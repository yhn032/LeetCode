package LeetCode75.SlidingWindow;

public class LongestOnes {
    public static void main(String[] args) {
        int nums[] = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int result = longestOnes(nums, 2);
        System.out.println("result = " + result);
    }

    public static int longestOnes(int [] nums, int k) {
        int l = 0, r = 0, max = 0, kc = k;

        for(int i=0; i< nums.length; i++) {
            if(nums[i] == 1) {
                r++;
            }else{
                if(kc > 0) {
                    r++;
                    kc--;
                }else {
                    max = Math.max(max, r -l);

                    while (l < nums.length && nums[l] == 1) {
                        l++;
                    }
                    l++;

                    r++;
                }
            }
        }
        max = Math.max(max, r -l);
        return max;
    }
}
