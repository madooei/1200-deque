package deque;

import java.util.NoSuchElementException;

/**
 * An array-backed implementation of the Deque ADT.
 *
 * @param <T> the type of elements in this deque.
 */
public class ArrayDeque<T> implements Deque<T> {

  private T[] arr;    // the backing array, used as a circular array
  private int front;
  private int size;

  // arr only ever holds T, so the cast is safe.
  @SuppressWarnings("unchecked")
  public ArrayDeque() {
    arr = (T[]) new Object[10];
    front = 0;
    size = 0;
  }

  // Turns an offset from the first end into an index into arr, wrapping
  // around the end of the array.
  private int index(int offset) {
    return (front + offset) % arr.length;
  }

  // Returns the index one slot to the left of i, wrapping from 0 to the last
  // index. We add arr.length before taking the remainder because Java's % can
  // return a negative result: (0 - 1) % arr.length would be -1.
  private int before(int i) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void addFirst(T item) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void addLast(T item) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void removeFirst() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void removeLast() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public T getFirst() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public T getLast() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public boolean isEmpty() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // bigger only ever holds T, so the cast is safe.
  @SuppressWarnings("unchecked")
  private void grow() {
    T[] bigger = (T[]) new Object[arr.length * 2];
    // The items may wrap around the end of the old array, so copy them in
    // deque order rather than slot by slot.
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[index(i)];
    }
    arr = bigger;
    front = 0;
  }
}
