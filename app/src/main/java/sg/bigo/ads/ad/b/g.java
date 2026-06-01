package sg.bigo.ads.ad.b;

import android.content.Context;
import androidx.annotation.NonNull;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.player.b;

/* JADX INFO: loaded from: classes6.dex */
public final class g<T extends Ad> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    T f13944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    Context f13945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    sg.bigo.ads.core.a.a f13946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f13947d;

    @NonNull
    d.a<T> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final sg.bigo.ads.core.g.c f13948f;
    b.a g;
    sg.bigo.ads.core.player.b.d h;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b.g$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f13949a;

        public AnonymousClass1(int i2) {
            this.f13949a = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2 = this.f13949a;
            if (i2 != 0) {
                g gVar = g.this;
                gVar.e.a(gVar.f13944a, 1006, i2, "Invalid VPAID media files.");
                return;
            }
            g.this.g = new b.a() { // from class: sg.bigo.ads.ad.b.g.1.1
                @Override // sg.bigo.ads.core.player.b.a
                public final void a() {
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void b(int i8) {
                    g gVar2 = g.this;
                    gVar2.e.a(gVar2.f13944a, 1006, i8, "Failed to download VPAID.");
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void a(int i8) {
                    g gVar2 = g.this;
                    if (gVar2.f13947d == null) {
                        gVar2.e.a(gVar2.f13944a, 1006, 10075, "VPAID video config is empty.");
                    } else {
                        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.g.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                sg.bigo.ads.api.c.b bVarB = sg.bigo.ads.api.c.b.b(g.this.f13946c.x());
                                bVarB.f15474c = false;
                                g gVar3 = g.this;
                                p pVar = gVar3.f13947d;
                                int i9 = pVar.f17065x;
                                int i10 = pVar.f17064w;
                                g gVar4 = g.this;
                                gVar3.h = new sg.bigo.ads.core.player.b.d(gVar4.f13945b, i9, i10, bVarB, gVar4.f13946c);
                                g gVar5 = g.this;
                                gVar5.h.setOnEventListener(gVar5.f13948f);
                            }
                        });
                    }
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void a(String str, sg.bigo.ads.common.h.a aVar) {
                }
            };
            sg.bigo.ads.core.player.b bVarA = sg.bigo.ads.core.player.b.a();
            g gVar2 = g.this;
            bVarA.a(gVar2.f13945b, gVar2.f13946c, gVar2.g);
        }
    }

    public g(@NonNull Context context, sg.bigo.ads.core.g.c cVar, @NonNull sg.bigo.ads.core.a.a aVar, p pVar, @NonNull d.a<T> aVar2, @NonNull T t3) {
        this.f13945b = context;
        this.f13948f = cVar;
        this.f13946c = aVar;
        this.f13947d = pVar;
        this.e = aVar2;
        this.f13944a = t3;
    }

    public final boolean a() {
        return this.f13946c.at() == 1;
    }
}
