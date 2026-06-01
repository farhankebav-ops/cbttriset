package com.bytedance.sdk.openadsdk.component.Bc;

import a1.a;
import android.content.Context;
import b0.b;
import com.bytedance.sdk.component.utils.Bc;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.vCE;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.multipro.MY;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static File IlO(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(((b) CacheDirFactory.getICacheDir(0)).d());
        return new File(a.r(sb, File.separator, str));
    }

    public static File MY(String str) {
        return IlO(cl.IlO(), vCE.IlO(cl.IlO()).MY(), str);
    }

    public static File IlO(Context context, String str, String str2) {
        return Bc.IlO(context, MY.EO(), str, str2);
    }

    public static void IlO(File file) {
        if (file == null) {
            return;
        }
        try {
            Bc.MY(file);
        } catch (Throwable unused) {
        }
    }

    public static void IlO(Context context) {
        try {
            vCE.IlO(context).IlO();
        } catch (Throwable unused) {
        }
    }

    public static String IlO() {
        return Bc.IlO(cl.IlO(), MY.EO(), vCE.IlO(cl.IlO()).MY()).getAbsolutePath();
    }

    public static void IlO(JSONObject jSONObject, int i2, boolean z2) {
        try {
            String strLEW = DmF.MY().lEW();
            int iDmF = DmF.MY().DmF();
            JSONObject jSONObject2 = jSONObject.getJSONObject("creative");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", strLEW);
            if (!z2) {
                jSONObject3.put("app_icon_id", "@".concat(String.valueOf(iDmF)));
            } else if (DmF.MY().DmF() != 0) {
                jSONObject3.put("app_icon_id", "local://pag_open_icon_id");
            }
            jSONObject2.put("open_app_info", jSONObject3);
            if (jSONObject2.optJSONObject(MimeTypes.BASE_TYPE_VIDEO) == null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("video_duration", cl.tV().oeT(String.valueOf(i2)));
                jSONObject2.put(MimeTypes.BASE_TYPE_VIDEO, jSONObject4);
            }
        } catch (Exception e) {
            oeT.EO("TTAppOpenUtils", e.getMessage());
        }
    }

    public static int IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2) {
        return i2 - oet.TU();
    }
}
