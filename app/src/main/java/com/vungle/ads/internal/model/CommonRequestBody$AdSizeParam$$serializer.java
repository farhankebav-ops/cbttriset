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
import f7.l0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonRequestBody$AdSizeParam$$serializer implements e0 {
    public static final CommonRequestBody$AdSizeParam$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        CommonRequestBody$AdSizeParam$$serializer commonRequestBody$AdSizeParam$$serializer = new CommonRequestBody$AdSizeParam$$serializer();
        INSTANCE = commonRequestBody$AdSizeParam$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.CommonRequestBody.AdSizeParam", commonRequestBody$AdSizeParam$$serializer, 2);
        e1Var.j("w", false);
        e1Var.j("h", false);
        descriptor = e1Var;
    }

    private CommonRequestBody$AdSizeParam$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        l0 l0Var = l0.f11478a;
        return new c[]{l0Var, l0Var};
    }

    @Override // b7.b
    public CommonRequestBody.AdSizeParam deserialize(e decoder) {
        int iDecodeIntElement;
        int iDecodeIntElement2;
        int i2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(descriptor2, 0);
            iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(descriptor2, 1);
            i2 = 3;
        } else {
            boolean z2 = true;
            iDecodeIntElement = 0;
            int iDecodeIntElement3 = 0;
            int i8 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = cVarBeginStructure.decodeIntElement(descriptor2, 0);
                    i8 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new m(iDecodeElementIndex);
                    }
                    iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(descriptor2, 1);
                    i8 |= 2;
                }
            }
            iDecodeIntElement2 = iDecodeIntElement3;
            i2 = i8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new CommonRequestBody.AdSizeParam(i2, iDecodeIntElement, iDecodeIntElement2, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, CommonRequestBody.AdSizeParam value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.AdSizeParam.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
