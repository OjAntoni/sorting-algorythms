package pl.edu.pw.ee.services;

public interface HeapInterface<T extends Comparable<T>>{
    public T pop();
    public void put(T elem);
}