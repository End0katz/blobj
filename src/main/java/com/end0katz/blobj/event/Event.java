package com.end0katz.blobj.event;

import java.util.*;
import java.util.function.*;

import java.lang.reflect.*;

import com.end0katz.blobj.*;

/**
 * Event that you can subscribe to. To add your method to an event, run:
 * {@code eventInstance.add(YourClass::YourMethod)}.
 *
 * There are more complex methods of doing this (see
 * src/main/resources/docs/Event.md)
 *
 * Creating an event is done through {@link Event#builder()}
 *
 * @see Subscribe
 */
public class Event {

    public static final String DEFAULT_REASON = "$null";

    protected long maxSubs;
    protected long maxTriggers;
    protected final List<Consumer<EventTriggerContext>> subscribers = new ArrayList<>();
    protected long activations = 0l;
    protected final String name;

    public static EventBuilder builder() {
        return new EventBuilder();
    }

    public static class EventBuilder implements Builder<Event> {

        static int index = 0;
        String name = null;
        long triggerLimit = -1;
        long subscribeLimit = -1;

        public EventBuilder triggerLimit(long limit) {
            triggerLimit = limit;
            return this;
        }

        public EventBuilder subscribeLimit(long limit) {
            subscribeLimit = limit;
            return this;
        }

        public EventBuilder singleton() {
            return triggerLimit(1);
        }

        public EventBuilder name(String str) {
            this.name = str;
            return this;
        }

        @Override
        public Event build() {
            if (name == null) {
                name = "Event#%s".formatted(index++);
            }

            Event result = new Event(name, triggerLimit, subscribeLimit);
            /*
            if (allEvents.containsKey(name)) {
                System.out.println(allEvents);
                System.out.println(name);
                throw new IllegalArgumentException("Event '%s' already exists! (make sure to namespace your events)".formatted(
                        this.name));
            }
            allEvents.put(name, result);*/

            return result;
        }
    }

    private Event(String name, long triggerLimit, long subscribeLimit) {
        maxSubs = subscribeLimit;
        maxTriggers = triggerLimit;
        this.name = name;
    }

    public Event add(Consumer<EventTriggerContext> f) {
        if (maxSubs == -1 || subscribers.size() < maxSubs) {
            subscribers.add(f);
        } else {
            throw new IllegalStateException("The subscriber limit has already been reached for event '%s'".formatted(
                    this));
        }
        return this;
    }

    public Event add(Runnable f) {
        return add((_) -> f.run());
    }

    public Event add(Class<?> cls) {
        List<Method> methodsToAdd = new ArrayList<>();
        Class<Subscribe> subscribeAnnotation = Subscribe.class;

        for (Method m : cls.getDeclaredMethods()) {
            if (Modifier.isStatic(m.getModifiers())
                    && m.isAnnotationPresent(subscribeAnnotation)) {
                Subscribe subdat = m.getAnnotation(subscribeAnnotation);
                if (this.name.matches(subdat.value())) {
                    if (m.getParameterCount() > 0
                            && !Arrays.equals(m.getParameters(), new Class<?>[]{EventTriggerContext.class})) {
                        throw new IllegalArgumentException(
                                "%s is annotated with @Subscribe but does not require correct arguments. (required: EventTriggerContext or none)"
                                        .formatted(m));
                    }
                    methodsToAdd.add(m);
                }
            }
        }

        for (Method m : methodsToAdd) {
            if (m.getParameterCount() == 0) {
                this.add(() -> {
                    try {
                        m.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                    }
                });
            } else {
                this.add((context) -> {
                    try {
                        m.invoke(null, context);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                    }
                });
            }
        }

        return this;
    }

    public Event add(Object inst) {
        List<Method> methodsToAdd = new ArrayList<>();
        Class<Subscribe> subscribeAnnotation = Subscribe.class;

        for (Method m : inst.getClass().getDeclaredMethods()) {
            if (!Modifier.isStatic(m.getModifiers())
                    && m.isAnnotationPresent(subscribeAnnotation)) {
                Subscribe subdat = m.getAnnotation(subscribeAnnotation);
                if (this.name.matches(subdat.value())) {
                    if (m.getParameterCount() > 0
                            && !Arrays.equals(m.getParameters(), new Class<?>[]{EventTriggerContext.class})) {
                        throw new IllegalArgumentException(
                                "%s is annotated with @Subscribe but does not require correct arguments. (required: EventTriggerContext or none)"
                                        .formatted(m));
                    }
                    methodsToAdd.add(m);
                }
            }
        }

        for (Method m : methodsToAdd) {
            if (m.getParameterCount() == 0) {
                this.add(() -> {
                    try {
                        m.invoke(inst);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                    }
                });
            } else {
                this.add((context) -> {
                    try {
                        m.invoke(inst, context);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                    }
                });
            }
        }

        return this;
    }

    public Event triggerInThisThread(Object... params) {
        return triggerInThisThread(DEFAULT_REASON, params);
    }

    public Thread triggerSerial(Object... params) {
        return triggerSerial(DEFAULT_REASON, params);
    }

    public Thread[] trigger(Object... params) {
        return trigger(DEFAULT_REASON, params);
    }

    public Event triggerInThisThread(String reason, Object... params) {
        if (maxTriggers > -1 && activations >= maxTriggers) {
            throw new IllegalStateException("The activation limit has already been reached for event '%s'".formatted(
                    this));
        } else if (maxSubs > -1 && subscribers.size() > maxSubs) {
            throw new IllegalStateException("The subscriber limit for %s was exceeded - refusing to trigger.".formatted(
                    this));
        }
        activations++;
        EventTriggerContext context = new EventTriggerContext(this, this.name, reason, params);
        for (Consumer<EventTriggerContext> f : subscribers) {
            f.accept(context.clone());
        }
        return this;
    }

    public Thread triggerSerial(String reason, Object... params) {
        if (maxTriggers > -1 && activations >= maxTriggers) {
            throw new IllegalStateException("The activation limit has already been reached for event '%s'".formatted(
                    this));
        } else if (maxSubs > -1 && subscribers.size() > maxSubs) {
            throw new IllegalStateException("The subscriber limit for %s was exceeded - refusing to trigger.".formatted(
                    this));
        }
        Thread result = new Thread(() -> this.triggerInThisThread(reason, params), "blobj:Event '%s'".formatted(this));
        result.start();
        return result;
    }

    public Thread[] trigger(String reason, Object... params) {
        if (maxTriggers > -1 && activations >= maxTriggers) {
            throw new IllegalStateException("The activation limit has already been reached for event '%s'".formatted(
                    this));
        } else if (maxSubs > -1 && subscribers.size() > maxSubs) {
            throw new IllegalStateException("The subscriber limit for event '%s' was exceeded - refusing to trigger.".formatted(
                    this));
        }

        List<Thread> result = new ArrayList<>();

        activations++;

        EventTriggerContext context = new EventTriggerContext(this, this.name, reason, params);

        int i = 0;
        for (Consumer<EventTriggerContext> f : subscribers) {
            result.add(new Thread(() -> f.accept(context), "blobj:Event '%s' task#%s".formatted(this, (Integer) i++)));
        }
        Thread[] resultAsArr = new Thread[result.size()];

        result.forEach(new Consumer<Thread>() {
            int i = 0;

            @Override
            public void accept(Thread x) {
                x.start();
                resultAsArr[i++] = x;
            }
        });
        return resultAsArr;
    }

    @Override
    public String toString() {
        return name;
    }
}
