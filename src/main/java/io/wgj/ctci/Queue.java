package io.wgj.ctci;

public class Queue<E> {

  Object[] queue;
  int head;
  int tail;
  static final int STARTING_CAPACITY = 1;
  int size;

  public Queue() {
    queue = new Object[STARTING_CAPACITY];
    head = 0;
    tail = 0;
    size = 0;
  }

  public void add(E e) {
    // TODO(wgj): Handle wrap around.
    if (getSize() == queue.length) {
      grow();
    }
    queue[nextTail()] = e;
    size++;
    tail = nextTail();
  }

  public E remove() {
    if (size == 0) {
      throw new IndexOutOfBoundsException();
    }
    @SuppressWarnings("unchecked")
    E e = (E) queue[head];
    head++;
    size--;
    return e;
  }

  public E peek() {
    if (size == 0) {
      return null;
    }
    @SuppressWarnings("unchecked")
    E e = (E) queue[head];
    return e;
  }

  private void grow() {
    int newLength = queue.length * 2;
    Object[] newQueue = new Object[newLength];
    // Loop from head to cap
    int copyIndex = 0;
    for (int i = head; i < queue.length - 1; i++) {
      newQueue[i] = queue[i];
      copyIndex++;
    }
    // Loop from 0 to tail
    for (int i = 0; i < tail; i++) {
      newQueue[copyIndex + i] = queue[i];
    }
    queue = newQueue;
    head = 0;
    tail = size;
  }

  public int getSize() {
    return size;
  }

  private int nextHead() {
    return -1;
  }

  private int nextTail() {
    // Wrap around since we're at the end of `queue`.
    if (tail > 0 && tail == queue.length - 1) {
      return 0;
    } else if (head == tail) {
      return tail;
    } else {
      return tail++;
    }
  }
}
