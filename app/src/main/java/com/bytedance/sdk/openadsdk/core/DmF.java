package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.sdk.openadsdk.core.EO.Bc;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF {
    public static hp IlO = null;
    public static final Set<String> MY = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.DmF.1
        {
            add("8025677");
            add("5001121");
        }
    };
    private static boolean cl = false;
    private com.bytedance.sdk.openadsdk.core.rp.EO.EO AXM;
    private int Bc;
    private String Cc;

    @Nullable
    private String DmF;
    private boolean EO;
    private int EV;

    @Nullable
    private String NV;
    private Bitmap bWL;
    private String cL;
    private Integer ea;
    private boolean es;
    private boolean hp;
    private boolean lEW;
    private volatile ConcurrentHashMap<String, Bc.IlO> oeT;
    private boolean rp;

    @NonNull
    private String tV;

    @NonNull
    private String vCE;
    private String xF;
    private int zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private static final DmF IlO = new DmF();
    }

    public static int Cc() {
        try {
            String strIlO = IlO("domain_index", LocationRequestCompat.PASSIVE_INTERVAL);
            if (TextUtils.isEmpty(strIlO)) {
                return 0;
            }
            return Integer.valueOf(strIlO).intValue();
        } catch (Throwable th) {
            th.getMessage();
            return 0;
        }
    }

    @NonNull
    public static DmF MY() {
        return IlO.IlO;
    }

    public static boolean kBB() {
        return cl;
    }

    public static void pP() {
        if (Build.VERSION.SDK_INT == 26 && "MI 6".equals(Build.MODEL)) {
            cl = true;
        }
    }

    public static int vCE() {
        try {
            String strIlO = IlO("config_fail_times", LocationRequestCompat.PASSIVE_INTERVAL);
            if (TextUtils.isEmpty(strIlO)) {
                return 0;
            }
            return Integer.valueOf(strIlO).intValue();
        } catch (Throwable th) {
            th.getMessage();
            return 0;
        }
    }

    public boolean AXM() {
        return "com.union_test.internationad".equals(zLG.Cc());
    }

    public String Bc() {
        String str = this.Cc;
        if (str != null) {
            return str;
        }
        String strIlO = IlO("mediation_info", LocationRequestCompat.PASSIVE_INTERVAL);
        this.Cc = strIlO;
        if (strIlO == null) {
            this.Cc = "";
        }
        return this.Cc;
    }

    public int DmF() {
        return com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_icon_id", "icon_id", 0) : this.Bc;
    }

    public boolean EO() {
        return com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_file", "sdk_activate_init", true);
    }

    public int EV() {
        return this.zPa;
    }

    public int NV() {
        Integer num = this.ea;
        return num != null ? num.intValue() : com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_privacy", "tt_gdpr", -1);
    }

    @Nullable
    public String bWL() {
        return com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("sp_global_file", "keywords", null) : this.DmF;
    }

    public Bitmap cL() {
        return com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.component.utils.tV.IlO(com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("sp_global_file", "pause_icon", null)) : this.bWL;
    }

    public boolean cl() {
        return true;
    }

    @Nullable
    public String ea() {
        return com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("sp_global_file", "extra_data", null) : this.NV;
    }

    public boolean es() {
        return MY.contains(this.tV);
    }

    public boolean hp() {
        return com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_file", "is_paid", false) : this.lEW;
    }

    @NonNull
    public String lEW() {
        if (TextUtils.isEmpty(this.vCE)) {
            this.vCE = IlO(cl.IlO());
        }
        return this.vCE;
    }

    public String oeT() {
        if (!TextUtils.isEmpty(this.xF)) {
            return this.xF;
        }
        String strIlO = com.bytedance.sdk.openadsdk.utils.rp.IlO();
        this.xF = strIlO;
        if (!TextUtils.isEmpty(strIlO)) {
            return this.xF;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.rp.IlO(strValueOf);
        this.xF = strValueOf;
        return strValueOf;
    }

    public boolean rp() {
        int i2 = this.zPa;
        return i2 < -1 || i2 > 1;
    }

    @Nullable
    public String tV() {
        if (TextUtils.isEmpty(this.tV)) {
            String strIlO = IlO("app_id", LocationRequestCompat.PASSIVE_INTERVAL);
            if (!TextUtils.isEmpty(strIlO)) {
                this.tV = strIlO;
            }
        }
        return this.tV;
    }

    public String tl() {
        return com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("sp_global_file", "adx_id", "") : this.cL;
    }

    public void vAh() {
        try {
            if (this.oeT == null || this.oeT.size() != 0) {
                return;
            }
            this.oeT = null;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public boolean xF() {
        return "5001121".contains(this.tV);
    }

    public com.bytedance.sdk.openadsdk.core.rp.EO.EO zPa() {
        if (this.AXM == null) {
            this.AXM = new com.bytedance.sdk.openadsdk.core.rp.EO.EO(10, 8);
        }
        return this.AXM;
    }

    private DmF() {
        this.EO = false;
        this.EV = 0;
        this.rp = true;
        this.hp = false;
        this.bWL = null;
        this.ea = null;
        this.zPa = -1;
        this.oeT = null;
    }

    private static void EV(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 1000) {
            return;
        }
        hp hpVar = IlO;
        if (hpVar != null) {
            hpVar.fail(4000, "Data is very long, the longest is 1000");
        }
        com.bytedance.sdk.component.utils.oeT.EO("TTAD.GlobalInfo", "Data is very long, the longest is 1000");
    }

    private static JSONObject rp(String str) {
        String strMY = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("sp_global_file", str, null);
        if (TextUtils.isEmpty(strMY)) {
            return null;
        }
        try {
            return new JSONObject(strMY);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public void EO(int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_icon_id", "icon_id", Integer.valueOf(i2));
        }
        this.Bc = i2;
    }

    public void MY(boolean z2) {
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_file", "sdk_activate_init", Boolean.valueOf(z2));
    }

    public static void IlO(hp hpVar) {
        IlO = hpVar;
    }

    public static void MY(int i2) {
        if (i2 >= 0) {
            IlO("config_fail_times", String.valueOf(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DmF(String str) {
        if (!TextUtils.isEmpty(this.NV)) {
            try {
                HashMap map = new HashMap();
                JSONArray jSONArray = new JSONArray(this.NV);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("name");
                        if (!TextUtils.isEmpty(strOptString)) {
                            map.put(strOptString, jSONObjectOptJSONObject);
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray(str);
                for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i8);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString2 = jSONObjectOptJSONObject2.optString("name");
                        String strOptString3 = jSONObjectOptJSONObject2.optString("value");
                        if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                            map.put(strOptString2, jSONObjectOptJSONObject2);
                        }
                    }
                }
                Collection collectionValues = map.values();
                JSONArray jSONArray3 = new JSONArray();
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    jSONArray3.put((JSONObject) it.next());
                }
                this.NV = jSONArray3.toString();
            } catch (Throwable th) {
                th.getMessage();
            }
        } else {
            this.NV = str;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_file", "extra_data", this.NV);
        }
    }

    private static void NV(String str) {
        hp hpVar;
        if (TextUtils.isEmpty(str) && (hpVar = IlO) != null) {
            hpVar.fail(4000, "appid cannot be empty");
        }
        com.bytedance.sdk.component.utils.oeT.EO("TTAD.GlobalInfo", "appid cannot be empty");
    }

    public boolean IlO() {
        return this.es;
    }

    public void MY(String str) {
        this.Cc = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IlO("mediation_info", str);
    }

    public void lEW(String str) {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_file", "adx_id", str);
        }
        this.cL = str;
    }

    public static boolean Bc(String str) {
        return (TextUtils.isEmpty(str) || !com.bytedance.sdk.openadsdk.utils.tl.IlO || str.contains("sp_full_screen_video") || str.contains("sp_reward_video") || str.contains("tt_openad") || str.contains("pag_sp_bad_par")) ? false : true;
    }

    public void Cc(int i2) {
        this.zPa = i2;
    }

    public void EO(@Nullable final String str) {
        EV(str);
        if (mmj.vCE()) {
            bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.DmF.3
                @Override // java.lang.Runnable
                public void run() {
                    DmF.this.DmF(str);
                }
            });
        } else {
            DmF(str);
        }
    }

    public void IlO(boolean z2) {
        this.es = z2;
    }

    public void vCE(int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_file", "title_bar_theme", Integer.valueOf(i2));
        }
        this.EV = i2;
    }

    public static void IlO(int i2) {
        if (i2 >= 0) {
            IlO("domain_index", String.valueOf(i2));
        }
    }

    public Bc.IlO Cc(String str) {
        try {
            if (this.oeT == null || str == null) {
                return null;
            }
            return this.oeT.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void tV(final int i2) {
        if (i2 == 1) {
            i2 = 0;
        } else if (i2 == 0) {
            i2 = 1;
        }
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            final Integer num = this.ea;
            if (num == null || num.intValue() != i2) {
                this.ea = Integer.valueOf(i2);
                if (!mmj.vCE()) {
                    IlO(num, i2);
                } else {
                    bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.DmF.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DmF.this.IlO(num, i2);
                        }
                    });
                }
            }
        }
    }

    public void IlO(@NonNull String str) {
        NV(str);
        this.tV = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IlO("app_id", str);
        com.bytedance.sdk.openadsdk.core.settings.hp.aP().tV(7);
    }

    public void vCE(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                com.bytedance.sdk.openadsdk.EO.NV.IlO(6, str);
            } else if (this.oeT != null) {
                this.oeT.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void EO(boolean z2) {
        this.EO = z2;
    }

    private String IlO(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static Pair<String, Long> tV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectRp = rp(str);
            if (jSONObjectRp == null) {
                return null;
            }
            return new Pair<>(jSONObjectRp.getString("value"), Long.valueOf(jSONObjectRp.getLong(InfluenceConstants.TIME)));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(Integer num, int i2) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_privacy", "tt_gdpr", Integer.valueOf(i2));
            com.bytedance.sdk.openadsdk.core.settings.hp.aP().IlO(4, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_privacy", "tt_gdpr", -1) != i2) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_privacy", "tt_gdpr", Integer.valueOf(i2));
            com.bytedance.sdk.openadsdk.core.settings.hp.aP().IlO(4, true);
        }
    }

    public static void IlO(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put(InfluenceConstants.TIME, System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("sp_global_file", str, jSONObject.toString());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.GlobalInfo", e.getMessage());
        }
    }

    public static String IlO(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectRp = rp(str);
            if (jSONObjectRp == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectRp.getLong(InfluenceConstants.TIME) <= j) {
                return jSONObjectRp.getString("value");
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.GlobalInfo", e.getMessage());
        }
        return null;
    }

    public void IlO(String str, Bc.IlO ilO) {
        try {
            if (TextUtils.isEmpty(str) || ilO == null) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                com.bytedance.sdk.openadsdk.EO.NV.IlO(6, str, ilO);
                return;
            }
            if (this.oeT == null) {
                synchronized (DmF.class) {
                    try {
                        if (this.oeT == null) {
                            this.oeT = new ConcurrentHashMap<>();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (this.oeT != null) {
                this.oeT.put(str, ilO);
            }
        } catch (Throwable unused) {
        }
    }
}
