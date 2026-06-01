package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.rp.MY.vCE;
import com.bytedance.sdk.openadsdk.core.tl;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO extends com.bytedance.sdk.openadsdk.core.Cc.EO {
    protected int Bc;
    protected TTDislikeDialogAbstract Cc;
    protected int DmF;
    protected com.bytedance.sdk.openadsdk.core.model.oeT EO;
    protected boolean EV;
    private com.bytedance.sdk.openadsdk.tV.Bc IlO;
    protected Context MY;
    protected boolean NV;
    protected int lEW;
    protected String rp;
    protected com.bytedance.sdk.openadsdk.EO.EO tV;
    protected String vCE;

    public IlO(@NonNull Context context) {
        super(context);
        this.vCE = "embeded_ad";
        this.NV = true;
        this.EV = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    public void IlO() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.Cc;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.EO.EO eo = this.tV;
        if (eo != null) {
            eo.IlO();
        } else {
            TTDelegateActivity.IlO(this.EO, (String) null);
        }
    }

    public abstract void IlO(View view, int i2, com.bytedance.sdk.openadsdk.core.model.bWL bwl);

    public String getDescription() {
        return !TextUtils.isEmpty(this.EO.dm()) ? this.EO.dm() : !TextUtils.isEmpty(this.EO.gm()) ? this.EO.gm() : "";
    }

    public String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.EO;
        return oet == null ? "" : (oet.VH() == null || TextUtils.isEmpty(this.EO.VH().MY())) ? !TextUtils.isEmpty(this.EO.hL()) ? this.EO.hL() : "" : this.EO.VH().MY();
    }

    public float getRealHeight() {
        return BS.EO(this.MY, this.lEW);
    }

    public float getRealWidth() {
        return BS.EO(this.MY, this.Bc);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public String getTitle() {
        return (this.EO.VH() == null || TextUtils.isEmpty(this.EO.VH().MY())) ? !TextUtils.isEmpty(this.EO.hL()) ? this.EO.hL() : !TextUtils.isEmpty(this.EO.dm()) ? this.EO.dm() : "" : this.EO.VH().MY();
    }

    public com.bytedance.sdk.openadsdk.core.rp.MY.vCE getVideoView() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce;
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.EO;
        if (oet != null && this.MY != null) {
            if (com.bytedance.sdk.openadsdk.core.model.oeT.Cc(oet)) {
                try {
                    vce = new com.bytedance.sdk.openadsdk.core.rp.MY.vCE(this.MY, this.EO, this.vCE, true, false, this.IlO);
                    vce.setVideoCacheUrl(this.rp);
                    vce.setControllerStatusCallBack(new vCE.MY() { // from class: com.bytedance.sdk.openadsdk.core.lEW.IlO.2
                        @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE.MY
                        public void IlO(boolean z2, long j, long j3, long j8, boolean z7) {
                        }
                    });
                    vce.setIsAutoPlay(this.NV);
                    vce.IlO(this.EV, "bannerGetVideoView");
                } catch (Throwable unused) {
                    vce = null;
                }
                if (!com.bytedance.sdk.openadsdk.core.model.oeT.Cc(this.EO) && vce != null && vce.IlO(0L, true, false)) {
                    return vce;
                }
            } else {
                vce = null;
                if (!com.bytedance.sdk.openadsdk.core.model.oeT.Cc(this.EO)) {
                }
            }
        }
        return null;
    }

    public void setDislikeInner(tl tlVar) {
        if (tlVar instanceof com.bytedance.sdk.openadsdk.EO.EO) {
            this.tV = (com.bytedance.sdk.openadsdk.EO.EO) tlVar;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet;
        if (tTDislikeDialogAbstract != null && (oet = this.EO) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(oet.KT(), this.EO.cJK());
        }
        this.Cc = tTDislikeDialogAbstract;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public IlO(@NonNull Context context, String str) {
        super(context);
        this.vCE = "embeded_ad";
        this.NV = true;
        this.EV = true;
        this.rp = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    public void IlO(View view, boolean z2) {
        com.bytedance.sdk.openadsdk.core.MY.MY my;
        if (view == null) {
            return;
        }
        if (z2) {
            Context context = this.MY;
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.EO;
            String str = this.vCE;
            my = new com.bytedance.sdk.openadsdk.core.MY.IlO(context, oet, str, zLG.IlO(str));
        } else {
            Context context2 = this.MY;
            com.bytedance.sdk.openadsdk.core.model.oeT oet2 = this.EO;
            String str2 = this.vCE;
            my = new com.bytedance.sdk.openadsdk.core.MY.MY(context2, oet2, str2, zLG.IlO(str2));
        }
        view.setOnTouchListener(my);
        view.setOnClickListener(my);
        my.IlO(new MY() { // from class: com.bytedance.sdk.openadsdk.core.lEW.IlO.1
            @Override // com.bytedance.sdk.openadsdk.core.lEW.MY
            public void IlO(View view2, int i2, com.bytedance.sdk.openadsdk.core.model.bWL bwl) {
                IlO.this.IlO(view2, i2, bwl);
            }
        });
    }

    public void IlO(int i2) {
        this.EV = com.bytedance.sdk.openadsdk.core.cl.tV().MY(String.valueOf(this.DmF));
        int iMY = com.bytedance.sdk.openadsdk.core.cl.tV().MY(i2);
        if (3 == iMY) {
            this.NV = false;
            return;
        }
        int iEO = com.bytedance.sdk.component.utils.xF.EO(com.bytedance.sdk.openadsdk.core.cl.IlO());
        if (1 != iMY || !zLG.tV(iEO)) {
            if (2 == iMY) {
                if (zLG.Cc(iEO) || zLG.tV(iEO) || zLG.vCE(iEO)) {
                    this.NV = true;
                    return;
                }
                return;
            }
            if (5 != iMY) {
                return;
            }
            if (!zLG.tV(iEO) && !zLG.vCE(iEO)) {
                return;
            }
        }
        this.NV = true;
    }

    public void IlO(View view) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.EO;
        if (oet == null || oet.fdM() == null || view == null) {
            return;
        }
        IlO(view, this.EO.lMM() == 1 && this.NV);
    }
}
