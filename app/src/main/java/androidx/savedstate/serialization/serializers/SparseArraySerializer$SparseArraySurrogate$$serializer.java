package androidx.savedstate.serialization.serializers;

import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import b7.b;
import b7.c;
import b7.m;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import d7.g;
import e7.e;
import f7.d;
import f7.e0;
import f7.e1;
import java.util.List;
import kotlin.jvm.internal.k;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class SparseArraySerializer$SparseArraySurrogate$$serializer<T> implements e0 {
    private final g descriptor;
    private final /* synthetic */ c typeSerial0;

    private SparseArraySerializer$SparseArraySurrogate$$serializer() {
        e1 e1Var = new e1("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", this, 2);
        e1Var.j(UserMetadata.KEYDATA_FILENAME, false);
        e1Var.j("values", false);
        this.descriptor = e1Var;
    }

    private final /* synthetic */ c getTypeSerial0() {
        return this.typeSerial0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f7.e0
    public final c[] childSerializers() {
        return new c[]{SparseArraySerializer.SparseArraySurrogate.$childSerializers[0].getValue(), new d(this.typeSerial0, 0)};
    }

    @Override // b7.b
    public final SparseArraySerializer.SparseArraySurrogate<T> deserialize(e decoder) {
        List list;
        List list2;
        int i2;
        k.e(decoder, "decoder");
        g gVar = this.descriptor;
        e7.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = SparseArraySerializer.SparseArraySurrogate.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            list = (List) cVarBeginStructure.decodeSerializableElement(gVar, 0, (b) fVarArr[0].getValue(), null);
            list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 1, new d(this.typeSerial0, 0), null);
            i2 = 3;
        } else {
            boolean z2 = true;
            int i8 = 0;
            List list3 = null;
            List list4 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    list3 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 0, (b) fVarArr[0].getValue(), list3);
                    i8 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new m(iDecodeElementIndex);
                    }
                    list4 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 1, new d(this.typeSerial0, 0), list4);
                    i8 |= 2;
                }
            }
            list = list3;
            list2 = list4;
            i2 = i8;
        }
        cVarBeginStructure.endStructure(gVar);
        return new SparseArraySerializer.SparseArraySurrogate<>(i2, list, list2, null);
    }

    @Override // b7.j, b7.b
    public final g getDescriptor() {
        return this.descriptor;
    }

    @Override // b7.j
    public final void serialize(e7.f encoder, SparseArraySerializer.SparseArraySurrogate<T> value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g gVar = this.descriptor;
        e7.d dVarBeginStructure = encoder.beginStructure(gVar);
        SparseArraySerializer.SparseArraySurrogate.write$Self$savedstate_release(value, dVarBeginStructure, gVar, this.typeSerial0);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // f7.e0
    public final c[] typeParametersSerializers() {
        return new c[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparseArraySerializer$SparseArraySurrogate$$serializer(c typeSerial0) {
        this();
        k.e(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }
}
