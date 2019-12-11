package bit.arithmetic.demo.datastructure.recall_39;

import java.util.Arrays;

/**
 * create at:  2019-12-09  17:23
 *
 * @author : js
 * @description:回溯算法的应用，八皇后问题
 */
public class EightQueen {

    int[] arr = new int[8];

    public void calc(int row) {
        if (row == 8) {
            printArray(arr);
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (isOk(i, row, arr)) {
                arr[row] = i;
                break;
            }
        }
        calc(++row);
    }

    private boolean isOk(int column, int row, int[] array) {
        for (int i = 0; i < row; i++) {
            if (array[i] == column || array[i] + row - i == column) {
                return false;
            }
        }
        return true;
    }

    private void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.calc(0);
    }
}
