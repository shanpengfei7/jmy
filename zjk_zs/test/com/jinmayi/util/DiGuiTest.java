package com.jinmayi.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DiGuiTest {

	@Test
	public void testDiGui() {
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(3);
		integers.add(4);
		integers.add(5);
		System.out.println(add(integers));
	}
	
	public int add(List<Integer> integers) {
		
		return 0;
	}
	
	public int fib(int index) {
		if (index == 1 || index == 2) {
			return 1;
		} else {
			return fib(index - 1) + fib(index - 2);
		}
	}
}
