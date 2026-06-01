package com.bytedance.sdk.component.adexpress.dynamic.EO.IlO;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW implements View.OnTouchListener {
    private float Bc;
    private float Cc;
    private final int EO = 10;
    private final com.bytedance.sdk.component.adexpress.dynamic.EO.lEW IlO;
    private final boolean MY;
    private float tV;
    private float vCE;

    public lEW(com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew, boolean z2) {
        this.IlO = lew;
        this.MY = z2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew;
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.tV = motionEvent.getX();
            this.Cc = motionEvent.getY();
            new StringBuilder(", mStartY: ").append(this.Cc);
        } else if (action == 1) {
            this.vCE = motionEvent.getX();
            this.Bc = motionEvent.getY();
            new StringBuilder(", mEndY: ").append(this.Bc);
            if (this.MY || (lew2 = this.IlO) == null) {
                float f4 = this.vCE - this.tV;
                float f8 = this.Bc - this.Cc;
                if (com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), Math.abs((float) Math.sqrt((f8 * f8) + (f4 * f4)))) > 10.0f && (lew = this.IlO) != null) {
                    lew.IlO();
                }
            } else {
                lew2.IlO();
            }
        }
        return true;
    }
}
