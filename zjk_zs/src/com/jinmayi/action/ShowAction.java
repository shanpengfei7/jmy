package com.jinmayi.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Evaluate;
import com.jinmayi.entity.Packageinformation;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Sellinformation;
import com.jinmayi.service.CirculateService;
import com.jinmayi.service.EmployeeService;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.EvaluateService;
import com.jinmayi.service.PackageInformationService;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.SellInformationService;
import com.jinmayi.service.StatisticalService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ShowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private QrCodeService qrCodeService;
	@Resource
	private ProductService productService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private CirculateService circulateService;
	@Resource
	private EmployeeService employeeService;
	private String token;

	@Resource
	private StatisticalService statisticalService;

	@Resource
	private PackageInformationService packageInformationService;
	@Resource
	private SellInformationService sellInformationService;

	private Qrcode qrcode;
	private Product product;
	private Circulate circulate;
	private Employee employee;
	private Enterprise enterprise;
	private List<Qrcode> qrcodes = new ArrayList<Qrcode>();
	private List<Circulate> circulates;
	private Integer id;
	private String evaluate1;
	private String evaluate2;
	private String evaluate3;
	private String evaluate4;
	private Integer evaluate1Count = 0;
	private Integer evaluate2Count = 0;
	private Integer evaluate3Count = 0;
	private Integer evaluate4Count = 0;
	private String phonenumber;
	private String error;
	private Integer productid;
	private Integer qrcodeid;

	private List<Packageinformation> packageinformations;
	private Sellinformation sellinformation;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		// 得到二维码的基本信息
		qrcode = qrCodeService.getQrCodeByQrCode(token);
		if(qrcode == null) {
			return SUCCESS;
		}
		// 得到二维码的完整信息
		qrcode = qrCodeService.getQrCodeByQrCode(qrcode);

		packageinformations = packageInformationService.getPackageinformationByQrcodeid(qrcode.getId());
		for (Packageinformation p : packageinformations) {
			Employee e = employeeService.getEmployeeById(p.getEmployeeid());
			p.setEmployee(e);
			List<Qrcode> sons = qrCodeService.getQrcodesByParentId(qrcode.getId());
			Product pr = productService.getProductById(sons.get(0).getProductid());
			sons.get(0).setProduct(pr);
			qrcode.setSon(sons.get(0));
		}
		if (qrcode.getIssell() == 1) {
			sellinformation = sellInformationService.getSellinformationsByQrcodeid(qrcode.getId());
			Employee em = employeeService.getEmployeeById(sellinformation.getEmployeeid());
			sellinformation.setEmployee(em);
			Enterprise en = enterpriseService.getEnterpriseById(sellinformation.getEnterpriseid());
			sellinformation.setEnterprise(en);
		}

		// 扫码+1
		qrCodeService.updateScanCountAddOne(qrcode.getId());
		statisticalService.updateScannumber();
		enterpriseService.updateScannumber(qrcode.getEnterpriseid());

		Qrcode q = qrcode;
		while (q.getHasson() == 1) {
			q = qrCodeService.getQrcodesByParentId(q.getId()).get(0);
		}

		product = productService.getProductById(q.getProductid());
		evaluates = evaluateService.getEvaluatesByProductId(product.getId());
		if (evaluates != null) {
			for (Evaluate e : evaluates) {
				try {
					if (e.getEvaluate1().equals("是")) {
						evaluate1Count++;
					}
				} catch (Exception ex) {

				}
				try {
					if (e.getEvaluate2().equals("是")) {
						evaluate2Count++;
					}
				} catch (Exception ex) {

				}
				try {
					if (e.getEvaluate3().equals("是")) {
						evaluate3Count++;
					}
				} catch (Exception ex) {

				}
				try {
					if (e.getEvaluate4().equals("是")) {
						evaluate4Count++;
					}
				} catch (Exception ex) {

				}
			}
		}

		circulates = circulateService.getCirculateByQrCodeId(qrcode.getId());
		if (circulates != null) {
			for (Circulate c : circulates) {
				if (c.getDeliveremployeeid() != null)
					c.setDeliveremployee(employeeService.getEmployeeById(c.getDeliveremployeeid()));
				if (c.getReceiveemployeeid() != null)
					c.setReceiveemployee(employeeService.getEmployeeById(c.getReceiveemployeeid()));
				if (c.getReceiveenterpriseid() != null)
					c.setReceiveenterprise(enterpriseService.getEnterpriseById(c.getReceiveenterpriseid()));
			}
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String shows() throws Exception {
		// 得到二维码的基本信息
		qrcode = qrCodeService.getQrCodeByQrCode(token);
		if(qrcode == null) {
			return SUCCESS;
		}
		// 得到二维码的完整信息
		qrcode = qrCodeService.getQrCodeByQrCode(qrcode);

		packageinformations = packageInformationService.getPackageinformationByQrcodeid(qrcode.getId());
		for (Packageinformation p : packageinformations) {
			Employee e = employeeService.getEmployeeById(p.getEmployeeid());
			p.setEmployee(e);
		}
		if (qrcode.getIssell() == 1) {
			sellinformation = sellInformationService.getSellinformationsByQrcodeid(qrcode.getId());
			Employee em = employeeService.getEmployeeById(sellinformation.getEmployeeid());
			sellinformation.setEmployee(em);
			Enterprise en = enterpriseService.getEnterpriseById(sellinformation.getEmployeeid());
			sellinformation.setEnterprise(en);
		}

		Qrcode q = qrcode;
		while (q.getHasson() == 1) {
			q = qrCodeService.getQrcodesByParentId(q.getId()).get(0);
		}

		product = productService.getProductById(q.getProductid());

		// product = productService.getProductById(qrcode.getProductid());
		//
		// List<Product> products =
		// productService.getProductByEnidAndProcode(qrcode.getEnterpriseid(),
		// product.getProcode());
		// evaluates = evaluateService.getEvaluatesByProducts(products);
		evaluates = evaluateService.getEvaluatesByProductId(product.getId());
		if (evaluates != null) {
			for (Evaluate e : evaluates) {
				try {
					if (e.getEvaluate1().equals("是")) {
						evaluate1Count++;
					}
				} catch (Exception ex) {

				}
				try {
					if (e.getEvaluate2().equals("是")) {
						evaluate2Count++;
					}
				} catch (Exception ex) {

				}
				try {
					if (e.getEvaluate3().equals("是")) {
						evaluate3Count++;
					}
				} catch (Exception ex) {

				}
				try {
					if (e.getEvaluate4().equals("是")) {
						evaluate4Count++;
					}
				} catch (Exception ex) {

				}

			}
		}

		circulates = circulateService.getCirculateByQrCodeId(qrcode.getId());
		if (circulates != null) {
			for (Circulate c : circulates) {
				if (c.getDeliveremployeeid() != null)
					c.setDeliveremployee(employeeService.getEmployeeById(c.getDeliveremployeeid()));
				if (c.getReceiveemployeeid() != null)
					c.setReceiveemployee(employeeService.getEmployeeById(c.getReceiveemployeeid()));
				if (c.getReceiveenterpriseid() != null)
					c.setReceiveenterprise(enterpriseService.getEnterpriseById(c.getReceiveenterpriseid()));
			}
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String evaluate() throws Exception {
		Evaluate e = new Evaluate();
		e.setEvaluate1(evaluate1);
		e.setEvaluate2(evaluate2);
		e.setEvaluate3(evaluate3);
		e.setEvaluate4(evaluate4);
		e.setPhonenumber(phonenumber);

		Qrcode q = qrCodeService.getQrCodeById(qrcodeid);
		if (q.getIsevaluate() == 1) {
			error = "error, the product has been evaluated!";
			return SUCCESS;
		} else {
			while (q.getHasson() == 1) {
				q = qrCodeService.getQrcodesByParentId(q.getParentid()).get(0);
			}
			e.setProductid(q.getProductid());
			Integer result = evaluateService.save(e);
			result += qrCodeService.sellEvaluate(qrcodeid);
			if (result > 0) {
				return SUCCESS;
			} else {
				error = "评价失败！";
				return SUCCESS;
			}
		}
	}

	@Resource
	private EvaluateService evaluateService;
	private List<Evaluate> evaluates;

	public List<Evaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public Integer getQrcodeid() {
		return qrcodeid;
	}

	public void setQrcodeid(Integer qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Circulate getCirculate() {
		return circulate;
	}

	public void setCirculate(Circulate circulate) {
		this.circulate = circulate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<Qrcode> getQrcodes() {
		return qrcodes;
	}

	public void setQrcodes(List<Qrcode> qrcodes) {
		this.qrcodes = qrcodes;
	}

	public List<Circulate> getCirculates() {
		return circulates;
	}

	public void setCirculates(List<Circulate> circulates) {
		this.circulates = circulates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEvaluate1() {
		return evaluate1;
	}

	public void setEvaluate1(String evaluate1) {
		this.evaluate1 = evaluate1;
	}

	public String getEvaluate2() {
		return evaluate2;
	}

	public void setEvaluate2(String evaluate2) {
		this.evaluate2 = evaluate2;
	}

	public String getEvaluate3() {
		return evaluate3;
	}

	public void setEvaluate3(String evaluate3) {
		this.evaluate3 = evaluate3;
	}

	public String getEvaluate4() {
		return evaluate4;
	}

	public void setEvaluate4(String evaluate4) {
		this.evaluate4 = evaluate4;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getEvaluate1Count() {
		return evaluate1Count;
	}

	public void setEvaluate1Count(Integer evaluate1Count) {
		this.evaluate1Count = evaluate1Count;
	}

	public Integer getEvaluate2Count() {
		return evaluate2Count;
	}

	public void setEvaluate2Count(Integer evaluate2Count) {
		this.evaluate2Count = evaluate2Count;
	}

	public Integer getEvaluate3Count() {
		return evaluate3Count;
	}

	public void setEvaluate3Count(Integer evaluate3Count) {
		this.evaluate3Count = evaluate3Count;
	}

	public Integer getEvaluate4Count() {
		return evaluate4Count;
	}

	public void setEvaluate4Count(Integer evaluate4Count) {
		this.evaluate4Count = evaluate4Count;
	}

	public List<Packageinformation> getPackageinformations() {
		return packageinformations;
	}

	public void setPackageinformations(List<Packageinformation> packageinformations) {
		this.packageinformations = packageinformations;
	}

	public Sellinformation getSellinformation() {
		return sellinformation;
	}

	public void setSellinformation(Sellinformation sellinformation) {
		this.sellinformation = sellinformation;
	}

}
