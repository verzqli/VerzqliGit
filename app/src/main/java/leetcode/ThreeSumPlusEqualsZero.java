package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aiya on 17/11/3.
 */

public class ThreeSumPlusEqualsZero {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i <length-2 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // 避免重复 比如数组中有两个2 【2 -1-1】 这样只产生一组
                continue;
            }
            int target = nums[i];
            int j=i+1,k=length-1;
            while(j<k){
                if (target+nums[j]==-nums[k]){
                    ans.add(Arrays.asList(nums[k],nums[j],target));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }else if (target+nums[j]>-nums[k]){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return ans;
    }
}
