package com.ironsource;

import com.ironsource.C2494p0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2494p0.a f6890a;

    public H(C2494p0.a performance) {
        kotlin.jvm.internal.k.e(performance, "performance");
        this.f6890a = performance;
    }

    public final C2494p0.a a() {
        return this.f6890a;
    }

    public final C2494p0.a b() {
        return this.f6890a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H) && this.f6890a == ((H) obj).f6890a;
    }

    public int hashCode() {
        return this.f6890a.hashCode();
    }

    public String toString() {
        return "AdInstancePerformance(performance=" + this.f6890a + ")";
    }

    public final H a(C2494p0.a performance) {
        kotlin.jvm.internal.k.e(performance, "performance");
        return new H(performance);
    }

    public final void b(C2494p0.a aVar) {
        kotlin.jvm.internal.k.e(aVar, "<set-?>");
        this.f6890a = aVar;
    }

    public static /* synthetic */ H a(H h, C2494p0.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = h.f6890a;
        }
        return h.a(aVar);
    }
}
