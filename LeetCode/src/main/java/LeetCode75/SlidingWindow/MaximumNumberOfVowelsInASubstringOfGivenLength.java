package LeetCode75.SlidingWindow;

import java.util.HashSet;
import java.util.stream.Collectors;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        int leetcode = maxVowels("abciiidef", 3);
        System.out.println("leetcode = " + leetcode);
    }

    //20ms 45.38mb
    public static int maxVowels(String s , int k){
        HashSet<Character> vowels = (HashSet<Character>) "aeiou".chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        int result = 0;
        char[] chars = s.toCharArray();
        if(s.length() == k) {//그냥 문자열 내의 모음 개수 구하기
            for(char c : chars) {
                if(vowels.contains(c)) result++;
            }
            return result;
        }else {
            int start =0; int end = k-1; int now = 0;

            for(int i=start; i<=end; i++) {
                if(vowels.contains(chars[i])) now++;
            }

            while(end != chars.length) {
                result = Math.max(result, now);

                end++;
                if(vowels.contains(chars[start])) now--;
                start++;
                if(end != chars.length && vowels.contains(chars[end])) {
                    now++;
                }
            }
        }
        return result;
    }

    //5ms 42.92mb
    public static int maxVOWELS(String s, int k) {
        byte []isVowel = new byte['z' + 1];     //배열의 인덱스에 문자를 넣으면 대응하는 아스키코드의 숫자로 오토 캐스팅
        isVowel['a'] = 1;
        isVowel['e'] = 1;
        isVowel['i'] = 1;
        isVowel['o'] = 1;
        isVowel['u'] = 1;

        char[] chars = s.toCharArray();
        int end = 0, max = 0;

        //초깃값 = 첫번째 윈도우의 상태 구하기
        while (end < k) {
            max += isVowel[chars[end++]];           //모음이라면 대응되는 값1씩 계수된다.
        }

        int start = 0, now = max;
        while (end < chars.length) {
            now += isVowel[chars[end++]] - isVowel[chars[start++]]; //후위 연산자 사용으로 가독성 증가
            if( now > max) {
                max = now;
            }
        }

        return max;
    }
}

/**
 * 1 <= 문자열의 길이 <= 100000
 * 소문자로만 구성
 * 1 <= k <= s.length
 *
 * 접근
 * 길이가 k인 윈도우를 만들어서 슬라이딩.
 * 문자열의 길이가 k보다 큰지 작은지에 따른 분기
 * 추가되거나 삭제되는 문자에 대해서 모음여부 검사  ->  호출이 많기 때문에 추가적인 메서드 호출 x
 * charAt대신 toCharArray로 배열로 구성
 */


/**
 * 시간 단축의 요소
 * 모음을 Set에 담아 하나씩 모음 여부를 판단 후 결과에 반영 -> byte배열 활용
 *
 * byte배열에는 0 or 1만 담을 수 있으며 배열의 인덱스로 문자를 넘으면 대응되는 아스키코드 값으로 인덱스가 오토캐스팅 된다.
 * 모음 문자에만 1을 초기화해주면 포인터를 후위 증감 연산자로 움직이면서 대응되는 문자의 값이 0인지 1인지에 따라 모음 개수를 계수할 수 있다.
 */