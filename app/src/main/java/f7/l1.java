package f7;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l1 implements d7.g, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d7.g f11480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f11482c;

    public l1(d7.g original) {
        kotlin.jvm.internal.k.e(original, "original");
        this.f11480a = original;
        this.f11481b = original.h() + '?';
        this.f11482c = c1.b(original);
    }

    @Override // f7.l
    public final Set a() {
        return this.f11482c;
    }

    @Override // d7.g
    public final boolean b() {
        return true;
    }

    @Override // d7.g
    public final int c(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        return this.f11480a.c(name);
    }

    @Override // d7.g
    public final int d() {
        return this.f11480a.d();
    }

    @Override // d7.g
    public final String e(int i2) {
        return this.f11480a.e(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l1) {
            return kotlin.jvm.internal.k.a(this.f11480a, ((l1) obj).f11480a);
        }
        return false;
    }

    @Override // d7.g
    public final List f(int i2) {
        return this.f11480a.f(i2);
    }

    @Override // d7.g
    public final d7.g g(int i2) {
        return this.f11480a.g(i2);
    }

    @Override // d7.g
    public final List getAnnotations() {
        return this.f11480a.getAnnotations();
    }

    @Override // d7.g
    public final a.a getKind() {
        return this.f11480a.getKind();
    }

    @Override // d7.g
    public final String h() {
        return this.f11481b;
    }

    public final int hashCode() {
        return this.f11480a.hashCode() * 31;
    }

    @Override // d7.g
    public final boolean i(int i2) {
        return this.f11480a.i(i2);
    }

    @Override // d7.g
    public final boolean isInline() {
        return this.f11480a.isInline();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11480a);
        sb.append('?');
        return sb.toString();
    }
}
