package io.wgj.ctci;

import java.util.Iterator;

public class ArrayList <E> implements Iterable<E> {
  transient Object[] elements;
  static final int STARTING_CAPACITY = 1;
  private int size;
  private int capacity;

  public ArrayList() {
    elements = new Object[STARTING_CAPACITY];
    size = 0;
    capacity = STARTING_CAPACITY;
  }

  public int size() {
    return this.size;
  }

  public boolean add(E e) {
    if (size >= capacity) {
      grow();
    }
    elements[size] = e;
    size++;
    return true;
  }

  private void grow() {
    var newCapacity = capacity*2;
    var newElements = new Object[newCapacity];
    var i = 0;
    for (Object e : elements) {
      newElements[i] = e;
      i++;
    }
    capacity = newCapacity;
    elements = newElements;
  }

  public E get(int index) {
    rangeCheck(index);
    return elementData(index);
  }

  public E remove(int index) {
    rangeCheck(index);
    E removedObject = elementData(index);
    // elements after the removed index shift to the left.
    for (int i = index; i < size-1; i++) {
      elements[i] = elements[i+1];
    }
    size--;
    return removedObject;
  }

  public boolean isEmpty() {
    if (size != 0) {
      return false;
    }
    return true;
  }

  public E set(int index, E e) {
    rangeCheck(index);
    E replacedObject = elementData(index);
    elements[index] = e;
    return replacedObject;
  }

  public Iterator<E> iterator() {
    Iterator<E> it = new Iterator<>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        try {
          rangeCheck(index+1);
        } catch (IndexOutOfBoundsException e) {
          return false;
        }
        return true;
      }

      @Override
      public E next() {
        E e = elementData(index);
        index++;
        return e;
      }
    };
    return it;
  }

   private void rangeCheck(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }
  @SuppressWarnings("unchecked")
  private E elementData(int index) {
    return (E) elements[index];
  }
}
