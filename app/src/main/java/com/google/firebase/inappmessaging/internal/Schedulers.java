package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Schedulers {
    private final s4.p computeScheduler;
    private final s4.p ioScheduler;
    private final s4.p mainThreadScheduler;

    public Schedulers(s4.p pVar, s4.p pVar2, s4.p pVar3) {
        this.ioScheduler = pVar;
        this.computeScheduler = pVar2;
        this.mainThreadScheduler = pVar3;
    }

    public s4.p computation() {
        return this.computeScheduler;
    }

    public s4.p io() {
        return this.ioScheduler;
    }

    public s4.p mainThread() {
        return this.mainThreadScheduler;
    }
}
