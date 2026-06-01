package sg.bigo.ads.controller.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.utils.l;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.a.f;
import sg.bigo.ads.controller.g.k;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sg.bigo.ads.controller.a.a f16310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sg.bigo.ads.common.g f16311b;

    @Nullable
    public sg.bigo.ads.controller.b g;
    private final sg.bigo.ads.api.a.h h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f16315i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicBoolean f16312c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicBoolean f16313d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicBoolean f16314f = new AtomicBoolean(false);
    private final g k = new g() { // from class: sg.bigo.ads.controller.a.b.1
        @Override // sg.bigo.ads.controller.a.g
        public final void a(String str) {
            b.this.f16310a.a(0L);
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], reSave config, fromUrlPath=".concat(String.valueOf(str)));
        }

        @Override // sg.bigo.ads.controller.a.g
        public final void a(String str, boolean z2) {
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "fetchConfig, country=" + str + ", fromSDKConfigUrl=" + z2);
            if (!z2) {
                b.a(b.this, (k.a) null);
            }
            b.a(b.this, str, true);
        }
    };
    private final Runnable l = new Runnable() { // from class: sg.bigo.ads.controller.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (b.a(b.this, new k.a() { // from class: sg.bigo.ads.controller.a.b.2.1
                @Override // sg.bigo.ads.controller.g.k.a
                public final void a(String str, int i2, int i8, int i9, @NonNull String str2, @Nullable Map<String, Object> map) {
                    b bVar = b.this;
                    b.a(bVar, bVar.f16311b.v(), false);
                }

                @Override // sg.bigo.ads.controller.g.k.a
                public final void a(String str, int i2, String str2, @Nullable Map<String, Object> map) {
                }
            })) {
                return;
            }
            b bVar = b.this;
            b.a(bVar, bVar.f16311b.v(), false);
        }
    };
    private final Map<String, String> j = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f16339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f16340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f16341c;

        private a(k kVar, String str, long j) {
            this.f16339a = kVar;
            this.f16340b = str;
            this.f16341c = j;
        }

        public /* synthetic */ a(k kVar, String str, long j, byte b8) {
            this(kVar, str, j);
        }
    }

    public b(@NonNull Context context, @NonNull sg.bigo.ads.common.g gVar, @NonNull sg.bigo.ads.api.a.h hVar) {
        this.f16315i = context;
        this.f16310a = new sg.bigo.ads.controller.a.a(context, hVar);
        this.f16311b = gVar;
        this.h = hVar;
    }

    @NonNull
    public final h a(String str, String str2, long j, boolean z2) {
        String str3 = str2;
        h hVarA = this.f16310a.a(str, str3, this.j, this.f16311b.v(), this.h.s());
        long jElapsedRealtime = j <= 0 ? 0L : SystemClock.elapsedRealtime() - j;
        if (hVarA.f16377b) {
            this.f16310a.a(0L);
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], update host config, configSource=" + str3 + ", result=" + hVarA);
            if (z2) {
                sg.bigo.ads.core.d.b.a(jElapsedRealtime, hVarA.f16378c, str3, true);
            }
        } else {
            long j3 = jElapsedRealtime;
            int i2 = hVarA.f16379d;
            if (i2 == 0) {
                if (z2) {
                    sg.bigo.ads.core.d.b.a(j3, hVarA.f16378c, str3, false);
                }
            } else if (z2) {
                sg.bigo.ads.core.d.b.a(j3, hVarA.f16378c, str3, i2, hVarA.e);
                str3 = str3;
            }
        }
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "updateHostConfig, configSource=" + str3 + ", update result=" + hVarA);
        return hVarA;
    }

    public final f b(@NonNull String str, String str2) {
        f.a aVar = new f.a(this.f16310a, this.f16311b, this.h, str, str2);
        aVar.a(this.k);
        return aVar;
    }

    public final void a(long j, String str) {
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "fetchAntiBanConfig, delayMillis=" + j + ", from=" + str);
        sg.bigo.ads.common.n.d.a(this.l);
        sg.bigo.ads.common.n.d.a(1, this.l, Math.max(j, 0L));
    }

    public final void a(String str, String str2) {
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", a1.a.n("addExtraHost, country=", str, ", host=", str2));
        if (d.a(str2)) {
            if (q.a((CharSequence) str)) {
                str = "all";
            }
            this.j.put(str, str2);
            if (this.f16310a.a(str, str2)) {
                this.f16310a.a(10L);
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "saveAsync, addExtraHost, delayMillis=10");
            }
        }
    }

    public final void a(@NonNull final String str, @NonNull final sg.bigo.ads.controller.a.a.g gVar, @Nullable final ValueCallback<a> valueCallback, @Nullable final ValueCallback<String> valueCallback2) {
        final k kVarA = gVar.a(str);
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] [saveAsync] fetch svr config, country=" + str + ", url=" + kVarA);
        this.f16310a.a(0L);
        if (kVarA == null) {
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue("not available url.");
            }
        } else {
            sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(new sg.bigo.ads.common.u.b.d(kVarA.f16384a), this.f16315i);
            aVar.k = sg.bigo.ads.common.u.a.e.b();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            sg.bigo.ads.common.u.g.a(aVar, new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.a, sg.bigo.ads.common.u.c.d>() { // from class: sg.bigo.ads.controller.a.b.9
                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ sg.bigo.ads.common.u.c.c a(@NonNull sg.bigo.ads.common.u.c.a aVar2) {
                    return new sg.bigo.ads.common.u.c.d(aVar2);
                }

                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull sg.bigo.ads.common.u.c.c cVar2) {
                    a0.g(0, 3, kVarA.f16384a, "AntiBan", new StringBuilder("[net disk] succeed to fetch net disk url: "));
                    String strA = ((sg.bigo.ads.common.u.c.d) cVar2).a();
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(new a(kVarA, strA, jElapsedRealtime, (byte) 0));
                    }
                }

                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull sg.bigo.ads.common.u.h hVar) {
                    sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] try another net disk url due to failed to fetch net disk url: " + kVarA.f16384a);
                    sg.bigo.ads.core.d.b.a(jElapsedRealtime > 0 ? SystemClock.elapsedRealtime() - jElapsedRealtime : 0L, false, kVarA.f16384a, 4000, "NetError:" + hVar.f15988a + ", " + hVar.getMessage());
                    b.this.a(str, gVar, valueCallback, valueCallback2);
                }
            });
        }
    }

    public final boolean a(String str, final ValueCallback<a> valueCallback, ValueCallback<String> valueCallback2) {
        final sg.bigo.ads.controller.a.a.e eVar = this.f16310a.k;
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] fetch free svr config, canFetch=" + eVar.a());
        if (!eVar.a()) {
            this.f16314f.set(false);
            return false;
        }
        eVar.b();
        a(str, eVar, new ValueCallback<a>() { // from class: sg.bigo.ads.controller.a.b.8
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(a aVar) {
                eVar.a(true);
                b.this.f16310a.a(0L);
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] [saveAsync], fetch third free svr config, onSuccess");
                valueCallback.onReceiveValue(aVar);
            }
        }, valueCallback2);
        return true;
    }

    public static /* synthetic */ boolean a(b bVar, final String str, boolean z2) {
        bVar.e.compareAndSet(false, z2);
        if (!bVar.f16313d.compareAndSet(false, true)) {
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] fetch pay svr config return because is fetching, fetch free svr config after fail -> ".concat(String.valueOf(z2)));
            return false;
        }
        sg.bigo.ads.controller.a.a.f fVar = bVar.f16310a.j;
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] fetch pay svr config, canFetch=" + fVar.a() + ", fetch free svr config after fail -> " + z2);
        final ValueCallback<a> valueCallback = new ValueCallback<a>() { // from class: sg.bigo.ads.controller.a.b.5
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(a aVar) {
                k kVar;
                a aVar2 = aVar;
                b.this.f16313d.set(false);
                b.this.e.set(false);
                b.this.f16314f.set(false);
                if (aVar2 == null || (kVar = aVar2.f16339a) == null) {
                    return;
                }
                b.this.a(aVar2.f16340b, kVar.f16384a, aVar2.f16341c, true);
            }
        };
        final ValueCallback<String> valueCallback2 = new ValueCallback<String>() { // from class: sg.bigo.ads.controller.a.b.6
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str2) {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] all svr urls are fail");
                b.this.e.set(false);
                b.this.f16314f.set(false);
            }
        };
        if (fVar.a()) {
            fVar.b();
            bVar.a(str, fVar, valueCallback, new ValueCallback<String>() { // from class: sg.bigo.ads.controller.a.b.7
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str2) {
                    b.this.f16313d.set(false);
                    if (b.this.e.compareAndSet(true, false) && b.this.f16314f.compareAndSet(false, true)) {
                        b.this.a(str, valueCallback, valueCallback2);
                    } else {
                        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] all pay svr urls are fail");
                    }
                }
            });
            return true;
        }
        if (bVar.e.compareAndSet(true, false) && bVar.f16314f.compareAndSet(false, true)) {
            bVar.a(str, valueCallback, valueCallback2);
        }
        bVar.f16313d.set(false);
        return false;
    }

    public static /* synthetic */ boolean a(b bVar, final k.a aVar) {
        final sg.bigo.ads.controller.a.a.c cVar = bVar.f16310a.g;
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[sdk config] fetch sdk config, canFetch=" + cVar.a() + ", ignoreFetchInterval=false");
        if (!bVar.f16312c.compareAndSet(false, true)) {
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[sdk config] fetch sdk config return because it is fetching.");
            return false;
        }
        if (!cVar.a()) {
            bVar.f16312c.set(false);
            return false;
        }
        cVar.g = System.currentTimeMillis();
        bVar.f16310a.a(0L);
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], fetch sdk config");
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        new sg.bigo.ads.controller.g.k(bVar.f16311b, bVar, new k.a() { // from class: sg.bigo.ads.controller.a.b.4
            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str, int i2, int i8, int i9, @NonNull String str2, @Nullable Map<String, Object> map) {
                int i10;
                int i11;
                String str3;
                b.this.f16312c.set(false);
                if (TextUtils.isEmpty(l.a(map, "host_cfg"))) {
                    long jElapsedRealtime2 = jElapsedRealtime > 0 ? SystemClock.elapsedRealtime() - jElapsedRealtime : 0L;
                    i10 = i8;
                    i11 = i9;
                    StringBuilder sbW = a1.a.w(i10, "code=", ",subCode=", i11, ",message=");
                    str3 = str2;
                    sbW.append(str3);
                    sg.bigo.ads.core.d.b.a(jElapsedRealtime2, false, str, 4001, sbW.toString());
                } else {
                    i10 = i8;
                    i11 = i9;
                    str3 = str2;
                }
                k.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(str, i2, i10, i11, str3, map);
                }
                sg.bigo.ads.controller.b bVar2 = b.this.g;
                if (bVar2 != null) {
                    bVar2.a(i2, i8, i9, str2, map);
                }
            }

            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str, int i2, String str2, @Nullable Map<String, Object> map) {
                String str3;
                b.this.f16312c.set(false);
                cVar.h = System.currentTimeMillis();
                b.this.f16310a.a(0L);
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], fetch sdk config, on sdk config fetch success");
                if (TextUtils.isEmpty(l.a(map, "host_cfg"))) {
                    str3 = str;
                    sg.bigo.ads.core.d.b.a(jElapsedRealtime > 0 ? SystemClock.elapsedRealtime() - jElapsedRealtime : 0L, false, str3, 4002, "host_cfg is empty.");
                } else {
                    str3 = str;
                }
                k.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(str3, i2, str2, map);
                }
                sg.bigo.ads.controller.b bVar2 = b.this.g;
                if (bVar2 != null) {
                    bVar2.a(i2, str2);
                }
            }
        }).b();
        return true;
    }
}
