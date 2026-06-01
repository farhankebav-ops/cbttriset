package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.UUID;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b<T extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15461d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15462f;

    @NonNull
    public final a g = new a(0);

    public static class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f15464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        String f15465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        String f15466d;

        @Nullable
        String e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f15467f;
        int g;
        String h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f15468i;
        long j;
        public long k;
        private long l;
        private long m;

        private a() {
            this.f15464b = UUID.randomUUID().toString();
            this.f15463a = "";
            this.f15465c = "";
            this.f15466d = "";
            this.e = "";
            this.g = 0;
            this.f15468i = 0;
            this.h = "";
            this.j = 0L;
            this.k = 0L;
            this.l = 0L;
            this.m = 0L;
        }

        public final void a() {
            if (this.l == 0) {
                this.l = System.currentTimeMillis();
            }
        }

        public final void b() {
            if (this.m == 0) {
                this.m = System.currentTimeMillis();
            }
        }

        @Override // sg.bigo.ads.api.core.h
        @Nullable
        public final String c() {
            return this.f15464b;
        }

        @Override // sg.bigo.ads.api.core.h
        @Nullable
        public final String d() {
            return this.f15465c;
        }

        @Override // sg.bigo.ads.api.core.h
        @Nullable
        public final String e() {
            return this.f15466d;
        }

        @Override // sg.bigo.ads.api.core.h
        @Nullable
        public final String f() {
            return this.e;
        }

        @Override // sg.bigo.ads.api.core.h
        public final String g() {
            return this.f15463a;
        }

        @Override // sg.bigo.ads.api.core.h
        public final int h() {
            return this.g;
        }

        @Override // sg.bigo.ads.api.core.h
        public final String i() {
            return this.h;
        }

        @Override // sg.bigo.ads.api.core.h
        public final int j() {
            return this.f15468i;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long k() {
            return this.f15467f;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long l() {
            return this.j;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long m() {
            return this.k;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long n() {
            return this.l;
        }

        @Override // sg.bigo.ads.api.core.h
        public final long o() {
            return this.m;
        }

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    public b(String str, @Nullable String str2) {
        this.f15458a = str;
        this.f15459b = str2;
    }

    @Nullable
    public T a() {
        return null;
    }

    @Nullable
    public sg.bigo.ads.api.core.d b() {
        if (q.a((CharSequence) this.f15458a)) {
            return new sg.bigo.ads.api.core.d(1019, 10001, "Please pass slot id when constructing an ad request");
        }
        return null;
    }

    public abstract int c();

    public final void c(int i2) {
        this.g.g = i2;
    }

    @Nullable
    public Map<String, Object> d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public l h() {
        return null;
    }

    public final void a(String str) {
        this.g.f15463a = str;
    }

    public final void b(int i2) {
        a aVar = this.g;
        if (aVar.j == 0) {
            aVar.f15468i = i2;
            aVar.j = System.currentTimeMillis();
        }
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        a aVar = this.g;
        aVar.f15465c = str;
        aVar.f15466d = str2;
        aVar.e = str3;
    }

    public final void b(String str) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.h = str;
        }
    }

    public boolean a(int i2) {
        return i2 != c();
    }
}
