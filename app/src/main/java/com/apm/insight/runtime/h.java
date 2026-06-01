package com.apm.insight.runtime;

import android.text.TextUtils;
import com.apm.insight.b.h;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h.a f4637a;

    public static void a(h.a aVar) {
        f4637a = aVar;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0031: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:50), block:B:10:0x0031 */
    private static JSONArray b(String str) throws Throwable {
        Closeable closeable;
        BufferedReader bufferedReader;
        JSONArray jSONArray;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                jSONArray = new JSONArray();
                bufferedReader = new BufferedReader(new FileReader(str));
            } catch (IOException e) {
                e = e;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                com.apm.insight.a.a(closeable2);
                throw th;
            }
            try {
                File file = new File(str);
                if (file.length() > 512000) {
                    bufferedReader.skip(file.length() - 512000);
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        com.apm.insight.a.a((Closeable) bufferedReader);
                        return jSONArray;
                    }
                    jSONArray.put(line);
                }
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                com.apm.insight.a.a((Closeable) bufferedReader);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    public static JSONArray a(String str) {
        if (!com.apm.insight.e.v()) {
            return null;
        }
        if (f4637a != null && com.apm.insight.e.f().equals(str)) {
            try {
                return b(f4637a.b());
            } catch (Throwable th) {
                com.apm.insight.c.a();
                j.a(th, "NPTH_CATCH");
            }
        }
        try {
            return b(com.apm.insight.a.a(str, com.apm.insight.e.i().getLogcatDumpCount(), com.apm.insight.e.i().getLogcatLevel()).getAbsolutePath());
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
            return null;
        }
    }
}
