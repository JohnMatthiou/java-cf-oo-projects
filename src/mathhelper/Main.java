package mathhelper;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 6, 13, 8, 24};


        try {
            int max = MathHelper.findMax(arr);
            int min = MathHelper.findMin(arr);
            double average = MathHelper.findAverge(arr);

            System.out.println("Max of the array is: " + max);
            System.out.println("Min of the array is: " + min);
            System.out.println("Average of the array is: " + average);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
