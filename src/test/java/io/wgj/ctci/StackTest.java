package io.wgj.ctci;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class StackTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testStackOneInt() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        int r = s.pop();
        assertEquals(1, r);
    }

    @Test
    public void testStackOneString() {
        Stack<String> s = new Stack<>();
        s.push("one");
        String r = s.pop();
        assertEquals("one", r);
    }

    @Test
    public void testPushPopsIntermixed() {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        assertEquals(0, (int) s.pop());
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, (int) s.pop());
        assertEquals(2, (int) s.pop());
        s.push(4);
        assertEquals(4, (int) s.pop());
        assertEquals(1, (int) s.pop());
        assertEquals(0, s.size());
    }

    @Test
    public void testStackMultipleInts() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        assertEquals(3, (int) s.pop());
        assertEquals(2, (int) s.pop());
        assertEquals(1, (int) s.pop());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackUnderFlow() {
        new Stack<Integer>().pop();
    }

    @Test
    public void testPeek() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        assertEquals(1, (int) s.peek());
        s.push(2);
        assertEquals(2, (int) s.peek());
        s.push(3);
        assertEquals(3, (int) s.peek());
        s.pop();
        assertEquals(2, (int) s.peek());
        s.pop();
        assertEquals(1, (int) s.peek());
    }

    @Test
    public void testSize() {
        Stack<Integer> s = new Stack<>();
        assertEquals(0, s.size());
        s.push(1);
        assertEquals(1, s.size());
        s.push(2);
        assertEquals(2, s.size());
        s.push(3);
        assertEquals(3, s.size());
        s.pop();
        assertEquals(2, s.size());
        s.pop();
        assertEquals(1, s.size());
        s.pop();
        assertEquals(0, s.size());
    }

    @Test
    public void testSizeIntermixed() {
        Stack<Integer> s = new Stack<>();
        assertEquals(0, s.size());
        s.push(0);
        assertEquals(1, s.size());
        s.push(0);
        s.push(0);
        assertEquals(3, s.size());
        s.pop();
        s.push(0);
        assertEquals(3, s.size());
        s.pop();
        s.pop();
        s.pop();
        assertEquals(0, s.size());
    }

    @Test
    public void testSizeEmptyStack() {
        Stack<Integer> s = new Stack<>();
        assertEquals(0, s.size());
        s.push(0);
        s.push(0);
        s.push(0);
        s.pop();
        s.pop();
        s.pop();
        assertEquals(0, s.size());
    }

    @Test
    public void testContentsAfterGrowth() {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        assertEquals(2, (int) s.pop());
        assertEquals(1, (int) s.pop());
        assertEquals(0, (int) s.pop());
    }
}
