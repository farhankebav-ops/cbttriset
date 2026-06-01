package com.apm.insight.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.l.f;
import com.apm.insight.l.m;
import com.ironsource.C2605va;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<com.apm.insight.d> f4386a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a(JSONObject jSONObject);
    }

    static {
        new ConcurrentHashMap();
    }

    public static void a(@NonNull com.apm.insight.d dVar) {
        f4386a.add(dVar);
    }

    @NonNull
    public static JSONArray b() {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f4386a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.a((CrashType) null, (JSONArray) null));
        }
        return jSONArray;
    }

    public static int c() {
        return f4386a.size();
    }

    public static List<String> d() {
        com.apm.insight.d next;
        ArrayList arrayList = new ArrayList();
        Iterator<com.apm.insight.d> it = f4386a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next.b());
        }
        return arrayList;
    }

    public static File a(File file) {
        return new File(file, "all_data.json");
    }

    @Nullable
    public static JSONArray a(Throwable th, Thread thread, @Nullable File file) {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] stackTraceElementArrB = m.b(th);
        Iterator<com.apm.insight.d> it = f4386a.iterator();
        while (true) {
            if (!it.hasNext() || (next = it.next()) == null) {
                break;
            }
            if (!com.apm.insight.runtime.a.a(next.b())) {
                com.apm.insight.a.a((Object) ("not enable javaCrash aid: " + next.b()));
            } else {
                JSONArray jSONArrayA = next.a(stackTraceElementArrB, th, thread != null ? thread.getName() : null);
                if (!com.apm.insight.a.a(jSONArrayA)) {
                    jSONArray.put(next.a(CrashType.JAVA, jSONArrayA));
                }
            }
        }
        if (com.apm.insight.a.a(jSONArray)) {
            return null;
        }
        try {
            f.a(new File(file, "all_data.json"), jSONArray);
        } catch (IOException unused) {
        }
        return jSONArray;
    }

    @Nullable
    public static String b(Object obj) {
        for (com.apm.insight.d dVar : f4386a) {
            if (dVar != null && dVar.a(obj)) {
                return dVar.b();
            }
        }
        return null;
    }

    @NonNull
    public static JSONArray a(String str) {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        String[] strArrSplit = str.split("\n");
        Iterator<com.apm.insight.d> it = f4386a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.b(next.b())) {
                JSONArray jSONArrayA = next.a(strArrSplit);
                if (!com.apm.insight.a.a(jSONArrayA)) {
                    jSONArray.put(next.a(CrashType.ANR, jSONArrayA));
                }
            }
        }
        return jSONArray;
    }

    @NonNull
    public static JSONArray a() {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f4386a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.c());
        }
        return jSONArray;
    }

    @NonNull
    public static JSONArray a(Object obj) {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f4386a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.apm.insight.d next = it.next();
            if (next != null && next.a(obj)) {
                jSONArray.put(next.a(CrashType.JAVA, (JSONArray) null));
                break;
            }
        }
        return jSONArray;
    }

    public static JSONArray a(Object obj, Throwable th, StackTraceElement[] stackTraceElementArr) {
        for (com.apm.insight.d dVar : f4386a) {
            if (dVar != null && dVar.a(obj)) {
                JSONArray jSONArrayA = dVar.a(stackTraceElementArr, th);
                JSONArray jSONArray = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C2605va.f10440b, dVar.b());
                    jSONObject.put("lines", jSONArrayA);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
                return jSONArray;
            }
        }
        return null;
    }

    @NonNull
    public static JSONArray a(String str, String str2, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("header")) != null && com.apm.insight.runtime.a.c(String.valueOf(jSONObjectOptJSONObject.opt(C2605va.f10440b)))) {
                if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("package"))) {
                    jSONArray2.put(jSONObjectOptJSONObject2);
                } else if (a(str, jSONObjectOptJSONObject.optJSONArray("so_list"), str2, jSONObjectOptJSONObject.optJSONArray("so_list"))) {
                    jSONArray2.put(jSONObjectOptJSONObject2);
                }
            }
        }
        return jSONArray2;
    }

    public static boolean a(String str, JSONArray jSONArray, String str2, JSONArray jSONArray2) {
        if (!com.apm.insight.a.a(jSONArray)) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (str.contains(jSONArray.optString(i2))) {
                    return true;
                }
            }
        }
        if (!com.apm.insight.a.a(jSONArray2)) {
            for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                String strOptString = jSONArray2.optString(i8);
                if (strOptString != null && strOptString.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray, a aVar) {
        JSONObject jSONObjectOptJSONObject;
        com.apm.insight.a.a((Object) "uploadFromFile with allData ".concat(String.valueOf(jSONArray)));
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length() && (jSONObjectOptJSONObject = jSONArray.optJSONObject(i2)) != null; i2++) {
            if (com.apm.insight.a.a(jSONObjectOptJSONObject, 0, "header", "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                com.apm.insight.entity.a.b(jSONObject2, jSONObject);
                com.apm.insight.entity.a.b(jSONObject2, jSONObjectOptJSONObject);
                aVar.a(jSONObject2);
            } else {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        if (jSONArray2.length() == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        com.apm.insight.entity.a.b(jSONObject3, jSONObject);
        try {
            jSONObject3.put("all_data", jSONArray2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.a(jSONObject3);
    }
}
