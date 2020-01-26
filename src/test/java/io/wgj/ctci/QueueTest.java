package io.wgj.ctci;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
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
        q.add(0);
    }

    @Test
    public void remove_newQueue() {
        Queue<Integer> q = new Queue<>();
        exception.expect(ArrayIndexOutOfBoundsException.class);
        q.remove();

    }

    @Test
    public void peek_newQueue() {
        Queue<Integer> q = new Queue<>();
        assertNull(q.peek());
    }
}
