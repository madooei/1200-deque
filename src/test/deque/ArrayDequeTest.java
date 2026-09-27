package deque;

/** Runs the Deque contract suite against ArrayDeque. */
public class ArrayDequeTest extends DequeTest {

  @Override
  protected Deque<Integer> createDeque() {
    return new ArrayDeque<>();
  }
}
