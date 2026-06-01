package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class aj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2648y2 f8024b;

    public /* synthetic */ aj(C2648y2 c2648y2, int i2) {
        this.f8023a = i2;
        this.f8024b = c2648y2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8023a) {
            case 0:
                C2648y2.a(this.f8024b);
                break;
            case 1:
                C2648y2.e(this.f8024b);
                break;
            case 2:
                C2648y2.c(this.f8024b);
                break;
            case 3:
                C2648y2.b(this.f8024b);
                break;
            default:
                C2648y2.d(this.f8024b);
                break;
        }
    }
}
