package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class SelectionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if(nums==null){
            throw new IllegalArgumentException("Null argument provided");
        }
        if(nums.length<=1){
            return;
        }
        for(int i = 0; i < nums.length; i++){
            int min = minElementIndex(nums, i, nums.length - 1);
            if(min != i){
                double tmp = nums[min];
                nums[min] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    private int minElementIndex(double[] array, int from, int to){
        int min = from;
        for(int i = from+1; i <= to; i++){
            if(array[i]<array[min]){
                min = i;
            }
        }
        return min;
    }

}
