package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.vungle.ads.fpd.FirstPartyData;
import com.vungle.ads.fpd.FirstPartyData$$serializer;
import com.vungle.ads.internal.model.CommonRequestBody;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.m1;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonRequestBody$User$$serializer implements e0 {
    public static final CommonRequestBody$User$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        CommonRequestBody$User$$serializer commonRequestBody$User$$serializer = new CommonRequestBody$User$$serializer();
        INSTANCE = commonRequestBody$User$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.CommonRequestBody.User", commonRequestBody$User$$serializer, 5);
        e1Var.j("gdpr", true);
        e1Var.j("ccpa", true);
        e1Var.j("coppa", true);
        e1Var.j("fpd", true);
        e1Var.j("iab", true);
        descriptor = e1Var;
    }

    private CommonRequestBody$User$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        return new c[]{q.Y(CommonRequestBody$GDPR$$serializer.INSTANCE), q.Y(CommonRequestBody$CCPA$$serializer.INSTANCE), q.Y(CommonRequestBody$COPPA$$serializer.INSTANCE), q.Y(FirstPartyData$$serializer.INSTANCE), q.Y(CommonRequestBody$IAB$$serializer.INSTANCE)};
    }

    @Override // b7.b
    public CommonRequestBody.User deserialize(e decoder) {
        int i2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        Object objDecodeNullableSerializableElement6 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, CommonRequestBody$GDPR$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$CCPA$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, CommonRequestBody$COPPA$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FirstPartyData$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CommonRequestBody$IAB$$serializer.INSTANCE, null);
            i2 = 31;
        } else {
            boolean z2 = true;
            int i8 = 0;
            Object objDecodeNullableSerializableElement7 = null;
            Object objDecodeNullableSerializableElement8 = null;
            Object objDecodeNullableSerializableElement9 = null;
            Object objDecodeNullableSerializableElement10 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, CommonRequestBody$GDPR$$serializer.INSTANCE, objDecodeNullableSerializableElement6);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$CCPA$$serializer.INSTANCE, objDecodeNullableSerializableElement7);
                    i8 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, CommonRequestBody$COPPA$$serializer.INSTANCE, objDecodeNullableSerializableElement8);
                    i8 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FirstPartyData$$serializer.INSTANCE, objDecodeNullableSerializableElement9);
                    i8 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CommonRequestBody$IAB$$serializer.INSTANCE, objDecodeNullableSerializableElement10);
                    i8 |= 16;
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
        return new CommonRequestBody.User(i2, (CommonRequestBody.GDPR) objDecodeNullableSerializableElement, (CommonRequestBody.CCPA) objDecodeNullableSerializableElement2, (CommonRequestBody.COPPA) objDecodeNullableSerializableElement3, (FirstPartyData) objDecodeNullableSerializableElement4, (CommonRequestBody.IAB) objDecodeNullableSerializableElement5, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, CommonRequestBody.User value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.User.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
