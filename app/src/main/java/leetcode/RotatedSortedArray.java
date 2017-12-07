package leetcode;

/**
 * Created by aiya on 17/11/4.
 */

import android.util.Log;

import static android.R.attr.left;
import static android.R.attr.right;
import static android.R.attr.tag;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class RotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1, half = 0;
        while (left <=right) {
            half = (left + right) / 2;
            if (nums[half] == target) {
                return half;
            }
            if (nums[left] <= nums[half]) {
                if (nums[half] > target && target >= nums[left]) {
                    right = half - 1;
                } else {
                    left = half + 1;
                }
            }
            if (nums[right] >= nums[half]) {
                if (nums[half] < target && target <= nums[right]) {
                    left = half + 1;
                } else {
                    right = half - 1;
                }
            }
        }
        return  -1;
    }
}
