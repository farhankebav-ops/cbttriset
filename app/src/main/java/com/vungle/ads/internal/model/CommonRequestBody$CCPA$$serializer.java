package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.vungle.ads.internal.model.CommonRequestBody;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.q1;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonRequestBody$CCPA$$serializer implements e0 {
    public static final CommonRequestBody$CCPA$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        CommonRequestBody$CCPA$$serializer commonRequestBody$CCPA$$serializer = new CommonRequestBody$CCPA$$serializer();
        INSTANCE = commonRequestBody$CCPA$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.CommonRequestBody.CCPA", commonRequestBody$CCPA$$serializer, 1);
        e1Var.j("status", false);
        descriptor = e1Var;
    }

    private CommonRequestBody$CCPA$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        return new c[]{q1.f11501a};
    }

    @Override // b7.b
    public CommonRequestBody.CCPA deserialize(e decoder) {
        String strDecodeStringElement;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 1;
        if (cVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
        } else {
            boolean z2 = true;
            int i8 = 0;
            strDecodeStringElement = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        throw new m(iDecodeElementIndex);
                    }
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                    i8 = 1;
                }
            }
            i2 = i8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new CommonRequestBody.CCPA(i2, strDecodeStringElement, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, CommonRequestBody.CCPA value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.CCPA.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
