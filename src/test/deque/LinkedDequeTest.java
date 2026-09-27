package deque;

/** Runs the Deque contract suite against LinkedDeque. */
public class LinkedDequeTest extends DequeTest {

  @Override
  protected Deque<Integer> createDeque() {
    return new LinkedDeque<>();
  }
}
