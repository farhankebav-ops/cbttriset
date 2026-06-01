package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class cj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC2662z f8169b;

    public /* synthetic */ cj(AbstractC2662z abstractC2662z, int i2) {
        this.f8168a = i2;
        this.f8169b = abstractC2662z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8168a) {
            case 0:
                AbstractC2662z.b(this.f8169b);
                break;
            case 1:
                AbstractC2662z.d(this.f8169b);
                break;
            default:
                AbstractC2662z.c(this.f8169b);
                break;
        }
    }
}
