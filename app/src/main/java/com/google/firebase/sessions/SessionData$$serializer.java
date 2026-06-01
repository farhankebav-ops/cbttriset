package com.google.firebase.sessions;

import b7.m;
import d7.g;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.m1;
import java.util.Map;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public /* synthetic */ class SessionData$$serializer implements e0 {
    public static final SessionData$$serializer INSTANCE;
    private static final g descriptor;

    static {
        SessionData$$serializer sessionData$$serializer = new SessionData$$serializer();
        INSTANCE = sessionData$$serializer;
        e1 e1Var = new e1("com.google.firebase.sessions.SessionData", sessionData$$serializer, 3);
        e1Var.j("sessionDetails", false);
        e1Var.j("backgroundTime", true);
        e1Var.j("processDataMap", true);
        descriptor = e1Var;
    }

    private SessionData$$serializer() {
    }

    @Override // f7.e0
    public final b7.c[] childSerializers() {
        return new b7.c[]{SessionDetails$$serializer.INSTANCE, q.Y(Time$$serializer.INSTANCE), q.Y(SessionData.$childSerializers[2])};
    }

    @Override // b7.b
    public final SessionData deserialize(e7.e decoder) {
        int i2;
        SessionDetails sessionDetails;
        Time time;
        Map map;
        k.e(decoder, "decoder");
        g gVar = descriptor;
        e7.c cVarBeginStructure = decoder.beginStructure(gVar);
        b7.c[] cVarArr = SessionData.$childSerializers;
        SessionDetails sessionDetails2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            SessionDetails sessionDetails3 = (SessionDetails) cVarBeginStructure.decodeSerializableElement(gVar, 0, SessionDetails$$serializer.INSTANCE, null);
            Time time2 = (Time) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, Time$$serializer.INSTANCE, null);
            map = (Map) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, cVarArr[2], null);
            sessionDetails = sessionDetails3;
            i2 = 7;
            time = time2;
        } else {
            boolean z2 = true;
            int i8 = 0;
            Time time3 = null;
            Map map2 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    sessionDetails2 = (SessionDetails) cVarBeginStructure.decodeSerializableElement(gVar, 0, SessionDetails$$serializer.INSTANCE, sessionDetails2);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    time3 = (Time) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, Time$$serializer.INSTANCE, time3);
                    i8 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new m(iDecodeElementIndex);
                    }
                    map2 = (Map) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, cVarArr[2], map2);
                    i8 |= 4;
                }
            }
            i2 = i8;
            sessionDetails = sessionDetails2;
            time = time3;
            map = map2;
        }
        cVarBeginStructure.endStructure(gVar);
        return new SessionData(i2, sessionDetails, time, map, (m1) null);
    }

    @Override // b7.j, b7.b
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public final void serialize(f encoder, SessionData value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g gVar = descriptor;
        e7.d dVarBeginStructure = encoder.beginStructure(gVar);
        SessionData.write$Self$com_google_firebase_firebase_sessions(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // f7.e0
    public b7.c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
