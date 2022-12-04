package edu.csc1061.ch24;

import java.util.Collection;

public abstract class MyList<E> implements Collection<E> {

  /** Add a new element at the specified index in this list */
  public abstract void add(int index, E e);

  /** Return the element from this list at the specified index */
  public abstract E get(int index);

  /**
   * Return the index of the first matching element in this list. Return -1 if no match.
   */
  public abstract int indexOf(Object e);

  /**
   * Return the index of the last matching element in this list Return -1 if no match.
   */
  public abstract int lastIndexOf(E e);

  /**
   * Remove the element at the specified position in this list Shift any subsequent elements to
   * the left. Return the element that was removed from the list.
   */
  public abstract E remove(int index);

  /**
   * Replace the element at the specified position in this list with the specified element and
   * returns the new set.
   */
  public abstract E set(int index, E e);

  /** Add a new element at the end of this list */
  @Override
  public boolean add(E e) {
    add(size(), e);
    return true;
  }

  /** Return true if this list contains no elements */
  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Remove the first occurrence of the element e from this list. Shift any subsequent
   * elements to the left. Return true if the element is removed.
   */
  @Override
  public boolean remove(Object e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }

    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public Object[] toArray() {
    // Left as an exercise
    return null;
  }

  @Override
  public <T> T[] toArray(T[] array) {
    // Left as an exercise
    return null;
  }
}
