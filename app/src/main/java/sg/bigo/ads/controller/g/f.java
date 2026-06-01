package sg.bigo.ads.controller.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.controller.g.a;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends e<sg.bigo.ads.controller.a.f> {
    public f(@NonNull Map<String, Object> map, @NonNull sg.bigo.ads.common.g gVar, @NonNull sg.bigo.ads.controller.a.b bVar, @NonNull sg.bigo.ads.controller.b bVar2) {
        super(map, gVar, bVar, bVar2);
    }

    @Override // sg.bigo.ads.controller.g.e, sg.bigo.ads.controller.g.a
    public final void a(@NonNull a.b bVar) {
        super.a(bVar);
        bVar.a("token", this.f16652b.P());
        bVar.a("req_status", Integer.valueOf(sg.bigo.ads.common.f.b.c()));
        bVar.a("uuid", this.f16652b.X());
    }

    @Override // sg.bigo.ads.controller.g.a
    @Nullable
    public final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    public final long e() {
        sg.bigo.ads.controller.a.b bVar = this.f16653c;
        return bVar != null ? bVar.f16310a.l.f16308c : super.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    @NonNull
    public final /* synthetic */ sg.bigo.ads.common.u.a f() {
        return this.f16653c.b("/Ad/UniCallback", null);
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void i() {
        sg.bigo.ads.common.x.a.E();
    }

    @Override // sg.bigo.ads.controller.g.a
    public final boolean j() {
        return sg.bigo.ads.api.a.i.f15457a.g() && sg.bigo.ads.common.x.a.D();
    }
}
