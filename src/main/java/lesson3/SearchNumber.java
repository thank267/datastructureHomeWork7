package lesson3;

public class SearchNumber {
    public static void main(String[] args) {
        test(6, 1, 2, 3, 4, 5, 7, 8);
        test(1);
        test(2, 1);
        test(2, 1, 3, 4, 5, 6, 7, 8);
        test(6, 1, 2, 3, 4, 5);
        test(7, 1, 2, 3, 4, 5, 6, 8);
        test(1, 2, 3, 4, 5, 6);
        test(11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16);
        test(3, 1, 2, 4, 5, 6);
    }

    public static void test(int lostNum, int... arr) {
        System.out.printf("Пропущено: %d, найдено: %d%n", lostNum, doTest(arr));
    }

    public static int doTest(int... arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int base = (start + end) / 2;
            if (arr[base] - base == 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }
        return start + 1;
    }


}
