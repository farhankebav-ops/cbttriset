package com.ironsource;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.e6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2302e6 implements Lc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2320f6 f8428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<InterfaceC2338g6> f8429b = new WeakReference<>(null);

    /* JADX INFO: renamed from: com.ironsource.e6$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8430a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f8431b = "impressions";

        private a() {
        }
    }

    public final void a(InterfaceC2320f6 loadListener) {
        kotlin.jvm.internal.k.e(loadListener, "loadListener");
        this.f8428a = loadListener;
    }

    @Override // com.ironsource.Lc
    public void onInterstitialAdRewarded(String str, int i2) {
        InterfaceC2338g6 interfaceC2338g6 = this.f8429b.get();
        if (interfaceC2338g6 != null) {
            interfaceC2338g6.onAdInstanceDidReward(str, i2);
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialClick() {
        InterfaceC2338g6 interfaceC2338g6 = this.f8429b.get();
        if (interfaceC2338g6 != null) {
            interfaceC2338g6.onAdInstanceDidClick();
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialClose() {
        InterfaceC2338g6 interfaceC2338g6 = this.f8429b.get();
        if (interfaceC2338g6 != null) {
            interfaceC2338g6.onAdInstanceDidDismiss();
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        InterfaceC2338g6 interfaceC2338g6;
        if (!kotlin.jvm.internal.k.a(str, "impressions") || (interfaceC2338g6 = this.f8429b.get()) == null) {
            return;
        }
        interfaceC2338g6.onAdInstanceDidBecomeVisible();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialLoadFailed(String description) {
        kotlin.jvm.internal.k.e(description, "description");
        InterfaceC2320f6 interfaceC2320f6 = this.f8428a;
        if (interfaceC2320f6 != null) {
            interfaceC2320f6.a(description);
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialLoadSuccess(M9 adInstance) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        InterfaceC2320f6 interfaceC2320f6 = this.f8428a;
        if (interfaceC2320f6 != null) {
            interfaceC2320f6.a(adInstance);
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialOpen() {
        InterfaceC2338g6 interfaceC2338g6 = this.f8429b.get();
        if (interfaceC2338g6 != null) {
            interfaceC2338g6.onAdInstanceDidShow();
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialShowFailed(String str) {
        InterfaceC2338g6 interfaceC2338g6 = this.f8429b.get();
        if (interfaceC2338g6 != null) {
            interfaceC2338g6.a(str);
        }
    }

    public final void a(InterfaceC2338g6 showListener) {
        kotlin.jvm.internal.k.e(showListener, "showListener");
        this.f8429b = new WeakReference<>(showListener);
    }

    @Override // com.ironsource.Lc
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.Lc
    public void onInterstitialShowSuccess() {
    }

    @Override // com.ironsource.Lc
    public void onInterstitialInitFailed(String str) {
    }
}
