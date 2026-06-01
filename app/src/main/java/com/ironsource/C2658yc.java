package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.yc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2658yc implements InterfaceC2676zd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10570a;

    /* JADX INFO: renamed from: com.ironsource.yc$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10571a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f10572b = "IronSource";

        private a() {
        }
    }

    public C2658yc(String networkInstanceId) {
        kotlin.jvm.internal.k.e(networkInstanceId, "networkInstanceId");
        this.f10570a = networkInstanceId;
    }

    @Override // com.ironsource.InterfaceC2676zd
    public String value() {
        return this.f10570a.length() == 0 ? "" : (kotlin.jvm.internal.k.a(this.f10570a, "0") || kotlin.jvm.internal.k.a(this.f10570a, "IronSource")) ? "IronSource" : a1.a.l("IronSource_", this.f10570a);
    }
}
