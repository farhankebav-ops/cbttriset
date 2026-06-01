package com.bytedance.adsdk.ugeno.core.MY;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.core.hp;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends IlO {
    private Context Bc;
    private float Cc;
    private final int DmF;
    private float EO;
    private float MY;
    private boolean lEW;
    private float tV;
    private EV vCE;

    public EO(Context context, EV ev) {
        this.Bc = context;
        this.vCE = ev;
        this.DmF = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean IlO(hp hpVar, com.bytedance.adsdk.ugeno.MY.EO eo, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.MY = motionEvent.getX();
            this.EO = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x2 - this.MY) >= this.DmF || Math.abs(y - this.EO) >= this.DmF) {
                    this.lEW = true;
                }
            } else if (action == 3) {
                this.lEW = false;
            }
        } else {
            if (this.lEW) {
                this.lEW = false;
                return false;
            }
            float x7 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x7 - this.MY) >= this.DmF || Math.abs(y2 - this.EO) >= this.DmF) {
                this.lEW = false;
            } else if (hpVar != null) {
                hpVar.IlO(this.vCE, eo, eo);
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean IlO(com.bytedance.adsdk.ugeno.core.hp r7, com.bytedance.adsdk.ugeno.MY.EO r8, android.view.MotionEvent r9, boolean r10) {
        /*
            r6 = this;
            boolean r0 = r6.IlO(r9)
            r1 = 0
            java.lang.String r2 = "GesThrough_OnlyTapEvent"
            if (r0 == 0) goto Lf
            java.lang.String r7 = "mockEvent，skip"
            android.util.Log.d(r2, r7)
            return r1
        Lf:
            if (r10 == 0) goto L14
            r6.IlO(r8, r9)
        L14:
            int r0 = r9.getAction()
            r3 = 1
            if (r0 == 0) goto L6c
            if (r0 == r3) goto L26
            r4 = 3
            if (r0 == r4) goto L21
            goto L78
        L21:
            java.lang.String r0 = "Sequence CANCEL, processed as UP event"
            android.util.Log.d(r2, r0)
        L26:
            float r0 = r9.getX()
            r6.tV = r0
            float r9 = r9.getY()
            r6.Cc = r9
            float r9 = r6.tV
            float r0 = r6.MY
            float r9 = r9 - r0
            float r9 = java.lang.Math.abs(r9)
            float r0 = r6.Cc
            float r4 = r6.EO
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r9 = r9 * r9
            float r0 = r0 * r0
            float r0 = r0 + r9
            double r4 = (double) r0
            double r4 = java.lang.Math.sqrt(r4)
            float r9 = (float) r4
            int r0 = r6.DmF
            float r0 = (float) r0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 > 0) goto L61
            java.lang.String r9 = "Click event, direct handling"
            android.util.Log.d(r2, r9)
            if (r7 == 0) goto L78
            com.bytedance.adsdk.ugeno.core.EV r9 = r6.vCE
            r7.IlO(r9, r8, r8)
            return r3
        L61:
            if (r10 == 0) goto L6b
            java.lang.String r7 = "Non-click event, need gesture through"
            android.util.Log.d(r2, r7)
            r6.IlO(r8)
        L6b:
            return r1
        L6c:
            float r7 = r9.getX()
            r6.MY = r7
            float r7 = r9.getY()
            r6.EO = r7
        L78:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.core.MY.EO.IlO(com.bytedance.adsdk.ugeno.core.hp, com.bytedance.adsdk.ugeno.MY.EO, android.view.MotionEvent, boolean):boolean");
    }
}
