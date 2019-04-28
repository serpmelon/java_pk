package com.togo.java.data.algorithm.sort;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.BubbleSort
 * <p>
 * Descdription:冒泡排序， 稳定，时间复杂度O(n^2)，空间复杂度O(1)
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月19日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class BubbleSort extends AbstractSort {

	@Override
	protected String getName() {
		return "BubbleSort 冒泡排序";
	}

	public void sort(int[] nums) {

		if (nums == null || nums.length == 0)
			return;
		if (nums.length == 1)
			return;

		for (int i = 0; i < nums.length; i++) {

			for (int j = 0; j < nums.length - i - 1; j++) {

				if (nums[j] > nums[j + 1]) {

					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
}
