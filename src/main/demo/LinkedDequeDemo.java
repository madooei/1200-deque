package demo;

import deque.LinkedDeque;

/** A demo of LinkedDeque used first as a stack and then as a queue. */
public final class LinkedDequeDemo {

  private LinkedDequeDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // As a stack: add and remove at the same end, so the most recent edit
    // leaves first. Expect delete 'world', then type ' world', then type 'hello'.
    LinkedDeque<String> edits = new LinkedDeque<>();
    edits.addFirst("type 'hello'");
    edits.addFirst("type ' world'");
    edits.addFirst("delete 'world'");
    while (!edits.isEmpty()) {
      System.out.println("undo " + edits.getFirst());
      edits.removeFirst();
    }

    // As a queue: add at one end and remove from the other, so the oldest job
    // leaves first. Expect essay.pdf, then homework.docx, then poster.png.
    LinkedDeque<String> jobs = new LinkedDeque<>();
    jobs.addLast("essay.pdf");
    jobs.addLast("homework.docx");
    jobs.addLast("poster.png");
    while (!jobs.isEmpty()) {
      System.out.println("printing " + jobs.getFirst());
      jobs.removeFirst();
    }
  }
}
