package sg.bigo.ads.controller.g;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sg.bigo.ads.controller.b.d f16667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final sg.bigo.ads.common.g f16668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final sg.bigo.ads.api.b f16669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final sg.bigo.ads.api.a.l f16670d;
    private final sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16671f;

    public c(sg.bigo.ads.controller.b.d dVar, sg.bigo.ads.common.g gVar, sg.bigo.ads.api.b bVar, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> eVar) {
        this.f16667a = dVar;
        this.f16668b = gVar;
        this.f16669c = bVar;
        this.f16670d = lVar;
        this.e = eVar;
        bVar.a(gVar.Q(), gVar.R(), gVar.S());
        this.f16671f = sg.bigo.ads.common.y.a.a();
    }

    @Override // sg.bigo.ads.controller.g.i
    public final int a() {
        return this.f16671f;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    @Override // sg.bigo.ads.controller.g.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.g.c.b():void");
    }

    @Override // sg.bigo.ads.controller.g.i
    public final sg.bigo.ads.api.b k() {
        return this.f16669c;
    }

    @Override // sg.bigo.ads.controller.g.i
    @NonNull
    public final sg.bigo.ads.api.a.l l() {
        return this.f16670d;
    }

    private void a(int i2, int i8, String str) {
        sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> eVar = this.e;
        if (eVar != null) {
            eVar.a(this.f16671f, i2, i8, str, this.f16670d);
        }
    }
}
