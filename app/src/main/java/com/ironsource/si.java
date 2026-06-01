package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class si implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC2413ka f10234b;

    public /* synthetic */ si(InterfaceC2413ka interfaceC2413ka, int i2) {
        this.f10233a = i2;
        this.f10234b = interfaceC2413ka;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10233a) {
            case 0:
                C2579u1.c(this.f10234b);
                break;
            default:
                C2579u1.d(this.f10234b);
                break;
        }
    }
}
