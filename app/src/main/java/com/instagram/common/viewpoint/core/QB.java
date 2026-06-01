package com.instagram.common.viewpoint.core;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QB implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        float f8 = f4 - 1.0f;
        return (f8 * f8 * f8 * f8 * f8) + 1.0f;
    }
}
