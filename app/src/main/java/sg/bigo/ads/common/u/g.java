package sg.bigo.ads.common.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.u.b;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f15987a;

    @NonNull
    public static c<sg.bigo.ads.common.u.c.a> a(@NonNull sg.bigo.ads.common.u.b.c cVar) {
        b.a aVar = new b.a();
        f15987a.c(cVar, aVar);
        return new c<>(aVar.f15960b, aVar.f15961c);
    }

    public static void a(@NonNull sg.bigo.ads.common.u.b.a aVar, @Nullable b bVar) {
        if (bVar == null) {
            bVar = b.f15958d;
        }
        f15987a.b(aVar, bVar);
    }
}
