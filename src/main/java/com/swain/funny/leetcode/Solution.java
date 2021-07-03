package com.swain.funny.leetcode;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯
// 👍 1229 👎 0

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }

        System.out.println("===================");
        List<List<Integer>> res2 = subsets2(nums);
        for (List<Integer> re : res2) {
            System.out.println(re);
        }
    }


    /**
     * 每个数有两种情况，取或者不取。所以一共有2的n次方种解法。
     * 可以联想到二进制来表示，所以遍历0到2^n-1，然后将其转为二进制字符串。二进制位上为1的就取，不为1的就不取。
     * 但是有个问题，java的Integer.toBinaryString函数，前面不会补0，只会保留最高位0，所以倒着取。
     * 要计算一下二进制的长度，与num的长度，取个差值，最后才能索引回去其在num里的原始位置。不然最高位一直都是1，num索引0也一直存在。
     * ————————————————
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length;
        int m = (int)Math.pow(2, l);
//        System.out.println("l:" + l + " m:"+m);
        for (int i = 0; i < m; i++){
            String b = Integer.toBinaryString(i);
//            System.out.println("i:"+i+" b:" + b);
            int re = nums.length - b.length();
            List<Integer> list = new ArrayList<>();
            for (int j = b.length() - 1; j >= 0; j--){
                if (b.charAt(j) == '1'){
                    list.add(nums[j + re]); // 索引回去
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 借鉴上述思路
     * 每个数有两种情况，取或者不取。所以一共有2的n次方种解法。
     * 可以联想到二进制来表示，所以遍历0到2^n-1，然后将其转为二进制字符串。
     * 二进制字符串上每位倒序对应原数组下标；二进制位上为1的就取，不为1的就不取。
     * 但是有个问题，java的Integer.toBinaryString函数，前面不会补0，只会保留最高位0，所以倒着取。
     * 因为倒序对应，索引回原数组下标为：s.length()-1-j
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Integer l = nums.length;
        int n = (int) Math.pow(2, l); //结果集个数

        for (int i = 0; i<n; i++) {
            String s = Integer.toBinaryString(i); //二进制字符串
            List<Integer> temp = new ArrayList<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '1') {
//                    System.out.println("j:"+j);
                    temp.add(nums[s.length()-1-j]); //索引数组下标
                }
            }
            result.add(temp);
        }
        return result;
    }
}
