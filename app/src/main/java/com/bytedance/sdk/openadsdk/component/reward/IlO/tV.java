package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO Cc;
    private final String EO;
    com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE IlO;
    private final oeT MY;
    private boolean tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, int i2, int i8, int i9);

        void IlO(String str, JSONObject jSONObject);
    }

    public tV(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.Cc = ilO;
        this.MY = ilO.MY;
        this.EO = ilO.Cc;
    }

    private void tV() {
        if (!com.bytedance.sdk.openadsdk.multipro.MY.EO() && this.MY.Jz() == 4) {
            this.IlO = com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(this.Cc.gQ, this.MY, this.EO);
        }
        if (this.IlO == null) {
            this.IlO = com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(this.Cc.BS, this.MY, this.EO);
        }
    }

    public com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE EO() {
        return this.IlO;
    }

    public void IlO() {
        if (this.tV) {
            return;
        }
        this.tV = true;
        tV();
    }

    public void MY() {
        com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vce = this.IlO;
        if (vce != null) {
            vce.tV();
        }
    }

    public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, int i2, int i8, int i9, IlO ilO) {
        if (this.IlO != null) {
            int id = view.getId();
            if (id == com.bytedance.sdk.openadsdk.utils.zPa.Cc) {
                ilO.IlO("click_play_star_level", null);
                return;
            }
            if (id == com.bytedance.sdk.openadsdk.utils.zPa.tV) {
                ilO.IlO("click_play_star_nums", null);
                return;
            } else if (id == com.bytedance.sdk.openadsdk.utils.zPa.EO) {
                ilO.IlO("click_play_source", null);
                return;
            } else {
                if (id == com.bytedance.sdk.openadsdk.utils.zPa.MY) {
                    ilO.IlO("click_play_logo", null);
                    return;
                }
                return;
            }
        }
        ilO.IlO(view, f4, f8, f9, f10, sparseArray, i2, i8, i9);
    }
}
