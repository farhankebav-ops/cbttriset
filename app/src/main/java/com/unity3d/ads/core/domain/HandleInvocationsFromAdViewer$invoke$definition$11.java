package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HandleInvocationsFromAdViewer$invoke$definition$11 extends l implements e6.a {
    public static final HandleInvocationsFromAdViewer$invoke$definition$11 INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$11();

    public HandleInvocationsFromAdViewer$invoke$definition$11() {
        super(0);
    }

    @Override // e6.a
    public final ExposedFunction invoke() {
        return CommonAdViewerExposedFunctionsKt.readStorage();
    }
}
