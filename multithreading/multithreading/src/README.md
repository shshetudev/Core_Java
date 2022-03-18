## Multithreading

#### 1. What is thread?
Thread is a lightweight process requiring fewer resources to create and share the process resources.

#### 2. Why do we prefer multithreading to multiprocessing?
- Multithreading and Multiprocessing are used for multitasking in Java.
- We prefer multithreading because __threads use a shared memory area which helps to save memory__.
- The __content-switching between the threads is a bit faster than the process__.

#### 3. What are the advantages of multithreading?
- Multithreading saves time as __we can perform multiple operations together__.
- __Threads are independent, so it does not block the user to perform multiple operations at the same time__.
- __If an exception occurs in a single thread it does not affect other threads.__

#### 4. Describe life cycle of a thread.
 There are five states of a thread: __New -> Runnable -> Running -> Non-Runnable -> Terminated__
- __New:__ __Born thread__, before invocation of the __start()__ method.
- __Runnable:__ A newly born thread is started by executing __start()__ method.
- __Running:__ When the thread scheduler selects.
- __Non-Runnable(Blocked):__ The thread is still alive in this state. But currently, it is not eligible to run.
- __Terminated:__ The thread is terminated either for __run()__ method execution or some unusual errors.

#### 5. What is Java Thread class?
- It extends the Object class and implements the Runnable interface.

#### 6. State Java Thread methods.
- __public void start():__ Starts the thread execution and then calls the __run()__ on this Thread object.
- __public void run():__ It's used to do an action for a thread. The __run()__ method is instantiated if the thread was constructed using a separate Runnable object.
- __public static void sleep():__ This **blocks the currently running thread for the specified amount of time**.
- __public static Thread currentThread():__ It returns a **reference to the currently running thread**.
- __public void join():__ **It causes the current thread to block until the second thread terminates or specified amount of milliseconds passes**.
- __public final int getPriority():__ **Checks the priority of the thread**. The priority is assigned either by JVM or by programmer explicitly while creating the thread.
- __public final int setPriority():__ **Changes the priority of the thread. Thread priority varies within: 1-10, Default:5**

## References:
- https://www.mygreatlearning.com/blog/multithreading-in-java/
- http://tutorials.jenkov.com/java-concurrency/index.html