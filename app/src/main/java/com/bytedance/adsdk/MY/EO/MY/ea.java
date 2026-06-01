package com.bytedance.adsdk.MY.EO.MY;

import a1.a;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea implements EO {
    private final com.bytedance.adsdk.MY.EO.IlO.tV Cc;
    private final String EO;
    private final boolean IlO;
    private final Path.FillType MY;
    private final com.bytedance.adsdk.MY.EO.IlO.IlO tV;
    private final boolean vCE;

    public ea(String str, boolean z2, Path.FillType fillType, com.bytedance.adsdk.MY.EO.IlO.IlO ilO, com.bytedance.adsdk.MY.EO.IlO.tV tVVar, boolean z7) {
        this.EO = str;
        this.IlO = z2;
        this.MY = fillType;
        this.tV = ilO;
        this.Cc = tVVar;
        this.vCE = z7;
    }

    public boolean Cc() {
        return this.vCE;
    }

    public com.bytedance.adsdk.MY.EO.IlO.tV EO() {
        return this.Cc;
    }

    public String IlO() {
        return this.EO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.IlO MY() {
        return this.tV;
    }

    public Path.FillType tV() {
        return this.MY;
    }

    public String toString() {
        return a.t(new StringBuilder("ShapeFill{color=, fillEnabled="), this.IlO, '}');
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.Bc(dmF, ilO, this);
    }
}
