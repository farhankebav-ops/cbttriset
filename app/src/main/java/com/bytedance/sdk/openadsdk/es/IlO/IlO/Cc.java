package com.bytedance.sdk.openadsdk.es.IlO.IlO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.ea;
import com.bytedance.sdk.openadsdk.core.lMM;
import com.bytedance.sdk.openadsdk.core.model.EV;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.tl;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.vAh;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements vCE {
    public static Boolean IlO;
    protected int Cc;
    protected oeT EO;
    protected com.bytedance.sdk.openadsdk.core.model.tV MY;
    protected String tV;
    private final WeakReference<Context> vCE;

    public Cc(Context context, oeT oet, String str) {
        this.vCE = new WeakReference<>(context);
        this.EO = oet;
        this.MY = oet.VH();
        this.tV = str;
        "====tag===".concat(String.valueOf(str));
        if (cl.IlO() == null) {
            cl.MY(context);
        }
    }

    private static boolean vCE() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public boolean Cc() {
        return this.MY != null && IlO(MY(), this.MY.IlO(), this.MY.EO());
    }

    public boolean EO() {
        com.bytedance.sdk.openadsdk.core.tV.IlO(this.EO, this.tV, 1, null);
        EV evZTS = this.EO.zTS();
        if (evZTS == null) {
            com.bytedance.sdk.openadsdk.core.tV.IlO(this.EO, this.tV, -1, null);
            return false;
        }
        HashMap map = new HashMap();
        IlO(map);
        String strIlO = evZTS.IlO();
        Context contextMY = MY();
        oeT oet = this.EO;
        if (EO.IlO(contextMY, strIlO, oet, zLG.MY(oet), map, true)) {
            return true;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(this.EO, this.tV, "open_fallback_url", map);
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public void IlO(boolean z2) {
    }

    public Context MY() {
        WeakReference<Context> weakReference = this.vCE;
        return (weakReference == null || weakReference.get() == null) ? cl.IlO() : this.vCE.get();
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public void tV() {
        if (MY() == null) {
            return;
        }
        if (EO()) {
            this.EO.EO(true);
            com.bytedance.sdk.openadsdk.utils.Cc.IlO(this.EO);
            return;
        }
        if (IlO()) {
            this.EO.EO(true);
            com.bytedance.sdk.openadsdk.utils.Cc.IlO(this.EO);
            return;
        }
        if (MY(false)) {
            com.bytedance.sdk.openadsdk.utils.Cc.IlO(this.EO);
            return;
        }
        if (Cc()) {
            this.EO.EO(true);
            com.bytedance.sdk.openadsdk.utils.Cc.IlO(this.EO);
        } else {
            if (this.EO.VH() != null || this.EO.pFe() == null) {
                return;
            }
            lMM.IlO(MY(), this.EO.pFe(), this.EO, zLG.IlO(this.tV), this.tV, true);
            this.EO.EO(true);
            com.bytedance.sdk.openadsdk.utils.Cc.IlO(this.EO);
        }
    }

    public static boolean IlO(Context context, String str, String str2, String str3, oeT oet) {
        if (!TextUtils.isEmpty(str3) && str3.contains("_landingpage")) {
            str3 = str3.replace("_landingpage", "");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.tV.EO.MY(oet, str3, "store_open", (JSONObject) null);
                com.bytedance.sdk.openadsdk.utils.Cc.IlO(oet);
                return true;
            } catch (Throwable unused) {
            }
        }
        if (context != null && str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                Uri uri = Uri.parse("market://details?id=".concat(str2));
                intent2.setData(uri);
                Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent2, 65536).iterator();
                while (it.hasNext()) {
                    if (it.next().activityInfo.packageName.equals("com.android.vending") && context.getPackageManager().getLaunchIntentForPackage("com.android.vending") != null) {
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(uri);
                        intent3.setPackage("com.android.vending");
                        if (!(context instanceof Activity)) {
                            intent3.setFlags(268435456);
                        }
                        context.startActivity(intent3);
                        com.bytedance.sdk.openadsdk.tV.EO.MY(oet, str3, "store_open", (JSONObject) null);
                        com.bytedance.sdk.openadsdk.utils.Cc.IlO(oet);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                ApmHelper.reportCustomError("gotoGooglePlayByPackageNameAndUrl error", "gotoGooglePlay", th);
            }
        }
        return false;
    }

    public boolean MY(boolean z2) {
        return MY(this.EO, MY(), z2);
    }

    public static boolean MY(oeT oet, Context context, boolean z2) {
        String strEO;
        IPMiBroadcastReceiver iPMiBroadcastReceiverIlO;
        if (oet != null && context != null) {
            try {
                tl tlVarIWr = oet.IWr();
                if (tlVarIWr != null && !TextUtils.isEmpty(tlVarIWr.DmF())) {
                    if (tlVarIWr.lEW() && IlO(oet, context, z2)) {
                        return true;
                    }
                    if (tlVarIWr.Bc()) {
                        if (oet.DmF() == 1) {
                            strEO = tlVarIWr.IlO();
                        } else {
                            strEO = (oet.VH() == null || TextUtils.isEmpty(oet.VH().EO())) ? null : oet.VH().EO();
                        }
                        if (!TextUtils.isEmpty(strEO) && (iPMiBroadcastReceiverIlO = IPMiBroadcastReceiver.IlO(context)) != null) {
                            iPMiBroadcastReceiverIlO.IlO(strEO, oet);
                        }
                    }
                    final boolean zIlO = EO.IlO(context, tlVarIWr.DmF(), oet, zLG.MY(oet), IlO(oet, z2, tlVarIWr), true);
                    mmj.MY(new lEW("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.es.IlO.IlO.Cc.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (zIlO) {
                                DmF.IlO("oem_store", "1");
                            } else {
                                DmF.IlO("oem_store", "-2");
                            }
                        }
                    });
                    return zIlO;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("GPDownLoader", th.getMessage());
            }
        }
        return false;
    }

    public static boolean IlO(oeT oet, String str, Context context, String str2, Map<String, Object> map) {
        Intent intentIlO;
        if (oet != null && oet.aP() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (intentIlO = zLG.IlO(context, str)) == null) {
                return false;
            }
            intentIlO.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                intentIlO.addFlags(268435456);
            }
            context.startActivity(intentIlO);
            if (map == null) {
                map = new HashMap<>();
            }
            if (oet != null && oet.lQ() == 0) {
                map.put("auto_click", Boolean.valueOf(!oet.NV()));
            }
            map.put("can_query_install", Integer.valueOf(vCE() ? 1 : 0));
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public void IlO(int i2) {
        this.Cc = i2;
    }

    public boolean IlO(Context context, String str, String str2) {
        return IlO(context, str, str2, this.tV, this.EO);
    }

    private void IlO(Map<String, Object> map) {
        oeT oet = this.EO;
        if (oet != null && oet.lQ() == 0) {
            oeT oet2 = this.EO;
            map.put("auto_click", Boolean.valueOf((oet2 == null || oet2.NV()) ? false : true));
        }
        oeT oet3 = this.EO;
        if (oet3 != null && oet3.lQ() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.Cc >= 11));
        }
        map.put("can_query_install", Integer.valueOf(vCE() ? 1 : 0));
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public boolean IlO() {
        if (this.MY == null) {
            return false;
        }
        oeT oet = this.EO;
        if (oet != null && oet.aP() == 0) {
            return false;
        }
        String strEO = this.MY.EO();
        if (TextUtils.isEmpty(strEO)) {
            return false;
        }
        return IlO(this.EO, strEO, MY(), this.tV, new HashMap());
    }

    private static void IlO(JSONObject jSONObject, JSONObject jSONObject2, oeT oet, String str, int i2) {
        try {
            jSONObject.put("status", i2);
            jSONObject2.put("pag_json_data", jSONObject.toString());
            com.bytedance.sdk.openadsdk.tV.EO.MY(oet, str, "gp_mini_card_status", jSONObject2);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean IlO(oeT oet, Context context, boolean z2) {
        if (oet != null && oet.IWr() != null && oet.IWr().lEW() && !TextUtils.isEmpty(oet.IWr().DmF()) && context != null) {
            try {
                tl tlVarIWr = oet.IWr();
                String strIlO = zLG.IlO(oet);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectNV = tlVarIWr.NV();
                jSONObjectNV.put("from_web", z2 ? 1 : 0);
                jSONObjectNV.put("is_w2a", oet.DmF());
                jSONObjectNV.put("status", 0);
                jSONObject.put("pag_json_data", jSONObjectNV.toString());
                com.bytedance.sdk.openadsdk.tV.EO.MY(oet, strIlO, "gp_mini_card_status", jSONObject);
                Intent intentIlO = IlO(context, tlVarIWr);
                if (intentIlO == null) {
                    IlO(jSONObjectNV, jSONObject, oet, strIlO, -2);
                    return false;
                }
                if (context instanceof Activity) {
                    if (!vAh.IlO((Activity) context)) {
                        context = null;
                    }
                } else {
                    Activity activityMY = ea.IlO().Cc().MY();
                    if (activityMY != null && vAh.IlO(activityMY)) {
                        context = activityMY;
                    }
                }
                if (!(context instanceof Activity)) {
                    IlO(jSONObjectNV, jSONObject, oet, strIlO, -5);
                    return false;
                }
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && intentIlO.resolveActivity(packageManager) != null) {
                    try {
                        ((Activity) context).startActivityForResult(intentIlO, 0);
                        IlO(jSONObjectNV, jSONObject, oet, strIlO, 1);
                        return true;
                    } catch (Throwable unused) {
                        IlO(jSONObjectNV, jSONObject, oet, strIlO, -3);
                        return false;
                    }
                }
                IlO(jSONObjectNV, jSONObject, oet, strIlO, -4);
                return false;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return false;
    }

    private static Intent IlO(Context context, tl tlVar) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            String strTV = tlVar.tV();
            if (!TextUtils.isEmpty(strTV)) {
                intent.setPackage(strTV);
            } else {
                intent.setPackage("com.android.vending");
            }
            intent.setData(Uri.parse(tlVar.DmF()));
            boolean z2 = true;
            if (tlVar.MY() != 1) {
                z2 = false;
            }
            intent.putExtra("overlay", z2);
            if (TextUtils.isEmpty(tlVar.EO())) {
                intent.putExtra("callerId", context.getPackageName());
            } else {
                intent.putExtra("callerId", tlVar.EO());
            }
            tlVar.IlO(intent);
            return intent;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    @NonNull
    private static Map<String, Object> IlO(oeT oet, boolean z2, tl tlVar) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("oem_vendor_type", tlVar.vCE());
            jSONObject.put("from_web", z2 ? 1 : 0);
            jSONObject.put("is_w2a", oet.DmF());
            map.put("pag_json_data", jSONObject.toString());
        } catch (Throwable unused) {
        }
        return map;
    }

    public static boolean IlO(String str, oeT oet) {
        String queryParameter;
        if (str != null && !str.isEmpty()) {
            try {
                Uri uri = Uri.parse(str);
                String scheme = uri.getScheme();
                String host = uri.getHost();
                if ("market".equals(scheme) && "details".equals(host)) {
                    return true;
                }
                if ((!ProxyConfig.MATCH_HTTP.equals(scheme) && !"https".equals(scheme)) || (!"play.google.com".equals(host) && !"market.android.com".equals(host))) {
                    if ("market".equals(scheme) && "webstoreredirect".equals(host) && (queryParameter = uri.getQueryParameter("uri")) != null) {
                        return IlO(queryParameter, oet);
                    }
                }
                return true;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return false;
    }

    public static boolean IlO(oeT oet, String str) {
        if (oet == null || oet.IWr() == null) {
            return false;
        }
        String strCc = oet.IWr().Cc();
        if (TextUtils.isEmpty(strCc)) {
            return false;
        }
        return Pattern.compile(strCc).matcher(str).matches();
    }
}
