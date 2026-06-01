package d7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f11178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l6.c f11179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11180c;

    public b(h hVar, l6.c kClass) {
        kotlin.jvm.internal.k.e(kClass, "kClass");
        this.f11178a = hVar;
        this.f11179b = kClass;
        this.f11180c = hVar.f11188a + '<' + ((kotlin.jvm.internal.e) kClass).f() + '>';
    }

    @Override // d7.g
    public final boolean b() {
        return false;
    }

    @Override // d7.g
    public final int c(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        return this.f11178a.c(name);
    }

    @Override // d7.g
    public final int d() {
        return this.f11178a.f11190c;
    }

    @Override // d7.g
    public final String e(int i2) {
        return this.f11178a.f11192f[i2];
    }

    public final boolean equals(Object obj) {
        b bVar = obj instanceof b ? (b) obj : null;
        return bVar != null && this.f11178a.equals(bVar.f11178a) && kotlin.jvm.internal.k.a(bVar.f11179b, this.f11179b);
    }

    @Override // d7.g
    public final List f(int i2) {
        return this.f11178a.h[i2];
    }

    @Override // d7.g
    public final g g(int i2) {
        return this.f11178a.g[i2];
    }

    @Override // d7.g
    public final List getAnnotations() {
        return this.f11178a.f11191d;
    }

    @Override // d7.g
    public final a.a getKind() {
        return this.f11178a.f11189b;
    }

    @Override // d7.g
    public final String h() {
        return this.f11180c;
    }

    public final int hashCode() {
        return this.f11180c.hashCode() + (((kotlin.jvm.internal.e) this.f11179b).hashCode() * 31);
    }

    @Override // d7.g
    public final boolean i(int i2) {
        return this.f11178a.f11193i[i2];
    }

    @Override // d7.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.f11179b + ", original: " + this.f11178a + ')';
    }
}
