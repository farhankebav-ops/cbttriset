package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.core.pP;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static final SparseArray<WeakReference<oeT>> IlO = new SparseArray<>();

    public static void IlO(IlO ilO, Intent intent, Bundle bundle) {
        IlO(intent, ilO);
        IlO(bundle, ilO);
    }

    public static oeT IlO(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            com.bytedance.sdk.openadsdk.core.model.IlO ilOBc = pP.IlO().Bc();
            vah = ilOBc != null ? new vAh(ilOBc) : null;
            if (my != null) {
                my.IlO(bundle);
            }
            pP.IlO().vCE();
        } else if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                if (stringExtra != null) {
                    vah = new vAh(com.bytedance.sdk.openadsdk.core.model.IlO.EO(new JSONObject(stringExtra)));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFDM", "", e);
            }
        }
        if (bundle != null) {
            try {
                WeakReference<oeT> weakReference = IlO.get(bundle.getInt("meta_tmp"));
                if (weakReference != null) {
                    vah = weakReference.get();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFDM", "", th);
            }
        }
        if (vah != null) {
            vah.IlO(vah.kBB(), 7);
        }
        return vah;
    }

    public static void IlO(Intent intent, IlO ilO) {
        if (intent == null) {
            return;
        }
        ilO.vAh.MY(intent.getBooleanExtra("video_is_cached", false));
        ilO.quf = intent.getStringExtra("multi_process_listener_key");
        ilO.nm = intent.getIntExtra("orientation_angle", 0) == 3;
    }

    public static void IlO(Bundle bundle, IlO ilO) {
        if (bundle == null) {
            return;
        }
        ilO.quf = bundle.getString("multi_process_listener_key");
        ilO.vAh.MY(bundle.getBoolean("video_is_cached", false));
        ilO.uvo = bundle.getBoolean("is_mute");
        if (bundle.getLong("video_current") > 0) {
            ilO.vAh.MY(bundle.getLong("video_current", 0L));
        }
        ilO.IlO(bundle.getBoolean("has_show_skip_btn"));
    }

    public static void IlO(IlO ilO, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            oeT oet = ilO.MY;
            IlO.append(oet.hashCode(), new WeakReference<>(oet));
            bundle.putInt("meta_tmp", oet.hashCode());
            bundle.putString("multi_process_listener_key", ilO.quf);
            bundle.putBoolean("video_is_cached", ilO.vAh.vSq());
            bundle.putLong("video_current", ilO.vAh.EV());
            bundle.putBoolean("is_mute", ilO.uvo);
            bundle.putBoolean("has_show_skip_btn", ilO.ii);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFDM", "onSaveInstanceState: ", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void IlO(android.content.Intent r2, android.app.Activity r3, boolean r4, com.bytedance.sdk.openadsdk.core.model.IlO r5, java.lang.String r6) {
        /*
            if (r3 != 0) goto L8
            r3 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r3)
            goto L1d
        L8:
            android.view.WindowManager r3 = r3.getWindowManager()     // Catch: java.lang.Exception -> L15
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch: java.lang.Exception -> L15
            int r3 = r3.getRotation()     // Catch: java.lang.Exception -> L15
            goto L1e
        L15:
            r3 = move-exception
            java.lang.String r0 = "TTAD.RFDM"
            java.lang.String r1 = ""
            com.bytedance.sdk.component.utils.oeT.IlO(r0, r1, r3)
        L1d:
            r3 = 0
        L1e:
            java.lang.String r0 = "orientation_angle"
            r2.putExtra(r0, r3)
            java.lang.String r3 = "video_is_cached"
            r2.putExtra(r3, r4)
            boolean r3 = com.bytedance.sdk.openadsdk.multipro.MY.EO()
            if (r3 == 0) goto L44
            org.json.JSONObject r3 = r5.bWL()
            if (r3 != 0) goto L35
            return
        L35:
            java.lang.String r4 = "multi_process_ad_info"
            java.lang.String r3 = r3.toString()
            r2.putExtra(r4, r3)
            java.lang.String r3 = "multi_process_listener_key"
            r2.putExtra(r3, r6)
            return
        L44:
            com.bytedance.sdk.openadsdk.core.pP r2 = com.bytedance.sdk.openadsdk.core.pP.IlO()
            r2.vCE()
            com.bytedance.sdk.openadsdk.core.pP r2 = com.bytedance.sdk.openadsdk.core.pP.IlO()
            r2.IlO(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(android.content.Intent, android.app.Activity, boolean, com.bytedance.sdk.openadsdk.core.model.IlO, java.lang.String):void");
    }
}
