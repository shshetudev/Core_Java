## CompletableFuture
- It's used for asynchoronous programming which means writing non-blocking code.
- **It runs a task on a specific thread than main application thread and notifies the main thread about its progress, completion or failure.** In this way, the main thread does not block or wait for the completion of the task. Other tasks execute in parallel which improves the performance of the program.
- **CompletableFuture is a class under package `java.util.concurrent` which is introduced in Java 8 as an extension of Java's Future API**. It implements **CompletionStage** and **Future** interface.
- **CompletionStage:** 
  - It performs an action and returns a value when another completion stage completes.
  - Since it is an element of a chain, when more than on thread attempt to complete - complete exceptionally or cancel a **CompletableFuture**, only one of them succeeds.

## Future Vs. CompletableFuture
- CompletableFuture is an extension to Java's Future API which was introduced in Java 8.
- **A Future is used for asynchronous programming which provides two methods **isDone()** and **get()** and these methods retrieve the result of the computation when it completes.**

## Shortcommings of Future
- Can not be mutually complete.
- Can not perform furthur action on a Future's result without blocking.
- No exception handling.
- Can not combine multiple futures.

## CompletableFuture methods
