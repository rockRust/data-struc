package bit.arithmetic.demo.leetcode;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author jiaosong
 * @desc
 * @date 2021/2/20
 */
public class TwoSum {

    public static List<Integer> findTwoNums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num2 = target - nums[i];
            if (Objects.isNull(map.get(num2))) {
                map.put(nums[i], i);
            } else {
                return Lists.newArrayList(map.get(num2), i);
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 10, 13};
        int target = 17;
        List<Integer> twoNums = findTwoNums(nums, target);
        System.out.println(twoNums);
    }
}
