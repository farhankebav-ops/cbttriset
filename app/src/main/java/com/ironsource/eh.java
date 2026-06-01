package com.ironsource;

import com.ironsource.Ae;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class eh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC2541re f8467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C2473ne f8468c;

    public /* synthetic */ eh(InterfaceC2541re interfaceC2541re, C2473ne c2473ne, int i2) {
        this.f8466a = i2;
        this.f8467b = interfaceC2541re;
        this.f8468c = c2473ne;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8466a) {
            case 0:
                Ae.a.a(this.f8467b, this.f8468c);
                break;
            default:
                C2677ze.b(this.f8467b, this.f8468c);
                break;
        }
    }
}
