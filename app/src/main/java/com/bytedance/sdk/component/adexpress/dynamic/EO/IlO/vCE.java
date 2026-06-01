package com.bytedance.sdk.component.adexpress.dynamic.EO.IlO;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements View.OnTouchListener {
    private static int EO = 10;
    private com.bytedance.sdk.component.adexpress.dynamic.EO.lEW Cc;
    private float IlO;
    private float MY;
    private boolean tV;

    public vCE(com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew) {
        this.Cc = lew;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.IlO = motionEvent.getX();
            this.MY = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x2 - this.IlO) >= EO || Math.abs(y - this.MY) >= EO) {
                    this.tV = true;
                }
            } else if (action == 3) {
                this.tV = false;
            }
        } else {
            if (this.tV) {
                this.tV = false;
                return false;
            }
            float x7 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x7 - this.IlO) >= EO || Math.abs(y2 - this.MY) >= EO) {
                this.tV = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew = this.Cc;
                if (lew != null) {
                    lew.IlO();
                }
            }
        }
        return true;
    }
}
