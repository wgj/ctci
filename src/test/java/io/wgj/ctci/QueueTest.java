package io.wgj.ctci;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueueTest {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void queue_new() {
    Queue<Integer> q = new Queue<>();
  }

  @Test
  public void add_newQueue() {
    Queue<Integer> q = new Queue<>();
    q.add(1);
  }

  @Test
  public void remove_newQueue() {
    Queue<Integer> q = new Queue<>();
    exception.expect(IndexOutOfBoundsException.class);
    q.remove();
  }

  @Test
  public void add_remove_intermixed() {
    Queue<Integer> q = new Queue<>();
    q.add(1);
    int a = q.remove();
    assertEquals(1, a);
    assertEquals(0, q.getSize());
    q.add(2);
    q.add(3);
    a = q.remove();
    assertEquals(2, a);
    assertEquals(1, q.getSize());
  }

  @Test
  public void add_wrapAround() {
    Queue<Integer> q = new Queue<>();
    q.add(1);
    assertEquals(1, q.getSize());
    q.add(2);
    assertEquals(2, q.getSize());
    q.add(3);
    assertEquals(3, q.getSize());
    q.add(4);
    assertEquals(4, q.getSize());
    q.add(5);
    assertEquals(5, q.getSize());
    q.add(6);
    assertEquals(6, q.getSize());
    q.add(7);
    assertEquals(7, q.getSize());
    q.add(8);
    assertEquals(8, q.getSize());
    q.add(9);
    assertEquals(9, q.getSize());
    q.add(10);
    assertEquals(10, q.getSize());

    assertEquals(1, (int) q.remove());
    assertEquals(2, (int) q.remove());
    assertEquals(3, (int) q.remove());
    assertEquals(4, (int) q.remove());
    assertEquals(5, (int) q.remove());
    assertEquals(6, (int) q.remove());
    assertEquals(7, (int) q.remove());
    assertEquals(8, (int) q.remove());
    assertEquals(9, (int) q.remove());
    assertEquals(10, (int) q.remove());

    assertEquals(0, q.getSize());
  }


  @Test
  public void peek_newQueue() {
    Queue<Integer> q = new Queue<>();
    assertNull(q.peek());
  }

  @Test
  public void peek_emptyQueue() {
    Queue<Integer> q = new Queue<>();
    q.add(1);
    q.remove();
    assertNull(q.peek());
  }

  @Test
  public void peek_notEmptyQueue() {
    Queue<Integer> q = new Queue<>();
    q.add(1);
    assertEquals(1, (int) q.peek());
  }
}
