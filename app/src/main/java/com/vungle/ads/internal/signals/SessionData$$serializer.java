package com.vungle.ads.internal.signals;

import b7.c;
import b7.m;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.vungle.ads.internal.model.UnclosedAd$$serializer;
import d7.g;
import e7.e;
import e7.f;
import f7.c1;
import f7.d;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.q0;
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionData$$serializer implements e0 {
    public static final SessionData$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        SessionData$$serializer sessionData$$serializer = new SessionData$$serializer();
        INSTANCE = sessionData$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.signals.SessionData", sessionData$$serializer, 12);
        e1Var.j("103", false);
        e1Var.j(StatisticData.ERROR_CODE_IO_ERROR, true);
        e1Var.j(StatisticData.ERROR_CODE_NOT_FOUND, true);
        e1Var.j("106", true);
        e1Var.j("102", true);
        e1Var.j("104", true);
        e1Var.j("105", true);
        e1Var.j("112", true);
        e1Var.j("113", true);
        e1Var.j("114", true);
        e1Var.j("115", true);
        e1Var.j("116", true);
        descriptor = e1Var;
    }

    private SessionData$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        d dVar = new d(SignaledAd$$serializer.INSTANCE, 0);
        d dVar2 = new d(UnclosedAd$$serializer.INSTANCE, 0);
        l0 l0Var = l0.f11478a;
        q0 q0Var = q0.f11499a;
        return new c[]{l0Var, q1.f11501a, q0Var, dVar, q0Var, l0Var, dVar2, l0Var, l0Var, l0Var, l0Var, l0Var};
    }

    @Override // b7.b
    public SessionData deserialize(e decoder) {
        int i2;
        int iDecodeIntElement;
        Object objDecodeSerializableElement;
        Object objDecodeSerializableElement2;
        int i8;
        int i9;
        int i10;
        int iDecodeIntElement2;
        int iDecodeIntElement3;
        long j;
        String str;
        long j3;
        char c7;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        int i11 = 9;
        int i12 = 7;
        int i13 = 0;
        if (cVarBeginStructure.decodeSequentially()) {
            int iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(descriptor2, 0);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 1);
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(descriptor2, 2);
            objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(descriptor2, 3, new d(SignaledAd$$serializer.INSTANCE, 0), null);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(descriptor2, 4);
            int iDecodeIntElement5 = cVarBeginStructure.decodeIntElement(descriptor2, 5);
            objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(descriptor2, 6, new d(UnclosedAd$$serializer.INSTANCE, 0), null);
            int iDecodeIntElement6 = cVarBeginStructure.decodeIntElement(descriptor2, 7);
            int iDecodeIntElement7 = cVarBeginStructure.decodeIntElement(descriptor2, 8);
            i13 = 4095;
            i2 = iDecodeIntElement4;
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(descriptor2, 9);
            i8 = iDecodeIntElement6;
            i9 = iDecodeIntElement7;
            i10 = iDecodeIntElement5;
            iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(descriptor2, 10);
            iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(descriptor2, 11);
            j = jDecodeLongElement2;
            str = strDecodeStringElement;
            j3 = jDecodeLongElement;
        } else {
            int i14 = 11;
            long jDecodeLongElement3 = 0;
            long jDecodeLongElement4 = 0;
            boolean z2 = true;
            int iDecodeIntElement8 = 0;
            int iDecodeIntElement9 = 0;
            int iDecodeIntElement10 = 0;
            int iDecodeIntElement11 = 0;
            int iDecodeIntElement12 = 0;
            int iDecodeIntElement13 = 0;
            Object objDecodeSerializableElement3 = null;
            Object objDecodeSerializableElement4 = null;
            String strDecodeStringElement2 = null;
            int iDecodeIntElement14 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i12 = 7;
                        break;
                    case 0:
                        i13 |= 1;
                        iDecodeIntElement8 = cVarBeginStructure.decodeIntElement(descriptor2, 0);
                        i14 = 11;
                        i11 = 9;
                        i12 = 7;
                        break;
                    case 1:
                        c7 = 3;
                        strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                        i13 |= 2;
                        i14 = 11;
                        i11 = 9;
                        i12 = 7;
                        break;
                    case 2:
                        c7 = 3;
                        jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(descriptor2, 2);
                        i13 |= 4;
                        i14 = 11;
                        i11 = 9;
                        i12 = 7;
                        break;
                    case 3:
                        c7 = 3;
                        objDecodeSerializableElement4 = cVarBeginStructure.decodeSerializableElement(descriptor2, 3, new d(SignaledAd$$serializer.INSTANCE, 0), objDecodeSerializableElement4);
                        i13 |= 8;
                        i14 = 11;
                        i11 = 9;
                        i12 = 7;
                        break;
                    case 4:
                        jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(descriptor2, 4);
                        i13 |= 16;
                        i14 = 11;
                        i11 = 9;
                        i12 = 7;
                        break;
                    case 5:
                        iDecodeIntElement11 = cVarBeginStructure.decodeIntElement(descriptor2, 5);
                        i13 |= 32;
                        i14 = 11;
                        i11 = 9;
                        i12 = 7;
                        break;
                    case 6:
                        objDecodeSerializableElement3 = cVarBeginStructure.decodeSerializableElement(descriptor2, 6, new d(UnclosedAd$$serializer.INSTANCE, 0), objDecodeSerializableElement3);
                        i13 |= 64;
                        i14 = 11;
                        i11 = 9;
                        i12 = 7;
                        break;
                    case 7:
                        iDecodeIntElement14 = cVarBeginStructure.decodeIntElement(descriptor2, i12);
                        i13 |= 128;
                        break;
                    case 8:
                        iDecodeIntElement10 = cVarBeginStructure.decodeIntElement(descriptor2, 8);
                        i13 |= 256;
                        break;
                    case 9:
                        iDecodeIntElement9 = cVarBeginStructure.decodeIntElement(descriptor2, i11);
                        i13 |= 512;
                        break;
                    case 10:
                        iDecodeIntElement12 = cVarBeginStructure.decodeIntElement(descriptor2, 10);
                        i13 |= 1024;
                        break;
                    case 11:
                        iDecodeIntElement13 = cVarBeginStructure.decodeIntElement(descriptor2, i14);
                        i13 |= 2048;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            i2 = iDecodeIntElement8;
            iDecodeIntElement = iDecodeIntElement9;
            objDecodeSerializableElement = objDecodeSerializableElement3;
            objDecodeSerializableElement2 = objDecodeSerializableElement4;
            i8 = iDecodeIntElement14;
            i9 = iDecodeIntElement10;
            i10 = iDecodeIntElement11;
            iDecodeIntElement2 = iDecodeIntElement12;
            iDecodeIntElement3 = iDecodeIntElement13;
            j = jDecodeLongElement3;
            str = strDecodeStringElement2;
            j3 = jDecodeLongElement4;
        }
        int i15 = i13;
        cVarBeginStructure.endStructure(descriptor2);
        return new SessionData(i15, i2, str, j3, (List) objDecodeSerializableElement2, j, i10, (List) objDecodeSerializableElement, i8, i9, iDecodeIntElement, iDecodeIntElement2, iDecodeIntElement3, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, SessionData value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        e7.d dVarBeginStructure = encoder.beginStructure(descriptor2);
        SessionData.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
