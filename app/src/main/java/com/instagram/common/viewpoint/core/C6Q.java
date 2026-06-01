package com.instagram.common.viewpoint.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6Q extends C1620fg {
    public InterfaceC1478dM A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A06(NativeAdLayout nativeAdLayout, C1477dL c1477dL, NativeAd nativeAd, C1137Ur c1137Ur) {
        C1291aK c1291aK = new C1291aK(c1477dL);
        MediaView mediaView = new MediaView(c1477dL);
        AdOptionsView adOptionsView = new AdOptionsView(c1477dL, nativeAd, nativeAdLayout);
        c1137Ur.A09(adOptionsView, 28);
        this.A00 = new EP(c1477dL, nativeAd, c1137Ur, C1020Qc.A0L(nativeAd.getInternalNativeAd()).A18(), c1291aK, mediaView, adOptionsView);
        XP.A0K(nativeAdLayout, c1137Ur.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, c1291aK, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.instagram.common.viewpoint.core.R8, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
