package bit.arithmetic.demo.datastructure.sort_11;

import java.util.Arrays;

/**
 * create at:  2019-11-06  16:26
 *
 * @author : js
 * @description: 排序
 */
public class SortPrc {

    /**
     * 冒泡排序
     *
     * @param a
     * @return
     */
    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    //换位
                    a[j] = a[j + 1] ^ a[j];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j + 1] ^ a[j];
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return a;
    }

    /**
     * 插入排序
     *
     * @param n
     * @return 找到要插入的位置
     */
    public static int[] insertSort(int[] n) {
        for (int i = 1; i < n.length; i++) {
            int value = n[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (n[j] > value) {
                    n[j + 1] = n[j];
                } else {
                    break;
                }
            }
            n[j + 1] = value;
        }
        return n;
    }

    /**
     * 快速排序
     */
    public static int[] quickSort(int[] n) {

        return n;
    }

    /**
     * @param args
     */

    public static void main(String[] args) {
        int[] n = {3, 2, 1};
//        int[] ints = insertSort(n);
        int[] ints = bubbleSort(n);
        System.out.println(Arrays.toString(ints));
    }
}
