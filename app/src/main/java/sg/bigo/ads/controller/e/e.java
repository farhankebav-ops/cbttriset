package sg.bigo.ads.controller.e;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.a.b.d;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends sg.bigo.ads.controller.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.common.g f16602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final sg.bigo.ads.controller.b.d f16603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final sg.bigo.ads.controller.b.h f16604c;
    int g;
    final Context h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final sg.bigo.ads.controller.a.b f16607i;
    private int l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f16605d = -1;
    boolean e = false;
    private final List<b> j = new ArrayList();
    private final AtomicReference<sg.bigo.ads.controller.g.h> k = new AtomicReference<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicInteger f16606f = new AtomicInteger(0);

    public interface a {
        void a(int i2);

        void a(int i2, int i8, String str);
    }

    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f16616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f16617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final sg.bigo.ads.common.g f16618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final sg.bigo.ads.controller.b.d f16619d;
        private final sg.bigo.ads.controller.b.h e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final sg.bigo.ads.controller.a.b f16620f;
        private final e g;

        public b(String str, a aVar, @NonNull sg.bigo.ads.controller.b.d dVar, @NonNull sg.bigo.ads.controller.b.h hVar, @NonNull sg.bigo.ads.common.g gVar, @NonNull sg.bigo.ads.controller.a.b bVar, @NonNull e eVar) {
            this.f16616a = str;
            this.f16617b = aVar;
            this.f16618c = gVar;
            this.f16619d = dVar;
            this.e = hVar;
            this.f16620f = bVar;
            this.g = eVar;
            if (c.a().f16587b.compareAndSet(-1, 0)) {
                sg.bigo.ads.common.t.a.a(0, 3, "ConfigInitProcessor", "reinit config and set status.");
            }
        }

        @Override // sg.bigo.ads.controller.e.e.a
        public final void a(int i2) {
            c.a().b();
            a aVar = this.f16617b;
            if (aVar != null) {
                aVar.a(i2);
            }
            if (i.f15457a.x()) {
                d.a.f16359a.a(this.f16620f, this.f16618c, this.f16619d, this.e, this.g);
            }
        }

        @Override // sg.bigo.ads.controller.e.e.a
        public final void a(int i2, int i8, String str) {
            c cVarA = c.a();
            String str2 = this.f16616a;
            if (1101 == i8 || 1105 == i8) {
                Map concurrentHashMap = cVarA.f16586a;
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap();
                    cVarA.f16586a = concurrentHashMap;
                }
                if (str2 != null && c.a(concurrentHashMap, str2)) {
                    concurrentHashMap.put(str2, Long.valueOf(SystemClock.elapsedRealtime()));
                }
                if (cVarA.f16587b.compareAndSet(0, -1)) {
                    sg.bigo.ads.common.t.a.a(0, "ConfigInitProcessor", "Failed to init config and set status.");
                }
            }
            a aVar = this.f16617b;
            if (aVar != null) {
                aVar.a(i2, i8, str);
            }
        }
    }

    public e(@NonNull Context context, @NonNull sg.bigo.ads.controller.b.d dVar, @NonNull sg.bigo.ads.controller.b.h hVar, @NonNull sg.bigo.ads.common.g gVar, @NonNull sg.bigo.ads.controller.a.b bVar) {
        this.h = context;
        this.f16602a = gVar;
        this.f16603b = dVar;
        this.f16604c = hVar;
        this.f16607i = bVar;
    }

    private void a(int i2, int i8) {
        if (this.k.get() != null) {
            return;
        }
        this.k.set(new sg.bigo.ads.controller.g.h(this.f16602a, this.f16607i, sg.bigo.ads.controller.b.e.E(), this));
        this.g = i2;
        this.f16605d = SystemClock.elapsedRealtime();
        this.e = sg.bigo.ads.common.f.b.d();
        this.f16606f.incrementAndGet();
        this.l = i8;
        String strA = this.f16602a.a();
        if (q.a((CharSequence) strA)) {
            b(1100, "App id cannot be empty, please pass the id when initializing bigo sdk");
        } else if (c.a().a(strA)) {
            this.k.get().b();
        } else {
            b(1101, "The slot id is invalid, please make sure the id is aligned with app id.");
        }
    }

    public final void b(int i2, String str) {
        this.k.set(null);
        if (this.j.isEmpty()) {
            return;
        }
        this.j.remove(0).a(this.l, i2, str);
        if (this.j.isEmpty()) {
            return;
        }
        a(this.g, this.l);
    }

    @Override // sg.bigo.ads.controller.e
    public final void a(final int i2, final int i8, final int i9, @NonNull final String str, @Nullable Object obj) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.e.2
            @Override // java.lang.Runnable
            public final void run() {
                e eVar;
                int i10;
                sg.bigo.ads.common.t.a.a(0, "GlobalConfig", "request error, seq=" + i2 + ", error=" + i8 + ", message=" + str);
                StringBuilder sb = new StringBuilder("Error from server: ");
                sb.append(str);
                String string = sb.toString();
                if (i9 == -9) {
                    eVar = e.this;
                    i10 = 1105;
                } else {
                    eVar = e.this;
                    i10 = 1104;
                }
                eVar.b(i10, string);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                e eVar2 = e.this;
                long j = jElapsedRealtime - eVar2.f16605d;
                int i11 = i8;
                int i12 = i9;
                String str2 = str;
                int i13 = eVar2.g;
                boolean z2 = eVar2.e;
                int i14 = eVar2.f16606f.get();
                sg.bigo.ads.common.g gVar = e.this.f16602a;
                sg.bigo.ads.core.d.b.a(j, i11, i12, str2, i13, z2, i14, gVar == null ? null : gVar.X());
            }
        });
    }

    @Override // sg.bigo.ads.controller.b
    public final void a(int i2, @NonNull String str) {
        a(i2, str, false);
    }

    public final void a(final int i2, @NonNull final String str, final boolean z2) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.e.1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder sb = new StringBuilder("request success, seq=");
                sb.append(i2);
                sb.append(", result=");
                int andSet = 0;
                a0.g(0, 3, str, "GlobalConfig", sb);
                e eVar = e.this;
                int i8 = eVar.g;
                if (z2) {
                    i8 = 2;
                }
                int i9 = i8;
                try {
                    boolean zN = eVar.f16603b.N();
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("global");
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("slots");
                    if (jSONObjectOptJSONObject != null && jSONArrayOptJSONArray != null) {
                        e.this.f16603b.e(jSONObjectOptJSONObject);
                        e eVar2 = e.this;
                        eVar2.f16603b.c(eVar2.h);
                        e.this.f16604c.a(jSONArrayOptJSONArray);
                        e eVar3 = e.this;
                        eVar3.f16604c.c(eVar3.h);
                        sg.bigo.ads.a aVarA = BigoAdSdk.a(e.this.h);
                        aVarA.f13773a = e.this.f16602a.a();
                        aVarA.c(e.this.h);
                        if (!z2) {
                            e.a(e.this);
                            andSet = e.this.f16606f.getAndSet(0);
                        }
                        int i10 = andSet;
                        long jI = e.this.f16603b.i();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        e eVar4 = e.this;
                        long j = jElapsedRealtime - eVar4.f16605d;
                        boolean z7 = eVar4.e;
                        sg.bigo.ads.common.g gVar = eVar4.f16602a;
                        sg.bigo.ads.core.d.b.a(jI, j, zN, i9, z7, i10, gVar == null ? null : gVar.X());
                        h.a().a(e.this.f16603b.J());
                        return;
                    }
                    if (!z2) {
                        e.this.b(1102, "Missing `global` or `slots` params.");
                    }
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    e eVar5 = e.this;
                    long j3 = jElapsedRealtime2 - eVar5.f16605d;
                    boolean z8 = eVar5.e;
                    int i11 = eVar5.f16606f.get();
                    sg.bigo.ads.common.g gVar2 = e.this.f16602a;
                    sg.bigo.ads.core.d.b.a(j3, 1102, 10002, "Missing `global` or `slots` params.", i9, z8, i11, gVar2 == null ? null : gVar2.X());
                } catch (JSONException unused) {
                    if (!z2) {
                        e.this.b(1103, "Failed to parse global config.");
                    }
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                    e eVar6 = e.this;
                    long j8 = jElapsedRealtime3 - eVar6.f16605d;
                    boolean z9 = eVar6.e;
                    int i12 = eVar6.f16606f.get();
                    sg.bigo.ads.common.g gVar3 = e.this.f16602a;
                    sg.bigo.ads.core.d.b.a(j8, 1103, 10002, "Failed to parse global config.", i9, z9, i12, gVar3 != null ? gVar3.X() : null);
                }
            }
        });
    }

    @WorkerThread
    public final void a(@Nullable a aVar, int i2) {
        b bVar = new b(this.f16602a.a(), aVar, this.f16603b, this.f16604c, this.f16602a, this.f16607i, this);
        int iC = this.f16603b.C();
        if (iC != 2) {
            if (iC == 3) {
                this.j.add(bVar);
            } else if (iC == 4) {
                bVar.a(iC);
            } else if (iC != 5) {
                return;
            }
            a(i2, iC);
            return;
        }
        bVar.a(iC);
    }

    public static /* synthetic */ void a(e eVar) {
        eVar.k.set(null);
        Iterator<b> it = eVar.j.iterator();
        while (it.hasNext()) {
            it.next().a(eVar.l);
        }
        eVar.j.clear();
    }
}
