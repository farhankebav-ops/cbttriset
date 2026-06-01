package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Vc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0 f7742a;

    public Vc(D0 eventsWrapper) {
        kotlin.jvm.internal.k.e(eventsWrapper, "eventsWrapper");
        this.f7742a = eventsWrapper;
    }

    public final void a() {
        this.f7742a.a(A0.OPERATIONAL_LOAD_AD, new HashMap());
    }

    public final void b() {
        this.f7742a.a(A0.PAUSE_AD, null);
    }

    public final void c() {
        this.f7742a.a(A0.RESUME_AD, null);
    }

    public final void a(long j) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        this.f7742a.a(A0.OPERATIONAL_LOAD_SUCCESS, map);
    }

    public final void a(long j, int i2, String reason) {
        kotlin.jvm.internal.k.e(reason, "reason");
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        map.put("reason", reason);
        map.put("duration", Long.valueOf(j));
        this.f7742a.a(A0.OPERATIONAL_LOAD_FAILED, map);
    }

    public final void a(double d8) {
        this.f7742a.a(A0.OPERATIONAL_SET_CONFIGURATIONS, r5.x.e0(new q5.i(IronSourceConstants.EVENTS_EXT1, "flooring=" + d8)));
    }
}
