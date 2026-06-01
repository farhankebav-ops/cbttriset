package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdapterBaseInterface f9023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f9024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f9025d;

    public /* synthetic */ b0(AdapterBaseInterface adapterBaseInterface, String str, List list, int i2) {
        this.f9022a = i2;
        this.f9023b = adapterBaseInterface;
        this.f9024c = str;
        this.f9025d = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9022a) {
            case 0:
                c.a(this.f9023b, this.f9024c, this.f9025d);
                break;
            default:
                c.b(this.f9023b, this.f9024c, this.f9025d);
                break;
        }
    }
}
