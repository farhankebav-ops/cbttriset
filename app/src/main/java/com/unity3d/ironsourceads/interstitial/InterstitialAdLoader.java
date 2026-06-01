package com.unity3d.ironsourceads.interstitial;

import com.ironsource.C2415kc;
import com.ironsource.C2672z9;
import com.ironsource.Cb;
import com.ironsource.Fb;
import com.ironsource.V7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import n3.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InterstitialAdLoader {
    public static final InterstitialAdLoader INSTANCE = new InterstitialAdLoader();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f10886a = V7.f7731a.c();

    private InterstitialAdLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Cb loadTask) {
        k.e(loadTask, "$loadTask");
        loadTask.start();
    }

    public static final void loadAd(InterstitialAdRequest adRequest, InterstitialAdLoaderListener listener) {
        k.e(adRequest, "adRequest");
        k.e(listener, "listener");
        IronLog.API.info("instanceId: " + adRequest.getInstanceId());
        INSTANCE.internalLoadAd$mediationsdk_release(f10886a, new C2672z9(adRequest, listener, C2415kc.e.a(IronSource.a.INTERSTITIAL), null, 8, null));
    }

    public final void internalLoadAd$mediationsdk_release(Executor executor, Fb loadTaskProvider) {
        k.e(executor, "executor");
        k.e(loadTaskProvider, "loadTaskProvider");
        executor.execute(new a(loadTaskProvider.a(), 1));
    }
}
