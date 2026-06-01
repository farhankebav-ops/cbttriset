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
import f7.q0;
import f7.q1;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonRequestBody$GDPR$$serializer implements e0 {
    public static final CommonRequestBody$GDPR$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        CommonRequestBody$GDPR$$serializer commonRequestBody$GDPR$$serializer = new CommonRequestBody$GDPR$$serializer();
        INSTANCE = commonRequestBody$GDPR$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.CommonRequestBody.GDPR", commonRequestBody$GDPR$$serializer, 4);
        e1Var.j("consent_status", false);
        e1Var.j("consent_source", false);
        e1Var.j("consent_timestamp", false);
        e1Var.j("consent_message_version", false);
        descriptor = e1Var;
    }

    private CommonRequestBody$GDPR$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new c[]{q1Var, q1Var, q0.f11499a, q1Var};
    }

    @Override // b7.b
    public CommonRequestBody.GDPR deserialize(e decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        int i2;
        String str;
        long j;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(descriptor2, 2);
            strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 3);
            i2 = 15;
            str = strDecodeStringElement3;
            j = jDecodeLongElement;
        } else {
            strDecodeStringElement = null;
            String strDecodeStringElement4 = null;
            boolean z2 = true;
            long jDecodeLongElement2 = 0;
            String strDecodeStringElement5 = null;
            int i8 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                    i8 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(descriptor2, 2);
                    i8 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new m(iDecodeElementIndex);
                    }
                    strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(descriptor2, 3);
                    i8 |= 8;
                }
            }
            strDecodeStringElement2 = strDecodeStringElement5;
            i2 = i8;
            str = strDecodeStringElement4;
            j = jDecodeLongElement2;
        }
        String str2 = strDecodeStringElement;
        cVarBeginStructure.endStructure(descriptor2);
        return new CommonRequestBody.GDPR(i2, str2, str, j, strDecodeStringElement2, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, CommonRequestBody.GDPR value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.GDPR.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
