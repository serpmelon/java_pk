package com.togo.java.data.algorithm.sort;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.sort.AbstractSort
 * <p>
 * Descdription:排序抽象父类，主要是为了提供子排序方法公共展示方法
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
public abstract class AbstractSort {

	public abstract void sort(int[] nums);

	protected String getName() {

		return "default";
	}

	public void sortAndPrintInfo(int[] nums) {

		System.out.println("******************************");
		System.out.println("排序算法  :" + getName());
		long start = System.currentTimeMillis();
		sort(nums);
		long end = System.currentTimeMillis();
		System.out.println();
		long r = end - start;
		System.out.println("排序花费时间   " + r + " ms");
	}

	public void sortAndPrintInfoWithArray(int[] nums) {

		sortAndPrintInfo(nums);
		System.out.println("排序后结果");
		for (int i : nums)
			System.out.print(i + "  ");
		System.out.println();
	}

	public void sortAndPrint(int[] nums) {

		if (nums.length > 10)
			sortAndPrintInfo(nums);
		else
			sortAndPrintInfoWithArray(nums);

		if (isRight(nums))
			System.out.println("~~从小到大排序，结果正确~~~~~~");
		else
			System.out.println("@@从小到大排序，结果错误@@@@@@");
	}

	public boolean isRight(int[] nums) {

		if (nums.length == 1)
			return true;

		for (int i = 0, j = 1; i < nums.length && j < nums.length; i++, j++) {

			if (nums[i] > nums[j])
				return false;
		}

		return true;
	}
}
