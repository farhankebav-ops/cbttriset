package com.apm.insight.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.b.h;
import com.apm.insight.b.i;
import com.apm.insight.nativecrash.NativeImpl;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4646a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4647b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4648c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4649d = false;
    private static boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static c f4650f = new c();
    private static volatile boolean g = false;
    private static boolean h = false;

    public static c a() {
        return f4650f;
    }

    public static boolean b() {
        return f4647b;
    }

    public static boolean c() {
        return f4648c;
    }

    public static boolean d() {
        return f4649d;
    }

    public static boolean e() {
        return f4646a;
    }

    public static void f() {
        if (!f4646a || f4647b) {
            return;
        }
        Context contextG = com.apm.insight.e.g();
        com.apm.insight.g.a aVarA = com.apm.insight.g.a.a();
        aVarA.a(new com.apm.insight.i.b(contextG));
        aVarA.b(new com.apm.insight.g.d(contextG));
    }

    public static void g() {
        if (f4646a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).c();
            f4648c = true;
        }
    }

    public static boolean h() {
        if (f4646a && !f4649d) {
            boolean zA = NativeImpl.a(com.apm.insight.e.g());
            f4649d = zA;
            if (!zA) {
                e = true;
            }
        }
        return f4649d;
    }

    public static boolean i() {
        return com.apm.insight.b.c.c();
    }

    public static void j() {
        if (f4646a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).d();
            f4648c = false;
        }
    }

    public static void k() {
        NativeImpl.c();
    }

    public static boolean l() {
        return com.apm.insight.g.a.b() || NativeImpl.e();
    }

    public static boolean m() {
        return com.apm.insight.g.a.c() || NativeImpl.e();
    }

    public static boolean n() {
        return com.apm.insight.g.a.b();
    }

    public static boolean o() {
        return h;
    }

    public static void p() {
        h = true;
    }

    public static /* synthetic */ boolean r() {
        g = true;
        return true;
    }

    public static synchronized void a(@NonNull Context context) {
        Application applicationH;
        try {
            if (com.apm.insight.e.h() != null) {
                applicationH = com.apm.insight.e.h();
            } else if (context instanceof Application) {
                applicationH = (Application) context;
                if (applicationH.getBaseContext() == null) {
                    throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                }
            } else {
                applicationH = (Application) context.getApplicationContext();
                if (applicationH == null) {
                    throw new IllegalArgumentException("Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.");
                }
                if (applicationH.getBaseContext() != null) {
                    context = applicationH.getBaseContext();
                }
            }
            a(applicationH, context);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public static void b(String str) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.c(str);
        }
    }

    public static void c(String str) {
        NativeImpl.b(str);
    }

    public static void d(boolean z2) {
        com.apm.insight.e.d(z2);
    }

    public static /* synthetic */ void e(boolean z2) {
        Context contextG = com.apm.insight.e.g();
        com.apm.insight.runtime.a.f.a();
        j.a();
        int iB = NativeImpl.b();
        NativeImpl.d();
        if (e) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("NativeLibraryLoad faild");
        } else if (iB < 0) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("createCallbackThread faild");
        }
        com.apm.insight.e.a.a().a(contextG);
        com.apm.insight.c.a();
        com.apm.insight.k.h.a(contextG);
        if (z2) {
            com.apm.insight.b.f.a(contextG).c();
            f4648c = z2;
        }
        com.apm.insight.k.g.a().b();
        NativeImpl.g();
        com.apm.insight.k.j.d();
        NativeImpl.k();
        n.a("afterNpthInitAsync", "noValue");
    }

    public static void c(boolean z2) {
        com.apm.insight.e.c(z2);
    }

    public static void b(h.a aVar) {
        com.apm.insight.k.e.a(aVar);
    }

    private static boolean c(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libapminsighta.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(long j) {
        NativeImpl.b(j);
    }

    public static void b(boolean z2) {
        com.apm.insight.e.b(z2);
    }

    private static boolean b(Context context) {
        try {
            return new File(com.apm.insight.l.j.j(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(ICrashCallback iCrashCallback, CrashType crashType) {
        f4650f.b(iCrashCallback, crashType);
    }

    public static void b(IOOMCallback iOOMCallback) {
        f4650f.b(iOOMCallback);
    }

    public static synchronized void a(@NonNull Application application, @NonNull Context context) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (f4646a) {
                return;
            }
            f4646a = true;
            if (context != null && application != null) {
                com.apm.insight.e.a(application, context);
                if (!com.apm.insight.e.u() || (!b(application) && !c(application))) {
                    com.apm.insight.g.a aVarA = com.apm.insight.g.a.a();
                    aVarA.a(new com.apm.insight.i.b(context));
                    aVarA.b(new com.apm.insight.g.d(context));
                    f4647b = true;
                    NativeImpl.a();
                    boolean zA = NativeImpl.a(context);
                    f4649d = zA;
                    if (!zA) {
                        e = true;
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        g = true;
                        NativeImpl.i();
                    }
                    m.a().a(new Runnable() { // from class: com.apm.insight.runtime.l.2

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        private /* synthetic */ boolean f4653a = true;

                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!l.g) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.apm.insight.runtime.l.2.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        l.r();
                                        NativeImpl.i();
                                    }
                                });
                            }
                            l.e(this.f4653a);
                        }
                    }, 0L);
                    com.apm.insight.a.a((Object) ("Npth.init takes " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms."));
                    return;
                }
                Log.e("apminsight", "Inner npth checked.");
                return;
            }
            throw new IllegalArgumentException("context or Application must be not null.");
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void a(final String str, final h.a aVar) {
        m.a().a(new Runnable() { // from class: com.apm.insight.runtime.l.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                    com.apm.insight.b.d.a(str, aVar);
                }
            }
        });
    }

    public static void a(h.a aVar) {
        h.a(aVar);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str);
    }

    public static void a(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, aVar);
    }

    public static void a(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @Nullable h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, map3, aVar);
    }

    @Deprecated
    public static void a(@NonNull Throwable th) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.a(th);
        }
    }

    public static void a(String str, i.a aVar, i.a aVar2) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        com.apm.insight.a.a.a().a(str, aVar, aVar2);
    }

    public static void a(long j) {
        NativeImpl.a(j);
    }

    public static void a(@NonNull i.a aVar) {
        com.apm.insight.e.i().setEncryptImpl$22f2d42e(aVar);
    }

    public static void a(boolean z2) {
        com.apm.insight.e.a(z2);
    }

    public static void a(ICrashCallback iCrashCallback, CrashType crashType) {
        f4650f.a(iCrashCallback, crashType);
    }

    public static void a(IOOMCallback iOOMCallback) {
        f4650f.a(iOOMCallback);
    }
}
