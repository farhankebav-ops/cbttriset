package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends IlO {
    private float EV;
    private String bWL;
    private int hp;
    private float rp;

    public EO(Context context) {
        super(context);
        this.hp = 0;
        this.bWL = "up";
    }

    @Override // com.bytedance.adsdk.ugeno.tV.tV.IlO
    public boolean IlO(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        Map<String, String> map = this.Cc;
        if (map != null) {
            this.bWL = TextUtils.isEmpty(map.get("direction")) ? "all" : this.Cc.get("direction");
            this.hp = com.bytedance.adsdk.ugeno.Bc.EO.IlO(this.Cc.get("distance"), 0);
        }
        return IlO(this.MY, (MotionEvent) objArr[0]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean IlO(com.bytedance.adsdk.ugeno.MY.EO r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            int r0 = r10.getAction()
            r1 = 1
            if (r0 == 0) goto La5
            if (r0 == r1) goto Le
            r2 = 3
            if (r0 == r2) goto Le
            goto Lb1
        Le:
            float r0 = r10.getX()
            float r10 = r10.getY()
            int r2 = r8.hp
            if (r2 != 0) goto L2a
            com.bytedance.adsdk.ugeno.tV.EV r2 = r8.IlO
            if (r2 == 0) goto L2a
            java.lang.String r10 = r8.vCE
            com.bytedance.adsdk.ugeno.tV.vCE r0 = r8.EO
            java.util.List r0 = r0.MY()
            r2.IlO(r9, r10, r0)
            return r1
        L2a:
            android.content.Context r2 = r8.NV
            float r3 = r8.EV
            float r0 = r0 - r3
            int r0 = com.bytedance.adsdk.ugeno.Bc.lEW.MY(r2, r0)
            android.content.Context r2 = r8.NV
            float r3 = r8.rp
            float r10 = r10 - r3
            int r10 = com.bytedance.adsdk.ugeno.Bc.lEW.MY(r2, r10)
            java.lang.String r2 = r8.bWL
            int r3 = r2.hashCode()
            switch(r3) {
                case 3739: goto L6a;
                case 96673: goto L63;
                case 3089570: goto L59;
                case 3317767: goto L4f;
                case 108511772: goto L46;
                default: goto L45;
            }
        L45:
            goto L74
        L46:
            java.lang.String r3 = "right"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L74
            goto L8a
        L4f:
            java.lang.String r3 = "left"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L74
            int r0 = -r0
            goto L8a
        L59:
            java.lang.String r3 = "down"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L74
            r0 = r10
            goto L8a
        L63:
            java.lang.String r3 = "all"
            boolean r2 = r2.equals(r3)
            goto L74
        L6a:
            java.lang.String r3 = "up"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L74
            int r0 = -r10
            goto L8a
        L74:
            double r2 = (double) r0
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = java.lang.Math.pow(r2, r4)
            double r6 = (double) r10
            double r4 = java.lang.Math.pow(r6, r4)
            double r4 = r4 + r2
            double r2 = java.lang.Math.sqrt(r4)
            double r2 = java.lang.Math.abs(r2)
            int r0 = (int) r2
        L8a:
            int r10 = r8.hp
            if (r0 < r10) goto La3
            com.bytedance.adsdk.ugeno.tV.EV r10 = r8.IlO
            if (r10 == 0) goto Lb1
            r0 = 0
            r8.EV = r0
            r8.rp = r0
            java.lang.String r0 = r8.vCE
            com.bytedance.adsdk.ugeno.tV.vCE r2 = r8.EO
            java.util.List r2 = r2.MY()
            r10.IlO(r9, r0, r2)
            return r1
        La3:
            r9 = 0
            return r9
        La5:
            float r9 = r10.getX()
            r8.EV = r9
            float r9 = r10.getY()
            r8.rp = r9
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.tV.tV.EO.IlO(com.bytedance.adsdk.ugeno.MY.EO, android.view.MotionEvent):boolean");
    }
}
