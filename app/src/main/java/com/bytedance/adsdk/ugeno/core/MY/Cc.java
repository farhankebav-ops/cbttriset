package com.bytedance.adsdk.ugeno.core.MY;

import android.content.Context;
import com.bytedance.adsdk.ugeno.core.EV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends IlO {
    private String Bc;
    private EV Cc;
    private boolean DmF;
    private Context lEW;
    private EV vCE;
    private float MY = Float.MIN_VALUE;
    private float EO = Float.MIN_VALUE;
    private int tV = 0;

    public Cc(Context context, EV ev, boolean z2) {
        this.lEW = context;
        this.Cc = ev;
        this.DmF = z2;
        MY();
    }

    private void MY() {
        EV ev = this.Cc;
        if (ev == null) {
            return;
        }
        this.tV = ev.EO().optInt("slideThreshold");
        this.Bc = this.Cc.EO().optString("slideDirection");
    }

    public void IlO() {
        this.MY = Float.MIN_VALUE;
        this.EO = Float.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean IlO(com.bytedance.adsdk.ugeno.core.hp r11, com.bytedance.adsdk.ugeno.MY.EO r12, android.view.MotionEvent r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.core.MY.Cc.IlO(com.bytedance.adsdk.ugeno.core.hp, com.bytedance.adsdk.ugeno.MY.EO, android.view.MotionEvent, boolean):boolean");
    }

    public Cc(Context context, EV ev, EV ev2, boolean z2) {
        this.lEW = context;
        this.Cc = ev;
        this.vCE = ev2;
        this.DmF = z2;
        MY();
    }
}
