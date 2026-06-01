package v0;

import android.content.Context;
import java.util.concurrent.Executor;
import p0.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5.a f17587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p5.a f17588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p5.a f17589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f17590d;
    public final p5.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p5.a f17591f;
    public final p5.a g;

    public g(p5.a aVar, p5.a aVar2, p5.a aVar3, w wVar, p5.a aVar4, p5.a aVar5, p5.a aVar6) {
        this.f17587a = aVar;
        this.f17588b = aVar2;
        this.f17589c = aVar3;
        this.f17590d = wVar;
        this.e = aVar4;
        this.f17591f = aVar5;
        this.g = aVar6;
    }

    @Override // p5.a
    public final Object get() {
        return new f((Context) this.f17587a.get(), (q0.f) this.f17588b.get(), (w0.d) this.f17589c.get(), (e2.h) this.f17590d.get(), (Executor) this.e.get(), (x0.c) this.f17591f.get(), new r4.c(6), new w1.f(5), (w0.c) this.g.get());
    }
}
