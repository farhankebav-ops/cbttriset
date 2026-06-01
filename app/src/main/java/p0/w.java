package p0;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p5.a f13317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p5.a f13318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0.b f13319d;

    public /* synthetic */ w(p5.a aVar, p5.a aVar2, r0.b bVar, int i2) {
        this.f13316a = i2;
        this.f13317b = aVar;
        this.f13318c = aVar2;
        this.f13319d = bVar;
    }

    @Override // p5.a
    public final Object get() {
        switch (this.f13316a) {
            case 0:
                return new v(new r4.c(6), new w1.f(5), (u0.c) ((u0.b) this.f13317b).get(), (v0.f) ((v0.g) this.f13318c).get(), (j4.h) ((v0.h) this.f13319d).get());
            default:
                return new e2.h((Context) this.f13317b.get(), (w0.d) this.f13318c.get(), (v0.a) ((u0.d) this.f13319d).get());
        }
    }
}
