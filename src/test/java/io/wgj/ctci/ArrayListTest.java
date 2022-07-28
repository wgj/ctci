package io.wgj.ctci;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayListTest {
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void arrayList_new() {
    ArrayList<Integer> al = new ArrayList<>();
  }

  @Test
  public void arrayList_add() {
    ArrayList<Integer> al = new ArrayList<>();
    al.add(1);
  }

  @Test
  public void arrayList_size() {
    ArrayList<Integer> al = new ArrayList<>();
    assertEquals(0, al.size());
    al.add(1);
    assertEquals(1, al.size());
  }

  @Test
  public void arrayList_grow() {
    ArrayList<Integer> al = new ArrayList<>();
    assertEquals(0, al.size());
    Integer[] ints = {1, 2, 3, 4, 5};
    for (Integer i : ints) {
      al.add(i);
    }
    assertEquals(5, al.size());
  }

  @Test
  public void arrayList_get() {
    ArrayList<Integer> al = new ArrayList<>();
    al.add(1);
    assertEquals((Integer) 1, al.get(0));
  }

  @Test
  public void arrayList_rangeCheck() {
    ArrayList<Integer> al = new ArrayList<>();
    exception.expect(IndexOutOfBoundsException.class);
    al.get(0);
  }

  @Test
  public void arrayList_remove_front() {
    ArrayList<Integer> al = new ArrayList<>();
    Integer[] add_ints = {1, 2, 3, 4, 5};
    for (Integer i : add_ints) {
      al.add(i);
    }
    assertEquals(add_ints[0], al.remove(0));

    Integer[] get_ints = {2, 3, 4, 5};
    for (int i = 0; i <= get_ints.length - 1; i++) {
      assertEquals(get_ints[i], al.get(i));
    }
    assertEquals(4, al.size());
  }

  @Test
  public void arrayList_remove_middle() {
    ArrayList<Integer> al = new ArrayList<>();
    Integer[] add_ints = {1, 2, 3, 4, 5};
    for (Integer i : add_ints) {
      al.add(i);
    }
    assertEquals(add_ints[2], al.remove(2));

    Integer[] get_ints = {1, 2, 4, 5};
    for (int i = 0; i <= get_ints.length - 1; i++) {
      assertEquals(get_ints[i], al.get(i));
    }
    assertEquals(4, al.size());
  }

  @Test
  public void arrayList_remove_back() {
    ArrayList<Integer> al = new ArrayList<>();
    Integer[] add_ints = {1, 2, 3, 4, 5};
    for (Integer i : add_ints) {
      al.add(i);
    }
    assertEquals(add_ints[4], al.remove(4));

    Integer[] get_ints = {1, 2, 3, 4};
    for (int i = 0; i <= get_ints.length - 1; i++) {
      assertEquals(get_ints[i], al.get(i));
    }
    assertEquals(4, al.size());
  }
  @Test
  public void arrayList_isEmpty() {
    ArrayList<Integer> al = new ArrayList<>();
    assertTrue(al.isEmpty());
    al.add(0);
    assertFalse(al.isEmpty());
    al.remove(0);
    assertTrue(al.isEmpty());
  }
  @Test
  public void arrayList_set() {
    ArrayList<Integer> al = new ArrayList<>();
    al.add(0);
    assertEquals((Integer) 0, al.get(0));
    al.set(0, 42);
    assertEquals((Integer) 42, al.get(0));
  }
  @Test
  public void arrayList_Iterator() {
    ArrayList<Integer> al = new ArrayList<>();
    Integer[] test = {1, 2, 3, 4, 5};
    for (Integer i : test) {
      al.add(i);
    }
    int index = 0;
    for (Integer i : al) {
      assertEquals(al.get(index), i);
      index++;
    }
  }
}
