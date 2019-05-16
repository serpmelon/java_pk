package com.togo.java.data.structure.hashing;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<T> {

	private static final int DEFAULT_TABLE_SIZE = 101;
	private List<T>[] theLists;
	private int currentSize;

	public SeparateChainingHashTable() {

		this(DEFAULT_TABLE_SIZE);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int size) {

		theLists = new LinkedList[nextPrime(size)];
		for (int i = 0; i < theLists.length; i++)
			theLists[i] = new LinkedList<>();
	}

	public void insert(T t) {

	}

	public void remove(T t) {

	}

	public boolean contains(T t) {

		// TODO
		return false;
	}

	public void makeEmpty() {

	}

	private void rehash() {

	}

	private int myhash(T t) {

		int hashVal = t.hashCode();
		hashVal %= theLists.length;

		if (hashVal < 0)
			hashVal += theLists.length;

		return hashVal;
	}

	private static int nextPrime(int n) {

	}

	private static boolean isPrime(int n) {

	}
}
