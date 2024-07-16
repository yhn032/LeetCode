package LeetCode75.Two_Pointer;

import java.util.Arrays;
import java.util.HashMap;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        int [] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}; int k = 2;
        System.out.println(maxMapOpt(nums, k));
    }

    //35ms 35.33% / 55.16MB 91.09%
    public static int maxMapOpt(int [] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for(int i =0; i<nums.length; i++){
            int res = k - nums[i];
            if(map.containsKey(res)) {
                result++;
                if(map.get(res) == 1) map.remove(res);
                else map.put(res, map.get(res) - 1);
            }else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
            }
        }

        return result;
    }

    //18ms 86.59% / 57.16MB 47.93%
    public static int maxTwoPointers(int [] nums, int k) {
        int result = 0; int l = 0; int h = nums.length - 1;

        Arrays.sort(nums);
        while(l < h) {
            int sum = nums[l] + nums[h];

            if(sum == k) {
                result++;
                l++;
                h--;
            }else if(sum > k) h--;
            else l++;
        }

        return result;
    }


    //time limit exceeded
    public static int maxBruteForce(int [] nums, int k) {
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) continue;

            for(int j =i+1; j< nums.length; j++) {
                if(nums[j] == 0) continue;

                if(nums[i] + nums[j] == k) {
                    result++;
                    nums[i] = k;
                    nums[j] = k;
                    break;
                }
            }
        }

        return result;
    }

    //1173ms 5.05% / 57.53MB 24.97%
    public static int maxOperation(int [] nums, int k) {
        int result = 0;
        if(nums.length == 1) return result;
        int pointer = 0;
        while(pointer < nums.length-1) {
            if(nums[pointer] == 0 || nums[pointer] >= k) {
                pointer++;
                continue;
            }
            int end = pointer + 1;
            while(end < nums.length){
                if(nums[end] == k-nums[pointer]) {
                    result++;
                    nums[pointer] =0; nums[end] = 0;
                    break;
                }else {
                    end++;
                }
            }
            pointer++;
        }

        return result;
    }
}
