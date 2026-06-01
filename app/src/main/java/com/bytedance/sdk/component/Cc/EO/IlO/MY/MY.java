package com.bytedance.sdk.component.Cc.EO.IlO.MY;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.Cc.cl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements cl {
    private com.bytedance.sdk.component.Cc.EO.IlO.EO<String, Bitmap> EO;
    private int IlO;
    private int MY;

    public MY(int i2, int i8) {
        this.MY = i2;
        this.IlO = i8;
        this.EO = new com.bytedance.sdk.component.Cc.EO.IlO.EO<String, Bitmap>(i2) { // from class: com.bytedance.sdk.component.Cc.EO.IlO.MY.MY.1
            @Override // com.bytedance.sdk.component.Cc.EO.IlO.EO
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public int MY(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return MY.IlO(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean MY(String str) {
        return this.EO.IlO(str) != null;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public boolean IlO(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.EO.IlO(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.Cc.IlO
    public Bitmap IlO(String str) {
        return this.EO.IlO(str);
    }

    public static int IlO(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
