package com.togo.java.data.algorithm.sort;

import java.util.Random;

public class TestSort {

	private static Random random = new Random();

	public static void main(String[] args) {

		int n = 7;
		int[] a = createArray(n, 0, 1000);

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

	/**
	 * 
	 * <p>
	 * Method ：createArray
	 * <p>
	 * Description :
	 *
	 * @param n
	 *            数组长度
	 * @param min
	 *            数组中最小值
	 * @param max
	 *            数组中最大值
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月31日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public static int[] createArray(int n, int min, int max) {

		int[] a = new int[n];
		if (n <= 10)
			System.out.println("create array :");
		for (int i = 0; i < n; i++) {

			a[i] = random.nextInt(max - min) + min;
			if (n <= 10)
				System.out.print(a[i] + " ");
		}

		System.out.println();
		return a;
	}
}
