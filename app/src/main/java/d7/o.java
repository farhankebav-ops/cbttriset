package d7;

import java.util.List;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11204a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11205b;

    public o(g gVar) {
        this.f11205b = gVar;
    }

    public g a() {
        return (g) ((q5.m) this.f11205b).getValue();
    }

    @Override // d7.g
    public final boolean b() {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).b();
            default:
                return false;
        }
    }

    @Override // d7.g
    public final int c(String name) {
        switch (this.f11204a) {
            case 0:
                kotlin.jvm.internal.k.e(name, "name");
                return ((g) this.f11205b).c(name);
            default:
                kotlin.jvm.internal.k.e(name, "name");
                return a().c(name);
        }
    }

    @Override // d7.g
    public final int d() {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).d();
            default:
                return a().d();
        }
    }

    @Override // d7.g
    public final String e(int i2) {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).e(i2);
            default:
                return a().e(i2);
        }
    }

    @Override // d7.g
    public final List f(int i2) {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).f(i2);
            default:
                return a().f(i2);
        }
    }

    @Override // d7.g
    public final g g(int i2) {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).g(i2);
            default:
                return a().g(i2);
        }
    }

    @Override // d7.g
    public final List getAnnotations() {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).getAnnotations();
            default:
                return r.f13638a;
        }
    }

    @Override // d7.g
    public final a.a getKind() {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).getKind();
            default:
                return a().getKind();
        }
    }

    @Override // d7.g
    public final String h() {
        switch (this.f11204a) {
            case 0:
                return "kotlinx.coroutines.flow.MutableStateFlow";
            default:
                return a().h();
        }
    }

    @Override // d7.g
    public final boolean i(int i2) {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).i(i2);
            default:
                return a().i(i2);
        }
    }

    @Override // d7.g
    public final boolean isInline() {
        switch (this.f11204a) {
            case 0:
                return ((g) this.f11205b).isInline();
            default:
                return false;
        }
    }

    public o(e6.a aVar) {
        this.f11205b = n7.b.C(aVar);
    }
}
