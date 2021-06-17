package bit.arithmetic.demo.datastructure.dynamic_40;

/**
 * @author jiaosong
 * @desc 硬币凑钱问题
 * @date 2021/6/17
 */
public class CoinSolution {


    public static int coin(int amount) {
        if (amount < 1) {
            return Integer.MAX_VALUE;
        }
        if (amount == 1 || amount == 3 || amount == 5) {
            return 1;
        }
        return 1 + Math.min(Math.min(coin(amount - 1), coin(amount - 3)), coin(amount - 5));
    }

    public static void main(String[] args) {
        int coin = coin(10);
        System.out.println("result:" + coin);
    }
}
