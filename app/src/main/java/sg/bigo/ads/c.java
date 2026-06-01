package sg.bigo.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: sg.bigo.ads.c$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15548a;

        static {
            int[] iArr = new int[ConsentOptions.values().length];
            f15548a = iArr;
            try {
                iArr[ConsentOptions.LGPD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15548a[ConsentOptions.CCPA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15548a[ConsentOptions.COPPA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15548a[ConsentOptions.GDPR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class a {
        private static final List<a> h = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15552d;
        private final String e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f15553f;
        private final String g;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f15549a = str;
            this.f15550b = str2;
            this.f15551c = str3;
            this.f15552d = str4;
            this.e = str5;
            this.f15553f = str6;
            this.g = str7;
        }

        public static List<a> a() {
            return h;
        }

        public static JSONObject b(a aVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("consent_type", aVar.f15549a);
                jSONObject.put("last_status", aVar.f15550b);
                jSONObject.put("cur_status", aVar.f15551c);
                jSONObject.put("get_token", aVar.f15552d);
                jSONObject.put("tcf_applias", aVar.e);
                jSONObject.put("tcf_purpose", aVar.f15553f);
                jSONObject.put("tcf_interests", aVar.g);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public static Map<String, String> c() {
            HashMap map = new HashMap();
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = h.iterator();
            while (it.hasNext()) {
                jSONArray.put(b(it.next()));
            }
            map.put("user_consent_event", jSONArray.toString());
            map.put("uuid", sg.bigo.ads.common.x.a.r());
            return map;
        }

        public static void a(a aVar) {
            h.add(aVar);
        }

        public static void b() {
            h.clear();
        }
    }
}
