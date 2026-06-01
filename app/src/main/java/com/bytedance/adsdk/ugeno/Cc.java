package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.tV.NV;
import com.bytedance.adsdk.ugeno.tV.lEW;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static volatile Cc IlO;
    private com.bytedance.adsdk.ugeno.core.IlO.IlO Bc;
    private com.bytedance.adsdk.ugeno.EO.IlO Cc;
    private com.bytedance.adsdk.ugeno.core.EO EO;
    private List<com.bytedance.adsdk.ugeno.core.MY> MY;
    private IlO tV;
    private com.bytedance.adsdk.ugeno.core.MY.tV vCE;

    private Cc() {
    }

    public static Cc IlO() {
        if (IlO == null) {
            synchronized (Cc.class) {
                try {
                    if (IlO == null) {
                        IlO = new Cc();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    private void vCE() {
        ArrayList arrayList = new ArrayList();
        this.MY = arrayList;
        com.bytedance.adsdk.ugeno.core.EO eo = this.EO;
        if (eo != null) {
            arrayList.addAll(eo.IlO());
        }
        com.bytedance.adsdk.ugeno.core.tV.IlO(this.MY);
    }

    public com.bytedance.adsdk.ugeno.core.IlO.IlO Cc() {
        return this.Bc;
    }

    public com.bytedance.adsdk.ugeno.EO.IlO EO() {
        return this.Cc;
    }

    public IlO MY() {
        return this.tV;
    }

    public com.bytedance.adsdk.ugeno.core.MY.tV tV() {
        return this.vCE;
    }

    public void IlO(Context context, com.bytedance.adsdk.ugeno.core.EO eo, IlO ilO) {
        this.EO = eo;
        this.tV = ilO;
        vCE();
    }

    public void IlO(com.bytedance.adsdk.ugeno.EO.IlO ilO) {
        this.Cc = ilO;
    }

    public void IlO(lEW lew) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.tV.IlO().IlO());
        if (lew != null) {
            arrayList.addAll(lew.IlO());
        }
        NV.IlO(arrayList);
    }

    public void IlO(com.bytedance.adsdk.ugeno.tV.EO eo) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.tV.Cc().IlO());
        if (eo != null) {
            arrayList.addAll(eo.IlO());
        }
        com.bytedance.adsdk.ugeno.tV.tV.IlO(arrayList);
    }
}
