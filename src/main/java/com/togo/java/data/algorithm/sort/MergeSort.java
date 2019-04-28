package com.togo.java.data.algorithm.sort;

import java.util.Arrays;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.MergeSort
 * <p>
 * Descdription:归并排序，稳定，时间复杂度O(nlogn)，空间复杂度O(n)
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
public class MergeSort extends AbstractSort {

	@Override
	protected String getName() {
		return "MergeSort 归并排序";
	}
	
	@Override
	public void sort(int[] nums) {

		mergeSort(nums, 0, nums.length - 1);
	}

	private void mergeSort(int[] nums, int i, int j) {

		if (i >= j)
			return;

		int p = (i + j) / 2;

		mergeSort(nums, i, p);
		mergeSort(nums, p + 1, j);

		int[] left = Arrays.copyOfRange(nums, i, p + 1);
		int[] right = Arrays.copyOfRange(nums, p + 1, j + 1);

		merge(nums, left, right, i);
	}

	private void merge(int[] nums, int[] left, int[] right, int start) {

		int[] temp = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		for (; i < left.length && j < right.length; k++) {

			if (left[i] <= right[j]) {

				temp[k] = left[i];
				i++;
			} else {
				temp[k] = right[j];
				j++;
			}
		}

		while (i < left.length) {

			temp[k++] = left[i++];
		}

		while (j < right.length) {

			temp[k++] = right[j++];
		}

		for (int x : temp) {

			nums[start++] = x;
		}
	}
}
