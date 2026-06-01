package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class qh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Q2 f9725b;

    public /* synthetic */ qh(Q2 q22, int i2) {
        this.f9724a = i2;
        this.f9725b = q22;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9724a) {
            case 0:
                Q2.a(this.f9725b);
                break;
            case 1:
                Q2.b(this.f9725b);
                break;
            default:
                Q2.c(this.f9725b);
                break;
        }
    }
}
