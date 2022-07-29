package io.wgj.ctci;

public class Queue<E> {

  ArrayList<E> al;
  int frontIndex;
  int backIndex;

  public Queue() {
    al = new ArrayList<>();
    frontIndex = 0;
    backIndex = 0;
  }

  public void enqueue(E e) {
    al.add(e);
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
    return al.get(frontIndex);
  }

  public boolean isEmpty() {
    return frontIndex == backIndex;
  }
}
