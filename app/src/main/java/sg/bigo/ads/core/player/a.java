package sg.bigo.ads.core.player;

import com.ironsource.adqualitysdk.sdk.i.a0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f17264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<String, b> f17265b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, RunnableC0325a> f17266c = new HashMap();

    /* JADX INFO: renamed from: sg.bigo.ads.core.player.a$a, reason: collision with other inner class name */
    public class RunnableC0325a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<sg.bigo.ads.common.h.a> f17267a;

        public RunnableC0325a(sg.bigo.ads.common.h.a aVar) {
            this.f17267a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public final void run() {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    WeakReference<sg.bigo.ads.common.h.a> weakReference = RunnableC0325a.this.f17267a;
                    if (weakReference == null || weakReference.get() == null) {
                        return;
                    }
                    RunnableC0325a runnableC0325a = RunnableC0325a.this;
                    a.this.f17266c.remove(runnableC0325a.f17267a.get().f15727a);
                    RunnableC0325a runnableC0325a2 = RunnableC0325a.this;
                    a.this.f17264a.c(runnableC0325a2.f17267a.get());
                }
            });
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        sg.bigo.ads.common.h.a f17270a;

        public b(sg.bigo.ads.common.h.a aVar) {
            this.f17270a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    b bVar = b.this;
                    sg.bigo.ads.common.h.a aVar = bVar.f17270a;
                    if (aVar != null) {
                        a.this.f17265b.remove(aVar.f15727a);
                        b bVar2 = b.this;
                        a.this.f17264a.b(bVar2.f17270a);
                        str = "call onDownloadFillTime";
                    } else {
                        str = "downloadInfo is null, not call onDownloadFillTime";
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "AdFillStrategyManager", str);
                }
            });
        }
    }

    public interface c {
        void b(sg.bigo.ads.common.h.a aVar);

        void c(sg.bigo.ads.common.h.a aVar);
    }

    public a(c cVar) {
        this.f17264a = cVar;
    }

    public final void a(sg.bigo.ads.common.h.a aVar) {
        if (aVar.c()) {
            if (aVar.e() > 0) {
                c(aVar);
            }
            if (aVar.f() > 0) {
                if (this.f17266c.containsKey(aVar.f15727a)) {
                    sg.bigo.ads.common.n.d.a(this.f17266c.remove(aVar.f15727a));
                }
                RunnableC0325a runnableC0325a = new RunnableC0325a(aVar);
                this.f17266c.put(aVar.f15727a, runnableC0325a);
                sg.bigo.ads.common.n.d.a(3, runnableC0325a, ((long) aVar.f()) * 1000);
            }
        }
    }

    public final void b(sg.bigo.ads.common.h.a aVar) {
        if (this.f17266c.containsKey(aVar.f15727a)) {
            sg.bigo.ads.common.n.d.a(this.f17266c.get(aVar.f15727a));
            this.f17266c.remove(aVar.f15727a);
        }
    }

    public final void c(sg.bigo.ads.common.h.a aVar) {
        if (this.f17265b.containsKey(aVar.f15727a)) {
            sg.bigo.ads.common.n.d.a(this.f17265b.remove(aVar.f15727a));
            a0.g(0, 3, aVar.f15727a, "AdFillStrategyManager", new StringBuilder("fillTimeRunnableList.containsKey: "));
        }
        b bVar = new b(aVar);
        this.f17265b.put(aVar.f15727a, bVar);
        sg.bigo.ads.common.n.d.a(3, bVar, ((long) aVar.e()) * 1000);
        sg.bigo.ads.common.t.a.a(0, 3, "AdFillStrategyManager", "startFillTimeRunnable at: " + aVar.e());
    }
}
