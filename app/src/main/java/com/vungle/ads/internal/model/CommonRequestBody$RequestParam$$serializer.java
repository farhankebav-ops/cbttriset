package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.ironsource.C2574td;
import com.vungle.ads.internal.model.CommonRequestBody;
import d7.g;
import e7.e;
import e7.f;
import f7.c1;
import f7.d;
import f7.e0;
import f7.e1;
import f7.m1;
import f7.q0;
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonRequestBody$RequestParam$$serializer implements e0 {
    public static final CommonRequestBody$RequestParam$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        CommonRequestBody$RequestParam$$serializer commonRequestBody$RequestParam$$serializer = new CommonRequestBody$RequestParam$$serializer();
        INSTANCE = commonRequestBody$RequestParam$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.CommonRequestBody.RequestParam", commonRequestBody$RequestParam$$serializer, 6);
        e1Var.j(C2574td.f10303c, true);
        e1Var.j("ad_size", true);
        e1Var.j("ad_start_time", true);
        e1Var.j("app_id", true);
        e1Var.j("placement_reference_id", true);
        e1Var.j("user", true);
        descriptor = e1Var;
    }

    private CommonRequestBody$RequestParam$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new c[]{q.Y(new d(q1Var, 0)), q.Y(CommonRequestBody$AdSizeParam$$serializer.INSTANCE), q.Y(q0.f11499a), q.Y(q1Var), q.Y(q1Var), q.Y(q1Var)};
    }

    @Override // b7.b
    public CommonRequestBody.RequestParam deserialize(e decoder) {
        int i2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i8 = 5;
        int i9 = 3;
        Object objDecodeNullableSerializableElement7 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, new d(q1Var, 0), null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$AdSizeParam$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q0.f11499a, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, q1Var, null);
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, q1Var, null);
            objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, q1Var, null);
            i2 = 63;
        } else {
            boolean z2 = true;
            int i10 = 0;
            Object objDecodeNullableSerializableElement8 = null;
            Object objDecodeNullableSerializableElement9 = null;
            Object objDecodeNullableSerializableElement10 = null;
            Object objDecodeNullableSerializableElement11 = null;
            Object objDecodeNullableSerializableElement12 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i8 = 5;
                        continue;
                    case 0:
                        objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, new d(q1.f11501a, 0), objDecodeNullableSerializableElement7);
                        i10 |= 1;
                        i8 = 5;
                        i9 = 3;
                        continue;
                    case 1:
                        objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$AdSizeParam$$serializer.INSTANCE, objDecodeNullableSerializableElement8);
                        i10 |= 2;
                        break;
                    case 2:
                        objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q0.f11499a, objDecodeNullableSerializableElement9);
                        i10 |= 4;
                        break;
                    case 3:
                        objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i9, q1.f11501a, objDecodeNullableSerializableElement10);
                        i10 |= 8;
                        break;
                    case 4:
                        objDecodeNullableSerializableElement11 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, q1.f11501a, objDecodeNullableSerializableElement11);
                        i10 |= 16;
                        break;
                    case 5:
                        objDecodeNullableSerializableElement12 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i8, q1.f11501a, objDecodeNullableSerializableElement12);
                        i10 |= 32;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            Object obj = objDecodeNullableSerializableElement7;
            i2 = i10;
            objDecodeNullableSerializableElement = obj;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement8;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement9;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement10;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement11;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement12;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new CommonRequestBody.RequestParam(i2, (List) objDecodeNullableSerializableElement, (CommonRequestBody.AdSizeParam) objDecodeNullableSerializableElement2, (Long) objDecodeNullableSerializableElement3, (String) objDecodeNullableSerializableElement4, (String) objDecodeNullableSerializableElement5, (String) objDecodeNullableSerializableElement6, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, CommonRequestBody.RequestParam value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        e7.d dVarBeginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.RequestParam.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
