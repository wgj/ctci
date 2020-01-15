package io.wgj.ctci;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class StackTest {
    @Test
    public void testStackOneInt() {
        Stack s = new Stack();
        s.push(1);
        int r = s.pop();
        assertEquals(1, r);
    }

    @Test
    public void testStackMultipleInts() {
        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 2; i < 10; i = i + 2) {
            expected.add(i);
        }

        Stack s = new Stack();
        for (int e : expected) {
            s.push(e);
        }

        Collections.reverse(expected);
        for (int e : expected) {
            assertEquals(e, s.pop());
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackOverFlow() {
        Stack s = new Stack();
        for (int i = 0; i < 11; i++) {
            s.push(i);
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackUnderFlow() {
        new Stack().pop();
    }
}
