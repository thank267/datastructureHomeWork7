package lesson2.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(Integer[] arr) {

        int limit = arr.length;
        boolean isChange;

        do {
            limit--;
            isChange  = false;

            for (int i = 0; i < limit; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    isChange = true;
                }
            }
//            System.out.println(limit + " " + Arrays.toString(arr));
        } while (isChange);
    }
}
