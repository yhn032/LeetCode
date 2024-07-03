package LeetCode75.Array_String;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,1};
        int n = 1;

        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 1) i++;
            else if(i+1 < flowerbed.length && flowerbed[i+1] == 1) {}
            else {
                //값이 0이고, 다음 인덱스가 배열을 벗어나지 않으면서 0임 - 심기 가능
                n--;
                i++;
            }
        }

        System.out.println(n <= 0);
    }
}
