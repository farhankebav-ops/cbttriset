package com.bytedance.adsdk.MY.EO;

import android.graphics.PointF;
import androidx.camera.core.processing.util.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public float Bc;
    public int Cc;
    public int DmF;
    public float EO;
    public boolean EV;
    public String IlO;
    public String MY;
    public float NV;
    public PointF hp;
    public int lEW;
    public PointF rp;
    public IlO tV;
    public float vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public MY(String str, String str2, float f4, IlO ilO, int i2, float f8, float f9, int i8, int i9, float f10, boolean z2, PointF pointF, PointF pointF2) {
        IlO(str, str2, f4, ilO, i2, f8, f9, i8, i9, f10, z2, pointF, pointF2);
    }

    public void IlO(String str, String str2, float f4, IlO ilO, int i2, float f8, float f9, int i8, int i9, float f10, boolean z2, PointF pointF, PointF pointF2) {
        this.IlO = str;
        this.MY = str2;
        this.EO = f4;
        this.tV = ilO;
        this.Cc = i2;
        this.vCE = f8;
        this.Bc = f9;
        this.lEW = i8;
        this.DmF = i9;
        this.NV = f10;
        this.EV = z2;
        this.rp = pointF;
        this.hp = pointF2;
    }

    public int hashCode() {
        int iOrdinal = ((this.tV.ordinal() + (((int) (a.b(this.IlO.hashCode() * 31, 31, this.MY) + this.EO)) * 31)) * 31) + this.Cc;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.vCE);
        return (((iOrdinal * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.lEW;
    }

    public MY() {
    }
}
