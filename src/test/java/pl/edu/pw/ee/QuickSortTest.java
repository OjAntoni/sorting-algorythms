package pl.edu.pw.ee;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Random;

import static org.junit.Assert.*;

public class QuickSortTest {
    private final QuickSort quickSort = new QuickSort();

    @Test
    public void extraordinaryDataTest(){
        assertThrows(Exception.class, ()-> quickSort.sort(null));

        double[] empty = new double[]{};
        quickSort.sort(empty);
        assertArrayEquals(new double[]{}, empty, 0);

        double[] oneElement = new double[]{12};
        quickSort.sort(oneElement);
        assertArrayEquals(new double[]{12}, oneElement, 0);
    }

    @Test
    public void optimisticTest(){
        double[] data = new double[]{10, 12, 13, 14, 16, 18, 20};
        quickSort.sort(data);
        assertArrayEquals(new double[]{10, 12, 13, 14, 16, 18, 20}, data, 0);
    }

    @Test
    public void pessimisticTest(){
        double[] data = new double[]{33, 32, 26, 23, 8, 7, 6};
        quickSort.sort(data);
        assertArrayEquals(new double[]{6, 7, 8, 23, 26, 32, 33}, data, 0);
    }

    @Test
    public void mixedDataTest(){
        double[] data = new double[]{-5, -89, 0, 3, 43, -90, -100};
        quickSort.sort(data);
        assertArrayEquals(new double[]{-100, -90, -89, -5, 0, 3, 43}, data, 0);
    }

    @Test
    public void randomBigDataTest(){
        int seed = LocalTime.now().getNano();
        double[] data = new double[1000000];
        Random r = new Random(seed);
        for(int i = 0; i < 1000000; i++){
            data[i] = r.nextDouble();
        }
        quickSort.sort(data);
        check(data);
    }

    private void check(double[] data){
        for (int i = 0; i < data.length-2; i++){
            if(data[i]>data[i+1]){
                fail();
            }
        }
    }
}
