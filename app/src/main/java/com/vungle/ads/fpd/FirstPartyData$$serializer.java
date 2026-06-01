package com.vungle.ads.fpd;

import b7.c;
import b7.m;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.g0;
import f7.q1;
import java.util.Map;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FirstPartyData$$serializer implements e0 {
    public static final FirstPartyData$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        FirstPartyData$$serializer firstPartyData$$serializer = new FirstPartyData$$serializer();
        INSTANCE = firstPartyData$$serializer;
        e1 e1Var = new e1("com.vungle.ads.fpd.FirstPartyData", firstPartyData$$serializer, 5);
        e1Var.j("session_context", true);
        e1Var.j("demographic", true);
        e1Var.j("location", true);
        e1Var.j("revenue", true);
        e1Var.j("custom_data", true);
        descriptor = e1Var;
    }

    private FirstPartyData$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        c cVarY = q.Y(SessionContext$$serializer.INSTANCE);
        c cVarY2 = q.Y(Demographic$$serializer.INSTANCE);
        c cVarY3 = q.Y(Location$$serializer.INSTANCE);
        c cVarY4 = q.Y(Revenue$$serializer.INSTANCE);
        q1 q1Var = q1.f11501a;
        return new c[]{cVarY, cVarY2, cVarY3, cVarY4, q.Y(new g0(q1Var, q1Var, 1))};
    }

    @Override // b7.b
    public FirstPartyData deserialize(e decoder) {
        int i2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        boolean z2 = false;
        Object objDecodeNullableSerializableElement6 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, SessionContext$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, Demographic$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Location$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Revenue$$serializer.INSTANCE, null);
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, new g0(q1Var, q1Var, 1), null);
            i2 = 31;
        } else {
            boolean z7 = true;
            int i8 = 0;
            Object objDecodeNullableSerializableElement7 = null;
            Object objDecodeNullableSerializableElement8 = null;
            Object objDecodeNullableSerializableElement9 = null;
            Object objDecodeNullableSerializableElement10 = null;
            while (z7) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z7 = z2;
                } else if (iDecodeElementIndex != 0) {
                    if (iDecodeElementIndex == 1) {
                        objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, Demographic$$serializer.INSTANCE, objDecodeNullableSerializableElement7);
                        i8 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Location$$serializer.INSTANCE, objDecodeNullableSerializableElement8);
                        i8 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Revenue$$serializer.INSTANCE, objDecodeNullableSerializableElement9);
                        i8 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new m(iDecodeElementIndex);
                        }
                        q1 q1Var2 = q1.f11501a;
                        objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, new g0(q1Var2, q1Var2, 1), objDecodeNullableSerializableElement10);
                        i8 |= 16;
                    }
                    z2 = false;
                } else {
                    objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, SessionContext$$serializer.INSTANCE, objDecodeNullableSerializableElement6);
                    i8 |= 1;
                    z2 = false;
                }
            }
            Object obj = objDecodeNullableSerializableElement6;
            i2 = i8;
            objDecodeNullableSerializableElement = obj;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement7;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement8;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement9;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement10;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new FirstPartyData(i2, (SessionContext) objDecodeNullableSerializableElement, (Demographic) objDecodeNullableSerializableElement2, (Location) objDecodeNullableSerializableElement3, (Revenue) objDecodeNullableSerializableElement4, (Map) objDecodeNullableSerializableElement5, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, FirstPartyData value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        FirstPartyData.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
