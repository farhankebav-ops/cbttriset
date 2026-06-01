package com.bytedance.sdk.openadsdk.core.act;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.EngagementSignalsCallback;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.model.NV;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2318f4;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AdActAction {
    private CustomTabsSession Bc;
    private String Cc;
    private oeT EO;
    private Context MY;
    private Long ea;
    private ActServiceConnection lEW;
    private String tV;
    private BindCustomTabsServiceCallback zPa;
    private CustomTabsClient vCE = null;
    private boolean DmF = false;
    private boolean NV = false;
    private boolean EV = false;
    private boolean rp = false;
    private boolean hp = false;
    private long bWL = 0;
    private MY cl = new MY() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1
        @Override // com.bytedance.sdk.openadsdk.core.act.MY
        public void IlO(final CustomTabsClient customTabsClient) {
            if (mmj.vCE()) {
                AdActAction.this.IlO(customTabsClient);
            } else {
                mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdActAction.this.IlO(customTabsClient);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.act.MY
        public void IlO() {
            AdActAction.this.vCE = null;
            AdActAction.this.lEW = null;
            AdActAction.this.Bc = null;
        }
    };
    public EngagementSignalsCallback IlO = new PAGEngagementSignalsCallback();
    private CustomTabsCallback cL = new PAGCustomTabsCallback();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface BindCustomTabsServiceCallback {
        void onBindFail(int i2, String str);

        void onBindSuccess(CustomTabsSession customTabsSession);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class PAGCustomTabsCallback extends CustomTabsCallback {
        public PAGCustomTabsCallback() {
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i2, @Nullable Bundle bundle) {
            if (i2 == 1) {
                AdActAction.this.ea = Long.valueOf(SystemClock.elapsedRealtime());
                if (AdActAction.this.rp || AdActAction.this.EO == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    AdActAction.this.IlO("load_start", jSONObject, 0L);
                    AdActAction.this.rp = true;
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("AdActAction", th.getMessage());
                    return;
                }
            }
            if (i2 == 2) {
                if (AdActAction.this.NV || AdActAction.this.ea == null || AdActAction.this.EO == null) {
                    return;
                }
                long jLongValue = AdActAction.this.ea.longValue() - SystemClock.elapsedRealtime();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("first_page", true);
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.put("url", AdActAction.this.Cc);
                    jSONObject2.put("preload_h5_type", AdActAction.this.EO.eVC());
                    AdActAction.this.IlO("load_finish", jSONObject2, jLongValue);
                    AdActAction.this.NV = true;
                    return;
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.oeT.EO("AdActAction", th2.getMessage());
                    return;
                }
            }
            if (i2 != 3) {
                if (i2 != 6) {
                    return;
                }
                AdActAction.this.IlO();
                if (AdActAction.this.hp || AdActAction.this.EO == null || AdActAction.this.EV || AdActAction.this.NV || AdActAction.this.ea == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.tV.EO.IlO(AdActAction.this.EO, zLG.IlO(AdActAction.this.EO), SystemClock.elapsedRealtime() - AdActAction.this.ea.longValue(), 0, 1);
                return;
            }
            if (AdActAction.this.EV || AdActAction.this.EO == null) {
                return;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("render_type", "h5");
                jSONObject3.putOpt("render_type_2", 0);
                jSONObject3.put("url", AdActAction.this.Cc);
                jSONObject3.put("preload_h5_type", AdActAction.this.EO.eVC());
                AdActAction.this.IlO("load_fail", jSONObject3, 0L);
                AdActAction.this.EV = true;
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.oeT.EO("AdActAction", th3.getMessage());
            }
        }
    }

    public AdActAction(Context context, oeT oet, String str, String str2) {
        this.MY = context;
        this.EO = oet;
        this.tV = str;
        this.Cc = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(CustomTabsClient customTabsClient) {
        this.vCE = customTabsClient;
        this.Bc = customTabsClient.newSession(this.cL);
        com.bytedance.sdk.openadsdk.ea.IlO.MY myIlO = IlO(9);
        try {
            CustomTabsSession customTabsSession = this.Bc;
            Bundle bundle = Bundle.EMPTY;
            if (customTabsSession.isEngagementSignalsApiAvailable(bundle)) {
                boolean engagementSignalsCallback = this.Bc.setEngagementSignalsCallback(this.IlO, bundle);
                myIlO.EO(1);
                IlO.IlO(1);
                if (engagementSignalsCallback) {
                    myIlO.tV(1);
                    IlO.MY(1);
                } else {
                    IlO.MY(0);
                }
            } else {
                myIlO.EO(0);
                IlO.IlO(0);
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(myIlO);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback = this.zPa;
            if (bindCustomTabsServiceCallback != null) {
                bindCustomTabsServiceCallback.onBindSuccess(this.Bc);
            }
        } catch (Throwable th) {
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.zPa;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(11, th.getMessage());
            }
        }
    }

    public void IlO(BindCustomTabsServiceCallback bindCustomTabsServiceCallback) {
        this.zPa = bindCustomTabsServiceCallback;
        if (this.MY == null || this.EO == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(8));
            String strIlO = IlO.IlO(this.MY);
            if (strIlO == null) {
                return;
            }
            ActServiceConnection actServiceConnection = new ActServiceConnection(this.cl);
            this.lEW = actServiceConnection;
            CustomTabsClient.bindCustomTabsService(this.MY, strIlO, actServiceConnection);
        } catch (Throwable th) {
            String message = th.getMessage();
            com.bytedance.sdk.component.utils.oeT.EO("AdActAction", message);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.zPa;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(10, message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO() {
        try {
            ActServiceConnection actServiceConnection = this.lEW;
            if (actServiceConnection == null) {
                return;
            }
            this.MY.unbindService(actServiceConnection);
            this.vCE = null;
            this.Bc = null;
            this.lEW = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("AdActAction", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str, final JSONObject jSONObject, final long j) {
        if (this.EO == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        oeT oet = this.EO;
        com.bytedance.sdk.openadsdk.tV.EO.IlO(jCurrentTimeMillis, oet, zLG.IlO(oet), str, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.2
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2;
                Throwable th;
                try {
                    jSONObject.put("is_playable", OOq.MY(AdActAction.this.EO) ? 1 : 0);
                    jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(AdActAction.this.EO) ? 1 : 0);
                    jSONObject2 = new JSONObject();
                } catch (Throwable th2) {
                    jSONObject2 = null;
                    th = th2;
                }
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    long j3 = j;
                    if (j3 <= 0) {
                        return jSONObject2;
                    }
                    jSONObject2.put("duration", j3);
                    return jSONObject2;
                } catch (Throwable th3) {
                    th = th3;
                    com.bytedance.sdk.component.utils.oeT.EO("AdActAction", th.getMessage());
                    return jSONObject2;
                }
            }
        });
    }

    private com.bytedance.sdk.openadsdk.ea.IlO.MY IlO(int i2) {
        com.bytedance.sdk.openadsdk.ea.IlO.MY my = new com.bytedance.sdk.openadsdk.ea.IlO.MY();
        my.IlO(this.tV);
        my.IlO(this.EO);
        my.MY(zLG.IlO(this.EO));
        my.IlO(i2);
        my.IlO(false);
        my.MY(8);
        return my;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class PAGEngagementSignalsCallback implements EngagementSignalsCallback {
        public PAGEngagementSignalsCallback() {
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onVerticalScrollEvent(boolean z2, @NonNull Bundle bundle) {
            AdActAction.this.bWL = System.currentTimeMillis();
            if (AdActAction.this.EO == null || AdActAction.this.DmF) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", AdActAction.this.Cc);
                jSONObject.put("down_time", AdActAction.this.bWL);
                long jCurrentTimeMillis = System.currentTimeMillis();
                jSONObject.put("up_time", jCurrentTimeMillis);
                com.bytedance.sdk.openadsdk.tV.EO.MY(AdActAction.this.EO, zLG.IlO(AdActAction.this.EO), "in_web_click", jSONObject, jCurrentTimeMillis - AdActAction.this.bWL);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("AdActAction", th.getMessage());
            }
            if (!TextUtils.isEmpty(oeT.IlO(AdActAction.this.MY, AdActAction.this.EO))) {
                com.bytedance.sdk.openadsdk.tV.EO.IlO(C2318f4.f8523d, AdActAction.this.EO, new NV.IlO().MY(AdActAction.this.bWL).IlO(System.currentTimeMillis()).MY(DmF.MY().IlO() ? 1 : 2).EO(BS.DmF(AdActAction.this.MY)).IlO(BS.Bc(AdActAction.this.MY)).MY(BS.lEW(AdActAction.this.MY)).IlO(), zLG.IlO(AdActAction.this.EO), true, (Map<String, Object>) new HashMap(), 2);
            }
            AdActAction.this.DmF = true;
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onGreatestScrollPercentageIncreased(int i2, @NonNull Bundle bundle) {
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onSessionEnded(boolean z2, @NonNull Bundle bundle) {
        }
    }
}
