package f7;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class r extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.c f11503a;

    public r(b7.c cVar) {
        this.f11503a = cVar;
    }

    @Override // f7.a
    public final void g(e7.c cVar, Object obj, int i2, int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i9 = 0; i9 < i8; i9++) {
            h(cVar, i2 + i9, obj);
        }
    }

    @Override // f7.a
    public void h(e7.c cVar, int i2, Object obj) {
        k(i2, obj, cVar.decodeSerializableElement(getDescriptor(), i2, this.f11503a, null));
    }

    public abstract void k(int i2, Object obj, Object obj2);

    @Override // b7.j
    public void serialize(e7.f fVar, Object obj) {
        int iE = e(obj);
        d7.g descriptor = getDescriptor();
        e7.d dVarBeginCollection = fVar.beginCollection(descriptor, iE);
        Iterator itD = d(obj);
        for (int i2 = 0; i2 < iE; i2++) {
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i2, this.f11503a, itD.next());
        }
        dVarBeginCollection.endStructure(descriptor);
    }
}
