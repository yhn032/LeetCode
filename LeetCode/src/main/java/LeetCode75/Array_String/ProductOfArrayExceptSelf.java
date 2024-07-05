package LeetCode75.Array_String;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        /**
         * 접근 -> 자신을 제외한 나머지 모두의 곱 = (전체 요소의 곱 / 자기 자신) -> result[i]의 값
         * 나눗셈 연산을 하기 때문에 0의 존재를 생각해야 함.
         * 요소에 0이 없는 경우, 1개인 경우, 2개 이상인 경우
         * 0이 없는 경우는 전체 곱에서 자기 자신을 나누면 됨
         * 0이 1개인 경우 nums의 값이 0인 idx만 전체 곱을 갖고 나머지는 0
         * 0이 2개인 경우 무조건 모두 0 -> 그냥 크기만 지정해서 배열을 생성하면 default값이 0으로 채워진다. 놓친 부분 -> (Arrays.fill 할 필요 없음!)
         *
         * 구현력 -> 0의 개수를 직접 카운팅할 필요 없이 불린 값을 활용하여 2개 이상인 경우부터 적용되도록 구현 가능하다.
         *
         * 최소 길이 2에 대한 대비를 하지 못했다.
         */

        //mySOL >
        int [] nums = new int[] {1,2,3,4};
        int [] result;


    }
    public static int[] productExceptSelf2(int []nums) {
        if (nums.length == 2) {
            //만약 요소가 2개인데 모두 0이라면 그냥 0을 리턴하면 되고, 하나라도 값이 있으면 스와핑(자기자신을 제외한 나머지 요소의 곱이므로)하면됨.
            return nums[0]==0 && nums[1]==0 ? new int[]{0,0} : new int[]{nums[1], nums[0]};
        }
        int totalProd = 1;
        boolean zeroFlag = false;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                totalProd *= nums[i];           //0을 제외한 값만 곱하면 곱셈 연산을 중복으로 할 필요가 없음
            }else {
                if(zeroFlag) {
                    return new int[nums.length];
                }
                zeroFlag = true;    // -> 처음 0이 발견된 경우 (0 1개) 플래그만  바꿈, 0이 또 발견된 경우 (0 2개 이상) 바로 return 내가 하고자 했던 건데 구현력이 부족했다.
                                    // 특정 값에 대한 개수 체크가 필요할 때 boolean도 고려하길
            }
        }

        int result[] = new int[nums.length];
        for(int i=0; i<result.length; i++) {
            if(zeroFlag) {
                result[i] = nums[i] == 0 ? totalProd : 0;
            }else {
                result[i] = totalProd / nums[i];
            }
        }

        return  result;
    }

    public static int[] productExceptSelf(int [] nums) {
        int product = 1;
        int zeroCnt = 0;
        int zeroIdx = 0;
        int [] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if(zeroCnt > 1) {
                Arrays.fill(result, 0);
                return result;
            }
            product *= nums[i];

            if( nums[i] == 0) {
                zeroIdx = i;
                zeroCnt++;
            }
        }

        if(zeroCnt > 1) {
            Arrays.fill(result, 0);
            return result;
        }

        if(zeroCnt == 1) {
            product = 1;
            for(int i=0; i<nums.length; i++) {
                if(i!=zeroIdx) product *= nums[i];
            }
            Arrays.fill(result, 0);
            result[zeroIdx] = product;
            return result;
        }else {
            for(int i=0; i<nums.length; i++) {
                result[i] = product / nums[i];
            }
        }



        return result;
    }
}
