package io.wgj.ctci;

public class Queue<E> {

  Object[] queue;
  int head;
  int tail;
  static final int STARTING_CAPACITY = 2;
  int size;

  public Queue() {
    queue = new Object[STARTING_CAPACITY];
    head = 0;
    tail = 0;
    size = 0;
  }

  public void add(E e) {
    // TODO(wgj): Handle wrap around.
    // TODO(wgj): Check if there's space before inserting.
    queue[tail] = e;
    size++;
    tail = nextTail();
    if (getSize() == queue.length) {
      grow();
    }
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
    int newQueueIndex = 0;
    int queueIndex = head;
    while (queueIndex != tail) {
      newQueue[newQueueIndex] = queue[queueIndex];
      // Wrap around because we reached the end of the array, but not the end of the queue.
      if (queueIndex == queue.length - 1) {
        queueIndex = 0;
      } else {
        queueIndex++;
      }
      newQueueIndex++;
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
    // Wrap around if we're at the end of `queue` and there's still space.
    if (tail > 0 && tail == queue.length - 1) {
      return 0;
      // Leave `tail` alone if it's an empty queue.
    } else if (head == tail && getSize() == 0) {
      return tail;
      // Increment `tail` normally.
    } else {
      return tail + 1;
    }
  }
}
