package com.ironsource;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.dd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2291dd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8234a = "com.google.market";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8235b = "com.android.vending";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8236c = "isInstalled";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8237d = "dd";
    private static final ArrayList<String> e = new a();

    /* JADX INFO: renamed from: com.ironsource.dd$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends ArrayList<String> {
        public a() {
            add(C2291dd.f8234a);
            add("com.android.vending");
        }
    }

    /* JADX INFO: renamed from: com.ironsource.dd$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends JSONObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8238a;

        public b(boolean z2) throws JSONException {
            this.f8238a = z2;
            put("isInstalled", z2);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.dd$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum c {
        GOOGLE_PLAY(2, new String[]{"com.android.vending"}),
        GOOGLE_MARKET(4, new String[]{C2291dd.f8234a}),
        SAMSUNG(5, new String[]{"com.sec.android.app.samsungapps"}),
        AMAZON(6, new String[]{"com.amazon.venezia"}),
        HUAWEI(7, new String[]{"com.huawei.appmarket"});

        private static final Map<String, c> h = new HashMap();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f8244b;

        static {
            for (c cVar : values()) {
                for (String str : cVar.d()) {
                    h.put(str, cVar);
                }
            }
        }

        c(int i2, String[] strArr) {
            this.f8243a = i2;
            this.f8244b = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c() {
            return this.f8243a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String[] d() {
            return this.f8244b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<String> b() {
            return new ArrayList<>(h.keySet());
        }
    }

    private static JSONObject a(Context context) {
        return a(context, e);
    }

    private static ArrayList<String> b(Context context) {
        List<ApplicationInfo> listH = Mb.U().i().H(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : listH) {
            if (applicationInfo != null) {
                arrayList.add(applicationInfo.packageName.toLowerCase(Locale.getDefault()));
            }
        }
        return arrayList;
    }

    public static Integer c(Context context) {
        JSONObject jSONObjectA = a(context, c.b());
        int iPow = 0;
        for (c cVar : c.values()) {
            String[] strArrD = cVar.d();
            int length = strArrD.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(strArrD[i2]);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("isInstalled")) {
                    iPow = (int) (Math.pow(2.0d, r5.c() - 1) + ((double) iPow));
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(iPow);
    }

    public static boolean d(Context context) {
        JSONObject jSONObjectA = a(context);
        Iterator<String> itKeys = jSONObjectA.keys();
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> arrayListB = b(context);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                String str = arrayList.get(i2);
                i2++;
                String str2 = str;
                jSONObject.put(str2, a(arrayListB.contains(str2.trim().toLowerCase(Locale.getDefault()))));
            }
            return jSONObject;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            Log.d(f8237d, "Error while extracting packages installation data");
            return jSONObject;
        }
    }

    private static JSONObject a(boolean z2) throws JSONException {
        return new b(z2);
    }
}
