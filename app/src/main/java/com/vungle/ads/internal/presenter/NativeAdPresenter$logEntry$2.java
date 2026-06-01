package com.vungle.ads.internal.presenter;

import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.util.LogEntry;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeAdPresenter$logEntry$2 extends l implements e6.a {
    final /* synthetic */ NativeAdPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAdPresenter$logEntry$2(NativeAdPresenter nativeAdPresenter) {
        super(0);
        this.this$0 = nativeAdPresenter;
    }

    @Override // e6.a
    public final LogEntry invoke() {
        AdPayload adPayload = this.this$0.advertisement;
        if (adPayload != null) {
            return adPayload.getLogEntry$vungle_ads_release();
        }
        return null;
    }
}
