package f7;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h1 extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f11464b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(b7.c primitiveSerializer) {
        super(primitiveSerializer);
        kotlin.jvm.internal.k.e(primitiveSerializer, "primitiveSerializer");
        this.f11464b = new g1(primitiveSerializer.getDescriptor());
    }

    @Override // f7.a
    public final Object a() {
        return (f1) i(l());
    }

    @Override // f7.a
    public final int b(Object obj) {
        f1 f1Var = (f1) obj;
        kotlin.jvm.internal.k.e(f1Var, "<this>");
        return f1Var.d();
    }

    @Override // f7.a
    public final void c(int i2, Object obj) {
        f1 f1Var = (f1) obj;
        kotlin.jvm.internal.k.e(f1Var, "<this>");
        f1Var.b(i2);
    }

    @Override // f7.a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // f7.a, b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return f(decoder);
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return this.f11464b;
    }

    @Override // f7.a
    public final Object j(Object obj) {
        f1 f1Var = (f1) obj;
        kotlin.jvm.internal.k.e(f1Var, "<this>");
        return f1Var.a();
    }

    @Override // f7.r
    public final void k(int i2, Object obj, Object obj2) {
        kotlin.jvm.internal.k.e((f1) obj, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Object l();

    public abstract void m(e7.d dVar, Object obj, int i2);

    @Override // f7.r, b7.j
    public final void serialize(e7.f fVar, Object obj) {
        int iE = e(obj);
        g1 g1Var = this.f11464b;
        e7.d dVarBeginCollection = fVar.beginCollection(g1Var, iE);
        m(dVarBeginCollection, obj, iE);
        dVarBeginCollection.endStructure(g1Var);
    }
}
