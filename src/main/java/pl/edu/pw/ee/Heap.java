package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.List;
import pl.edu.pw.ee.services.HeapInterface;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private final List<T> elements = new ArrayList<>();
    private int length = 0;
    
    public void put(T item){
        elements.add(item);
        length++;
        heapUp();
    }

    public T pop(){
        if(length==0){
            throw new ArrayIndexOutOfBoundsException("Heap is empty");
        }
        T dropItem = elements.get(0);
        swap(0, length-1);
        if(length!=0)
            elements.remove(length-1);
        length--;
        heapDown();
        return dropItem;
    }

    private void swap(int firstIndex, int secondIndex){
        if(firstIndex<0 || secondIndex<0 || firstIndex>length-1 || secondIndex>length-1){
            return;
        }
        T tmp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, tmp);
    }

    private void heapUp(){
        int parentIndex = (length-2)/2;
        int childIndex = length-1;
        while (elements.get(parentIndex).compareTo(elements.get(childIndex))<0){
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }

    private void heapDown(){
        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (true){
            if (elements.size()==0){
                break;
            }
            T parent = elements.get(parentIndex);
            T leftChild = null;
            T rightChild = null;
            if(leftChildIndex >= length){
                break;
            }
            if(rightChildIndex >= length){
                leftChild = elements.get(leftChildIndex);
                if(leftChild.compareTo(parent)>0){
                    swap(leftChildIndex, parentIndex);
                }
                parentIndex = leftChildIndex;

            } else {
                leftChild = elements.get(leftChildIndex);
                rightChild = elements.get(rightChildIndex);
                T largestChild = null;
                int largestChildIndex = -1;
                if(leftChild.compareTo(rightChild)>=0){
                    largestChild = leftChild;
                    largestChildIndex = leftChildIndex;
                } else {
                    largestChild = rightChild;
                    largestChildIndex = rightChildIndex;
                }
                if(largestChild.compareTo(parent)>=0){
                    swap(parentIndex, largestChildIndex);
                }
                parentIndex = largestChildIndex;
            }
            leftChildIndex = parentIndex*2 + 1;
            rightChildIndex = parentIndex*2 + 2;
        }
    }

}
