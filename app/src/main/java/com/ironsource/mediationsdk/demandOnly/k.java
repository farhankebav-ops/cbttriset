package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.C2499p5;
import com.ironsource.C2531r4;
import com.ironsource.D5;
import com.ironsource.InterfaceC2250b8;
import com.ironsource.L9;
import com.ironsource.U4;
import com.ironsource.Zd;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class k implements i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final U4 f9138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, l> f9139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2250b8<ISDemandOnlyRewardedVideoListener> f9140c;

    public k(List<NetworkSettings> list, Zd zd, com.ironsource.mediationsdk.c cVar, InterfaceC2250b8<ISDemandOnlyRewardedVideoListener> interfaceC2250b8, String str, String str2, U4 u42) {
        String strD = IronSourceUtils.d();
        boolean zD = zd.d();
        com.ironsource.mediationsdk.f fVar = new com.ironsource.mediationsdk.f(zd.k(), strD);
        this.f9139b = new ConcurrentHashMap<>();
        this.f9138a = u42;
        this.f9140c = interfaceC2250b8;
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter abstractAdapterA = cVar.a(networkSettings, networkSettings.getRewardedVideoSettings(), true);
                if (abstractAdapterA != null) {
                    l lVar = new l(str, str2, networkSettings, this.f9140c.a(networkSettings.getSubProviderId()), zd.i(), abstractAdapterA, new com.ironsource.mediationsdk.e(fVar));
                    lVar.a(zD);
                    this.f9139b.put(networkSettings.getSubProviderId(), lVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public void a(h.d dVar) {
        String strE = dVar.e();
        try {
            l lVar = this.f9139b.get(strE);
            if (lVar == null) {
                this.f9138a.a(D5.RV_DO_BUSINESS_INSTANCE_NOT_FOUND_IN_LOAD, strE);
                IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
                this.f9140c.a(strE).onRewardedVideoAdLoadFailed(strE, ironSourceErrorBuildNonExistentInstanceError);
                return;
            }
            if (dVar.c()) {
                lVar.b(new o.a(L9.b(C2499p5.b().c(), dVar.b())));
            } else {
                lVar.c();
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideo exception " + e.getMessage());
            IronLog.API.error(ironSourceErrorBuildLoadFailedError.getErrorMessage());
            this.f9140c.a(strE).onRewardedVideoAdLoadFailed(strE, ironSourceErrorBuildLoadFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public void b(String str) {
        try {
            l lVar = this.f9139b.get(str);
            if (lVar != null) {
                lVar.d();
                return;
            }
            this.f9138a.a(D5.RV_DO_BUSINESS_INSTANCE_NOT_FOUND_IN_SHOW, str);
            IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
            IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
            this.f9140c.a(str).onRewardedVideoAdShowFailed(str, ironSourceErrorBuildNonExistentInstanceError);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceError ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, "showRewardedVideo exception " + e.getMessage());
            IronLog.API.error(ironSourceErrorBuildShowFailedError.getErrorMessage());
            this.f9140c.a(str).onRewardedVideoAdShowFailed(str, ironSourceErrorBuildShowFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public boolean a(String str) {
        l lVar = this.f9139b.get(str);
        if (lVar == null) {
            this.f9138a.a(D5.RV_DO_INSTANCE_NOT_FOUND_IN_AVAILABILITY_CHECK, str);
            return false;
        }
        return lVar.a();
    }

    public ConcurrentHashMap<String, l> a() {
        return this.f9139b;
    }
}
