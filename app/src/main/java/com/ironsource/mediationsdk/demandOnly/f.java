package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.C2499p5;
import com.ironsource.C2531r4;
import com.ironsource.D5;
import com.ironsource.F9;
import com.ironsource.InterfaceC2250b8;
import com.ironsource.L9;
import com.ironsource.U4;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class f implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final U4 f9109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, g> f9110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2250b8<ISDemandOnlyInterstitialListener> f9111c;

    public f(List<NetworkSettings> list, F9 f9, com.ironsource.mediationsdk.c cVar, InterfaceC2250b8<ISDemandOnlyInterstitialListener> interfaceC2250b8, String str, String str2, U4 u42) {
        String strD = IronSourceUtils.d();
        boolean zJ = f9.j();
        com.ironsource.mediationsdk.f fVar = new com.ironsource.mediationsdk.f(f9.g(), strD);
        this.f9110b = new ConcurrentHashMap<>();
        this.f9109a = u42;
        this.f9111c = interfaceC2250b8;
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter abstractAdapterA = cVar.a(networkSettings, networkSettings.getInterstitialSettings(), true);
                if (abstractAdapterA != null) {
                    g gVar = new g(str, str2, networkSettings, this.f9111c.a(networkSettings.getSubProviderId()), f9.e(), abstractAdapterA, new com.ironsource.mediationsdk.e(fVar));
                    gVar.a(zJ);
                    this.f9110b.put(networkSettings.getSubProviderId(), gVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(h.d dVar) {
        String strE = dVar.e();
        String strB = dVar.b();
        try {
            g gVar = this.f9110b.get(strE);
            if (gVar == null) {
                this.f9109a.a(D5.IS_DO_INSTANCE_NOT_FOUND_IN_LOAD, strE);
                IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
                this.f9111c.a(strE).onInterstitialAdLoadFailed(strE, ironSourceErrorBuildNonExistentInstanceError);
                return;
            }
            if (TextUtils.isEmpty(strB)) {
                gVar.b();
            } else {
                gVar.a(new o.a(L9.b(C2499p5.b().c(), strB)));
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial exception " + e.getMessage());
            IronLog.API.error(ironSourceErrorBuildLoadFailedError.getErrorMessage());
            this.f9111c.a(strE).onInterstitialAdLoadFailed(strE, ironSourceErrorBuildLoadFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public boolean b(String str) {
        g gVar = this.f9110b.get(str);
        if (gVar != null) {
            return gVar.a();
        }
        this.f9109a.a(D5.IS_DO_INSTANCE_NOT_FOUND_IN_AVAILABILITY_CHECK, str);
        return false;
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(String str) {
        try {
            g gVar = this.f9110b.get(str);
            if (gVar == null) {
                this.f9109a.a(D5.IS_DO_INSTANCE_NOT_FOUND_IN_SHOW, str);
                IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
                this.f9111c.a(str).onInterstitialAdShowFailed(str, ironSourceErrorBuildNonExistentInstanceError);
                return;
            }
            gVar.e();
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceError ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial exception " + e.getMessage());
            IronLog.API.error(ironSourceErrorBuildShowFailedError.getErrorMessage());
            this.f9111c.a(str).onInterstitialAdShowFailed(str, ironSourceErrorBuildShowFailedError);
        }
    }

    public ConcurrentHashMap<String, g> a() {
        return this.f9110b;
    }
}
