package com.jinmayi.util;

import org.junit.Test;

public class StringTest {

	@Test
	public void testString() {
		String s = "���� Ů";
		System.out.println("0:" + (s.contains("��")&&s.contains("Ů")));
	}
	@Test
	public void testString1() {
		String s = "���� Ů";
		System.out.println("1:" + s.contains("��"));
	}
	@Test
	public void testString2() {
		String s = "���� Ů";
		System.out.println("2:" + s.contains("Ů"));
	}
}
