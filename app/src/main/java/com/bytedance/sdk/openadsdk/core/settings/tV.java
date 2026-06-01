package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static String EO = null;
    private static volatile String IlO = "";
    private static volatile String MY = "";
    private static volatile int tV;

    public static String EO() {
        if (tV != 0) {
            return MY;
        }
        IlO();
        return MY;
    }

    public static String tV() {
        if (TextUtils.isEmpty(EO)) {
            EO = cl.IlO().getPackageManager().getInstallerPackageName(zLG.Cc());
        }
        if (EO == null) {
            EO = "";
        }
        return EO;
    }

    public static String MY() {
        if (tV != 0) {
            return IlO;
        }
        IlO();
        return IlO;
    }

    public static void IlO() {
        try {
            AppSet.getClient(cl.IlO()).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope$1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                @Keep
                public void onSuccess(AppSetIdInfo appSetIdInfo) {
                    String unused = tV.IlO = Integer.toString(appSetIdInfo.getScope());
                    String unused2 = tV.MY = appSetIdInfo.getId();
                    int unused3 = tV.tV = 1;
                }
            });
        } catch (Throwable unused) {
            tV = 2;
        }
    }
}
