package com.ironsource;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Kc implements Jc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private B2 f7060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<D2> f7061b = new WeakReference<>(null);

    public final void a(B2 loadListener) {
        kotlin.jvm.internal.k.e(loadListener, "loadListener");
        this.f7060a = loadListener;
    }

    @Override // com.ironsource.Jc
    public void onBannerClick() {
        D2 d22 = this.f7061b.get();
        if (d22 != null) {
            d22.onBannerClick();
        }
    }

    @Override // com.ironsource.Jc
    public void onBannerLoadFail(String description) {
        kotlin.jvm.internal.k.e(description, "description");
        B2 b22 = this.f7060a;
        if (b22 != null) {
            b22.onBannerLoadFail(description);
        }
    }

    @Override // com.ironsource.Jc
    public void onBannerLoadSuccess(M9 adInstance, C2411k8 adContainer) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(adContainer, "adContainer");
        B2 b22 = this.f7060a;
        if (b22 != null) {
            b22.onBannerLoadSuccess(adInstance, adContainer);
        }
    }

    @Override // com.ironsource.Jc
    public void onBannerShowSuccess() {
        D2 d22 = this.f7061b.get();
        if (d22 != null) {
            d22.onBannerShowSuccess();
        }
    }

    public final void a(D2 showListener) {
        kotlin.jvm.internal.k.e(showListener, "showListener");
        this.f7061b = new WeakReference<>(showListener);
    }

    @Override // com.ironsource.Jc
    public void onBannerInitSuccess() {
    }

    @Override // com.ironsource.Jc
    public void onBannerInitFailed(String str) {
    }
}
