# SingletonPatternDemo
Demonstrates how to stop creating new Object for Singleton class using either Reflection or Clone or ObjectStream (file).

#SingletonClient1.java
  - Invoking ```MySingleTon#getInstance();``` multiple times still we should see same object reference.
#SingletonClient2.java
  - Trying create new instance using Reflection, ```MySingleton``` throws exception.
#SingletonClient3.java
  - What if multiple thread trying to access MySingleton#getInstance() method at a time. There may be a chance multiple object get created (race condition) to avoid this mark the ```getInstance()``` as synchronized.
#SingletonClient4.java
  - Singleton pattern can be broken when we write object into file, and then read object from file, to avoid this add below method in ```MySingleton.java``` java.
  <code>
   private Object readResolve() throws ObjectStreamException { 
        return INSTANCE;  //singleton instance.
    }
  </code>
 - for information ref: http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html
