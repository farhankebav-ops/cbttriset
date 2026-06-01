package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PY extends AccessibilityNodeProvider {
    public final /* synthetic */ PZ A00;

    public PY(PZ pz) {
        this.A00 = pz;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        return (AccessibilityNodeInfo) this.A00.A58(i2);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
        return this.A00.A6Q(str, i2);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i2) {
        return (AccessibilityNodeInfo) this.A00.A6R(i2);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i2, int i8, Bundle bundle) {
        return this.A00.AGB(i2, i8, bundle);
    }
}
