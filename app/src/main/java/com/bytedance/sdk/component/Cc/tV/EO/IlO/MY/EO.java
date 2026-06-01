package com.bytedance.sdk.component.Cc.tV.EO.IlO.MY;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.Cc.cl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements cl {
    private final cl IlO;
    private final com.bytedance.sdk.component.Cc.tV.EO.IlO.IlO MY;

    public EO(cl clVar) {
        this(clVar, null);
    }

    public EO(cl clVar, com.bytedance.sdk.component.Cc.tV.EO.IlO.IlO ilO) {
        this.IlO = clVar;
        this.MY = ilO;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean MY(String str) {
        return this.IlO.MY(str);
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean IlO(String str, Bitmap bitmap) {
        return this.IlO.IlO(str, bitmap);
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public Bitmap IlO(String str) {
        return this.IlO.IlO(str);
    }
}
