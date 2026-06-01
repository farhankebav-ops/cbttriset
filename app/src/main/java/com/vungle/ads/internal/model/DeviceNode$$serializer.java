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
import f7.e0;
import f7.e1;
import f7.l0;
import f7.m1;
import f7.q1;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DeviceNode$$serializer implements e0 {
    public static final DeviceNode$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        DeviceNode$$serializer deviceNode$$serializer = new DeviceNode$$serializer();
        INSTANCE = deviceNode$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.DeviceNode", deviceNode$$serializer, 11);
        e1Var.j(Q6.f7468t, false);
        e1Var.j(Q6.B, false);
        e1Var.j(Q6.G, false);
        e1Var.j(Q6.P0, true);
        e1Var.j(Q6.F, false);
        e1Var.j("w", false);
        e1Var.j("h", false);
        e1Var.j(Q6.d0, true);
        e1Var.j("ifa", true);
        e1Var.j("lmt", true);
        e1Var.j("ext", true);
        descriptor = e1Var;
    }

    private DeviceNode$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        c cVarY = q.Y(q1Var);
        l0 l0Var = l0.f11478a;
        return new c[]{q1Var, q1Var, q1Var, cVarY, q1Var, l0Var, l0Var, q.Y(q1Var), q.Y(q1Var), q.Y(l0Var), q.Y(DeviceNode$VungleExt$$serializer.INSTANCE)};
    }

    @Override // b7.b
    public DeviceNode deserialize(e decoder) {
        int i2;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        int i8;
        int i9;
        String str;
        String str2;
        String str3;
        String str4;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i10 = 10;
        int i11 = 9;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(descriptor2, 2);
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, q1Var, null);
            String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(descriptor2, 4);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(descriptor2, 5);
            int iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(descriptor2, 6);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, q1Var, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, q1Var, null);
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, l0.f11478a, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, DeviceNode$VungleExt$$serializer.INSTANCE, null);
            str = strDecodeStringElement;
            i2 = iDecodeIntElement2;
            i8 = iDecodeIntElement;
            str4 = strDecodeStringElement4;
            str3 = strDecodeStringElement3;
            str2 = strDecodeStringElement2;
            i9 = 2047;
        } else {
            boolean z2 = true;
            int iDecodeIntElement3 = 0;
            int i12 = 0;
            Object objDecodeNullableSerializableElement6 = null;
            Object objDecodeNullableSerializableElement7 = null;
            Object objDecodeNullableSerializableElement8 = null;
            Object objDecodeNullableSerializableElement9 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            int iDecodeIntElement4 = 0;
            Object objDecodeNullableSerializableElement10 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i10 = 10;
                        break;
                    case 0:
                        strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                        i12 |= 1;
                        i10 = 10;
                        i11 = 9;
                        break;
                    case 1:
                        strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                        i12 |= 2;
                        i10 = 10;
                        i11 = 9;
                        break;
                    case 2:
                        strDecodeStringElement7 = cVarBeginStructure.decodeStringElement(descriptor2, 2);
                        i12 |= 4;
                        i10 = 10;
                        i11 = 9;
                        break;
                    case 3:
                        objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, q1.f11501a, objDecodeNullableSerializableElement10);
                        i12 |= 8;
                        i10 = 10;
                        i11 = 9;
                        break;
                    case 4:
                        strDecodeStringElement8 = cVarBeginStructure.decodeStringElement(descriptor2, 4);
                        i12 |= 16;
                        i10 = 10;
                        break;
                    case 5:
                        iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(descriptor2, 5);
                        i12 |= 32;
                        break;
                    case 6:
                        iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(descriptor2, 6);
                        i12 |= 64;
                        break;
                    case 7:
                        objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, q1.f11501a, objDecodeNullableSerializableElement9);
                        i12 |= 128;
                        break;
                    case 8:
                        objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, q1.f11501a, objDecodeNullableSerializableElement8);
                        i12 |= 256;
                        break;
                    case 9:
                        objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i11, l0.f11478a, objDecodeNullableSerializableElement6);
                        i12 |= 512;
                        break;
                    case 10:
                        objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, i10, DeviceNode$VungleExt$$serializer.INSTANCE, objDecodeNullableSerializableElement7);
                        i12 |= 1024;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            i2 = iDecodeIntElement3;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement6;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement7;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement8;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement9;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement10;
            i8 = iDecodeIntElement4;
            i9 = i12;
            str = strDecodeStringElement5;
            str2 = strDecodeStringElement6;
            str3 = strDecodeStringElement7;
            str4 = strDecodeStringElement8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new DeviceNode(i9, str, str2, str3, (String) objDecodeNullableSerializableElement5, str4, i8, i2, (String) objDecodeNullableSerializableElement4, (String) objDecodeNullableSerializableElement3, (Integer) objDecodeNullableSerializableElement, (DeviceNode.VungleExt) objDecodeNullableSerializableElement2, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, DeviceNode value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        DeviceNode.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
