package com.jinmayi.util;

import org.junit.Test;

public class StringTest {

	@Test
	public void testString() {
		String s = "李男 女";
		System.out.println("0:" + (s.contains("男")&&s.contains("女")));
	}
	@Test
	public void testString1() {
		String s = "李男 女";
		System.out.println("1:" + s.contains("男"));
	}
	@Test
	public void testString2() {
		String s = "李男 女";
		System.out.println("2:" + s.contains("女"));
	}
}
