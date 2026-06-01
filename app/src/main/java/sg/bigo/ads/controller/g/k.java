package sg.bigo.ads.controller.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.G5;
import java.util.Map;
import sg.bigo.ads.controller.g.a;

/* JADX INFO: loaded from: classes6.dex */
public final class k extends sg.bigo.ads.controller.g.a<sg.bigo.ads.controller.a.f> {
    private a j;

    public interface a {
        void a(String str, int i2, int i8, int i9, @NonNull String str2, @Nullable Map<String, Object> map);

        void a(String str, int i2, String str2, @Nullable Map<String, Object> map);
    }

    public k(@NonNull sg.bigo.ads.common.g gVar, @NonNull sg.bigo.ads.controller.a.b bVar, a aVar) {
        super(gVar, bVar);
        this.j = aVar;
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(int i2, int i8, String str) {
    }

    @Override // sg.bigo.ads.controller.g.a
    @Nullable
    public final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.b();
    }

    @Override // sg.bigo.ads.controller.g.a
    public final sg.bigo.ads.common.u.f d() {
        return sg.bigo.ads.common.u.f.a(G5.L);
    }

    @Override // sg.bigo.ads.controller.g.a
    public final long e() {
        sg.bigo.ads.controller.a.b bVar = this.f16653c;
        return bVar != null ? bVar.f16310a.l.f16306a : super.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    @NonNull
    public final /* synthetic */ sg.bigo.ads.common.u.a f() {
        String str = this.f16656i;
        return str != null ? this.f16653c.b("/Ad/GetSDKConfig", str) : this.f16653c.b("/Ad/GetSDKConfig", null);
    }

    @Override // sg.bigo.ads.controller.g.a
    public final boolean h() {
        return false;
    }

    @Override // sg.bigo.ads.controller.g.a
    public final boolean j() {
        return false;
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(String str, int i2, int i8, String str2, @Nullable Map<String, Object> map) {
        super.a(str, i2, i8, str2, map);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(str, a(), i2, i8, str2, map);
        }
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        super.a(str, str2, map);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(str, a(), str2, map);
        }
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(@NonNull String str, @NonNull Map<String, Object> map) {
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(@NonNull a.b bVar) {
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void i() {
    }
}
