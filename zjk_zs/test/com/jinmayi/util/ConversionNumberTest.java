package com.jinmayi.util;

import org.junit.Test;

import com.jinmayi.entity.Enterprise;

public class ConversionNumberTest {

	@Test
	public void testConvertTo36() {
		long l = System.currentTimeMillis();
		System.out.println((int) l);
		System.out.println(l);
		System.out.println(ConversionNumber.ConvertTo36((int) System
				.currentTimeMillis()));

		String a = ConversionNumber.ConvertTo36(1);
		if (a.length() == 1) {
			a = 0 + a;
		}

		System.out.println(a);
		System.out.println("A0b3".toUpperCase());
	}

	@Test
	public void testConvertTo10() {
		System.out.println(ConversionNumber.ConvertTo10("RQ"));
		System.out.println(System.currentTimeMillis() / 1000);
		System.out.println(System.currentTimeMillis());
		System.out.println(new Long(System.currentTimeMillis() / 1000)
				.intValue());
		System.out.println(new Long(System.currentTimeMillis()).intValue());
	}

	@Test
	public void testNumber() {
		for (int i = 0; i < 4; i++) {
			System.out.println("a:" + getBit(3, i));
		}
		System.out.println(getBit(3, 2));
	}

	private static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);// true 表示第i位为1,否则为0
	}

	Enterprise enterprise = new Enterprise();

	@Test
	public void testPower() {
		Short a = 1;
		enterprise.setRole(a);

		if (enterprise.getBit(enterprise.getRole(), 0)) {
			System.out.println(enterprise.getRole());
		} else {
			System.out.println("ok");
		}
	}
}
