package com.ironsource;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C2300e4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronLog;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.r4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2531r4 {
    private static final String k = "1.0.6";
    public static String l = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final B7 f9753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9756d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ContextProvider f9757f;
    public Thread.UncaughtExceptionHandler g;
    public String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9758i;
    private boolean j;

    /* JADX INFO: renamed from: com.ironsource.r4$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9761b;

        public b(Context context, String str) {
            this.f9760a = context;
            this.f9761b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strI = C2531r4.this.f9753a.I(this.f9760a);
                if (!TextUtils.isEmpty(strI)) {
                    C2531r4.this.f9755c = strI;
                }
                String strB = C2531r4.this.f9753a.b(this.f9760a);
                if (!TextUtils.isEmpty(strB)) {
                    C2531r4.this.e = strB;
                }
                SharedPreferences.Editor editorEdit = this.f9760a.getSharedPreferences("CRep", 0).edit();
                editorEdit.putString("String1", C2531r4.this.f9755c);
                editorEdit.putString("sId", this.f9761b);
                editorEdit.apply();
            } catch (Exception e) {
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.r4$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c extends RunnableC2548s4 {
        public c(JSONObject jSONObject) {
            super(jSONObject);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.r4$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile C2531r4 f9764a = new C2531r4(0);

        private d() {
        }
    }

    public /* synthetic */ C2531r4(int i2) {
        this();
    }

    public String e() {
        return this.f9758i;
    }

    private C2531r4() {
        this.j = false;
        this.f9753a = Mb.U().i();
        this.f9757f = ContextProvider.getInstance();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.g = defaultUncaughtExceptionHandler;
        this.f9758i = " ";
        this.h = "https://o-crash.mediation.unity3d.com/reporter";
        Thread.setDefaultUncaughtExceptionHandler(new C2498p4(defaultUncaughtExceptionHandler));
    }

    public static List<P5> c() {
        return null;
    }

    public static C2531r4 d() {
        return d.f9764a;
    }

    public void a(HashSet<String> hashSet, String str, String str2, boolean z2, String str3, int i2, boolean z7) {
        Context applicationContext = this.f9757f.getApplicationContext();
        if (applicationContext != null) {
            Log.d("automation_log", "init ISCrashReporter");
            if (!TextUtils.isEmpty(str2)) {
                this.f9758i = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                this.h = str;
            }
            this.f9756d = str3;
            if (z2) {
                new C2223a(i2).a(z7).b(true).a(new a()).start();
            }
            a(applicationContext, hashSet);
            new Thread(new b(applicationContext, str3)).start();
        }
        this.j = true;
        IronLog.INTERNAL.verbose("initialized");
    }

    public String b() {
        return k;
    }

    /* JADX INFO: renamed from: com.ironsource.r4$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements InterfaceC2241b {
        public a() {
        }

        @Override // com.ironsource.InterfaceC2241b
        public void a() {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            StringBuilder sb = new StringBuilder(128);
            for (Thread thread : allStackTraces.keySet()) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    sb.append("*** Thread Name ");
                    sb.append(thread.getName());
                    sb.append(" Thread ID ");
                    sb.append(thread.getId());
                    sb.append(" (");
                    sb.append(thread.getState().toString());
                    sb.append(") ***\n");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString());
                        sb.append(" ");
                        sb.append(thread.getState().toString());
                        sb.append("\n");
                    }
                }
            }
            C2531r4.l = sb.toString();
        }

        @Override // com.ironsource.InterfaceC2241b
        public void b() {
        }
    }

    public void a(Throwable th) {
        IronLog.INTERNAL.verbose("isInitialized=" + this.j);
        if (!this.j || th == null) {
            return;
        }
        new P5(new C2515q4(th).b(), "" + System.currentTimeMillis(), "Caught_IS_Crash").a();
    }

    private void a(Context context, HashSet<String> hashSet) {
        String strA = a(a());
        if (strA.equals("none")) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("CRep", 0);
        String string = sharedPreferences.getString("String1", this.f9755c);
        String string2 = sharedPreferences.getString("sId", this.f9756d);
        List<P5> listB = I4.b();
        IronLog.INTERNAL.verbose("reportList size " + listB.size());
        for (P5 p52 : listB) {
            JSONObject jSONObject = new JSONObject();
            String strB = p52.b();
            String strE = p52.e();
            String strD = p52.d();
            String packageName = context.getPackageName();
            JSONObject jSONObject2 = new JSONObject();
            try {
                ActivityManager.MemoryInfo memoryInfoN = this.f9753a.n(context);
                if (memoryInfoN != null) {
                    jSONObject2.put("availRam", this.f9753a.c(memoryInfoN));
                    jSONObject2.put(Q6.f7479x, this.f9753a.b(memoryInfoN));
                    jSONObject2.put("mThreshold", this.f9753a.a(memoryInfoN));
                }
                String strT = this.f9753a.t();
                if (strT != null) {
                    jSONObject2.put(Q6.f7484z, strT);
                }
                jSONObject2.put("crashDate", strB);
                jSONObject2.put("stacktraceCrash", strE);
                jSONObject2.put("crashType", strD);
                jSONObject2.put("CrashReporterVersion", k);
                jSONObject2.put(C2300e4.i.f8415q, "9.0.0");
                jSONObject2.put(C2300e4.i.f8424x, this.f9753a.c(context));
                jSONObject2.put("appVersion", C1.b(context, packageName));
                jSONObject2.put(C2300e4.i.f8410n, this.f9753a.i());
                jSONObject2.put("network", strA);
                jSONObject2.put(C2300e4.i.p, this.f9753a.e());
                jSONObject2.put("deviceModel", this.f9753a.l());
                jSONObject2.put("totalRam", this.f9753a.q(context));
                jSONObject2.put(C2253bb.f8071o, this.f9753a.f());
                jSONObject2.put("advertisingId", string);
                jSONObject2.put("deviceOEM", this.f9753a.q());
                jSONObject2.put("systemProperties", System.getProperties());
                jSONObject2.put("bundleId", packageName);
                jSONObject2.put("sId", string2);
                if (!TextUtils.isEmpty(this.e)) {
                    jSONObject2.put(C2300e4.i.M, Boolean.parseBoolean(this.e));
                }
                if (hashSet == null || hashSet.isEmpty()) {
                    jSONObject = jSONObject2;
                } else {
                    for (String str : hashSet) {
                        try {
                            if (jSONObject2.has(str)) {
                                jSONObject.put(str, jSONObject2.opt(str));
                            }
                        } catch (Exception e) {
                            IronLog.INTERNAL.error(e.toString());
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (jSONObject.length() == 0) {
                Log.d("ISCrashReport", " Is Empty");
            } else {
                new Thread(new c(jSONObject)).start();
            }
        }
        I4.a();
    }

    public Context a() {
        return this.f9757f.getApplicationContext();
    }

    private String a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "none";
            }
            if (networkCapabilities.hasTransport(1)) {
                return C2228a4.f7946b;
            }
            return networkCapabilities.hasTransport(0) ? C2228a4.g : "none";
        } catch (Exception e) {
            IronLog.INTERNAL.error(e.toString());
            return "none";
        }
    }
}
