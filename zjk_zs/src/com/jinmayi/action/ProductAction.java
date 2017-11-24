package com.jinmayi.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Product;
import com.jinmayi.service.VersionService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 产品下线
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class ProductAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer eid = null;// 企业的id

	private Integer getEid() {
		try {
			eid = Integer.parseInt(session.getAttribute("enterpriseId").toString());
		} catch (Exception e) {
			try {
				eid = enterpriseid;
			} catch (Exception en) {
				eid = 0;
			}
		}
		return eid;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		products = versionService.getProductsApplied(getEid());
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String iadd() throws Exception {
		product = versionService.getProduct(id);
		return "add";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		Product p = new Product();
		p.setId(id);
		p.setInformation(information);
		versionService.addInformationToProduct(p);
		nextUrl = "product-list.php";
		return NONE;
	}

	private List<Product> products;
	private Product product;
	private Integer id;
	private String information;
	@Resource
	private VersionService versionService;
	private String nextUrl;
	private Integer enterpriseid;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

}
