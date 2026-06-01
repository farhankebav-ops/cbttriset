package sg.bigo.ads.controller.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.a.a.b;
import sg.bigo.ads.controller.a.b.d;

/* JADX INFO: loaded from: classes6.dex */
public interface f extends c {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final sg.bigo.ads.controller.a.a f16366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final sg.bigo.ads.controller.a.a.b f16367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final sg.bigo.ads.common.g f16368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final sg.bigo.ads.api.a.h f16369d;
        private final String e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f16370f;
        private j g;
        private j h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f16371i;
        private boolean j;
        private boolean k;
        private String l;
        private g m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f16372n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final AtomicBoolean f16373o = new AtomicBoolean(false);
        private final AtomicBoolean p = new AtomicBoolean(false);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final Runnable f16374q = new Runnable() { // from class: sg.bigo.ads.controller.a.f.a.1
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] run timeout task");
                a.this.b();
            }
        };

        public a(@NonNull sg.bigo.ads.controller.a.a aVar, @NonNull sg.bigo.ads.common.g gVar, @NonNull sg.bigo.ads.api.a.h hVar, @NonNull String str, String str2) {
            this.f16372n = null;
            boolean z2 = false;
            this.f16366a = aVar;
            this.f16368c = gVar;
            this.f16369d = hVar;
            this.e = str;
            this.f16372n = str2;
            str.getClass();
            if (str.equals("/Ad/GetSDKConfig")) {
                this.f16367b = aVar.g;
                z2 = true;
            } else {
                this.f16367b = !str.equals("/Ad/ReportUniBaina") ? aVar.f16262i : aVar.h;
            }
            this.f16371i = z2;
        }

        @Override // sg.bigo.ads.common.u.a
        public final String a() {
            g gVar;
            g gVar2;
            String str = this.f16372n;
            if (str != null) {
                return sg.bigo.ads.b.a(str, this.e);
            }
            if (q.a((CharSequence) this.f16370f)) {
                String strV = this.f16368c.v();
                e eVarA = this.f16367b.a(strV, this.f16369d.s());
                sg.bigo.ads.controller.a.a aVar = this.f16366a;
                this.j = aVar.f16260a;
                this.k = aVar.e;
                this.l = aVar.f16261f;
                this.g = eVarA.f16363a;
                this.h = this.f16367b.f16269a;
                d.a.f16359a.a(this.e, this.g, this.h);
                this.f16370f = sg.bigo.ads.b.a(this.g.c() ? this.g.b() : this.g.a(), this.e);
                if (eVarA.f16365c && (gVar2 = this.m) != null) {
                    gVar2.a(this.e);
                }
                if (eVarA.f16364b && (gVar = this.m) != null) {
                    gVar.a(strV, this.f16371i);
                }
            }
            return this.f16370f;
        }

        @Override // sg.bigo.ads.common.u.a
        public final void b() {
            g gVar;
            boolean zEquals = false;
            if (!this.f16373o.compareAndSet(false, true)) {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] mark fail do nth, it has marked.");
                return;
            }
            sg.bigo.ads.common.n.d.a(this.f16374q);
            String strD = d();
            a0.g(0, 3, this.f16370f, "AntiBan", new StringBuilder("[bigo url] mark fail, url is "));
            sg.bigo.ads.controller.a.a.b bVar = this.f16367b;
            b.C0305b c0305b = bVar.f16270b;
            if (c0305b != null && (zEquals = TextUtils.equals(strD, c0305b.a()))) {
                bVar.f16271c++;
            }
            if (zEquals && (gVar = this.m) != null) {
                gVar.a(this.e);
            }
        }

        @Override // sg.bigo.ads.common.u.a
        public final void c() {
            g gVar;
            boolean z2 = false;
            if (!this.f16373o.compareAndSet(false, true)) {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[bigo url] mark success do nth, it has marked.");
                return;
            }
            sg.bigo.ads.common.n.d.a(this.f16374q);
            String strD = d();
            a0.g(0, 3, this.f16370f, "AntiBan", new StringBuilder("[bigo url] mark success, url is "));
            sg.bigo.ads.controller.a.a.b bVar = this.f16367b;
            b.C0305b c0305b = bVar.f16270b;
            if (c0305b != null) {
                boolean z7 = TextUtils.equals(strD, c0305b.a()) && bVar.f16271c > 0;
                if (z7) {
                    bVar.f16271c = 0;
                }
                z2 = z7;
            }
            if (z2 && (gVar = this.m) != null) {
                gVar.a(this.e);
            }
        }

        @Override // sg.bigo.ads.common.u.a
        public final String d() {
            j jVar = this.g;
            return jVar != null ? jVar.a() : "";
        }

        @Override // sg.bigo.ads.common.u.a
        public final boolean e() {
            j jVar = this.g;
            return jVar != null && jVar.c();
        }

        @Override // sg.bigo.ads.common.u.a
        public final String f() {
            j jVar = this.h;
            return jVar != null ? jVar.a() : "";
        }

        @Override // sg.bigo.ads.controller.a.c
        @Nullable
        public final j g() {
            return this.g;
        }

        @Override // sg.bigo.ads.controller.a.c
        public final boolean h() {
            return this.k;
        }

        @Override // sg.bigo.ads.controller.a.c
        public final String i() {
            return this.l;
        }

        @Override // sg.bigo.ads.controller.a.c
        public final void a(long j) {
            if (this.p.compareAndSet(false, true)) {
                sg.bigo.ads.common.n.d.a(3, this.f16374q, j);
            }
        }

        @Override // sg.bigo.ads.controller.a.c
        public final void a(g gVar) {
            this.m = gVar;
        }
    }
}
