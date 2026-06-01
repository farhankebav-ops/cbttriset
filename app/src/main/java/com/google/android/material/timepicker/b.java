package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f5504a;

    public b(ClockFaceView clockFaceView) {
        this.f5504a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f5504a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f5487d.f5498d) - clockFaceView.l;
        if (height != clockFaceView.f5509b) {
            clockFaceView.f5509b = height;
            clockFaceView.a();
            ClockHandView clockHandView = clockFaceView.f5487d;
            clockHandView.l = clockFaceView.f5509b;
            clockHandView.invalidate();
        }
        return true;
    }
}
