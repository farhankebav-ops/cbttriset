package sg.bigo.ads.common.m;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.vungle.ads.internal.model.Cookie;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15804a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f15805b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f15806c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f15807d = "";
    private static boolean e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static SharedPreferences.OnSharedPreferenceChangeListener f15808f = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: sg.bigo.ads.common.m.b.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (q.a((CharSequence) str)) {
                return;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "GdprManager", "Listener SharedPreferenceChanged, key: ".concat(String.valueOf(str)));
            str.getClass();
            switch (str) {
                case "IABTCF_PurposeConsents":
                    b.a(sharedPreferences);
                    break;
                case "IABTCF_PurposeLegitimateInterests":
                    b.c(sharedPreferences);
                    break;
                case "IABTCF_gdprApplies":
                    b.b(sharedPreferences);
                    break;
                case "IABTCF_TCString":
                    b.d(sharedPreferences);
                    break;
                default:
                    return;
            }
            b.h();
        }
    };
    private static Context g;

    public static void a(@NonNull Context context) {
        g = context;
        sg.bigo.ads.common.x.a.a(context.getPackageName(), f15808f);
    }

    public static String b() {
        if (q.a((CharSequence) f15804a) && a()) {
            f15804a = sg.bigo.ads.common.x.a.e(g.getPackageName());
        }
        return f15804a;
    }

    public static int c() {
        if (g == null || !sg.bigo.ads.common.x.b.a()) {
            return f15805b;
        }
        f15805b = e(g) ? sg.bigo.ads.common.x.a.g(g.getPackageName()) : -1;
        return f15805b;
    }

    public static String d() {
        if (q.a((CharSequence) f15806c) && a()) {
            f15806c = sg.bigo.ads.common.x.a.h(g.getPackageName());
        }
        return f15806c;
    }

    public static String e() {
        if (q.a((CharSequence) f15807d) && a()) {
            f15807d = sg.bigo.ads.common.x.a.f(g.getPackageName());
        }
        return f15807d;
    }

    public static boolean f() {
        return e;
    }

    public static void g() {
        e = false;
    }

    public static /* synthetic */ boolean h() {
        e = true;
        return true;
    }

    public static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            f15804a = sharedPreferences.getString("IABTCF_PurposeConsents", "");
        } catch (Exception unused) {
            f15804a = "";
        }
    }

    public static String b(Context context) {
        return (context == null || !sg.bigo.ads.common.x.b.a()) ? f15804a : sg.bigo.ads.common.x.a.e(context.getPackageName());
    }

    public static int c(Context context) {
        return (context == null || !sg.bigo.ads.common.x.b.a()) ? f15805b : sg.bigo.ads.common.x.a.g(context.getPackageName());
    }

    public static String d(Context context) {
        return (context == null || !sg.bigo.ads.common.x.b.a()) ? f15806c : sg.bigo.ads.common.x.a.h(context.getPackageName());
    }

    public static boolean e(Context context) {
        if (context == null || !sg.bigo.ads.common.x.b.a()) {
            return false;
        }
        return sg.bigo.ads.common.x.a.a(context.getPackageName() + "_preferences", Cookie.IABTCF_GDPR_APPLIES);
    }

    public static boolean a() {
        return g != null;
    }

    public static void b(SharedPreferences sharedPreferences) {
        int iIntValue;
        if (sharedPreferences == null || sharedPreferences.getAll() == null) {
            return;
        }
        Object obj = sharedPreferences.getAll().get(Cookie.IABTCF_GDPR_APPLIES);
        if (obj instanceof Integer) {
            iIntValue = ((Integer) obj).intValue();
        } else {
            if (!(obj instanceof String)) {
                return;
            }
            try {
                f15805b = Integer.parseInt((String) obj);
                return;
            } catch (Exception unused) {
                iIntValue = 0;
            }
        }
        f15805b = iIntValue;
    }

    public static void c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            f15806c = sharedPreferences.getString("IABTCF_PurposeLegitimateInterests", "");
        } catch (Exception unused) {
            f15806c = "";
        }
    }

    public static void d(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            f15807d = sharedPreferences.getString("IABTCF_TCString", "");
        } catch (Exception unused) {
            f15807d = "";
        }
    }
}
