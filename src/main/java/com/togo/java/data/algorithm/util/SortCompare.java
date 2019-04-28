package com.togo.java.data.algorithm.util;

import com.togo.java.data.algorithm.sort.InsertionSort;
import com.togo.java.data.algorithm.sort.SelectionSort;

public class SortCompare {

	public static double time(String alg, int[] a) {

		StopWatch sw = new StopWatch();
		if (alg.equals("Insertion"))
			new InsertionSort().sort(a);
		if (alg.equals("Selection"))
			new SelectionSort().sort(a);

		return sw.elapsedTime();
	}
}
