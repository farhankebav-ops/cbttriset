package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.ironsource.Q6;
import com.vungle.ads.internal.model.DeviceNode;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.d0;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.m1;
import f7.q0;
import f7.q1;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DeviceNode$VungleExt$$serializer implements e0 {
    public static final DeviceNode$VungleExt$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        DeviceNode$VungleExt$$serializer deviceNode$VungleExt$$serializer = new DeviceNode$VungleExt$$serializer();
        INSTANCE = deviceNode$VungleExt$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.DeviceNode.VungleExt", deviceNode$VungleExt$$serializer, 22);
        e1Var.j("is_google_play_services_available", true);
        e1Var.j("app_set_id", true);
        e1Var.j("app_set_id_scope", true);
        e1Var.j("battery_level", true);
        e1Var.j("battery_state", true);
        e1Var.j("battery_saver_enabled", true);
        e1Var.j("connection_type", true);
        e1Var.j("connection_type_detail", true);
        e1Var.j("locale", true);
        e1Var.j("language", true);
        e1Var.j("time_zone", true);
        e1Var.j("volume_level", true);
        e1Var.j("sound_enabled", true);
        e1Var.j("is_tv", true);
        e1Var.j("sd_card_available", true);
        e1Var.j("is_sideload_enabled", true);
        e1Var.j(Q6.U0, true);
        e1Var.j("amazon_advertising_id", true);
        e1Var.j("sit", true);
        e1Var.j("oit", true);
        e1Var.j("ort", true);
        e1Var.j("obt", true);
        descriptor = e1Var;
    }

    private DeviceNode$VungleExt$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        c cVarY = q.Y(q1Var);
        l0 l0Var = l0.f11478a;
        c cVarY2 = q.Y(l0Var);
        c cVarY3 = q.Y(q1Var);
        c cVarY4 = q.Y(q1Var);
        c cVarY5 = q.Y(q1Var);
        c cVarY6 = q.Y(q1Var);
        c cVarY7 = q.Y(q1Var);
        c cVarY8 = q.Y(q1Var);
        c cVarY9 = q.Y(q1Var);
        c cVarY10 = q.Y(q1Var);
        q0 q0Var = q0.f11499a;
        c cVarY11 = q.Y(q0Var);
        c cVarY12 = q.Y(q0Var);
        c cVarY13 = q.Y(q0Var);
        c cVarY14 = q.Y(q0Var);
        f7.g gVar = f7.g.f11455a;
        d0 d0Var = d0.f11433a;
        return new c[]{gVar, cVarY, cVarY2, d0Var, cVarY3, l0Var, cVarY4, cVarY5, cVarY6, cVarY7, cVarY8, d0Var, l0Var, gVar, l0Var, gVar, cVarY9, cVarY10, cVarY11, cVarY12, cVarY13, cVarY14};
    }

    @Override // b7.b
    public DeviceNode.VungleExt deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object obj;
        Object obj2;
        Object objDecodeNullableSerializableElement3;
        int i2;
        Object objDecodeNullableSerializableElement4;
        Object obj3;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        Object objDecodeNullableSerializableElement7;
        boolean z2;
        float f4;
        Object objDecodeNullableSerializableElement8;
        Object objDecodeNullableSerializableElement9;
        Object objDecodeNullableSerializableElement10;
        int i8;
        boolean z7;
        boolean z8;
        int i9;
        int i10;
        float f8;
        Object objDecodeNullableSerializableElement11;
        Object obj4;
        int i11;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i12 = 0;
        if (cVarBeginStructure.decodeSequentially()) {
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(descriptor2, 0);
            q1 q1Var = q1.f11501a;
            Object objDecodeNullableSerializableElement12 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1Var, null);
            objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, null);
            float fDecodeFloatElement = cVarBeginStructure.decodeFloatElement(descriptor2, 3);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, q1Var, null);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(descriptor2, 5);
            objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, q1Var, null);
            objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, q1Var, null);
            objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, q1Var, null);
            objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, q1Var, null);
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, q1Var, null);
            float fDecodeFloatElement2 = cVarBeginStructure.decodeFloatElement(descriptor2, 11);
            int iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(descriptor2, 12);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(descriptor2, 13);
            int iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(descriptor2, 14);
            boolean zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(descriptor2, 15);
            obj = objDecodeNullableSerializableElement12;
            Object objDecodeNullableSerializableElement13 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 16, q1Var, null);
            Object objDecodeNullableSerializableElement14 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 17, q1Var, null);
            q0 q0Var = q0.f11499a;
            obj3 = objDecodeNullableSerializableElement14;
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 18, q0Var, null);
            Object objDecodeNullableSerializableElement15 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 19, q0Var, null);
            objDecodeNullableSerializableElement11 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 20, q0Var, null);
            f4 = fDecodeFloatElement;
            i2 = 4194303;
            i8 = iDecodeIntElement2;
            i10 = iDecodeIntElement;
            f8 = fDecodeFloatElement2;
            z2 = zDecodeBooleanElement3;
            i9 = iDecodeIntElement3;
            z8 = zDecodeBooleanElement2;
            z7 = zDecodeBooleanElement;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement15;
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 21, q0Var, null);
            obj2 = objDecodeNullableSerializableElement13;
        } else {
            objDecodeNullableSerializableElement = null;
            boolean z9 = true;
            Object objDecodeNullableSerializableElement16 = null;
            Object objDecodeNullableSerializableElement17 = null;
            Object objDecodeNullableSerializableElement18 = null;
            Object objDecodeNullableSerializableElement19 = null;
            Object objDecodeNullableSerializableElement20 = null;
            objDecodeNullableSerializableElement2 = null;
            Object objDecodeNullableSerializableElement21 = null;
            Object objDecodeNullableSerializableElement22 = null;
            Object objDecodeNullableSerializableElement23 = null;
            Object objDecodeNullableSerializableElement24 = null;
            Object objDecodeNullableSerializableElement25 = null;
            Object objDecodeNullableSerializableElement26 = null;
            boolean zDecodeBooleanElement4 = false;
            int iDecodeIntElement4 = 0;
            boolean zDecodeBooleanElement5 = false;
            boolean zDecodeBooleanElement6 = false;
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            float fDecodeFloatElement3 = 0.0f;
            float fDecodeFloatElement4 = 0.0f;
            Object objDecodeNullableSerializableElement27 = null;
            while (z9) {
                Object obj10 = objDecodeNullableSerializableElement16;
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        obj5 = objDecodeNullableSerializableElement18;
                        obj6 = objDecodeNullableSerializableElement26;
                        z9 = false;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement26 = obj6;
                        objDecodeNullableSerializableElement18 = obj5;
                        break;
                    case 0:
                        obj5 = objDecodeNullableSerializableElement18;
                        obj6 = objDecodeNullableSerializableElement26;
                        zDecodeBooleanElement5 = cVarBeginStructure.decodeBooleanElement(descriptor2, 0);
                        i12 |= 1;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement17 = objDecodeNullableSerializableElement17;
                        objDecodeNullableSerializableElement26 = obj6;
                        objDecodeNullableSerializableElement18 = obj5;
                        break;
                    case 1:
                        obj7 = objDecodeNullableSerializableElement17;
                        obj8 = objDecodeNullableSerializableElement18;
                        i12 |= 2;
                        objDecodeNullableSerializableElement26 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1.f11501a, objDecodeNullableSerializableElement26);
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement18 = obj8;
                        objDecodeNullableSerializableElement17 = obj7;
                        break;
                    case 2:
                        obj7 = objDecodeNullableSerializableElement17;
                        obj8 = objDecodeNullableSerializableElement18;
                        objDecodeNullableSerializableElement16 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, obj10);
                        i12 |= 4;
                        objDecodeNullableSerializableElement18 = obj8;
                        objDecodeNullableSerializableElement17 = obj7;
                        break;
                    case 3:
                        obj9 = objDecodeNullableSerializableElement17;
                        fDecodeFloatElement3 = cVarBeginStructure.decodeFloatElement(descriptor2, 3);
                        i12 |= 8;
                        objDecodeNullableSerializableElement17 = obj9;
                        objDecodeNullableSerializableElement16 = obj10;
                        break;
                    case 4:
                        obj9 = objDecodeNullableSerializableElement17;
                        objDecodeNullableSerializableElement20 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, q1.f11501a, objDecodeNullableSerializableElement20);
                        i12 |= 16;
                        objDecodeNullableSerializableElement17 = obj9;
                        objDecodeNullableSerializableElement16 = obj10;
                        break;
                    case 5:
                        obj4 = objDecodeNullableSerializableElement20;
                        iDecodeIntElement6 = cVarBeginStructure.decodeIntElement(descriptor2, 5);
                        i12 |= 32;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 6:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement17 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, q1.f11501a, objDecodeNullableSerializableElement17);
                        i12 |= 64;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 7:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement18 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, q1.f11501a, objDecodeNullableSerializableElement18);
                        i12 |= 128;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 8:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement25 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, q1.f11501a, objDecodeNullableSerializableElement25);
                        i12 |= 256;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 9:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement24 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, q1.f11501a, objDecodeNullableSerializableElement24);
                        i12 |= 512;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 10:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement23 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, q1.f11501a, objDecodeNullableSerializableElement23);
                        i12 |= 1024;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 11:
                        obj4 = objDecodeNullableSerializableElement20;
                        fDecodeFloatElement4 = cVarBeginStructure.decodeFloatElement(descriptor2, 11);
                        i12 |= 2048;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 12:
                        obj4 = objDecodeNullableSerializableElement20;
                        iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(descriptor2, 12);
                        i12 |= 4096;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 13:
                        obj4 = objDecodeNullableSerializableElement20;
                        zDecodeBooleanElement6 = cVarBeginStructure.decodeBooleanElement(descriptor2, 13);
                        i12 |= 8192;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 14:
                        obj4 = objDecodeNullableSerializableElement20;
                        iDecodeIntElement5 = cVarBeginStructure.decodeIntElement(descriptor2, 14);
                        i12 |= 16384;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 15:
                        obj4 = objDecodeNullableSerializableElement20;
                        zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(descriptor2, 15);
                        i12 |= 32768;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 16:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement19 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 16, q1.f11501a, objDecodeNullableSerializableElement19);
                        i11 = 65536;
                        i12 |= i11;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 17:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement22 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 17, q1.f11501a, objDecodeNullableSerializableElement22);
                        i11 = 131072;
                        i12 |= i11;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 18:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement21 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 18, q0.f11499a, objDecodeNullableSerializableElement21);
                        i11 = 262144;
                        i12 |= i11;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 19:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 19, q0.f11499a, objDecodeNullableSerializableElement);
                        i11 = 524288;
                        i12 |= i11;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 20:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement27 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 20, q0.f11499a, objDecodeNullableSerializableElement27);
                        i11 = 1048576;
                        i12 |= i11;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    case 21:
                        obj4 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 21, q0.f11499a, objDecodeNullableSerializableElement2);
                        i11 = 2097152;
                        i12 |= i11;
                        objDecodeNullableSerializableElement16 = obj10;
                        objDecodeNullableSerializableElement20 = obj4;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            Object obj11 = objDecodeNullableSerializableElement18;
            Object obj12 = objDecodeNullableSerializableElement26;
            Object obj13 = objDecodeNullableSerializableElement16;
            obj = obj12;
            obj2 = objDecodeNullableSerializableElement19;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement20;
            i2 = i12;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement21;
            obj3 = objDecodeNullableSerializableElement22;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement23;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement24;
            objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement25;
            z2 = zDecodeBooleanElement4;
            f4 = fDecodeFloatElement3;
            objDecodeNullableSerializableElement8 = obj13;
            objDecodeNullableSerializableElement9 = obj11;
            objDecodeNullableSerializableElement10 = objDecodeNullableSerializableElement17;
            i8 = iDecodeIntElement4;
            z7 = zDecodeBooleanElement5;
            z8 = zDecodeBooleanElement6;
            i9 = iDecodeIntElement5;
            i10 = iDecodeIntElement6;
            f8 = fDecodeFloatElement4;
            objDecodeNullableSerializableElement11 = objDecodeNullableSerializableElement27;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new DeviceNode.VungleExt(i2, z7, (String) obj, (Integer) objDecodeNullableSerializableElement8, f4, (String) objDecodeNullableSerializableElement3, i10, (String) objDecodeNullableSerializableElement10, (String) objDecodeNullableSerializableElement9, (String) objDecodeNullableSerializableElement7, (String) objDecodeNullableSerializableElement6, (String) objDecodeNullableSerializableElement5, f8, i8, z8, i9, z2, (String) obj2, (String) obj3, (Long) objDecodeNullableSerializableElement4, (Long) objDecodeNullableSerializableElement, (Long) objDecodeNullableSerializableElement11, (Long) objDecodeNullableSerializableElement2, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, DeviceNode.VungleExt value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        DeviceNode.VungleExt.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
