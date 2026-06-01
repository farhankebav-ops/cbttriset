package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1455cy implements View.OnTouchListener {
    public final /* synthetic */ C1456cz A00;

    public ViewOnTouchListenerC1455cy(C1456cz c1456cz) {
        this.A00 = c1456cz;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.A00.A01 = System.currentTimeMillis();
            C1456cz.A00(this.A00);
            this.A00.A07.ABJ(this.A00.A04.A25(), new C1262Zp().A03(this.A00.getViewabilityChecker()).A02(this.A00.getTouchDataRecorder()).A05());
            return false;
        }
        return false;
    }
}
