package com.bytedance.sdk.openadsdk.vCE;

import com.bytedance.sdk.openadsdk.core.EO;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.ironsource.C2300e4;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static volatile IlO IlO;
    private int[] Bc;
    private int[] Cc;
    private int[] DmF;
    private boolean EO;
    private boolean EV;
    private boolean MY;
    private boolean NV;
    private boolean bWL;
    private boolean cl;
    private int ea;
    private boolean hp;
    private int[] lEW;
    private int[] rp;
    private boolean tV;
    private int[] vCE;
    private boolean zPa;

    private IlO() {
        MY();
    }

    public int[] EV() {
        return this.Bc;
    }

    public int[] NV() {
        return this.vCE;
    }

    public boolean bWL() {
        return this.NV;
    }

    public boolean cL() {
        return this.cl;
    }

    public boolean cl() {
        return this.hp;
    }

    public boolean ea() {
        return this.EV;
    }

    public int[] hp() {
        return this.DmF;
    }

    public int[] rp() {
        return this.lEW;
    }

    public int[] zPa() {
        return this.rp;
    }

    public boolean Bc() {
        return this.EO;
    }

    public int[] DmF() {
        return this.Cc;
    }

    public boolean lEW() {
        return this.tV;
    }

    public boolean Cc() {
        return this.zPa;
    }

    public int tV() {
        return this.ea;
    }

    public boolean vCE() {
        return this.MY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] EO(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        int i2 = 0;
        for (String str : strArr) {
            try {
                int i8 = Integer.parseInt(str);
                iArr[i2] = i8;
                if (i8 > 0) {
                    i2++;
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i2 == length) {
            return iArr;
        }
        int[] iArr2 = new int[i2];
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        return iArr2;
    }

    public void MY() {
        bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.vCE.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                IlO.this.bWL = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("feature_switch", false);
                if (IlO.this.bWL) {
                    try {
                        IlO.this.cl = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("exclude_banner_native", false);
                        IlO.this.ea = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("feature_timer_interval", 10000);
                        IlO.this.zPa = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("enable_feature_cids", true);
                        String[] strArrSplit = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pag_ad_show_cnt", "1,3,5&session").split(C2300e4.i.f8401c);
                        String[] strArrSplit2 = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pag_ad_click_cnt", "1,3,5&session").split(C2300e4.i.f8401c);
                        String[] strArrSplit3 = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pag_video_play_cnt", "1,3,5&session").split(C2300e4.i.f8401c);
                        String[] strArrSplit4 = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pag_dislike_cnt", "1,3,5session").split(",");
                        IlO ilO = IlO.this;
                        ilO.MY = ilO.IlO(strArrSplit);
                        IlO ilO2 = IlO.this;
                        ilO2.EO = ilO2.IlO(strArrSplit2);
                        IlO ilO3 = IlO.this;
                        ilO3.tV = ilO3.IlO(strArrSplit3);
                        IlO ilO4 = IlO.this;
                        ilO4.Cc = ilO4.MY(strArrSplit);
                        IlO ilO5 = IlO.this;
                        ilO5.vCE = ilO5.MY(strArrSplit2);
                        IlO ilO6 = IlO.this;
                        ilO6.Bc = ilO6.MY(strArrSplit3);
                        IlO ilO7 = IlO.this;
                        ilO7.rp = ilO7.EO(strArrSplit4);
                        String[] strArrSplit5 = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pag_landingPage_stay_time", "1,3,5&session").split(C2300e4.i.f8401c);
                        String[] strArrSplit6 = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pag_video_stay_time", "1,3,5&session").split(C2300e4.i.f8401c);
                        IlO ilO8 = IlO.this;
                        ilO8.NV = ilO8.IlO(strArrSplit5);
                        IlO ilO9 = IlO.this;
                        ilO9.EV = ilO9.IlO(strArrSplit6);
                        IlO ilO10 = IlO.this;
                        ilO10.lEW = ilO10.MY(strArrSplit5);
                        IlO ilO11 = IlO.this;
                        ilO11.DmF = ilO11.MY(strArrSplit6);
                        IlO.this.hp = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("pag_video_30p_session", true);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] MY(String[] strArr) {
        if (strArr.length > 0) {
            return EO(strArr[0].split(","));
        }
        return new int[0];
    }

    public static IlO IlO() {
        if (IlO == null) {
            synchronized (EO.class) {
                try {
                    if (IlO == null) {
                        IlO = new IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public boolean EO() {
        return this.bWL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(String[] strArr) {
        if (strArr.length == 2) {
            return OutcomeEventsTable.COLUMN_NAME_SESSION.equals(strArr[1]);
        }
        if (strArr.length == 1) {
            return OutcomeEventsTable.COLUMN_NAME_SESSION.equals(strArr[0]);
        }
        return false;
    }
}
