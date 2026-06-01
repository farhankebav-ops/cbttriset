package com.apm.insight.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.b;
import com.apm.insight.k.c;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.o;
import com.google.android.gms.ads.RequestConfiguration;
import com.ironsource.C2605va;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f4450b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4451a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C0015b f4454f;
    private HashMap<String, C0015b> g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<File> f4452c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<File> f4453d = new ArrayList();
    private int e = -1;
    private volatile boolean h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Runnable f4455i = new Runnable() { // from class: com.apm.insight.k.b.1
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.f();
        }
    };
    private Runnable j = new Runnable() { // from class: com.apm.insight.k.b.2
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.d();
        }
    };

    /* JADX INFO: renamed from: com.apm.insight.k.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0015b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4469a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a f4472d;
        a e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<a> f4470b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<a> f4471c = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f4473f = false;
        int g = 0;

        public C0015b(String str) {
            this.f4469a = str;
        }
    }

    private b(Context context) {
        this.f4451a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws Throwable {
        if (this.h || this.g == null) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f4451a)) {
            e();
        }
        if (this.e == -1) {
            if (com.apm.insight.runtime.a.a() && com.apm.insight.runtime.a.f()) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }
        boolean z2 = this.e == 1;
        com.apm.insight.runtime.f fVar = new com.apm.insight.runtime.f(this.f4451a);
        Iterator<C0015b> it = this.g.values().iterator();
        while (it.hasNext()) {
            b(it.next(), z2, fVar);
        }
        Iterator<C0015b> it2 = this.g.values().iterator();
        while (it2.hasNext()) {
            a(it2.next(), z2, fVar);
        }
        Iterator<C0015b> it3 = this.g.values().iterator();
        while (it3.hasNext()) {
            com.apm.insight.l.f.a(com.apm.insight.l.j.a(this.f4451a, it3.next().f4469a));
        }
        fVar.a();
        com.apm.insight.runtime.b.a();
        e();
    }

    private void e() {
        this.h = true;
        this.g = null;
        NativeImpl.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws Throwable {
        if (this.h) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f4451a) || (System.currentTimeMillis() - com.apm.insight.e.j() <= 5000 && com.apm.insight.e.i().isApmExists() && !Npth.hasCrash())) {
            m.a().a(this.f4455i, 5000L);
        } else {
            d();
        }
    }

    private void g() {
        File[] fileArrListFiles = com.apm.insight.l.j.i(this.f4451a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length && i2 < 5; i2++) {
            File file = fileArrListFiles[i2];
            if (file.getName().endsWith(".atmp")) {
                com.apm.insight.a.a.a();
                file.getAbsolutePath();
            } else {
                try {
                    com.apm.insight.f.b bVarC = com.apm.insight.l.f.c(file.getAbsolutePath());
                    if (bVarC != null) {
                        if (bVarC.b() != null) {
                            bVarC.b().put("upload_scene", "launch_scan");
                        }
                        if (e.a(e.d(), bVarC.e(), bVarC.d(), bVarC.f(), bVarC.g())) {
                            com.apm.insight.l.f.a(file);
                            String strC = bVarC.c();
                            if (!TextUtils.isEmpty(strC)) {
                                com.apm.insight.l.f.a(new File(strC));
                            }
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
            }
        }
    }

    public static b a() {
        if (f4450b == null) {
            synchronized (b.class) {
                try {
                    if (f4450b == null) {
                        f4450b = new b(com.apm.insight.e.g());
                    }
                } finally {
                }
            }
        }
        return f4450b;
    }

    public final void b() {
        try {
            if (!this.h && com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                m.a().a(this.j);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean c() {
        return this.h;
    }

    private void b(HashMap<String, C0015b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.d(this.f4451a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length && i2 < 5; i2++) {
            File file = fileArrListFiles[i2];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0015b c0015b = map.get(name);
                    if (c0015b == null) {
                        c0015b = new C0015b(name);
                        map.put(name, c0015b);
                    }
                    c0015b.f4471c.add(new a(file, CrashType.NATIVE));
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        File f4465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f4466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f4467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        CrashType f4468d;
        String e;

        public a(File file, @Nullable CrashType crashType) {
            this.f4466b = -1L;
            this.f4467c = -1L;
            this.f4465a = file;
            this.f4468d = crashType;
            this.e = file.getName();
        }

        public a(File file, long j, @Nullable CrashType crashType) {
            this.f4467c = -1L;
            this.f4465a = file;
            this.f4466b = j;
            this.f4468d = crashType;
            this.e = file.getName();
        }
    }

    public final void a(boolean z2) throws Throwable {
        if (!Npth.isStopUpload() && z2) {
            if (this.f4454f == null) {
                this.f4454f = new C0015b("old_uuid");
                HashMap<String, C0015b> map = new HashMap<>();
                this.g = map;
                a(map);
                a(this.g, this.f4454f);
                com.apm.insight.l.f.a(com.apm.insight.l.j.b(this.f4451a));
                b(this.g);
                b(this.f4454f, true, null);
                a(this.f4454f, true, null);
                this.f4454f = null;
                if (this.g.isEmpty()) {
                    e();
                } else {
                    f();
                }
            }
            g();
            com.apm.insight.a.c();
        }
    }

    private void b(final C0015b c0015b, boolean z2, @Nullable com.apm.insight.runtime.f fVar) {
        boolean z7;
        JSONObject jSONObjectA;
        if (c0015b.f4471c.size() <= 1 && c0015b.f4471c.isEmpty()) {
            c0015b.e = c0015b.f4472d;
            return;
        }
        boolean zB = com.apm.insight.l.k.b(this.f4451a);
        c0015b.e = c0015b.f4472d;
        com.apm.insight.nativecrash.a aVar = new com.apm.insight.nativecrash.a(this.f4451a);
        for (a aVar2 : c0015b.f4471c) {
            final File file = aVar2.f4465a;
            try {
                aVar.a(file);
                jSONObjectA = a(aVar);
            } catch (Throwable th) {
                th = th;
                z7 = zB;
            }
            if (jSONObjectA != null && jSONObjectA.length() != 0) {
                if (jSONObjectA.length() != 0) {
                    if (!z2) {
                        long jOptLong = jSONObjectA.optLong("crash_time");
                        try {
                            a aVar3 = c0015b.e;
                            if (aVar3 == null) {
                                c0015b.e = aVar2;
                                c0015b.f4473f = true;
                                if (fVar == null || fVar.a("default")) {
                                    z7 = zB;
                                } else {
                                    aVar.i();
                                }
                            } else {
                                z7 = zB;
                                try {
                                    if (!c0015b.f4473f && jOptLong < aVar3.f4466b) {
                                        c0015b.e = aVar2;
                                        if (fVar != null && !fVar.a("default")) {
                                            aVar.i();
                                            zB = z7;
                                        } else {
                                            a(file);
                                            c0015b.f4473f = true;
                                        }
                                    } else {
                                        com.apm.insight.entity.a.a(jSONObjectA, "filters", C2605va.f10440b, String.valueOf(jSONObjectA.optJSONObject("header").opt(C2605va.f10440b)));
                                        jSONObjectA.optJSONObject("header").put(C2605va.f10440b, 2010);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                                    com.apm.insight.l.f.a(file);
                                    zB = z7;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            z7 = zB;
                        }
                    } else {
                        z7 = zB;
                        if (fVar != null && !fVar.a("default")) {
                            aVar.i();
                        }
                    }
                    com.apm.insight.entity.a.a(jSONObjectA, "filters", "start_uuid", c0015b.f4469a);
                    com.apm.insight.entity.a.a(jSONObjectA, "filters", "crash_thread_name", jSONObjectA.optString("crash_thread_name", "unknown"));
                    if (z7) {
                        try {
                            c.a aVar4 = new c.a(jSONObjectA, CrashType.NATIVE);
                            com.apm.insight.entity.b.a(jSONObjectA, com.apm.insight.entity.b.a(aVar4.c(), aVar4.a(), o.a().b(aVar4.b() == -1 ? System.currentTimeMillis() : aVar4.b())), new b.a() { // from class: com.apm.insight.k.b.4
                                @Override // com.apm.insight.entity.b.a
                                public final void a(JSONObject jSONObject) {
                                    d.a();
                                    d.a(jSONObject, file, com.apm.insight.l.j.a(b.this.f4451a, c0015b.f4469a));
                                }
                            });
                            if (!aVar.i()) {
                                aVar.f();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                            com.apm.insight.l.f.a(file);
                        }
                    }
                    c.a(CrashType.NATIVE, jSONObjectA);
                } else {
                    z7 = zB;
                }
                zB = z7;
            } else {
                z7 = zB;
                aVar.i();
                zB = z7;
            }
        }
    }

    private void a(HashMap<String, C0015b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.f(this.f4451a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length && i2 < 5; i2++) {
            File file = fileArrListFiles[i2];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0015b c0015b = map.get(name);
                    if (c0015b == null) {
                        c0015b = new C0015b(name);
                        map.put(name, c0015b);
                    }
                    JSONArray jSONArrayA = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.l(file), com.apm.insight.l.j.m(file));
                    int length = jSONArrayA.length();
                    c0015b.g = length;
                    if (length > 0) {
                        try {
                            com.apm.insight.l.f.a(com.apm.insight.l.j.n(file), jSONArrayA);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d2 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:9:0x0024, B:11:0x0032, B:14:0x003a, B:17:0x0042, B:20:0x0052, B:22:0x0058, B:23:0x005d, B:25:0x0069, B:27:0x0074, B:31:0x008e, B:48:0x00ca, B:50:0x00d2, B:51:0x00da, B:53:0x00e5, B:61:0x00fd, B:56:0x00ef, B:58:0x00f3, B:60:0x00fb, B:38:0x00a8, B:40:0x00b0, B:41:0x00b3, B:43:0x00bb, B:44:0x00be, B:46:0x00c6, B:62:0x0103, B:63:0x0120, B:29:0x0080), top: B:70:0x0024, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e5 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:9:0x0024, B:11:0x0032, B:14:0x003a, B:17:0x0042, B:20:0x0052, B:22:0x0058, B:23:0x005d, B:25:0x0069, B:27:0x0074, B:31:0x008e, B:48:0x00ca, B:50:0x00d2, B:51:0x00da, B:53:0x00e5, B:61:0x00fd, B:56:0x00ef, B:58:0x00f3, B:60:0x00fb, B:38:0x00a8, B:40:0x00b0, B:41:0x00b3, B:43:0x00bb, B:44:0x00be, B:46:0x00c6, B:62:0x0103, B:63:0x0120, B:29:0x0080), top: B:70:0x0024, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.HashMap<java.lang.String, com.apm.insight.k.b.C0015b> r18, com.apm.insight.k.b.C0015b r19) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(java.util.HashMap, com.apm.insight.k.b$b):void");
    }

    private static JSONObject a(com.apm.insight.nativecrash.a aVar) {
        JSONObject jSONObjectB = aVar.b();
        if (jSONObjectB != null && jSONObjectB.length() != 0) {
            return jSONObjectB;
        }
        if (com.apm.insight.e.d()) {
            aVar.j();
        }
        if (!aVar.a()) {
            aVar.i();
            return null;
        }
        if (!aVar.d()) {
            aVar.i();
            return null;
        }
        if (aVar.e()) {
            aVar.i();
            return null;
        }
        aVar.c();
        return aVar.h();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:97|38|39|(1:41)(1:43)|44|(18:46|89|47|(1:49)|91|55|56|87|57|70|71|93|72|(1:74)|75|78|69|113)(1:52)|53|(5:91|55|56|87|57)(4:64|(0)(1:68)|69|113)|70|71|93|72|(0)|75|78|69|113) */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0166, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0154 A[Catch: all -> 0x0166, TryCatch #4 {all -> 0x0166, blocks: (B:72:0x0148, B:74:0x0154, B:78:0x0168), top: B:93:0x0148 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(final com.apm.insight.k.b.C0015b r19, boolean r20, @androidx.annotation.Nullable com.apm.insight.runtime.f r21) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(com.apm.insight.k.b$b, boolean, com.apm.insight.runtime.f):void");
    }

    private static boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ac A[Catch: all -> 0x01e1, TRY_ENTER, TryCatch #1 {all -> 0x01e1, blocks: (B:31:0x0072, B:39:0x0090, B:42:0x009d, B:47:0x00b3, B:46:0x00ac), top: B:92:0x0072 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.apm.insight.f.b a(java.io.File r24, com.apm.insight.CrashType r25, java.lang.String r26, long r27, long r29) {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(java.io.File, com.apm.insight.CrashType, java.lang.String, long, long):com.apm.insight.f.b");
    }
}
