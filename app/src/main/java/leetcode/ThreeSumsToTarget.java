package leetcode;

import java.util.Arrays;

import static android.R.attr.start;

/**
 * Created by aiya on 17/11/3.
 */

public class ThreeSumsToTarget {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i <nums.length-2 ; i++) {
            int l=0,r=nums.length-1;
            l=i+1;
            int firstNum= nums[i];
            while (l<r){
                int sum = firstNum + nums[l] + nums[r];
                if (sum==target){
                    return target;
                }else if (sum>target){
                    r--;
                }else {
                    l++;
                }
                if (Math.abs(result-target)>Math.abs(sum-target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}
