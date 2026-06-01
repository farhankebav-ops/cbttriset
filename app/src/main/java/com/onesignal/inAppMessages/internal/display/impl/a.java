package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.ValueAnimator;
import android.view.View;
import i1.c;
import z1.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10703b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f10702a = i2;
        this.f10703b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f10702a) {
            case 0:
                OneSignalAnimate.m3155animateViewColor$lambda0((View) this.f10703b, valueAnimator);
                break;
            case 1:
                c cVar = (c) this.f10703b;
                cVar.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cVar.j.setAlpha((int) (255.0f * fFloatValue));
                cVar.f11808x = fFloatValue;
                break;
            default:
                j jVar = (j) this.f10703b;
                jVar.getClass();
                jVar.f17936d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
