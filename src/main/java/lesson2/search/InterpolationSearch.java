package lesson2.search;

public class InterpolationSearch {
    public static int search(Integer[] arr, int num2Find) {
        int start = 0;
        int end = arr.length - 1;
        int base;
        int i = 0;

        while (end >= start && num2Find >= arr[start] && num2Find <= arr[end]) {
            if (arr[end].equals(arr[start])) {
                break;
            }
            i++;
            base = (int)(start +
                  1.0 *  (end - start) / (arr[end] - arr[start])
                    * (num2Find - arr[start]));


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

        if (arr[start].equals(num2Find)) {
            return start;
        }

        System.out.println("НЕ НАШЛИ! Кол-во итераций: " + i);
        return -1;
    }
}
