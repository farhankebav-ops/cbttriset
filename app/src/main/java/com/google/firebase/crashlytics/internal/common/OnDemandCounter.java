package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class OnDemandCounter {
    private final AtomicInteger recordedOnDemandExceptions = new AtomicInteger();
    private final AtomicInteger droppedOnDemandExceptions = new AtomicInteger();

    public int getDroppedOnDemandExceptions() {
        return this.droppedOnDemandExceptions.get();
    }

    public int getRecordedOnDemandExceptions() {
        return this.recordedOnDemandExceptions.get();
    }

    public void incrementDroppedOnDemandExceptions() {
        this.droppedOnDemandExceptions.getAndIncrement();
    }

    public void incrementRecordedOnDemandExceptions() {
        this.recordedOnDemandExceptions.getAndIncrement();
    }

    public void resetDroppedOnDemandExceptions() {
        this.droppedOnDemandExceptions.set(0);
    }
}
