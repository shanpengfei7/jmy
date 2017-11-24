package com.jinmayi.servlet.baogao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jinmayi.dao.impl.DengLuDao;
import com.jinmayi.dao.impl.JiChuXinXiDao;
import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.YiShengDao;
import com.jinmayi.dao.impl.YiYuanDao;
import com.jinmayi.dao.impl.baogao.HrvBaoGaoDao;
import com.jinmayi.entity.DengLu;
import com.jinmayi.entity.HrvBaoGao;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;
import com.jinmayi.entity.YiSheng;
import com.jinmayi.entity.YiYuan;

public class hrvbg extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HrvBaoGaoDao hrvBaoGaoDao = new HrvBaoGaoDao();
	JiChuXinXiDao jiChuXinXiDao = new JiChuXinXiDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();
	DengLuDao dengLuDao = new DengLuDao();
	YiYuanDao yiYuanDao = new YiYuanDao();
	YiShengDao yiShengDao = new YiShengDao();

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = request.getParameter("m");

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01
		// Transitional//EN\">");
		// out.println("<HTML>");
		// out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		// out.println(" <BODY>");
		// out.print(" This is ");
		// out.print(this.getClass());
		// out.println(", using the POST method");
		// out.println(" </BODY>");
		// out.println("</HTML>");
		// out.flush();
		// out.close();
	}

	public void bind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = "";
		String password = "";
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();
				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString("UTF-8");

					if ("number".equals(name)) {
						number = value;
					}
					if ("password".equals(name)) {
						password = value;
					}

				} else {
					String error = "�����û�������������";
					json.put("error", error);
					json.put("status", 0);
					out.print(json);
					out.flush();
					out.close();
					return;
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}
		// ======================================================================

		DengLu dengLu = dengLuDao.getDengLuByDengLuHao(number);
		try {
			if (dengLu.getMiMa().equals(password)) {

				Integer quanXian = dengLu.getQuanXian();

				if (quanXian == 2) {
					// ok
					YiYuan yy = yiYuanDao.getIdByDLId(dengLu.getId());
					json.put("yyid", yy.getId());
					json.put("status", 1);
					out.print(json);
					out.flush();
					out.close();
					return;
				} else {
					String error = "����¼���˺Ų���ȷ������ҽԺ����Ա���˺ŵ�¼��";
					json.put("error", error);
					json.put("status", 0);
					out.print(json);
					out.flush();
					out.close();
					return;
				}
			} else {
				String error = "�����û�������������";
				json.put("error", error);
				json.put("status", 0);
				out.print(json);
				out.flush();
				out.close();
				return;
			}
		} catch (Exception e) {
			String error = "�����û�������������";
			try {
				json.put("error", error);
				json.put("status", 0);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			out.print(json);
			out.flush();
			out.close();
			return;
		}

	}

	public void hrvinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = "";
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();
				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString("UTF-8");

					if ("yyid".equals(name)) {
						id = value;
					}

				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}
		int yyid = 0;
		if (id != null) {
			yyid = Integer.parseInt(id);
		}
		List<JiChuXinXi> jiChuXinXis = jiChuXinXiDao.hrv(yyid);

		Boolean flag = false;
		for (int i = jiChuXinXis.size() - 1; i >= 0; i--) {

			int ciShu = 0;
			JianCeXiangMu jcxm = jianCeXiangMuDao.hrv(yyid, jiChuXinXis.get(i).getId());
			if (jcxm != null) {
				ciShu = jcxm.getCiShu();
				flag = true;
			} else {
				jiChuXinXis.remove(i);
			}

			if (flag) {
				HrvBaoGao hrv = hrvBaoGaoDao.hrv(ciShu, jiChuXinXis.get(i).getId());
				if (hrv != null) {
					jiChuXinXis.remove(i);
				}
				flag = false;
			}
		}
		JSONArray json = new JSONArray();
		try {
			for (int i = 0; i < jiChuXinXis.size(); i++) {
				JSONObject jo = new JSONObject();
				jo.put("id", jiChuXinXis.get(i).getId());
				jo.put("name", jiChuXinXis.get(i).getXingMing());
				if (jiChuXinXis.get(i).getXingBie() == 1) {
					jo.put("sex", "��");
				} else if (jiChuXinXis.get(i).getXingBie() == 2) {
					jo.put("sex", "Ů");
				}
				jo.put("birthday", jiChuXinXis.get(i).getChuShengNian() + "-" + jiChuXinXis.get(i).getChuShengYue()
						+ "-" + jiChuXinXis.get(i).getChuShengRi());
				jo.put("date", jiChuXinXis.get(i).getRiQi());
				jo.put("caseId", jiChuXinXis.get(i).getYongHuId());
				jo.put("doorId", jiChuXinXis.get(i).getMenZhenHao());
				jo.put("hisId", jiChuXinXis.get(i).getBingAnHao());
				json.put(jo);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			out.print(json);
			out.flush();
			out.close();
		}

	}

	public void one(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = "";
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();
				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString("UTF-8");

					if ("jcxxid".equals(name)) {
						id = value;
					}

				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}
		int jcxxid = 0;
		if (id != null) {
			jcxxid = Integer.parseInt(id);
		}
		JiChuXinXi j = jiChuXinXiDao.one(jcxxid);
		YiSheng ys = yiShengDao.getYiShengById(j.getJingShenKeYiShengId());

		JSONObject jo = new JSONObject();
		try {
			jo.put("caseID", j.getYongHuId());
			jo.put("name", j.getXingMing());
			if (j.getXingBie() == 1) {
				jo.put("sex", "��");
			} else if (j.getXingBie() == 2) {
				jo.put("sex", "Ů");
			}
			jo.put("birthday", j.getChuShengNian() + "-" + j.getChuShengYue() + "-" + j.getChuShengRi() + " 00:00:00");
			jo.put("doorID", j.getMenZhenHao());
			jo.put("hisID", j.getBingAnHao());
			jo.put("height", j.getShenGao());
			jo.put("weight", j.getTiZhong());
			jo.put("tel", j.getLianXiDianHua());
			jo.put("add", j.getLianXiDiZhi());
			jo.put("phyName", j.getZhuGuanYiShi());
			jo.put("office", ys.getKeShi());
			jo.put("phyTel", ys.getLianXiFangShi());
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {

			out.print(jo);
			out.flush();
			out.close();
		}
	}

	public void flag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = "";
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();
				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString("UTF-8");

					if ("jcxxid".equals(name)) {
						id = value;
					}

				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}
		int jcxxid = 0;
		if (id != null) {
			jcxxid = Integer.parseInt(id);
		}
		JianCeXiangMu j = jianCeXiangMuDao.hrv(jcxxid);

		if (j == null) {
			out.print(0);
		} else if (j.getHrv()) {
			out.print(1);
		} else if (!j.getHrv()) {
			out.print(0);
		}

		out.flush();
		out.close();
	}

	public void ibg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String cs = request.getParameter("cs");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer bgcs = null;
		try {
			bgcs = Integer.parseInt(cs) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		HrvBaoGao h = hrvBaoGaoDao.getHrvBaoGaoByCiShuJcxx(bgcs, jId);
		request.setAttribute("h", h);
		request.setAttribute("jid", id);
		request.setAttribute("cs", bgcs);
		request.getRequestDispatcher("pages/baogao/hrvbg.jsp").forward(request, response);
	}

	public void ipic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String cs = request.getParameter("cs");
		String pic = request.getParameter("pic");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer bgcs = null;
		try {
			bgcs = Integer.parseInt(cs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HrvBaoGao h = hrvBaoGaoDao.getHrvBaoGaoByCiShuJcxx(bgcs, jId);
		if (h != null) {
			if (pic.equals("1")) {
				request.setAttribute("pic", "hrv/" + h.getPic1());
			} else if (pic.equals("2")) {
				request.setAttribute("pic", "hrv/" + h.getPic2());
			} else if (pic.equals("3")) {
				request.setAttribute("pic", "hrv/" + h.getPic3());
			} else if (pic.equals("4")) {
				request.setAttribute("pic", "hrv/" + h.getPic4());
			} else if (pic.equals("5")) {
				request.setAttribute("pic", "hrv/" + h.getPic5());
			}
		}

		request.setAttribute("jid", id);
		request.setAttribute("cs", bgcs);
		request.getRequestDispatcher("pages/baogao/pic.jsp").forward(request, response);
	}

	public void sbg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/hrv");

		// ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
		// ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		HrvBaoGao h = new HrvBaoGao();
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			int index = 0;
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();

				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString("UTF-8");

					if ("cishu".equals(name)) {
						Integer cs = null;
						try {
							cs = Integer.parseInt(value);
						} catch (Exception e) {

						}
						h.setCiShu(cs);
					}
					if ("jid".equals(name)) {
						Integer jId = null;
						try {
							jId = Integer.parseInt(value);
						} catch (Exception e) {

						}
						h.setJiChuXinXiId(jId);
					}

				}
				// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
				else {
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					index++;
					if (index == 1) {
						h.setPic1(filename);
					} else if (index == 2) {
						h.setPic2(filename);
					} else if (index == 3) {
						h.setPic3(filename);
					} else if (index == 4) {
						h.setPic4(filename);
					} else if (index == 5) {
						h.setPic5(filename);
					} else {
						continue;
					}
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path, filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());

					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
						out.write(buf, 0, length);

					}
					in.close();
					out.close();
				}
			}
			if (h.getPic1() == null || h.getPic1().equals("")) {
				request.getRequestDispatcher("hrvbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu() - 1))
						.forward(request, response);
				return;
			}
			hrvBaoGaoDao.save(h);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		response.sendRedirect("hrvbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu() - 1));
	}

	public void ebg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/hrv");

		// ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
		// ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		HrvBaoGao h = new HrvBaoGao();
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			int index = 0;
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();

				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString("UTF-8");

					if ("id".equals(name)) {
						Integer id = null;
						try {
							id = Integer.parseInt(value);
						} catch (Exception e) {

						}
						h.setId(id);
					}

					if ("cishu".equals(name)) {
						Integer cs = null;
						try {
							cs = Integer.parseInt(value);
						} catch (Exception e) {

						}
						h.setCiShu(cs);
					}
					if ("jid".equals(name)) {
						Integer jId = null;
						try {
							jId = Integer.parseInt(value);
						} catch (Exception e) {

						}
						h.setJiChuXinXiId(jId);
					}

				}
				// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
				else {
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					index++;
					if (index == 1) {
						h.setPic1(filename);
					} else if (index == 2) {
						h.setPic2(filename);
					} else if (index == 3) {
						h.setPic3(filename);
					} else if (index == 4) {
						h.setPic4(filename);
					} else if (index == 5) {
						h.setPic5(filename);
					} else {
						continue;
					}
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path, filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());

					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
						out.write(buf, 0, length);

					}
					in.close();
					out.close();
				}
			}
			if (h.getPic1() == null || h.getPic1().equals("")) {
				request.getRequestDispatcher("hrvbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu() - 1))
						.forward(request, response);
				return;
			}
			hrvBaoGaoDao.update(h);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		response.sendRedirect("hrvbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu() - 1));
	}

	public void hrv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/hrv");

		// ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
		// ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		HrvBaoGao h = new HrvBaoGao();
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			int index = 0;
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();

				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString("UTF-8");

					if ("yhid".equals(name)) {
						// Integer yhid = null;
						// try {
						// yhid = Integer.parseInt(value);
						// } catch (Exception e) {
						//
						// }
						// h.setCiShu(cs);
						JiChuXinXi jiChuXinXi = jiChuXinXiDao.getIdByYongHuId(value);
						JianCeXiangMu jianCeXiangMu = jianCeXiangMuDao.getNewJianCeXiangMusByJcxxId(jiChuXinXi.getId());
						h.setCiShu(jianCeXiangMu.getCiShu());
						h.setJiChuXinXiId(jiChuXinXi.getId());
					}
					// if ("cishu".equals(name)) {
					// Integer cs = null;
					// try {
					// cs = Integer.parseInt(value);
					// } catch (Exception e) {
					//
					// }
					// h.setCiShu(cs);
					// }
					// if ("jid".equals(name)) {
					// Integer jId = null;
					// try {
					// jId = Integer.parseInt(value);
					// } catch (Exception e) {
					//
					// }
					// h.setJiChuXinXiId(jId);
					// }

				}
				// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
				else {
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					index++;
					if (index == 1) {
						h.setPic1(filename);
					} else if (index == 2) {
						h.setPic2(filename);
					} else if (index == 3) {
						h.setPic3(filename);
					} else if (index == 4) {
						h.setPic4(filename);
					} else if (index == 5) {
						h.setPic5(filename);
					} else {
						continue;
					}
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path, filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());

					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
						out.write(buf, 0, length);

					}
					in.close();
					out.close();
				}
			}
			if (h.getPic1() == null || h.getPic1().equals("")) {
				request.getRequestDispatcher("hrvbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu() - 1))
						.forward(request, response);
				return;
			}
			hrvBaoGaoDao.save(h);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		// response.sendRedirect("hrvbg?m=ibg&id=" + h.getJiChuXinXiId() +
		// "&cs=" + (h.getCiShu()-1));
	}
}
