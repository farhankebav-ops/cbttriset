package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import kotlin.jvm.internal.k;
import s6.a;
import t6.p0;
import t6.r0;
import t6.t0;
import t6.w0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OperativeEventRepository {
    private final p0 _operativeEvents;
    private final t0 operativeEvents;

    public OperativeEventRepository() {
        w0 w0VarA = x0.a(10, 10, a.f13719b);
        this._operativeEvents = w0VarA;
        this.operativeEvents = new r0(w0VarA);
    }

    public final void addOperativeEvent(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest) {
        k.e(operativeEventRequest, "operativeEventRequest");
        this._operativeEvents.d(operativeEventRequest);
    }

    public final t0 getOperativeEvents() {
        return this.operativeEvents;
    }
}
