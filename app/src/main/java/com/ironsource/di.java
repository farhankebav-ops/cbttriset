package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class di implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2276cg f8255b;

    public /* synthetic */ di(C2276cg c2276cg, int i2) {
        this.f8254a = i2;
        this.f8255b = c2276cg;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8254a) {
            case 0:
                C2276cg.a(this.f8255b);
                break;
            default:
                C2276cg.b(this.f8255b);
                break;
        }
    }
}
