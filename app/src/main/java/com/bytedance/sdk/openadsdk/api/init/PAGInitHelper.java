package com.bytedance.sdk.openadsdk.api.init;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.IlO.MY.MY;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.common.Cc;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.EO;
import com.bytedance.sdk.openadsdk.core.act.IlO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.rp;
import com.bytedance.sdk.openadsdk.multipro.tV.tV;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.lMM;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.ironsource.Q6;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGInitHelper {
    public static final List<PAGSdk.PAGInitCallback> CALLBACK_LIST = new ArrayList();
    public static float animationScale = 1.0f;

    private static void IlO(Context context) {
        EO.IlO(context).IlO("uuid", pP.IlO());
    }

    public static void initAPM() {
        if (Cc.IlO()) {
            return;
        }
        try {
            String strTV = DmF.MY().tV();
            if (TextUtils.isEmpty(strTV)) {
                return;
            }
            ApmHelper.initApm(cl.IlO(), new PAGConfig.Builder().appId(strTV).build());
        } catch (Exception unused) {
        }
    }

    public static void initAnimationScale(Context context) {
        try {
            float f4 = Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
            animationScale = f4;
            if (f4 <= 0.0f) {
                animationScale = 1.0f;
            }
        } catch (Throwable unused) {
            animationScale = 1.0f;
        }
    }

    public static void initMemoryData() {
        cl.tV();
        tV.IlO("ttopenadsdk", "a", 0);
        tV.IlO("sp_global_file", "a", 0);
        tV.IlO("sp_global_privacy", "a", 0);
        tV.IlO("sp_global_app_id", "a", 0);
        tV.IlO("sp_global_icon_id", "a", 0);
        tV.IlO("tpl_fetch_model", "a", 0);
        tV.IlO("tt_sp", "a", 0);
        tV.IlO("tt_sdk_event_net_ad", "a", 0);
        tV.IlO("tt_sdk_event_net_state", "a", 0);
        tV.IlO("tt_sdk_event_net_trail", "a", 0);
        tV.IlO("tt_sdk_event_db_ad", "a", 0);
        tV.IlO("tt_sdk_event_db_state", "a", 0);
        tV.IlO("tt_sdk_event_db_trail", "a", 0);
        tV.IlO("pag_sp_bad_par", "did");
        tV.IlO("pag_sp_bad_par", Q6.U0);
    }

    public static void maybeAsyncInitTask(Context context) {
        IlO.IlO(context);
        lMM.IlO();
        BS.IlO(context);
        IlO(context);
        cl.Cc();
        String strIlO = rp.IlO(context);
        com.bytedance.sdk.openadsdk.core.DmF.EO.MY(strIlO);
        com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(strIlO, true);
        MY.IlO();
        com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().MY();
        initAnimationScale(context);
    }
}
