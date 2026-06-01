package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1672gY extends C0972Og {
    @Override // com.instagram.common.viewpoint.core.C0972Og
    public final View.AccessibilityDelegate A00(AbstractC0973Oh abstractC0973Oh) {
        return new C0970Oe(this, abstractC0973Oh);
    }

    @Override // com.instagram.common.viewpoint.core.C0972Og
    public final PU A01(View.AccessibilityDelegate accessibilityDelegate, View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new PU(accessibilityNodeProvider);
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.C0972Og
    public final boolean A02(View.AccessibilityDelegate accessibilityDelegate, View view, int i2, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i2, bundle);
    }
}
