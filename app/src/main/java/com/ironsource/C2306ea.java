package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.ironsource.C2569t8;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ea, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2306ea {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8452b = "ea";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8453c = "supersonic_shared_preferen";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8454d = "version";
    private static final String e = "back_button_state";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8455f = "search_keys";
    private static final String g = "^\\d+_\\d+$";
    private static C2306ea h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f8456a;

    private C2306ea(Context context) {
        this.f8456a = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized C2306ea a(Context context) {
        try {
            if (h == null) {
                h = new C2306ea(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return h;
    }

    public static synchronized C2306ea e() {
        return h;
    }

    public C2569t8.a b() {
        int i2 = Integer.parseInt(this.f8456a.getString(e, "2"));
        return i2 == 0 ? C2569t8.a.None : i2 == 1 ? C2569t8.a.Device : i2 == 2 ? C2569t8.a.Controller : C2569t8.a.Controller;
    }

    public void c(String str) {
        SharedPreferences.Editor editorEdit = this.f8456a.edit();
        editorEdit.putString(e, str);
        editorEdit.apply();
    }

    public List<String> d() {
        String string = this.f8456a.getString(f8455f, null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            C2346ge c2346ge = new C2346ge(string);
            if (c2346ge.a(C2300e4.h.R)) {
                try {
                    arrayList.addAll(c2346ge.a((JSONArray) c2346ge.b(C2300e4.h.R)));
                    return arrayList;
                } catch (JSONException e4) {
                    C2531r4.d().a(e4);
                    IronLog.INTERNAL.error(e4.toString());
                }
            }
        }
        return arrayList;
    }

    public void e(String str) {
        SharedPreferences.Editor editorEdit = this.f8456a.edit();
        editorEdit.putString(f8455f, str);
        editorEdit.apply();
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f8456a.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public String c() {
        return this.f8456a.getString("version", Y1.f7808f);
    }

    public String a(String str) {
        String string = this.f8456a.getString(str, null);
        return string != null ? string : "{}";
    }

    private boolean b(String str) {
        return str.matches(g);
    }

    public boolean a(String str, String str2, String str3) {
        String string = this.f8456a.getString("ssaUserData", null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2.isNull(str3)) {
                return false;
            }
            jSONObject2.getJSONObject(str3).put("timestamp", str);
            SharedPreferences.Editor editorEdit = this.f8456a.edit();
            editorEdit.putString("ssaUserData", jSONObject.toString());
            editorEdit.apply();
            return true;
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return false;
        }
    }

    public void d(String str) {
        if (c().equalsIgnoreCase(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f8456a.edit();
        editorEdit.putString("version", str);
        editorEdit.apply();
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = (String[]) this.f8456a.getAll().keySet().toArray(new String[0]);
        SharedPreferences.Editor editorEdit = this.f8456a.edit();
        for (String str : strArr) {
            if (b(str)) {
                arrayList.add(str);
                editorEdit.remove(str);
            }
        }
        editorEdit.apply();
        return arrayList;
    }
}
