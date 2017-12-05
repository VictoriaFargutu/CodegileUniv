//1. Se genereaza un sir de nr intregi aleatoare intre 0 si 1000.
// Continutul acestui sir generat se copiaza intr-un alt sir.
// Se sorteaza sirurile crescator, primul folosind algoritmul Bubble,
// al doilea algoritmul Quick (sortarea are loc cvasisimultan, adica
// iteratia k a algoritmului Quick se executa imediat dupa iteratia
// k a algoritmului Bubble.

package com.codegile.university.victoria.week1.day3.problem1;

import java.util.Random;

public class IntegerArraySorting {

    private static int iIndex = 0;
    private static int jIndex = 1;
    public static int[] bubbleSortList = new int[7];

    public static void main(String[] args){
        int[] quickSortList = new int[7];

        Random random = new Random();
        for(int i = 0; i < 7; i++){
            int integerNumber = random.nextInt(1000);
            bubbleSortList[i] = integerNumber;
            quickSortList[i] = bubbleSortList[i];
        }
        System.out.println("Initial list: ");
        for(int i = 0; i < 7; i++){
            System.out.println(quickSortList[i]);
        }
        System.out.println();
        quickSort(quickSortList);
        System.out.println("quicksort: ");
        for(int i = 0; i < 7; i++){
            System.out.println(quickSortList[i]);
        }
        System.out.println();
        System.out.println("bubblesort: ");
        for(int i = 0; i < 7; i++){
            System.out.println(bubbleSortList[i]);
        }

    }

    public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }


    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {

        int idx = partition(array, startIdx, endIdx);
        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }
        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }


    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        // taking first element as pivot
        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }
            // swap the values
            if (left <= right) {
                //bubbleSort
                while(jIndex < bubbleSortList.length-iIndex) {
                    if (bubbleSortList[jIndex - 1] > bubbleSortList[jIndex]) {
                        int temporary = bubbleSortList[jIndex - 1];
                        bubbleSortList[jIndex - 1] = bubbleSortList[jIndex];
                        bubbleSortList[jIndex] = temporary;

                    }
                    jIndex++;
                }
                jIndex = 1;
                iIndex++;

                //quickSort
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                //increment left index and decrement right index
                left++; right--;
            }
        }
        return left;
    }
}
