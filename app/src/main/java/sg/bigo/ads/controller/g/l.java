package sg.bigo.ads.controller.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.controller.g.a;

/* JADX INFO: loaded from: classes6.dex */
public final class l extends e<sg.bigo.ads.common.u.b.d> {
    public l(@NonNull Map<String, Object> map, @NonNull sg.bigo.ads.common.g gVar, @Nullable sg.bigo.ads.controller.a.b bVar, @NonNull sg.bigo.ads.controller.b bVar2) {
        super(map, gVar, bVar, bVar2);
    }

    @Override // sg.bigo.ads.controller.g.e, sg.bigo.ads.controller.g.a
    public final void a(@NonNull a.b bVar) {
        super.a(bVar);
        bVar.a("token", this.f16652b.P());
    }

    @Override // sg.bigo.ads.controller.g.a
    @Nullable
    public final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.c();
    }

    @Override // sg.bigo.ads.controller.g.a
    @NonNull
    public final /* synthetic */ sg.bigo.ads.common.u.a f() {
        String str = this.f16656i;
        return str != null ? new sg.bigo.ads.common.u.b.d(sg.bigo.ads.b.a(str, "/Ad/ReportUniBaina")) : new sg.bigo.ads.common.u.b.d(sg.bigo.ads.b.a(sg.bigo.ads.b.b(), "/Ad/ReportUniBaina"));
    }

    @Override // sg.bigo.ads.controller.g.a
    public final boolean g() {
        return false;
    }

    @Override // sg.bigo.ads.controller.g.a
    public final boolean j() {
        return false;
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void i() {
    }
}
