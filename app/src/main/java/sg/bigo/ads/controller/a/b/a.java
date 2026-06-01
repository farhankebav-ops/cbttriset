package sg.bigo.ads.controller.a.b;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.b.h;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    sg.bigo.ads.controller.e.e f16342a;

    public a(sg.bigo.ads.controller.a.b bVar, g gVar, sg.bigo.ads.controller.b.d dVar, h hVar) {
        super(bVar, gVar, dVar, hVar);
    }

    @Override // sg.bigo.ads.controller.a.b.c
    public final sg.bigo.ads.common.n.e a() {
        return sg.bigo.ads.common.u.a.e.d();
    }

    @Override // sg.bigo.ads.controller.a.b.c
    public final sg.bigo.ads.controller.a.a.b b() {
        return this.f16348b.f16310a.f16262i;
    }

    @Override // sg.bigo.ads.controller.a.b.c
    public final void a(final Pair<String, Integer> pair) {
        g gVar;
        if (pair == null || (gVar = this.f16349c) == null || this.f16350d == null || this.e == null) {
            return;
        }
        String strA = gVar.a();
        if (q.a((CharSequence) strA) || !sg.bigo.ads.controller.e.c.a().a(strA)) {
            sg.bigo.ads.common.t.a.a(0, 3, "GlobalConfig", "app key is empty or invalid");
            return;
        }
        this.h.set(true);
        sg.bigo.ads.controller.g.h hVar = new sg.bigo.ads.controller.g.h(this.f16349c, this.f16348b, sg.bigo.ads.controller.b.e.E(), new sg.bigo.ads.controller.b() { // from class: sg.bigo.ads.controller.a.b.a.1
            @Override // sg.bigo.ads.controller.e
            public final void a(int i2, int i8, int i9, @NonNull String str, @Nullable Object obj) {
                a.this.h.set(false);
                a.this.a(pair, c.a(i9));
            }

            @Override // sg.bigo.ads.controller.b
            public final void a(int i2, @NonNull String str) {
                a.this.h.set(false);
                sg.bigo.ads.controller.e.e eVar = a.this.f16342a;
                if (eVar != null) {
                    eVar.a(i2, str, true);
                }
                a.this.a(pair, false);
            }
        });
        hVar.f16656i = (String) pair.first;
        hVar.b();
    }
}
