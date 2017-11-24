package com.jinmayi.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Sellinformation;
import com.jinmayi.service.CirculateService;
import com.jinmayi.service.EmployeeService;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.SellInformationService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 流通信息，内含发货列表，收货列表和销售列表
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class CirculateAction extends ActionSupport {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 列出发货信息
	 * 
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
		rowCount = circulateService.getCirculateCountByDeEmId(eid);
		if (rowCount > 0) {
			circulates = circulateService.getCirculatesByDeEmId(eid, pageNow, pageSize);
			for (Circulate circulate : circulates) {
				Employee em = employeeService.getEmployeeById(circulate.getDeliveremployeeid());
				circulate.setDeliveremployee(em);
				Enterprise en = enterpriseService.getEnterpriseById(circulate.getDeliverenterpriseid());
				circulate.setDeliverenterprise(en);
				Qrcode q = qrCodeService.getQrCodeById(circulate.getQrcodeid());
				Product p = productService.getProductById(q.getProductid());
				q.setProduct(p);
				circulate.setQrcode(q);
			}
		}
		return SUCCESS;
	}

	/**
	 * 列出收货信息
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
			eid = rid;
		}
		rowCount = circulateService.getCirculateCountByReEmId(eid);
		if (rowCount > 0) {
			circulates = circulateService.getCirculatesByReEmId(eid, pageNow, pageSize);
			for (Circulate circulate : circulates) {
				Employee em = employeeService.getEmployeeById(circulate.getReceiveemployeeid());
				circulate.setReceiveemployee(em);
				Enterprise en = enterpriseService.getEnterpriseById(circulate.getReceiveenterpriseid());
				circulate.setReceiveenterprise(en);
				Qrcode q = qrCodeService.getQrCodeById(circulate.getQrcodeid());
				Product p = productService.getProductById(q.getProductid());
				q.setProduct(p);
				circulate.setQrcode(q);
			}
		}
		return SUCCESS;
	}

	/**
	 * 列出销售信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sell() throws Exception {
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
			eid = rid;
		}
		rowCount = sellInformationService.getSellinformationCountByEnid(eid);
		if (rowCount > 0) {
			sellinformations = sellInformationService.getSellinformationsByEnid(eid, pageNow, pageSize);
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

	@Resource
	private SellInformationService sellInformationService;
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

}
