package LeetCode75.Array_String;

public class ReverseVowelsOfaString {
    public static void main(String[] args) {
        String s = "leetcode";

        boolean [] vowels = new boolean[128];   //표현되는 문자는 아스키코드로 구성되어 있고, 아스키코드는 128개이다.
        char[] chars = "aeiouAEIOU".toCharArray();
        for (Character c : chars) {
            vowels[c] = true;       //배열의 인덱스로 아스키코드로 표현 가능한 char을 입력하는 경우 int타입으로 자동 캐스팅 된다.
        }
        int l = 0; int h = s.length() - 1;

        char[] cs = s.toCharArray();
        while( l < h ) {

            while(l<h && !vowels[cs[l]]) {  //if로 하는 경우 한 번의 while패스동안 포인터가 한 번씩만 이동하기 때문에 전체 탐색 수가 늘어난다.
                l++;
            }
            while(l<h && !vowels[cs[h]]){
                h--;
            }
            if(l < h) {
                char cc = cs[l];
                cs[l] = cs[h];
                cs[h] = cc;
                l++;
                h--;
            }
        }
        System.out.println(String.valueOf(cs));
    }

}
