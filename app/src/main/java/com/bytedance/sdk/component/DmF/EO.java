package com.bytedance.sdk.component.DmF;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EO implements View.OnTouchListener {
    private ViewConfiguration IlO;
    private int MY = -1;

    public abstract void IlO(View.OnTouchListener onTouchListener);

    public boolean IlO(float f4, float f8, float f9, float f10, Context context) {
        if (this.IlO == null) {
            this.IlO = ViewConfiguration.get(context);
        }
        if (this.MY == -1) {
            this.MY = this.IlO.getScaledTouchSlop();
        }
        return Math.abs(f4 - f9) <= ((float) this.MY) && Math.abs(f8 - f10) <= ((float) this.MY);
    }
}
