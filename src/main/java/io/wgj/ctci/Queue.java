package io.wgj.ctci;

public class Queue<E> {

  ArrayList<E> list;
  int frontIndex;
  int backIndex;

  public Queue() {
    list = new ArrayList<>();
    frontIndex = 0;
    backIndex = 0;
  }

  public void enqueue(E e) {
    list.add(e);
    backIndex++;
  }

  public void dequeue() {
    if (! isEmpty()) {
      frontIndex++;
    }
  }

  public E front() {
    if (frontIndex == backIndex) {
      return null;
    }
    return list.get(frontIndex);
  }

  public boolean isEmpty() {
    return frontIndex == backIndex;
  }
}
