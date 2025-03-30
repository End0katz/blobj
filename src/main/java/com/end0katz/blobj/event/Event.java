package com.end0katz.blobj.event;

import com.end0katz.blobj.*;

/**
 * Event that you can subscribe to. To add your method to an event, run:
 * {@code eventInstance.add(YourClass::YourMethod)}.
 *
 * There are more complex methods of doing this (see
 * src/main/resources/docs/Event.md)
 *
 * Creating an event is done through {@link Event.builder()}
 *
 * @see Subscribe
 */
public class Event {

    public EventBuilder builder() {
        return new EventBuilder();
    }

    public class EventBuilder implements Builder<Event> {

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
            return subscribeLimit(1);
        }

        @Override
        public Event build() {
            if (name == null) {
                name = "Event#%s".formatted(index++);
            }

            Event result = new Event(
                    name,
                    triggerLimit,
                    subscribeLimit
            );

            return result;
        }

    }

    public Event(String name, long triggerLimit, long subscribeLimit) {

    }
}
