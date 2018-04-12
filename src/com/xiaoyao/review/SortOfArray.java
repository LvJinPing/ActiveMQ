package com.xiaoyao.review;

import java.util.Random;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-04-11
 */
public class SortOfArray {
    public static void main(String[] args){
        int[] nums = new int[6];
        Random r = new Random();
        r.nextInt(100);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        SortOfArray.xuanze(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
    // 大到小
    private static void maopao(int[] nums){
        if (nums != null && nums.length >0){
            for (int i = 0; i < nums.length -1; i++) {
                for (int j = i; j < nums.length-1; j++) {
                    int temp = nums[j];
                    if (nums[j] < nums[j+1]){
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                    }
                }
            }
        }else {
            return;
        }

    }
    // 小到大
    private static void xuanze(int[] nums){
        if (nums != null && nums.length >0){
            for (int i = 0; i < nums.length -1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                  int temp = nums[i];
                  if (nums[i] > nums[j]){
                      nums[i] = nums[j];
                      nums[j] = temp;
                  }
                }
            }
        }else {
            return;
        }
    }

}
