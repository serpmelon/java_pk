package com.togo.java.data.algorithm.search;

import com.togo.java.data.algorithm.sort.QuickSort;
import com.togo.java.data.algorithm.util.ArrayUtil;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2019年06月05日 13:52
 * @since 1.0
 */
public class TestSearch {

    public static void main(String[] args) {

        int[] nums = ArrayUtil.createArray(10, 0, 5);
        QuickSort sort = new QuickSort();
        sort.sortAndPrint(nums);

        BinarySearch search = new BinarySearch();
        int result = search.searchFirstElement(nums, 2);
        System.out.println(result);
    }
}
