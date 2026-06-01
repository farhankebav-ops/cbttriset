package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class I3 implements InterfaceC2551s7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f6965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f6966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final P3 f6967c;

    public I3(Boolean bool, Integer num, P3 p3) {
        this.f6965a = bool;
        this.f6966b = num;
        this.f6967c = p3;
    }

    @Override // com.ironsource.InterfaceC2551s7
    public Object a() {
        Boolean bool = this.f6965a;
        if (bool == null) {
            return r2.q.M(new Exception("enabled flag is not provided or invalid"));
        }
        if (!bool.booleanValue()) {
            return Boolean.FALSE;
        }
        Integer num = this.f6966b;
        return (num == null || num.intValue() <= 0) ? r2.q.M(new Exception("limit flag is not provided or invalid")) : this.f6967c == null ? r2.q.M(new Exception("unit flag is not provided or invalid")) : Boolean.TRUE;
    }
}
