package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class l implements h, Serializable {
    private final int arity;

    public l(int i2) {
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        b0.f12719a.getClass();
        String strA = c0.a(this);
        k.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
