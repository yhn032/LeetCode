package LeetCode75.Array_String;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int [] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3;

        List<Boolean> possible = new ArrayList<>();
        int m = 0;
        for (int d : candies) {
            m = m > d ? m : d;
        }

        for(int i=0; i<candies.length; i++) {
            if((candies[i] + extraCandies) >= m) possible.add(true);
            else possible.add(false);
        }

        System.out.println(possible.toString());
    }
}
