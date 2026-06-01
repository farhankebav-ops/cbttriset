package sg.bigo.ads.controller.a.b;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.common.g;
import sg.bigo.ads.controller.b.h;
import sg.bigo.ads.controller.g.k;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Pair<String, Integer> f16360a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final k.a f16361i;

    public e(sg.bigo.ads.controller.a.b bVar, g gVar, sg.bigo.ads.controller.b.d dVar, h hVar) {
        super(bVar, gVar, dVar, hVar);
        this.f16360a = null;
        this.f16361i = new k.a() { // from class: sg.bigo.ads.controller.a.b.e.1
            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str, int i2, int i8, int i9, @NonNull String str2, @Nullable Map<String, Object> map) {
                e.this.h.set(false);
                e eVar = e.this;
                eVar.a(eVar.f16360a, c.a(i9));
            }

            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str, int i2, String str2, @Nullable Map<String, Object> map) {
                e.this.h.set(false);
                e eVar = e.this;
                eVar.a(eVar.f16360a, false);
            }
        };
    }

    @Override // sg.bigo.ads.controller.a.b.c
    public final sg.bigo.ads.common.n.e a() {
        return sg.bigo.ads.common.u.a.e.b();
    }

    @Override // sg.bigo.ads.controller.a.b.c
    public final sg.bigo.ads.controller.a.a.b b() {
        return this.f16348b.f16310a.g;
    }

    @Override // sg.bigo.ads.controller.a.b.c
    public final void a(Pair<String, Integer> pair) {
        if (pair == null) {
            return;
        }
        this.h.set(true);
        this.f16360a = pair;
        final sg.bigo.ads.controller.a.b bVar = this.f16348b;
        String str = (String) pair.first;
        final k.a aVar = this.f16361i;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final sg.bigo.ads.controller.a.a.c cVar = bVar.f16310a.g;
        k kVar = new k(bVar.f16311b, bVar, new k.a() { // from class: sg.bigo.ads.controller.a.b.3
            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str2, int i2, int i8, int i9, @NonNull String str3, @Nullable Map<String, Object> map) {
                k.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(str2, i2, i8, i9, str3, map);
                }
            }

            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str2, int i2, String str3, @Nullable Map<String, Object> map) {
                cVar.h = System.currentTimeMillis();
                b.this.f16310a.a(0L);
                k.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(str2, i2, str3, map);
                }
            }
        });
        kVar.f16656i = str;
        kVar.b();
    }
}
