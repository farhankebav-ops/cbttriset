package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ai implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2271cb f8022b;

    public /* synthetic */ ai(C2271cb c2271cb, int i2) {
        this.f8021a = i2;
        this.f8022b = c2271cb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8021a) {
            case 0:
                C2271cb.d(this.f8022b);
                break;
            case 1:
                C2271cb.c(this.f8022b);
                break;
            case 2:
                C2271cb.b(this.f8022b);
                break;
            default:
                C2271cb.e(this.f8022b);
                break;
        }
    }
}
