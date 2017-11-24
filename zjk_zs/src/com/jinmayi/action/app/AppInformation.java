package com.jinmayi.action.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Packageinformation;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Sellinformation;
import com.jinmayi.entity.Waybill;
import com.jinmayi.service.CirculateService;
import com.jinmayi.service.EmployeeService;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.PackageInformationService;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.SellInformationService;
import com.jinmayi.service.WayBillService;
import com.jinmayi.util.TimeChange;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 手机端查看信息
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class AppInformation extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 查看销售信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sell() throws Exception {
		if (packagetime == null || packagetime.equals("")) {
			this.setPackagetime(TimeChange.getToday());
		}
		sellinformations = sellInformationService.getSellinformationsByEmid(employeeid, packagetime);
		if (sellinformations != null && sellinformations.size() > 0) {
			for (Sellinformation s : sellinformations) {
				Qrcode q = qrCodeService.getQrCodeById(s.getQrcodeid());

				Product p = productService.getProductById(q.getProductid());
				q.setProduct(p);
				s.setQrcode(q);

				Employee em = employeeService.getEmployeeById(s.getEmployeeid());
				s.setEmployee(em);
				Enterprise en = enterpriseService.getEnterpriseById(s.getEnterpriseid());
				s.setEnterprise(en);
				q.setSellinformation(s);
			}
		}
		return SUCCESS;
	}

	/**
	 * 查看打包信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String packagelist() throws Exception {
		if (packagetime == null || packagetime.equals("")) {
			this.setPackagetime(TimeChange.getToday());
		}
		packageinformations = packageInformationService.getPackageinformationByEmIdAndDate(employeeid, packagetime);
		try {
			if (packageinformations.size() > 0) {
				for (Packageinformation pi : packageinformations) {
					Qrcode q = qrCodeService.getQrCodeById(pi.getQrcodeid());
					Product p = productService.getProductById(q.getProductid());
					q.setProduct(p);
					List<Qrcode> qs = qrCodeService.getQrcodesByParentId(q.getId());
					if (qs != null && qs.size() > 0) {
						Product sonProduct = productService.getProductById(qs.get(0).getProductid());
						qs.get(0).setProduct(sonProduct);
						q.setSon(qs.get(0));
					}
					if (countMap.containsKey(q.getProduct().getTradename())) {
						countMap.put(q.getProduct().getTradename(), countMap.get(q.getProduct().getTradename()) + 1);
					} else {
						countMap.put(q.getProduct().getTradename(), 1);
					}
					pi.setQrcode(q);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 查看发货信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delist() throws Exception {
		// 如果pageNow当前页面为空，则设为0
		if (pageNow == null) {
			pageNow = 0;
		}
		// 如果pageSize一页显示多少条信息为空，则显示10条
		if (pageSize == null) {
			pageSize = 10;
		}
		if (packagetime == null || packagetime.equals("")) {
			this.setPackagetime(TimeChange.getToday());
		}
		rowCount = wayBillService.getWaybillsCountByDeEmId(employeeid, packagetime);
		if (rowCount > 0) {
			waybills = wayBillService.getWaybillsByDeEmId(employeeid, pageNow, pageSize, packagetime);
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
		return SUCCESS;
	}

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
	 * 查看收货信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String relist() throws Exception {
		// 如果pageNow当前页面为空，则设为0
		if (pageNow == null) {
			pageNow = 0;
		}
		// 如果pageSize一页显示多少条信息为空，则显示10条
		if (pageSize == null) {
			pageSize = 10;
		}
		if (packagetime == null || packagetime.equals("")) {
			this.setPackagetime(TimeChange.getToday());
		}
		rowCount = wayBillService.getWaybillsCountByReEmId(employeeid, packagetime);
		if (rowCount > 0) {
			waybills = wayBillService.getWaybillsByReEmId(employeeid, pageNow, pageSize, packagetime);
			for (Waybill w : waybills) {
				Employee em = employeeService.getEmployeeById(w.getReceiveemployeeid());
				w.setReceiveemployee(em);
				Enterprise en = enterpriseService.getEnterpriseById(w.getReceiveenterpriseid());
				w.setReceiveenterprise(en);
			}
		}
		return SUCCESS;
	}

	public String rlist() throws Exception {
		circulates = circulateService.getCirculatesByWaybillId(waybillid);
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
		return SUCCESS;
	}

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
		return SUCCESS;
	}

	@Resource
	private PackageInformationService packageInformationService;
	private List<Packageinformation> packageinformations;
	private String packagetime;
	private Integer employeeid;
	private Map<String, Integer> countMap = new HashMap<String, Integer>();
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
	@Resource
	private SellInformationService sellInformationService;
	private List<Circulate> circulates;
	private Integer did;
	private Integer rid;
	HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer pageNow;// 当前页
	private Integer pageSize;// 一页多少条
	private Integer rowCount;// 总条数
	private Integer pageCount;// 共多少页
	private List<Qrcode> qrcodes;
	private Integer enterpriseid;
	private List<Waybill> waybills;
	private Integer waybillid;
	private Integer qrcodeid;
	private List<Sellinformation> sellinformations;

	public List<Sellinformation> getSellinformations() {
		return sellinformations;
	}

	public void setSellinformations(List<Sellinformation> sellinformations) {
		this.sellinformations = sellinformations;
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

	public Map<String, Integer> getCountMap() {
		return countMap;
	}

	public void setCountMap(Map<String, Integer> countMap) {
		this.countMap = countMap;
	}

	public List<Packageinformation> getPackageinformations() {
		return packageinformations;
	}

	public void setPackageinformations(List<Packageinformation> packageinformations) {
		this.packageinformations = packageinformations;
	}

	public String getPackagetime() {
		return packagetime;
	}

	public void setPackagetime(String packagetime) {
		this.packagetime = packagetime;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

}
