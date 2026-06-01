package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ui implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2587u9 f10417b;

    public /* synthetic */ ui(C2587u9 c2587u9, int i2) {
        this.f10416a = i2;
        this.f10417b = c2587u9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10416a) {
            case 0:
                C2587u9.a(this.f10417b);
                break;
            case 1:
                C2587u9.b(this.f10417b);
                break;
            case 2:
                C2587u9.d(this.f10417b);
                break;
            default:
                C2587u9.c(this.f10417b);
                break;
        }
    }
}
