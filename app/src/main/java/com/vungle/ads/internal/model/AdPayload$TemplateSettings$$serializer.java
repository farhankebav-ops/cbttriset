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
import f7.g0;
import f7.m1;
import f7.q1;
import java.util.Map;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdPayload$TemplateSettings$$serializer implements e0 {
    public static final AdPayload$TemplateSettings$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        AdPayload$TemplateSettings$$serializer adPayload$TemplateSettings$$serializer = new AdPayload$TemplateSettings$$serializer();
        INSTANCE = adPayload$TemplateSettings$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.AdPayload.TemplateSettings", adPayload$TemplateSettings$$serializer, 2);
        e1Var.j("normal_replacements", true);
        e1Var.j("cacheable_replacements", true);
        descriptor = e1Var;
    }

    private AdPayload$TemplateSettings$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new c[]{q.Y(new g0(q1Var, q1Var, 1)), q.Y(new g0(q1Var, AdPayload$CacheableReplacement$$serializer.INSTANCE, 1))};
    }

    @Override // b7.b
    public AdPayload.TemplateSettings deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        int i2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        m1 m1Var = null;
        if (cVarBeginStructure.decodeSequentially()) {
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, new g0(q1Var, q1Var, 1), null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, new g0(q1Var, AdPayload$CacheableReplacement$$serializer.INSTANCE, 1), null);
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
                    q1 q1Var2 = q1.f11501a;
                    objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, new g0(q1Var2, q1Var2, 1), objDecodeNullableSerializableElement);
                    i8 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, new g0(q1.f11501a, AdPayload$CacheableReplacement$$serializer.INSTANCE, 1), objDecodeNullableSerializableElement3);
                    i8 |= 2;
                }
            }
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement3;
            i2 = i8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new AdPayload.TemplateSettings(i2, (Map) objDecodeNullableSerializableElement, (Map) objDecodeNullableSerializableElement2, m1Var);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, AdPayload.TemplateSettings value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AdPayload.TemplateSettings.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
