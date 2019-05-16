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

		List<T> whichList = theLists[myhash(t)];
		if (!whichList.contains(t)) {

			whichList.add(t);

			if (++currentSize > theLists.length)
				rehash();
		}
	}

	public void remove(T t) {

		List<T> whichList = theLists[myhash(t)];
		if (whichList.contains(t)) {

			whichList.remove(t);
			currentSize--;
		}
	}

	public boolean contains(T t) {

		List<T> whichList = theLists[myhash(t)];

		return whichList.contains(t);
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
