package com.bytedance.sdk.component.adexpress.IlO.EO;

import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private Map<String, IlO> Bc = new ConcurrentHashMap();
    private MY Cc;
    private String EO;
    private String IlO;
    private String MY;
    private List<C0049IlO> tV;
    private String vCE;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.IlO.EO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0049IlO {
        private int EO;
        private String IlO;
        private String MY;

        public int EO() {
            return this.EO;
        }

        public String IlO() {
            return this.IlO;
        }

        public String MY() {
            return this.MY;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0049IlO)) {
                return super.equals(obj);
            }
            String str2 = this.IlO;
            if (str2 != null) {
                C0049IlO c0049IlO = (C0049IlO) obj;
                if (str2.equals(c0049IlO.IlO()) && (str = this.MY) != null && str.equals(c0049IlO.MY())) {
                    return true;
                }
            }
            return false;
        }

        public void IlO(String str) {
            this.IlO = str;
        }

        public void MY(String str) {
            this.MY = str;
        }

        public void IlO(int i2) {
            this.EO = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        private List<Pair<String, String>> EO;
        private String IlO;
        private String MY;

        public String IlO() {
            return this.IlO;
        }

        public void MY(String str) {
            this.MY = str;
        }

        public void IlO(String str) {
            this.IlO = str;
        }

        public List<Pair<String, String>> MY() {
            return this.EO;
        }

        public void IlO(List<Pair<String, String>> list) {
            this.EO = list;
        }
    }

    public String Bc() {
        return this.vCE;
    }

    public MY Cc() {
        return this.Cc;
    }

    public JSONObject DmF() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", MY());
            jSONObject.putOpt("version", EO());
            jSONObject.putOpt(C2300e4.h.Z, tV());
            if (!TextUtils.isEmpty(this.vCE)) {
                jSONObject.put("template_fetch_url", this.vCE);
            }
            JSONArray jSONArray = new JSONArray();
            if (vCE() != null) {
                for (C0049IlO c0049IlO : vCE()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0049IlO.IlO());
                    jSONObject2.putOpt("md5", c0049IlO.MY());
                    jSONObject2.putOpt(FirebaseAnalytics.Param.LEVEL, Integer.valueOf(c0049IlO.EO()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.Bc.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z2 = false;
                for (String str : this.Bc.keySet()) {
                    IlO ilO = this.Bc.get(str);
                    if (ilO != null) {
                        jSONObject3.put(str, ilO.DmF());
                        z2 = true;
                    }
                }
                if (z2) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            MY myCc = Cc();
            if (myCc != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", myCc.IlO);
                jSONObject4.put("md5", myCc.MY);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listMY = myCc.MY();
                if (listMY != null) {
                    for (Pair<String, String> pair : listMY) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String EO() {
        return this.MY;
    }

    public Map<String, IlO> IlO() {
        return this.Bc;
    }

    public String MY() {
        return this.IlO;
    }

    public String NV() {
        JSONObject jSONObjectDmF;
        if (!lEW() || (jSONObjectDmF = DmF()) == null) {
            return null;
        }
        return jSONObjectDmF.toString();
    }

    public boolean lEW() {
        return (TextUtils.isEmpty(tV()) || TextUtils.isEmpty(EO()) || TextUtils.isEmpty(MY())) ? false : true;
    }

    public String tV() {
        return this.EO;
    }

    public List<C0049IlO> vCE() {
        if (this.tV == null) {
            this.tV = new ArrayList();
        }
        return this.tV;
    }

    public static IlO Cc(String str) {
        if (str == null) {
            return null;
        }
        try {
            return IlO(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public void EO(String str) {
        this.EO = str;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(String str) {
        this.MY = str;
    }

    public void tV(String str) {
        this.vCE = str;
    }

    public void IlO(MY my) {
        this.Cc = my;
    }

    public void IlO(List<C0049IlO> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.tV = list;
    }

    public static IlO IlO(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        IlO ilO = new IlO();
        ilO.IlO(jSONObject.optString("name"));
        ilO.MY(jSONObject.optString("version"));
        ilO.EO(jSONObject.optString(C2300e4.h.Z));
        ilO.tV(jSONObject.optString("template_fetch_url", ""));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                C0049IlO c0049IlO = new C0049IlO();
                c0049IlO.IlO(jSONObjectOptJSONObject2.optString("url"));
                c0049IlO.MY(jSONObjectOptJSONObject2.optString("md5"));
                c0049IlO.IlO(jSONObjectOptJSONObject2.optInt(FirebaseAnalytics.Param.LEVEL));
                arrayList.add(c0049IlO);
            }
        }
        ilO.IlO(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    IlO IlO = IlO(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (IlO != null) {
                        ilO.IlO().put(next, IlO);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            MY my = new MY();
            my.IlO(jSONObjectOptJSONObject.optString("url"));
            my.MY(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    a0.n(next2, jSONObjectOptJSONObject4.optString(next2), arrayList2);
                }
                my.IlO(arrayList2);
            }
            ilO.IlO(my);
        }
        if (ilO.lEW()) {
            return ilO;
        }
        return null;
    }
}
