package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.R;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.ea;
import com.bytedance.sdk.openadsdk.core.model.OOq;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private TTAdDislikeToast EO;
    private final IlO IlO;
    private com.bytedance.sdk.openadsdk.common.ea MY;

    public EO(IlO ilO) {
        this.IlO = ilO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        TTAdDislikeToast tTAdDislikeToast = this.EO;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        if (this.IlO.BS.isFinishing()) {
            return;
        }
        if (this.IlO.rp.get()) {
            if (this.EO == null) {
                this.EO = new TTAdDislikeToast(this.IlO.BS);
                ((FrameLayout) this.IlO.BS.findViewById(R.id.content)).addView(this.EO);
            }
            this.EO.show(TTAdDislikeToast.getDislikeTip());
            return;
        }
        if (this.MY == null) {
            try {
                MY(my);
            } catch (Throwable th) {
                ApmHelper.reportCustomError("initDislike error", "RewardFullDislikeManager", th);
            }
        }
        com.bytedance.sdk.openadsdk.common.ea eaVar = this.MY;
        if (eaVar != null) {
            eaVar.IlO();
        }
    }

    public void MY() {
        TTAdDislikeToast tTAdDislikeToast = this.EO;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.onDestroy();
        }
    }

    private void MY(final com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        if (this.MY == null) {
            IlO ilO = this.IlO;
            com.bytedance.sdk.openadsdk.common.ea eaVar = new com.bytedance.sdk.openadsdk.common.ea(ilO.BS, ilO.MY);
            this.MY = eaVar;
            eaVar.setCallback(new ea.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.EO.1
                @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                public void IlO(View view) {
                    EO.this.IlO.EV.set(true);
                    String str = "landing_page";
                    if (!com.bytedance.sdk.openadsdk.core.model.es.MY(EO.this.IlO.MY) && !com.bytedance.sdk.openadsdk.core.model.es.tV(EO.this.IlO.MY) && !com.bytedance.sdk.openadsdk.core.model.es.Cc(EO.this.IlO.MY)) {
                        if (!EO.this.IlO.NV.get()) {
                            str = "video_player";
                        } else if (OOq.MY(EO.this.IlO.MY)) {
                            str = "playable";
                        } else if (!EO.this.IlO.MY.AK()) {
                            str = "endcard";
                        }
                    }
                    EO.this.MY.setDislikeSource(str);
                    if (EO.this.IlO.vAh.Cc) {
                        if (EO.this.IlO.tl != null) {
                            EO.this.IlO.tl.IlO(8, false);
                            return;
                        }
                        return;
                    }
                    my.zPa();
                    if (EO.this.IlO.vAh.vCE()) {
                        EO.this.IlO.vAh.xF();
                    }
                    if ((EO.this.IlO.ED instanceof com.bytedance.sdk.openadsdk.activity.EO) && !EO.this.IlO.ED.kBB()) {
                        EO.this.IlO.ED.pP().IlO(2);
                    }
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(EO.this.IlO.MY, 8);
                }

                @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                public void MY(View view) {
                    EO.this.IlO.EV.set(false);
                    if (EO.this.IlO.vAh.Cc) {
                        if (EO.this.IlO.tl != null) {
                            EO.this.IlO.tl.IlO(0, true);
                            return;
                        }
                        return;
                    }
                    EO.this.IlO.vAh.IlO(my);
                    if (EO.this.IlO.vAh.lEW()) {
                        EO.this.IlO.vAh.es();
                    }
                    if ((EO.this.IlO.ED instanceof com.bytedance.sdk.openadsdk.activity.EO) && !EO.this.IlO.ED.kBB()) {
                        EO.this.IlO.ED.pP().IlO(1);
                    }
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(EO.this.IlO.MY, 4);
                }

                @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                public void IlO(FilterWord filterWord) {
                    if (EO.this.IlO.rp.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    EO.this.IlO.rp.set(true);
                    EO.this.EO();
                }
            });
            ((FrameLayout) this.IlO.BS.findViewById(R.id.content)).addView(this.MY);
        }
        if (this.EO == null) {
            this.EO = new TTAdDislikeToast(this.IlO.BS);
            ((FrameLayout) this.IlO.BS.findViewById(R.id.content)).addView(this.EO);
        }
    }

    public void IlO() {
        TTAdDislikeToast tTAdDislikeToast = this.EO;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.hide();
        }
    }
}
