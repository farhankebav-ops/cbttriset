package sg.bigo.ads.core.e.a;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.k;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.core.e.a.g;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f16951f = false;
    private static final d g = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f16954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f16955d;
    public Context e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<f> f16952a = p.a(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f16953b = new AtomicBoolean(false);
    private final Runnable h = new Runnable() { // from class: sg.bigo.ads.core.e.a.d.2
        /* JADX WARN: Removed duplicated region for block: B:107:0x02ab A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0145  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0264  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x02bc  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 848
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.e.a.d.AnonymousClass2.run():void");
        }
    };

    public static d a() {
        return g;
    }

    public static /* synthetic */ boolean c() {
        f16951f = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        f16951f = true;
        b();
        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "startCheckRetryTrack");
        sg.bigo.ads.common.n.d.a(1, this.h, 20000L);
    }

    public final void b() {
        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "stopCheckRetryTrack");
        sg.bigo.ads.common.n.d.a(this.h);
    }

    public final void a(f fVar) {
        if (!f16951f) {
            d();
        }
        this.f16952a.add(fVar);
        g gVar = g.a.f16978a;
        g.a(fVar);
    }

    public final void b(final f fVar) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = g.a.f16978a;
                g.b(fVar);
            }
        });
    }
}
