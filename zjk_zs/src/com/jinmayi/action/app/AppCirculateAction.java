package com.jinmayi.action.app;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Waybill;
import com.jinmayi.service.CirculateService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.RepertoryService;
import com.jinmayi.service.WayBillService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * app端流通管理，扫码发货和扫码收货
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class AppCirculateAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JSONObject json = new JSONObject();

	/**
	 * yundan shengcheng 运单生成，发货
	 * 
	 * @throws Exception
	 */
	public void deliver() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			// 运单
			Waybill w = new Waybill();
			w.setQrcode("");
			w.setNumber(UUID.randomUUID().toString().replaceAll("-", ""));
			w.setReceiveplace(receiveplace);
			w.setReceivephonenumber(receivephonenumber);
			w.setReceiveemployeename(receiveemployeename);
			w.setReceiveenterprisename(receiveenterprisename);
			w.setWillreceiveenterpriseid(willreceiveenterpriseid);
			Long time = System.currentTimeMillis();
			w.setDelivertime(time);
			Short s0 = 0;
			w.setIsdelete(s0);
			w.setDeliveremployeeid(deliveremployeeid);
			w.setDeliverenterpriseid(deliverenterpriseid);
			w.setIsreceive(s0);
			w.setDeliverplace(deliverplace);
			Integer wayBillId = wayBillService.saveWayBill(w);

			// 返回的运单信息
			JSONObject j = new JSONObject();
			j.put("number", w.getNumber());
			// 保存了运单信息后，保存发货信息
			if (wayBillId != null && wayBillId > 0) {
				String[] qrcodeidString = qrcodeid.split(",");
				// 通过掊口拿到的发货的id拿到对应的二维码信息
				for (int i = 1; i < qrcodeidString.length; i++) {
					Qrcode qrcode = qrCodeService.getQrCodeById(Integer.parseInt(qrcodeidString[i]));
					qrcodes.add(qrcode);
				}
				try {
					// 发货
					circulateService.newGood(wayBillId, qrcodes, time, deliverenterpriseid, deliveremployeeid,
							deliverplace, willreceiveenterpriseid);
				} catch (Exception e) {
					e.printStackTrace();
					w.setId(wayBillId);
					wayBillService.deleteWayBill(w);
					json.put("status", 0);
					json.put("message", "发货未成功,有的货物已经发货！");
					json.put("data", "");
					out.print(json);
					out.flush();
					out.close();
					throw e;
				}
			}

			json.put("status", 1);
			json.put("message", "发货成功！");
			json.put("data", j);
			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "发货未成功！");
			json.put("data", "");
			out.print(json);
			out.flush();
			out.close();
			throw ex;
		} finally {
			out.flush();
			out.close();
		}
	}

	private List<Qrcode> qrcodes = new ArrayList<Qrcode>();

	/**
	 * 收货
	 * 
	 * @throws Exception
	 */
	public void receive() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String[] qrcodeidString = qrcodeid.split(",");
			Long time = System.currentTimeMillis();
			List<Integer> integers = new ArrayList<Integer>();
			for (int i = 1; i < qrcodeidString.length; i++) {
				integers.add(Integer.parseInt(qrcodeidString[i]));
			}

			try {
				circulateService.updateGood(integers, time, flag, receiveenterpriseid, receiveemployeeid, receiveplace);
			} catch (Exception e) {
				json.put("status", 0);
				json.put("message", "收货未成功，该单位不能收这批货物,或者已收货！");
				json.put("data", "");
				out.print(json);
				out.flush();
				out.close();
				throw e;
			}
			json.put("status", 1);
			json.put("message", "收货成功！");
			json.put("data", "");
			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "收货未成功！");
			json.put("data", "");
			out.print(json);
			out.flush();
			out.close();
			throw ex;
		} finally {
			out.flush();
			out.close();
		}
	}

	@Resource
	private QrCodeService qrCodeService;
	@Resource
	private CirculateService circulateService;
	@Resource
	private WayBillService wayBillService;
	@Resource
	private RepertoryService repertoryService;

	HttpServletRequest request;
	private HttpServletResponse response;
	private Qrcode qrcode;
	private String token;
	private Integer deliveremployeeid;
	private String deliverplace;
	private Integer receiveemployeeid;
	private Integer receiveenterpriseid;
	private String receiveplace;
	private String qrcodeid;
	private Integer deliverenterpriseid;
	private String receiveemployeename;
	private String receiveenterprisename;
	private String receivephonenumber;
	private Integer willreceiveenterpriseid;
	private Integer flag;

	public Qrcode getQrcode() {
		return qrcode;
	}

	public void setQrcode(Qrcode qrcode) {
		this.qrcode = qrcode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getDeliveremployeeid() {
		return deliveremployeeid;
	}

	public void setDeliveremployeeid(Integer deliveremployeeid) {
		this.deliveremployeeid = deliveremployeeid;
	}

	public String getDeliverplace() {
		return deliverplace;
	}

	public void setDeliverplace(String deliverplace) {
		this.deliverplace = deliverplace;
	}

	public Integer getReceiveemployeeid() {
		return receiveemployeeid;
	}

	public void setReceiveemployeeid(Integer receiveemployeeid) {
		this.receiveemployeeid = receiveemployeeid;
	}

	public Integer getReceiveenterpriseid() {
		return receiveenterpriseid;
	}

	public void setReceiveenterpriseid(Integer receiveenterpriseid) {
		this.receiveenterpriseid = receiveenterpriseid;
	}

	public String getReceiveplace() {
		return receiveplace;
	}

	public void setReceiveplace(String receiveplace) {
		this.receiveplace = receiveplace;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getQrcodeid() {
		return qrcodeid;
	}

	public void setQrcodeid(String qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

	public Integer getDeliverenterpriseid() {
		return deliverenterpriseid;
	}

	public void setDeliverenterpriseid(Integer deliverenterpriseid) {
		this.deliverenterpriseid = deliverenterpriseid;
	}

	public String getReceiveemployeename() {
		return receiveemployeename;
	}

	public void setReceiveemployeename(String receiveemployeename) {
		this.receiveemployeename = receiveemployeename;
	}

	public String getReceiveenterprisename() {
		return receiveenterprisename;
	}

	public void setReceiveenterprisename(String receiveenterprisename) {
		this.receiveenterprisename = receiveenterprisename;
	}

	public String getReceivephonenumber() {
		return receivephonenumber;
	}

	public void setReceivephonenumber(String receivephonenumber) {
		this.receivephonenumber = receivephonenumber;
	}

	public Integer getWillreceiveenterpriseid() {
		return willreceiveenterpriseid;
	}

	public void setWillreceiveenterpriseid(Integer willreceiveenterpriseid) {
		this.willreceiveenterpriseid = willreceiveenterpriseid;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
