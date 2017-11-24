package com.jmy.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

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

import com.jmy.entity.son.TaxSon;

public class ExcelTools {
	public static void exportExcel(String title, String[] headers, List<TaxSon> taxs,
			OutputStream out) {
		//声明一个工作簿  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        //生成一个表格  
        HSSFSheet sheet = workbook.createSheet("Sheet1");  
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
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);

		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		for (int i = 0; i < taxs.size(); i++) {
			TaxSon t = taxs.get(i);
			row = sheet.createRow(i + 1);
			int j = 0;
			row.createCell(j++).setCellValue(t.getNowTimeSon());
			row.createCell(j++).setCellValue(t.getAddTimeSon());
			row.createCell(j++).setCellValue(t.getFlag());
			row.createCell(j++).setCellValue(t.getIdCode());
			row.createCell(j++).setCellValue(t.getName());
			row.createCell(j++).setCellValue(t.getSwjgDm());
			row.createCell(j++).setCellValue(t.getSwjgMc());
			row.createCell(j++).setCellValue(t.getTotal() + "");
			row.createCell(j++).setCellValue(t.getYingys() + "");
			row.createCell(j++).setCellValue(t.getQysds() + "");
			row.createCell(j++).setCellValue(t.getGrsds() + "");
			row.createCell(j++).setCellValue(t.getZys() + "");
			row.createCell(j++).setCellValue(t.getYjs() + "");
			row.createCell(j++).setCellValue(t.getFcs() + "");
			row.createCell(j++).setCellValue(t.getYhs() + "");
			row.createCell(j++).setCellValue(t.getTdsys() + "");
			row.createCell(j++).setCellValue(t.getTdzzs() + "");
			row.createCell(j++).setCellValue(t.getCcs() + "");
			row.createCell(j++).setCellValue(t.getYanys() + "");
			row.createCell(j++).setCellValue(t.getGdzys() + "");
			row.createCell(j++).setCellValue(t.getQs() + "");
			row.createCell(j++).setCellValue(t.getZzs() + "");
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
