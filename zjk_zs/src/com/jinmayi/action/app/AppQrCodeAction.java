package com.jinmayi.action.app;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Repertory;
import com.jinmayi.service.CirculateService;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.RepertoryService;
import com.jinmayi.service.StatisticalService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 扫码确认
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class AppQrCodeAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JSONObject json = new JSONObject();

	/**
	 * 码中转，内部扫描，不增加次数
	 * 
	 * @throws Exception
	 */
	public void in() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是系统的码!");
				json.put("data", "");
			} else {
				json.put("status", 1);
				json.put("message", "扫码成功!");
				JSONObject j = new JSONObject();
				j.put("url", "shows.php?token=" + token);
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
	 * 通用接口，弃用
	 * 
	 * @throws Exception
	 */
	public void qrcode() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是包装或产品的码!");
				json.put("data", "");
			} else {
				json.put("status", 1);
				json.put("message", "扫码成功!");
				JSONObject j = new JSONObject();
				j.put("id", q.getId());
				j.put("empty", q.getHasson());
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
	 * 包装时扫描父包
	 * 
	 * @throws Exception
	 */
	public void parent() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是包装的码!");
				json.put("data", "");
			} else if (enterpriseid != q.getEnterpriseid() || !q.getEnterpriseid().equals(enterpriseid)) {
				json.put("status", 0);
				json.put("message", "该产品不是贵企业的产品!");
				json.put("data", "");
			} else if (q.getHasparent() == 1) {
				json.put("status", 0);
				json.put("message", "该产品已装箱!");
				json.put("data", "");
			} else if (q.getHasson() == 1) {
				json.put("status", 0);
				json.put("message", "该包装已经装入产品!");
				json.put("data", "");
			} else {
				Product p = productService.getProductById(q.getProductid());
				if (p == null) {
					json.put("status", 0);
					json.put("message", "二维码不是包装的码!");
					json.put("data", "");
				} else if (p.getIspackage() == 0) {
					json.put("status", 0);
					json.put("message", "这是一个产品!");
					json.put("data", "");
					// } else if (q.getIsuse() == 1) {
					// json.put("status", 0);
					// json.put("message", "该产品已装箱!");
					// json.put("data", "");
				} else {
					json.put("status", 1);
					json.put("message", "扫码成功!");
					JSONObject j = new JSONObject();
					j.put("id", q.getId());
					j.put("name", p.getTradename());
					j.put("pid", p.getId());
					json.put("data", j);
				}
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

	public void unqrcode() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是包装的码!");
				json.put("data", "");
			} else if (enterpriseid != q.getEnterpriseid() || !q.getEnterpriseid().equals(enterpriseid)) {
				json.put("status", 0);
				json.put("message", "该产品不是贵企业的产品!");
				json.put("data", "");
			} else {
				Product p = productService.getProductById(q.getProductid());
				if (p == null) {
					json.put("status", 0);
					json.put("message", "二维码不是包装的码!");
					json.put("data", "");
				} else if (p.getIspackage() == 0) {
					json.put("status", 0);
					json.put("message", "这是一个产品!");
					json.put("data", "");
				} else if (q.getIsuse() == 0) {
					json.put("status", 0);
					json.put("message", "该产品未装箱!");
					json.put("data", "");
				} else {
					json.put("status", 1);
					json.put("message", "扫码成功!");
					JSONObject j = new JSONObject();
					j.put("id", q.getId());
					j.put("name", p.getTradename());
					j.put("pid", p.getId());
					json.put("data", j);
				}
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
	 * 包装时扫描子包
	 * 
	 * @throws Exception
	 */
	public void son() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是产品的码!");
				json.put("data", "");
			} else if (enterpriseid != q.getEnterpriseid() || !q.getEnterpriseid().equals(enterpriseid)) {
				json.put("status", 0);
				json.put("message", "该产品不是贵企业的产品!");
				json.put("data", "");
			} else {
				Qrcode parent = qrCodeService.getQrCodeById(parentid);
				if (parent == null) {
					json.put("status", 0);
					json.put("message", "二维码不是产品的码!");
					json.put("data", "");
				} else if (q.getProductid() == parent.getProductid()
						|| q.getProductid().equals(parent.getProductid())) {
					json.put("status", 0);
					json.put("message", "二维码和外包装是同一物品!");
					json.put("data", "");
				} else if (q.getHasparent() == 1) {
					json.put("status", 0);
					json.put("message", "该产品已装箱!");
					json.put("data", "");
				} else {
					Product p = productService.getProductById(q.getProductid());
					json.put("status", 1);
					json.put("message", "扫码成功!");
					JSONObject j = new JSONObject();
					j.put("id", q.getId());
					j.put("name", p.getTradename());
					j.put("pid", p.getId());
					json.put("data", j);
				}
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
	 * 发货时扫描
	 * 
	 * @throws Exception
	 */
	public void decode() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是货物的码!");
				json.put("data", "");
			} else if (circulateService.isDeliver(enterpriseid, q.getId())) {
				json.put("status", 0);
				json.put("message", "该货物已被发货!");
				json.put("data", "");
			} else {
				Product p = productService.getProductById(q.getProductid());
				if (p == null) {
					json.put("status", 0);
					json.put("message", "二维码不是产品的码!");
					json.put("data", "");
				} else {
					List<Repertory> r = repertoryService.getRepertoriesByQrCodeId(q.getId());
					if (r == null) {
						json.put("status", 0);
						json.put("message", "这个产品不是该企业的!");
						json.put("data", "");

					} else if (r.get(0).getEnterpriseid() != enterpriseid
							|| !r.get(0).getEnterpriseid().equals(enterpriseid)) {

						json.put("status", 0);
						json.put("message", "这个产品不是该企业的!");
						json.put("data", "");
					} else {
						json.put("status", 1);
						json.put("message", "扫码成功!");
						JSONObject j = new JSONObject();
						j.put("id", q.getId());
						j.put("name", p.getTradename());
						j.put("pid", p.getId());
						json.put("data", j);
					}
				}
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
	 * 货物收货时扫描
	 * 
	 * @throws Exception
	 */
	public void recode() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是货物的码!");
				json.put("data", "");
			} else if (circulateService.isReceive(enterpriseid, q.getId())) {
				json.put("status", 0);
				json.put("message", "该货物已收货!");
				json.put("data", "");
			} else {
				Product p = productService.getProductById(q.getProductid());
				if (p == null) {
					json.put("status", 0);
					json.put("message", "二维码不是产品的码!");
					json.put("data", "");
				} else {
					List<Circulate> cs = circulateService.getCirculateByQrCodeId(q.getId());
					if (cs == null) {
						json.put("status", 0);
						json.put("message", "这个产品不是该企业的!");
						json.put("data", "");
					} else if (cs.get(cs.size() - 1).getWillreceiveenterpriseid() != enterpriseid
							|| !cs.get(cs.size() - 1).getWillreceiveenterpriseid().equals(enterpriseid)) {
						json.put("status", 0);
						json.put("message", "这个产品不是该企业的!");
						json.put("data", "");
					} else {
						json.put("status", 1);
						json.put("message", "扫码成功!");
						JSONObject j = new JSONObject();
						j.put("id", q.getId());
						j.put("name", p.getTradename());
						j.put("pid", p.getId());
						j.put("flag", 0);
						json.put("data", j);
					}
				}
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
	 * 销售时扫描
	 * 
	 * @throws Exception
	 */
	public void secode() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Qrcode q = qrCodeService.getQrCodeByQrCode(token);

			if (q == null) {
				json.put("status", 0);
				json.put("message", "二维码不是货物的码!");
				json.put("data", "");
			} else {
				if (q.getIssell() == 1) {
					json.put("status", 0);
					json.put("message", "该货物已被销售!");
					json.put("data", "");

				} else {
					List<Repertory> r = repertoryService.getRepertoriesByQrCodeId(q.getId());
					if (r == null) {
						json.put("status", 0);
						json.put("message", "这个产品不是该企业的!");
						json.put("data", "");

					} else if (r.get(0).getEnterpriseid() != enterpriseid
							|| !r.get(0).getEnterpriseid().equals(enterpriseid)) {

						json.put("status", 0);
						json.put("message", "这个产品不是该企业的!");
						json.put("data", "");
					} else {
						Product p = productService.getProductById(q.getProductid());
						json.put("status", 1);
						json.put("message", "扫码成功!");
						JSONObject j = new JSONObject();
						j.put("id", q.getId());
						j.put("name", p.getTradename());
						j.put("pid", p.getId());
						json.put("data", j);
					}
				}
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
	 * 打包
	 * 
	 * @throws Exception
	 */
	public void packaged() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			List<Integer> sonidsInt = new ArrayList<Integer>();
			String[] sonidsString = sonids.split(",");
			for (int i = 1; i < sonidsString.length; i++) {
				sonidsInt.add(Integer.parseInt(sonidsString[i]));
			}

			Integer status = 0;
			try {
				// 打包
				status = qrCodeService.packageQrCode(enterpriseid, employeeid, sonidsInt, parentid, soncount, place);
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status", 0);
				json.put("message", "打包未成功,该包装不能包装这些产品！");
				json.put("data", "");
				out.print(json);
				out.flush();
				out.close();
				throw e;
			}

			if (status > 0) {

				json.put("status", 1);
				json.put("message", "打包成功!");
				json.put("data", "");
			} else {
				json.put("status", 0);
				json.put("message", "打包未成功");
				json.put("data", "");
			}

			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "打包未成功！");
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

	public void unpackage() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			List<Integer> parentidsInt = new ArrayList<Integer>();
			String[] parentidsString = parentids.split(",");
			for (int i = 1; i < parentidsString.length; i++) {
				parentidsInt.add(Integer.parseInt(parentidsString[i]));
			}

			Integer status = 0;
			try {
				// 拆包
				status = qrCodeService.packageUnQrCode(enterpriseid, employeeid, parentidsInt, place);
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status", 0);
				json.put("message", "拆包未成功！");
				json.put("data", "");
				out.print(json);
				out.flush();
				out.close();
				throw e;
			}

			if (status > 0) {
				// statisticalService.updateUnUserCountDelete(sonidsString.length);
				json.put("status", 1);
				json.put("message", "拆包成功!");
				json.put("data", "");
			} else {
				json.put("status", 0);
				json.put("message", "拆包未成功");
				json.put("data", "");
			}

			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "拆包未成功！");
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
	 * 销售
	 * 
	 * @throws Exception
	 */
	public void sell() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String[] qrcodeidString = qrcodeid.split(",");
			List<Qrcode> qrcodes = new ArrayList<Qrcode>();
			for (int i = 1; i < qrcodeidString.length; i++) {
				Qrcode qrcode = qrCodeService.getQrCodeById(Integer.parseInt(qrcodeidString[i]));
				qrcodes.add(qrcode);
			}

			try {
				// 销售
				qrCodeService.sellQrCode(qrcodes, enterpriseid, employeeid, sellplace);
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status", 0);
				json.put("message", "销售未成功,有的产品已销售！");
				json.put("data", "");
				out.print(json);
				out.flush();
				out.close();
				throw e;
			}

			json.put("status", 1);
			json.put("message", "销售成功！");
			json.put("data", "");
			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "销售未成功！");
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
	private StatisticalService statisticalService;
	@Resource
	private QrCodeService qrCodeService;
	@Resource
	private ProductService productService;
	@Resource
	private CirculateService circulateService;
	@Resource
	private RepertoryService repertoryService;
	HttpServletRequest request;
	private HttpServletResponse response;
	private Qrcode qrcode;
	private String token;
	private Integer enterpriseid;
	private Integer employeeid;
	private Integer parentid;
	private Integer sonid;
	private String sonids;
	private String parentids;
	private Integer soncount;
	private String sellplace;
	private List<Integer> test;
	private String qrcodeid;
	private List<Qrcode> qrcodes;
	private String packagetime;
	private String place;

	public List<Integer> getTest() {
		return test;
	}

	public void setTest(List<Integer> test) {
		this.test = test;
	}

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

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getSonid() {
		return sonid;
	}

	public void setSonid(Integer sonid) {
		this.sonid = sonid;
	}

	public String getSonids() {
		return sonids;
	}

	public void setSonids(String sonids) {
		this.sonids = sonids;
	}

	public String getParentids() {
		return parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids;
	}

	public Integer getSoncount() {
		return soncount;
	}

	public void setSoncount(Integer soncount) {
		this.soncount = soncount;
	}

	public String getSellplace() {
		return sellplace;
	}

	public void setSellplace(String sellplace) {
		this.sellplace = sellplace;
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

	public List<Qrcode> getQrcodes() {
		return qrcodes;
	}

	public void setQrcodes(List<Qrcode> qrcodes) {
		this.qrcodes = qrcodes;
	}

	public String getPackagetime() {
		return packagetime;
	}

	public void setPackagetime(String packagetime) {
		this.packagetime = packagetime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
