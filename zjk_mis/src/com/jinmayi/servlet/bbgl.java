package com.jinmayi.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.json.JSONException;
import org.json.JSONObject;

import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.KeShiDao;
import com.jinmayi.dao.impl.YiShengDao;
import com.jinmayi.dao.impl.YiYuanDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchBb;
import com.jinmayi.entity.JianCeXiangMu;
import com.jinmayi.entity.KeShi;
import com.jinmayi.entity.YiSheng;
import com.jinmayi.entity.YiYuan;

/**
 * �������
 * @author pnfy
 *
 */
public class bbgl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	YiYuanDao yiYuanDao = new YiYuanDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();
	KeShiDao keShiDao = new KeShiDao();
	YiShengDao yiShengDao = new YiShengDao();
	
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

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	
	/**
	 * ר��ҽ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gzk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		JSONObject json = new JSONObject();
		
		HttpSession session = request.getSession();
		Integer qx = (Integer)session.getAttribute("quanxian");
		List<YiSheng> ys = null;
		if(qx == 1) {
			ys = yiShengDao.getZhuanKesByKeShiId(id.trim(), "ר��ҽ��", "ר������");
		} else {
			ys = yiShengDao.getZhuanKesByKeShiId(id.trim(), "ר��ҽ��", "ר������", session);
		}
		if(ys != null) {
			for(int i = 0; i < ys.size(); i++) {
				try {
					json.put("ys" + i, ys.get(i).getXingMing());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		Integer yiYuanId = null;
		try{
			yiYuanId = Integer.parseInt(id.trim());
		} catch(Exception e) {
			System.out.println(e);
		}
		JSONObject json = new JSONObject();
		List<KeShi> ks = keShiDao.getKeShisByYiYuanId(yiYuanId);
		if(ks != null) {
			for(int i = 0; i < ks.size(); i++) {
				try {
					json.put(i + "", ks.get(i).getMingCheng());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		
		out.print(json);
		out.flush();
		out.close();
	}
	/**
	 * �����ҽ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gjsk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		Integer yiYuanId = null;
		try{
			yiYuanId = Integer.parseInt(id.trim());
		} catch(Exception e) {
			System.out.println(e);
		}
		JSONObject json = new JSONObject();
		
		HttpSession session = request.getSession();
		Integer qx = (Integer)session.getAttribute("quanxian");
		List<YiSheng> jsk = null;
		if(qx == 1) {
			jsk = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "�����ҽ��", "���������");
		} else {
			jsk = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "�����ҽ��", "���������", session);
		}
		
		if(jsk != null) {
			for(int i = 0; i < jsk.size(); i++) {
				try {
					json.put(i + "", jsk.get(i).getXingMing());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		
		out.print(json);
		out.flush();
		out.close();
	}
	/**
	 * ����ʦ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gcps(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		Integer yiYuanId = null;
		try{
			yiYuanId = Integer.parseInt(id.trim());
		} catch(Exception e) {
			System.out.println(e);
		}
		JSONObject json = new JSONObject();
		
		List<YiSheng> cps = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "����ʦ", "����ʦ");
		if(cps != null) {
			for(int i = 0; i < cps.size(); i++) {
				try {
					json.put(i + "", cps.get(i).getXingMing());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		out.print(json);
		out.flush();
		out.close();
	}
	
	public void ibb(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long pageNow = 1;
		String r = request.getParameter("r");
		String q = request.getParameter("q");
		String y = request.getParameter("y");
		String k = request.getParameter("k");
		String z = request.getParameter("z");
		String j = request.getParameter("j");
		String c = request.getParameter("c");
		
		request.setAttribute("r", r);
		request.setAttribute("q", q);
		request.setAttribute("y", y);
		request.setAttribute("k", k);
		request.setAttribute("z", z);
		request.setAttribute("j", j);
		request.setAttribute("c", c);
		
		String pn = request.getParameter("pn");
		try{
			pageNow = Long.parseLong(pn.trim());
		} catch (Exception e) {
			pageNow = 1;
		}
		SearchBb s = new SearchBb();
		String sq = "";
		HttpSession session = request.getSession();
		Integer qx = (Integer)session.getAttribute("quanxian");
		try{
			if(qx != 1) {
				sq = " and yiYuanId = " + session.getAttribute("yiYuanId");
			
			} else if(!y.trim().equals("")) {
				sq = " and yiYuanId = " + Integer.parseInt(y.trim());
			}
		} catch (Exception e) {
			
		}
		try{
			s.setRiQi1(r.trim());
			if(r.equals("")) {
				s.setRiQi1("2000-0-0");
			}
		} catch(Exception e) {
			s.setRiQi1("2000-0-0");
		}
		try{
			s.setRiQi2(q.trim());
			if(q.equals("")) {
				s.setRiQi2(new Timestamp(new Date().getTime()).toString());
			}
		} catch(Exception e) {
			s.setRiQi2(new Timestamp(new Date().getTime()).toString());
		}
		sq += " and riQi between '"+s.getRiQi1()+"' and '" + s.getRiQi2() + "' ";
		
		try{
			if(!k.trim().equals("")) {
				sq += " and keShi = '" + k.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		try{
			if(!z.trim().equals("")) {
				sq += " and zhuanKeYiSheng = '" + z.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		try{
			if(!j.trim().equals("")) {
				sq += " and jingShenKeYiSheng = '" + j.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		try{
			if(!c.trim().equals("")) {
				sq += " and cePingShi = '" + c.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		
		request.setAttribute("nd", jianCeXiangMuDao.getNaoDianCount(sq));
		request.setAttribute("ccbt", jianCeXiangMuDao.getCcbtCount(sq));
		request.setAttribute("nrz", jianCeXiangMuDao.getNaoRenZhiCount(sq));
		request.setAttribute("xlcp", jianCeXiangMuDao.getXinLiCePingCount(sq));
		request.setAttribute("yy", jianCeXiangMuDao.getYingYanCount(sq));
		request.setAttribute("hrv", jianCeXiangMuDao.getHrvCount(sq));
		
		
		
		if(qx == 1) {
			List<YiYuan> yiYuans = yiYuanDao.getLessYiYuans();
			request.setAttribute("ys", yiYuans);
		} else if(qx == 2 || qx == 3 || qx == 4) {
			Integer yiYuanId = (Integer)session.getAttribute("yiYuanId");
			List<KeShi> ks = keShiDao.getKeShisByYiYuanId(yiYuanId);
			List<YiSheng> jsk = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "�����ҽ��", "���������");
			List<YiSheng> cps = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "����ʦ", "����ʦ");
			request.setAttribute("ks", ks);
			request.setAttribute("jsk", jsk);
			request.setAttribute("cps", cps);
		} else if(qx == 6) {
			List<YiSheng> ys = yiShengDao.getZhuanKesByKeShiId(session.getAttribute("keShi").toString(), "ר��ҽ��", "ר������", session);
			request.setAttribute("ys", ys);
		} else if(qx == 5) {
			sq += " and jingShenKeYiSheng = '" + session.getAttribute("xingMing").toString() +"'";
		} else if(qx == 7) {
			sq += " and zhuanKeYiSheng = '" + session.getAttribute("xingMing").toString() +"'";
			sq += " and keShi = '" + session.getAttribute("keShi").toString() +"'";
		} 
		Page<JianCeXiangMu> page = jianCeXiangMuDao.getPagebb(pageNow, sq);
		request.setAttribute("page", page);
		request.getRequestDispatcher("pages/bbgl.jsp").forward(request, response);
		
	}
	//================================������===============================
	public void pbb(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String r = request.getParameter("r");
		String q = request.getParameter("q");
		String y = request.getParameter("y");
		String k = request.getParameter("k");
		String z = request.getParameter("z");
		String j = request.getParameter("j");
		String c = request.getParameter("c");
		
		SearchBb s = new SearchBb();
		String sq = "";
		Integer qx = (Integer)request.getSession().getAttribute("quanxian");
		try{
			if(qx != 1) {
				sq = " and yiYuanId = " + request.getSession().getAttribute("yiYuanId");
			
			} else if(!y.trim().equals("")) {
				sq = " and yiYuanId = " + Integer.parseInt(y.trim());
			}
		} catch (Exception e) {
			
		}
		try{
			s.setRiQi1(r.trim());
			if(r.equals("")) {
				s.setRiQi1("2000-0-0");
			}
		} catch(Exception e) {
			s.setRiQi1("2000-0-0");
		}
		try{
			s.setRiQi2(q.trim());
			if(q.equals("")) {
				s.setRiQi2(new Timestamp(new Date().getTime()).toString());
			}
		} catch(Exception e) {
			s.setRiQi2(new Timestamp(new Date().getTime()).toString());
		}
		sq += " and riQi between '"+s.getRiQi1()+"' and '" + s.getRiQi2() + "' ";
		
		try{
			if(!k.trim().equals("")) {
				sq += " and keShi = '" + k.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		try{
			if(!z.trim().equals("")) {
				sq += " and zhuanKeYiSheng = '" + z.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		try{
			if(!j.trim().equals("")) {
				sq += " and jingShenKeYiSheng = '" + j.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		try{
			if(!c.trim().equals("")) {
				sq += " and cePingShi = '" + c.trim() +"'";
			}
		} catch (Exception e) {
			
		}
		
		List<YiYuan> yiYuans = null;
		if((Integer)request.getSession().getAttribute("quanxian") == 1) {
			yiYuans = yiYuanDao.getLessYiYuans();    
		}
		List<JianCeXiangMu> jcxm = jianCeXiangMuDao.getJianCeXiangMupbb(sq);
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();  
        for(JianCeXiangMu jc : jcxm){  
            Map<String,Object> map = new HashMap<String, Object>();  
            map.put("�û�ID",jc.getYongHuId());  
            map.put("����",jc.getXingMing()); 
            map.put("����",jc.getRiQi()); 
            if(jc.getNaoDian()) {
            	map.put("�Ե�", 1); 
            } else {
            	map.put("�Ե�", 0); 
			}
            if(jc.getCcbt()) {
            	map.put("CCBT", 1); 
            } else {
            	map.put("CCBT", 0); 
			}
            if(jc.getNaoRenZhi()) {
            	map.put("����֪", 1); 
            } else {
            	map.put("����֪", 0); 
			}
            if(jc.getXinLiCePing()) {
            	map.put("�������", 1); 
            } else {
            	map.put("�������", 0); 
			}
            if(jc.getYingYan()) {
            	map.put("ӥ��", 1); 
            } else {
            	map.put("ӥ��", 0); 
			}
            if(jc.getHrv()) {
            	map.put("HRV", 1); 
            } else {
            	map.put("HRV", 0); 
			}
            if((Integer)request.getSession().getAttribute("quanxian") == 1) {
    			for (YiYuan yy : yiYuans) {
					if(yy.getId() == jc.getYiYuanId()) {
						map.put("ҽԺ", yy.getMingCheng()); 
						continue;
					} else {
						map.put("ҽԺ", ""); 
						continue;
					}
				}    
    		} else {
    			map.put("ҽԺ", request.getSession().getAttribute("yiYuanMingCheng")); 
			}
            map.put("����",jc.getKeShi()); 
            map.put("�����ҽ��",jc.getJingShenKeYiSheng()); 
            map.put("ר��ҽ��",jc.getZhuanKeYiSheng()); 
            map.put("����ʦ",jc.getCePingShi()); 
            list.add(map);  
        }  
        String yiYuan = "";
        if((Integer)request.getSession().getAttribute("quanxian") == 1) {
			for (YiYuan yy : yiYuans) {
				try{
					if(yy.getId() == Integer.parseInt(y.trim())) {
						yiYuan = yy.getMingCheng(); 
					}
				} catch(Exception e) {
					yiYuan = "";
				}
			}    
		} else {
			yiYuan = request.getSession().getAttribute("yiYuanMingCheng").toString(); 
		}
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String excelName = "����" + format.format(Calendar.getInstance().getTime());  
        //ת���ֹ����  
        response.addHeader("Content-Disposition", "attachment;filename="+new String( excelName.getBytes("gb2312"), "ISO8859-1" )+".xls");  
        String[] count = new String[]{"����","","",jianCeXiangMuDao.getNaoDianCount(sq).toString(),
        		jianCeXiangMuDao.getCcbtCount(sq).toString(),jianCeXiangMuDao.getNaoRenZhiCount(sq).toString(),
        		jianCeXiangMuDao.getXinLiCePingCount(sq).toString(),jianCeXiangMuDao.getYingYanCount(sq).toString(),
        		jianCeXiangMuDao.getHrvCount(sq).toString(), yiYuan, k.trim(),j.trim(),z.trim(),c.trim()};
        String[] headers = new String[]{"�û�ID","����","����","�Ե�","CCBT","����֪","�������","ӥ��","HRV", "ҽԺ", "����","�����ҽ��","ר��ҽ��","����ʦ"};  
        try {  
            OutputStream out = response.getOutputStream();  
            exportExcel(excelName, count, headers, list, out,"yyyy-MM-dd");  
            out.close();  
        } catch (FileNotFoundException e) {  
                e.printStackTrace();  
        } catch (IOException e) {  
                e.printStackTrace();  
        }  
	}
	
	
    /** 
     *  
     * @Description: ����excel���������ͻ��ˣ����أ� 
     * @Auther: lujinyong 
     * @Date: 2013-8-22 ����3:05:49 
     */  
    protected void exportExcel(String title, String[] count, String[] headers,List<Map<String, Object>> mapList,OutputStream out,String pattern){  
        //����һ��������  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        //����һ�����  
        HSSFSheet sheet = workbook.createSheet(title);  
        //���ñ��Ĭ���п��Ϊ15���ַ�  
        sheet.setDefaultColumnWidth(20);  
        //����һ����ʽ���������ñ�����ʽ  
        HSSFCellStyle style = workbook.createCellStyle();  
        //������Щ��ʽ  
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);  
        style.setBorderBottom(CellStyle.BORDER_THIN);  
        style.setBorderLeft(CellStyle.BORDER_THIN);  
        style.setBorderRight(CellStyle.BORDER_THIN);  
        style.setBorderTop(CellStyle.BORDER_THIN);  
        style.setAlignment(CellStyle.ALIGN_CENTER);  
        //����һ������  
        HSSFFont font = workbook.createFont();  
        font.setColor(HSSFColor.VIOLET.index);  
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);  
        //������Ӧ�õ���ǰ����ʽ  
        style.setFont(font);  
        // ���ɲ�������һ����ʽ,��������������ʽ  
        HSSFCellStyle style2 = workbook.createCellStyle();  
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
        style2.setFillPattern(CellStyle.SOLID_FOREGROUND);  
        style2.setBorderBottom(CellStyle.BORDER_THIN);  
        style2.setBorderLeft(CellStyle.BORDER_THIN);  
        style2.setBorderRight(CellStyle.BORDER_THIN);  
        style2.setBorderTop(CellStyle.BORDER_THIN);  
        style2.setAlignment(CellStyle.ALIGN_CENTER);  
        style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
        // ������һ������  
        HSSFFont font2 = workbook.createFont();  
        font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);  
        // ������Ӧ�õ���ǰ����ʽ  
        style2.setFont(font2);
        HSSFRow row = sheet.createRow(0);  
        for(int i = 0; i<count.length;i++){  
            HSSFCell cell = row.createCell(i);  
            HSSFRichTextString text = new HSSFRichTextString(count[i]);  
            cell.setCellValue(text);  
        }
        
        //������������  
        row = sheet.createRow(1);
        for(int i = 0; i<headers.length;i++){  
            HSSFCell cell = row.createCell(i);  
            cell.setCellStyle(style);  
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);  
            cell.setCellValue(text);  
        }  
        for (int i=0;i<mapList.size();i++) {  
            Map<String,Object> map = mapList.get(i);  
            row = sheet.createRow(i+2);  
            int j = 0;  
            row.createCell(j++).setCellValue(map.get("�û�ID").toString());  
            row.createCell(j++).setCellValue(map.get("����").toString());  
            row.createCell(j++).setCellValue(map.get("����").toString());  
            row.createCell(j++).setCellValue(map.get("�Ե�").toString());  
            row.createCell(j++).setCellValue(map.get("CCBT").toString());  
            row.createCell(j++).setCellValue(map.get("����֪").toString());  
            row.createCell(j++).setCellValue(map.get("�������").toString());  
            row.createCell(j++).setCellValue(map.get("ӥ��").toString());  
            row.createCell(j++).setCellValue(map.get("HRV").toString());  
            row.createCell(j++).setCellValue(map.get("ҽԺ").toString());
            row.createCell(j++).setCellValue(map.get("����").toString());  
            try {
            	row.createCell(j++).setCellValue(map.get("�����ҽ��").toString());  
            } catch (Exception e) {
            	row.createCell(j).setCellValue("");  
            }
            row.createCell(j++).setCellValue(map.get("ר��ҽ��").toString());  
            row.createCell(j++).setCellValue(map.get("����ʦ").toString());  
        }  
        try {  
            workbook.write(out);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	
	//================================����������===============================
}
