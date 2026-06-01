package x5;

import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h extends g implements kotlin.jvm.internal.h {
    private final int arity;

    public h(int i2, v5.c cVar) {
        super(cVar);
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    @Override // x5.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        b0.f12719a.getClass();
        String strA = c0.a(this);
        k.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
