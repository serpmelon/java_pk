package com.togo.java.data.algorithm.sort;

import com.togo.java.data.algorithm.util.ArrayUtil;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.QuickSort
 * <p>
 * Descdription:快速排序，不稳定，时间复杂度nlogn，空间复杂度nlogn，空间复杂度是因为递归调用消耗的
 * 算法中的j是遍历游标，i是指向中间点的游标，每次遍历结束需要将中间值和区分点交换； 区分点取头结点，则交换的时候需要i -
 * 1，因为i指向的是值大于区分点，交换后该值就在区分点的左边了，所以需要 -
 * 1，而区分点选择尾节点则直接交换i，这是因为交换后i指向的元素还是在区分点右边。还有一种情况是区分点取头结点，头节点最大，
 * 则i最后指向末尾+1，所以也需要减1。使用尾节点当区分点逻辑比较清晰
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月20日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class QuickSort extends AbstractSort {

	@Override
	protected String getName() {
		return "QuickSort 快速排序";
	}

	@Override
	public void sort(int[] nums) {

		quickSort(nums, 0, nums.length - 1);
	}

	/**
	 * 
	 * <p>
	 * Method ：quickSort
	 * <p>
	 * Description :快排思想： 1、选择一个区分点（一般为数组尾节点或者头节点），将数组分成两部分 2、对每个部分重复1中的操作
	 * 3、直到数组不可分为止
	 *
	 * @param nums
	 * @param start
	 * @param end
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月17日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	private void quickSort(int[] nums, int start, int end) {

		// 当为一个元素的时候停止
		if (start >= end)
			return;

		// 返回区分点的位置
		int point = partition(nums, start, end);
		// 对两部分数组继续进行排序
		quickSort(nums, start, point - 1);
		quickSort(nums, point + 1, end);
	}

	/**
	 * 
	 * <p>
	 * Method ：partition
	 * <p>
	 * Description :取末尾为区分点
	 *
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月20日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	private int partition(int[] nums, int start, int end) {

		// 取默认为区分点
		int point = nums[end];
		// i指向的是没有排序的元素或者比区分点大的元素（从小到大排序的话）
		int i = start;
		for (int j = start; j < end; j++) {// 遍历数组

			if (nums[j] < point) {// 当元素比区分点小的时候

				// 交换改元素和i指向的元素
				ArrayUtil.swap(nums, i, j);
				// i指针移动，
				i++;
			}
		}

		// 交换区分点和i的位置，当前i指向的就是一个大于区分点的第一个元素，交换之后，区分点左面的都小于区分点
		ArrayUtil.swap(nums, i, end);

		return i;
	}

	/**
	 * 
	 * <p>
	 * Method ：partition
	 * <p>
	 * Description :以队首为区分点
	 *
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月20日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	// private int partition(int[] nums, int start, int end) {
	//
	// int point = nums[start];
	// int i = start + 1;
	// for (int j = start + 1; j <= end; j++) {
	//
	// if (nums[j] < point) {
	//
	// ArrayUtil.swap(nums, i, j);
	// i++;
	// }
	// }
	//
	// ArrayUtil.swap(nums, i - 1, start);
	//
	// return i - 1;
	// }
}
