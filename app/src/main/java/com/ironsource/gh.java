package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class gh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Da f8628b;

    public /* synthetic */ gh(Da da, int i2) {
        this.f8627a = i2;
        this.f8628b = da;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8627a) {
            case 0:
                Da.a(this.f8628b);
                break;
            case 1:
                Da.b(this.f8628b);
                break;
            default:
                Da.c(this.f8628b);
                break;
        }
    }
}
