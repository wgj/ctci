package io.wgj.ctci;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class StackTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

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
        for (int i = 0; i < 10; i++) {
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

    @Test
    public void testStackRandomInts() {
        Random r = new Random();

        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            expected.add(r.nextInt());
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

    @Test
    public void testStackOverFlow() {
        Stack s = new Stack();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        s.push(11);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackUnderFlow() {
        new Stack().pop();
    }
}
