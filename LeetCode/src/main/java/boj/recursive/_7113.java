package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7113 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n == m) System.out.println(++cnt);
        else {
            getSquare(n, m);
            System.out.println(cnt);
        }
    }

    public static void getSquare(int n, int m) {
        if(n == 0 || m == 0) return;

        cnt++;
        if(n > m) {
            getSquare(n-m, m);
        }else {
            getSquare(n, m-n);
        }
    }
}
