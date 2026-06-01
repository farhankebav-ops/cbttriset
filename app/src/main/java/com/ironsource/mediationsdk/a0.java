package com.ironsource.mediationsdk;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractAdapter f8992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f8993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f8994d;

    public /* synthetic */ a0(AbstractAdapter abstractAdapter, String str, List list, int i2) {
        this.f8991a = i2;
        this.f8992b = abstractAdapter;
        this.f8993c = str;
        this.f8994d = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8991a) {
            case 0:
                c.a(this.f8992b, this.f8993c, this.f8994d);
                break;
            default:
                c.b(this.f8992b, this.f8993c, this.f8994d);
                break;
        }
    }
}
