package io.wgj.ctci;

import java.util.Iterator;

public class ArrayList <E> implements Iterable<E> {
  transient Object[] elements;
  static final int STARTING_CAPACITY = 1;
  private int size;

  public ArrayList() {
    elements = new Object[STARTING_CAPACITY];
    size = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean add(E e) {
    if (size >= elements.length) {
      grow();
    }
    elements[size] = e;
    size++;
    return true;
  }

  private void grow() {
    var newElements = new Object[elements.length * 2];
    var i = 0;
    for (Object e : elements) {
      newElements[i] = e;
      i++;
    }
    elements = newElements;
  }

  public E get(int index) {
    rangeCheck(index);
    return elementData(index);
  }

  public E remove(int index) {
    rangeCheck(index);
    E removedObject = elementData(index);
    if (elements.length > 1) {
      // elements after the removed index shift to the left.
      for (int i = index; i < size-1; i++) {
        elements[i] = elements[i+1];
      }
    }
    elements[size-1] = null;
    size--;
    return removedObject;
  }

  public boolean isEmpty() {
    return size == 0;
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
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
  }
  @SuppressWarnings("unchecked")
  private E elementData(int index) {
    return (E) elements[index];
  }
}
