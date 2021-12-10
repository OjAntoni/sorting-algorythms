package pl.edu.pw.ee;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void put() {
        try {
            Field length = Heap.class.getDeclaredField("length");
            length.setAccessible(true);
            Heap<Double> heap = new Heap<>();
            for(int i = 0; i < 10; i++){
                heap.put(i*0.9);
            }
            assertEquals(10, length.getLong(heap));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void pop() {
        Heap<Double> heap = new Heap<>();

        for (int i = 1; i <= 100000; i++) {
            heap.put(i*100.98);
        }
        for (int i = 100000; i > 0; i--) {
            assertEquals(i*100.95, heap.pop(), 0);
        }
    }
}