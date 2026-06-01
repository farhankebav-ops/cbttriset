package sg.bigo.ads.controller.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.j;
import sg.bigo.ads.controller.g.m;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends a {
    public f(@NonNull g gVar, @NonNull sg.bigo.ads.controller.a.b bVar) {
        super(gVar, bVar);
    }

    @Override // sg.bigo.ads.common.j
    public final void a(@NonNull Map<String, Object> map, final j.a aVar) {
        new m(map, this.f16527a, this.f16528b, new sg.bigo.ads.controller.b() { // from class: sg.bigo.ads.controller.d.f.1
            @Override // sg.bigo.ads.controller.e
            public final void a(int i2, int i8, int i9, @NonNull String str, @Nullable Object obj) {
                aVar.a(i8, i9, str);
            }

            @Override // sg.bigo.ads.controller.b
            public final void a(int i2, @NonNull String str) {
                aVar.a();
            }
        }).b();
    }
}
