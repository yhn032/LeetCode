package LeetCode75.PrefixSum;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int [] gain = new int[] {-5,1,5,0,-7};
        System.out.println("largestAltitude(gain) = " + largestAltitude(gain));
    }

    public static int largestAltitude(int [] gain) {
        int ans = 0;
        int sum = 0;
        for(int i=0;i<gain.length;i++){
            sum+=gain[i];
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}
