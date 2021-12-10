package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class HeapSortTest {

    private final Sorting heapSort = new HeapSort();

    @Test
    public void extraordinaryDataTest(){
        assertThrows(Exception.class, ()-> heapSort.sort(null));

        double[] empty = new double[]{};
        heapSort.sort(empty);
        assertArrayEquals(new double[]{}, empty, 0);

        double[] oneElement = new double[]{12};
        heapSort.sort(oneElement);
        assertArrayEquals(new double[]{12}, oneElement, 0);
    }

    @Test
    public void optimisticTest(){
        double[] data = new double[]{10, 12, 13, 14, 16, 18, 20};
        heapSort.sort(data);
        assertArrayEquals(new double[]{10, 12, 13, 14, 16, 18, 20}, data, 0);
    }

    @Test
    public void pessimisticTest(){
        double[] data = new double[]{33, 32, 26, 23, 8, 7, 6};
        heapSort.sort(data);
        assertArrayEquals(new double[]{6, 7, 8, 23, 26, 32, 33}, data, 0);
    }

    @Test
    public void mixedDataTest(){
        double[] data = new double[]{-5, -89, 0, 3, 43, -90, -100};
        heapSort.sort(data);
        assertArrayEquals(new double[]{-100, -90, -89, -5, 0, 3, 43}, data, 0);
    }

    @Test
    public void randomBigDataTest(){
        int seed = LocalTime.now().getNano();
        for(int y =0; y <= 1000; y++){
            double[] data = new double[1000];
            Random r = new Random(seed);
            for(int i = 0; i < data.length; i++){
            data[i] = r.nextDouble()*100;
                data[i] = r.nextInt(20);
            }
            heapSort.sort(data);
            check(data);
        }
    }

    private void check(double[] data){
        for (int i = 1; i < data.length; i++){
            if(Double.compare(data[i-1], data[i]) > 0){
                System.out.println(Arrays.toString(data));
                fail(data[i-1] + "("+(i-1)+") > " + data[i]+"("+(i)+")");
            }
        }
    }
}