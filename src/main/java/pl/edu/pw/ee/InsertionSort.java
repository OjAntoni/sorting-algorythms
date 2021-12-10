package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class InsertionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if(nums==null){
            throw new IllegalArgumentException("Null argument provided");
        }
        if (nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int j = i-1;
            while (j>=0 && nums[j] > nums[j+1]) {
                double tmp = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = tmp;
                j--;
            }
        }
    }

}
