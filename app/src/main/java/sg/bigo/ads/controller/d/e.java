package sg.bigo.ads.controller.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.j;
import sg.bigo.ads.controller.g.l;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends a {
    public e(@NonNull g gVar, @Nullable sg.bigo.ads.controller.a.b bVar) {
        super(gVar, bVar);
    }

    @Override // sg.bigo.ads.common.j
    public final void a(@NonNull Map<String, Object> map, @Nullable final j.a aVar) {
        new l(map, this.f16527a, this.f16528b, new sg.bigo.ads.controller.b() { // from class: sg.bigo.ads.controller.d.e.1
            @Override // sg.bigo.ads.controller.e
            public final void a(int i2, int i8, int i9, @NonNull String str, @Nullable Object obj) {
                j.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(i8, i9, str);
                }
            }

            @Override // sg.bigo.ads.controller.b
            public final void a(int i2, @NonNull String str) {
                j.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }).b();
    }
}
