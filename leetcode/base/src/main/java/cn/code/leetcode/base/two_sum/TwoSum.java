package cn.code.leetcode.base.two_sum;

/**
 * @author: leihang@live.cn
 * @date: 2016-09-30 11:18
 * @description:
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;
        int[] result = twoSum(nums, target);
        System.out.println("result:" + result[0] + ":" + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] total = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = (i + 1); j < nums.length; j++) {
                int current = nums[j];
                if ((first + current) == target) {
                    total[0] = i;
                    total[1] = j;
                    break;
                }
            }
        }
        return total;
    }
}
