package com.google.firebase.inappmessaging.model;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class TriggeredInAppMessage {
    private InAppMessage inAppMessage;
    private String triggeringEvent;

    public TriggeredInAppMessage(InAppMessage inAppMessage, String str) {
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = str;
    }

    public InAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    public String getTriggeringEvent() {
        return this.triggeringEvent;
    }
}
