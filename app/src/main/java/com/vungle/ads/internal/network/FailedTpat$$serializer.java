package com.vungle.ads.internal.network;

import b7.c;
import b7.m;
import com.ironsource.C2300e4;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.g0;
import f7.l0;
import f7.m1;
import f7.q1;
import java.util.Map;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FailedTpat$$serializer implements e0 {
    public static final FailedTpat$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        FailedTpat$$serializer failedTpat$$serializer = new FailedTpat$$serializer();
        INSTANCE = failedTpat$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.network.FailedTpat", failedTpat$$serializer, 6);
        e1Var.j("method", true);
        e1Var.j("headers", true);
        e1Var.j(C2300e4.h.E0, true);
        e1Var.j("retryAttempt", true);
        e1Var.j("retryCount", false);
        e1Var.j("tpatKey", true);
        descriptor = e1Var;
    }

    private FailedTpat$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        c cVarY = q.Y(new g0(q1Var, q1Var, 1));
        c cVarY2 = q.Y(q1Var);
        c cVarY3 = q.Y(q1Var);
        l0 l0Var = l0.f11478a;
        return new c[]{HttpMethod$$serializer.INSTANCE, cVarY, cVarY2, l0Var, l0Var, cVarY3};
    }

    @Override // b7.b
    public FailedTpat deserialize(e decoder) {
        int i2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        int i8;
        int i9;
        Object objDecodeSerializableElement;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i10 = 5;
        int i11 = 3;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(descriptor2, 0, HttpMethod$$serializer.INSTANCE, null);
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, new g0(q1Var, q1Var, 1), null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1Var, null);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(descriptor2, 3);
            int iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(descriptor2, 4);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, q1Var, null);
            i9 = iDecodeIntElement;
            i8 = iDecodeIntElement2;
            i2 = 63;
        } else {
            boolean z2 = true;
            int iDecodeIntElement3 = 0;
            int i12 = 0;
            Object objDecodeSerializableElement2 = null;
            Object objDecodeNullableSerializableElement4 = null;
            Object objDecodeNullableSerializableElement5 = null;
            Object objDecodeNullableSerializableElement6 = null;
            int iDecodeIntElement4 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i11 = 3;
                        break;
                    case 0:
                        objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(descriptor2, 0, HttpMethod$$serializer.INSTANCE, objDecodeSerializableElement2);
                        i12 |= 1;
                        i10 = 5;
                        i11 = 3;
                        break;
                    case 1:
                        q1 q1Var2 = q1.f11501a;
                        objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, new g0(q1Var2, q1Var2, 1), objDecodeNullableSerializableElement4);
                        i12 |= 2;
                        i10 = 5;
                        i11 = 3;
                        break;
                    case 2:
                        objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1.f11501a, objDecodeNullableSerializableElement5);
                        i12 |= 4;
                        break;
                    case 3:
                        iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(descriptor2, i11);
                        i12 |= 8;
                        break;
                    case 4:
                        iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(descriptor2, 4);
                        i12 |= 16;
                        break;
                    case 5:
                        objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i10, q1.f11501a, objDecodeNullableSerializableElement6);
                        i12 |= 32;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            i2 = i12;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement4;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement5;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement6;
            i8 = iDecodeIntElement4;
            i9 = iDecodeIntElement3;
            objDecodeSerializableElement = objDecodeSerializableElement2;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new FailedTpat(i2, (HttpMethod) objDecodeSerializableElement, (Map) objDecodeNullableSerializableElement, (String) objDecodeNullableSerializableElement2, i9, i8, (String) objDecodeNullableSerializableElement3, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, FailedTpat value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        FailedTpat.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
