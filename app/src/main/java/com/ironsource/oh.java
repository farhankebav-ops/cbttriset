package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class oh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Nd f9563b;

    public /* synthetic */ oh(Nd nd, int i2) {
        this.f9562a = i2;
        this.f9563b = nd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9562a) {
            case 0:
                Nd.c(this.f9563b);
                break;
            case 1:
                Nd.b(this.f9563b);
                break;
            case 2:
                Nd.d(this.f9563b);
                break;
            case 3:
                Nd.a(this.f9563b);
                break;
            default:
                Nd.e(this.f9563b);
                break;
        }
    }
}
