package com.bytedance.sdk.openadsdk.cL.IlO;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.component.utils.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private Bitmap Cc;
    private byte[] EO;
    int IlO;
    private Drawable MY;
    private Bitmap tV;

    public EO(Drawable drawable, int i2) {
        this.EO = null;
        this.tV = null;
        this.Cc = null;
        this.MY = drawable;
        this.IlO = i2;
    }

    public boolean Cc() {
        if (this.tV != null || this.MY != null) {
            return true;
        }
        byte[] bArr = this.EO;
        return bArr != null && bArr.length > 0;
    }

    public byte[] EO() {
        try {
            if (this.EO == null) {
                this.EO = com.bytedance.sdk.component.utils.tV.IlO(this.tV);
            }
        } catch (OutOfMemoryError e) {
            oeT.EO("GifRequestResult", e.getMessage());
        }
        return this.EO;
    }

    public Bitmap IlO() {
        return this.tV;
    }

    public Bitmap MY() {
        return this.Cc;
    }

    public Drawable tV() {
        return this.MY;
    }

    public EO(byte[] bArr, int i2) {
        this.MY = null;
        this.tV = null;
        this.Cc = null;
        this.EO = bArr;
        this.IlO = i2;
    }

    public EO(Bitmap bitmap, Bitmap bitmap2, int i2) {
        this.MY = null;
        this.EO = null;
        this.Cc = bitmap2;
        this.tV = bitmap;
        this.IlO = i2;
    }
}
