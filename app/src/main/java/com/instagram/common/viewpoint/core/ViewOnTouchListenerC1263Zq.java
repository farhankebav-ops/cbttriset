package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1263Zq implements View.OnTouchListener {
    public final /* synthetic */ ViewOnClickListenerC1264Zr A00;

    public ViewOnTouchListenerC1263Zq(ViewOnClickListenerC1264Zr viewOnClickListenerC1264Zr) {
        this.A00 = viewOnClickListenerC1264Zr;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.A00.A00(motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }
}
