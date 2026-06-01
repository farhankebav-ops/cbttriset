package com.bytedance.sdk.openadsdk.core.NV.Cc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.core.DmF;
import com.bytedance.adsdk.ugeno.core.bWL;
import com.bytedance.adsdk.ugeno.core.hp;
import com.bytedance.adsdk.ugeno.tV.vCE;
import com.bytedance.sdk.openadsdk.core.model.bWL;
import com.bytedance.sdk.openadsdk.core.model.dY;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends EO {
    private com.bytedance.sdk.openadsdk.core.widget.Cc OOq;
    private com.bytedance.adsdk.ugeno.MY.EO pP;
    private com.bytedance.adsdk.ugeno.MY.EO tl;
    private boolean wPn;

    public vCE(Context context, oeT oet, boolean z2, IlO ilO, ViewGroup viewGroup) {
        super(context, oet, z2, ilO, viewGroup);
        this.wPn = false;
    }

    private void DmF() {
        com.bytedance.adsdk.ugeno.MY.EO eo = this.pP;
        if (eo != null) {
            eo.EO(8);
        }
        com.bytedance.adsdk.ugeno.MY.EO eo2 = this.tl;
        if (eo2 != null) {
            eo2.EO(8);
        }
    }

    private void NV() {
        DmF dmF = new DmF();
        HashMap map = new HashMap();
        map.put("image_info", this.vCE.EV());
        map.put("cache_dir", this.vCE.bWL());
        dmF.IlO(map);
        dmF.IlO(this.MY);
        dmF.IlO(this.tV);
        dmF.MY(this.kBB);
        this.IlO.IlO("ad", dmF);
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO
    public com.bytedance.adsdk.ugeno.MY.EO Bc() {
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = this.EO;
        if (eo == null) {
            return null;
        }
        return eo.tV("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO
    public JSONObject IlO() {
        JSONObject jSONObjectEO = this.vCE.EO();
        if (jSONObjectEO != null) {
            return jSONObjectEO.optJSONObject("xTemplate");
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO
    public JSONObject MY() {
        return this.vCE.EO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO
    public com.bytedance.adsdk.ugeno.MY.EO lEW() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO, com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setTime(CharSequence charSequence, int i2, int i8, boolean z2) {
        if (this.EO == null) {
            return;
        }
        boolean z7 = i2 == 1;
        IlO(charSequence, z7, i8, z2);
        MY(charSequence, z7, i8, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO
    public int tV() {
        NV();
        this.IlO.IlO((hp) this);
        this.IlO.IlO((bWL) this);
        dY dYVarEa = this.Cc.Ea();
        try {
            if (dYVarEa != null) {
                this.EO = this.IlO.IlO(this.tV, this.kBB, dYVarEa.Cc());
            } else {
                this.EO = this.IlO.IlO(this.tV, this.kBB, (JSONObject) null);
            }
            if (this.EO != null) {
                if (TextUtils.equals(this.oeT, "rewarded_video")) {
                    this.pP = this.EO.tV("RVCountdown");
                    this.tl = this.EO.tV("RVSkipView");
                } else {
                    this.pP = this.EO.tV("FVCountdown");
                    this.tl = this.EO.tV("FVSkipView");
                }
                DmF();
            }
            this.vCE.dY().MY();
            this.vCE.dY().EO();
            return 0;
        } catch (NoClassDefFoundError unused) {
            return 140;
        } catch (UnsatisfiedLinkError unused2) {
            return 139;
        } catch (Throwable unused3) {
            return 141;
        }
    }

    private void MY(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        com.bytedance.adsdk.ugeno.MY.EO eo = this.tl;
        if (eo != null && (eo instanceof com.bytedance.sdk.openadsdk.core.NV.MY.vCE)) {
            int i8 = 0;
            if (!z2 && !z7) {
                i8 = 8;
            }
            eo.EO(i8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO
    public void IlO(com.bytedance.sdk.openadsdk.core.widget.Cc cc) {
        this.OOq = cc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO, com.bytedance.adsdk.ugeno.core.hp
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
        int i2;
        int i8;
        if (this.lEW == null || ilO == null) {
            return;
        }
        String strMY = ilO.MY();
        strMY.getClass();
        i2 = 7;
        i8 = -1;
        boolean z2 = true;
        switch (strMY) {
            case "sendLogExtra":
                new Bc().IlO("sendLogExtra", this.Cc, this.oeT, ilO.EO());
                return;
            case "sendAdExtra":
                new Bc().IlO("sendAdExtra", this.Cc, this.oeT, ilO.EO());
                return;
            case "openPrivacy":
                break;
            case "pauseVideo":
            case "videoControl":
                i2 = 4;
                break;
            case "skip":
                i2 = 6;
                break;
            case "convert":
                i2 = 2;
                break;
            case "muteVideo":
                i2 = 5;
                break;
            case "openLinks":
                new Cc().IlO(IlO(eo.EV()), this.MY instanceof Activity, this.Cc, this.oeT, ilO.EO(), this.OOq);
                return;
            case "speedVideoOrTimer":
                com.bytedance.sdk.component.utils.oeT.MY("UGenRender", "onUGenEvent: " + ilO.EO());
                i2 = 13;
                if (ilO.EO() != null && !ilO.EO().isEmpty()) {
                    try {
                        i8 = Integer.parseInt(ilO.EO().get("switch"));
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.EO("UGenRender", th);
                    }
                    break;
                }
                break;
            case "dislike":
                i2 = 3;
                break;
            default:
                i2 = 0;
                break;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.AXM;
        if (weakReference != null) {
            int[] iArrIlO = BS.IlO(weakReference.get());
            if (iArrIlO != null) {
                iArr = iArrIlO;
            }
            int[] iArrEO = BS.EO(this.AXM.get());
            if (iArrEO != null) {
                iArr2 = iArrEO;
            }
        }
        bWL.IlO IlO = new bWL.IlO().tV(this.hp).EO(this.bWL).MY(this.ea).IlO(this.zPa).MY(this.cl).IlO(this.cL).EO(i8).tV(iArr[0]).Cc(iArr[1]).vCE(iArr2[0]).Bc(iArr2[1]).IlO(this.vAh);
        if (str.equals("tap") && !this.es) {
            z2 = false;
        }
        this.lEW.IlO(eo.EV(), i2, IlO.IlO(z2).IlO(eo.lMM()).MY(false).IlO());
    }

    @Override // com.bytedance.sdk.openadsdk.core.NV.Cc.EO, com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setSoundMute(boolean z2) {
    }

    private void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        int i8;
        com.bytedance.adsdk.ugeno.MY.EO eo = this.pP;
        if (eo != null && (eo instanceof com.bytedance.sdk.openadsdk.core.NV.MY.MY)) {
            try {
                i8 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.oeT.EO("UGenRender", "parse duration exception", charSequence);
                i8 = 0;
            }
            if (!z7 && i8 > 0 && !this.wPn) {
                this.pP.EO(0);
                if (!z2 && this.vCE.IlO() && com.bytedance.sdk.component.adexpress.tV.vCE.MY(this.vCE.tV())) {
                    ((com.bytedance.sdk.openadsdk.core.NV.MY.MY) this.pP).Bc(String.valueOf(i2));
                    return;
                } else if (!"open_ad".equals(this.vCE.tV()) && this.vCE.IlO()) {
                    this.wPn = true;
                    this.pP.EO(8);
                    return;
                } else {
                    ((com.bytedance.sdk.openadsdk.core.NV.MY.MY) this.pP).Bc(String.valueOf(charSequence));
                    return;
                }
            }
            this.pP.EO(8);
        }
    }

    private Context IlO(View view) {
        Activity activityIlO = view != null ? com.bytedance.sdk.component.utils.MY.IlO(view) : null;
        return activityIlO == null ? this.MY : activityIlO;
    }
}
