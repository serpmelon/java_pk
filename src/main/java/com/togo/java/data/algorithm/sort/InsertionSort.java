package com.togo.java.data.algorithm.sort;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.InsertionSort
 * <p>
 * Descdription:插入排序，稳定，时间复杂度n^2，空间复杂度1
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
public class InsertionSort extends AbstractSort {

	@Override
	protected String getName() {
		return "InsertionSort 插入排序";
	}

	/**
	 * 将当前值插入到前面已经排好序的队列中
	 */
	@Override
	protected void sort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {

			// pre始终指向小于当前值得下标
			int pre = i - 1;
			int current = nums[i];
			while (pre >= 0 && nums[pre] > current) {

				// 下边的操作实际上就是把数字向后移动
				nums[pre + 1] = nums[pre];
				pre--;
			}

			// 循环结束，pre要么=-1表示当前值是目前最小值，pre+1=0，将当前值放到0的位置上
			// 或者pre>-1，表示指向的值小于当前值，所以需要把当前值放到pre后面，即pre+1处
			nums[pre + 1] = current;
		}
	}

}
