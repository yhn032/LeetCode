package LeetCode75.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DetermineIfTwiStringAreClose {
    public static void main(String[] args) {
        System.out.println("closeStrings(\"aabbsed\", \"aaswvvas\") = " + closeStrings("aabbsed", "aaswvvas"));
    }
    public static boolean closeStrings(String word1, String word2) {
        int [] asciiChar1 = new int[26];
        int [] asciiChar2 = new int[26];

        for(char c : word1.toCharArray()) {
            asciiChar1[c - 'a']++;
        }

        for(char c : word2.toCharArray()) {
            asciiChar2[c - 'a']++;
        }

        //공통 문자 소지 확인
        for(int i=0; i<26; i++) {
            if((asciiChar1[i] == 0 && asciiChar2[i] != 0) || asciiChar1[i] != 0 && asciiChar2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(asciiChar1);
        Arrays.sort(asciiChar2);

        for(int i=0; i<26; i++) {
            if (asciiChar1[i] != asciiChar2[i]) return false;
        }

        return true;

    }
}
