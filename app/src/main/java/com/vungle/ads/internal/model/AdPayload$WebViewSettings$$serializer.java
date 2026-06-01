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
public final class AdPayload$WebViewSettings$$serializer implements e0 {
    public static final AdPayload$WebViewSettings$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        AdPayload$WebViewSettings$$serializer adPayload$WebViewSettings$$serializer = new AdPayload$WebViewSettings$$serializer();
        INSTANCE = adPayload$WebViewSettings$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.AdPayload.WebViewSettings", adPayload$WebViewSettings$$serializer, 2);
        e1Var.j("allow_file_access_from_file_urls", true);
        e1Var.j("allow_universal_access_from_file_urls", true);
        descriptor = e1Var;
    }

    private AdPayload$WebViewSettings$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        f7.g gVar = f7.g.f11455a;
        return new c[]{q.Y(gVar), q.Y(gVar)};
    }

    @Override // b7.b
    public AdPayload.WebViewSettings deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        int i2;
        Object objDecodeNullableSerializableElement2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        m1 m1Var = null;
        if (cVarBeginStructure.decodeSequentially()) {
            f7.g gVar = f7.g.f11455a;
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, gVar, null);
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, gVar, null);
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
                    objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, f7.g.f11455a, objDecodeNullableSerializableElement3);
                    i8 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, f7.g.f11455a, objDecodeNullableSerializableElement);
                    i8 |= 2;
                }
            }
            i2 = i8;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement3;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new AdPayload.WebViewSettings(i2, (Boolean) objDecodeNullableSerializableElement2, (Boolean) objDecodeNullableSerializableElement, m1Var);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, AdPayload.WebViewSettings value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AdPayload.WebViewSettings.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
