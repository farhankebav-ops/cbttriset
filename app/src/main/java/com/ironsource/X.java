package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.InitListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class X implements W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2523qc f7787a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements Nc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2269c9 f7788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InitListener f7789b;

        public a(C2269c9 c2269c9, InitListener initListener) {
            this.f7788a = c2269c9;
            this.f7789b = initListener;
        }

        @Override // com.ironsource.Nc
        public void onFail(C2586u8 error) {
            kotlin.jvm.internal.k.e(error, "error");
            IronLog.ADAPTER_API.verbose("initSDKWithNetworkConfigurations error: " + error);
            this.f7789b.onInitFailed(C2668z5.f10625a.a(new IronSourceError(error.a(), error.b())));
        }

        @Override // com.ironsource.Nc
        public void onSuccess() {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("initSDKWithNetworkConfigurations success");
            V vE = this.f7788a.e();
            com.google.android.gms.ads.internal.client.a.p("controllerURL = ", vE != null ? vE.c() : null, ironLog);
            V vE2 = this.f7788a.e();
            ironLog.verbose("controllerConfig = " + (vE2 != null ? vE2.a() : null));
            V vE3 = this.f7788a.e();
            ironLog.verbose("debugMode = " + (vE3 != null ? Integer.valueOf(vE3.b()) : null));
            com.google.android.gms.ads.internal.client.a.p("applicationKey = ", this.f7788a.d(), ironLog);
            com.google.android.gms.ads.internal.client.a.p("userId = ", this.f7788a.h(), ironLog);
            this.f7789b.onInitSuccess();
        }
    }

    public X(InterfaceC2523qc networkInitApi) {
        kotlin.jvm.internal.k.e(networkInitApi, "networkInitApi");
        this.f7787a = networkInitApi;
    }

    @Override // com.ironsource.W
    public void a(Context context, C2269c9 initConfig, InitListener initListener) {
        JSONObject jSONObjectA;
        String strC;
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(initConfig, "initConfig");
        kotlin.jvm.internal.k.e(initListener, "initListener");
        InterfaceC2523qc interfaceC2523qc = this.f7787a;
        V vE = initConfig.e();
        interfaceC2523qc.a(vE != null ? vE.b() : 0);
        V vE2 = initConfig.e();
        if (vE2 != null && (strC = vE2.c()) != null) {
            this.f7787a.b(strC);
        }
        V vE3 = initConfig.e();
        if (vE3 != null && (jSONObjectA = vE3.a()) != null) {
            InterfaceC2523qc interfaceC2523qc2 = this.f7787a;
            String string = jSONObjectA.toString();
            kotlin.jvm.internal.k.d(string, "applicationConfig.toString()");
            interfaceC2523qc2.a(string);
        }
        Map<String, String> mapA = new C2489oc().a();
        this.f7787a.a(new a(initConfig, initListener));
        this.f7787a.a(context, initConfig.d(), initConfig.h(), mapA);
    }
}
