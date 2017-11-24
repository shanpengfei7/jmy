package com.jmy.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ����ҳ�� jstlʱ���ʽ��s Created by gmq on 2016/5/24.
 */
public class DateTag extends TagSupport {

	private static final long serialVersionUID = 6464168398214506236L;

	private String value;

	@Override
	public int doStartTag() throws JspException {
		String vv = "" + value;
		if (!vv.equals("")) {
			try {
				long time = Long.valueOf(vv.trim());
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(time);
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = dateformat.format(c.getTime());
				pageContext.getOut().write(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return super.doStartTag();
	}

	public void setValue(String value) {
		this.value = value;
	}

}