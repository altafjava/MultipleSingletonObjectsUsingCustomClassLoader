package com.altafjava.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.altafjava.classloader.AltafClassLoader;
import com.altafjava.pattern.Singleton;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

		AltafClassLoader altafClassLoader = new AltafClassLoader();
		Class<?> singletonClass = altafClassLoader.findClass("com.altafjava.pattern.Singleton");
		Constructor<?> constructor = singletonClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object object = constructor.newInstance();
		System.out.println("Using Custom ClassLoader= " + object);
		
		AltafClassLoader altafClassLoader2 = new AltafClassLoader();
		Class<?> singletonClass2 = altafClassLoader2.findClass("com.altafjava.pattern.Singleton");
		constructor = singletonClass2.getDeclaredConstructor();
		constructor.setAccessible(true);
		object = constructor.newInstance();
		System.out.println("Using Custom ClassLoader= " + object);

		Class<Singleton> clazz = Singleton.class;
		Constructor<Singleton> constructor2 = clazz.getDeclaredConstructor();
		constructor2.setAccessible(true);
		Singleton singleton3 = constructor2.newInstance();
		System.out.println("Using Reflection= " + singleton3);

		Singleton singleton = Singleton.getInstance();
		System.out.println("Using getInstance()= " + singleton);
		Singleton singleton2 = Singleton.getInstance();
		System.out.println("Using getInstance()= " + singleton2);
	}
}
