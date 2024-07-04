package LeetCode75.Array_String;

public class ReverseWordsInaString {
    public static void main(String[] args) {
        String result = "";
        String s = "the sky is blue";

        //solution 1 (trim vs strip) trim이 공간 사용율 우세 왜?
        /*
        *   trim VS strip
        *   공통 : 문자열의 중간은 무시하고 앞 뒤 공백을 제거한다.
        *   trim
        *   - java 1버전 부터 사용 가능하기 때문에 오래된 레거시 코드와 호환성이 좋다.
        *   - 공백 제거 대상이 아스키 코드로 제한되기 때문에 구현이 단순하며, 메모리 효율성이 좋다.
        *
        *   strip
        *   - java 11버전 부터 사용 가능하고, 국제화된 소스 환경에서 유용하다.
        *   - 유니코드 공백 문자까지 제거하기 때문에 구현이 복잡하며, 메모리 효율성이 비교적 낮다.
        * */
        String [] str = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();

        for(int i=str.length-1; i>=0 ; i--) {
            if(str[i].equals("")) continue;
            else {
                sb.append(str[i]).append(" ");
            }
        }
        result = sb.toString().trim();

        //solution 2 optimize time-complexity (two pointer)
        char[] strArray = s.toCharArray();
        char[] res = new char[s.length() + 1];
        int n = strArray.length;
        int i = n-1;
        int y =0;
        while (i>=0){
            while(i>=0 && strArray[i] ==' ') i--;
            int j = i-1;
            while(j>= 0 && strArray[j] !=' ') j--;
            int k = j+1;
            if(i>=0){
                while(k <= i){
                    res[y++] = strArray[k++];
                }
                res[y++] = ' ';
                i = j-1;
            }
        }
        result = new String(res , 0, y-1);

    }
}
