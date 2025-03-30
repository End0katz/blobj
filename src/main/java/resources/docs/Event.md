# Events

Events can be triggered and subscribed to.

## Creating an event

Creating an event is done through the Event.EventBuilder class.

```java
Event.EventBuilder builder = Event.builder();
builder.name("CustomEvent");
builder.limitTriggers(1); // Or builder.singleton();
builder.limitSubscribers(5); // Only 5 things can subscribe to this. good for security.

Event event = builder.build();
```

## Subscribing to an event

There are multiple methods of doing this:

### Direct method subscription

```java
event.add(YourClass::YourMethod);
```

### Annotations

Class Methods:

```java
public class MyClass {

    @Subscribe(event = event)
    public static void myMethod() {
        System.out.println("Foo");
    }
}

event.add(MyClass.class)
```

And Instance Methods:

```java
public class MyClass {

    @Subscribe(event = event)
    public void myMethod() {
        System.out.println("Bar");
    }

    public MyClass create() {
        MyClass result = new MyClass();
        event.add(result);
        return result;
    }
}
```
