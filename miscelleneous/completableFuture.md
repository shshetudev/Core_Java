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
- Creating new instance:
```java
CompletableFuture<String> future = new CompletableFuture<String>();
```
- **supplyAsync():** 
  - It completes it's job asynchronously. The result of supplier is run by a task from `FrokJoinPool.commonPool()` as default.
  - The `supplyAsync()` method returns `CompletableFuture` on which we can apply other methods.
- **thenApply():**
  - This method accepts function as an arguments and returns a new `CompletableStage` when this stage completes normally.
  - The new stage use as the argument to the supplied function.
- **join():**
  - This method returns the result value when complete. It also throws a `CompletionException` (unchecked exception) if completed exceptionally.

```java
import java.util.Arrays;  
import java.util.List;  
import java.util.concurrent.CompletableFuture;  
public class CompletableFutureExample1 {  
public static void main(String[] args) {  
try {  
List<Integer> list = Arrays.asList(5,9,14);  
list.stream()
.map(num -> CompletableFuture.supplyAsync(()-> getNumber(num)))
.map(CompletableFuture->CompletableFuture.thenApply(n -> n*n))
.map(t -> t.join()).forEach(s -> System.out.println(s));  
} catch (Exception e) {  
e.printStackTrace();  
}  
    }  
private static int getNumber(int a) {  
return a*a;  
}  
}  

Output:
625
6561
38416
```