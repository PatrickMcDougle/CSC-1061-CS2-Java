/**
 * Code for Class.
 *
 * <p>
 * CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch24;

@SuppressWarnings("unchecked")
public class MyArrayList<E> extends MyList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];
    private int size = 0; // Number of elements in the list

    /** Create an empty list */
    public MyArrayList() {}

    /**
     * Create a list from an array of objects
     *
     * @param objects
     */
    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]); // Warning: don't use super(objects)!
        }
    }

    @Override
    public void add(int index, E e) {
        // Ensure the index is in the right range
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity();

        // Move the elements to the right after the specified index
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // Insert new element to data[index]
        data[index] = e;

        // Increase size by 1
        size++;
    } // See https://liveexample.pearsoncmg.com/dsanimation/Figure24_4.html

    /** Create a new larger array, double the current size + 1 */
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E e = data[index];

        // Shift data to the left
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }

        data[size - 1] = null; // This element is now null

        // Decrement size
        size--;

        return e;
    } // See https://liveexample.pearsoncmg.com/dsanimation/Figure24_5.html

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (Object item : this) {
            sb.append(item);
            sb.append(", "); // Separate two elements with a comma
        }
        sb.replace(sb.length() - 2, sb.length(), "]"); // replace the last ", " with a closing
                                                       // bracket "]"

        return sb.toString();
    }

    private String toStringOldVersion() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }

        return result.toString() + "]";
    }

    /** Trims the capacity to current size */
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // If size == capacity, no need to trim
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0; // Current index

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            if (current == 0) {
                throw new IllegalStateException(); // next() has not been called yet
            }
            MyArrayList.this.remove(--current);
        }
    }

    @Override
    public int size() {
        return size;
    }
}
