package com.apm.insight.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.apm.insight.e;
import com.apm.insight.l.f;
import com.apm.insight.l.j;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.n;
import com.ironsource.C2300e4;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f4429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f4430b;

    public b(File file) {
        String strA;
        File fileC = j.c(file);
        if (!fileC.exists() || fileC.length() == 0 || (strA = NativeImpl.a(fileC.getAbsolutePath())) == null) {
            return;
        }
        String[] strArrSplit = strA.split("\n");
        this.f4430b = new HashMap();
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split(C2300e4.i.f8399b);
            if (strArrSplit2.length == 2) {
                this.f4430b.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
    }

    public static String a(String str) {
        return e.g().getFilesDir() + "/apminsight/selflib/lib" + str + ".so";
    }

    public static void b(final String str) {
        m.a().a(new Runnable() { // from class: com.apm.insight.h.b.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f4431a = false;

            @Override // java.lang.Runnable
            public final void run() {
                String strA;
                b.b();
                if (b.c(str)) {
                    return;
                }
                n.a("updateSo", str);
                File file = new File(b.a(str));
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                String str2 = "doUnpackLibrary: " + str;
                if (e.i().isDebugMode()) {
                    Log.w("npth", str2);
                }
                try {
                    strA = c.a(e.g(), str, file);
                } catch (Throwable th) {
                    n.a("updateSoError", str);
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                    strA = null;
                }
                if (strA != null) {
                    if (this.f4431a) {
                        n.a("updateSoFailed", str);
                        return;
                    }
                    this.f4431a = true;
                    n.a("updateSoPostRetry", str);
                    m.a().a(this, 3000L);
                    return;
                }
                b.f4429a.put(file.getName(), "2007-20250613121539");
                try {
                    f.a(new File(e.g().getFilesDir() + "/apminsight/selflib/" + str + ".ver"), "2007-20250613121539", false);
                } catch (Throwable unused) {
                }
                n.a("updateSoSuccess", str);
            }
        });
    }

    public final boolean d() {
        Map<String, String> map = this.f4430b;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.f4430b.get("process_name")) || TextUtils.isEmpty(this.f4430b.get("crash_thread_name")) || TextUtils.isEmpty(this.f4430b.get("pid")) || TextUtils.isEmpty(this.f4430b.get(ScarConstants.TOKEN_ID_KEY)) || TextUtils.isEmpty(this.f4430b.get("start_time")) || TextUtils.isEmpty(this.f4430b.get("crash_time")) || TextUtils.isEmpty(this.f4430b.get("signal_line"))) ? false : true;
    }

    @Nullable
    public final String e() {
        return this.f4430b.get("signal_line");
    }

    public final Map<String, String> f() {
        return this.f4430b;
    }

    public static String a() {
        return e.g().getFilesDir() + "/apminsight/selflib/";
    }

    public static /* synthetic */ void b() {
        if (f4429a == null) {
            f4429a = new HashMap<>();
            File file = new File(e.g().getFilesDir(), "/apminsight/selflib/");
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    if (str.endsWith(".ver")) {
                        try {
                            f4429a.put(str.substring(0, str.length() - 4), f.a(file.getAbsolutePath() + "/" + str, "\n"));
                        } catch (Throwable th) {
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        }
                    } else if (!str.endsWith(".so")) {
                        f.a(new File(file, str));
                    }
                }
            }
        }
    }

    public static /* synthetic */ boolean c(String str) {
        return "2007-20250613121539".equals(f4429a.get(str)) && new File(a(str)).exists();
    }
}
