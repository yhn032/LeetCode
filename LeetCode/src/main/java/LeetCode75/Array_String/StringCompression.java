package LeetCode75.Array_String;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println((int) ('0'));
        char chars[] = new char[] {'a','a','b','b','c','c','c'};
        System.out.println("stringCompression(chart) = " + compression(chars));
    }

    public static int stringCompression(char[] chars) {

        if(chars.length <= 1) return chars.length;
        StringBuffer s = new StringBuffer();

        int cnt = 1;
        for(int i=1; i<chars.length; i++) {
            if(chars[i-1] == chars[i]) {
                cnt++;
            }else {
                s.append(chars[i-1]);
                if(cnt != 1) {
                    s.append(cnt);
                    cnt = 1;
                }
            }

        }

        s.append(chars[chars.length-1]);
        if(cnt != 1) {
            s.append(cnt);
        }
        for(int i=0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
    
    public static int compression (char [] chars) { 
        int newSize = 0; 
        int i = 0;              //공간복잡도 O(1)을 만들기 위한 배열 탐색 idx;
        
        while(i < chars.length) {
            char c = chars[i];
            //중복되는 문자열의 길이 
            int groupSize = lengthOfConsecutive(chars, i);

            //길이를 찾아서 곧바로 재구성
            chars[newSize++] = c;
            if(groupSize > 1) {//숫자가 2자리 수 인경우 문자 형태로 넣어야 하기 때문에 자릿수 별로 숫자를 뽑아서 채워 넣기
                newSize = insertCnt(chars, newSize, groupSize);
            }
            //이미 탐색이 끝난 범위 건너 뛰기
            i += groupSize;
        }
        return newSize;
    }

    /**
     *
     * @param chars 원본 배열
     * @param size  압축된 문자열 현재 길이
     * @param groupSize 그룹 문자열 길이
     * @return
     */
    private static int insertCnt(char[] chars, int size, int groupSize) {
        int newSize = size;
        if(groupSize != 0) {
            newSize = insertCnt(chars, newSize, groupSize / 10);
            chars[newSize] = (char) ('0' + groupSize % 10);
            newSize++;
        }
        return newSize;
    }

    private static int lengthOfConsecutive(char[] chars, int idx) {
        int size = 0;
        //시작지점부터 중복이 끝나는 지점까지 중복된 개수를 구함으로써 그룹개수 카운팅
        while(idx + size < chars.length && chars[idx+size] == chars[idx]) {
            size++;
        }
        return size;
    }
}
