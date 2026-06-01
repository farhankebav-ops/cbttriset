package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Hg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6951c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f6952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Xc f6953b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Hg a(V0 adTools, AbstractC2595v0 adUnitData, Xc outcomeReporter, Cg waterfallInstances, F adInstanceLoadStrategy) {
            kotlin.jvm.internal.k.e(adTools, "adTools");
            kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
            kotlin.jvm.internal.k.e(outcomeReporter, "outcomeReporter");
            kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
            kotlin.jvm.internal.k.e(adInstanceLoadStrategy, "adInstanceLoadStrategy");
            return adUnitData.q() ? new C2509pf(adTools, outcomeReporter, waterfallInstances, adInstanceLoadStrategy) : new O4(adTools, outcomeReporter, waterfallInstances);
        }

        private a() {
        }
    }

    public Hg(C2459n0 adTools, Xc outcomeReporter) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(outcomeReporter, "outcomeReporter");
        this.f6952a = adTools;
        this.f6953b = outcomeReporter;
    }

    private final void b(AbstractC2662z abstractC2662z, List<? extends AbstractC2662z> list) {
        for (AbstractC2662z abstractC2662z2 : list) {
            if (abstractC2662z2 == abstractC2662z) {
                abstractC2662z.a(true);
                return;
            } else {
                abstractC2662z2.a(false);
                IronLog.INTERNAL.verbose(C2459n0.a(this.f6952a, a1.a.C(abstractC2662z2.q(), " - not ready to show"), (String) null, 2, (Object) null));
            }
        }
    }

    public abstract void a();

    public abstract void a(AbstractC2662z abstractC2662z);

    public final void a(AbstractC2662z instanceToShow, List<? extends AbstractC2662z> orderedInstances) {
        kotlin.jvm.internal.k.e(instanceToShow, "instanceToShow");
        kotlin.jvm.internal.k.e(orderedInstances, "orderedInstances");
        b(instanceToShow, orderedInstances);
        c(instanceToShow);
    }

    public abstract void b(AbstractC2662z abstractC2662z);

    public abstract void c(AbstractC2662z abstractC2662z);

    public final void a(AbstractC2662z instance, String str, C2469na publisherDataHolder) {
        kotlin.jvm.internal.k.e(instance, "instance");
        kotlin.jvm.internal.k.e(publisherDataHolder, "publisherDataHolder");
        this.f6953b.a(instance, str, publisherDataHolder);
    }
}
