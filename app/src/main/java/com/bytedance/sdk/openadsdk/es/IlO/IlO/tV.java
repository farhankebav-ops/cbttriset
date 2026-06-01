package com.bytedance.sdk.openadsdk.es.IlO.IlO;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lMM;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.tl;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.tV.rp;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements vCE {
    private final WeakReference<Context> Bc;
    protected String EO;
    protected com.bytedance.sdk.openadsdk.core.model.tV IlO;
    protected oeT MY;
    protected int vCE;
    protected boolean tV = false;
    protected final AtomicBoolean Cc = new AtomicBoolean(false);
    private boolean lEW = false;

    public tV(Context context, oeT oet, String str) {
        this.Bc = new WeakReference<>(context);
        this.MY = oet;
        this.IlO = oet.VH();
        this.EO = str;
        "====tag===".concat(String.valueOf(str));
        if (cl.IlO() == null) {
            cl.MY(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public boolean Cc() {
        this.Cc.set(true);
        return this.IlO != null && IlO(EO(), this.IlO.IlO(), this.IlO.EO());
    }

    public Context EO() {
        WeakReference<Context> weakReference = this.Bc;
        return (weakReference == null || weakReference.get() == null) ? cl.IlO() : this.Bc.get();
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public boolean IlO() {
        return false;
    }

    public boolean MY() {
        com.bytedance.sdk.openadsdk.core.tV.IlO(this.MY, this.EO, 1, null);
        if (this.MY.zTS() == null) {
            com.bytedance.sdk.openadsdk.core.tV.IlO(this.MY, this.EO, -1, null);
            return false;
        }
        String strIlO = this.MY.zTS().IlO();
        if (TextUtils.isEmpty(strIlO)) {
            oeT oet = this.MY;
            com.bytedance.sdk.openadsdk.core.tV.IlO(oet, this.EO, -2, oet.zTS().tV());
        } else {
            Uri uri = Uri.parse(strIlO);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            zLG.MY myIlO = zLG.IlO(EO(), intent);
            if (myIlO.MY > 0) {
                if (!(EO() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                try {
                    HashMap map = new HashMap();
                    IlO(map);
                    map.put("matched_count", Integer.valueOf(myIlO.MY));
                    map.put("url", strIlO);
                    ComponentName componentName = myIlO.IlO;
                    if (componentName != null) {
                        intent.setComponent(componentName);
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(this.MY, this.EO, "open_url_app", map);
                    EO().startActivity(intent);
                    rp.IlO().IlO(map).IlO(this.MY, this.EO);
                    com.bytedance.sdk.openadsdk.tV.EO.IlO("dp_start_act_success", this.MY, this.EO, map);
                    return true;
                } catch (Throwable th) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", th.getMessage());
                        jSONObject.put("intent", intent.toString());
                        jSONObject.put("can_query_install", 1);
                    } catch (Exception unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.tV.IlO(this.MY, this.EO, -4, jSONObject);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("intent", intent.toString());
                    jSONObject2.put("can_query_install", 1);
                } catch (Exception unused2) {
                }
                com.bytedance.sdk.openadsdk.core.tV.IlO(this.MY, this.EO, -3, jSONObject2);
            }
        }
        if (this.tV && !this.Cc.get()) {
            return false;
        }
        this.tV = true;
        Map<String, Object> map2 = new HashMap<>();
        IlO(map2);
        com.bytedance.sdk.openadsdk.tV.EO.IlO(this.MY, this.EO, "open_fallback_url", map2);
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public void tV() {
        if (EO() == null) {
            return;
        }
        if (MY()) {
            this.Cc.set(true);
            this.MY.EO(true);
            return;
        }
        if (IlO()) {
            this.MY.EO(true);
            return;
        }
        if (MY(false)) {
            return;
        }
        if (Cc()) {
            this.MY.EO(true);
        } else {
            if (this.MY.VH() != null || this.MY.pFe() == null) {
                return;
            }
            lMM.IlO(EO(), this.MY.pFe(), this.MY, zLG.IlO(this.EO), this.EO, true);
            this.MY.EO(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public void IlO(boolean z2) {
        this.lEW = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE
    public void IlO(int i2) {
        this.vCE = i2;
    }

    public boolean IlO(Context context, String str, String str2) {
        return IlO(context, str, str2, this.EO, this.MY);
    }

    public static boolean IlO(Context context, String str, String str2, String str3, oeT oet) {
        if (EO.IlO()) {
            return Cc.IlO(context, str, str2, str3, oet);
        }
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

    private void IlO(Map<String, Object> map) {
        oeT oet = this.MY;
        if (oet != null && oet.lQ() == 0) {
            oeT oet2 = this.MY;
            map.put("auto_click", Boolean.valueOf((oet2 == null || oet2.NV()) ? false : true));
        }
        oeT oet3 = this.MY;
        if (oet3 != null && oet3.lQ() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.vCE >= 11));
        }
        map.put("can_query_install", 1);
    }

    public boolean MY(boolean z2) {
        tl tlVarIWr;
        IPMiBroadcastReceiver iPMiBroadcastReceiverIlO;
        try {
            oeT oet = this.MY;
            if (oet == null || (tlVarIWr = oet.IWr()) == null || TextUtils.isEmpty(tlVarIWr.DmF())) {
                return false;
            }
            if (tlVarIWr.Bc() && this.MY.VH() != null && !TextUtils.isEmpty(this.MY.VH().EO()) && (iPMiBroadcastReceiverIlO = IPMiBroadcastReceiver.IlO(EO())) != null) {
                iPMiBroadcastReceiverIlO.IlO(this.MY.VH().EO(), this.MY);
            }
            final boolean zIlO = MY.IlO(EO(), tlVarIWr.DmF(), this.MY);
            mmj.MY(new lEW("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.es.IlO.IlO.tV.1
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
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("GPDownLoader", th.getMessage());
            return false;
        }
    }
}
