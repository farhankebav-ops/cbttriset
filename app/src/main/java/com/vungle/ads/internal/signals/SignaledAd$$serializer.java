package com.vungle.ads.internal.signals;

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
import f7.q0;
import f7.q1;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SignaledAd$$serializer implements e0 {
    public static final SignaledAd$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        SignaledAd$$serializer signaledAd$$serializer = new SignaledAd$$serializer();
        INSTANCE = signaledAd$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.signals.SignaledAd", signaledAd$$serializer, 5);
        e1Var.j("500", true);
        e1Var.j("109", false);
        e1Var.j("107", true);
        e1Var.j("110", true);
        e1Var.j("108", true);
        descriptor = e1Var;
    }

    private SignaledAd$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        c cVarY = q.Y(q1Var);
        c cVarY2 = q.Y(q1Var);
        q0 q0Var = q0.f11499a;
        return new c[]{cVarY, q0Var, cVarY2, q0Var, l0.f11478a};
    }

    @Override // b7.b
    public SignaledAd deserialize(e decoder) {
        long jDecodeLongElement;
        long jDecodeLongElement2;
        int i2;
        Object objDecodeNullableSerializableElement;
        int iDecodeIntElement;
        Object objDecodeNullableSerializableElement2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i8 = 3;
        if (cVarBeginStructure.decodeSequentially()) {
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, q1Var, null);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(descriptor2, 1);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1Var, null);
            long jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(descriptor2, 3);
            i2 = 31;
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(descriptor2, 4);
            jDecodeLongElement2 = jDecodeLongElement3;
            jDecodeLongElement = jDecodeLongElement4;
        } else {
            jDecodeLongElement = 0;
            boolean z2 = true;
            int iDecodeIntElement2 = 0;
            Object objDecodeNullableSerializableElement3 = null;
            Object objDecodeNullableSerializableElement4 = null;
            jDecodeLongElement2 = 0;
            int i9 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, q1.f11501a, objDecodeNullableSerializableElement3);
                    i9 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(descriptor2, 1);
                    i9 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1.f11501a, objDecodeNullableSerializableElement4);
                    i9 |= 4;
                } else if (iDecodeElementIndex == i8) {
                    jDecodeLongElement = cVarBeginStructure.decodeLongElement(descriptor2, i8);
                    i9 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new m(iDecodeElementIndex);
                    }
                    iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(descriptor2, 4);
                    i9 |= 16;
                }
                i8 = 3;
            }
            i2 = i9;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement3;
            iDecodeIntElement = iDecodeIntElement2;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement4;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new SignaledAd(i2, (String) objDecodeNullableSerializableElement, jDecodeLongElement2, (String) objDecodeNullableSerializableElement2, jDecodeLongElement, iDecodeIntElement, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, SignaledAd value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        SignaledAd.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
