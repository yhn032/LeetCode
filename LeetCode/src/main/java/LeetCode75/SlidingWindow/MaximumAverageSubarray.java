package LeetCode75.SlidingWindow;

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        int [] nums = {0,1,1,3,3};
        double v = maxAverage(nums, 4);
        System.out.println("v = " + v);
    }

    public static double maxAverage(int nums[] , int k) {
        double max = Integer.MIN_VALUE;
        int current = 0;

        int start = 0; int end = k-1;
        for(int i = start; i<=end; i++) {
            current += nums[i];
        }

        while(end != nums.length) {
            max = Math.max(max, (double)current / k);
            end++;
            current -= nums[start];
            start++;
            if(end != nums.length) {
                current += nums[end];
            }
        }

        return max;
    }
}
