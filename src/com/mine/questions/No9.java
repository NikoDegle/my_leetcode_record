package com.mine.questions;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class No9 implements Question {
    @Override
    public void run() {
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.isPalindrome(-10));
    }

    /**
     * 解决方法一，数字转换为字符串进行比较
     */
    class Solution1 {
        public boolean isPalindrome(int x) {
            //首先判断示例2中的负数
            if (x < 0){
                return false;
            }

            StringBuffer stringBuffer = new StringBuffer();
            while (x > 0){
                stringBuffer.append(x % 10);
                x = x / 10;
            }

            //如果字符串倒转之后和现在的串一致则说明该数字为回文
            String result = stringBuffer.toString();
            if (stringBuffer.reverse().toString().equals(result)){
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 修改解法，学习评论里的方法
     */
    class Solution2 {
        public boolean isPalindrome(int x) {
            String number = new StringBuffer(String.valueOf(x)).reverse().toString();
            return number.equals(String.valueOf(x));
        }
    }
}
