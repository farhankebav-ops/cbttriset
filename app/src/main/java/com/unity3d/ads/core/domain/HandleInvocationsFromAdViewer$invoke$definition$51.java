package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HandleInvocationsFromAdViewer$invoke$definition$51 extends l implements e6.a {
    final /* synthetic */ AdObject $adObject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandleInvocationsFromAdViewer$invoke$definition$51(AdObject adObject) {
        super(0);
        this.$adObject = adObject;
    }

    @Override // e6.a
    public final ExposedFunction invoke() {
        return CommonAdViewerExposedFunctionsKt.setOpportunityTTL(this.$adObject);
    }
}
