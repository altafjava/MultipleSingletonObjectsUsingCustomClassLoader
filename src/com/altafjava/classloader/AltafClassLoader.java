package com.altafjava.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AltafClassLoader extends ClassLoader {

	@Override
	public Class<?> findClass(String className) throws ClassNotFoundException {
		byte[] byteCode = loadClassData(className);
		return defineClass(className, byteCode, 0, byteCode.length);
	}

	public byte[] loadClassData(String className) {
		InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int i = 0;
		try {
			while ((i = is.read()) != -1) {
				bos.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

}
