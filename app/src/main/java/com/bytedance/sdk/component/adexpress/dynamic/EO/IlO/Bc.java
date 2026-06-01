package com.bytedance.sdk.component.adexpress.dynamic.EO.IlO;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc implements View.OnTouchListener {
    private static int EO = 10;
    private int Cc;
    private float IlO;
    private float MY;
    private com.bytedance.sdk.component.adexpress.dynamic.EO.lEW tV;
    private RectF vCE = new RectF();
    private long Bc = 0;
    private final int lEW = 200;
    private final int DmF = 3;
    private SoftReference<View> NV = new SoftReference<>(null);

    public Bc(com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew, int i2, final ViewGroup viewGroup) {
        this.Cc = EO;
        this.tV = lew;
        if (i2 > 0) {
            this.Cc = i2;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.Bc.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    Bc.this.NV = new SoftReference(viewFindViewById);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew;
        com.bytedance.sdk.component.adexpress.dynamic.EO.lEW lew2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.vCE = IlO(this.NV.get());
            this.IlO = motionEvent.getRawX();
            this.MY = motionEvent.getRawY();
            this.Bc = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.vCE;
            if (rectF != null && !rectF.contains(this.IlO, this.MY)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.IlO);
            float fAbs2 = Math.abs(rawY - this.MY);
            int iMY = com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), Math.abs(rawX - this.IlO));
            int i2 = EO;
            if (fAbs < i2 || fAbs2 < i2) {
                if ((System.currentTimeMillis() - this.Bc < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (lew = this.tV) != null) {
                    lew.IlO();
                }
            } else if (rawX > this.IlO && iMY > this.Cc && (lew2 = this.tV) != null) {
                lew2.IlO();
            }
        }
        return true;
    }

    private RectF IlO(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r2, view.getHeight() + iArr[1]);
    }
}
