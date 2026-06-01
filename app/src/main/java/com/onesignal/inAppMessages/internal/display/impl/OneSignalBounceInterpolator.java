package com.onesignal.inAppMessages.internal.display.impl;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalBounceInterpolator implements Interpolator {
    private double mAmplitude;
    private double mFrequency;

    public OneSignalBounceInterpolator(double d8, double d9) {
        this.mAmplitude = d8;
        this.mFrequency = d9;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        return (float) ((Math.cos(this.mFrequency * ((double) f4)) * Math.pow(2.718281828459045d, ((double) (-f4)) / this.mAmplitude) * ((double) (-1))) + ((double) 1));
    }
}
