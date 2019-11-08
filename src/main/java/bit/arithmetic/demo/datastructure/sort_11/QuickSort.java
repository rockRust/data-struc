package bit.arithmetic.demo.datastructure.sort_11;

import java.util.Arrays;

/**
 * create at:  2019-11-08  11:15
 *
 * @author : js
 * @description: 快速排序
 */
public class QuickSort {

    public static int[] quickSort(int[] n) {
        quickSortPart(n, 0, n.length - 1);
        return n;
    }

    /**
     * @param n 要排序的数组
     * @param p 要排序起始位置
     * @param r 要排序的结束位置
     */
    public static void quickSortPart(int[] n, int p, int r) {
        if (p >= r) return;
        //以这个值为分隔点
//        int value = n[r];
//        //标记要插入的位置
//        int j = p;
//        for (int i = p; i < r; i++) {
//            if (n[i] < value) {
//                //将该值与i位的swap
//                if (i == j) {
//                    j++;
//                } else {
//                    n[j] = n[i] ^ n[j];
//                    n[i] = n[i] ^ n[j];
//                    n[j] = n[i] ^ n[j];
//                    j++;
//                }
//            }
//        }
//        //将n[r] 与n[i] swap
//        n[r] = n[j];
//        n[j] = value;
        int j = partition(n, p, r);
        quickSortPart(n, 0, j - 1);
        quickSortPart(n, j + 1, r);
    }

    /**
     * 找出数组中第k大的数
     *
     * @param n
     * @param k
     * @return
     */
    public static int findKth(int[] n, int k, int p, int r) {
        int partition = partition(n, p, r);
        if (partition == k - 1) return n[partition];
        if (partition > k - 1) {
            findKth(n, k, 0, partition - 1);
        }
        if (partition < k - 1) {
            findKth(n, k - partition - 1, partition + 1, r);
        }
        return n[k - 1];
    }


    public static int findKth(int[] n, int k) {
        return findKth(n, k, 0, n.length - 1);
    }

    /**
     * 以数组的最后一位为间隔点，分成前后两部分，前面的是小于间隔点的，后半部分是大于间隔点的
     *
     * @param n
     * @return
     */
    public static int partition(int[] n, int p, int r) {
        int partition = n[r];
        int j = p;
        for (int i = p; i < r; i++) {
            if (n[i] > partition) {
                if (i == j) {
                    j++;
                } else {
                    n[i] = n[j] ^ n[i];
                    n[j] = n[j] ^ n[i];
                    n[i] = n[j] ^ n[i];
                    j++;
                }
            }
        }
        n[r] = n[j];
        n[j] = partition;
        return j;
    }

    public static void main(String[] args) {
//        int[] n = {8, 5, 7, 1, 6, 2, 6};
        int[] n = {1, 1, 2};
        int[] ints = quickSort(n);
        System.out.println(Arrays.toString(ints));
        int kth = findKth(n, 2);
        System.out.println(kth);
    }
}
