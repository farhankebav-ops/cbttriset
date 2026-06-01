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
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdPayload$ViewAbility$$serializer implements e0 {
    public static final AdPayload$ViewAbility$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        AdPayload$ViewAbility$$serializer adPayload$ViewAbility$$serializer = new AdPayload$ViewAbility$$serializer();
        INSTANCE = adPayload$ViewAbility$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.AdPayload.ViewAbility", adPayload$ViewAbility$$serializer, 1);
        e1Var.j("om", true);
        descriptor = e1Var;
    }

    private AdPayload$ViewAbility$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        return new c[]{q.Y(AdPayload$ViewAbilityInfo$$serializer.INSTANCE)};
    }

    @Override // b7.b
    public AdPayload.ViewAbility deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 1;
        m1 m1Var = null;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, AdPayload$ViewAbilityInfo$$serializer.INSTANCE, null);
        } else {
            boolean z2 = true;
            int i8 = 0;
            objDecodeNullableSerializableElement = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, AdPayload$ViewAbilityInfo$$serializer.INSTANCE, objDecodeNullableSerializableElement);
                    i8 = 1;
                }
            }
            i2 = i8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new AdPayload.ViewAbility(i2, (AdPayload.ViewAbilityInfo) objDecodeNullableSerializableElement, m1Var);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, AdPayload.ViewAbility value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AdPayload.ViewAbility.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
