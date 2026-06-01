package com.apm.insight.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.apm.insight.runtime.m;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f4509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4510b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4511c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, String> f4512d;

    public static boolean a() {
        return f4510b;
    }

    public static boolean b() {
        return f4511c;
    }

    public static void c() {
        if (f4510b) {
            return;
        }
        f4511c = true;
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configFile");
        if (file.exists()) {
            try {
                com.apm.insight.runtime.a.a(new JSONArray(com.apm.insight.l.f.a(file, "\n")), false);
                f4510b = true;
            } catch (Throwable unused) {
                com.apm.insight.runtime.a.a((JSONArray) null, false);
            }
        }
    }

    public static void d() {
        c();
        if (g()) {
            a.a();
        }
    }

    public static void e() {
        m.a().a(new Runnable() { // from class: com.apm.insight.k.j.1
            @Override // java.lang.Runnable
            public final void run() {
                if (j.g()) {
                    a.a();
                }
            }
        });
    }

    public static void f() {
        Map<String, String> map = f4512d;
        if (map != null) {
            map.clear();
        }
    }

    public static boolean g() {
        File fileH = h();
        try {
            Map<String, String> mapC = f4512d;
            if (mapC == null) {
                mapC = com.apm.insight.l.f.c(fileH);
            }
            f4512d = mapC;
            if (mapC == null) {
                f4512d = new HashMap();
                return true;
            }
            if (mapC.size() < com.apm.insight.entity.b.c()) {
                return true;
            }
            Iterator<String> it = com.apm.insight.entity.b.d().iterator();
            while (it.hasNext()) {
                if (!f4512d.containsKey(it.next())) {
                    return true;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = false;
            for (Map.Entry<String, String> entry : f4512d.entrySet()) {
                try {
                    if (jCurrentTimeMillis - Long.decode(entry.getValue()).longValue() > com.apm.insight.runtime.d.d(entry.getKey())) {
                        z2 = true;
                    }
                } catch (Throwable th) {
                    com.apm.insight.a.a(th);
                }
            }
            if (z2) {
                com.apm.insight.a.a((Object) "config should be updated");
            } else {
                com.apm.insight.a.a((Object) "config should not be updated");
            }
            return z2;
        } catch (Throwable th2) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th2);
            return true;
        }
    }

    @NonNull
    private static File h() {
        if (f4509a == null) {
            f4509a = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configInvalid");
        }
        return f4509a;
    }

    public static void a(JSONArray jSONArray) {
        try {
            com.apm.insight.l.f.a(new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configFile"), jSONArray);
        } catch (IOException unused) {
        }
        try {
            com.apm.insight.l.f.a(h(), f4512d);
        } catch (Throwable unused2) {
        }
    }

    public static void a(String str) {
        if (f4512d == null) {
            f4512d = new HashMap();
        }
        f4512d.put(str, String.valueOf(System.currentTimeMillis()));
    }
}
