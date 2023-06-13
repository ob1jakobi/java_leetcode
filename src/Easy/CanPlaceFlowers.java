package Easy;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean hasFlowerLeft = i != 0 && flowerbed[i - 1] == 1;
                boolean hasFlowerRight = i != flowerbed.length - 1 && flowerbed[i + 1] == 1;
                if (!hasFlowerLeft && !hasFlowerRight) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
