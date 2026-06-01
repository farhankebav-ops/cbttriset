package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r1 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.c f11507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b7.c f11508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.c f11509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d7.h f11510d = r2.q.p("kotlin.Triple", new d7.g[0], new androidx.camera.core.impl.utils.a(this, 9));

    public r1(b7.c cVar, b7.c cVar2, b7.c cVar3) {
        this.f11507a = cVar;
        this.f11508b = cVar2;
        this.f11509c = cVar3;
    }

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        d7.h hVar = this.f11510d;
        e7.c cVarBeginStructure = decoder.beginStructure(hVar);
        boolean zDecodeSequentially = cVarBeginStructure.decodeSequentially();
        b7.c cVar = this.f11509c;
        b7.c cVar2 = this.f11508b;
        b7.c cVar3 = this.f11507a;
        if (zDecodeSequentially) {
            Object objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(hVar, 0, cVar3, null);
            Object objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(hVar, 1, cVar2, null);
            Object objDecodeSerializableElement3 = cVarBeginStructure.decodeSerializableElement(hVar, 2, cVar, null);
            cVarBeginStructure.endStructure(hVar);
            return new q5.n(objDecodeSerializableElement, objDecodeSerializableElement2, objDecodeSerializableElement3);
        }
        Object obj = c1.f11429c;
        Object objDecodeSerializableElement4 = obj;
        Object objDecodeSerializableElement5 = objDecodeSerializableElement4;
        Object objDecodeSerializableElement6 = objDecodeSerializableElement5;
        while (true) {
            int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(hVar);
            if (iDecodeElementIndex == -1) {
                cVarBeginStructure.endStructure(hVar);
                if (objDecodeSerializableElement4 == obj) {
                    throw new b7.i("Element 'first' is missing");
                }
                if (objDecodeSerializableElement5 == obj) {
                    throw new b7.i("Element 'second' is missing");
                }
                if (objDecodeSerializableElement6 != obj) {
                    return new q5.n(objDecodeSerializableElement4, objDecodeSerializableElement5, objDecodeSerializableElement6);
                }
                throw new b7.i("Element 'third' is missing");
            }
            if (iDecodeElementIndex == 0) {
                objDecodeSerializableElement4 = cVarBeginStructure.decodeSerializableElement(hVar, 0, cVar3, null);
            } else if (iDecodeElementIndex == 1) {
                objDecodeSerializableElement5 = cVarBeginStructure.decodeSerializableElement(hVar, 1, cVar2, null);
            } else {
                if (iDecodeElementIndex != 2) {
                    throw new b7.i(a1.a.g(iDecodeElementIndex, "Unexpected index "));
                }
                objDecodeSerializableElement6 = cVarBeginStructure.decodeSerializableElement(hVar, 2, cVar, null);
            }
        }
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return this.f11510d;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        q5.n value = (q5.n) obj;
        kotlin.jvm.internal.k.e(value, "value");
        d7.h hVar = this.f11510d;
        e7.d dVarBeginStructure = fVar.beginStructure(hVar);
        dVarBeginStructure.encodeSerializableElement(hVar, 0, this.f11507a, value.f13508a);
        dVarBeginStructure.encodeSerializableElement(hVar, 1, this.f11508b, value.f13509b);
        dVarBeginStructure.encodeSerializableElement(hVar, 2, this.f11509c, value.f13510c);
        dVarBeginStructure.endStructure(hVar);
    }
}
