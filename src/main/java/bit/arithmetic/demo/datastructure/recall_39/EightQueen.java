package bit.arithmetic.demo.datastructure.recall_39;

import java.util.Arrays;

/**
 * create at:  2019-12-09  17:23
 *
 * @author : js
 * @description:回溯算法的应用，八皇后问题 回溯就是循环内递归(类似于深度优先算法dfs)，这样每次递归判断失败后，会回到上一层此时i就相当于减1，
 * 回溯的效果就是能回到上一次的状态
 */
public class EightQueen {

    int[] arr = new int[8];

    public void calc(int row) {
        if (row >= 8) {
            printArray(arr);
        }
        for (int i = 0; i < 8; i++) {
            if (isOk(i, row, arr)) {
                arr[row] = i;
                calc(++row);
                // 清空标志位
                arr[row] = 0;
            }
        }
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
        EightQueen eightQueen = new EightQueen(4);
        eightQueen.calc(1);
    }


    private int[] column; //同栏是否有皇后，1表示有
    private int[] rup; //右上至左下是否有皇后
    private int[] lup; //左上至右下是否有皇后
    private int[] queen; //解答
    private int num; //解答编号

    public EightQueen() {
        column = new int[8 + 1];
        rup = new int[(2 * 8) + 1];
        lup = new int[(2 * 8) + 1];
        for (int i = 1; i <= 8; i++)
            column[i] = 0;
        for (int i = 1; i <= (2 * 8); i++)
            rup[i] = lup[i] = 0;  //初始定义全部无皇后
        queen = new int[8 + 1];
    }

    int n = 8;

    public EightQueen(int n) {
        this.n = n;
        column = new int[n + 1];
        rup = new int[(2 * n) + 1];
        lup = new int[(2 * n) + 1];
        for (int i = 1; i <= n; i++)
            column[i] = 0;
        for (int i = 1; i <= (2 * n); i++)
            rup[i] = lup[i] = 0;  //初始定义全部无皇后
        queen = new int[n + 1];
    }

    public void backtrack(int i) {
        if (i > n) {
            showAnswer();
        } else {
            for (int j = 1; j <= n; j++) {
                if ((column[j] == 0) && (rup[i + j] == 0) && (lup[i - j + n] == 0)) {
                    //若无皇后
                    queen[i] = j; //设定为占用
                    column[j] = rup[i + j] = lup[i - j + n] = 1;
                    backtrack(i + 1);  //循环调用
                    column[j] = rup[i + j] = lup[i - j + n] = 0;
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("answer:" + num);
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (queen[y] == x) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        Queen queen = new Queen();
//        queen.backtrack(1);
//    }
}
