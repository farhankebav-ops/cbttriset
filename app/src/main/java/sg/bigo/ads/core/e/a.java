package sg.bigo.ads.core.e;

import androidx.annotation.NonNull;
import sg.bigo.ads.common.k;
import sg.bigo.ads.common.u.b.d;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final k.b f16909a;

    public a(@NonNull k.b bVar) {
        super(bVar.b());
        this.f16909a = bVar;
    }

    @Override // sg.bigo.ads.common.u.b.d, sg.bigo.ads.common.u.a
    public final String a() {
        return this.f16909a.a();
    }

    @Override // sg.bigo.ads.common.u.b.d, sg.bigo.ads.common.u.a
    public final String d() {
        return this.f16909a.c();
    }

    @Override // sg.bigo.ads.common.u.b.d, sg.bigo.ads.common.u.a
    public final boolean e() {
        return this.f16909a.d();
    }
}
