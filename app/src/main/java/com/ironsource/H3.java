package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class H3 implements InterfaceC2534r7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f6903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f6904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final P3 f6905c;

    public H3(Boolean bool, Integer num, P3 p3) {
        this.f6903a = bool;
        this.f6904b = num;
        this.f6905c = p3;
    }

    private final Object a(P3 p3) {
        return new I3(this.f6903a, this.f6904b, p3).a();
    }

    @Override // com.ironsource.InterfaceC2534r7
    public Object b() {
        Integer num;
        P3 p3 = P3.Second;
        Throwable thA = q5.k.a(a(p3));
        if (thA != null) {
            return r2.q.M(thA);
        }
        if (!kotlin.jvm.internal.k.a(this.f6903a, Boolean.TRUE) || (num = this.f6904b) == null) {
            return null;
        }
        return new Yc(p3.a(num), null, 2, null);
    }

    @Override // com.ironsource.InterfaceC2534r7
    public Object c() {
        Integer num;
        Throwable thA = q5.k.a(a(this.f6905c));
        if (thA != null) {
            return r2.q.M(thA);
        }
        if (!kotlin.jvm.internal.k.a(this.f6903a, Boolean.TRUE) || (num = this.f6904b) == null) {
            return null;
        }
        int iIntValue = num.intValue();
        P3 p3 = this.f6905c;
        if (p3 != null) {
            return new C2418kf(iIntValue, p3);
        }
        return null;
    }

    public final Boolean d() {
        return this.f6903a;
    }

    public final Integer e() {
        return this.f6904b;
    }

    public final P3 f() {
        return this.f6905c;
    }

    @Override // com.ironsource.InterfaceC2534r7
    public Object a() {
        Throwable thA = q5.k.a(new Q4(this.f6903a).a());
        if (thA != null) {
            return r2.q.M(thA);
        }
        Boolean bool = this.f6903a;
        if (bool != null) {
            return new P4(bool.booleanValue());
        }
        return null;
    }

    public /* synthetic */ H3(Boolean bool, Integer num, P3 p3, int i2, kotlin.jvm.internal.f fVar) {
        this(bool, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : p3);
    }
}
