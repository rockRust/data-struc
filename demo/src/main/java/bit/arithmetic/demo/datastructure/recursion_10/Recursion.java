package bit.arithmetic.demo.datastructure.recursion_10;

/**
 * create at:  2019-11-06  15:07
 *
 * @author : js
 * @description: 递归，先写出递归公式，再找出中止条件
 */
public class Recursion {
    /**
     * 有七个台阶，每次可以走一个或两个，有多少种走法
     * 递归公式 f(n) = f(n-1)+f(n-2)
     * 中止条件 f(1) = 1,f(2) = 2;
     */
    public static int methodNum(int stepNum) {
        if (stepNum == 1) return 1;
        if (stepNum == 2) return 2;
        return methodNum(stepNum - 1) + methodNum(stepNum - 2);
    }

    public static void main(String[] args) {
        int i = methodNum(7);
        System.out.println(i);
    }

}
