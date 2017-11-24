package com.jinmayi.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Product;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Repertory;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.RepertoryService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ¿â´æ
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class RepertoryAction extends ActionSupport {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		repertories = repertoryService.getRepertories(getEid());
		if (repertories != null) {
			for (int j = 0; j < repertories.size(); j++) {
				Qrcode q = new Qrcode();
				try {
					q = qrCodeService.getQrCodeById(repertories.get(j).getQrcodeid());
					if (q.getHasparent() == 1) {

						Repertory re = repertoryService.getRepertories(getEid(), q.getParentid());
						if (re != null) {
							repertories.remove(j);
							j--;
							continue;
						}
					} else if (q.getIsuse() == 0) {
						repertories.remove(j);
						j--;
						continue;
					}
					List<Qrcode> qs = qrCodeService.getQrcodesByParentId(q.getId());
					if (qs == null) {
						repertories.remove(j);
						continue;
					} else {
						for (int i = 0; i < qs.size(); i++) {
							Repertory r = repertoryService.getRepertories(getEid(), qs.get(i).getId());
							if (r == null) {
								qs.remove(i);
								i--;
							} else {
								Qrcode qr = qs.get(i);
								Product p = productService.getProductById(qr.getProductid());
								qr.setProduct(p);
							}
						}
					}

					q.setSons(qs);

					Product p = productService.getProductById(q.getProductid());
					q.setProduct(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
				repertories.get(j).setQrcode(q);
			}
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sonlist() throws Exception {

		qrcodes = qrCodeService.getQrcodesByParentId(qrcodeid);
		if (qrcodes != null) {
			for (int i = 0; i < qrcodes.size(); i++) {
				Repertory r = repertoryService.getRepertories(getEid(), qrcodes.get(i).getId());
				if (r == null) {
					qrcodes.remove(i);
					i--;
					continue;
				}

				Product p = productService.getProductById(qrcodes.get(i).getProductid());
				qrcodes.get(i).setProduct(p);

				List<Qrcode> qs = qrCodeService.getQrcodesByParentId(qrcodes.get(i).getId());
				if (qs != null) {
					for (int j = 0; j < qs.size(); j++) {
						Repertory re = repertoryService.getRepertories(getEid(), qs.get(j).getId());
						if (re == null) {
							qs.remove(j);
							j--;
						} else {
							Qrcode qr = qs.get(j);
							Product pro = productService.getProductById(qr.getProductid());
							qr.setProduct(pro);
						}
					}
					qrcodes.get(i).setSons(qs);
				}

			}
		}
		return SUCCESS;
	}

	HttpSession session = ServletActionContext.getRequest().getSession();
	private Integer eid = null;// ÆóÒµµÄid

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

	private Integer enterpriseid;
	@Resource
	private RepertoryService repertoryService;
	@Resource
	private QrCodeService qrCodeService;
	@Resource
	private ProductService productService;

	private List<Repertory> repertories;
	private List<Qrcode> qrcodes;
	private Integer qrcodeid;

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public List<Repertory> getRepertories() {
		return repertories;
	}

	public void setRepertories(List<Repertory> repertories) {
		this.repertories = repertories;
	}

	public List<Qrcode> getQrcodes() {
		return qrcodes;
	}

	public void setQrcodes(List<Qrcode> qrcodes) {
		this.qrcodes = qrcodes;
	}

	public Integer getQrcodeid() {
		return qrcodeid;
	}

	public void setQrcodeid(Integer qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

}
