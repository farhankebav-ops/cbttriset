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
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Demographic$$serializer implements e0 {
    public static final Demographic$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        Demographic$$serializer demographic$$serializer = new Demographic$$serializer();
        INSTANCE = demographic$$serializer;
        e1 e1Var = new e1("com.vungle.ads.fpd.Demographic", demographic$$serializer, 4);
        e1Var.j("age_range", true);
        e1Var.j("length_of_residence", true);
        e1Var.j("median_home_value_usd", true);
        e1Var.j("monthly_housing_payment_usd", true);
        descriptor = e1Var;
    }

    private Demographic$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        l0 l0Var = l0.f11478a;
        return new c[]{q.Y(l0Var), q.Y(l0Var), q.Y(l0Var), q.Y(l0Var)};
    }

    @Override // b7.b
    public Demographic deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        int i2;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        Object objDecodeNullableSerializableElement5 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            l0 l0Var = l0.f11478a;
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, l0Var, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, l0Var, null);
            Object objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0Var, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, l0Var, null);
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement6;
            i2 = 15;
        } else {
            boolean z2 = true;
            int i8 = 0;
            Object objDecodeNullableSerializableElement7 = null;
            objDecodeNullableSerializableElement = null;
            Object objDecodeNullableSerializableElement8 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, l0.f11478a, objDecodeNullableSerializableElement5);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, l0.f11478a, objDecodeNullableSerializableElement7);
                    i8 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, objDecodeNullableSerializableElement);
                    i8 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, l0.f11478a, objDecodeNullableSerializableElement8);
                    i8 |= 8;
                }
            }
            i2 = i8;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement5;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement7;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new Demographic(i2, (Integer) objDecodeNullableSerializableElement2, (Integer) objDecodeNullableSerializableElement3, (Integer) objDecodeNullableSerializableElement, (Integer) objDecodeNullableSerializableElement4, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, Demographic value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        Demographic.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
