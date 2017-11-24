package com.jinmayi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Evaluate;
import com.jinmayi.entity.Makeqrcode;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Productproperty;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.EvaluateService;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.VersionService;
import com.jinmayi.util.qrcode.QRCodeUtil;
import com.jinmayi.util.qrcode.ZipUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��Ĺ���
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class QrCodeAction extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, ServletContextAware {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String zip() throws Exception {
		List<Qrcode> qrcodes = qrCodeService.getQrcodesByMakeQrCodeId(mid);

		Product p = productService.getProductById(qrcodes.get(0).getProductid());
		Enterprise en = enterpriseService.getEnterpriseById(p.getEnterpriseid());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// �������ڸ�ʽ
		// zip�ļ���
		String fileName = p.getTradename() + "_" + df.format(new Date()) + "_" + en.getCode() + "_"
				+ new Random().nextInt(9999) + ".zip";
		// ͼƬ����ļ�
		String fileDir = p.getTradename() + "_" + df.format(new Date()) + "_" + en.getCode() + "_"
				+ new Random().nextInt(9999);
		// �õ���Ŀ�ĸ�Ŀ¼
		String path = application.getRealPath("/");
		// zip�ļ�ȫ·����
		String fileString = path + "file/temp/" + fileName;

		File f = new File(fileString);

		qrCodeService.updateMakeQrCode(mid);
		try {
			for (int i = 0; i < qrcodes.size(); i++) {
				String text = "http://192.168.108.201:8080/zs/show.php?token=" + qrcodes.get(i).getQrcode();
				QRCodeUtil.encode(text, path + "file/temp/" + fileDir, (i + 1) + ".jpg", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ZipUtil.zip(path + "file/temp/" + fileDir, path + "file/temp/", fileName);

		// ɾ��ͼƬ�ļ���
		File ff = new File("file/temp/" + fileDir);
		deleteFile(ff);

		InputStream is = new FileInputStream(fileString);
		// ���ص�����ͻ���
		// HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream os = response.getOutputStream();

		String userAgent = request.getHeader("User-Agent");

		// �������صĿ�filename:��ʾ�û����ص��ļ���
		if (userAgent.toLowerCase().indexOf("msie") > 0 || userAgent.toLowerCase().indexOf("edge") > 0) {
			response.addHeader("content-disposition",
					"attachment;filename=" + java.net.URLEncoder.encode(fileName, "utf-8"));
		} else {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
		}
		byte[] b = new byte[1024];
		int size = is.read(b);
		while (size > 0) {
			os.write(b, 0, size);
			size = is.read(b);
		}
		is.close();
		os.close();
		f.delete();
		return SUCCESS;
	}

	// �ݹ�ɾ���ļ���
	private void deleteFile(File file) {
		if (file.exists()) {// �ж��ļ��Ƿ����
			if (file.isFile()) {// �ж��Ƿ����ļ�
				file.delete();// ɾ���ļ�
			} else if (file.isDirectory()) {// �����������һ��Ŀ¼
				File[] files = file.listFiles();// ����Ŀ¼�����е��ļ� files[];
				for (int i = 0; i < files.length; i++) {// ����Ŀ¼�����е��ļ�
					this.deleteFile(files[i]);// ��ÿ���ļ�������������е���
				}
				file.delete();// ɾ���ļ���
			}
		} else {
			System.out.println("��ɾ�����ļ�������");
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String txt() throws Exception {

		List<Qrcode> qrcodes = qrCodeService.getQrcodesByMakeQrCodeId(mid);
		Product p = productService.getProductById(qrcodes.get(0).getProductid());
		Enterprise en = enterpriseService.getEnterpriseById(p.getEnterpriseid());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// �������ڸ�ʽ
		String fileName = p.getTradename() + "_" + df.format(new Date()) + "_" + en.getCode() + "_"
				+ new Random().nextInt(9999) + ".txt";
		// Ҫ���ص��ĸ��ļ�
		String path = application.getRealPath("/");// �õ���Ŀ�ĸ�Ŀ¼
		String fileString = path + "file/temp/" + fileName;

		File f = new File(fileString);
		qrCodeService.updateMakeQrCode(mid);
		try {
			FileOutputStream o = new FileOutputStream(f, true);
			try {
				for (Qrcode qrcode : qrcodes) {
					o.write(("http://cnniot.cn/C/S?" + qrcode.getQrcode() + "\r\n").getBytes("utf-8"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				o.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream is = new FileInputStream(fileString);
		// ���ص�����ͻ���
		// HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream os = response.getOutputStream();

		String userAgent = request.getHeader("User-Agent");
		// �������صĿ�filename:��ʾ�û����ص��ļ���
		if (userAgent.toLowerCase().indexOf("msie") > 0 || userAgent.toLowerCase().indexOf("edge") > 0) {
			response.addHeader("content-disposition",
					"attachment;filename=" + java.net.URLEncoder.encode(fileName, "utf-8"));
		} else {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
		}
		System.out.println(userAgent);
		byte[] b = new byte[1024];
		int size = is.read(b);
		while (size > 0) {
			os.write(b, 0, size);
			size = is.read(b);
		}
		is.close();
		os.close();
		f.delete();
		return SUCCESS;
	}

	private Makeqrcode makeqrcode;
	private List<Makeqrcode> makeqrcodes;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String dlist() throws Exception {
		makeqrcodes = qrCodeService.getMakeqrcodesByEidAndPid(enterpriseid, pid);
		for (Makeqrcode m : makeqrcodes) {
			product = productService.getProductById(pid);
			m.setProduct(product);
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String evalist() throws Exception {
		// ���pageNow��ǰҳ��Ϊ�գ�����Ϊ0
		if (pageNow == null) {
			pageNow = 1;
		}
		// ���pageSizeһҳ��ʾ��������ϢΪ�գ�����ʾ10��
		if (pageSize == null) {
			pageSize = 10;
		}
		rowCount = evaluateService.getEvaluateCountByProductId(pid);
		if (rowCount > 0) {
			evaluates = evaluateService.getEvaluatesByProductId(pid, pageNow, pageSize);
		}

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String qrlist() throws Exception {
		// ���pageNow��ǰҳ��Ϊ�գ�����Ϊ0
		if (pageNow == null) {
			pageNow = 1;
		}
		// ���pageSizeһҳ��ʾ��������ϢΪ�գ�����ʾ10��
		if (pageSize == null) {
			pageSize = 10;
		}
		rowCount = qrCodeService.getQrcodeCountByMqid(pid);
		if (rowCount > 0) {
			qrcodes = qrCodeService.getQrcodesByMqid(pid, pageNow, pageSize);
		}
		noUseQrCodeCount = qrCodeService.getNoUseQrcodeCountByMqid(pid);
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		products = versionService.getProductsApplied(getEid());
		enterpriseid = eid;
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String plist() throws Exception {
		products = versionService.getProductsAppliedp(getEid());
		enterpriseid = eid;
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String iadd() throws Exception {
		productproperties = productService.getProductproperties(pid);
		return "add";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		qrCodeService.printQrCodeBatch(pid, count, getEid(), propertyName, propertyValue, price);

		if (operate == 1) {
			nextUrl = "qrcode-list.php";
		} else {
			nextUrl = "qrcode-plist.php";
		}
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String qlist() throws Exception {
		try {
			makeqrcodes = qrCodeService.getMakeQrCodesByEnId(getEid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Makeqrcode m : makeqrcodes) {
			product = productService.getProductById(m.getProductid());
			m.setProduct(product);
		}
		return SUCCESS;
	}

	@Resource
	private VersionService versionService;
	@Resource
	private QrCodeService qrCodeService;
	@Resource
	private ProductService productService;
	@Resource
	private EvaluateService evaluateService;
	@Resource
	private EnterpriseService enterpriseService;
	private String nextUrl;
	private List<Product> products;
	private Integer pid;
	private Integer count;
	private Integer operate;
	private String qrcode;
	private Product product;
	private Productproperty productproperty;
	private List<Productproperty> productproperties;
	private String propertyName;
	private String propertyValue;
	private List<Qrcode> qrcodes;
	private Integer pageNow;// ��ǰҳ
	private Integer pageSize;// һҳ������
	private Integer rowCount;// ������
	private Integer pageCount;// ������ҳ
	private Integer noUseQrCodeCount;
	private Integer enterpriseid;
	private Double price;
	private List<Evaluate> evaluates;
	private Integer mid;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public List<Evaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	HttpSession session = ServletActionContext.getRequest().getSession();
	// private Integer eid =
	// Integer.parseInt(session.getAttribute("enterpriseId").toString());//
	// ��ҵ��id

	private Integer eid = null;// ��ҵ��id

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Productproperty getProductproperty() {
		return productproperty;
	}

	public void setProductproperty(Productproperty productproperty) {
		this.productproperty = productproperty;
	}

	public List<Productproperty> getProductproperties() {
		return productproperties;
	}

	public void setProductproperties(List<Productproperty> productproperties) {
		this.productproperties = productproperties;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public List<Qrcode> getQrcodes() {
		return qrcodes;
	}

	public void setQrcodes(List<Qrcode> qrcodes) {
		this.qrcodes = qrcodes;
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

	public Integer getNoUseQrCodeCount() {
		return noUseQrCodeCount;
	}

	public void setNoUseQrCodeCount(Integer noUseQrCodeCount) {
		this.noUseQrCodeCount = noUseQrCodeCount;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Makeqrcode getMakeqrcode() {
		return makeqrcode;
	}

	public void setMakeqrcode(Makeqrcode makeqrcode) {
		this.makeqrcode = makeqrcode;
	}

	public List<Makeqrcode> getMakeqrcodes() {
		return makeqrcodes;
	}

	public void setMakeqrcodes(List<Makeqrcode> makeqrcodes) {
		this.makeqrcodes = makeqrcodes;
	}

	private HttpServletResponse response;
	private HttpServletRequest request;
	private ServletContext application;

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.application = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
