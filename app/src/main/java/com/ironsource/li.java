package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class li implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2450mb f8928b;

    public /* synthetic */ li(C2450mb c2450mb, int i2) {
        this.f8927a = i2;
        this.f8928b = c2450mb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8927a) {
            case 0:
                C2450mb.a(this.f8928b);
                break;
            default:
                C2450mb.b(this.f8928b);
                break;
        }
    }
}
