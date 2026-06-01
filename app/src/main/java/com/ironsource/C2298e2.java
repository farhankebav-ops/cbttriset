package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.ironsource.e2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2298e2 implements Xc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f8269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ironsource.mediationsdk.e f8270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8271c;

    public C2298e2(V0 adTools, com.ironsource.mediationsdk.e auctionHandler) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(auctionHandler, "auctionHandler");
        this.f8269a = adTools;
        this.f8270b = auctionHandler;
    }

    @Override // com.ironsource.Xc
    public void a(AbstractC2662z instance, String str, C2469na publisherDataHolder) {
        kotlin.jvm.internal.k.e(instance, "instance");
        kotlin.jvm.internal.k.e(publisherDataHolder, "publisherDataHolder");
        this.f8270b.a(instance.h(), instance.r(), instance.m(), str);
        a(publisherDataHolder, instance.h(), str);
    }

    @Override // com.ironsource.Xc
    public void a(List<? extends AbstractC2662z> waterfallInstances, AbstractC2662z winnerInstance) {
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
        kotlin.jvm.internal.k.e(winnerInstance, "winnerInstance");
        if (this.f8271c) {
            return;
        }
        this.f8271c = true;
        C2461n2 c2461n2H = winnerInstance.h();
        this.f8270b.a(c2461n2H, winnerInstance.r(), winnerInstance.m());
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, C2461n2> concurrentHashMap = new ConcurrentHashMap<>();
        for (AbstractC2662z abstractC2662z : waterfallInstances) {
            arrayList.add(abstractC2662z.p());
            concurrentHashMap.put(abstractC2662z.p(), abstractC2662z.h());
        }
        this.f8270b.a(arrayList, concurrentHashMap, winnerInstance.r(), winnerInstance.m(), c2461n2H);
    }

    private final void a(C2469na c2469na, C2461n2 c2461n2, String str) {
        if (c2461n2 != null) {
            Y8 y8A = c2461n2.a(str);
            if (y8A != null) {
                Iterator it = new HashSet(c2469na.a()).iterator();
                while (it.hasNext()) {
                    this.f8269a.e(new androidx.camera.core.processing.c(this, (InterfaceC2233a9) it.next(), y8A, 21));
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.error(C2459n0.a(this.f8269a, "reportImpressionDataToPublisher - no auctionResponseItem or listener", (String) null, 2, (Object) null));
        this.f8269a.e().h().g("reportImpressionDataToPublisher - no auctionResponseItem or listener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2298e2 this$0, InterfaceC2233a9 listener, Y8 impressionData) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(listener, "$listener");
        IronLog.CALLBACK.verbose(C2459n0.a(this$0.f8269a, "onImpressionSuccess " + listener.getClass().getSimpleName() + ": " + impressionData, (String) null, 2, (Object) null));
        kotlin.jvm.internal.k.d(impressionData, "impressionData");
        listener.a(impressionData);
    }
}
