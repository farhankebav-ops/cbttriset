package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class lh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ka f8926b;

    public /* synthetic */ lh(Ka ka, int i2) {
        this.f8925a = i2;
        this.f8926b = ka;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8925a) {
            case 0:
                Ka.c(this.f8926b);
                break;
            default:
                Ka.d(this.f8926b);
                break;
        }
    }
}
