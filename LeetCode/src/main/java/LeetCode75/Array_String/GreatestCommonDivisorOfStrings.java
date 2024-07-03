package LeetCode75.Array_String;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String str2 = "ABABABABABAB"; //12
        String str1 = "ABABABAB";     //8
        String result = "";

        if(!(str1+str2).equals(str2 + str1)) { //나눠 떨어지지 않는 값이 있다는 뜻 불가능
            result = "";
        }
        int str1_len = str1.length();
        int str2_len = str2.length();

        while(str2_len != 0) {  //값의 크기를 구분할 필요가 없음. 나누는 수가 더 크다면 나눠지는 수가 그대로 나머지로 나오면서 스왑됨

            int tmp = str2_len;
            str2_len = str1_len % str2_len;
            str1_len = tmp;
        }

        result = str1.substring(0, str1_len);
        System.out.println("result = " + result);
    }
}
