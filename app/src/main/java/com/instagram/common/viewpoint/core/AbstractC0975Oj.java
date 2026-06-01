package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0975Oj {
    public static boolean A00(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
