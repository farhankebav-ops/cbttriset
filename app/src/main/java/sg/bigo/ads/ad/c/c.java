package sg.bigo.ads.ad.c;

import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f14080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f14081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f14082c;

    public c(g gVar) {
        this.f14080a = 2;
        this.f14081b = 0;
        this.f14082c = 1;
        if (gVar == null) {
            return;
        }
        this.f14080a = gVar.f15496a.ao();
        this.f14081b = gVar.f15496a.ap();
        this.f14082c = gVar.f15496a.aq();
    }
}
