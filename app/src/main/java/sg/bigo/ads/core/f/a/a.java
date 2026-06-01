package sg.bigo.ads.core.f.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C0316a> f16994a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<C0316a> f16995b = new ArrayList();

    /* JADX INFO: renamed from: sg.bigo.ads.core.f.a.a$a, reason: collision with other inner class name */
    public static final class C0316a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f16997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f16998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f16999d;

        @Nullable
        public final String e;

        public C0316a(String str, int i2, int i8, @Nullable String str2, String str3) {
            this.f16997b = str;
            this.f16998c = i2;
            this.f16999d = i8;
            this.e = str2;
            this.f16996a = str3;
        }

        public final boolean a() {
            return !TextUtils.isEmpty(this.f16997b);
        }

        public final boolean b() {
            return "image/jpeg".equalsIgnoreCase(this.e) || "image/png".equalsIgnoreCase(this.e);
        }

        public final boolean c() {
            return "image/gif".equalsIgnoreCase(this.e);
        }
    }

    @Nullable
    public final C0316a a() {
        return a(this.f16994a);
    }

    public static C0316a a(List<C0316a> list) {
        if (list == null) {
            return null;
        }
        for (C0316a c0316a : list) {
            if (c0316a != null) {
                return c0316a;
            }
        }
        return null;
    }
}
