package com.ironsource;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class W1 implements X1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2448m9 f7754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ironsource.mediationsdk.d f7755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2280d2 f7756c;

    public W1(C2448m9 instanceInfo, com.ironsource.mediationsdk.d auctionDataUtils, C2280d2 c2280d2) {
        kotlin.jvm.internal.k.e(instanceInfo, "instanceInfo");
        kotlin.jvm.internal.k.e(auctionDataUtils, "auctionDataUtils");
        this.f7754a = instanceInfo;
        this.f7755b = auctionDataUtils;
        this.f7756c = c2280d2;
    }

    @Override // com.ironsource.X1
    public void a(String methodName) {
        List<String> listB;
        kotlin.jvm.internal.k.e(methodName, "methodName");
        C2280d2 c2280d2 = this.f7756c;
        if (c2280d2 == null || (listB = c2280d2.b()) == null) {
            listB = r5.r.f13638a;
        }
        a(listB, methodName);
    }

    @Override // com.ironsource.X1
    public void b(String methodName) {
        List<String> listA;
        kotlin.jvm.internal.k.e(methodName, "methodName");
        C2280d2 c2280d2 = this.f7756c;
        if (c2280d2 == null || (listA = c2280d2.a()) == null) {
            listA = r5.r.f13638a;
        }
        a(listA, methodName);
    }

    @Override // com.ironsource.X1
    public void c(String methodName) {
        List<String> listC;
        kotlin.jvm.internal.k.e(methodName, "methodName");
        C2280d2 c2280d2 = this.f7756c;
        if (c2280d2 == null || (listC = c2280d2.c()) == null) {
            listC = r5.r.f13638a;
        }
        a(listC, methodName);
    }

    private final void a(List<String> list, String str) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f7755b.a(str, this.f7754a.e(), com.ironsource.mediationsdk.d.b().a(it.next(), this.f7754a.e(), this.f7754a.f(), this.f7754a.d(), "", "", "", ""));
        }
    }
}
