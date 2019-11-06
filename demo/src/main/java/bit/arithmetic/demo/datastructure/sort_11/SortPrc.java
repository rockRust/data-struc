package bit.arithmetic.demo.datastructure.sort_11;

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
     * @return
     */
    public static int[] insertSort(int[] n) {
        for (int i = 1; i < n.length; i++) {
            int value = n[i];
            int j = i;
            for (; j > 0; j--) {
                if (n[j - 1] > value) {
                    //换位
                    n[j] = n[j - 1];
                } else {
                    break;
                }
            }
            n[j] = value;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 1};
        int[] ints = insertSort(n);
        System.out.println(ints);
    }
}
