package sg.bigo.ads.ad.interstitial.a.b;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface a {

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a.b.a$a, reason: collision with other inner class name */
    public static final class C0248a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Set<Integer> f14272a = new HashSet();

        public final void a(sg.bigo.ads.api.core.c cVar, int i2, long j) {
            if (this.f14272a.contains(Integer.valueOf(i2))) {
                return;
            }
            this.f14272a.add(Integer.valueOf(i2));
            sg.bigo.ads.core.d.b.a(cVar, i2, j, (String) null, -1, (String) null, (String) null);
        }

        public final void a(sg.bigo.ads.api.core.c cVar, int i2, long j, @Nullable String str, int i8, @Nullable String str2, @Nullable String str3) {
            if (this.f14272a.contains(Integer.valueOf(i2))) {
                return;
            }
            this.f14272a.add(Integer.valueOf(i2));
            sg.bigo.ads.core.d.b.a(cVar, i2, j, str, i8, str2, str3);
        }
    }

    @Nullable
    View a();

    void a(int i2);

    void a(int i2, int i8);

    boolean a(Context context);

    boolean b();

    void c();

    void d();

    void e();

    void f();
}
