package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        searchZLine(size, r, c);

        System.out.println(cnt);
    }

    /**
     * 1. r행 c열이 4분할 했을때 몇 사분면에 있는지 찾기
     * 2. 한 변의 길이를 분할된 크기(size/4)로 줄인 후 부분 정사각형으로 이동한다.
     * 3. 이동할 때 탐색해야 할 좌표를 분할된 사각형의 ★상대좌표로 변경★한다.
     * 예를 들어 N = 2, r = 3, c = 1이라고 하면, 목적 좌표는 3사분면에 존재한다.
     * 그렇다면 1,2 사분면은 이미 탐색한 것으로 간주하고 한 변의 길이를 사용하여 탐색수를 계산한다. -> n사분면에 존재한다! -> cnt += size*size/4*(n-1)
     * 상대 좌표로 변경한다.
     * 전체로 봤을때는 3행 1열이지만, 분할된 3사분면에서만 보면 1행 1열이기 때문이다.
     */
    public static void searchZLine(int size, int r, int c) { //r == y , c == x

        //목적지를 찾았을 때 바로 리턴하기 때문에 zero index 보장가능
        if(size == 1) return;

        //1사분면에 있는 경우
        if(r < size/2 && c < size/2) {//1사분면
            searchZLine(size/2, r, c);
        }else if(r < size/2 && c >= size/2){ //2사분면
            cnt += size * size / 4;
            searchZLine(size/2, r, c-size/2);
        }else if(r >= size/2 && c < size/2){ //3사분면
            cnt += size * size / 4*2;
            searchZLine(size/2, r-size/2, c);
        }else { //4 사분면
            cnt += size * size / 4*3;
            searchZLine(size/2, r-size/2, c-size/2);
        }
    }
}
