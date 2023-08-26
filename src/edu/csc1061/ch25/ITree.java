/**
 * Code for Class.
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author  Patrick McDougle
 * @version %I%, %G%
 * @since   1.0
 */
package edu.csc1061.ch25;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public interface ITree<E> extends Collection<E> {

  // ////////// ////////// //
  // Public Interface Methods
  // ////////// ////////// //

  public void clear();

  /**
   * Delete the specified element from the tree Return true if the element is
   * deleted successfully
   */
  public boolean delete(E e);

  public String inOrder();

  /**
   * Insert element e into the binary tree Return true if the element is inserted
   * successfully
   */
  public boolean insert(E e);

  /**
   * Get the number of elements in the tree
   */
  public int getSize();

  public String postOrder();

  public String preOrder();

  /**
   * Return true if the element is in the tree
   */
  public boolean search(E e);

  // ////////// ////////// //
  // Public Override Methods
  // ////////// ////////// //

  @Override
  public default boolean add(E e) {
    return insert(e);
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    if (c == null) {
      return false;
    }
    c.forEach(this::insert);
    return true;
  }

  @Override
  public default boolean contains(Object e) {
    return search((E) e);
  }

  @Override
  public default boolean containsAll(Collection<?> c) {
    if (c == null) {
      return false;
    }

    boolean foundAll = true;
    Iterator<?> iterator = c.iterator();
    while (iterator.hasNext() && foundAll) {
      foundAll &= search((E) iterator.next());
    }

    return foundAll;
  }

  @Override
  public default boolean isEmpty() {
    return getSize() == 0;
  }

  @Override
  public default boolean remove(Object e) {
    return delete((E) e);
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    if (c == null) {
      return false;
    }

    Iterator<?> iterator = c.iterator();
    while (iterator.hasNext()) {
      delete((E) iterator.next());
    }

    return true;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    // remove everything else.

    if (c == null) {
      return false;
    }

    Iterator<E> iterator = iterator();
    while (iterator.hasNext()) {
      if (!c.contains(iterator.next())) {
        iterator.remove();
      }
    }
    return true;
  }

  @Override
  public default int size() {
    return getSize();
  }

  @Override
  public default Object[] toArray() {
    Iterator<E> iterator = iterator();
    ArrayList<E> list = new ArrayList<>();

    while (iterator.hasNext()) {
      list.add(iterator.next());
    }

    return list.toArray();
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    Iterator<E> iterator = iterator();
    ArrayList<E> list = new ArrayList<>();

    while (iterator.hasNext()) {
      list.add(iterator.next());
    }

    return list.toArray(array);
  }
}
