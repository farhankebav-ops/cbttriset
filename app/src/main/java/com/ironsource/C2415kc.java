package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.ironsource.kc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2415kc {
    public static final a e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile C2415kc f8855f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dd f8856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f8857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private V3 f8859d;

    /* JADX INFO: renamed from: com.ironsource.kc$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final C2415kc a() {
            C2415kc c2415kc;
            C2415kc c2415kc2 = C2415kc.f8855f;
            if (c2415kc2 != null) {
                return c2415kc2;
            }
            synchronized (this) {
                c2415kc = C2415kc.f8855f;
                if (c2415kc == null) {
                    c2415kc = new C2415kc(null);
                    C2415kc.f8855f = c2415kc;
                }
            }
            return c2415kc;
        }

        private a() {
        }

        public final InterfaceC2279d1 a(IronSource.a adFormat) {
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            C2415kc c2415kc = C2415kc.f8855f;
            V3 v3B = c2415kc != null ? c2415kc.b() : null;
            C2415kc c2415kc2 = C2415kc.f8855f;
            Dd ddE = c2415kc2 != null ? c2415kc2.e() : null;
            if (v3B != null && ddE != null) {
                return new C2564t3(v3B, ddE, adFormat);
            }
            return new C2464n5();
        }
    }

    public /* synthetic */ C2415kc(kotlin.jvm.internal.f fVar) {
        this();
    }

    public static final C2415kc d() {
        return e.a();
    }

    public final V3 b() {
        return this.f8859d;
    }

    public final AtomicBoolean c() {
        return this.f8857b;
    }

    public final Dd e() {
        return this.f8856a;
    }

    public final String f() {
        return this.f8858c;
    }

    public final void g() {
        this.f8857b.set(true);
    }

    private C2415kc() {
        this.f8857b = new AtomicBoolean(false);
        this.f8858c = "";
    }

    public final void a(Dd dd) {
        this.f8856a = dd;
    }

    public final void a(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f8858c = str;
    }

    public final void a(V3 v32) {
        this.f8859d = v32;
    }
}
