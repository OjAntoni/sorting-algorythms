package pl.edu.pw.ee.table;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import pl.edu.pw.ee.SelectionSort;
import pl.edu.pw.ee.services.Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.fail;

public class SelectionSortTable {
    private Sorting insertionSort;
    private Random random;

    @Before
    public void setUp(){
        insertionSort = new SelectionSort();
        random = new Random();
    }

    @AfterEach
    public void tearDownAfterEachTest(){
        random = new Random();
    }

    @Test
    public void createOptimisticTable() {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("tables/selection_optimistic.txt"))) {
            for(int i=1; i<=50; i++){
                int length = i*200;
                double[] array = new double[length];
                array[0] = random.nextDouble();
                for(int j=1; j<length; j++){
                    array[j] = array[j-1] + j;
                }
                long start = System.nanoTime();
                insertionSort.sort(array);
                long end = System.nanoTime();
                fileWriter.write(String.format("%-10d %d\n", length, end-start));
            }
        } catch (IOException e) {
            fail("Error occurred during reaching the output file");
        }
    }

    @Test
    public void createPessimisticTable() {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("tables/selection_pessimistic.txt"))) {
            for(int i=1; i<=50; i++){
                int length = i*200;
                double[] array = new double[length];
                array[0] = random.nextDouble();
                for(int j=1; j<length; j++){
                    array[j] = array[j-1] - j;
                }
                long start = System.nanoTime();
                insertionSort.sort(array);
                long end = System.nanoTime();
                fileWriter.write(String.format("%-10d %d\n", length, end-start));
            }
        } catch (IOException e) {
            fail("Error occurred during reaching the output file");
        }
    }

    @Test
    public void createRandomTable() {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("tables/selection_random.txt"))) {
            for(int i=1; i<=50; i++){
                int length = i*200;
                double[] array = new double[length];
                array[0] = random.nextDouble();
                for(int j=1; j<length; j++){
                    array[j] = random.nextDouble();
                }
                long start = System.nanoTime();
                insertionSort.sort(array);
                long end = System.nanoTime();
                fileWriter.write(String.format("%-10d %d\n", length, end-start));
            }
        } catch (IOException e) {
            fail("Error occurred during reaching the output file");
        }
    }

}
