package v0;

import java.util.concurrent.Executor;
import p0.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5.a f17592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p5.a f17593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f17594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p5.a f17595d;

    public h(p5.a aVar, p5.a aVar2, w wVar, p5.a aVar3) {
        this.f17592a = aVar;
        this.f17593b = aVar2;
        this.f17594c = wVar;
        this.f17595d = aVar3;
    }

    @Override // p5.a
    public final Object get() {
        Executor executor = (Executor) this.f17592a.get();
        w0.d dVar = (w0.d) this.f17593b.get();
        e2.h hVar = (e2.h) this.f17594c.get();
        x0.c cVar = (x0.c) this.f17595d.get();
        j4.h hVar2 = new j4.h();
        hVar2.f12231a = executor;
        hVar2.f12232b = dVar;
        hVar2.f12233c = hVar;
        hVar2.f12234d = cVar;
        return hVar2;
    }
}
