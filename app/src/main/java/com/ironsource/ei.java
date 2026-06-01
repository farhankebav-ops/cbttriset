package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ei implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2276cg f8470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC2345gd f8471c;

    public /* synthetic */ ei(C2276cg c2276cg, AbstractC2345gd abstractC2345gd, int i2) {
        this.f8469a = i2;
        this.f8470b = c2276cg;
        this.f8471c = abstractC2345gd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8469a) {
            case 0:
                C2276cg.a(this.f8470b, this.f8471c);
                break;
            default:
                C2276cg.b(this.f8470b, this.f8471c);
                break;
        }
    }
}
