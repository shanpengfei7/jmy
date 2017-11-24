package com.jinmayi.util;

import org.junit.Test;

public class ShortTest {
	Short s = null;
	@Test
	public void testShort() {
		Short h = 3;
		setS(h);
		System.out.println(s);
//		System.out.println(s.getClass().getTypeName());
	}
	public Short getS() {
		return s;
	}
	public void setS(Short s) {
		this.s = s;
	}
	@Test
	public void a() {
		double a = 1/2;
		System.out.println(a);
	}
}
