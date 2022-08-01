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
  public void add_newQueue() {
    Queue<Integer> q = new Queue<>();
    q.enqueue(1);
  }

  @Test
  public void remove_newQueue() {
    Queue<Integer> q = new Queue<>();
    q.dequeue();
  }

  @Test
  public void front_newQueue() {
    Queue<Integer> q = new Queue<>();
    assertNull(q.front());
  }

  @Test
  public void front_emptyQueue() {
    Queue<Integer> q = new Queue<>();
    q.enqueue(1);
    q.dequeue();
    assertNull(q.front());
  }

  @Test
  public void front_notEmptyQueue() {
    Queue<Integer> q = new Queue<>();
    q.enqueue(1);
    assertEquals(1, (int) q.front());
  }
}
