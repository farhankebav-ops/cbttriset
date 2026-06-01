package sg.bigo.ads.controller.g;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.common.u.a;
import sg.bigo.ads.controller.g.a;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e<T extends sg.bigo.ads.common.u.a> extends a<T> {

    @NonNull
    private final sg.bigo.ads.controller.b j;

    @NonNull
    private final Map<String, Object> k;

    public e(@NonNull Map<String, Object> map, @NonNull sg.bigo.ads.common.g gVar, @Nullable sg.bigo.ads.controller.a.b bVar, @NonNull sg.bigo.ads.controller.b bVar2) {
        super(gVar, bVar);
        this.j = bVar2;
        this.k = map;
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(int i2, int i8, String str) {
        this.j.a(a(), i2, i8, str, null);
    }

    @Override // sg.bigo.ads.controller.g.a
    public final void a(@NonNull String str, @NonNull Map<String, Object> map) {
        this.j.a(a(), str);
    }

    @Override // sg.bigo.ads.controller.g.a
    @CallSuper
    public void a(@NonNull a.b bVar) {
        for (String str : this.k.keySet()) {
            bVar.a(str, this.k.get(str));
        }
    }
}
