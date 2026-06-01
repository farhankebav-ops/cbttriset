package u0;

import e2.h;
import java.util.concurrent.Executor;
import p0.w;
import q0.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5.a f17521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p5.a f17522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f17523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p5.a f17524d;
    public final p5.a e;

    public b(p5.a aVar, p5.a aVar2, w wVar, p5.a aVar3, p5.a aVar4) {
        this.f17521a = aVar;
        this.f17522b = aVar2;
        this.f17523c = wVar;
        this.f17524d = aVar3;
        this.e = aVar4;
    }

    @Override // p5.a
    public final Object get() {
        return new a((Executor) this.f17521a.get(), (f) this.f17522b.get(), (h) this.f17523c.get(), (w0.d) this.f17524d.get(), (x0.c) this.e.get());
    }
}
