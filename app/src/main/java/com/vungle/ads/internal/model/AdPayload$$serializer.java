package com.vungle.ads.internal.model;

import b7.a;
import b7.c;
import b7.m;
import d7.g;
import e7.f;
import f7.c1;
import f7.d;
import f7.e0;
import f7.e1;
import f7.g0;
import f7.q1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdPayload$$serializer implements e0 {
    public static final AdPayload$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        AdPayload$$serializer adPayload$$serializer = new AdPayload$$serializer();
        INSTANCE = adPayload$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.AdPayload", adPayload$$serializer, 6);
        e1Var.j("ads", true);
        e1Var.j("config", true);
        e1Var.j("mraidFiles", true);
        e1Var.j("incentivizedTextSettings", true);
        e1Var.j("assetsFullyDownloaded", true);
        e1Var.j("indexFilePath", true);
        descriptor = e1Var;
    }

    private AdPayload$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        c cVarY = q.Y(new d(AdPayload$PlacementAdUnit$$serializer.INSTANCE, 0));
        c cVarY2 = q.Y(ConfigPayload$$serializer.INSTANCE);
        e eVarA = b0.a(ConcurrentHashMap.class);
        q1 q1Var = q1.f11501a;
        return new c[]{cVarY, cVarY2, new a(eVarA, new c[]{q1Var, q1Var}), new g0(q1Var, q1Var, 1), f7.g.f11455a, q.Y(q1Var)};
    }

    @Override // b7.b
    public AdPayload deserialize(e7.e decoder) {
        boolean z2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        int i2;
        Object objDecodeSerializableElement;
        Object objDecodeSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i8 = 5;
        int i9 = 3;
        int i10 = 0;
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, new d(AdPayload$PlacementAdUnit$$serializer.INSTANCE, 0), null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$$serializer.INSTANCE, null);
            e eVarA = b0.a(ConcurrentHashMap.class);
            q1 q1Var = q1.f11501a;
            objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(descriptor2, 2, new a(eVarA, new c[]{q1Var, q1Var}), null);
            objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(descriptor2, 3, new g0(q1Var, q1Var, 1), null);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(descriptor2, 4);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, q1Var, null);
            i2 = 63;
            z2 = zDecodeBooleanElement;
        } else {
            int i11 = 1;
            boolean zDecodeBooleanElement2 = false;
            Object objDecodeNullableSerializableElement4 = null;
            Object objDecodeNullableSerializableElement5 = null;
            Object objDecodeSerializableElement3 = null;
            Object objDecodeSerializableElement4 = null;
            Object objDecodeNullableSerializableElement6 = null;
            int i12 = 0;
            while (i11 != 0) {
                int i13 = i10;
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i10 = i13;
                        i11 = i10;
                        break;
                    case 0:
                        i10 = i13;
                        objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i10, new d(AdPayload$PlacementAdUnit$$serializer.INSTANCE, i10), objDecodeNullableSerializableElement4);
                        i12 |= 1;
                        i8 = 5;
                        i9 = 3;
                        break;
                    case 1:
                        objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$$serializer.INSTANCE, objDecodeNullableSerializableElement5);
                        i12 |= 2;
                        i10 = i13;
                        i8 = 5;
                        i9 = 3;
                        break;
                    case 2:
                        e eVarA2 = b0.a(ConcurrentHashMap.class);
                        c[] cVarArr = new c[2];
                        q1 q1Var2 = q1.f11501a;
                        cVarArr[i13] = q1Var2;
                        cVarArr[1] = q1Var2;
                        objDecodeSerializableElement3 = cVarBeginStructure.decodeSerializableElement(descriptor2, 2, new a(eVarA2, cVarArr), objDecodeSerializableElement3);
                        i12 |= 4;
                        i10 = i13;
                        i8 = 5;
                        i9 = 3;
                        break;
                    case 3:
                        q1 q1Var3 = q1.f11501a;
                        objDecodeSerializableElement4 = cVarBeginStructure.decodeSerializableElement(descriptor2, i9, new g0(q1Var3, q1Var3, 1), objDecodeSerializableElement4);
                        i12 |= 8;
                        i10 = i13;
                        i8 = 5;
                        break;
                    case 4:
                        zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(descriptor2, 4);
                        i12 |= 16;
                        i10 = i13;
                        break;
                    case 5:
                        objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i8, q1.f11501a, objDecodeNullableSerializableElement6);
                        i12 |= 32;
                        i10 = i13;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            Object obj = objDecodeNullableSerializableElement5;
            z2 = zDecodeBooleanElement2;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement4;
            objDecodeNullableSerializableElement2 = obj;
            i2 = i12;
            objDecodeSerializableElement = objDecodeSerializableElement3;
            objDecodeSerializableElement2 = objDecodeSerializableElement4;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement6;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new AdPayload(i2, (List) objDecodeNullableSerializableElement, (ConfigPayload) objDecodeNullableSerializableElement2, (ConcurrentHashMap) objDecodeSerializableElement, (Map) objDecodeSerializableElement2, z2, (String) objDecodeNullableSerializableElement3, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, AdPayload value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        e7.d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AdPayload.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
