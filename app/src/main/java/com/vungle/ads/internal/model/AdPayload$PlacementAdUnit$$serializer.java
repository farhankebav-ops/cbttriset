package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.vungle.ads.internal.model.AdPayload;
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
public final class AdPayload$PlacementAdUnit$$serializer implements e0 {
    public static final AdPayload$PlacementAdUnit$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        AdPayload$PlacementAdUnit$$serializer adPayload$PlacementAdUnit$$serializer = new AdPayload$PlacementAdUnit$$serializer();
        INSTANCE = adPayload$PlacementAdUnit$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.AdPayload.PlacementAdUnit", adPayload$PlacementAdUnit$$serializer, 2);
        e1Var.j("placement_reference_id", true);
        e1Var.j("ad_markup", true);
        descriptor = e1Var;
    }

    private AdPayload$PlacementAdUnit$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        return new c[]{q.Y(q1.f11501a), q.Y(AdPayload$AdUnit$$serializer.INSTANCE)};
    }

    @Override // b7.b
    public AdPayload.PlacementAdUnit deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        int i2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        m1 m1Var = null;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, q1.f11501a, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, AdPayload$AdUnit$$serializer.INSTANCE, null);
            i2 = 3;
        } else {
            boolean z2 = true;
            int i8 = 0;
            objDecodeNullableSerializableElement = null;
            Object objDecodeNullableSerializableElement3 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, q1.f11501a, objDecodeNullableSerializableElement);
                    i8 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, AdPayload$AdUnit$$serializer.INSTANCE, objDecodeNullableSerializableElement3);
                    i8 |= 2;
                }
            }
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement3;
            i2 = i8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new AdPayload.PlacementAdUnit(i2, (String) objDecodeNullableSerializableElement, (AdPayload.AdUnit) objDecodeNullableSerializableElement2, m1Var);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, AdPayload.PlacementAdUnit value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AdPayload.PlacementAdUnit.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
