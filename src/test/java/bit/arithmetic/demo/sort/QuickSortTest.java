package bit.arithmetic.demo.sort;

/**
 * @author jiaosong
 * @desc
 * @date 2021/6/9
 */
public class QuickSortTest {

    public static int[] quickSort(int[] arr, int head, int tail) {
        if (tail <= head) {
            return arr;
        }
        int k = arr[tail];
        int curr = head;
        for (int i = head; i < tail; i++) {
            if (arr[i] <= k) {
                swap(arr, i, curr);
                curr++;
            }
        }
        swap(arr, curr, tail);
        quickSort(arr, head, curr - 1);
        quickSort(arr, curr + 1, tail);
        return arr;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 6, 8, 2, 7, 1, 5, 4};
        int[] ints = quickSort(arr, 0, arr.length - 1);
        System.out.println(ints);
    }
}
