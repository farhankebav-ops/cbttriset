package com.google.firebase.sessions.settings;

import b7.c;
import b7.m;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.q0;
import f7.u;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public /* synthetic */ class SessionConfigs$$serializer implements e0 {
    public static final SessionConfigs$$serializer INSTANCE;
    private static final g descriptor;

    static {
        SessionConfigs$$serializer sessionConfigs$$serializer = new SessionConfigs$$serializer();
        INSTANCE = sessionConfigs$$serializer;
        e1 e1Var = new e1("com.google.firebase.sessions.settings.SessionConfigs", sessionConfigs$$serializer, 5);
        e1Var.j("sessionsEnabled", false);
        e1Var.j("sessionSamplingRate", false);
        e1Var.j("sessionTimeoutSeconds", false);
        e1Var.j("cacheDurationSeconds", false);
        e1Var.j("cacheUpdatedTimeSeconds", false);
        descriptor = e1Var;
    }

    private SessionConfigs$$serializer() {
    }

    @Override // f7.e0
    public final c[] childSerializers() {
        c cVarY = q.Y(f7.g.f11455a);
        c cVarY2 = q.Y(u.f11523a);
        l0 l0Var = l0.f11478a;
        return new c[]{cVarY, cVarY2, q.Y(l0Var), q.Y(l0Var), q.Y(q0.f11499a)};
    }

    @Override // b7.b
    public final SessionConfigs deserialize(e decoder) {
        int i2;
        Boolean bool;
        Double d8;
        Integer num;
        Integer num2;
        Long l;
        k.e(decoder, "decoder");
        g gVar = descriptor;
        e7.c cVarBeginStructure = decoder.beginStructure(gVar);
        Boolean bool2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            Boolean bool3 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(gVar, 0, f7.g.f11455a, null);
            Double d9 = (Double) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, u.f11523a, null);
            l0 l0Var = l0.f11478a;
            Integer num3 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, l0Var, null);
            bool = bool3;
            num2 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, l0Var, null);
            l = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, q0.f11499a, null);
            num = num3;
            d8 = d9;
            i2 = 31;
        } else {
            boolean z2 = true;
            int i8 = 0;
            Double d10 = null;
            Integer num4 = null;
            Integer num5 = null;
            Long l8 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    bool2 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(gVar, 0, f7.g.f11455a, bool2);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    d10 = (Double) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, u.f11523a, d10);
                    i8 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    num4 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, l0.f11478a, num4);
                    i8 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    num5 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, l0.f11478a, num5);
                    i8 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new m(iDecodeElementIndex);
                    }
                    l8 = (Long) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, q0.f11499a, l8);
                    i8 |= 16;
                }
            }
            i2 = i8;
            bool = bool2;
            d8 = d10;
            num = num4;
            num2 = num5;
            l = l8;
        }
        cVarBeginStructure.endStructure(gVar);
        return new SessionConfigs(i2, bool, d8, num, num2, l, null);
    }

    @Override // b7.j, b7.b
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public final void serialize(f encoder, SessionConfigs value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        SessionConfigs.write$Self$com_google_firebase_firebase_sessions(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
