package deque;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The contract test suite for the Deque ADT, written against the Deque interface
 * alone. A concrete subclass supplies createDeque() to pick the implementation.
 */
public abstract class DequeTest {

  private Deque<Integer> deque;

  protected abstract Deque<Integer> createDeque();

  @BeforeEach
  public void setup() {
    deque = createDeque();
  }

  @Test
  public void newDequeIsEmpty() {
    assertTrue(deque.isEmpty());
  }

  @Test
  public void getFirstOnEmptyDequeThrows() {
    try {
      deque.getFirst();
      fail("expected NoSuchElementException when calling getFirst on an empty deque");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void getLastOnEmptyDequeThrows() {
    try {
      deque.getLast();
      fail("expected NoSuchElementException when calling getLast on an empty deque");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void removeFirstOnEmptyDequeThrows() {
    try {
      deque.removeFirst();
      fail("expected NoSuchElementException when calling removeFirst on an empty deque");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void removeLastOnEmptyDequeThrows() {
    try {
      deque.removeLast();
      fail("expected NoSuchElementException when calling removeLast on an empty deque");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void addFirstMakesDequeNonEmpty() {
    deque.addFirst(10);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void addLastMakesDequeNonEmpty() {
    deque.addLast(10);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void getFirstReturnsItemAddedFirst() {
    deque.addFirst(10);
    assertEquals(10, deque.getFirst());
  }

  @Test
  public void getLastReturnsItemAddedLast() {
    deque.addLast(10);
    assertEquals(10, deque.getLast());
  }

  @Test
  public void onlyItemIsAlsoTheLast() {
    deque.addFirst(10);
    assertEquals(10, deque.getLast());
  }

  @Test
  public void onlyItemIsAlsoTheFirst() {
    deque.addLast(10);
    assertEquals(10, deque.getFirst());
  }

  @Test
  public void getFirstDoesNotRemoveTheItem() {
    deque.addFirst(10);
    deque.getFirst();
    assertFalse(deque.isEmpty());
  }

  @Test
  public void getLastDoesNotRemoveTheItem() {
    deque.addLast(10);
    deque.getLast();
    assertFalse(deque.isEmpty());
  }

  @Test
  public void removeFirstOnlyItemLeavesDequeEmpty() {
    deque.addFirst(10);
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void removeLastOnlyItemLeavesDequeEmpty() {
    deque.addLast(10);
    deque.removeLast();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void removeLastCanTakeItemAddedFirst() {
    deque.addFirst(10);
    deque.removeLast();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void removeFirstCanTakeItemAddedLast() {
    deque.addLast(10);
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void getFirstAfterRemovingOnlyItemThrows() {
    deque.addFirst(10);
    deque.removeFirst();
    try {
      deque.getFirst();
      fail("expected NoSuchElementException after removing the only item");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void addFirstAfterRemovingOnlyItemBecomesTheFirst() {
    deque.addFirst(10);
    deque.removeFirst();
    deque.addFirst(20);
    assertEquals(20, deque.getFirst());
  }

  @Test
  public void addLastAfterRemovingOnlyItemBecomesTheLast() {
    deque.addLast(10);
    deque.removeLast();
    deque.addLast(20);
    assertEquals(20, deque.getLast());
  }

  @Test
  public void addFirstPutsTheNewItemBeforeTheOthers() {
    deque.addFirst(10);
    deque.addFirst(20);
    assertEquals(20, deque.getFirst());
  }

  @Test
  public void addFirstDoesNotChangeTheLast() {
    deque.addFirst(10);
    deque.addFirst(20);
    assertEquals(10, deque.getLast());
  }

  @Test
  public void addLastPutsTheNewItemAfterTheOthers() {
    deque.addLast(10);
    deque.addLast(20);
    assertEquals(20, deque.getLast());
  }

  @Test
  public void addLastDoesNotChangeTheFirst() {
    deque.addLast(10);
    deque.addLast(20);
    assertEquals(10, deque.getFirst());
  }

  @Test
  public void removeFirstRevealsTheNextItem() {
    deque.addLast(10);
    deque.addLast(20);
    deque.removeFirst();
    assertEquals(20, deque.getFirst());
  }

  @Test
  public void removeLastRevealsThePreviousItem() {
    deque.addLast(10);
    deque.addLast(20);
    deque.removeLast();
    assertEquals(10, deque.getLast());
  }

  @Test
  public void removeFirstDoesNotChangeTheLast() {
    deque.addLast(10);
    deque.addLast(20);
    deque.addLast(30);
    deque.removeFirst();
    assertEquals(30, deque.getLast());
  }

  @Test
  public void removeLastDoesNotChangeTheFirst() {
    deque.addLast(10);
    deque.addLast(20);
    deque.addLast(30);
    deque.removeLast();
    assertEquals(10, deque.getFirst());
  }

  @Test
  public void addFirstThenAddLastKeepBothEnds() {
    deque.addFirst(4);
    deque.addLast(9);
    deque.addFirst(2);
    assertEquals(2, deque.getFirst());
  }

  @Test
  public void addLastAfterAddFirstIsTheLast() {
    deque.addFirst(4);
    deque.addLast(9);
    deque.addFirst(2);
    assertEquals(9, deque.getLast());
  }

  @Test
  public void removeLastAfterMixedAddsRevealsTheMiddleItem() {
    deque.addFirst(4);
    deque.addLast(9);
    deque.addFirst(2);
    deque.removeLast();
    assertEquals(4, deque.getLast());
  }

  @Test
  public void removeFirstAfterMixedAddsRevealsTheMiddleItem() {
    deque.addFirst(4);
    deque.addLast(9);
    deque.addFirst(2);
    deque.removeFirst();
    assertEquals(4, deque.getFirst());
  }

  @Test
  public void removingFromBothEndsLeavesTheMiddleItem() {
    deque.addFirst(4);
    deque.addLast(9);
    deque.addFirst(2);
    deque.removeFirst();
    deque.removeLast();
    assertEquals(4, deque.getFirst());
  }

  @Test
  public void addingAtTheFirstEndOnlyServesInReverseOrder() {
    deque.addFirst(10);
    deque.addFirst(20);
    deque.addFirst(30);
    deque.removeFirst();
    deque.removeFirst();
    assertEquals(10, deque.getFirst());
  }

  @Test
  public void addingAtTheLastEndOnlyServesInArrivalOrder() {
    deque.addLast(10);
    deque.addLast(20);
    deque.addLast(30);
    deque.removeFirst();
    deque.removeFirst();
    assertEquals(30, deque.getFirst());
  }

  @Test
  public void removingEveryItemLeavesDequeEmpty() {
    deque.addFirst(10);
    deque.addLast(20);
    deque.addFirst(30);
    deque.removeFirst();
    deque.removeLast();
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void addingTheSameItemAtBothEndsKeepsBothCopies() {
    deque.addFirst(7);
    deque.addLast(7);
    deque.removeFirst();
    assertEquals(7, deque.getLast());
  }

  @Test
  public void manyAddFirstsKeepTheMostRecentItemFirst() {
    for (int i = 1; i <= 12; i++) {
      deque.addFirst(i);
    }
    assertEquals(12, deque.getFirst());
  }

  @Test
  public void manyAddFirstsKeepTheOldestItemLast() {
    for (int i = 1; i <= 12; i++) {
      deque.addFirst(i);
    }
    assertEquals(1, deque.getLast());
  }

  @Test
  public void manyAddLastsKeepTheOldestItemFirst() {
    for (int i = 1; i <= 12; i++) {
      deque.addLast(i);
    }
    assertEquals(1, deque.getFirst());
  }

  @Test
  public void manyAddLastsKeepTheMostRecentItemLast() {
    for (int i = 1; i <= 12; i++) {
      deque.addLast(i);
    }
    assertEquals(12, deque.getLast());
  }

  @Test
  public void manyAddsAtBothEndsKeepEveryItemInOrder() {
    for (int i = 1; i <= 12; i++) {
      deque.addFirst(i);
      deque.addLast(i);
    }
    for (int i = 1; i <= 11; i++) {
      deque.removeFirst();
      deque.removeLast();
    }
    assertEquals(1, deque.getFirst());
  }

  @Test
  public void addFirstsAfterRemoveFirstsKeepReverseOrder() {
    for (int i = 1; i <= 8; i++) {
      deque.addFirst(i);
    }
    for (int i = 1; i <= 5; i++) {
      deque.removeFirst();
    }
    for (int i = 9; i <= 14; i++) {
      deque.addFirst(i);
    }
    for (int i = 1; i <= 5; i++) {
      deque.removeFirst();
    }
    assertEquals(9, deque.getFirst());
  }

  @Test
  public void addLastsAfterRemoveFirstsKeepArrivalOrder() {
    for (int i = 1; i <= 8; i++) {
      deque.addLast(i);
    }
    for (int i = 1; i <= 5; i++) {
      deque.removeFirst();
    }
    for (int i = 9; i <= 14; i++) {
      deque.addLast(i);
    }
    for (int i = 1; i <= 5; i++) {
      deque.removeFirst();
    }
    assertEquals(11, deque.getFirst());
  }

  @Test
  public void addFirstsPastInitialCapacityAfterRemovesKeepTheLast() {
    for (int i = 1; i <= 8; i++) {
      deque.addLast(i);
    }
    for (int i = 1; i <= 5; i++) {
      deque.removeLast();
    }
    for (int i = 9; i <= 16; i++) {
      deque.addFirst(i);
    }
    assertEquals(3, deque.getLast());
  }

  @Test
  public void addLastsPastInitialCapacityAfterRemovesKeepArrivalOrder() {
    for (int i = 1; i <= 8; i++) {
      deque.addLast(i);
    }
    for (int i = 1; i <= 5; i++) {
      deque.removeFirst();
    }
    for (int i = 9; i <= 16; i++) {
      deque.addLast(i);
    }
    for (int i = 1; i <= 5; i++) {
      deque.removeFirst();
    }
    assertEquals(11, deque.getFirst());
  }

  @Test
  public void addFirstNullThrows() {
    try {
      deque.addFirst(null);
      fail("expected IllegalArgumentException when adding null at the first end");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void addLastNullThrows() {
    try {
      deque.addLast(null);
      fail("expected IllegalArgumentException when adding null at the last end");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
