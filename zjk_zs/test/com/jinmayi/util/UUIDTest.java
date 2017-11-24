package com.jinmayi.util;

import java.util.UUID;

import org.junit.Test;

public class UUIDTest {

	@Test
	public void testUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		System.out.println(uuid);
	}
}
