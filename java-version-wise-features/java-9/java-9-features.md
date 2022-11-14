## Features at a glimpse
- Java 9 REPL(JShell)
- Factory methods of Immutable List, Set, Map and Map.Entry
- Private methods in Interfaces
- Process API Improvements
- Try With Resources Improvement
- CompletableFuture API Improvements
- Reactive Streams
- Diamond Operator for Anonymous Inner class
- Optional Class Improvements
- Stream API Improvements
- Enhanced @Deprecated annotation
- HTTP 2 Client
- Mutli-Resolution Image API
- Miscellaneouse java 9 Features

### Java 9 REPL (JShell)
- Oracle Corp has introduced a new tool called "jshell". It stands for Java Shell and also known as REPL(Read Evaluate Print Loop).
- It is used to execute and test any java constructs like class, interfaces, enum, object, statements etc very easily.
    ```jshell
    G:\>jshell
    |  Welcome to JShell -- Version 9-ea
    |  For an introduction type: /help intro


    jshell> int a = 10
    a ==> 10

    jshell> System.out.println("a value = " + a )
    a value = 10

    jshell> /exit
    ```
- **Execute class:**
  ```jshell
  jshell> class Hello {
   ...> public static void sayHello() {
   ...> System.out.print("Hello");
   ...> }
   ...> }
     created class Hello

    jshell> Hello.sayHello()
    Hello
  ```

### Factory Methods for Immutable List, Set, Map and Map.Entry
- Oracle Corp has introduced some convenient factory methods to create **Immutable List, Set, Map and Map.Entry objects**.
- These utility methods are used to create empty or non-empty collection objects.
- In Java SE 8 and earlier versions, we can use collections class utility methods like: `Collections.unmodifiableList` method which is a tedious and verbose approach.
- To overcome this shortcommings, Oracle corp has added a couple of utility methods to List, Set and Map Interfaces having `of()` methods to create an empty or non-empty immutable list.
```java
List immutableList = List.of();
List immutableList = List.of("one", "two", "three");
Map emptyImmutableMap = Map.of();
Map nonEmptyImmutableMap = Map.of(1, "One", 2, "Two", 3, "three");
```

### Private methods in interfaces
- In Java 8, we can provide method implementation in interfaces using **Default** and **Static** methods.
- **Why default methods were needed?**
  - `default` is implicitly public(already added public behind the scene). 
  - In a typical design based on abstractions, where an interace has one or multiple implementations, if one or methods are added to the interface, the design will just break down.
  - So for ensuring **backward compatibility is neatly preserved,** we use default method.
- **Why static mthods are needed?**
  - Since static methods don't belong to a particular object, they are not part of the API of the classes implementing the interface.
  - Therefore they have to be called by using the interface name preceding the method name.
  ```java
  public interface Vehicle {

  static int getHorsePower(int rpm, int torque) {
      return (rpm * torque) / 5252;
  }

  Vehicle.getHorsePower(2500, 480));
  }
  ```
  - The idea behind static interface methods is to provide a simple mechanism that allows us to increase the degree of cohesion of a design by putting together related methdos in one single place, without having to create an object.
  - However we can create private(static and non-static) method from java SE 9.
  ```
    public interface Card{

    private Long createCardID(){
      // Method implementation goes here.
    }

    private static void displayCardDetails(){
      // Method implementation goes here.
    }

  }
  ```

  ### Try with resources improvement
  - The syntax of try-with resources which has been introduced in java7, improves in java9.
  ```java
    void testARM_Before_Java9() throws IOException{
  BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
  try (BufferedReader reader2 = reader1) {
    System.out.println(reader2.readLine());
  }
  }
  ```
  - **Improvement:**
  ```java
    void testARM_Java9() throws IOException{
  BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
  try (reader1) {
    System.out.println(reader1.readLine());
  }
  }
  ```

### Reactive Streams
-  Oracle Corps is also introducing new Reactive Streams API in Java SE 9. Java SE 9 Reactive Streams API is a Publish/Subscribe Framework to implement Asynchronous, Scalable and Parallel applications very easily using Java language.
- Java SE 9 has introduced the following API to develop Reactive Streams in Java-based applications:
  - **java.util.concurrent.Flow**
  - **java.util.concurrent.Flow.Publisher**
  - **java.util.concurrent.Flow.Subscriber**
  - **java.util.concurrent.Flow.Processor**

### Diamond Operator for Anonymous Inner class
- Java SE 7 has introduced one new feture, Diamond operator to avoid redundant code and verbosity, to improve readability.
- In java 8 we found some limitations which are improved in java 9 regarding anonymous inner class.
```
  public List getEmployee(String empid){
  // Code to get Employee details from Data Store
  return new List(emp){ };
}
``` 

### Stream API Improvements
- Two of the default methods like: `dropWhile` and `takeWhile` is introduced.

```
jshell> Stream.of(1,2,3,4,5,6,7,8,9,10).takeWhile(i -> i < 5 )
                 .forEach(System.out::println);
1
2
3
4
```
