package lesson2;

import lesson2.search.BinarySearch;
import lesson2.search.ExponentialSearch;
import lesson2.search.InterpolationSearch;
import lesson2.sort.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        MyArray.isRepeat = false;
        MyArray.isShuffle = true;
        final int SIZE = 50000;
        Integer[] arr = MyArray.getArray(SIZE, 2);

//        System.out.println(Arrays.toString(arr));

        SpeedTest.startTime();

        //sort при 50000
//        BubbleSort.sort(arr); //13411 // 4
//        CocktailSort.sort(arr); //13497
//        SelectionSort.sort(arr); //3360
//        InsertionSort.sort(arr); //2286
//        CombSort.sort(arr); // 47
//        Arrays.sort(arr); //47
//        PigeonholeSort.sort(arr); //12
//        SelectionSortOpt.sort(new Integer[]{10, 13, 2, 6, 0, 8, 5, 7, 3, 11});
//        QuickSort.sort(arr); //127
//        HeapSort.sort(arr); //44

        SpeedTest.endTime();

//        System.out.println(Arrays.toString(arr));

  /*      System.out.println(BinarySearch.search(arr, 1));
        System.out.println(ExponentialSearch.search(arr, 1));
        System.out.println(InterpolationSearch.search(arr, 1));*/
    }
}
