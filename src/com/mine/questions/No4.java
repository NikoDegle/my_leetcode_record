package com.mine.questions;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 *
 */
public class No4 {

    public static void main(String[] args) {
        int nums1[] = {1,2,3};
        int nums2[] = {1, 2,};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isDouble = false;
        //获得中位数
        int len = nums1.length + nums2.length;
        if (len % 2 == 0){
            //如果总长度是偶数，则取中间两个数
            isDouble = true;
        }

        //循环
        int i=0, j=0;
        int sum = 0;
        while(i + j <= len/2){
            int nextNum = 0;
            if (i >= nums1.length){
                nextNum = nums2[j++];
            } else if (j >= nums2.length){
                nextNum = nums1[i++];
            } else {
                nextNum = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
            }

            if (isDouble){
                if (i + j - 1 == len/2 || i + j - 1 == len/2 - 1){
                    sum += nextNum;
                }
            } else {
                if (i + j - 1 == (len-1)/2){
                    sum += nextNum;
                }
            }
        }

        if (isDouble){
            return sum/2.0;
        } else {
            return (double)sum;
        }
    }
}