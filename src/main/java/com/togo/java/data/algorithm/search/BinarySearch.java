package com.togo.java.data.algorithm.search;

/**
 * <p>binary search code for test</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2019年06月05日 13:44
 * @since 1.0
 */
public class BinarySearch {

    /**
     * <pre>
     * desc : 查找出现的第一个制定元素
     * @author : taiyn
     * date : 2019/6/5 13:46
     * @param nums, target
     * @return int
     * </pre>
     */
    public int searchFirstElement(int[] nums, int target) {

        int length = nums.length;
        int high = length - 1;
        int low = 0;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (nums[mid] > target) {

                high = mid - 1;
            } else if (nums[mid] < target) {

                low = mid + 1;
            } else {

                if ((mid == 0) || nums[mid - 1] != target)
                    return mid;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    public int searchLastElement(int[] nums, int target){

        int length = nums.length;
        int high = length - 1;
        int low = 0;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (nums[mid] > target) {

                high = mid - 1;
            } else if (nums[mid] < target){

                low = mid + 1;
            } else {

                if ((mid == length - 1) || nums[mid + 1] != target)
                    return mid;
                else
                    low = mid + 1;
            }
        }

        return -1;
    }
}
