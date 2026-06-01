package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.webkit.DownloadListener;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    public static int EO = 2;
    public static int IlO = 0;
    public static int MY = 1;

    @Nullable
    private NV Cc;
    private final boolean tV;

    @Nullable
    private DmF vCE;

    public lEW(IlO ilO, oeT oet) {
        boolean zNt = oet.nt();
        this.tV = zNt;
        if (zNt) {
            this.Cc = OOq.vCE(oet) ? new Bc(ilO) : new NV(ilO);
        } else {
            this.vCE = new DmF(ilO);
        }
    }

    public boolean Bc() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            return dmF.ea();
        }
        return false;
    }

    public void Cc() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.vCE();
        }
    }

    public long DmF() {
        if (this.vCE != null) {
            return r0.DmF();
        }
        return 0L;
    }

    public boolean EO() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            return dmF.zPa();
        }
        return true;
    }

    public com.bytedance.sdk.openadsdk.rp.Cc EV() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            return dmF.bWL();
        }
        return null;
    }

    public boolean IlO() {
        DmF dmF = this.vCE;
        return dmF != null && dmF.cl();
    }

    public float MY() {
        if (this.vCE != null) {
            return r0.NV();
        }
        return 0.0f;
    }

    public void NV() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.Cc();
        }
    }

    public void bWL() {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.lEW();
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.hp();
        }
    }

    public void cL() {
        NV nv = this.Cc;
        if (nv != null) {
            nv.EO();
        }
    }

    public void cl() {
        NV nv = this.Cc;
        if (nv != null) {
            nv.EV();
        }
    }

    public void ea() {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.IlO();
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO();
        }
    }

    public void hp() {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.tV();
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.EV();
        }
    }

    public void lEW() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.MY();
        }
    }

    public void rp() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.tV();
        }
    }

    public com.bytedance.sdk.openadsdk.xF.lEW tV() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            return dmF.cL();
        }
        return null;
    }

    public void vCE() {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.Bc();
        }
    }

    public void zPa() {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.Cc();
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.rp();
        }
    }

    public void IlO(int i2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(i2);
        }
    }

    public void Bc(int i2) {
        NV nv;
        if (this.tV && i2 != EO && (nv = this.Cc) != null) {
            nv.vCE();
            return;
        }
        DmF dmF = this.vCE;
        if (dmF == null || i2 == MY) {
            return;
        }
        dmF.EO();
    }

    public void Cc(boolean z2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.Cc(z2);
        }
    }

    public void EO(int i2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.MY(i2);
        }
    }

    public int MY(int i2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            return dmF.EO(i2);
        }
        return 0;
    }

    public boolean lEW(int i2) {
        if (this.tV && i2 == MY) {
            NV nv = this.Cc;
            if (nv != null) {
                return nv.NV();
            }
            return false;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            return dmF.lEW();
        }
        return false;
    }

    public void tV(boolean z2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.tV(z2);
        }
    }

    public void vCE(int i2) {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.IlO(i2);
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.Cc(i2);
        }
    }

    public void IlO(boolean z2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.MY(z2);
        }
    }

    public void Cc(int i2) {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.IlO(i2);
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(i2);
        }
    }

    public void EO(boolean z2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(z2);
        }
    }

    public void MY(boolean z2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.vCE(z2);
        }
    }

    public boolean tV(int i2) {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                return nv.DmF();
            }
        } else {
            DmF dmF = this.vCE;
            if (dmF != null && dmF.DmF() - this.vCE.NV() >= i2) {
                return true;
            }
        }
        return false;
    }

    public void IlO(JSONObject jSONObject) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(jSONObject);
        }
    }

    public void EO(String str) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(str);
        }
    }

    public void MY(String str) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.MY(str);
        }
    }

    public void IlO(int i2, oeT oet, boolean z2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(i2, oet, z2);
        }
    }

    public void vCE(boolean z2) {
        NV nv = this.Cc;
        if (nv != null) {
            nv.EO(z2);
        }
    }

    public void IlO(DownloadListener downloadListener) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(downloadListener);
        }
    }

    public void IlO(String str) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.EO(str);
        }
    }

    public void IlO(int i2, String str, String str2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(i2, str, str2);
        }
    }

    public void IlO(boolean z2, String str, int i2) {
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(z2, str, i2);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.Cc cc) {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.IlO(cc);
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(cc);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.rp.vCE vce, boolean z2) {
        if (this.tV) {
            NV nv = this.Cc;
            if (nv != null) {
                nv.MY(z2);
                return;
            }
            return;
        }
        DmF dmF = this.vCE;
        if (dmF != null) {
            dmF.IlO(vce, z2);
        }
    }
}
