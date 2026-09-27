package deque;

import java.util.NoSuchElementException;

/**
 * A node-backed implementation of the Deque ADT.
 *
 * @param <T> the type of elements in this deque.
 */
public class LinkedDeque<T> implements Deque<T> {

  private final Node<T> head;  // front sentinel
  private final Node<T> tail;  // back sentinel

  private static class Node<T> {
    T value;
    Node<T> prev;
    Node<T> next;

    Node(T value) {
      this.value = value;
    }
  }

  public LinkedDeque() {
    head = new Node<>(null);
    tail = new Node<>(null);
    head.next = tail;
    tail.prev = head;
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

  // Pre: before and after are neighbors, with before.next == after.
  private void insertBetween(T value, Node<T> before, Node<T> after) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Pre: target is a real node, never a sentinel.
  private void removeNode(Node<T> target) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
