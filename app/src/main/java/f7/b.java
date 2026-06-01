package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements b7.c {
    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        Object objDecodeSerializableElement;
        kotlin.jvm.internal.k.e(decoder, "decoder");
        b7.f fVar = (b7.f) this;
        d7.g descriptor = fVar.getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor);
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(fVar.getDescriptor(), 1, n7.b.p(this, cVarBeginStructure, cVarBeginStructure.decodeStringElement(fVar.getDescriptor(), 0)), null);
        } else {
            Object objDecodeSerializableElement2 = null;
            String strDecodeStringElement = null;
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(fVar.getDescriptor());
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = cVarBeginStructure.decodeStringElement(fVar.getDescriptor(), iDecodeElementIndex);
                    } else {
                        if (iDecodeElementIndex != 1) {
                            StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                            if (strDecodeStringElement == null) {
                                strDecodeStringElement = "unknown class";
                            }
                            sb.append(strDecodeStringElement);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iDecodeElementIndex);
                            throw new b7.i(sb.toString());
                        }
                        if (strDecodeStringElement == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(fVar.getDescriptor(), iDecodeElementIndex, n7.b.p(this, cVarBeginStructure, strDecodeStringElement), null);
                    }
                } else {
                    if (objDecodeSerializableElement2 == null) {
                        throw new IllegalArgumentException(a1.a.l("Polymorphic value has not been read for class ", strDecodeStringElement).toString());
                    }
                    objDecodeSerializableElement = objDecodeSerializableElement2;
                }
            }
        }
        cVarBeginStructure.endStructure(descriptor);
        return objDecodeSerializableElement;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object value) {
        kotlin.jvm.internal.k.e(value, "value");
        b7.j jVarQ = n7.b.q(this, fVar, value);
        b7.f fVar2 = (b7.f) this;
        d7.g descriptor = fVar2.getDescriptor();
        e7.d dVarBeginStructure = fVar.beginStructure(descriptor);
        dVarBeginStructure.encodeStringElement(fVar2.getDescriptor(), 0, jVarQ.getDescriptor().h());
        dVarBeginStructure.encodeSerializableElement(fVar2.getDescriptor(), 1, jVarQ, value);
        dVarBeginStructure.endStructure(descriptor);
    }
}
