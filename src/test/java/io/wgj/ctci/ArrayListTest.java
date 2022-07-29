package io.wgj.ctci;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ArrayListTest {
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void arrayList() {
    ArrayList<Integer> list = new ArrayList<>();
    assertEquals(0, list.size());
    Integer[] ints = {1, 2, 3, 4, 5};
    for (Integer i : ints) {
      list.add(i);
    }
    assertEquals(5, list.size());
    assertEquals((Integer) 1, list.get(0));
    assertEquals((Integer) 5, list.get(list.size()-1));
  }

  @Test
  public void arrayList_rangeCheck() {
    ArrayList<Integer> list = new ArrayList<>();
    exception.expect(IndexOutOfBoundsException.class);
    list.get(0);
  }

  private boolean compareArrayToArrayList(Integer[] array, ArrayList<Integer> list) {
    if (array.length != list.size()) {
      return false;
    }
    for (int i = 0; i < array.length; i++ ) {
      if (! array[i].equals(list.get(i))) {
        return false;
      }
    }
    return true;
  }
  @Test
  public void arrayList_remove_front() {
    ArrayList<Integer> list = new ArrayList<>();
    Integer[] ints = {1, 2, 3, 4, 5};
    for (Integer i : ints) {
      list.add(i);
    }
    assertEquals(ints[0], list.remove(0));
    Integer[] ints_with_front_removed = {2, 3, 4, 5};
    compareArrayToArrayList(ints_with_front_removed, al);
  }

  @Test
  public void arrayList_remove_middle() {
    ArrayList<Integer> list = new ArrayList<>();
    Integer[] ints = {1, 2, 3, 4, 5};
    for (Integer i : ints) {
      list.add(i);
    }
    assertEquals(ints[2], list.remove(2));
    Integer[] ints_with_middle_removed = {1, 2, 4, 5};
    compareArrayToArrayList(ints_with_middle_removed, al);
  }

  @Test
  public void arrayList_remove_back() {
    ArrayList<Integer> list = new ArrayList<>();
    Integer[] ints = {1, 2, 3, 4, 5};
    for (Integer i : ints) {
      list.add(i);
    }
    assertEquals(ints[4], list.remove(4));
    Integer[] ints_with_back_removed = {1, 2, 3, 4};
    compareArrayToArrayList(ints_with_back_removed, al);
  }

  @Test
  public void arrayList_isEmpty() {
    ArrayList<Integer> list = new ArrayList<>();
    assertTrue(list.isEmpty());
    list.add(0);
    assertFalse(list.isEmpty());
    list.remove(0);
    assertTrue(list.isEmpty());
  }

  @Test
  public void arrayList_set() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0);
    assertEquals((Integer) 0, list.get(0));
    list.set(0, 42);
    assertEquals((Integer) 42, list.get(0));
  }

  @Test
  public void arrayList_Iterator() {
    ArrayList<Integer> list = new ArrayList<>();
    Integer[] test = {1, 2, 3, 4, 5};
    for (Integer i : test) {
      list.add(i);
    }
    int index = 0;
    for (Integer i : list) {
      assertEquals(list.get(index), i);
      index++;
    }
  }
}
