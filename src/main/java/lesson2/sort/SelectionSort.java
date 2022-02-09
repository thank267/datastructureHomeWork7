package lesson2.sort;

public class SelectionSort {
    public static void sort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }
}
