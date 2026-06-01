package com.google.firebase.inappmessaging.internal.time;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemClock implements Clock {
    @Override // com.google.firebase.inappmessaging.internal.time.Clock
    public long now() {
        return System.currentTimeMillis();
    }
}
