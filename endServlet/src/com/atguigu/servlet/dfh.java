package com.atguigu.servlet;

import java.util.HashSet;
import java.util.Iterator;

public class dfh {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("a");
		hashSet.add("n");
		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
			
		}
	}
}
