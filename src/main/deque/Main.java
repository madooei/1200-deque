package deque;

/** A demo of the Deque ADT: one structure used as a stack and as a queue. */
public final class Main {

  private Main() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    System.out.println("LinkedDeque:");
    undoSession(new LinkedDeque<>());
    printSession(new LinkedDeque<>());
    System.out.println("ArrayDeque:");
    undoSession(new ArrayDeque<>());
    printSession(new ArrayDeque<>());
  }

  // Adds and removes at the same end, so the most recent edit leaves first:
  // the deque acts like a stack.
  private static void undoSession(Deque<String> edits) {
    edits.addFirst("type 'hello'");
    edits.addFirst("type ' world'");
    edits.addFirst("delete 'world'");
    while (!edits.isEmpty()) {
      System.out.println("  undo " + edits.getFirst());
      edits.removeFirst();
    }
  }

  // Adds at one end and removes from the other, so the oldest job leaves
  // first: the deque acts like a queue.
  private static void printSession(Deque<String> jobs) {
    jobs.addLast("essay.pdf");
    jobs.addLast("homework.docx");
    jobs.addLast("poster.png");
    while (!jobs.isEmpty()) {
      System.out.println("  printing " + jobs.getFirst());
      jobs.removeFirst();
    }
  }
}
