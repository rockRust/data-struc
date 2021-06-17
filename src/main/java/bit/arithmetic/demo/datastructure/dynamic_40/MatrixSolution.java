package bit.arithmetic.demo.datastructure.dynamic_40;

/**
 * @author jiaosong
 * @desc
 * @date 2021/6/15
 */
public class MatrixSolution {

    static int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};

    static int[][] result = new int[4][4];

    /**
     * 状态表
     * 状态转移方程： dist[i][j] = matrix[i][j] + min(dist[i-1][j],dist[i][j-1])
     *
     * @return
     */
    public static int minDist(int line, int row) {
        if (line == 0 && row == 0) {
            return matrix[0][0];
        }
        if (result[line][row] != 0) {
            return result[line][row];
        }
        int minLeft = Integer.MAX_VALUE;
        if (line - 1 >= 0) {
            minLeft = minDist(line - 1, row);
        }
        int minUp = Integer.MAX_VALUE;
        if (row - 1 >= 0) {
            minUp = minDist(line, row - 1);
        }
        result[line][row] = matrix[line][row] + Math.min(minLeft, minUp);
        return result[line][row];
    }


    public static void main(String[] args) {
        int i = minDist(3, 3);
        System.out.println("result : " + i);
    }
}
