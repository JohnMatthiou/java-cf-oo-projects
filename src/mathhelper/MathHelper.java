package mathhelper;

public class MathHelper {

    private MathHelper() {

    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Error. Empty array!");
        }

        int arrMax = arr[0];

        for (int num : arr) {
            if (num > arrMax) {
                arrMax = num;
            }
        }

        return arrMax;

    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Error. Empty array!");
        }

        int arrMin = arr[0];

        for (int num : arr) {
            if (num < arrMin) {
                arrMin = num;
            }
        }

        return arrMin;

    }

    public static double findAverge(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Error. Empty array!");
        }

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return (double) sum / arr.length;

    }
}
