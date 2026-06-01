package sg.bigo.ads.controller.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.controller.g.a;

/* JADX INFO: loaded from: classes6.dex */
public final class h extends a<sg.bigo.ads.controller.a.f> {

    @NonNull
    private final sg.bigo.ads.controller.b j;

    public h(@NonNull sg.bigo.ads.common.g gVar, @NonNull sg.bigo.ads.controller.a.b bVar, long j, @NonNull sg.bigo.ads.controller.b bVar2) {
        super(gVar, bVar, j);
        this.j = bVar2;
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(int i2, int i8, String str) {
        this.j.a(a(), i2, i8, str, null);
    }

    @Override // sg.bigo.ads.controller.g.a
    @Nullable
    public final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.d();
    }

    @Override // sg.bigo.ads.controller.g.a
    public final long e() {
        sg.bigo.ads.controller.a.b bVar = this.f16653c;
        return bVar != null ? bVar.f16310a.l.f16309d : super.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    @NonNull
    public final /* synthetic */ sg.bigo.ads.common.u.a f() {
        String str = this.f16656i;
        return str != null ? this.f16653c.b("/Ad/GetUniConfig", str) : this.f16653c.b("/Ad/GetUniConfig", null);
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void i() {
        sg.bigo.ads.common.x.a.w();
    }

    @Override // sg.bigo.ads.controller.g.a
    public final boolean j() {
        return sg.bigo.ads.api.a.i.f15457a.c() && sg.bigo.ads.common.x.a.v();
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(@NonNull String str, @NonNull Map<String, Object> map) {
        this.j.a(a(), str);
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(@NonNull a.b bVar) {
        bVar.a("req_status", Integer.valueOf(sg.bigo.ads.common.f.b.c()));
        sg.bigo.ads.common.b bVarAc = this.f16652b.ac();
        bVar.a("bat_stat", bVarAc != null ? String.valueOf(bVarAc.f15584c) : "");
        bVar.a("bat_num", bVarAc != null ? String.valueOf(bVarAc.f15582a) : "");
        bVar.a("bat_scale", bVarAc != null ? String.valueOf(bVarAc.f15583b) : "");
        bVar.a("coppa", Integer.valueOf(sg.bigo.ads.common.x.a.p()));
    }
}
