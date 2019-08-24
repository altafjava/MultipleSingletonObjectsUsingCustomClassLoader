package com.altafjava.pattern;

public class Singleton {

	private static Singleton instance = null;

	int count = 0;

	private Singleton() {
		// if we remove these two lines then anyone can create multiple object using Reflection
		if (instance != null) {
			throw new IllegalAccessError("Object already created");
		}
		// if we are not writing this line then using reflection we can create multiple objects
		instance = this;
	}

	public static final synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
