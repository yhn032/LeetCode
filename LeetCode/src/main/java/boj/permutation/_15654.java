package boj.permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _15654 {
    static int N, M;
    static boolean check[];
    static Queue<Integer> ans;
    static int [] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        list = new int[N];
        ans = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        permutation(0);
    }

    public static void permutation(int depth) {
        if(depth == M) {
            for(int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++) {
            if(check[i]) continue;

            ans.add(list[i]);
            check[i] = true;

            permutation(depth + 1);

            check[i] = false;
            ans.remove(list[i]);
        }
    }
}
