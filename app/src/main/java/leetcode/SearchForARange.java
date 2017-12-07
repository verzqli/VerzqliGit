package leetcode;

/**
 * Created by aiya on 17/11/6.
 */

import static android.R.attr.left;
import static android.R.attr.right;

/**
 Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 Given [5, 7, 7, 8, 10] and target value 8,
 return [3, 3].
 */
public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {

        int left = 0,right = nums.length-1,half;
        int result[]={-1,-1};
        if (nums.length==1&&nums[0]==target){
            result[0]=0;
            result[1]=0;
            return result;
        }
        while (left<=right){
            half = (left+right)/2;
            if (nums[half]==target){
                int temp=half;
                while (temp>=0&&nums[temp]==target){
                    temp--;
                }
                result[0]=temp+1;
                temp=half;
                while (temp<=nums.length-1&&nums[temp]==target){
                    temp++;
                }
                result[1]=temp-1;
                return result;
            }
            if (nums[half]>target){
                right=half-1;
            }else {
                left=half+1;
            }
        }
        return result;
    }
}
