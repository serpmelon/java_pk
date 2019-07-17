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

    public BinaryHeap() {

        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {

        array = (T[]) new Comparable[capacity];
    }

    public BinaryHeap(T[] items) {

        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (T t : items)
            array[i++] = t;

        buildHeap();
    }


    /**
     * <pre>
     * desc : Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @author : taiyn
     * date : 2019-07-16 08:50
     * @param t the element
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

    public boolean isEmpty() {

        return currentSize == 0;
    }

    public void makeEmpty() {

        if (currentSize > DEFAULT_CAPACITY)
            array = (T[]) new Comparable[currentSize];
        else
            array = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    /**
     * <pre>
     * desc : Remove the smallest item from the priority queue.
     * @author : taiyn
     * date : 2019-07-16 13:18
     * @param []
     * @return T
     * </pre>
     */
    public T deleteMin() {

        if (isEmpty())
            throw new RuntimeException();

        T t = findMin();
        array[1] = array[currentSize--];

        percolateDown(1);

        return t;
    }

    public T findMin() {

        if (array != null)
            return array[1];

        return null;
    }

    private void enlargeArray(int newSize) {

        int size = newSize;
        if (size > Integer.MAX_VALUE)
            size = Integer.MAX_VALUE;

        T[] largeArray = (T[]) new Comparable[size];
        int index = 0;
        for (T t : array) {

            largeArray[index++] = array[index];
        }

        array = largeArray;
    }

    /**
     * <pre>
     * desc : Internal method to percolate down in the heap
     * @author : taiyn
     * date : 2019-07-16 13:43
     * @param [hole]
     * @return void
     * </pre>
     */
    private void percolateDown(int hole) {

        int child = 0;
        T t = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {

            child = hole * 2;

            // 成立表示右子树更小
            if (array[child + 1].compareTo(array[child]) < 0) {

                child++;
            }

            if (array[child].compareTo(t) < 0) {

                array[hole] = array[child];
            } else {
                break;
            }
        }

        array[hole] = t;
    }

    private void buildHeap() {

        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }
}