package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ki implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2427l6 f8872b;

    public /* synthetic */ ki(C2427l6 c2427l6, int i2) {
        this.f8871a = i2;
        this.f8872b = c2427l6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8871a) {
            case 0:
                C2427l6.a(this.f8872b);
                break;
            case 1:
                C2427l6.b(this.f8872b);
                break;
            case 2:
                C2427l6.e(this.f8872b);
                break;
            case 3:
                C2427l6.c(this.f8872b);
                break;
            default:
                C2427l6.d(this.f8872b);
                break;
        }
    }
}
