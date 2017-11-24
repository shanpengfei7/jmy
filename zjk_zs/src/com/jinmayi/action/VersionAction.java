package com.jinmayi.action;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.CoiCategoryOne;
import com.jinmayi.entity.CoiCategoryThree;
import com.jinmayi.entity.CoiCategoryTwo;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Productproperty;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.VersionService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 物品的型号
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class VersionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 要找平台要掊口，拿到码的前面的内容
	 * 
	 * @return
	 * @throws Exception
	 */
	public String check() throws Exception {
		product = productService.getProductById(id);
		// 从平台上得到的码的前半段
		String aa = "COI186shanpengfei" + product.getEnterpriseid() + product.getVersion()
				+ UUID.randomUUID().toString().substring(0, 5);

		productService.checkProduct(aa, id);
		nextUrl = "version-adminapplying.php";
		return NONE;
	}

	/**
	 * 申请中的型号
	 * 
	 * @return
	 * @throws Exception
	 */
	public String applying() throws Exception {
		products = versionService.getProductsApplying(getEid());
		return SUCCESS;
	}

	public String adminapplying() throws Exception {
		products = versionService.getProductsApplying();
		for (Product p : products) {
			enterprise = enterpriseService.getEnterpriseById(p.getEnterpriseid());
			p.setEnterprise(enterprise);
		}
		return SUCCESS;
	}

	/**
	 * 列出一级
	 * 
	 * @return
	 * @throws Exception
	 */
	public String one() throws Exception {
		Enterprise e = enterpriseService
				.getEnterpriseById(Integer.parseInt(session.getAttribute("enterpriseId").toString()));
		if (e != null && e.getIsconnect() == 0) {
			coiCategoryOnes = versionService.getCoiCategoryOnes();
		}
		return SUCCESS;
	}

	/**
	 * 列出二级
	 * 
	 * @return
	 * @throws Exception
	 */
	public String two() throws Exception {
		coiCategoryTwos = versionService.getcoiCategoryTwos(id);
		return SUCCESS;
	}

	/**
	 * 列出三级
	 * 
	 * @return
	 * @throws Exception
	 */
	public String three() throws Exception {
		coiCategoryThrees = versionService.getcoiCategoryThrees(id);
		return SUCCESS;
	}

	/**
	 * 打开添加界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String iadd() throws Exception {
		coiCategoryThree = versionService.getCoiCategoryThree(id);
		return "add";
	}

	/**
	 * 添加操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		Product p = new Product();
		Short s0 = 0;
		p.setStatus(s0);
		p.setIsapply(s0);
		p.setIspackage(s0);
		p.setIsdelete(s0);
		p.setName(name);
		p.setVersion(version);
		p.setDescription(description);
		p.setTradename(tradename);
		p.setEnterpriseid(getEid());
		p.setProcode(version);

		enterprise = enterpriseService.getEnterpriseById(getEid());

		if (enterprise.getBit(enterprise.getRole(), 0)) {
			versionService.saveProduct(p);
		} else {
			error = "申请失败，请您重新登录！";
			return SUCCESS;
		}
		nextUrl = "version-applying.php";
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		product = versionService.getProduct(id);
		return "edit";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		Product p = new Product();
		p.setTradename(tradename);
		p.setDescription(description);
		p.setId(id);
		Integer eid = getEid();
		if (eid != null) {
			enterprise = enterpriseService.getEnterpriseById(eid);
		}
		if (enterprise == null) {
			versionService.updateProduct(p);
		} else if (enterprise.getBit(enterprise.getRole(), 0)) {
			versionService.updateProduct(p);
		} else {
			error = "申请失败，请您重新登录！";
			return SUCCESS;
		}
		if (ad == 1) {
			nextUrl = "version-adminapplied.php";
		} else if (ad == 2) {
			nextUrl = "version-applying.php";
		}
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		versionService.deleteProduct(id);
		if (ad == 1) {
			nextUrl = "version-adminapplying.php";
		} else if (ad == 2) {
			nextUrl = "version-applying.php";
		}
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String applied() throws Exception {
		products = versionService.getProductsApplied(getEid());
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String adminapplied() throws Exception {
		products = versionService.getProductsApplied();
		for (Product p : products) {
			enterprise = enterpriseService.getEnterpriseById(p.getEnterpriseid());
			p.setEnterprise(enterprise);
		}
		return SUCCESS;
	}

	/**
	 * 列出一个产品的所有属性
	 * 
	 * @return
	 * @throws Exception
	 */
	public String plist() throws Exception {
		productproperties = productService.getProductproperties(pid);
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String piadd() throws Exception {
		product = versionService.getProduct(pid);
		return "padd";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String padd() throws Exception {
		Productproperty p = new Productproperty();
		p.setName(name);
		p.setValue(value);
		p.setProductid(pid);
		p.setDescription(description);
		productService.saveProductproperty(p);
		// nextUrl = "version-applied.php";
		nextUrl = "version-plist.php?pid=" + pid;
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String piedit() throws Exception {
		productproperty = productService.getProductpropertyById(id);
		product = versionService.getProduct(productproperty.getProductid());

		return "pedit";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pedit() throws Exception {
		Productproperty p = new Productproperty();
		p.setName(name);
		p.setId(id);
		p.setValue(value);
		p.setDescription(description);
		productService.updateProductproperty(p);
		// nextUrl = "version-applied.php";
		nextUrl = "version-plist.php?pid=" + pid;
		return NONE;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pdelete() throws Exception {
		Productproperty p = new Productproperty();
		p.setId(id);
		productService.deleteProductproperty(p);
		// nextUrl = "version-applied.php";
		nextUrl = "version-plist.php?pid=" + pid;
		return NONE;
	}

	@Resource
	private ProductService productService;
	@Resource
	private VersionService versionService;
	@Resource
	private EnterpriseService enterpriseService;
	private Integer id;
	private List<Product> products;
	private List<CoiCategoryOne> coiCategoryOnes;
	private List<CoiCategoryTwo> coiCategoryTwos;
	private List<CoiCategoryThree> coiCategoryThrees;
	private CoiCategoryThree coiCategoryThree;
	private String nextUrl;
	private String name;
	private String value;
	private String tradename;
	private String version;
	private String description;
	private Product product;
	private Integer pid;
	private String information;
	private List<Productproperty> productproperties;
	private Productproperty productproperty;
	private Integer ad;
	private Enterprise enterprise;
	private Integer enterpriseid;
	private String error;
	private String keyword;

	HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer eid = null;// 企业的id

	public List<Product> getProducts() {
		return products;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<CoiCategoryOne> getCoiCategoryOnes() {
		return coiCategoryOnes;
	}

	public void setCoiCategoryOnes(List<CoiCategoryOne> coiCategoryOnes) {
		this.coiCategoryOnes = coiCategoryOnes;
	}

	public List<CoiCategoryTwo> getCoiCategoryTwos() {
		return coiCategoryTwos;
	}

	public void setCoiCategoryTwos(List<CoiCategoryTwo> coiCategoryTwos) {
		this.coiCategoryTwos = coiCategoryTwos;
	}

	public List<CoiCategoryThree> getCoiCategoryThrees() {
		return coiCategoryThrees;
	}

	public void setCoiCategoryThrees(List<CoiCategoryThree> coiCategoryThrees) {
		this.coiCategoryThrees = coiCategoryThrees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CoiCategoryThree getCoiCategoryThree() {
		return coiCategoryThree;
	}

	public void setCoiCategoryThree(CoiCategoryThree coiCategoryThree) {
		this.coiCategoryThree = coiCategoryThree;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTradename() {
		return tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<Productproperty> getProductproperties() {
		return productproperties;
	}

	public void setProductproperties(List<Productproperty> productproperties) {
		this.productproperties = productproperties;
	}

	public Productproperty getProductproperty() {
		return productproperty;
	}

	public void setProductproperty(Productproperty productproperty) {
		this.productproperty = productproperty;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Integer getAd() {
		return ad;
	}

	public void setAd(Integer ad) {
		this.ad = ad;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
