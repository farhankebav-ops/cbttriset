package com.ironsource;

import com.ironsource.X2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class wh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ V0 f10495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f10496c;

    public /* synthetic */ wh(V0 v02, long j, int i2) {
        this.f10494a = i2;
        this.f10495b = v02;
        this.f10496c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10494a) {
            case 0:
                X2.a.d(this.f10495b, this.f10496c);
                break;
            case 1:
                X2.a.a(this.f10495b, this.f10496c);
                break;
            case 2:
                X2.a.b(this.f10495b, this.f10496c);
                break;
            default:
                X2.a.c(this.f10495b, this.f10496c);
                break;
        }
    }
}
