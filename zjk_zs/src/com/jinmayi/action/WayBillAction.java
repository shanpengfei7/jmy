package com.jinmayi.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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
 * 发货单
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class WayBillAction extends ActionSupport implements ServletResponseAware {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	JSONObject json = new JSONObject();

	/**
	 * 打印发货单
	 * @return
	 * @throws Exception
	 */
	public void print() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Integer enid = null;
		Integer emid = null;
		printtime = System.currentTimeMillis();
		Waybill w = new Waybill();
		try {
			enid = Integer.parseInt(session.getAttribute("enterpriseId").toString());
			Enterprise enterprise = enterpriseService.getEnterpriseById(enid);
			printname = enterprise.getName();
			w.setPrintemployeeid(0);
			w.setPrintenterpriseid(enid);
			w.setPrinttime(printtime);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				emid = Integer.parseInt(session.getAttribute("employeeId").toString());
				Employee employee = employeeService.getEmployeeById(emid);
				printname = employee.getName();
				w.setPrintemployeeid(emid);
				w.setPrintenterpriseid(employee.getEnterpriseid());
				w.setPrinttime(printtime);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			wayBillService.printWaybill(w);
		}
		json.put("status", 1);
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 展示发货单
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		waybill = wayBillService.getWaybillById(waybillid);
		Employee em = employeeService.getEmployeeById(waybill.getDeliveremployeeid());
		waybill.setDeliveremployee(em);
		Enterprise en = enterpriseService.getEnterpriseById(waybill.getDeliverenterpriseid());
		waybill.setDeliverenterprise(en);
		Enterprise enw = enterpriseService.getEnterpriseById(waybill.getWillreceiveenterpriseid());
		waybill.setWillreceiveenterprise(enw);

		Integer enid = null;
		Integer emid = null;
		printtime = System.currentTimeMillis();
		try {
			enid = Integer.parseInt(session.getAttribute("enterpriseId").toString());
			Enterprise enterprise = enterpriseService.getEnterpriseById(enid);
			printname = enterprise.getName();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			emid = Integer.parseInt(session.getAttribute("employeeId").toString());
			Employee employee = employeeService.getEmployeeById(emid);
			printname = employee.getName();
		} catch (Exception e) {
			e.printStackTrace();
		}

		circulates = circulateService.getCirculatesByWaybillId(waybillid);
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

	/**
	 * 查看发货单下的货物
	 * @return
	 * @throws Exception
	 */
	public String delist() throws Exception {
		// 如果pageNow当前页面为空，则设为0
		if (pageNow == null) {
			pageNow = 1;
		}
		// 如果pageSize一页显示多少条信息为空，则显示10条
		if (pageSize == null) {
			pageSize = 10;
		}
		try {
			eid = Integer.parseInt(session.getAttribute("enterpriseId").toString());
		} catch (Exception e) {
			e.printStackTrace();
			eid = enterpriseid;
		}
		if (eid == null) {
			eid = did;
		}
		rowCount = wayBillService.getWaybillsCountByDeEnId(eid);
		if (rowCount > 0) {
			waybills = wayBillService.getWaybillsByDeEnId(eid, pageNow, pageSize);
			for (Waybill w : waybills) {
				Employee em = employeeService.getEmployeeById(w.getDeliveremployeeid());
				w.setDeliveremployee(em);
				Enterprise en = enterpriseService.getEnterpriseById(w.getDeliverenterpriseid());
				w.setDeliverenterprise(en);
				Enterprise wen = enterpriseService.getEnterpriseById(w.getWillreceiveenterpriseid());
				w.setWillreceiveenterprise(wen);
			}
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String dlist() throws Exception {
		circulates = circulateService.getCirculatesByWaybillId(waybillid);
		for (Circulate circulate : circulates) {
			Employee em = employeeService.getEmployeeById(circulate.getDeliveremployeeid());
			circulate.setDeliveremployee(em);
			Enterprise en = enterpriseService.getEnterpriseById(circulate.getDeliverenterpriseid());
			circulate.setDeliverenterprise(en);
			Qrcode q = qrCodeService.getQrCodeById(circulate.getQrcodeid());
			Product p = productService.getProductById(q.getProductid());
			q.setProduct(p);

			List<Qrcode> qs = qrCodeService.getQrcodesByParentId(q.getId());
			if (qs != null && qs.size() > 0) {
				Product sonProduct = productService.getProductById(qs.get(0).getProductid());
				qs.get(0).setProduct(sonProduct);
				q.setSon(qs.get(0));
			}

			circulate.setQrcode(q);
		}
		// }
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String dslist() throws Exception {
		List<Qrcode> qrcodes = qrCodeService.getQrcodesByParentId(qrcodeid);
		Integer[] ids = new Integer[qrcodes.size()];
		for (int i = 0; i < qrcodes.size(); i++) {
			ids[i] = qrcodes.get(i).getId();
		}
		try {
			if (ids.length > 0) {
				circulates = circulateService.getCirculatesByWaybillId(ids, waybillid);
			} else {
				circulates = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (circulates != null && circulates.size() > 0) {
			for (Circulate circulate : circulates) {
				Employee em = employeeService.getEmployeeById(circulate.getDeliveremployeeid());
				circulate.setDeliveremployee(em);
				Enterprise en = enterpriseService.getEnterpriseById(circulate.getDeliverenterpriseid());
				circulate.setDeliverenterprise(en);
				Qrcode q = qrCodeService.getQrCodeById(circulate.getQrcodeid());
				Product p = productService.getProductById(q.getProductid());
				q.setProduct(p);

				List<Qrcode> qs = qrCodeService.getQrcodesByParentId(q.getId());
				if (qs != null && qs.size() > 0) {
					Product sonProduct = productService.getProductById(qs.get(0).getProductid());
					qs.get(0).setProduct(sonProduct);
					q.setSon(qs.get(0));
				}

				circulate.setQrcode(q);
			}
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String relist() throws Exception {
		// 如果pageNow当前页面为空，则设为0
		if (pageNow == null) {
			pageNow = 1;
		}
		// 如果pageSize一页显示多少条信息为空，则显示10条
		if (pageSize == null) {
			pageSize = 10;
		}
		try {
			eid = Integer.parseInt(session.getAttribute("enterpriseId").toString());
		} catch (Exception e) {
			e.printStackTrace();
			eid = enterpriseid;
		}
		if (eid == null) {
			eid = did;
		}
		rowCount = wayBillService.getWaybillsCountByReEnId(eid);
		if (rowCount > 0) {
			waybills = wayBillService.getWaybillsByReEnId(eid, pageNow, pageSize);
			for (Waybill w : waybills) {
				Employee em = employeeService.getEmployeeById(w.getReceiveemployeeid());
				w.setReceiveemployee(em);
				Enterprise ren = enterpriseService.getEnterpriseById(w.getReceiveenterpriseid());
				w.setReceiveenterprise(ren);
				Enterprise den = enterpriseService.getEnterpriseById(w.getDeliverenterpriseid());
				w.setDeliverenterprise(den);
			}
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String rlist() throws Exception {
		circulates = circulateService.getCirculatesByWaybillId(waybillid);
		for (Circulate circulate : circulates) {
			Employee em = employeeService.getEmployeeById(circulate.getReceiveemployeeid());
			circulate.setReceiveemployee(em);
			Enterprise ren = enterpriseService.getEnterpriseById(circulate.getReceiveenterpriseid());
			circulate.setReceiveenterprise(ren);
			Qrcode q = qrCodeService.getQrCodeById(circulate.getQrcodeid());
			Product p = productService.getProductById(q.getProductid());
			q.setProduct(p);

			List<Qrcode> qs = qrCodeService.getQrcodesByParentId(q.getId());
			if (qs != null && qs.size() > 0) {
				Product sonProduct = productService.getProductById(qs.get(0).getProductid());
				qs.get(0).setProduct(sonProduct);
				q.setSon(qs.get(0));
			}
			circulate.setQrcode(q);
		}
		// }
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String rslist() throws Exception {
		List<Qrcode> qrcodes = qrCodeService.getQrcodesByParentId(qrcodeid);
		Integer[] ids = new Integer[qrcodes.size()];
		for (int i = 0; i < qrcodes.size(); i++) {
			ids[i] = qrcodes.get(i).getId();
		}
		try {
			if (ids.length > 0) {
				circulates = circulateService.getCirculatesByWaybillId(ids, waybillid);
			} else {
				circulates = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (circulates != null && circulates.size() > 0) {
			for (Circulate circulate : circulates) {
				Employee em = employeeService.getEmployeeById(circulate.getReceiveemployeeid());
				circulate.setReceiveemployee(em);
				Enterprise en = enterpriseService.getEnterpriseById(circulate.getReceiveenterpriseid());
				circulate.setReceiveenterprise(en);
				Qrcode q = qrCodeService.getQrCodeById(circulate.getQrcodeid());
				Product p = productService.getProductById(q.getProductid());
				q.setProduct(p);

				List<Qrcode> qs = qrCodeService.getQrcodesByParentId(q.getId());
				if (qs != null && qs.size() > 0) {
					Product sonProduct = productService.getProductById(qs.get(0).getProductid());
					qs.get(0).setProduct(sonProduct);
					q.setSon(qs.get(0));
				}

				circulate.setQrcode(q);
			}
		}
		// }
		return SUCCESS;
	}


	@Resource
	private CirculateService circulateService;
	@Resource
	private QrCodeService qrCodeService;
	@Resource
	private ProductService productService;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private WayBillService wayBillService;

	private List<Circulate> circulates;
	private Integer did;
	private Integer rid;
	HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer eid = null;// 企业的id
	private Integer pageNow;// 当前页
	private Integer pageSize;// 一页多少条
	private Integer rowCount;// 总条数
	private Integer pageCount;// 共多少页
	private List<Qrcode> qrcodes;
	private Integer enterpriseid;
	private List<Waybill> waybills;
	private Integer waybillid;
	private Integer qrcodeid;
	private Waybill waybill;
	private Long printtime;
	private String printname;

	public Long getPrinttime() {
		return printtime;
	}

	public void setPrinttime(Long printtime) {
		this.printtime = printtime;
	}

	public String getPrintname() {
		return printname;
	}

	public void setPrintname(String printname) {
		this.printname = printname;
	}

	private Map<String, Integer> countMap = new HashMap<String, Integer>();

	public Map<String, Integer> getCountMap() {
		return countMap;
	}

	public void setCountMap(Map<String, Integer> countMap) {
		this.countMap = countMap;
	}

	public Waybill getWaybill() {
		return waybill;
	}

	public void setWaybill(Waybill waybill) {
		this.waybill = waybill;
	}

	public List<Circulate> getCirculates() {
		return circulates;
	}

	public void setCirculates(List<Circulate> circulates) {
		this.circulates = circulates;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageCount() {
		pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<Qrcode> getQrcodes() {
		return qrcodes;
	}

	public void setQrcodes(List<Qrcode> qrcodes) {
		this.qrcodes = qrcodes;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public List<Waybill> getWaybills() {
		return waybills;
	}

	public void setWaybills(List<Waybill> waybills) {
		this.waybills = waybills;
	}

	public Integer getWaybillid() {
		return waybillid;
	}

	public void setWaybillid(Integer waybillid) {
		this.waybillid = waybillid;
	}

	public Integer getQrcodeid() {
		return qrcodeid;
	}

	public void setQrcodeid(Integer qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

	private HttpServletResponse response;

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

}
