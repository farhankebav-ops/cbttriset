package sg.bigo.ads.a;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.work.PeriodicWorkRequest;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import sg.bigo.ads.a.a.a;
import sg.bigo.ads.a.a.b;
import sg.bigo.ads.common.n.d;

/* JADX INFO: loaded from: classes6.dex */
final class b implements a.InterfaceC0226a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f13796c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.a.a.a f13797a = new sg.bigo.ads.a.a.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13799d = 300000;
    private final int e = 200;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set<String> f13798b = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<String, Long> f13800f = new HashMap<>();
    private int g = 0;
    private boolean h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13801i = false;
    private boolean j = true;
    private boolean k = false;

    public static /* synthetic */ String a(int i2) {
        switch (i2) {
            case 1:
                return "Navigation Started";
            case 2:
                return "Navigation Finished";
            case 3:
                return "Navigation Failed";
            case 4:
                return "Navigation Aborted";
            case 5:
                return "Tab Shown";
            case 6:
                return "Tab Hidden";
            default:
                return "Unknown Event";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void e() {
        final String next;
        Iterator<String> it;
        if (!this.f13801i) {
            this.k = false;
            return;
        }
        if (!this.k) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "The task of preload start.");
        }
        try {
            it = this.f13798b.iterator();
        } catch (Exception unused) {
            next = null;
        }
        if (!it.hasNext()) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "The task of preload stop.");
            this.k = false;
            return;
        }
        this.k = true;
        next = it.next();
        try {
            this.f13798b.remove(next);
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(next)) {
            return;
        }
        d.a(1, new Runnable() { // from class: sg.bigo.ads.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                CustomTabsSession customTabsSessionA;
                Long l = (Long) b.this.f13800f.get(next);
                if (l == null || SystemClock.elapsedRealtime() - l.longValue() > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                    Uri uri = Uri.parse(next);
                    sg.bigo.ads.a.a.a aVar = b.this.f13797a;
                    boolean zMayLaunchUrl = (aVar.f13784a == null || (customTabsSessionA = aVar.a()) == null) ? false : customTabsSessionA.mayLaunchUrl(uri, null, null);
                    StringBuilder sb = new StringBuilder("Preload url state: ");
                    sb.append(zMayLaunchUrl);
                    sb.append(", url: ");
                    a0.g(0, 3, next, "ChromeTabsStatic", sb);
                    if (!zMayLaunchUrl) {
                        sg.bigo.ads.core.d.b.a(3002, 10115, String.valueOf(next));
                    }
                    b.this.f13800f.put(next, Long.valueOf(SystemClock.elapsedRealtime()));
                } else {
                    a0.g(0, 3, next, "ChromeTabsStatic", new StringBuilder("The url that wait for preload has been preloaded before: "));
                }
                d.a(2, new Runnable() { // from class: sg.bigo.ads.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.e();
                    }
                }, 200L);
            }
        });
    }

    @Override // sg.bigo.ads.a.a.a.InterfaceC0226a
    public final void c() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs service connected.");
        this.f13801i = true;
        this.h = false;
        b();
    }

    @Override // sg.bigo.ads.a.a.a.InterfaceC0226a
    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs service disconnected.");
        this.f13801i = false;
        this.h = false;
    }

    @MainThread
    public final void b() {
        if (this.k) {
            return;
        }
        e();
    }

    public static b a() {
        return f13796c;
    }

    public final boolean a(Context context) {
        String str;
        if (!this.j) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome service is unavailable.");
            return false;
        }
        boolean zBindCustomTabsService = true;
        if (this.f13801i) {
            str = "Chrome service connected";
        } else {
            if (!this.h) {
                this.h = true;
                sg.bigo.ads.a.a.a aVar = this.f13797a;
                aVar.f13786c = this;
                if (aVar.f13784a == null) {
                    b.a aVarA = sg.bigo.ads.a.a.b.a(context);
                    if (aVarA == null || !aVarA.f13791a) {
                        zBindCustomTabsService = false;
                    } else {
                        sg.bigo.ads.a.a.c cVar = new sg.bigo.ads.a.a.c(aVar);
                        aVar.f13785b = cVar;
                        zBindCustomTabsService = CustomTabsClient.bindCustomTabsService(context, aVarA.e, cVar);
                    }
                }
                if (!zBindCustomTabsService) {
                    this.h = false;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    if (i2 < 3) {
                        this.j = false;
                    }
                }
                return zBindCustomTabsService;
            }
            str = "Chrome service connect trying.";
        }
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", str);
        return true;
    }
}
