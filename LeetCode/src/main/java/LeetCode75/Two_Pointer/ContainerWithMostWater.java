package LeetCode75.Two_Pointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int [] height) {
        int l = 0; int h = height.length-1; int max = 0;
        if(height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        while(l < h) {
            int currentArea = Math.min(height[l], height[h]) * (h-l);
            max = Math.max(max, currentArea);

            int width = Math.min(height[l], height[h]);
            while(l < h && width >= height[l]) l++;
            while(l < h && width >= height[h]) h--;
        }
        System.gc();
        return max;
    }
}
