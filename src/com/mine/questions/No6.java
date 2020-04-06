package com.mine.questions;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class No6 implements Question {
    @Override
    public void run() {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.convert("A", 1));
    }

    /**
     * 解决方法1：暴力法
     * 第一次提交  错误例为A,1  从而发现极端情况，当numRows<=2时，斜放字母为0或者负数，导致无限循环。
     * 添加对cross的极端情况处理
     * 之后通过，速度超过82%的用户，但是内存只超过11%的用户
     */
    class Solution1 {
        public String convert(String s, int numRows) {
            //如果字符串为空串
            if (s.length() <= 0){
                return "";
            }

            //存放新的字符串的buffer
            StringBuffer str = new StringBuffer();

            //计算z字型中间需要多少个斜放的字母
            int cross = numRows - 2;
            //极端情况处理
            if (cross <= 0){
                cross = 0;
            }

            //计算每一轮循环的字符数量
            int circle = cross + numRows;

            //外层循环circle次
            for (int i=0; i<numRows; i++){
                //内层循环次数
                int time = 0;

                //内层循环添加字符
                while (i + (time * circle) < s.length()){
                    str.append(s.charAt(i + (time * circle)));
                    //如果当前字符不是第一行或者最后一行字符
                    if (i != 0 && i != numRows - 1){
                        //再拼接上斜向的字符
                        if (i + (time * circle) + (circle - i * 2) >= s.length()){
                            break;
                        }
                        str.append(s.charAt(i + (time * circle) + (circle - i * 2)));
                    }

                    //内层循环下一轮
                    time++;
                }
            }

            return str.toString();
        }
    }

}
