package com.bytedance.sdk.openadsdk.tV.IlO;

import android.content.Context;
import android.os.HandlerThread;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.mediationsdk.metadata.a;
import com.unity3d.services.UnityAdsConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV implements com.bytedance.sdk.component.vCE.IlO.Cc {
    private final String IlO = "[7206]";

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean Bc() {
        return false;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public Executor Cc() {
        return mmj.lEW();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public String DmF() {
        return zLG.EO();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean EO() {
        return true;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public com.bytedance.sdk.component.vCE.IlO.vCE EV() {
        com.bytedance.sdk.component.vCE.IlO.vCE vceIlO;
        synchronized (this) {
            vceIlO = com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO());
        }
        return vceIlO;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public com.bytedance.sdk.component.vCE.IlO.tV.IlO IlO(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean MY() {
        return false;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public com.bytedance.sdk.component.vCE.IlO.Cc.EO NV() {
        return new Bc();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean bWL() {
        return BinderPoolService.IlO;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public int cl() {
        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("batch_log_config", "once_max", 10);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public long ea() {
        long jIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("log_queue_timeout", 40000);
        if (jIlO < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS || jIlO > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS) {
            return 40000L;
        }
        return jIlO;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public void hp() {
        IlO.IlO(IlO.vCE);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean lEW() {
        return true;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public com.bytedance.sdk.component.vCE.IlO.Bc rp() {
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public Executor tV() {
        return mmj.tV();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public int vCE() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean zPa() {
        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("batch_log_config", a.j, 0) == 1;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public int EO(String str) {
        return com.bytedance.sdk.openadsdk.core.settings.hp.aP().PTq().IlO(str);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean IlO() {
        return false;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public String MY(String str) {
        return com.bytedance.sdk.component.tV.IlO.IlO(str, com.bytedance.sdk.openadsdk.core.IlO.IlO());
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public boolean IlO(Context context) {
        return xF.IlO(context);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public String IlO(String str) {
        return com.bytedance.sdk.component.tV.IlO.MY(str, com.bytedance.sdk.openadsdk.core.IlO.IlO());
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public void IlO(boolean z2, int i2, long j, com.bytedance.sdk.component.vCE.IlO.vCE.tV tVVar) {
        Runnable runnableIlO;
        if (tVVar == null) {
            return;
        }
        IlO.IlO(IlO.EO, z2, i2, j);
        if (z2) {
            com.bytedance.sdk.openadsdk.ea.EO.IlO("track_link_result", false, (com.bytedance.sdk.openadsdk.ea.MY) new hp(true, tVVar));
            return;
        }
        bWL bwlPTq = com.bytedance.sdk.openadsdk.core.settings.hp.aP().PTq();
        if (bwlPTq == null || tVVar.tV() >= bwlPTq.IlO(tVVar.vCE())) {
            com.bytedance.sdk.openadsdk.ea.EO.IlO("track_link_result", false, (com.bytedance.sdk.openadsdk.ea.MY) new hp(false, tVVar));
        } else {
            if (!bwlPTq.IlO() || (runnableIlO = tVVar.IlO(com.bytedance.sdk.openadsdk.core.rp.IlO(cl.IlO()), null)) == null) {
                return;
            }
            mmj.IlO().schedule(runnableIlO, bwlPTq.MY(tVVar.vCE()), TimeUnit.SECONDS);
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public void IlO(boolean z2) {
        IlO.IlO(IlO.vCE, z2);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc
    public HandlerThread IlO(String str, int i2) {
        return com.bytedance.sdk.component.utils.lEW.IlO(str, i2);
    }
}
