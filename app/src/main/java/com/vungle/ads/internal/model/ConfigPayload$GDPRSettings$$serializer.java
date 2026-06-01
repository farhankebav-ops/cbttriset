package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.vungle.ads.internal.model.ConfigPayload;
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
public final class ConfigPayload$GDPRSettings$$serializer implements e0 {
    public static final ConfigPayload$GDPRSettings$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        ConfigPayload$GDPRSettings$$serializer configPayload$GDPRSettings$$serializer = new ConfigPayload$GDPRSettings$$serializer();
        INSTANCE = configPayload$GDPRSettings$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.ConfigPayload.GDPRSettings", configPayload$GDPRSettings$$serializer, 6);
        e1Var.j("is_country_data_protected", true);
        e1Var.j("consent_title", true);
        e1Var.j("consent_message", true);
        e1Var.j("consent_message_version", true);
        e1Var.j("button_accept", true);
        e1Var.j("button_deny", true);
        descriptor = e1Var;
    }

    private ConfigPayload$GDPRSettings$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        c cVarY = q.Y(f7.g.f11455a);
        q1 q1Var = q1.f11501a;
        return new c[]{cVarY, q.Y(q1Var), q.Y(q1Var), q.Y(q1Var), q.Y(q1Var), q.Y(q1Var)};
    }

    @Override // b7.b
    public ConfigPayload.GDPRSettings deserialize(e decoder) {
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
        Object objDecodeNullableSerializableElement7 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, f7.g.f11455a, null);
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1Var, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1Var, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, q1Var, null);
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, q1Var, null);
            objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, q1Var, null);
            i2 = 63;
        } else {
            boolean z2 = true;
            int i9 = 0;
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
                        break;
                    case 0:
                        objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, f7.g.f11455a, objDecodeNullableSerializableElement7);
                        i9 |= 1;
                        i8 = 5;
                        break;
                    case 1:
                        objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1.f11501a, objDecodeNullableSerializableElement8);
                        i9 |= 2;
                        break;
                    case 2:
                        objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, q1.f11501a, objDecodeNullableSerializableElement9);
                        i9 |= 4;
                        break;
                    case 3:
                        objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, q1.f11501a, objDecodeNullableSerializableElement10);
                        i9 |= 8;
                        break;
                    case 4:
                        objDecodeNullableSerializableElement11 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, q1.f11501a, objDecodeNullableSerializableElement11);
                        i9 |= 16;
                        break;
                    case 5:
                        objDecodeNullableSerializableElement12 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i8, q1.f11501a, objDecodeNullableSerializableElement12);
                        i9 |= 32;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            Object obj = objDecodeNullableSerializableElement7;
            i2 = i9;
            objDecodeNullableSerializableElement = obj;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement8;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement9;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement10;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement11;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement12;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new ConfigPayload.GDPRSettings(i2, (Boolean) objDecodeNullableSerializableElement, (String) objDecodeNullableSerializableElement2, (String) objDecodeNullableSerializableElement3, (String) objDecodeNullableSerializableElement4, (String) objDecodeNullableSerializableElement5, (String) objDecodeNullableSerializableElement6, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, ConfigPayload.GDPRSettings value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        ConfigPayload.GDPRSettings.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
