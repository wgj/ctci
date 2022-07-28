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
