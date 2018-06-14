package com.terahertz.QuickSort;

public class QuickSort {

    //Average case O(nlogn)
    //Worst case O(n^2)
    //Improvement: Choosing median value for initial pivot would make sure we don't get O(n^2)

    private static int partition(int[] array, int start, int end){

        //pivot is the last element of the array
        int i = start - 1;
        for(int j = start; j < end; j++){
           if(array[j] <= array[end]){
               i++;
               //swap i and j
               int temp = array[i];
               array[i] = array[j];
               array[j] = temp;
           }
        }

        //swap pivot and i+1
        int temp2 = array[end];
        array[end] = array[i+1];
        array[i+1] = temp2;

        //return pivot index
        return i+1;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    private static void sort(int[] array, int start, int end){

        if(start >= end){
            //Base case, array has 0 elements
        } else {
            int partition = partition(array, start, end);

            //Recursively sort the two sections
            sort(array, start, partition-1);
            sort(array, partition+1, end);
        }

    }

    public static void main(String[] args){
        int[] array = new int[] {1,6,5,3,2,4};
        sort(array, 0, array.length-1);
        for (int number : array) {
            System.out.print(number);
        }

    }

}
