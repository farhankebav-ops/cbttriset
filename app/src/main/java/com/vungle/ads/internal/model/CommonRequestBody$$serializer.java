package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.ironsource.C2300e4;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.ui.AdActivity;
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
public final class CommonRequestBody$$serializer implements e0 {
    public static final CommonRequestBody$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        CommonRequestBody$$serializer commonRequestBody$$serializer = new CommonRequestBody$$serializer();
        INSTANCE = commonRequestBody$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.CommonRequestBody", commonRequestBody$$serializer, 5);
        e1Var.j(C2300e4.h.G, false);
        e1Var.j("app", true);
        e1Var.j("user", true);
        e1Var.j("ext", true);
        e1Var.j(AdActivity.REQUEST_KEY_EXTRA, true);
        descriptor = e1Var;
    }

    private CommonRequestBody$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        return new c[]{DeviceNode$$serializer.INSTANCE, q.Y(AppNode$$serializer.INSTANCE), q.Y(CommonRequestBody$User$$serializer.INSTANCE), q.Y(CommonRequestBody$RequestExt$$serializer.INSTANCE), q.Y(CommonRequestBody$RequestParam$$serializer.INSTANCE)};
    }

    @Override // b7.b
    public CommonRequestBody deserialize(e decoder) {
        int i2;
        Object objDecodeSerializableElement;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        Object objDecodeSerializableElement2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(descriptor2, 0, DeviceNode$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, AppNode$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, CommonRequestBody$User$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, CommonRequestBody$RequestExt$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CommonRequestBody$RequestParam$$serializer.INSTANCE, null);
            i2 = 31;
        } else {
            boolean z2 = true;
            int i8 = 0;
            Object objDecodeNullableSerializableElement5 = null;
            Object objDecodeNullableSerializableElement6 = null;
            Object objDecodeNullableSerializableElement7 = null;
            Object objDecodeNullableSerializableElement8 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(descriptor2, 0, DeviceNode$$serializer.INSTANCE, objDecodeSerializableElement2);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, AppNode$$serializer.INSTANCE, objDecodeNullableSerializableElement5);
                    i8 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, CommonRequestBody$User$$serializer.INSTANCE, objDecodeNullableSerializableElement6);
                    i8 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, CommonRequestBody$RequestExt$$serializer.INSTANCE, objDecodeNullableSerializableElement7);
                    i8 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CommonRequestBody$RequestParam$$serializer.INSTANCE, objDecodeNullableSerializableElement8);
                    i8 |= 16;
                }
            }
            Object obj = objDecodeSerializableElement2;
            i2 = i8;
            objDecodeSerializableElement = obj;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement5;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement6;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement7;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new CommonRequestBody(i2, (DeviceNode) objDecodeSerializableElement, (AppNode) objDecodeNullableSerializableElement, (CommonRequestBody.User) objDecodeNullableSerializableElement2, (CommonRequestBody.RequestExt) objDecodeNullableSerializableElement3, (CommonRequestBody.RequestParam) objDecodeNullableSerializableElement4, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, CommonRequestBody value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
