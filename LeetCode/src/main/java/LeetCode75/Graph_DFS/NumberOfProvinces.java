package LeetCode75.Graph_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberOfProvinces {
    static boolean [] checked;
    static ArrayList<ArrayList<Integer>> adjacentList;
    static int cnt;
    static int n;
    public static void main(String[] args) {
        int isConnected [][] = new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int [][] isConnected){

        n = isConnected.length;
        checked = new boolean[n];
        adjacentList = new ArrayList<>(n);

        //인접 리스트 생성
        for(int i=0; i<n; i++) {
            adjacentList.add((ArrayList<Integer>) Arrays.stream(isConnected[i]).boxed().collect(Collectors.toList()));
        }

        //각 노드에서 출발
        for(int i=0; i<n; i++) {
            if(!checked[i]) {
                findProvince(i);
                cnt++;
            }
        }
        return cnt;
    }

    private static void findProvince(int start) {
        if(start >= n) return;
        checked[start] = true;

        ArrayList<Integer> list = adjacentList.get(start);
        for(int i=0; i<list.size(); i++) {
            if(i == start) continue;

            if (list.get(i) == 1 && !checked[i]) findProvince(i);
        }
    }
}
