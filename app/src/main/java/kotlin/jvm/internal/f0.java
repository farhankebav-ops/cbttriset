package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f0 implements l6.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l6.c f12723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12725c;

    public f0(l6.c classifier, List arguments, int i2) {
        k.e(classifier, "classifier");
        k.e(arguments, "arguments");
        this.f12723a = classifier;
        this.f12724b = arguments;
        this.f12725c = i2;
    }

    public final String a(boolean z2) {
        String name;
        l6.c cVar = this.f12723a;
        l6.c cVar2 = cVar instanceof l6.c ? cVar : null;
        Class clsB = cVar2 != null ? a.a.B(cVar2) : null;
        if (clsB == null) {
            name = cVar.toString();
        } else if ((this.f12725c & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsB.isArray()) {
            name = clsB.equals(boolean[].class) ? "kotlin.BooleanArray" : clsB.equals(char[].class) ? "kotlin.CharArray" : clsB.equals(byte[].class) ? "kotlin.ByteArray" : clsB.equals(short[].class) ? "kotlin.ShortArray" : clsB.equals(int[].class) ? "kotlin.IntArray" : clsB.equals(float[].class) ? "kotlin.FloatArray" : clsB.equals(long[].class) ? "kotlin.LongArray" : clsB.equals(double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
        } else if (z2 && clsB.isPrimitive()) {
            k.c(cVar, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = a.a.C(cVar).getName();
        } else {
            name = clsB.getName();
        }
        return a1.a.D(name, this.f12724b.isEmpty() ? "" : r5.l.c1(this.f12724b, ", ", "<", ">", new androidx.camera.core.impl.utils.a(this, 12), 24), b() ? "?" : "");
    }

    @Override // l6.r
    public final boolean b() {
        return (this.f12725c & 1) != 0;
    }

    @Override // l6.r
    public final l6.c c() {
        return this.f12723a;
    }

    @Override // l6.r
    public final List d() {
        return this.f12724b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return k.a(this.f12723a, f0Var.f12723a) && k.a(this.f12724b, f0Var.f12724b) && this.f12725c == f0Var.f12725c;
    }

    public final int hashCode() {
        return ((this.f12724b.hashCode() + (this.f12723a.hashCode() * 31)) * 31) + this.f12725c;
    }

    public final String toString() {
        return a(false) + " (Kotlin reflection is not available)";
    }
}
