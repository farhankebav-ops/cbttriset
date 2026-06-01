package sg.bigo.ads.common.t;

import android.util.Log;
import com.ironsource.C2300e4;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static void a(int i2, int i8, String str, String str2) {
        if (a(i2)) {
            if (i2 == 0) {
                str2 = a1.a.n(C2300e4.i.f8403d, str, "] ", str2);
            }
            Log.println(i8, "BigoAds", str2);
        }
    }

    public static void b(String str, String str2) {
        a(0, 5, str, str2);
    }

    public static void a(int i2, String str, String str2) {
        a(i2, 6, str, str2);
    }

    public static void a(String str, String str2) {
        a(0, 4, str, str2);
    }

    private static boolean a(int i2) {
        t.a();
        return t.b() ? i2 == 2 || i2 == 1 : i2 == 2;
    }
}
