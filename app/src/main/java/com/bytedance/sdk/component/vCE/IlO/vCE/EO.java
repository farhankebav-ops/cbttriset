package com.bytedance.sdk.component.vCE.IlO.vCE;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements MY {
    private final Context IlO;
    private final Cc MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO extends com.bytedance.sdk.component.vCE.IlO.Cc.Cc {
        private final String EO;
        private final tV MY;
        private final Map<String, String> tV;

        private String EO(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.EO)) ? str.replace("{UID}", this.EO).replace("__UID__", this.EO) : str;
        }

        public boolean IlO(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        public String MY(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(EO.EO().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.vCE.IlO.Cc.tV tVVarIlO;
            com.bytedance.sdk.component.vCE.IlO.Cc ccZPa = lEW.Bc().zPa();
            if (ccZPa == null || lEW.Bc().vCE() == null || !ccZPa.EO() || !IlO(this.MY.MY())) {
                return;
            }
            if (this.MY.tV() >= ccZPa.EO(this.MY.vCE())) {
                EO.this.MY.EO(this.MY);
                return;
            }
            try {
                ccZPa.hp();
                if (this.MY.EV()) {
                    EO.this.MY.IlO(this.MY);
                }
                if (ccZPa.IlO(EO.this.IlO())) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strMY = this.MY.MY();
                    if (ccZPa.vCE() == 0) {
                        strMY = EO(this.MY.MY());
                        if (this.MY.EO()) {
                            strMY = MY(strMY);
                        }
                    }
                    com.bytedance.sdk.component.vCE.IlO.Cc.EO eoNV = ccZPa.NV();
                    if (eoNV == null) {
                        return;
                    }
                    eoNV.IlO("User-Agent", ccZPa.DmF());
                    eoNV.IlO("csj_client_source_from", "1");
                    if (this.tV != null) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : this.tV.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        eoNV.IlO("csj_extra_info", jSONObject.toString());
                    }
                    eoNV.IlO(strMY);
                    try {
                        tVVarIlO = eoNV.IlO();
                        try {
                            ccZPa.IlO(tVVarIlO.IlO());
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        tVVarIlO = null;
                    }
                    tV tVVar = this.MY;
                    tVVar.IlO(tVVar.tV() + 1);
                    if (tVVarIlO != null && tVVarIlO.IlO()) {
                        EO.this.MY.EO(this.MY);
                        this.MY.MY();
                        ccZPa.IlO(true, 200, System.currentTimeMillis() - jCurrentTimeMillis, this.MY);
                        return;
                    }
                    if (tVVarIlO != null) {
                        this.MY.MY(tVVarIlO.MY());
                        this.MY.EO(tVVarIlO.EO());
                    }
                    if (tVVarIlO == null || tVVarIlO.MY() != 8848) {
                        this.MY.MY();
                        if (this.MY.tV() >= ccZPa.EO(this.MY.vCE())) {
                            EO.this.MY.EO(this.MY);
                            this.MY.MY();
                        } else {
                            EO.this.MY.MY(this.MY);
                        }
                    } else {
                        tVVarIlO.EO();
                        EO.this.MY.EO(this.MY);
                    }
                    ccZPa.IlO(false, this.MY.lEW(), System.currentTimeMillis() - jCurrentTimeMillis, this.MY);
                }
            } catch (Throwable unused3) {
            }
        }

        private IlO(tV tVVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.MY = tVVar;
            this.EO = str;
            this.tV = map;
        }
    }

    public EO(Context context, Cc cc) {
        this.IlO = context;
        this.MY = cc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random EO() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public Context IlO() {
        Context context = this.IlO;
        return context == null ? lEW.Bc().vCE() : context;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.MY
    public void IlO(String str, List<String> list, boolean z2, Map<String, String> map, int i2, String str2) {
        com.bytedance.sdk.component.vCE.IlO.Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || lEW.Bc().vCE() == null || ccZPa.tV() == null || !ccZPa.EO() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ccZPa.tV().execute(new IlO(new tV(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z2, i2, str2), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.MY
    public Runnable IlO(final tV tVVar, final String str, final Map<String, String> map) {
        if (tVVar == null || TextUtils.isEmpty(tVVar.IlO())) {
            return null;
        }
        return new Runnable() { // from class: com.bytedance.sdk.component.vCE.IlO.vCE.EO.1
            @Override // java.lang.Runnable
            public void run() {
                if (EO.this.MY.IlO(tVVar.IlO()) != null) {
                    new IlO(tVVar, str, map).run();
                }
            }
        };
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.MY
    public void IlO(final String str, final boolean z2) {
        com.bytedance.sdk.component.vCE.IlO.Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || lEW.Bc().vCE() == null || !ccZPa.EO()) {
            return;
        }
        com.bytedance.sdk.component.vCE.IlO.Cc.Cc cc = new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("trackFailedUrls") { // from class: com.bytedance.sdk.component.vCE.IlO.vCE.EO.2
            @Override // java.lang.Runnable
            public void run() {
                EO.this.IlO(EO.this.MY.IlO(), str, z2);
            }
        };
        cc.IlO(1);
        if (ccZPa.tV() != null) {
            ccZPa.tV().execute(cc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(List<tV> list, String str, boolean z2) {
        String str2;
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.vCE.IlO.Cc ccZPa = lEW.Bc().zPa();
        for (tV tVVar : list) {
            if (ccZPa == null || ccZPa.tV() == null) {
                str2 = str;
            } else {
                tVVar.IlO(z2);
                str2 = str;
                ccZPa.tV().execute(new IlO(tVVar, str2, null));
            }
            str = str2;
        }
    }
}
