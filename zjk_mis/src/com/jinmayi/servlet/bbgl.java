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
 * 报表管理
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
	 * 专科医生
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
			ys = yiShengDao.getZhuanKesByKeShiId(id.trim(), "专科医生", "专科主任");
		} else {
			ys = yiShengDao.getZhuanKesByKeShiId(id.trim(), "专科医生", "专科主任", session);
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
	 * 科室
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
	 * 精神科医生
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
			jsk = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "精神科医生", "精神科主任");
		} else {
			jsk = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "精神科医生", "精神科主任", session);
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
	 * 测评师
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
		
		List<YiSheng> cps = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "测评师", "测评师");
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
			List<YiSheng> jsk = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "精神科医生", "精神科主任");
			List<YiSheng> cps = yiShengDao.getYiShengsByYiYuanId(yiYuanId, "测评师", "测评师");
			request.setAttribute("ks", ks);
			request.setAttribute("jsk", jsk);
			request.setAttribute("cps", cps);
		} else if(qx == 6) {
			List<YiSheng> ys = yiShengDao.getZhuanKesByKeShiId(session.getAttribute("keShi").toString(), "专科医生", "专科主任", session);
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
	//================================报表导出===============================
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
            map.put("用户ID",jc.getYongHuId());  
            map.put("姓名",jc.getXingMing()); 
            map.put("日期",jc.getRiQi()); 
            if(jc.getNaoDian()) {
            	map.put("脑电", 1); 
            } else {
            	map.put("脑电", 0); 
			}
            if(jc.getCcbt()) {
            	map.put("CCBT", 1); 
            } else {
            	map.put("CCBT", 0); 
			}
            if(jc.getNaoRenZhi()) {
            	map.put("脑认知", 1); 
            } else {
            	map.put("脑认知", 0); 
			}
            if(jc.getXinLiCePing()) {
            	map.put("心理测评", 1); 
            } else {
            	map.put("心理测评", 0); 
			}
            if(jc.getYingYan()) {
            	map.put("鹰演", 1); 
            } else {
            	map.put("鹰演", 0); 
			}
            if(jc.getHrv()) {
            	map.put("HRV", 1); 
            } else {
            	map.put("HRV", 0); 
			}
            if((Integer)request.getSession().getAttribute("quanxian") == 1) {
    			for (YiYuan yy : yiYuans) {
					if(yy.getId() == jc.getYiYuanId()) {
						map.put("医院", yy.getMingCheng()); 
						continue;
					} else {
						map.put("医院", ""); 
						continue;
					}
				}    
    		} else {
    			map.put("医院", request.getSession().getAttribute("yiYuanMingCheng")); 
			}
            map.put("科室",jc.getKeShi()); 
            map.put("精神科医生",jc.getJingShenKeYiSheng()); 
            map.put("专科医生",jc.getZhuanKeYiSheng()); 
            map.put("测评师",jc.getCePingShi()); 
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
		String excelName = "报表" + format.format(Calendar.getInstance().getTime());  
        //转码防止乱码  
        response.addHeader("Content-Disposition", "attachment;filename="+new String( excelName.getBytes("gb2312"), "ISO8859-1" )+".xls");  
        String[] count = new String[]{"次数","","",jianCeXiangMuDao.getNaoDianCount(sq).toString(),
        		jianCeXiangMuDao.getCcbtCount(sq).toString(),jianCeXiangMuDao.getNaoRenZhiCount(sq).toString(),
        		jianCeXiangMuDao.getXinLiCePingCount(sq).toString(),jianCeXiangMuDao.getYingYanCount(sq).toString(),
        		jianCeXiangMuDao.getHrvCount(sq).toString(), yiYuan, k.trim(),j.trim(),z.trim(),c.trim()};
        String[] headers = new String[]{"用户ID","姓名","日期","脑电","CCBT","脑认知","心理测评","鹰演","HRV", "医院", "科室","精神科医生","专科医生","测评师"};  
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
     * @Description: 生成excel并导出到客户端（本地） 
     * @Auther: lujinyong 
     * @Date: 2013-8-22 下午3:05:49 
     */  
    protected void exportExcel(String title, String[] count, String[] headers,List<Map<String, Object>> mapList,OutputStream out,String pattern){  
        //声明一个工作簿  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        //生成一个表格  
        HSSFSheet sheet = workbook.createSheet(title);  
        //设置表格默认列宽度为15个字符  
        sheet.setDefaultColumnWidth(20);  
        //生成一个样式，用来设置标题样式  
        HSSFCellStyle style = workbook.createCellStyle();  
        //设置这些样式  
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);  
        style.setBorderBottom(CellStyle.BORDER_THIN);  
        style.setBorderLeft(CellStyle.BORDER_THIN);  
        style.setBorderRight(CellStyle.BORDER_THIN);  
        style.setBorderTop(CellStyle.BORDER_THIN);  
        style.setAlignment(CellStyle.ALIGN_CENTER);  
        //生成一个字体  
        HSSFFont font = workbook.createFont();  
        font.setColor(HSSFColor.VIOLET.index);  
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);  
        //把字体应用到当前的样式  
        style.setFont(font);  
        // 生成并设置另一个样式,用于设置内容样式  
        HSSFCellStyle style2 = workbook.createCellStyle();  
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
        style2.setFillPattern(CellStyle.SOLID_FOREGROUND);  
        style2.setBorderBottom(CellStyle.BORDER_THIN);  
        style2.setBorderLeft(CellStyle.BORDER_THIN);  
        style2.setBorderRight(CellStyle.BORDER_THIN);  
        style2.setBorderTop(CellStyle.BORDER_THIN);  
        style2.setAlignment(CellStyle.ALIGN_CENTER);  
        style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
        // 生成另一个字体  
        HSSFFont font2 = workbook.createFont();  
        font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);  
        // 把字体应用到当前的样式  
        style2.setFont(font2);
        HSSFRow row = sheet.createRow(0);  
        for(int i = 0; i<count.length;i++){  
            HSSFCell cell = row.createCell(i);  
            HSSFRichTextString text = new HSSFRichTextString(count[i]);  
            cell.setCellValue(text);  
        }
        
        //产生表格标题行  
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
            row.createCell(j++).setCellValue(map.get("用户ID").toString());  
            row.createCell(j++).setCellValue(map.get("姓名").toString());  
            row.createCell(j++).setCellValue(map.get("日期").toString());  
            row.createCell(j++).setCellValue(map.get("脑电").toString());  
            row.createCell(j++).setCellValue(map.get("CCBT").toString());  
            row.createCell(j++).setCellValue(map.get("脑认知").toString());  
            row.createCell(j++).setCellValue(map.get("心理测评").toString());  
            row.createCell(j++).setCellValue(map.get("鹰演").toString());  
            row.createCell(j++).setCellValue(map.get("HRV").toString());  
            row.createCell(j++).setCellValue(map.get("医院").toString());
            row.createCell(j++).setCellValue(map.get("科室").toString());  
            try {
            	row.createCell(j++).setCellValue(map.get("精神科医生").toString());  
            } catch (Exception e) {
            	row.createCell(j).setCellValue("");  
            }
            row.createCell(j++).setCellValue(map.get("专科医生").toString());  
            row.createCell(j++).setCellValue(map.get("测评师").toString());  
        }  
        try {  
            workbook.write(out);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	
	//================================报表导出结束===============================
}
