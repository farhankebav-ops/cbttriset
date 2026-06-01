package f7;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements b7.c {
    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(int i2, Object obj);

    public abstract Iterator d(Object obj);

    @Override // b7.b
    public Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return f(decoder);
    }

    public abstract int e(Object obj);

    public final Object f(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        Object objA = a();
        int iB = b(objA);
        e7.c cVarBeginStructure = decoder.beginStructure(getDescriptor());
        if (!cVarBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                h(cVarBeginStructure, iDecodeElementIndex + iB, objA);
            }
        } else {
            int iDecodeCollectionSize = cVarBeginStructure.decodeCollectionSize(getDescriptor());
            c(iDecodeCollectionSize, objA);
            g(cVarBeginStructure, objA, iB, iDecodeCollectionSize);
        }
        cVarBeginStructure.endStructure(getDescriptor());
        return j(objA);
    }

    public abstract void g(e7.c cVar, Object obj, int i2, int i8);

    public abstract void h(e7.c cVar, int i2, Object obj);

    public abstract Object i(Object obj);

    public abstract Object j(Object obj);
}
