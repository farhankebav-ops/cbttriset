package sg.bigo.ads.a;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColorInt
    private final int f13775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColorInt
    private final int f13776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13777d;
    private final Bitmap e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f13778f;
    private final b g;

    /* JADX INFO: renamed from: sg.bigo.ads.a.a$a, reason: collision with other inner class name */
    public static class C0225a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f13780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f13781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ColorInt
        private int f13782d = 0;

        @ColorInt
        private int e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f13783f = true;
        private Bitmap g;

        public final a a() {
            return new a(this.f13779a, this.f13782d, this.e, this.f13783f, this.g, this.f13780b, this.f13781c);
        }
    }

    public interface b {
        void a(Context context, String str, int i2, @Nullable String str2);

        void a(String str, String str2, String str3);
    }

    public interface c {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public a(String str, int i2, int i8, boolean z2, Bitmap bitmap, c cVar, b bVar) {
        this.f13774a = str;
        this.f13775b = i2;
        this.f13776c = i8;
        this.f13777d = z2;
        this.e = bitmap;
        this.f13778f = cVar;
        this.g = bVar;
    }

    public final void a(Context context) {
        sg.bigo.ads.a.c.a(context, this.f13774a, this.f13775b, this.f13776c, this.f13777d, this.e, this.f13778f, this.g);
    }
}
