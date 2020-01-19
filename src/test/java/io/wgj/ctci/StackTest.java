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

    @Test
    public void testGrowth() {
        Stack<Integer> s = new Stack<>(1);
        int startingCapacity = s.capacity();
        s.push(1);
        s.push(2);
        s.push(3);
        int newCapacity = s.capacity();
        assertTrue(startingCapacity < newCapacity);

    }

    @Test
    public void testGrowthWithLeftOver() {
        int cap = 257; // 257 << 2 is 1028, and trigger a "left over".
        Stack<Integer> s = new Stack<>(cap);
        assertEquals(cap, s.capacity());
        for (int i = 0; i < cap + 1; i++) {
            s.push(0);
        }
        // Our new capacity will use what's left over from s.grow().
        assertEquals(s.maxSize(), s.capacity());
    }

    @Test
    public void testMaxArraySize() {
        Stack<Integer> s = new Stack<>(1024); // Stack.MAX_ARRAY_SIZE
        for (int i = 0; i < s.maxSize(); i++) {
            s.push(0);
        }
        thrown.expect(UnsupportedOperationException.class);
        s.push(0);
    }

    @Test
    public void testTooLargeStartingArray() {
        Stack<Integer> s = new Stack<>(2048);
        assertEquals(1024, s.maxSize());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackUnderFlow() {
        new Stack().pop();
    }

    @Test
    public void TestPeek() {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        assertEquals(0, (int) s.peek());
    }

    @Test
    public void TestSize() {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        assertEquals(1, s.size());
    }

    @Test
    public void TestSizeEmptyStack() {
        Stack<Integer> s = new Stack<>();
        assertEquals(0, s.size());
    }

}
