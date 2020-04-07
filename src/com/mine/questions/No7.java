package com.mine.questions;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class No7 implements Question{

    @Override
    public void run() {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reverse(4453197));
    }

    /**
     * 题目还是很简单的，重点在于溢出的判断
     * 有的解答使用的溢出判断是定义最大值和最小值
     * 但是这个解答就很简单，使用long保存拼接的数据，之后转换成int类型，如果有精度损失那么就返回0
     */
    class Solution1 {
        public int reverse(int x) {
            long n = 0;
            while(x != 0) {
                n = n*10 + x%10;
                x = x/10;
            }
            return (int)n==n? (int)n:0;
        }
    }
}
