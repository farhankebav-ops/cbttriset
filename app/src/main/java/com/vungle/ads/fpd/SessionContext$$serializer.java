package com.vungle.ads.fpd;

import b7.c;
import b7.m;
import d7.g;
import e7.e;
import e7.f;
import f7.c1;
import f7.d;
import f7.d0;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionContext$$serializer implements e0 {
    public static final SessionContext$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        SessionContext$$serializer sessionContext$$serializer = new SessionContext$$serializer();
        INSTANCE = sessionContext$$serializer;
        e1 e1Var = new e1("com.vungle.ads.fpd.SessionContext", sessionContext$$serializer, 12);
        e1Var.j("level_percentile", true);
        e1Var.j("page", true);
        e1Var.j("time_spent", true);
        e1Var.j("signup_date", true);
        e1Var.j("user_score_percentile", true);
        e1Var.j("user_id", true);
        e1Var.j("friends", true);
        e1Var.j("user_level_percentile", true);
        e1Var.j("health_percentile", true);
        e1Var.j("session_start_time", true);
        e1Var.j("session_duration", true);
        e1Var.j("in_game_purchases_usd", true);
        descriptor = e1Var;
    }

    private SessionContext$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        d0 d0Var = d0.f11433a;
        c cVarY = q.Y(d0Var);
        q1 q1Var = q1.f11501a;
        c cVarY2 = q.Y(q1Var);
        l0 l0Var = l0.f11478a;
        return new c[]{cVarY, cVarY2, q.Y(l0Var), q.Y(l0Var), q.Y(d0Var), q.Y(q1Var), q.Y(new d(q1Var, 0)), q.Y(d0Var), q.Y(d0Var), q.Y(l0Var), q.Y(l0Var), q.Y(d0Var)};
    }

    @Override // b7.b
    public SessionContext deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        Object objDecodeNullableSerializableElement7;
        Object objDecodeNullableSerializableElement8;
        Object objDecodeNullableSerializableElement9;
        Object obj;
        Object objDecodeNullableSerializableElement10;
        Object objDecodeNullableSerializableElement11;
        int i2;
        Object obj2;
        int i8;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        Object objDecodeNullableSerializableElement12 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            d0 d0Var = d0.f11433a;
            Object objDecodeNullableSerializableElement13 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, d0Var, null);
            q1 q1Var = q1.f11501a;
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1Var, null);
            l0 l0Var = l0.f11478a;
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0Var, null);
            objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, l0Var, null);
            Object objDecodeNullableSerializableElement14 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, d0Var, null);
            objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, q1Var, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, new d(q1Var, 0), null);
            objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, d0Var, null);
            objDecodeNullableSerializableElement11 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, d0Var, null);
            objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, l0Var, null);
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, l0Var, null);
            objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 11, d0Var, null);
            i2 = 4095;
            obj = objDecodeNullableSerializableElement13;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement14;
        } else {
            boolean z2 = true;
            int i9 = 0;
            Object objDecodeNullableSerializableElement15 = null;
            Object objDecodeNullableSerializableElement16 = null;
            Object objDecodeNullableSerializableElement17 = null;
            Object objDecodeNullableSerializableElement18 = null;
            Object objDecodeNullableSerializableElement19 = null;
            Object objDecodeNullableSerializableElement20 = null;
            Object objDecodeNullableSerializableElement21 = null;
            Object objDecodeNullableSerializableElement22 = null;
            Object objDecodeNullableSerializableElement23 = null;
            Object objDecodeNullableSerializableElement24 = null;
            objDecodeNullableSerializableElement = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        objDecodeNullableSerializableElement12 = objDecodeNullableSerializableElement12;
                        i9 = i9;
                        break;
                    case 0:
                        objDecodeNullableSerializableElement12 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, d0.f11433a, objDecodeNullableSerializableElement12);
                        i9 |= 1;
                        break;
                    case 1:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement15 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, q1.f11501a, objDecodeNullableSerializableElement15);
                        i8 = i9 | 2;
                        i9 = i8;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 2:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement16 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, l0.f11478a, objDecodeNullableSerializableElement16);
                        i8 = i9 | 4;
                        i9 = i8;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 3:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement17 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, l0.f11478a, objDecodeNullableSerializableElement17);
                        i8 = i9 | 8;
                        i9 = i8;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 4:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, d0.f11433a, objDecodeNullableSerializableElement);
                        i8 = i9 | 16;
                        i9 = i8;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 5:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement24 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, q1.f11501a, objDecodeNullableSerializableElement24);
                        i8 = i9 | 32;
                        i9 = i8;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 6:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement23 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, new d(q1.f11501a, 0), objDecodeNullableSerializableElement23);
                        i8 = i9 | 64;
                        i9 = i8;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 7:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement21 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, d0.f11433a, objDecodeNullableSerializableElement21);
                        i9 |= 128;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 8:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement22 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, d0.f11433a, objDecodeNullableSerializableElement22);
                        i9 |= 256;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 9:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement20 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, l0.f11478a, objDecodeNullableSerializableElement20);
                        i9 |= 512;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 10:
                        obj2 = objDecodeNullableSerializableElement12;
                        objDecodeNullableSerializableElement19 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, l0.f11478a, objDecodeNullableSerializableElement19);
                        i9 |= 1024;
                        objDecodeNullableSerializableElement12 = obj2;
                        break;
                    case 11:
                        objDecodeNullableSerializableElement18 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 11, d0.f11433a, objDecodeNullableSerializableElement18);
                        i9 |= 2048;
                        objDecodeNullableSerializableElement12 = objDecodeNullableSerializableElement12;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            int i10 = i9;
            Object obj3 = objDecodeNullableSerializableElement24;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement15;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement23;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement16;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement19;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement20;
            objDecodeNullableSerializableElement7 = obj3;
            Object obj4 = objDecodeNullableSerializableElement21;
            objDecodeNullableSerializableElement8 = objDecodeNullableSerializableElement17;
            objDecodeNullableSerializableElement9 = obj4;
            obj = objDecodeNullableSerializableElement12;
            objDecodeNullableSerializableElement10 = objDecodeNullableSerializableElement18;
            objDecodeNullableSerializableElement11 = objDecodeNullableSerializableElement22;
            i2 = i10;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new SessionContext(i2, (Float) obj, (String) objDecodeNullableSerializableElement2, (Integer) objDecodeNullableSerializableElement4, (Integer) objDecodeNullableSerializableElement8, (Float) objDecodeNullableSerializableElement, (String) objDecodeNullableSerializableElement7, (List) objDecodeNullableSerializableElement3, (Float) objDecodeNullableSerializableElement9, (Float) objDecodeNullableSerializableElement11, (Integer) objDecodeNullableSerializableElement6, (Integer) objDecodeNullableSerializableElement5, (Float) objDecodeNullableSerializableElement10, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, SessionContext value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        e7.d dVarBeginStructure = encoder.beginStructure(descriptor2);
        SessionContext.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
