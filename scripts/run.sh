#!/usr/bin/env bash
# Compile all source into out/ and run the Deque ADT demo.
set -e
cd "$(dirname "$0")/.."
javac -d out $(find src/main -name "*.java")
java -cp out deque.Main
