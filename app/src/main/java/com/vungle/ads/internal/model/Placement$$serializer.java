package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.m1;
import f7.q1;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Placement$$serializer implements e0 {
    public static final Placement$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        Placement$$serializer placement$$serializer = new Placement$$serializer();
        INSTANCE = placement$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.Placement", placement$$serializer, 3);
        e1Var.j("placement_ref_id", false);
        e1Var.j("is_hb", true);
        e1Var.j("type", true);
        descriptor = e1Var;
    }

    private Placement$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new c[]{q1Var, f7.g.f11455a, q.Y(q1Var)};
    }

    @Override // b7.b
    public Placement deserialize(e decoder) {
        boolean z2;
        int i2;
        String str;
        Object objDecodeNullableSerializableElement;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(descriptor2, 1);
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1.f11501a, null);
            str = strDecodeStringElement;
            z2 = zDecodeBooleanElement;
            i2 = 7;
        } else {
            boolean z7 = true;
            boolean zDecodeBooleanElement2 = false;
            String strDecodeStringElement2 = null;
            Object objDecodeNullableSerializableElement2 = null;
            int i8 = 0;
            while (z7) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z7 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(descriptor2, 1);
                    i8 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1.f11501a, objDecodeNullableSerializableElement2);
                    i8 |= 4;
                }
            }
            z2 = zDecodeBooleanElement2;
            i2 = i8;
            str = strDecodeStringElement2;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new Placement(i2, str, z2, (String) objDecodeNullableSerializableElement, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, Placement value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        Placement.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
