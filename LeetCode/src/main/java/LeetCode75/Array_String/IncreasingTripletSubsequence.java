package LeetCode75.Array_String;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int nums[] = new int[] {20,100,10,12,5,13};

        System.out.println("mySolution = " + increasingTripletMine(nums));

        System.out.println("wellKnownSolution = " + increasingTripletOthers(nums));
    }

    /**
     * 연속된 인덱스에 대해서만 해당하는 풀이다.
     * 세 인덱스가 증분하기만 하면 될 뿐, 연속될 필요는 없다.
     */
    public static boolean increasingTripletMine(int[] nums) {
         if(nums.length < 3) return false;
         boolean triplet = false;
         for(int i=1; i<nums.length; i++) {
             if(nums[i] > nums[i-1]) {
                 if(triplet) return true;
                 triplet = true;
             }else {
                 triplet = false;
             }
         }
         return false;
    }

    /**
     * 핵심 로직 : 배열에서 대소가 비교된 가장 작은 2개의 값을 찾는다.
     * 이 두 값보다 큰 값이 존재한다면 i < j < k, nums[i] < nums[j] < nums[k]를 만족하는 수가 반드시 존재한다.
     * 배열의 순서대로 탐색을 하기 때문에 인덱스의 증분은 보장된다.
     * 이 부분이 이해가 안되었었는데, 결론적으로 a, b에 남아 있는 수가 실제 조건을 만족하는 순서쌍이 아닐 수도 있다.
     * 하지만 위에서 말 한듯이 배열의 인덱스 순서대로 탐색을 했기 때문에 배열 내에서 대소가 비교된 a < b가 있다는 것 만으로도 조건이 충분 된다.
     *
     * 현재의 실례를 보면 배열의 끝값 13에 가서야 조건을 만족한다. 조건을 만족하는 순서쌍은  [2,3,5] -> (10, 12, 13)이다.
     * 하지만 반복의 끝에 가면 a와 b에 남은 값은 5와 12이다. 얼필 보면 오류인 듯 보이지만,
     * 결론적으로 보면 a와b는 마지막까지 계속 업데이트 될 수 있다. 이 둘보다 큰 값이 그 뒤에 발견된다면 증가하는 세 값을 찾을 수 있다.
     */
    public static boolean increasingTripletOthers(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        if(nums.length < 3) return false;
        for(int num : nums) {
            if(num <= a) {
                a = num;
            }else if (num <= b) {
                b = num;
            }else {
                System.gc();
                return true;
            }
        }
        return false;
    }
}
