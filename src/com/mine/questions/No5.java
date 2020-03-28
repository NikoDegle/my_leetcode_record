package com.mine.questions;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class No5 implements Question {
    @Override
    public void run() {
        ThirdSolution solution = new ThirdSolution();
        System.out.println(solution.longestPalindrome("a"));
    }

    /**
     * 第一个解决方案只能解决奇数长度的回文问题
     * 类似bb的偶数回文无法解决
     */
    class FirstSolution {
        public String longestPalindrome(String s) {
            //长度记录
            int len = 0;
            int center = 0;

            //遍历字符串
            for (int pointer=0; pointer<s.length(); pointer++){
                //循环找回文
                int nowLen = 1;
                int left=pointer-1, right=pointer+1;
                while(true){
                    if ((left<0 || right>=s.length()) || (s.charAt(left) != s.charAt(right))){
                        //如果当前回文更长，则将回文中心位置指向center， 长度记录为nowlen
                        if (nowLen > len){
                            len = nowLen;
                            center = pointer;
                        }
                        break;
                    }
                    left--;
                    right++;
                    nowLen++;
                }
            }

            //截取回文并展示
            return s.substring(center-len+1, center+len);
        }
    }

    /**
     * 第二种解法，从左至右寻找回文，将所有最左和最右一致的字符串判断是否为回文
     *
     * 第一次提交后添加判空方法
     * 第二次提交后超出时间限制，对应的串为"dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" 修改为searcher从后往前走
     * 第三次提交后超出时间限制，优化while循环，添加if判断跳出循环
     * 第四次提交通过，但是结果不好
     *
     * 优化for循环，添加循环提前结束条件，耗时从800ms减少到300ms
     * 尝试使用迭代方法判断是否为回文  事实证明迭代花费了更多的时间和空间
     */
    class SecondSolution{
        public String longestPalindrome(String s){
            if (s.length() <= 0){
                return "";
            }
            int pointer=0;
            String str = s.charAt(0)+"";
            while (pointer < s.length()){
                if (str.length() > s.length() - pointer){
                    break;
                }
                for (int searcher=s.length()-1; searcher>pointer && searcher-pointer+1>str.length(); searcher--){
                    if (s.charAt(pointer) == s.charAt(searcher)){
                        String target = s.substring(pointer, searcher+1);
                        if (isHuiWen(target) && target.length() > str.length()){
                            str = target;
                        }
                    }
                }
                pointer++;
            }
            return str;
        }

        /**
         * 判断输入的字符串是否为回文
         * @param s
         * @return
         */
        public boolean isHuiWen(String s) {
            int left = 0, right = s.length() - 1;
            while (right >= left) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
        /**
         * public boolean isHuiWen(String s){
         *             if (s.length() == 1){
         *                 return true;
         *             }
         *             if (s.length() == 2 && s.charAt(0) == s.charAt(1)){
         *                 return true;
         *             }
         *             if (s.charAt(0) == s.charAt(s.length()-1) && isHuiWen(s.substring(1, s.length()-1))){
         *                 return true;
         *             }
         *             return false;
         *         }
         */
    }

    /**
     * 查看c语言中最好的解决方案后  以回文串中的特殊串“重复字符串”为中心向两侧查找
     * 第一次提交，执行用时32ms 超过%70的用户
     */
    class ThirdSolution{
        public String longestPalindrome(String s) {
            int pointer=0;
            String str="";
            while (pointer < s.length()){
                int right=pointer;
                int left=pointer;

                //从右边开始找重复串
                while (right+1 < s.length() && s.charAt(right) == s.charAt(right+1)){
                    right++;
                }
                pointer = right;

                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    String temp = s.substring(left, right+1);
                    if (temp.length() > str.length()){
                        str = temp;
                    }
                    left--;
                    right++;
                }

                pointer++;
            }
            return str;
        }
    }
}
