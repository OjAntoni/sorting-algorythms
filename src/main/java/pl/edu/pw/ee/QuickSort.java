package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

import java.util.Arrays;


public class QuickSort implements Sorting {

    @Override
    public void sort(double[] nums) {
         if (nums == null) {
             throw new IllegalArgumentException("Nums array cannot be null");
         }
         if(nums.length<=1){
             return;
         }
         quicksort(nums,0, nums.length-1);
    }

     private void quicksort(double[] data, int start, int end) {
         if(start>=end) return;
         int pivotIndex = splitData(data, start, end);
         quicksort(data, start, pivotIndex-1);
         quicksort(data, pivotIndex+1, end);
     }

     private int splitData(double[] data, int start, int end) {
         double pivot = data[start];
         int leftCursor = start+1;
         int rightCursor = end;
         while (leftCursor<rightCursor){
             while (data[leftCursor]<pivot && leftCursor<rightCursor){
                 leftCursor++;
             }
             while (data[rightCursor]>=pivot && leftCursor<rightCursor){
                 rightCursor--;
             }
             swap(data, leftCursor, rightCursor);
         }
         if(data[leftCursor]>=pivot){
             leftCursor--;
         }
         swap(data, start, leftCursor);
         return leftCursor;
     }

     private void swap(double[] data, int firstId, int secondId) {
         if (firstId != secondId) {
             double firstValue = data[firstId];
             data[firstId] = data[secondId];
             data[secondId] = firstValue;
         }
     }
}
