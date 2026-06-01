package sg.bigo.ads.controller.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.k;
import sg.bigo.ads.controller.a.j;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    protected final sg.bigo.ads.controller.a.b f16533a;

    public static class a implements k.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final String f16534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f16535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f16536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private final String f16537d;

        public a(@Nullable String str, @Nullable j jVar) {
            this.f16534a = str;
            if (jVar != null) {
                boolean zC = jVar.c();
                this.f16536c = zC;
                this.f16535b = jVar.a();
                str = sg.bigo.ads.controller.a.d.a(str, zC ? jVar.b() : jVar.a());
            } else {
                this.f16536c = false;
                this.f16535b = "";
            }
            this.f16537d = str;
        }

        @Override // sg.bigo.ads.common.k.b
        @Nullable
        public final String a() {
            return this.f16537d;
        }

        @Override // sg.bigo.ads.common.k.b
        @Nullable
        public final String b() {
            return this.f16534a;
        }

        @Override // sg.bigo.ads.common.k.b
        @Nullable
        public final String c() {
            return this.f16535b;
        }

        @Override // sg.bigo.ads.common.k.b
        public final boolean d() {
            return this.f16536c;
        }
    }

    public d(@Nullable sg.bigo.ads.controller.a.b bVar) {
        this.f16533a = bVar;
    }

    @Override // sg.bigo.ads.common.k
    @NonNull
    public final k.b a(@Nullable String str) {
        sg.bigo.ads.controller.a.b bVar = this.f16533a;
        return new a(str, bVar != null ? bVar.f16310a.f16262i.f16270b : null);
    }
}
