package bit.arithmetic.demo.datastructure.headTree_28;

import java.util.Arrays;

/**
 * create at:  2019-11-20  16:39
 *
 * @author : js
 * @description: 堆与堆排序
 */
public class HeadTree {

    private int[] rep;

    /**
     * 数组长度
     */
    private int size;

    /**
     * 当前元素数量
     */
    private int currentSize;

    /**
     * 笔记
     * 堆的api 插入与删除堆顶元素
     * 堆排序方法：1.建堆 2.排序
     */
    public HeadTree(int capacity) {
        rep = new int[capacity];
        size = capacity;
        currentSize = 0;
    }

    /**
     * 插入元素
     * 思路：先插到最后，然后跟父节点比较，直到小于父节点停止交换
     *
     * @param value
     */
    public void insert(int value) {
        //满了
        if (size - currentSize <= 1) return;
        int i = ++currentSize;
        rep[i] = value;
        //开始与父节点比较，父节点就是角标/2
        while (rep[i >> 1] < value && i >> 1 > 0) {
            swap(rep, i / 2, i);
            i = i >> 1;
        }
    }

    /**
     * 交换arr中角标为i，j的两数
     *
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 删除堆顶元素，对于大顶堆来说就是拿最大的元素
     * 思路：将最后一个元素放到堆顶，然后与子节点中较大的swap，一直到恢复正常的堆
     */
    private void delete() {
        rep[1] = rep[currentSize];
        rep[currentSize--] = 0;
        heapify(rep, rep[1], 1);
    }

    /**
     * 对于插入一个值的堆化
     *
     * @param arr
     * @param value 要插入的值
     * @param i     所处的位置
     */
    private void heapify(int[] arr, int value, int i) {
        int maxPos = i;
        if (i << 1 < size && arr[i << 1] > arr[maxPos]) {
            maxPos = i << 1;
        }

        if ((i << 1) + 1 < size && arr[(i << 1) + 1] > arr[maxPos]) {
            maxPos = (i << 1) + 1;
        }

        if (maxPos == i) {
            return;
        }
        swap(arr, i, maxPos);
        heapify(arr, value, maxPos);
    }

    public int[] sort(int[] arr) {
//        HeadTree headTree = buildHead(arr);
        return arr;
    }

    /**
     * 将无序数组变成一个堆
     *
     * @param arr
     */
    private void buildHead(int[] arr) {

    }

    public void print() {
        System.out.println(Arrays.toString(rep));
    }


    public static void main(String[] args) {
//        HeadTree h1 = new HeadTree(10);
//        h1.insert(5);
//        h1.insert(4);
//        h1.insert(6);
//        h1.insert(7);
//        h1.insert(9);
//        h1.insert(1);
//        h1.print();
//        h1.delete();
//        h1.print();
//        h1.delete();
//        h1.print();
//        h1.delete();
//        h1.print();

        String s1 = "9";
        String s2 = "90";
        System.out.println(s1.compareTo(s2));
        s2 = "1";
        System.out.println(s1.compareTo(s2));
    }
}
