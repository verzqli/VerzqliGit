package leetcode;

/**
 * Created by aiya on 17/11/3.
 */

public class ContainMostWater {
    public static int maxArea(int[] height) {
         int  maxArea=0 ,l=0 ,r= height.length-1;
        while(l<r){
            maxArea = Math.max(maxArea,Math.min(height[l],height[r])*(r-l));
            if (height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return  maxArea;
    }
}
