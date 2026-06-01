package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class hh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Da f8682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC2484o7 f8683c;

    public /* synthetic */ hh(Da da, InterfaceC2484o7 interfaceC2484o7, int i2) {
        this.f8681a = i2;
        this.f8682b = da;
        this.f8683c = interfaceC2484o7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8681a) {
            case 0:
                Da.b(this.f8682b, this.f8683c);
                break;
            default:
                Da.a(this.f8682b, this.f8683c);
                break;
        }
    }
}
