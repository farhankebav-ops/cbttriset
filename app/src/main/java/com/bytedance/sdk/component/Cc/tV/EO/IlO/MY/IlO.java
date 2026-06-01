package com.bytedance.sdk.component.Cc.tV.EO.IlO.MY;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.Cc.cl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements cl {
    private int EO;
    private long IlO = 4194304;
    private int MY;
    private com.bytedance.sdk.component.Cc.tV.EO.IlO.EO<String, Bitmap> tV;

    public IlO(int i2, int i8) {
        this.MY = i8;
        this.EO = i2;
        this.tV = new com.bytedance.sdk.component.Cc.tV.EO.IlO.EO<>(i8);
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean MY(String str) {
        return this.tV.IlO(str) != null;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean IlO(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            try {
                int iIlO = IlO(bitmap);
                if (iIlO <= this.IlO && iIlO != 0) {
                    this.tV.IlO(str, bitmap);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public Bitmap IlO(String str) {
        try {
            return this.tV.IlO(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int IlO(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
