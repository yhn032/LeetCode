package boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        out:
        while (!(str = br.readLine()).equals("0")){
            char[] chars = str.toCharArray();
            for(int i=0; i< chars.length; i++) {
                if(chars[i] != chars[chars.length-1-i]) {
                    System.out.println("no");
                    continue out;
                }
            }
            System.out.println("yes");
        }
    }
}
