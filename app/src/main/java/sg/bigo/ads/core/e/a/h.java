package sg.bigo.ads.core.e.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.Map;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.core.e.b;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f16979b = "h";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Map<String, String> f16981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r f16982d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16983f;
    private final String g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16984i;
    private final int[] h = {0, 30000, 300000};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16980a = 0;

    private h(@NonNull Map<String, String> map, r rVar, int i2, String str, String str2, String str3) {
        this.f16981c = map;
        this.f16982d = rVar;
        this.e = str;
        this.f16983f = str2;
        this.g = str3;
        this.f16984i = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (str == null || str.length() < 40) {
            return str;
        }
        return str.substring(0, 20) + "..." + str.substring(str.length() - 10);
    }

    public static /* synthetic */ void b(h hVar, Context context) {
        if (TextUtils.equals("va_show", hVar.e) || TextUtils.equals("va_cli", hVar.e) || TextUtils.equals("va_cpn_imp", hVar.e) || TextUtils.equals("va_cpn_cli", hVar.e)) {
            int i2 = hVar.f16980a + 1;
            hVar.f16980a = i2;
            hVar.a(context, i2);
        }
    }

    public static h a(@NonNull Map<String, String> map, r rVar, int i2, String str, String str2, String str3) {
        return new h(map, rVar, i2, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context) {
        String str = f16979b;
        StringBuilder sb = new StringBuilder("Vast tracker request start, action: ");
        sb.append(this.e);
        sb.append(", url: ");
        a0.g(0, 3, b(this.f16983f), str, sb);
        sg.bigo.ads.core.e.b.a(context, 0, this.e, new sg.bigo.ads.common.u.b.d(this.f16983f), this.g, this.f16984i, false, this.f16980a, this.f16981c, new b.a() { // from class: sg.bigo.ads.core.e.a.h.2
            @Override // sg.bigo.ads.core.e.b.a
            public final void a() {
                sg.bigo.ads.common.t.a.a(0, 3, h.f16979b, "Vast tracker request error, action: " + h.this.e + ", url: " + h.b(h.this.f16983f));
                h.b(h.this, context);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final void b() {
                sg.bigo.ads.common.t.a.a(0, 3, h.f16979b, "Vast tracker request success, action: " + h.this.e + ", url: " + h.b(h.this.f16983f));
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final boolean a(int i2) {
                return h.this.f16982d != null && h.this.f16982d.a(i2);
            }
        });
    }

    public final void a(final Context context, int i2) {
        if (i2 >= 3) {
            String str = f16979b;
            StringBuilder sb = new StringBuilder("Vast tracker retry time exceed, action: ");
            sb.append(this.e);
            sb.append(", url: ");
            a0.g(0, 3, b(this.f16983f), str, sb);
            return;
        }
        int[] iArr = this.h;
        int i8 = iArr[i2 % iArr.length];
        if (i8 <= 0) {
            a(context);
            return;
        }
        String str2 = f16979b;
        StringBuilder sbV = a1.a.v(i8, "Vast tracker retry after ", " ms, action: ");
        sbV.append(this.e);
        sbV.append(", url: ");
        sbV.append(b(this.f16983f));
        sg.bigo.ads.common.t.a.a(0, 3, str2, sbV.toString());
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.h.1
            @Override // java.lang.Runnable
            public final void run() {
                h.this.a(context);
            }
        }, i8);
    }
}
