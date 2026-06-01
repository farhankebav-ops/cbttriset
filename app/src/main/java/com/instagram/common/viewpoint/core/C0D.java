package com.instagram.common.viewpoint.core;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0D, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0D extends C0M {
    @Override // com.instagram.common.viewpoint.core.PO
    public final Object A00(int i2, int i8, int i9, int i10, boolean z2, boolean z7) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i8, i9, i10, z2, z7);
    }

    @Override // com.instagram.common.viewpoint.core.PO
    public final Object A01(int i2, int i8, boolean z2, int i9) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i2, i8, z2, i9);
    }
}
