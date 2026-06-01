package com.onesignal.session.internal.session;

import e6.a;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionModel$focusTime$2 extends l implements a {
    public static final SessionModel$focusTime$2 INSTANCE = new SessionModel$focusTime$2();

    public SessionModel$focusTime$2() {
        super(0);
    }

    @Override // e6.a
    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
