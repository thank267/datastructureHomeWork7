package lesson2.search;

public class BinarySearch {
    public static int search(Integer[] arr, int num2Find) {
       return search(arr, num2Find, 0, arr.length - 1);
    }

    public static int search(Integer[] arr, int num2Find, int start, int end) {
//        int start = 0;
//        int end = arr.length - 1;
        int base;
        int i = 0;

        while (end >= start && num2Find >= arr[start] && num2Find <= arr[end]) {
            i++;
            base = (start + end) / 2;
            System.out.println("Base = " + base);

            if (arr[base] == num2Find) {
                System.out.println("НАЙДЕНО! Кол-во итераций: " + i);
                return base;
            } else if (arr[base] < num2Find) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        System.out.println("НЕ НАШЛИ! Кол-во итераций: " + i);
        return -1;
    }
}
