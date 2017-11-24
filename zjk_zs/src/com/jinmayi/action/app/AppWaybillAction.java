package com.jinmayi.action.app;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Waybill;
import com.jinmayi.service.CirculateService;
import com.jinmayi.service.EmployeeService;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.WayBillService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 运单管理
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class AppWaybillAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JSONObject json = new JSONObject();

	/**
	 * 扫运单码
	 * 
	 * @throws Exception
	 */
	public void waybill() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Waybill w = wayBillService.getWaybillByNumbwer(token);

			if (w == null) {
				json.put("status", 0);
				json.put("message", "二维码不正确!");
				json.put("data", "");
			} else {
				json.put("status", 1);
				json.put("message", "扫码成功!");
				JSONObject j = new JSONObject();
				j.put("id", w.getId());

				j.put("url", "app-waybills.php");
				j.put("flag", 1);
				json.put("data", j);
			}

			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "扫码未成功！");
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

	/**
	 * 运单列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String waybills() throws Exception {
		waybill = wayBillService.getWaybillById(id);
		Employee em = employeeService.getEmployeeById(waybill.getDeliveremployeeid());
		waybill.setDeliveremployee(em);
		Enterprise en = enterpriseService.getEnterpriseById(waybill.getDeliverenterpriseid());
		waybill.setDeliverenterprise(en);
		Enterprise enw = enterpriseService.getEnterpriseById(waybill.getWillreceiveenterpriseid());
		waybill.setWillreceiveenterprise(enw);

		circulates = circulateService.getCirculatesByWaybillId(waybill.getId());
		if (circulates != null && circulates.size() > 0) {
			for (Circulate circulate : circulates) {
				Qrcode q = qrCodeService.getQrCodeById(circulate.getQrcodeid());
				Product p = productService.getProductById(q.getProductid());
				q.setProduct(p);

				if (countMap.containsKey(p.getTradename())) {
					countMap.put(p.getTradename(), countMap.get(p.getTradename()) + 1);
				} else {
					countMap.put(p.getTradename(), 1);
				}

				circulate.setQrcode(q);
			}
		}
		return SUCCESS;
	}

	private List<Circulate> circulates;
	private Waybill waybill;
	private Integer id;
	private Map<String, Integer> countMap = new HashMap<String, Integer>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, Integer> getCountMap() {
		return countMap;
	}

	public void setCountMap(Map<String, Integer> countMap) {
		this.countMap = countMap;
	}

	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private ProductService productService;
	@Resource
	private CirculateService circulateService;
	@Resource
	private WayBillService wayBillService;
	@Resource
	private QrCodeService qrCodeService;

	HttpServletRequest request;
	HttpServletResponse response;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
