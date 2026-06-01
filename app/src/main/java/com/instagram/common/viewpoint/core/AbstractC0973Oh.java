package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0973Oh {
    public final View.AccessibilityDelegate A00 = A02.A00(this);
    public static final C0972Og A02 = new C1672gY();
    public static final View.AccessibilityDelegate A01 = new View.AccessibilityDelegate();

    public final View.AccessibilityDelegate A00() {
        return this.A00;
    }

    public final PU A01(View view) {
        return A02.A01(A01, view);
    }

    public final void A02(View view, int i2) {
        A01.sendAccessibilityEvent(view, i2);
    }

    public final void A03(View view, AccessibilityEvent accessibilityEvent) {
        A01.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final void A04(View view, AccessibilityEvent accessibilityEvent) {
        A01.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public final boolean A05(View view, AccessibilityEvent accessibilityEvent) {
        return A01.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final boolean A06(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return A01.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void A07(View view, AccessibilityEvent accessibilityEvent) {
        A01.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void A08(View view, PS ps) {
        A01.onInitializeAccessibilityNodeInfo(view, ps.A0M());
    }

    public boolean A09(View view, int i2, Bundle bundle) {
        return A02.A02(A01, view, i2, bundle);
    }
}
