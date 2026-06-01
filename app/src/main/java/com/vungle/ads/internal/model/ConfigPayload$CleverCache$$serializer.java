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
import f7.l0;
import f7.m1;
import f7.q0;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigPayload$CleverCache$$serializer implements e0 {
    public static final ConfigPayload$CleverCache$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        ConfigPayload$CleverCache$$serializer configPayload$CleverCache$$serializer = new ConfigPayload$CleverCache$$serializer();
        INSTANCE = configPayload$CleverCache$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.ConfigPayload.CleverCache", configPayload$CleverCache$$serializer, 3);
        e1Var.j("enabled", true);
        e1Var.j("disk_size", true);
        e1Var.j("disk_percentage", true);
        descriptor = e1Var;
    }

    private ConfigPayload$CleverCache$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        return new c[]{q.Y(f7.g.f11455a), q.Y(q0.f11499a), q.Y(l0.f11478a)};
    }

    @Override // b7.b
    public ConfigPayload.CleverCache deserialize(e decoder) {
        int i2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        Object objDecodeNullableSerializableElement4 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, f7.g.f11455a, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q0.f11499a, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, null);
            i2 = 7;
        } else {
            boolean z2 = true;
            int i8 = 0;
            Object objDecodeNullableSerializableElement5 = null;
            Object objDecodeNullableSerializableElement6 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, f7.g.f11455a, objDecodeNullableSerializableElement4);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q0.f11499a, objDecodeNullableSerializableElement5);
                    i8 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new m(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, objDecodeNullableSerializableElement6);
                    i8 |= 4;
                }
            }
            Object obj = objDecodeNullableSerializableElement4;
            i2 = i8;
            objDecodeNullableSerializableElement = obj;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement5;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement6;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new ConfigPayload.CleverCache(i2, (Boolean) objDecodeNullableSerializableElement, (Long) objDecodeNullableSerializableElement2, (Integer) objDecodeNullableSerializableElement3, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, ConfigPayload.CleverCache value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        ConfigPayload.CleverCache.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
