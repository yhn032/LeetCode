package LeetCode75.Hash;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println("uniqueOccurrences(new int[]{1,2,2,1,1,3}) = " + uniqueOccurrences(new int[]{1,2,3}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 1) return true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        return map.size() == set.size();
    }
}
