package com.ironsource;

import com.ironsource.Ae;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class dh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2435le f8252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC2541re f8253c;

    public /* synthetic */ dh(C2435le c2435le, InterfaceC2541re interfaceC2541re) {
        this.f8251a = 1;
        this.f8252b = c2435le;
        this.f8253c = interfaceC2541re;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8251a) {
            case 0:
                Ae.a(this.f8253c, this.f8252b);
                break;
            case 1:
                Ae.a.a(this.f8252b, this.f8253c);
                break;
            default:
                C2677ze.b(this.f8253c, this.f8252b);
                break;
        }
    }

    public /* synthetic */ dh(InterfaceC2541re interfaceC2541re, C2435le c2435le, int i2) {
        this.f8251a = i2;
        this.f8253c = interfaceC2541re;
        this.f8252b = c2435le;
    }
}
