package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class HeapSort implements Sorting {
    private final Heap<Double> heap = new Heap<>();

    @Override
    public void sort(double[] nums) {
        for (double num : nums) {
            heap.put(num);
        }
        for (int i = 0; i < nums.length; i++){
            nums[nums.length-i-1] = heap.pop();
        }
    }

}
