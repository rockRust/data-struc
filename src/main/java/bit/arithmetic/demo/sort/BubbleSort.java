package bit.arithmetic.demo.sort;

/**
 * @author jiaosong
 * @desc
 * @date 2021/5/21
 */
public class BubbleSort {

    public static int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 2, 5, 9};
        int[] sort = bubble(arr);
        System.out.println(sort);
    }
}
