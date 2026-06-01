package com.bytedance.sdk.openadsdk.core.lEW;

import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM extends com.bytedance.sdk.component.adexpress.MY.IlO<IlO> {
    private com.bytedance.sdk.component.adexpress.MY.Bc Cc;
    private final View EO;
    AtomicBoolean IlO = new AtomicBoolean(false);
    private IlO MY;
    private com.bytedance.sdk.component.adexpress.MY.EO tV;
    private final com.bytedance.sdk.component.adexpress.MY.hp vCE;

    public AXM(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.MY.hp hpVar) {
        this.EO = view;
        this.vCE = hpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        if (this.IlO.get()) {
            return;
        }
        com.bytedance.sdk.component.adexpress.MY.EO eo = this.tV;
        if (eo == null || !eo.IlO((xF) this.EO, 0)) {
            this.Cc.IlO(107, "backup false");
            return;
        }
        this.vCE.Cc().Bc();
        IlO ilO = (IlO) this.EO.findViewWithTag("tt_express_backup_fl_tag_26");
        this.MY = ilO;
        if (ilO == null) {
            this.Cc.IlO(107, "backupview is null");
            return;
        }
        com.bytedance.sdk.component.adexpress.MY.bWL bwl = new com.bytedance.sdk.component.adexpress.MY.bWL();
        IlO ilO2 = this.MY;
        float realWidth = ilO2 == null ? 0.0f : ilO2.getRealWidth();
        IlO ilO3 = this.MY;
        float realHeight = ilO3 != null ? ilO3.getRealHeight() : 0.0f;
        bwl.IlO(true);
        bwl.IlO(realWidth);
        bwl.MY(realHeight);
        this.Cc.IlO(this.MY, bwl);
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public void IlO(com.bytedance.sdk.component.adexpress.MY.Bc bc) {
        this.Cc = bc;
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.AXM.1
            @Override // java.lang.Runnable
            public void run() {
                AXM.this.MY();
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public IlO Cc() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.IlO
    public void IlO(com.bytedance.sdk.component.adexpress.MY.EO eo) {
        this.tV = eo;
    }
}
