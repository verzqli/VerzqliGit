package leetcode;

import static android.R.attr.left;
import static android.R.attr.right;

/**
 * Created by aiya on 17/11/6.
 */

public class MinmumRotatedSortedArray {
    public static int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }

        int left = 0,right = nums.length-1,half;
        while (left<right){
            if (nums[left]<nums[right])
                return nums[left];
            half = (left+right)/2;
            if (half > 0 && nums[half] < nums[half - 1]) {
                return nums[half];
            }
          if (nums[left]>nums[half]){
              right=half;

          }else {
              left=half+1;
          }

        }
        return nums[left];
    }
}