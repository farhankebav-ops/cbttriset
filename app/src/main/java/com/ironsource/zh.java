package com.ironsource;

import com.ironsource.C2245b3;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2245b3 f10661b;

    public /* synthetic */ zh(C2245b3 c2245b3, int i2) {
        this.f10660a = i2;
        this.f10661b = c2245b3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10660a) {
            case 0:
                C2245b3.a.a(this.f10661b);
                break;
            default:
                C2245b3.b.a(this.f10661b);
                break;
        }
    }
}
