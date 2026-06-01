package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class kBB {
    public static ConcurrentHashMap<Integer, kBB> IlO = new ConcurrentHashMap<>();
    private int Cc;
    private int tV;
    private String vCE;
    private String MY = "";
    private String EO = "";

    private void vCE() {
        this.MY = "";
        this.EO = "";
        this.tV = 0;
        this.Cc = 0;
    }

    public int Cc() {
        return this.Cc;
    }

    public String EO() {
        return this.EO;
    }

    public String IlO() {
        return this.vCE;
    }

    public String MY() {
        return this.MY;
    }

    public int tV() {
        return this.tV;
    }

    public static void EO(int i2) {
        kBB kbb;
        if (i2 == 0) {
            return;
        }
        if (IlO == null) {
            IlO = new ConcurrentHashMap<>();
        }
        if (!IlO.containsKey(Integer.valueOf(i2)) || (kbb = IlO.get(Integer.valueOf(i2))) == null) {
            return;
        }
        kbb.MY(1);
    }

    public void IlO(int i2) {
        this.tV = i2;
    }

    public void MY(int i2) {
        this.Cc = i2;
    }

    public static void MY(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet == null || TextUtils.isEmpty(oet.KT())) {
            return;
        }
        int iHFV = oet.hFV();
        Integer numValueOf = Integer.valueOf(iHFV);
        if (iHFV == 0) {
            return;
        }
        if (IlO == null) {
            IlO = new ConcurrentHashMap<>();
        }
        kBB kbb = IlO.containsKey(numValueOf) ? IlO.get(numValueOf) : null;
        if (kbb == null) {
            kbb = new kBB();
        }
        String strJAC = oet.JAC();
        if (TextUtils.isEmpty(strJAC) || !strJAC.equals(kbb.IlO())) {
            kbb.vCE();
            kbb.IlO(oet);
            IlO.put(numValueOf, kbb);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet != null) {
            String strJAC = oet.JAC();
            if (!TextUtils.isEmpty(strJAC)) {
                this.vCE = strJAC;
            }
            String strPFe = oet.pFe();
            if (TextUtils.isEmpty(strPFe) && oet.xJ()) {
                strPFe = oet.QfH().DmF();
            }
            if (!TextUtils.isEmpty(strPFe)) {
                String[] strArrSplit = strPFe.split("/");
                if (strArrSplit.length >= 3) {
                    this.MY = strArrSplit[2];
                }
            }
            if (oet.VH() == null || TextUtils.isEmpty(oet.VH().EO())) {
                return;
            }
            this.EO = oet.VH().EO();
        }
    }

    public static void EO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        kBB kbb;
        if (oet == null) {
            return;
        }
        int iHFV = oet.hFV();
        Integer numValueOf = Integer.valueOf(iHFV);
        if (iHFV == 0) {
            return;
        }
        if (IlO == null) {
            IlO = new ConcurrentHashMap<>();
        }
        if (!IlO.containsKey(numValueOf) || (kbb = IlO.get(numValueOf)) == null) {
            return;
        }
        kbb.IlO(1);
    }
}
