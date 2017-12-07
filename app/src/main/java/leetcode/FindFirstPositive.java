package leetcode;

/**
 * Created by xupei on 17/11/6
 */

import android.util.Log;

import java.util.Arrays;

/**
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 找到第一个不与前面连续的正整数

 [-3,-2,0,3,4] 排序后是 -2，-3，0，3，4 所以第一个缺少的正整数是1
 */
public class FindFirstPositive {
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length-1,temp;
        for (int i = 0; i <=length;) {
            if (nums[i]==i+1||nums[i]<=0||nums[i]>length+1){
                i++;
            }else if (nums[i]-1>=0&&nums[nums[i]-1]!=nums[i]){
                int j = nums[i]-1;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else {
                i++;
            }
        }
        for (int i = 0; i <=length ; i++) {
            if (nums[i]<=0||nums[i]!=i+1){
                return i+1;
            }
            if (i==length){
                return i+2;
            }
        }
        return 1;
    }
}
