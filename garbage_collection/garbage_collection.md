## What is GC?
- Java applications obtain objects in memory as needed.
- It's the task of garbage collection in the JVM to automatically determine what memory is no longer being used by a Java application and to recycle this memory for other users.
- **Since memory is automatically reclaimed in the JVM**, java application developers are not burdened with having to explicitly free memory objects that are not being used.
- It's a **way to destroy the unused objects.**

## Advantage:
- Makes java memory efficient.
- Automatically done.

## How can an object be unreferenced?
- By nulling the reference.
```java
    Employee e = new Employee();
    e = null;
```
- By assigning a reference to another.
```java
    Employee e1 = new Employee();
    Employee e2 = new Employee();
    e1 = e2;
```
- By annonymous objects.
```java
    new Employee();
```

## Types of Garbage collection?
- **Minor/Incremental:** is said to have occured **when unreachable objects in the young generation heap memory are removed**.
- **Major/Full:** is said to have occured when the objects that survived the minor garbage collection and **copied into the old generation or permanent generation heap memory** are removed.

## How GC works?
- The heap is divided into three sections:
  - **Young Generation:**
    - **Newly created objects start in the Young generation. **The Young generation is furthur subdivided into an Eden space. When objects are garbase collected from here, it's a minor garbage collection event.
  - **Old Generation:**
    - Long-lived objects are eventually moved from young generation to old generation. When objects are garbage collected from the old generation, it's a major garbage collection.
  - **Permanent Generation:**
    - Metadata such as classes and methods are stored in the Permanent Generation. Classes that are not longer in use may be grabage collected from the Permanent Generation.

## Stop the world: 
- To free up memory, the JVM must stop the application from running for at least a short time and execute the GC process. This process is called **stop-the-world**.

## Ways of performing the GC activity:
- **Serial:** Where just one thread executed the GC.
- **Parallel:** Where multiple threads are executing simultaneously each executing a part of GC.
- **Concurrent Mark Sweep:** Similar to parallel, also allows the execution of some application threads and reduces the frequency qof stop-the-world GC.
- **G1:** Which is also run in parallel and concurrently but functions differently that CMS.

## Types of JVM using GC
- Many JVMs. such as Oracle HotSpot, JRockit, OpenJDK, IBM J9 and SAP JVM, use stop-the-world GC techniques.
- Modern JVM like **Azul Zing** use **Continously Concurrent Compacting Collector (C4)**, which eliminates the **stop-the-world** GC pauses.

## Whe Monitoring Java Garbage Collection is important?
- Impact the performance of Java application in unpredictable ways.
- **When there is frequent GC activity, it adds a lot of CPU load and slows down application processing.**
- Excessive garbage collection activity can occure due to **memory leak** in the Java application.
- For optimal Java application performance, it is crucial to monitor a JVM's GC activity. The time spent on GC should be low - typically less than 5%.

## Key Garbage collection metrics to monitor
- When GC happend.
- How often GC is happening in the JVM.
- How much memory is being collected each time.
- How long it's running.
- Percentage of time spent by JVM for GC.
- JVM heap and non-heap memory usage.

## When is Java GC needed?
- When there are unreferenced objects to be cleared out.

## How to tune Java GC?
- keep the number of objects passed to the old generation area to a minimum.
- Configure the major GC time to be low.
- Some critical JVM parameters to configure for right sizing the JVM's memory are **-Xms**, **-Xmx**, and **-NewRatio**.