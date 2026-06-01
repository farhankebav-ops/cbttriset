package sg.bigo.ads.core.player.a;

import android.os.SystemClock;
import com.ironsource.C2300e4;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import sg.bigo.ads.common.m;

/* JADX INFO: loaded from: classes6.dex */
final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile c f17291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile sg.bigo.ads.common.h.a f17292c;
    private final String g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicInteger f17290a = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile long f17293d = 0;
    volatile long e = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicInteger f17294f = new AtomicInteger(0);

    public e(String str) {
        this.g = (String) m.a(str);
    }

    public final synchronized boolean a() {
        c cVar;
        try {
            if (this.f17291b == null) {
                String str = this.g;
                HashMap map = new HashMap();
                for (String str2 : str.substring(str.indexOf("?") + 1).split(C2300e4.i.f8401c)) {
                    String[] strArrSplit = str2.split(C2300e4.i.f8399b);
                    if (strArrSplit.length == 2) {
                        map.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                this.f17292c = sg.bigo.ads.core.player.b.a().g.a((String) map.get("path"), (String) map.get("name"));
                if (this.f17292c == null) {
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "downloadInfo = null");
                    cVar = null;
                } else {
                    cVar = new c(this.f17292c);
                }
            } else {
                cVar = this.f17291b;
            }
            this.f17291b = cVar;
        } catch (Throwable th) {
            throw th;
        }
        return this.f17291b != null;
    }

    public final synchronized void b() {
        if (this.f17290a.decrementAndGet() <= 0) {
            c cVar = this.f17291b;
            synchronized (cVar.f17309c) {
                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Shutdown proxy for ");
                cVar.f17310d = true;
                cVar.f17308b.b();
            }
            this.f17291b = null;
        }
    }
}
