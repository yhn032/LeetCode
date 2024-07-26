package LeetCode75.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FindDifferenceOfTwoArrays {
    public static void main(String[] args) {
        
        int [] nums1 = new int[]{1,2,3,3};
        int [] nums2 = new int[]{1,1,2,2};

        System.out.println("findDifference(nums1, nums2) = " + findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int [] nums1, int [] nums2) {
        HashSet<Integer> s1 = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        HashSet<Integer> interSection= new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        HashSet<Integer> s2 = new HashSet<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        interSection.retainAll(s2);


        List<List<Integer>> result = new ArrayList<>();
        s1.removeAll(interSection);
        s2.removeAll(interSection);
        result.add(new ArrayList<Integer>(s1));
        result.add(new ArrayList<Integer>(s2));
        
        return result;
    }
}
