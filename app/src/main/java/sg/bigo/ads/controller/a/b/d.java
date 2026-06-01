package sg.bigo.ads.controller.a.b;

import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.g;
import sg.bigo.ads.controller.a.j;
import sg.bigo.ads.controller.b.h;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sg.bigo.ads.controller.a.b f16354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f16355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private sg.bigo.ads.controller.b.d f16356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f16357d;
    private sg.bigo.ads.controller.e.e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f16358f;
    private c g;
    private c h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f16359a = new d();
    }

    public final void a(String str, j jVar, j jVar2) {
        c cVar;
        if (str == null || jVar == null || jVar2 == null || !i.f15457a.x() || i.f15457a.y() <= 0 || i.f15457a.z() <= 0 || i.f15457a.A() <= 0 || this.f16354a == null) {
            return;
        }
        if (str.equals("/Ad/GetSDKConfig")) {
            if (jVar.d() == 1) {
                return;
            }
            if (this.f16358f == null) {
                this.f16358f = new e(this.f16354a, this.f16355b, this.f16356c, this.f16357d);
            }
            cVar = this.f16358f;
        } else if (str.equals("/Ad/ReportUniBaina")) {
            if (jVar.d() == 1) {
                return;
            }
            if (this.g == null) {
                this.g = new b(this.f16354a, this.f16355b, this.f16356c, this.f16357d);
            }
            cVar = this.g;
        } else {
            if (jVar.d() == 1) {
                return;
            }
            if (this.h == null) {
                this.h = new sg.bigo.ads.controller.a.b.a(this.f16354a, this.f16355b, this.f16356c, this.f16357d);
            }
            cVar = this.h;
            ((sg.bigo.ads.controller.a.b.a) cVar).f16342a = this.e;
        }
        cVar.c();
    }

    public final void a(sg.bigo.ads.controller.a.b bVar, g gVar, sg.bigo.ads.controller.b.d dVar, h hVar, sg.bigo.ads.controller.e.e eVar) {
        this.f16354a = bVar;
        this.f16355b = gVar;
        this.f16356c = dVar;
        this.f16357d = hVar;
        this.e = eVar;
    }
}
