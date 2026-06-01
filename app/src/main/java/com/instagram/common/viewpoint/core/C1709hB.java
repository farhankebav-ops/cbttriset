package com.instagram.common.viewpoint.core;

import android.content.Context;
import com.facebook.ads.AdSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1709hB implements TL {
    @Override // com.instagram.common.viewpoint.core.TL
    public final String A71() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final String A7F() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final C1073Se A7e(SQ sq) {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final String A8O() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final String A98() {
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            return AdSettings.getTestAdType().getAdTypeString();
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final boolean AAR() {
        return AdSettings.isMixedAudience();
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final boolean AAX() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final Boolean AAb() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TL
    public final boolean isTestMode(Context context) {
        return AdSettings.isTestMode(context);
    }
}
