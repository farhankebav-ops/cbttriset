package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static boolean EO;
    private static WeakReference<com.bytedance.sdk.openadsdk.core.model.oeT> IlO;
    private static long MY;

    public static boolean EO() {
        WeakReference<com.bytedance.sdk.openadsdk.core.model.oeT> weakReference = IlO;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        EO = true;
        return true;
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        com.bytedance.sdk.openadsdk.core.model.tV tVVarVH = oet.VH();
        if (tVVarVH == null || TextUtils.isEmpty(tVVarVH.IlO())) {
            return;
        }
        IlO = new WeakReference<>(oet);
    }

    private static void MY(final long j) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet;
        WeakReference<com.bytedance.sdk.openadsdk.core.model.oeT> weakReference = IlO;
        if (weakReference == null || j <= 0 || (oet = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oet, oet.Cc(), "store_duration", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.utils.Cc.1
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", j);
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
        });
        IlO = null;
        EO = false;
    }

    public static void IlO(long j) {
        MY(j);
    }

    public static void IlO() {
        if (IlO == null || EO) {
            return;
        }
        if (MY > 0) {
            MY(SystemClock.elapsedRealtime() - MY);
        }
        IlO = null;
        MY = 0L;
    }

    public static void MY() {
        if (IlO == null || EO) {
            return;
        }
        MY = SystemClock.elapsedRealtime();
    }
}
