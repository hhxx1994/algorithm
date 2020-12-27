package one;

import java.util.ArrayList;

/**
 * @author huanghaoxing
 */
public class MaxHeap<E extends Comparable> {
  ArrayList<E> array;

  public MaxHeap(int capacity) {
    array = new ArrayList<>(capacity);
  }

  private int leftChild(int index) {
    return index * 2 + 1;
  }

  private int rightChild(int index) {
    return index * 2 + 2;
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  public void add(E e) {
    array.add(e);
    siftUp(array.size() - 1);
  }

  public E extractMax() {
    swap(0, array.size() - 1);
    E max = array.remove(array.size() - 1);
    siftDown(0);
    return max;
  }

  private void siftDown(int index) {
    while (leftChild(index) < array.size()) {
      int i = leftChild(index);
      if (i + 1 < array.size() && array.get(i + 1).compareTo(array.get(i)) > 0) {
        i++;
      }
      if (array.get(i).compareTo(array.get(index)) <= 0) {
        break;
      }
      swap(i, index);
      index = i;
    }
  }

  private void siftUp(int index) {
    // 上浮的条件
    while (parent(index) >= 0 && array.get(parent(index)).compareTo(array.get(index)) < 0) {
      swap(parent(index), index);
      index = parent(index);
    }
  }

  private void swap(int parent, int index) {
    E temp = array.get(parent);
    array.set(parent, array.get(index));
    array.set(index, temp);
  }

  public static void main(String[] args) {
    MaxHeap mapHeap = new MaxHeap(10);
    for (int i = 0; i < 10; i++)
      mapHeap.add(i);

    for (int i = 0; i < 10; i++)
      System.out.println(mapHeap.extractMax());

  }

}
