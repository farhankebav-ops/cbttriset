package com.apm.insight.k;

import android.content.Context;
import androidx.annotation.NonNull;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.n;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f4479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f4480b;

    private d(@NonNull Context context) {
        this.f4480b = context;
    }

    public static d a() {
        if (f4479a == null) {
            f4479a = new d(com.apm.insight.e.g());
        }
        return f4479a;
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strF = e.f();
            File file = new File(com.apm.insight.l.j.a(this.f4480b), com.apm.insight.l.j.c());
            com.apm.insight.l.f.a(file, file.getName(), strF, jSONObject, e.b());
            if (e.a(strF, jSONObject.toString()).a()) {
                com.apm.insight.l.f.a(file);
            }
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
        }
    }

    public final void c(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        m.a().a(new Runnable() { // from class: com.apm.insight.k.d.1
            @Override // java.lang.Runnable
            public final void run() {
                String strC = e.c();
                try {
                    jSONObject.put("upload_scene", "direct");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                e.b(strC, jSONObject.toString());
            }
        });
    }

    public static boolean a(JSONObject jSONObject, File file, File file2) {
        try {
            return e.a(e.g(), jSONObject.toString(), file, file2, n.a(System.currentTimeMillis()), new File(com.apm.insight.h.b.a())).a();
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
            return false;
        }
    }

    public final void a(JSONObject jSONObject, long j, boolean z2) {
        File[] fileArr;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strC = e.c();
            int i2 = 0;
            File file = new File(com.apm.insight.l.j.a(this.f4480b), com.apm.insight.e.a(j, CrashType.ANR, false, false));
            com.apm.insight.l.f.a(file, file.getName(), strC, jSONObject, e.b());
            if (z2 && !Npth.isStopUpload()) {
                jSONObject.put("upload_scene", "direct");
                jSONObject.put("crash_uuid", file.getName());
                if (com.apm.insight.runtime.a.h()) {
                    HashMap<String, n.a> mapA = n.a(j, "anr_trace");
                    fileArr = new File[mapA.size() + 2];
                    for (Map.Entry<String, n.a> entry : mapA.entrySet()) {
                        if (!entry.getKey().equals(com.apm.insight.l.a.c(this.f4480b))) {
                            fileArr[i2] = com.apm.insight.l.j.a(this.f4480b, entry.getValue().f4658a);
                            i2++;
                        }
                    }
                } else {
                    fileArr = new File[2];
                }
                fileArr[fileArr.length - 1] = com.apm.insight.l.j.a(this.f4480b, com.apm.insight.e.f());
                fileArr[fileArr.length - 2] = n.a(j);
                if (e.a(strC, jSONObject.toString(), fileArr).a()) {
                    com.apm.insight.l.f.a(file);
                    if (Npth.hasCrash()) {
                        return;
                    }
                    com.apm.insight.l.f.a(com.apm.insight.l.j.e(com.apm.insight.e.g()));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String strC = e.c();
                File file = new File(com.apm.insight.l.j.a(this.f4480b), com.apm.insight.l.j.a(com.apm.insight.e.e()));
                com.apm.insight.l.f.a(file, file.getName(), strC, jSONObject, e.a());
                jSONObject.put("upload_scene", "direct");
                if (!e.b(strC, jSONObject.toString()).a()) {
                    return false;
                }
                com.apm.insight.l.f.a(file);
                return true;
            } catch (Throwable th) {
                com.apm.insight.a.b(th);
            }
        }
        return false;
    }
}
