package com.util;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class ConfigUtil {
	// 声明properties对象
	private static Properties properties;

	static {
		// 初始化properties对象
		properties = new Properties();

		try {
			properties.load(ConfigUtil.class
					.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取对应配置的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getPropValue(String key) {
		return properties.getProperty(key);
	}

	@Test
	private void getPropValue() {
		String c1 = properties.getProperty("jdbc.name");
		String c2 = properties.getProperty("jdbc.pwd");
		System.out.println("name是：" + c1);
		System.out.println("pwd是：" + c2);
	}
}
