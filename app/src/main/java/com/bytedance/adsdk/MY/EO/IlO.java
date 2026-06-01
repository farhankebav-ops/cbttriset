package com.bytedance.adsdk.MY.EO;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private final PointF EO;
    private final PointF IlO;
    private final PointF MY;

    public IlO() {
        this.IlO = new PointF();
        this.MY = new PointF();
        this.EO = new PointF();
    }

    public void EO(float f4, float f8) {
        this.EO.set(f4, f8);
    }

    public void IlO(float f4, float f8) {
        this.IlO.set(f4, f8);
    }

    public void MY(float f4, float f8) {
        this.MY.set(f4, f8);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.EO.x), Float.valueOf(this.EO.y), Float.valueOf(this.IlO.x), Float.valueOf(this.IlO.y), Float.valueOf(this.MY.x), Float.valueOf(this.MY.y));
    }

    public PointF EO() {
        return this.EO;
    }

    public PointF IlO() {
        return this.IlO;
    }

    public PointF MY() {
        return this.MY;
    }

    public IlO(PointF pointF, PointF pointF2, PointF pointF3) {
        this.IlO = pointF;
        this.MY = pointF2;
        this.EO = pointF3;
    }
}
