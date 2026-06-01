package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class qi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2533r6 f9727b;

    public /* synthetic */ qi(C2533r6 c2533r6, int i2) {
        this.f9726a = i2;
        this.f9727b = c2533r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9726a) {
            case 0:
                C2533r6.b(this.f9727b);
                break;
            case 1:
                C2533r6.c(this.f9727b);
                break;
            default:
                C2533r6.a(this.f9727b);
                break;
        }
    }
}
