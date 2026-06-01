package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class M1 implements InterfaceC2466n7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final I7 f7109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private N1 f7110b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public final N1 a(K1 k12, I7 featureAvailabilityService) {
            kotlin.jvm.internal.k.e(featureAvailabilityService, "featureAvailabilityService");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("isAndroidxApplicationLifecycleAvailable: " + featureAvailabilityService.a());
            ironLog.verbose("isAndroidxApplicationLifecycleEnabled: " + (k12 != null ? Boolean.valueOf(k12.k()) : null));
            boolean z2 = false;
            if (featureAvailabilityService.a()) {
                C2256be.i().a(new C5(D5.TROUBLESHOOTING_ANDROIDX_PROCESS_LIFECYCLE_OWNER_AVAILABLE, IronSourceUtils.b(false)));
            }
            if ((k12 != null ? k12.k() : false) && featureAvailabilityService.a()) {
                z2 = true;
            }
            ironLog.verbose("isAndroidxEnabled: " + z2);
            return z2 ? new C2579u1() : new X7();
        }
    }

    public M1(I7 featureAvailabilityService) {
        kotlin.jvm.internal.k.e(featureAvailabilityService, "featureAvailabilityService");
        this.f7109a = featureAvailabilityService;
    }

    @Override // com.ironsource.InterfaceC2466n7
    public void a(K1 k12) {
        if (this.f7110b == null) {
            this.f7110b = new a().a(k12, this.f7109a);
        }
    }

    @Override // com.ironsource.N1
    public void b(InterfaceC2413ka observer) {
        kotlin.jvm.internal.k.e(observer, "observer");
        N1 n12 = this.f7110b;
        if (n12 != null) {
            n12.b(observer);
        }
    }

    @Override // com.ironsource.N1
    public void a(InterfaceC2413ka observer) {
        kotlin.jvm.internal.k.e(observer, "observer");
        N1 n12 = this.f7110b;
        if (n12 != null) {
            n12.a(observer);
        }
    }
}
