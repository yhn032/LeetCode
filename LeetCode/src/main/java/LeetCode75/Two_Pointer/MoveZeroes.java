package LeetCode75.Two_Pointer;

public class MoveZeroes {
    public static void main(String[] args) {
        int [] nums = new int[] {0,1,0,3,12};
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        moveZeroes(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeroes(int [] nums) {

        /*      allocate new space nums

        int [] news = new int[nums.length];
        int idx = 0;
        for(int n : nums) {
            if(n != 0) news[idx++] = n;
        }
        for(int i =0; i<nums.length; i++) {
            nums[i] = news[i];
        }*/

        /* in-space */
        int idx = 0;
        for(int n : nums ) {
            if (n!=0) nums[idx++] = n;
        }

        while(idx < nums.length) {
            nums[idx++] = 0;
        }


        /*
            System.gc() : 명시적 가비지 컬렉터 호출.
            평소 프로젝트 개발에서는 사용하면 오히려 확률이 떨어질 수 있지만, 알고리즘 풀이에서는
            호출시 메모리 효율을 높여주고(안 쓰는 레퍼런스 즉시 정리), 시간 복잡도가 약간 떨어진다(정리하는 시간이 추가되는듯).
        *  */
    }
}
