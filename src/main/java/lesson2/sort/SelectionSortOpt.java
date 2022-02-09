package lesson2.sort;

import java.util.Arrays;

public class SelectionSortOpt {
    public static void sort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            int max = arr.length - 1 - i;
            System.out.println(arr[min]);
            System.out.println(arr[max]);

            for (int j = min + 1; j < arr.length - i; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                } else if (arr[j] > arr[max]) {
                    max = j;
                }

            }

            change(arr, i, min);
            change(arr, arr.length - 1 - i, max);
            System.out.println("i: " + i + " -- "+ Arrays.toString(arr));
        }
    }

    private static void change(Integer[] arr, int i, int minmax) {
        int temp = arr[i];
        arr[i] = arr[minmax];
        arr[minmax] = temp;
    }
}
