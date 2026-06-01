package com.apm.insight.b;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.apm.insight.runtime.p;
import com.google.mlkit.common.MlKitException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NewHtcHomeBadger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f4296r = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f4297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f4299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4300d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f f4301f;
    private long g;
    private long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4302i;
    private long j;
    private String k;
    private String l;
    private com.apm.insight.b.e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f4303n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4304o;
    private final p p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f4305q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Runnable f4306s;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f4314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f4315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f4316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4317d;
        int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        StackTraceElement[] f4318f;

        private a() {
        }

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f4319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4320b;

        public final void a(a aVar) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface c {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f4321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f4322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f4323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4324d;
        int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f4325f;
        long g;
        String h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f4326i;
        private String j;
        private d k;

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, g.a(this.h));
                jSONObject.put("cpuDuration", this.g);
                jSONObject.put("duration", this.f4325f);
                jSONObject.put("type", this.f4324d);
                jSONObject.put(NewHtcHomeBadger.COUNT, this.e);
                jSONObject.put("messageCount", this.e);
                jSONObject.put("lastDuration", this.f4322b - this.f4323c);
                jSONObject.put("start", this.f4321a);
                jSONObject.put("end", this.f4322b);
                jSONObject.put("block_uuid", (Object) null);
                jSONObject.put("sblock_uuid", (Object) null);
                jSONObject.put("belong_frame", false);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        }

        public final void b() {
            this.f4324d = -1;
            this.e = -1;
            this.f4325f = -1L;
            this.h = null;
            this.j = null;
            this.k = null;
            this.f4326i = null;
        }
    }

    public g() {
        this((byte) 0);
    }

    public static /* synthetic */ b c() {
        return null;
    }

    public static /* synthetic */ p e() {
        return null;
    }

    private g(byte b8) {
        this.f4298b = 0;
        this.f4299c = 0;
        this.f4300d = 100;
        this.e = 200;
        this.g = -1L;
        this.h = -1L;
        this.f4302i = -1;
        this.j = -1L;
        this.f4303n = false;
        this.f4304o = false;
        this.f4305q = false;
        this.f4306s = new Runnable() { // from class: com.apm.insight.b.g.2

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f4309b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f4308a = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f4310c = -1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f4311d = 0;
            private int e = 0;

            @Override // java.lang.Runnable
            public final void run() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (g.c().f4319a != null) {
                    throw null;
                }
                a aVar = new a((byte) 0);
                if (this.f4310c == g.this.f4299c) {
                    this.f4311d++;
                } else {
                    this.f4311d = 0;
                    this.e = 0;
                    this.f4309b = jUptimeMillis;
                }
                this.f4310c = g.this.f4299c;
                int i2 = this.f4311d;
                if (i2 > 0 && i2 - this.e >= g.f4296r && this.f4308a != 0 && jUptimeMillis - this.f4309b > 700 && g.this.f4305q) {
                    aVar.f4318f = Looper.getMainLooper().getThread().getStackTrace();
                    this.e = this.f4311d;
                }
                aVar.f4317d = g.this.f4305q;
                aVar.f4316c = (jUptimeMillis - this.f4308a) - 300;
                aVar.f4314a = jUptimeMillis;
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                this.f4308a = jUptimeMillis2;
                aVar.f4315b = jUptimeMillis2 - jUptimeMillis;
                aVar.e = g.this.f4299c;
                g.e().a(g.this.f4306s, 300L);
                g.c().a(aVar);
            }
        };
        this.f4297a = new c() { // from class: com.apm.insight.b.g.1
        };
        this.p = null;
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f4298b;
        gVar.f4298b = i2 + 1;
        return i2;
    }

    public final JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            int i2 = 0;
            for (e eVar : this.f4301f.a()) {
                if (eVar != null) {
                    i2++;
                    jSONArray.put(eVar.a().put("id", i2));
                }
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    public final void a() {
        if (this.f4303n) {
            return;
        }
        this.f4303n = true;
        this.f4300d = 100;
        this.e = MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE;
        this.f4301f = new f(100);
        this.m = new com.apm.insight.b.e() { // from class: com.apm.insight.b.g.3
            @Override // com.apm.insight.b.e
            public final boolean a() {
                return true;
            }

            @Override // com.apm.insight.b.e
            public final void b(String str) {
                super.b(str);
                g.d(g.this);
                g.a(g.this, false, com.apm.insight.b.e.f4290a);
                g gVar = g.this;
                gVar.k = gVar.l;
                g.this.l = "no message running";
                g.this.f4305q = false;
            }

            @Override // com.apm.insight.b.e
            public final void a(String str) {
                g.this.f4305q = true;
                g.this.l = str;
                super.a(str);
                g.a(g.this, true, com.apm.insight.b.e.f4290a);
            }
        };
        h.a();
        h.a(this.m);
        j.a(j.a());
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e f4329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<e> f4330d = new ArrayList();

        public f(int i2) {
            this.f4327a = i2;
        }

        public final e a(int i2) {
            e eVar = this.f4329c;
            if (eVar != null) {
                eVar.f4324d = i2;
                this.f4329c = null;
                return eVar;
            }
            e eVar2 = new e();
            eVar2.f4324d = i2;
            return eVar2;
        }

        public final void a(e eVar) {
            int size = this.f4330d.size();
            int i2 = this.f4327a;
            if (size < i2) {
                this.f4330d.add(eVar);
                this.f4328b = this.f4330d.size();
                return;
            }
            int i8 = this.f4328b % i2;
            this.f4328b = i8;
            e eVar2 = this.f4330d.set(i8, eVar);
            eVar2.b();
            this.f4329c = eVar2;
            this.f4328b++;
        }

        public final List<e> a() {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            if (this.f4330d.size() == this.f4327a) {
                for (int i8 = this.f4328b; i8 < this.f4330d.size(); i8++) {
                    arrayList.add(this.f4330d.get(i8));
                }
                while (i2 < this.f4328b - 1) {
                    arrayList.add(this.f4330d.get(i2));
                    i2++;
                }
            } else {
                while (i2 < this.f4330d.size()) {
                    arrayList.add(this.f4330d.get(i2));
                    i2++;
                }
            }
            return arrayList;
        }
    }

    private void a(int i2, long j, String str) {
        a(i2, j, str, true);
    }

    private void a(int i2, long j, String str, boolean z2) {
        this.f4304o = true;
        e eVarA = this.f4301f.a(i2);
        eVarA.f4325f = j - this.g;
        if (z2) {
            long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            eVarA.g = jCurrentThreadTimeMillis - this.j;
            this.j = jCurrentThreadTimeMillis;
        } else {
            eVarA.g = -1L;
        }
        eVarA.e = this.f4298b;
        eVarA.h = str;
        eVarA.f4326i = this.k;
        eVarA.f4321a = this.g;
        eVarA.f4322b = j;
        eVarA.f4323c = this.h;
        this.f4301f.a(eVarA);
        this.f4298b = 0;
        this.g = j;
    }

    public final e a(long j) {
        e eVar = new e();
        eVar.h = this.l;
        eVar.f4326i = this.k;
        eVar.f4325f = j - this.h;
        eVar.g = 0 - this.j;
        eVar.e = this.f4298b;
        return eVar;
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "unknown message";
        }
        try {
            String[] strArrSplit = str.split(":");
            String str3 = strArrSplit.length == 2 ? strArrSplit[1] : "";
            if (str.contains("{") && str.contains("}")) {
                str2 = str.split("\\{")[0];
                try {
                    str = str2 + str.split("\\}")[1];
                } catch (Throwable unused) {
                    return str2;
                }
            } else {
                str2 = str;
            }
            if (str.contains("@")) {
                String[] strArrSplit2 = str.split("@");
                if (strArrSplit2.length > 1) {
                    str = strArrSplit2[0];
                }
            }
            if (str.contains("(") && str.contains(")") && !str.endsWith(" null")) {
                String[] strArrSplit3 = str.split("\\(");
                if (strArrSplit3.length > 1) {
                    str = strArrSplit3[1];
                }
                str = str.replace(")", "");
            }
            if (str.startsWith(" ")) {
                str = str.replace(" ", "");
            }
            return str + str3;
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static /* synthetic */ void a(g gVar, boolean z2, long j) {
        int i2 = gVar.f4299c + 1;
        gVar.f4299c = i2;
        gVar.f4299c = i2 & 65535;
        gVar.f4304o = false;
        if (gVar.g < 0) {
            gVar.g = j;
        }
        if (gVar.h < 0) {
            gVar.h = j;
        }
        if (gVar.f4302i < 0) {
            gVar.f4302i = Process.myTid();
            gVar.j = SystemClock.currentThreadTimeMillis();
        }
        long j3 = j - gVar.g;
        int i8 = gVar.e;
        if (j3 > i8) {
            long j8 = gVar.h;
            if (j - j8 <= i8) {
                gVar.a(9, j, gVar.l);
            } else if (z2) {
                if (gVar.f4298b == 0) {
                    gVar.a(1, j, "no message running");
                } else {
                    gVar.a(9, j8, gVar.k);
                    gVar.a(1, j, "no message running", false);
                }
            } else if (gVar.f4298b == 0) {
                gVar.a(8, j, gVar.l, true);
            } else {
                gVar.a(9, j8, gVar.k, false);
                gVar.a(8, j, gVar.l, true);
            }
        }
        gVar.h = j;
    }
}
