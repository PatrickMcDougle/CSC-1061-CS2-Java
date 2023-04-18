package edu.csc1061.ch25;

import java.util.Collection;

@SuppressWarnings("unchecked")
public interface ITree<E> extends Collection<E> {
  /** Return true if the element is in the tree */
  public boolean search(E e);

  /**
   * Insert element e into the binary tree Return true if the element is inserted
   * successfully
   */
  public boolean insert(E e);

  /**
   * Delete the specified element from the tree Return true if the element is
   * deleted successfully
   */
  public boolean delete(E e);

  /** Get the number of elements in the tree */
  public int getSize();

  /** Return true if the tree is empty */
  @Override
  public default boolean isEmpty() {
    return this.size() == 0;
  }

  @Override
  public default boolean contains(Object e) {
    return search((E) e);
  }

  @Override
  public default boolean add(E e) {
    return insert(e);
  }

  @Override
  public default boolean remove(Object e) {
    return delete((E) e);
  }

  @Override
  public default int size() {
    return getSize();
  }

  @Override
  public default boolean containsAll(Collection<?> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    // Left as an exercise
    return false;
  }

  @Override
  public default Object[] toArray() {
    // Left as an exercise
    return null;
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    // Left as an exercise
    return null;
  }
}
