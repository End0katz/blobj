package com.end0katz.blobj.event;

/**
 * The context passed to all {@link Event} subscribers that except it.
 *
 * @param event the event that was triggered.
 * @param name the name of the event.
 * @param reason the provided reason why the trigger occurred.
 * @param params arguments passed to the methods.
 *
 * @see Event#DEFAULT_REASON
 */
public record EventTriggerContext(
        Event event, String name, String reason, Object[] params) {

    @Override
    public EventTriggerContext clone() {
        try {
            return (EventTriggerContext) super.clone();
        } catch (CloneNotSupportedException e) {
            return new EventTriggerContext(event, name, reason, params);
        }
    }
}
