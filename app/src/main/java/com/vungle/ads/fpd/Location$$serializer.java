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
import f7.l0;
import f7.q1;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Location$$serializer implements e0 {
    public static final Location$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        Location$$serializer location$$serializer = new Location$$serializer();
        INSTANCE = location$$serializer;
        e1 e1Var = new e1("com.vungle.ads.fpd.Location", location$$serializer, 3);
        e1Var.j("country", true);
        e1Var.j("region_state", true);
        e1Var.j("dma", true);
        descriptor = e1Var;
    }

    private Location$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new c[]{q.Y(q1Var), q.Y(q1Var), q.Y(l0.f11478a)};
    }

    @Override // b7.b
    public Location deserialize(e decoder) {
        int i2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        Object objDecodeNullableSerializableElement3 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            q1 q1Var = q1.f11501a;
            Object objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, q1Var, null);
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1Var, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, null);
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement4;
            i2 = 7;
        } else {
            boolean z2 = true;
            int i8 = 0;
            Object objDecodeNullableSerializableElement5 = null;
            Object objDecodeNullableSerializableElement6 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, q1.f11501a, objDecodeNullableSerializableElement3);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1.f11501a, objDecodeNullableSerializableElement5);
                    i8 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, objDecodeNullableSerializableElement6);
                    i8 |= 4;
                }
            }
            i2 = i8;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement5;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement6;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new Location(i2, (String) objDecodeNullableSerializableElement3, (String) objDecodeNullableSerializableElement, (Integer) objDecodeNullableSerializableElement2, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, Location value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        Location.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
