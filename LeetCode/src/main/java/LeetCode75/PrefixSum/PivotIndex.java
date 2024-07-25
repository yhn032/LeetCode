package LeetCode75.PrefixSum;

import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int [] nums = new int[] {1,7,3,6,5,6};
        System.out.println("pivotIndex(nums) = " + pivotIndex(nums));
    }

    public static int pivotIndex(int [] nums){
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;

        for(int i=0; i<nums.length; i++) {
            rightSum -= nums[i];
            if(leftSum == rightSum) return i;

            leftSum += nums[i];
        }

        return -1;
    }
}
