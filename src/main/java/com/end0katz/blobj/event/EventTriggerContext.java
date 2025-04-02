package com.end0katz.blobj.event;

public record EventTriggerContext(
    Event event, String name, String reason, Object[] params
)
{

    @Override
    public EventTriggerContext clone() {
        try {
            return (EventTriggerContext) super.clone();
        } catch (CloneNotSupportedException e) {
            return new EventTriggerContext(event, name, reason, params);
        }
    }
}
