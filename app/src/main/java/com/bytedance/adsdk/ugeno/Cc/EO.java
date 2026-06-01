package com.bytedance.adsdk.ugeno.Cc;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    int Bc;
    int Cc;
    int DmF;
    float EV;
    float NV;
    boolean cL;
    boolean cl;
    int ea;
    int hp;
    int lEW;
    int rp;
    int vCE;
    int zPa;
    int IlO = Integer.MAX_VALUE;
    int MY = Integer.MAX_VALUE;
    int EO = Integer.MIN_VALUE;
    int tV = Integer.MIN_VALUE;
    List<Integer> bWL = new ArrayList();

    public int IlO() {
        return this.Bc;
    }

    public int MY() {
        return this.lEW - this.DmF;
    }

    public void IlO(View view, int i2, int i8, int i9, int i10) {
        MY my = (MY) view.getLayoutParams();
        this.IlO = Math.min(this.IlO, (view.getLeft() - my.hp()) - i2);
        this.MY = Math.min(this.MY, (view.getTop() - my.bWL()) - i8);
        this.EO = Math.max(this.EO, my.ea() + view.getRight() + i9);
        this.tV = Math.max(this.tV, my.zPa() + view.getBottom() + i10);
    }
}
