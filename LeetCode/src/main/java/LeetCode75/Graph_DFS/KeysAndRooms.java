package LeetCode75.Graph_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public static boolean [] checked;
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(6,7,8)));
        rooms.add(new ArrayList<>(Arrays.asList(5,4,9)));
        rooms.add(new ArrayList<>(Arrays.asList()));
        rooms.add(new ArrayList<>(Arrays.asList(8)));
        rooms.add(new ArrayList<>(Arrays.asList(4)));
        rooms.add(new ArrayList<>(Arrays.asList()));
        rooms.add(new ArrayList<>(Arrays.asList(1,9,2,3)));
        rooms.add(new ArrayList<>(Arrays.asList(7)));
        rooms.add(new ArrayList<>(Arrays.asList(6,5)));
        rooms.add(new ArrayList<>(Arrays.asList(2,3,1)));

        System.out.println(canVisitAllRooms(rooms));
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        checked = new boolean[rooms.size()];
        checked[0] = true;

        dfs(rooms, 0);

        for(boolean b : checked) {
            if(!b) return false;
        }

        return  true;
    }

    private static void dfs(List<List<Integer>> rooms, int roomNum) {
        List<Integer> keys = rooms.get(roomNum);
        if(keys.size() == 0 || keys.isEmpty()) return;

        for(int i=0; i<keys.size(); i++) {
            if(checked[keys.get(i)]) continue;
            else {
                checked[keys.get(i)] = true;
                dfs(rooms, keys.get(i));
            }
        }
    }
}
