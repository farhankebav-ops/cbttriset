package com.unity3d.ads.adplayer.model;

import com.ironsource.mediationsdk.l;
import com.unity3d.services.banners.bridge.BannerBridge;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OnScarBannerEvent implements WebViewEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnScarBannerEvent(BannerBridge.BannerEvent bannerEvent) {
        k.e(bannerEvent, "bannerEvent");
        this.category = l.f9204a;
        this.name = bannerEvent.name();
        this.parameters = new Object[0];
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public String getCategory() {
        return this.category;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public String getName() {
        return this.name;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public Object[] getParameters() {
        return this.parameters;
    }
}
