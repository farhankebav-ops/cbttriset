package com.ironsource;

import android.content.Context;
import com.ironsource.Me;
import com.ironsource.V;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class P9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P9 f7378a = new P9();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C2412k9 f7379b = new C2412k9();

    private P9() {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2541re {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C2426l5 f7381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InitListener f7382c;

        public b(Context context, C2426l5 c2426l5, InitListener initListener) {
            this.f7380a = context;
            this.f7381b = c2426l5;
            this.f7382c = initListener;
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2435le sdkConfig) {
            kotlin.jvm.internal.k.e(sdkConfig, "sdkConfig");
            P9.f7378a.a(this.f7380a, sdkConfig.d(), this.f7381b, this.f7382c);
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2473ne error) {
            kotlin.jvm.internal.k.e(error, "error");
            P9.f7378a.a(this.f7382c, this.f7381b, error);
        }
    }

    public final void a(Context context, InitRequest initRequest, InitListener initializationListener) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(initRequest, "initRequest");
        kotlin.jvm.internal.k.e(initializationListener, "initializationListener");
        IronLog.API.info("IronSourceAds.init() appkey: " + initRequest.getAppKey() + ", legacyAdFormats: " + initRequest.getLegacyAdFormats() + ", context: " + context.getClass().getSimpleName());
        f7379b.a(new androidx.camera.core.processing.c(initRequest, context, initializationListener, 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitRequest initRequest, Context context, InitListener initializationListener) {
        kotlin.jvm.internal.k.e(initRequest, "$initRequest");
        kotlin.jvm.internal.k.e(context, "$context");
        kotlin.jvm.internal.k.e(initializationListener, "$initializationListener");
        C2426l5 c2426l5 = new C2426l5();
        Ae.f6342a.c(context, new C2575te(initRequest.getAppKey(), null, r5.j.t0(f7379b.a(initRequest.getLegacyAdFormats())), 2, null), new b(context, c2426l5, initializationListener));
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InitListener {
        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitFailed(IronSourceError error) {
            kotlin.jvm.internal.k.e(error, "error");
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitSuccess() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, Me me, C2426l5 c2426l5, InitListener initListener) {
        String strT = com.ironsource.mediationsdk.r.m().t();
        C2269c9 c2269c9F = me.f();
        kotlin.jvm.internal.k.d(c2269c9F, "serverResponse.initialConfiguration");
        NetworkSettings networkSettingsB = me.k().b("IronSource");
        kotlin.jvm.internal.k.d(networkSettingsB, "serverResponse.providerS…s.IRONSOURCE_CONFIG_NAME)");
        JSONObject interstitialSettings = networkSettingsB.getInterstitialSettings();
        kotlin.jvm.internal.k.d(interstitialSettings, "networkSettings.interstitialSettings");
        c2269c9F.a(new V.a(interstitialSettings));
        c2269c9F.a(ConfigFile.getConfigFile().getPluginType());
        c2269c9F.b(strT);
        new X(new C2539rc()).a(context, c2269c9F, new a());
        a(me, c2426l5, initListener);
    }

    private final void a(Me me, C2426l5 c2426l5, InitListener initListener) {
        J1 j1E;
        A1 a1B = me.c().b();
        new Nb().a((a1B == null || (j1E = a1B.e()) == null) ? null : j1E.b(), true);
        String sessionId = com.ironsource.mediationsdk.r.m().t();
        C2415kc c2415kcA = C2415kc.e.a();
        c2415kcA.a(me.k());
        c2415kcA.a(me.c());
        kotlin.jvm.internal.k.d(sessionId, "sessionId");
        c2415kcA.a(sessionId);
        c2415kcA.g();
        long jA = C2426l5.a(c2426l5);
        C2412k9 c2412k9 = f7379b;
        Me.a aVarH = me.h();
        kotlin.jvm.internal.k.d(aVarH, "serverResponse.origin");
        c2412k9.a(jA, aVarH);
        c2412k9.b(new ch(initListener, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitListener initListener) {
        IronLog.CALLBACK.info("InitListener.onInitSuccess()");
        if (initListener != null) {
            initListener.onInitSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(InitListener initListener, C2426l5 c2426l5, C2473ne c2473ne) {
        long jA = C2426l5.a(c2426l5);
        C2412k9 c2412k9 = f7379b;
        c2412k9.a(c2473ne, jA);
        c2412k9.b(new ti(6, c2473ne, initListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2473ne error, InitListener initListener) {
        kotlin.jvm.internal.k.e(error, "$error");
        IronLog.CALLBACK.info("InitListener.onInitFailed() error " + error);
        if (initListener != null) {
            initListener.onInitFailed(f7379b.a(error));
        }
    }

    public final void a(String key, String value) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        ArrayList arrayList = new ArrayList();
        arrayList.add(value);
        com.ironsource.mediationsdk.r.m().a(key, arrayList);
    }
}
