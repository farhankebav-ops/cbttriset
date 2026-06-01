package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class vh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uf f10462b;

    public /* synthetic */ vh(Uf uf, int i2) {
        this.f10461a = i2;
        this.f10462b = uf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10461a) {
            case 0:
                Uf.a(this.f10462b);
                break;
            default:
                Uf.b(this.f10462b);
                break;
        }
    }
}
