package com.togo.java.data.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.togo.java.data.algorithm.util.ArrayUtil;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.BucketSort
 * <p>
 * Descdription:桶排序，稳定，时间复杂度n，空间复杂度n + k
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月21日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class BucketSort extends AbstractSort {

	private final int BUCKET_SIZE = 5;

	@Override
	protected String getName() {

		return "BucketSort 桶排序";
	}

	// TODO 还有问题
	@Override
	public void sort(int[] nums) {

		int max = nums[0];
		int min = nums[0];

		for (int i : nums) {

			if (i < min)
				min = i;
			else if (i > max)
				max = i;
		}

		int bucketCap = (max - min) / BUCKET_SIZE + 1;
		List<Integer>[] buckets = new List[BUCKET_SIZE];

		for (int i : nums) {

			int index = (i - min) / bucketCap;
			if (buckets[index] == null)
				buckets[index] = new ArrayList<>();
			buckets[index].add(i);
		}

		for (int j = 0; j < buckets.length; j++) {

			List<Integer> list = buckets[j];
			if (list == null)
				break;
			Integer[] arr = list.toArray(new Integer[0]);
			int[] temp = new int[arr.length];
			ArrayUtil.copySrc2Des(arr, temp);

			QuickSort qs = new QuickSort();
			qs.sort(temp);

			for (int i = 0; i < temp.length; i++) {

				nums[j * bucketCap + i] = temp[i];
			}
		}
	}
}
