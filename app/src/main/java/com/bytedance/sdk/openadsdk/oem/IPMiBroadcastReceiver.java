package com.bytedance.sdk.openadsdk.oem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.tl;
import com.bytedance.sdk.openadsdk.tV.EO;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IPMiBroadcastReceiver extends BroadcastReceiver {
    private static volatile IPMiBroadcastReceiver IlO;
    private IlO EO;
    private final LruCache<String, oeT> MY;
    private int tV = 0;

    private IPMiBroadcastReceiver() {
        int i2 = 10;
        int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("ip_data_config", "ip_ad_cache_count", 10);
        if (iIlO > 0 && iIlO <= 200) {
            i2 = iIlO;
        }
        this.MY = new LruCache<>(i2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if ("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT".equals(intent.getAction())) {
            mmj.EO(new lEW("ip-mi") { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    final int i2;
                    final int i8;
                    final int i9;
                    try {
                        int intExtra = 0;
                        final int intExtra2 = intent.getIntExtra(IronSourceConstants.EVENTS_ERROR_CODE, 0);
                        if (intExtra2 < 0) {
                            int intExtra3 = intent.getIntExtra("reason", 0);
                            if (intExtra2 == -4 && intExtra3 == -1) {
                                return;
                            } else {
                                i2 = intExtra3;
                            }
                        } else {
                            i2 = 0;
                        }
                        if (intExtra2 == 5) {
                            int intExtra4 = intent.getIntExtra("status", 0);
                            if (intExtra4 == -2) {
                                try {
                                    intExtra = intent.getIntExtra("progress", 0);
                                } catch (Throwable unused) {
                                    IPMiBroadcastReceiver.this.tV = 1;
                                }
                                if (intExtra < 100) {
                                    return;
                                }
                            }
                            i8 = intExtra4;
                            i9 = intExtra;
                        } else {
                            i8 = 0;
                            i9 = 0;
                        }
                        String stringExtra = intent.getStringExtra("packageName");
                        IlO ilO = IPMiBroadcastReceiver.this.EO;
                        if (intExtra2 > 0 && ilO != null) {
                            ilO.IlO(stringExtra, intExtra2);
                        }
                        final oeT oetIlO = IPMiBroadcastReceiver.this.IlO(stringExtra);
                        if (oetIlO != null) {
                            EO.IlO(System.currentTimeMillis(), oetIlO, zLG.IlO(oetIlO), "ip_listener_log", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1.1
                                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                                public JSONObject IlO() {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put("ip_error_code", intExtra2);
                                        oeT oet = oetIlO;
                                        if (oet != null) {
                                            jSONObject3.put("ip_is_w2a", oet.DmF());
                                        }
                                        int i10 = intExtra2;
                                        if (i10 > 0) {
                                            if (i10 == 5) {
                                                jSONObject3.put("ip_status", i8);
                                                jSONObject3.put("ip_exec_type", IPMiBroadcastReceiver.this.tV);
                                            }
                                            if (i8 == -2) {
                                                jSONObject3.put("ip_progress", i9);
                                            }
                                        }
                                        if (intExtra2 < 0) {
                                            jSONObject3.put("ip_reason", i2);
                                        }
                                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                                        jSONObject.put("ad_extra_data", jSONObject2);
                                        return jSONObject;
                                    } catch (Throwable th) {
                                        com.bytedance.sdk.component.utils.oeT.EO("IPMiBroadcastReceiver", th.getMessage());
                                        return jSONObject;
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.EO("IPMiBroadcastReceiver", th.getMessage());
                    }
                }
            });
        }
    }

    public void IlO(String str, oeT oet) {
        if (TextUtils.isEmpty(str) || oet == null || this.MY.get(str) != null) {
            return;
        }
        this.MY.put(str, oet);
    }

    public oeT IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.MY.get(str);
    }

    public void IlO(IlO ilO) {
        this.EO = ilO;
    }

    public void IlO() {
        this.EO = null;
    }

    public static IPMiBroadcastReceiver IlO(Context context) {
        if (com.bytedance.sdk.openadsdk.AXM.IlO.IlO("ip_data_config", "ip_link_listener", 0) == 0) {
            return null;
        }
        if (IlO == null) {
            synchronized (IPMiBroadcastReceiver.class) {
                try {
                    if (IlO == null) {
                        IlO = new IPMiBroadcastReceiver();
                        IntentFilter intentFilter = new IntentFilter("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT");
                        if (Build.VERSION.SDK_INT >= 34 && zLG.NV(context) >= 34) {
                            context.registerReceiver(IlO, intentFilter, 2);
                        } else {
                            context.registerReceiver(IlO, intentFilter);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public static void IlO(final Context context, oeT oet) {
        tl tlVarIWr;
        if (IlO == null && oet != null && (tlVarIWr = oet.IWr()) != null && tlVarIWr.Bc()) {
            bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        IPMiBroadcastReceiver.IlO(cl.IlO(context));
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.EO("IPMiBroadcastReceiver", th.getMessage());
                    }
                }
            });
        }
    }
}
