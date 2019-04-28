package com.togo.java.data.algorithm.util;

public class ArrayUtil {

	private ArrayUtil() {
	}

	/**
	 * 
	 * <p>
	 * Method ：swap
	 * <p>
	 * Description :交换数组中的两个元素
	 *
	 * @param nums
	 * @param i
	 * @param j
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月31日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public static void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * 
	 * <p>
	 * Method ：copySrc2Des
	 * <p>
	 * Description :将src数组copy到目标数组
	 *
	 * @param src
	 * @param des
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月31日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public static void copySrc2Des(Object[] src, int[] des) {

		for (int i = 0; i < des.length; i++) {

			des[i] = (int) src[i];
		}
	}
}
