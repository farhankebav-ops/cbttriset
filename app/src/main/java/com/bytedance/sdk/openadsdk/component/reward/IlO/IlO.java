package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.DmF;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public final boolean AK;
    public boolean BO;

    @NonNull
    public final Activity BS;
    public final boolean Bc;
    public final String Cc;
    public final com.bytedance.sdk.openadsdk.component.reward.view.NV DM;
    public boolean Dxv;

    @Nullable
    public com.bytedance.sdk.openadsdk.activity.vCE ED;
    public final boolean EO;
    public int Ea;
    public final vSq HSR;
    public boolean HTA;
    public boolean Hg;
    public final int IlO;
    public int Jz;
    public final oeT MY;
    public final rp OOq;
    public com.bytedance.sdk.openadsdk.component.reward.EV PTq;
    private long VH;

    @NonNull
    public final bWL YA;
    public com.bytedance.sdk.openadsdk.component.reward.top.EO aa;
    public com.bytedance.sdk.openadsdk.rp.NV dY;
    public boolean dm;
    public final Context gQ;
    public boolean gm;
    public float hL;
    public boolean ii;
    public final tV kBB;
    public final es lMM;
    public final Cc mmj;
    public boolean nm;
    public final ea nvX;
    public final vCE oc;
    public com.bytedance.sdk.openadsdk.common.hp pFe;
    public final lEW pP;
    public String quf;
    public boolean qvT;
    public com.bytedance.sdk.openadsdk.component.reward.MY.MY qz;
    public final com.bytedance.sdk.openadsdk.core.rp.tV.MY ssS;
    public final boolean tV;
    public final com.bytedance.sdk.openadsdk.component.reward.view.lEW tl;
    public com.bytedance.sdk.openadsdk.utils.bWL ts;
    public boolean uvo;

    @NonNull
    public final cl vAh;
    public final int vCE;
    public final EO vSq;
    public int wD;
    public final EV wPn;
    public final com.bytedance.sdk.openadsdk.component.reward.view.Bc zLG;
    private long zTS;
    public int lEW = 0;
    public int DmF = 0;
    public final AtomicBoolean NV = new AtomicBoolean(false);
    public final AtomicBoolean EV = new AtomicBoolean(false);
    public final AtomicBoolean rp = new AtomicBoolean(false);
    public final AtomicBoolean hp = new AtomicBoolean(false);
    public final AtomicBoolean bWL = new AtomicBoolean(false);
    public final AtomicBoolean ea = new AtomicBoolean(false);
    public final AtomicBoolean zPa = new AtomicBoolean(false);
    public final AtomicBoolean cl = new AtomicBoolean(false);
    public final AtomicBoolean cL = new AtomicBoolean(false);
    public final AtomicBoolean es = new AtomicBoolean(false);
    public final AtomicBoolean xF = new AtomicBoolean(false);
    public final AtomicBoolean AXM = new AtomicBoolean(false);
    public final AtomicBoolean oeT = new AtomicBoolean(false);
    public boolean KC = false;
    public int fdM = 1;
    public long Tx = 0;

    public IlO(@NonNull Activity activity, vSq vsq, @NonNull oeT oet, com.bytedance.sdk.openadsdk.core.rp.tV.MY my, int i2) {
        this.BS = activity;
        this.ssS = my;
        Context contextIlO = com.bytedance.sdk.openadsdk.core.cl.IlO();
        this.gQ = contextIlO;
        this.MY = oet;
        this.IlO = i2;
        this.AK = i2 == 0 || i2 == 2;
        this.qvT = i2 == 0 || i2 == 1;
        this.HSR = vsq;
        boolean z2 = oet.ssS().getDurationSlotType() == 7;
        this.tV = z2;
        this.Cc = z2 ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.Hg = oet.vCE();
        this.Bc = com.bytedance.sdk.openadsdk.core.model.es.NV(oet);
        int iHFV = oet.hFV();
        this.vCE = iHFV;
        this.uvo = com.bytedance.sdk.openadsdk.core.cl.tV().zPa(String.valueOf(iHFV));
        this.EO = com.bytedance.sdk.openadsdk.core.settings.hp.aP().hp(String.valueOf(iHFV));
        this.OOq = i2 == 2 ? new hp(this) : new rp(this);
        this.DM = i2 == 2 ? new com.bytedance.sdk.openadsdk.component.reward.view.EV(this) : oet.vCE() ? new com.bytedance.sdk.openadsdk.component.reward.view.NV(this) : new com.bytedance.sdk.openadsdk.component.reward.view.DmF(this);
        this.zLG = new com.bytedance.sdk.openadsdk.component.reward.view.Bc(this);
        this.vAh = new cl(this);
        this.kBB = new tV(this);
        this.pP = new lEW(this, oet);
        this.tl = new com.bytedance.sdk.openadsdk.component.reward.view.lEW(this);
        this.lMM = new es(this);
        this.nvX = new ea(this);
        this.YA = new bWL(this);
        this.mmj = new Cc(this);
        this.wPn = new EV(this);
        this.oc = new vCE(this);
        this.vSq = new EO(this);
        this.dY = new com.bytedance.sdk.openadsdk.rp.NV(contextIlO);
        this.ts = com.bytedance.sdk.openadsdk.utils.DmF.IlO(activity, new DmF.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.IlO.1
            @Override // com.bytedance.sdk.openadsdk.utils.DmF.IlO
            public View IlO() {
                com.bytedance.sdk.openadsdk.component.reward.view.NV nv = IlO.this.DM;
                if (nv != null) {
                    return nv.NV();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.utils.DmF.IlO
            public void MY() {
                bWL bwl = IlO.this.YA;
                if (bwl != null) {
                    bwl.Cc();
                }
            }
        });
    }

    public long EO() {
        return (SystemClock.elapsedRealtime() - this.VH) + this.zTS;
    }

    public void IlO(boolean z2) {
        this.ii = z2;
        this.YA.tV(z2);
    }

    public void MY() {
        if (this.VH <= 0) {
            this.VH = SystemClock.elapsedRealtime();
        }
        this.zTS = (SystemClock.elapsedRealtime() - this.VH) + this.zTS;
    }

    public boolean tV() {
        if (this.BO) {
            return this.gm || this.dm;
        }
        return false;
    }

    public void IlO() {
        this.VH = SystemClock.elapsedRealtime();
    }
}
