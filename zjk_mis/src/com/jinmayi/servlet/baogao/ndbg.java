package com.jinmayi.servlet.baogao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import com.jinmayi.dao.impl.baogao.NaoDianBaoGaoDao;
import com.jinmayi.entity.NaoDianBaoGao;

public class ndbg extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	NaoDianBaoGaoDao naoDianBaoGaoDao = new NaoDianBaoGaoDao();
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methodName = request.getParameter("m");

		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	}
	public void ibg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		NaoDianBaoGao h = naoDianBaoGaoDao.getNaoDianBaoGaoByCiShuJcxx(bgcs, jId);
		request.setAttribute("h", h);
		request.setAttribute("jid", id);
		request.setAttribute("cs", bgcs);
		request.getRequestDispatcher("pages/baogao/ndbg.jsp").forward(request, response);
	}
	
	public void ipic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		NaoDianBaoGao h = naoDianBaoGaoDao.getNaoDianBaoGaoByCiShuJcxx(bgcs, jId);
		if(h != null) {
			if(pic.equals("1")) {
				request.setAttribute("pic", "naodian/" + h.getPic1());
			} else if(pic.equals("2")) {
				request.setAttribute("pic", "naodian/" + h.getPic2());
			} else if(pic.equals("3")) {
				request.setAttribute("pic", "naodian/" + h.getPic3());
			} else if(pic.equals("4")) {
				request.setAttribute("pic", "naodian/" + h.getPic4());
			} else if(pic.equals("5")) {
				request.setAttribute("pic", "naodian/" + h.getPic5());
			}
		}
		
		request.setAttribute("jid", id);
		request.setAttribute("cs", bgcs);
		request.getRequestDispatcher("pages/baogao/pic.jsp").forward(request, response);
	}
	
	
	public void sbg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/naodian");

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

		NaoDianBaoGao h = new NaoDianBaoGao();
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
					index ++;
					if(index == 1) {
						h.setPic1(filename);
					} else if(index == 2) {
						h.setPic2(filename);
					} else if(index == 3) {
						h.setPic3(filename);
					} else if(index == 4) {
						h.setPic4(filename);
					} else if(index == 5) {
						h.setPic5(filename);
					} else {
						continue;
					}
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path,
							filename));

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
			if(h.getPic1() == null || h.getPic1().equals("")) {
				request.getRequestDispatcher("ndbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu()-1)).forward(request, response);
				return;
			}
			naoDianBaoGaoDao.save(h);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		response.sendRedirect("ndbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu()-1));
	}
	public void ebg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/naodian");

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

		NaoDianBaoGao h = new NaoDianBaoGao();
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
					
					if("id".equals(name)) {
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
					index ++;
					if(index == 1) {
						h.setPic1(filename);
					} else if(index == 2) {
						h.setPic2(filename);
					} else if(index == 3) {
						h.setPic3(filename);
					} else if(index == 4) {
						h.setPic4(filename);
					} else if(index == 5) {
						h.setPic5(filename);
					} else {
						continue;
					}
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path,
							filename));

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
			if(h.getPic1() == null || h.getPic1().equals("")) {
				request.getRequestDispatcher("ndbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu()-1)).forward(request, response);
				return;
			}
			naoDianBaoGaoDao.update(h);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		response.sendRedirect("ndbg?m=ibg&id=" + h.getJiChuXinXiId() + "&cs=" + (h.getCiShu()-1));
	}
}
