package LeetCode75.Two_Pointer;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "abxawc";
        System.out.println(isSubsequence(s, t));
    }

    /**
     * for문을 통한 String.charAt()으로 문자 비교 VS String.toCharArray()로 변환후 for문을 통한 문자 비교
     *
     * 두 방법 모두 시간복잡도 O(N)으로 성능의 차이는 크게 없다.
     * 하지만 결론적으로 내부  메서드를 보면 charAt() 또한 내부 String 클래스의 멤버 변수 charArray : value 즉 배열의 접근이 이루어진다.
     * 그렇다면 값을 구하는 방식이 배열의 접근이라는 뜻인데,
     * 후자는 초기 한 번만 메서드 호출하여 배열을 사용하고,
     * 전자는 매번 메서드를 호출하여 배열을 사용한다.
     *
     * 즉, 문자열이 매우 길거나(입력값이 큰 경우), 빈번한 비교가 필요한 경우 charAt은 메서드 오버헤드가 존재할 수도 있다.
     */
    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        if(s.length() == 0) return true;

        int idx = 0;
        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == s.charAt(idx)) idx++;
            if(idx == s.length()) return true;
        }

        return false;
    }
}
