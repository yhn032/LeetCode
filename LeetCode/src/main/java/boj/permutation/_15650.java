package boj.permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15650 {
    static int N;                   //전체 수열 원소 개수
    static int M;                   //뽑울 개수
    static boolean [] check;        //해당 원소 사용 여부
    static Queue<Integer> ans;      //결과 배열
    public static void main(String[] args) throws Exception{
        //순열 : 순서가 존재 n개중 r개를 뽑아 나열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        ans = new LinkedList<>();

        permutation(0, 1);      //깊이(depth)는 탈출 조건, 현재 바라보는 원소(pos)는 오름차순으로 뽑기 위함
    }

    private static void permutation(int depth, int pos) {
        if (depth == M) {
            for(int i : ans) {
                if (i==0) continue;
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=pos; i<=N; i++) {
            if(check[i]) continue;

            ans.add(i);
            check[i] = true;

            permutation(depth + 1, i+1);

            check[i] = false;
            ans.remove(i);
        }
    }
}
