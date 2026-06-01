package com.bytedance.sdk.openadsdk.core.EV.MY;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.wPn;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.EV.MY.IlO;
import com.bytedance.sdk.openadsdk.core.EV.MY.MY;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static final Map<String, MY> Cc = new ConcurrentHashMap();
    private static final AtomicBoolean vCE = new AtomicBoolean(false);
    private boolean EO;
    private final String IlO;
    private EnumC0085EO MY;
    private boolean tV;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.EV.MY.EO$EO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum EnumC0085EO {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private final String IlO;
        private EnumC0085EO MY = EnumC0085EO.TRACKING_URL;
        private boolean EO = false;

        public IlO(String str) {
            this.IlO = str;
        }

        public IlO IlO(boolean z2) {
            this.EO = z2;
            return this;
        }

        public EO IlO() {
            return new EO(this.IlO, this.MY, Boolean.valueOf(this.EO));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        float EO;
        String IlO;
        oeT MY;

        public MY(String str, oeT oet) {
            this(str, oet, -1.0f);
        }

        public MY(String str, oeT oet, float f4) {
            this.IlO = str;
            this.MY = oet;
            this.EO = f4;
        }
    }

    static {
        wPn.IlO(new wPn.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EV.MY.EO.1
            @Override // com.bytedance.sdk.component.utils.wPn.IlO
            public void IlO(Context context, Intent intent, boolean z2, int i2) {
                if (i2 == 0 || EO.Cc.size() <= 0) {
                    return;
                }
                EO.MY();
            }
        }, cl.IlO());
    }

    public EO(String str, EnumC0085EO enumC0085EO, Boolean bool) {
        this.IlO = str;
        this.MY = enumC0085EO;
        this.EO = bool.booleanValue();
    }

    public static void MY(@NonNull List<EO> list, @Nullable com.bytedance.sdk.openadsdk.core.EV.IlO.IlO ilO, @Nullable long j, @Nullable String str) {
        IlO(list, ilO, j, str, null);
    }

    public boolean Cc() {
        return this.tV;
    }

    public String EO() {
        return this.IlO;
    }

    public void k_() {
        this.tV = true;
    }

    public boolean tV() {
        return this.EO;
    }

    public static List<com.bytedance.sdk.openadsdk.core.EV.MY.IlO> EO(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new IlO.C0086IlO(jSONObjectOptJSONObject.optString("content"), jSONObjectOptJSONObject.optLong("trackingMilliseconds", 0L)).IlO());
                }
            }
        }
        return arrayList;
    }

    public static List<String> IlO(@NonNull List<EO> list, @Nullable com.bytedance.sdk.openadsdk.core.EV.IlO.IlO ilO, @Nullable long j, @Nullable String str) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (EO eo : list) {
            if (eo != null && (!eo.Cc() || eo.tV())) {
                arrayList.add(eo.EO());
                eo.k_();
            }
        }
        return new com.bytedance.sdk.openadsdk.core.EV.EO.EO(arrayList).IlO(ilO).IlO(j).IlO(str).IlO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY() {
        if (vCE.compareAndSet(false, true)) {
            Map<String, MY> map = Cc;
            HashSet<Map.Entry> hashSet = new HashSet(map.entrySet());
            map.clear();
            for (Map.Entry entry : hashSet) {
                if (entry != null) {
                    IlO((String) entry.getKey(), (MY) entry.getValue(), true);
                }
            }
            vCE.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(final boolean z2, final String str, final String str2, final MY my, final String str3, final boolean z7) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(new lEW("dsp_track_link_result") { // from class: com.bytedance.sdk.openadsdk.core.EV.MY.EO.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", my.IlO);
                    jSONObject.put("success", z2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("description", str);
                    }
                    jSONObject.put("url", str3);
                    float f4 = my.EO;
                    if (f4 >= 0.0f) {
                        jSONObject.put("progress", ((double) Math.round(f4 * 100.0f)) / 100.0d);
                    }
                    if (z7) {
                        jSONObject.put("retry", true);
                    }
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.tV.EO.MY(my.MY, str2, "dsp_track_link_result", jSONObject);
            }
        });
    }

    public static List<com.bytedance.sdk.openadsdk.core.EV.MY.MY> MY(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new MY.IlO(jSONObjectOptJSONObject.optString("content"), (float) jSONObjectOptJSONObject.optDouble("trackingFraction", 0.0d)).IlO());
                }
            }
        }
        return arrayList;
    }

    public static void IlO(@NonNull List<EO> list, @Nullable com.bytedance.sdk.openadsdk.core.EV.IlO.IlO ilO, @Nullable long j, @Nullable String str, MY my) {
        IlO(IlO(list, ilO, j, str), my);
    }

    public static void IlO(List<String> list, MY my) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (!TextUtils.isEmpty(str)) {
                IlO(str, my, false);
            }
        }
    }

    private static void IlO(final String str, final MY my, final boolean z2) {
        com.bytedance.sdk.component.Bc.MY.MY myEO = Bc.IlO().MY().EO();
        if (myEO == null) {
            return;
        }
        myEO.IlO(true);
        myEO.MY(str);
        myEO.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EV.MY.EO.2
            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my2) {
                boolean z7;
                MY my3 = my;
                if (my3 == null || my3.MY == null) {
                    return;
                }
                String str2 = null;
                if (my2 == null || !my2.vCE()) {
                    z7 = false;
                    if (my2 != null) {
                        str2 = my2.IlO() + ":" + my2.MY();
                        if (!z2 && (my2.IlO() <= 300 || my2.IlO() >= 400)) {
                            EO.Cc.put(str, my);
                        }
                    }
                } else {
                    z7 = true;
                }
                EO.MY(z7, str2, zLG.EO(my.MY.OyN()), my, str, z2);
                if (my2 == null || my2.IlO() != 200 || EO.Cc.size() <= 0) {
                    return;
                }
                EO.MY();
            }

            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                oeT oet;
                MY my2 = my;
                if (my2 != null && (oet = my2.MY) != null) {
                    EO.MY(false, iOException != null ? iOException.getMessage() : null, zLG.EO(oet.OyN()), my, str, z2);
                }
                if (z2 || my == null) {
                    return;
                }
                EO.Cc.put(str, my);
            }
        });
    }

    public static JSONArray IlO(List<EO> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            jSONArray.put(list.get(i2).EO());
        }
        return jSONArray;
    }

    public static List<EO> IlO(JSONArray jSONArray) {
        return IlO(jSONArray, false);
    }

    public static List<EO> IlO(JSONArray jSONArray, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(new IlO(strOptString).IlO(z2).IlO());
                }
            }
        }
        return arrayList;
    }
}
