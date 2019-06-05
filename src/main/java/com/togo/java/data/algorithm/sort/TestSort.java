package com.togo.java.data.algorithm.sort;

import com.togo.java.data.algorithm.util.ArrayUtil;

import java.util.Random;

public class TestSort {



	public static void main(String[] args) {

		int n = 7;
		int[] a = ArrayUtil.createArray(n, 0, 1000);

		AbstractSort sort = new BubbleSort();
		sort.sortAndPrint(a.clone());

		sort = new InsertionSort();
		sort.sortAndPrint(a.clone());

		sort = new SelectionSort();
		sort.sortAndPrint(a.clone());

		sort = new MergeSort();
		sort.sortAndPrint(a.clone());

		sort = new QuickSort();
		sort.sortAndPrint(a.clone());

//		sort = new BucketSort();
//		sort.sortAndPrint(a.clone());
	}


}
