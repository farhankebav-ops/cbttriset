package com.ironsource;

import com.ironsource.C2677ze;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class fj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2473ne f8558b;

    public /* synthetic */ fj(C2473ne c2473ne, int i2) {
        this.f8557a = i2;
        this.f8558b = c2473ne;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8557a) {
            case 0:
                C2677ze.c(this.f8558b);
                break;
            default:
                C2677ze.b.b(this.f8558b);
                break;
        }
    }
}
