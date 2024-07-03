package LeetCode75.Array_String;

public class MergeStringAlternatively {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        int charLimit = Math.max(word1Chars.length, word2Chars.length);
        char[] result = new char[word1Chars.length + word2Chars.length];
        int currentIdx = 0;

        for(int i=0; i<charLimit; i++) {
            if(i< word1Chars.length) {
                result[currentIdx++] = word1Chars[i];
            }
            if(i< word2Chars.length) {
                result[currentIdx++] = word2Chars[i];
            }
        }

        System.out.println(String.valueOf(result));
        System.out.println(new String(result));
    }

}
