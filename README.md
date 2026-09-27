# Deque

The `Deque` ADT with two implementations, one backed by a doubly linked list and one backed by a circular array. A JUnit suite checks both implementations against the same contract.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      deque/
        Deque.java                      # the Deque ADT contract
        LinkedDeque.java                # doubly linked Deque
        ArrayDeque.java                 # circular-array Deque
        Main.java                       # demo entry point
    test/
      deque/
        DequeTest.java                  # abstract: the Deque contract suite
        LinkedDequeTest.java            # runs the suite against LinkedDeque
        ArrayDequeTest.java             # runs the suite against ArrayDeque
  scripts/
    run.sh                              # compile and run the Deque demo (deque.Main)
    test.sh                             # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh deque.ArrayDequeTest` — compiles everything and runs only that test class. Use this while you are working on one class and the other is still empty.
- `scripts/run.sh` — compiles everything and runs the `Main` demo.

## What's here

- `deque.Deque<T>` — the Deque contract: `addFirst`, `addLast`, `removeFirst`, `removeLast`, `getFirst`, `getLast`, and `isEmpty`.
- `deque.LinkedDeque<T>` — the node-backed implementation, a doubly linked list with references to both ends.
- `deque.ArrayDeque<T>` — the array-backed implementation, using the array as a circular array.
- `deque.Main` — a runnable demo that uses a deque as a stack and as a queue.
- `deque.DequeTest` — the abstract contract suite.
- `deque.LinkedDequeTest` — runs the contract suite against `LinkedDeque`.
- `deque.ArrayDequeTest` — runs the contract suite against `ArrayDeque`.
