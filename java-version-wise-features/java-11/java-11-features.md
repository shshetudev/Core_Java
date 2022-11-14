## At a glimpse
- Running java file with single command
- New utility methods in String class
- Local-Variable syntax for Lambda parameters
- Nested Based Access control
- JEP 321: HTTP client
- Reading/Writing Strings to and from the Files
- JEP 328: Flight Recorder

### Running java file with single command
- One major change is that we don't need to compile java source file with javac tool first. 
- We can directly run the file with **java** command and it implicitly compiles. The feature comes under JEP 330.

### New utility methods in String class (isBlank(), lines(), strip(), stripLeading(), stripTrailing(), repeat(int))

- **isBlank():** Empty Strings and Strings with only white spaces are treated as blank.
```java
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        System.out.println(" ".isBlank()); //true
        
        String s = "Anupam";
        System.out.println(s.isBlank()); //false
        String s1 = "";
        System.out.println(s1.isBlank()); //true
    }
}
```
- **lines():** This method returns a stream of strings, which is a collection of all substrings split by lines.
```java
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        
        String str = "JD\nJD\nJD"; 
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));
    }
}

Output:
JD
JD
JD
[JD, JD, JD]
```

- **strip():** 
  - Unicode aware evolution of `trim()`. Removes the white space from both, begining and the end of string.
  - **stripLeading():** trims from starting.
  - **stripTrailing():** trims from ending.

```java
public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        String str = " JD "; 
        System.out.print("Start");
        System.out.print(str.strip());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(str.stripLeading());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(str.stripTrailing());
        System.out.println("End");
    }
}

Output:
StartJDEnd
StartJD End
Start JDEnd
```
- **repeat(int):** Simply repeats the string that many numbers of times as mentioned in the form of an int.
```java
public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        String str = "=".repeat(2);
        System.out.println(str); //prints ==
    }
}
```

### Local variable syntax for lambda parameters
- **JEP 323**
  - In java 10, local variable type reference was introduced. Thus we could infer the type of the variable from the RHS. `var list = new Arraylist<String>()`
  - In java 11, **JEP 323** allows **var** to be used to declare the formal parameters of an implicitly typed lambda expression:
  ```java
  (var s1, var s2) -> s1 + s2 // allowed
  (var s1, s2) -> s1 + s2 //no skipping allowed
  (var s1, String y) -> s1 + y //no mixing allowed
  var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
  ```

  ### Nested based access control
  - Before Java 11 this was possible
  ```java
  public class Main {
 
    public void myPublic() {
    }
 
    private void myPrivate() {
    }
 
    class Nested {
 
        public void nestedPublic() {
            myPrivate();
        }
            }
    }
  ```
  - private method of the main class is accessible from the above nested class in the above manner. But if we use `java reflection`, it will give and `IllegalStateException`.
  ```java
  Method method = ob.getClass().getDeclaredMethod("myPrivate");
  method.invoke(ob);
  ```
- Java 11 nested access control addresses this concern in reflection. `java.lang.class` introduces three methods in the reflection API. `getNestedHost()`, `getNestedMembers()`, `isNestmateOf()`.


### JEP 318: Epsilon: A No-Op Garbage collector
- Unlike the JVM GC which is responsible for allocating memory and releasing it, **Epsilon only allocate memory**. It allocates memory for the following things:
  - Performance testing.
  - Memory pressure testing.
  - VM interface testing.
  - Extremely short lived jobs.
  - Last-drop latency improvements.
  - Last-drop throughput improvements.

### JEP 321: HTTP client
- Java 11 standardizes the Http Client API. The new API supports both HTTP/1.1 and HTTP/2.
- It also natively supports WebSockets.

### JEP 315: Improve Aarch64 intrinsics
- Improve the existing string and array intrinsics, and implement new intrinsics for the java.lang.Math sin, cos and log functions on AArch64 processors.