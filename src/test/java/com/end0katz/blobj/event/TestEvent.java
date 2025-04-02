package com.end0katz.blobj.event;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class TestEvent {

    static Event e_std;

    static Event e_singleton;
    static Event e_single;
    static Event e_annotation;

    static boolean staticSubscribe = false;
    static boolean instanceSubscribe = false;
    static boolean instanceSubscribe2 = false;

    @BeforeAll
    public static void prepare() {
        e_std = Event.builder()
                .name("TestEvent")
                .build()
                .add(() -> {
                    throw new RuntimeException();
                });
        e_singleton = Event.builder().name("SingletonEvent").singleton().build();
        e_single = Event.builder().name("SingleSubscriberEvent").subscribeLimit(1).build();
        e_annotation = Event.builder().name("Annotated").build();
    }

    @Test
    void testSingleThread() {
        assertThrowsExactly(RuntimeException.class, e_std::triggerInThisThread, "Not calling throw() method").getClass();
    }

    @Test
    void testSingletonThrows() {
        e_singleton.trigger();
        assertEquals(1l, e_singleton.activations, "Event not registering activation");
        assertEquals(1l, e_singleton.maxTriggers, "Event maximum activations not set");
        assertEquals(e_singleton.maxTriggers, e_singleton.activations, "Math has broken");
        assertTrue(e_singleton.maxTriggers > -1 && e_singleton.activations >= e_singleton.maxTriggers, "Logic has broken");
        assertThrowsExactly(IllegalStateException.class, e_singleton::trigger, "Not throwing").getClass();
    }

    @Test
    void assertSubscriberLimitExists() {
        e_single.add(() -> {
        });

        assertThrowsExactly(
                IllegalStateException.class,
                () -> {
                    e_single.add(() -> {
                    });
                },
                "Subscriber limit not reached"
        ).getClass();
    }

    @Test
    void testAnnotationSubscription() {
        e_annotation.add(this.getClass());
        e_annotation.add(this);
        e_annotation.triggerInThisThread();

        assertTrue(staticSubscribe, "Static @Subscribe fail");
        assertTrue(instanceSubscribe, "Instance @Subscribe fail");
        assertFalse(instanceSubscribe2, "@Subscribe regex fail");
    }

    @Subscribe
    public void thisIsAnAnnotationMethod() {
        instanceSubscribe = true;
    }

    @Subscribe
    public static void alsoAnAnnotationMethod() {
        staticSubscribe = true;
    }

    @Subscribe("^$")
    public void annotatedMethod3() {
        instanceSubscribe2 = true;
    }
}
