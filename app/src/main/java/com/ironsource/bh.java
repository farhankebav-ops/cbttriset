package com.ironsource;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class bh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f8089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C2575te f8090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ InterfaceC2541re f8091d;

    public /* synthetic */ bh(Context context, C2575te c2575te, InterfaceC2541re interfaceC2541re, int i2) {
        this.f8088a = i2;
        this.f8089b = context;
        this.f8090c = c2575te;
        this.f8091d = interfaceC2541re;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f8088a) {
            case 0:
                Ae.b(this.f8089b, this.f8090c, this.f8091d);
                break;
            default:
                Ae.d(this.f8089b, this.f8090c, this.f8091d);
                break;
        }
    }
}
