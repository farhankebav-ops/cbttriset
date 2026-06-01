package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ProgramaticContextualTriggers {
    private Listener listener;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Listener {
        void onEventTrigger(String str);
    }

    public void removeListener(Listener listener) {
        this.listener = null;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void triggerEvent(String str) {
        Logging.logd("Programmatically trigger: " + str);
        this.listener.onEventTrigger(str);
    }
}
