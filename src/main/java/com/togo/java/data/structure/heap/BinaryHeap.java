package com.togo.java.data.structure.heap;

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
 * @date Created in 2019年07月16日 08:21
 * @since 1.0
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private T[] array;

    /**
     * <pre>
     * desc : Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @author : taiyn
     * date : 2019-07-16 08:50
     * @param [t]
     * @return void
     * </pre>
     */
    public void insert(T t) {

        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);

        int hole = ++currentSize;
        // hole / 2获取到的就是它的父节点。
        for (array[0] = t; t.compareTo(array[hole / 2]) < 0; hole /= 2) {

            array[hole] = array[hole / 2];
        }

        array[hole] = t;
    }

    private void enlargeArray(int newSize) {
    }
}