package com.google.firebase.sessions;

import b7.m;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import d7.g;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.q0;
import f7.q1;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public /* synthetic */ class SessionDetails$$serializer implements e0 {
    public static final SessionDetails$$serializer INSTANCE;
    private static final g descriptor;

    static {
        SessionDetails$$serializer sessionDetails$$serializer = new SessionDetails$$serializer();
        INSTANCE = sessionDetails$$serializer;
        e1 e1Var = new e1("com.google.firebase.sessions.SessionDetails", sessionDetails$$serializer, 4);
        e1Var.j(JsonStorageKeyNames.SESSION_ID_KEY, false);
        e1Var.j("firstSessionId", false);
        e1Var.j("sessionIndex", false);
        e1Var.j("sessionStartTimestampUs", false);
        descriptor = e1Var;
    }

    private SessionDetails$$serializer() {
    }

    @Override // f7.e0
    public final b7.c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new b7.c[]{q1Var, q1Var, l0.f11478a, q0.f11499a};
    }

    @Override // b7.b
    public final SessionDetails deserialize(e7.e decoder) {
        String strDecodeStringElement;
        int i2;
        int iDecodeIntElement;
        String str;
        long jDecodeLongElement;
        k.e(decoder, "decoder");
        g gVar = descriptor;
        e7.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 0);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 1);
            i2 = 15;
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 2);
            str = strDecodeStringElement2;
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 3);
        } else {
            strDecodeStringElement = null;
            String strDecodeStringElement3 = null;
            boolean z2 = true;
            long jDecodeLongElement2 = 0;
            int i8 = 0;
            int iDecodeIntElement2 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 0);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 1);
                    i8 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(gVar, 2);
                    i8 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new m(iDecodeElementIndex);
                    }
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 3);
                    i8 |= 8;
                }
            }
            i2 = i8;
            iDecodeIntElement = iDecodeIntElement2;
            str = strDecodeStringElement3;
            jDecodeLongElement = jDecodeLongElement2;
        }
        String str2 = strDecodeStringElement;
        cVarBeginStructure.endStructure(gVar);
        return new SessionDetails(i2, str2, str, iDecodeIntElement, jDecodeLongElement, null);
    }

    @Override // b7.j, b7.b
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public final void serialize(f encoder, SessionDetails value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g gVar = descriptor;
        e7.d dVarBeginStructure = encoder.beginStructure(gVar);
        SessionDetails.write$Self$com_google_firebase_firebase_sessions(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // f7.e0
    public b7.c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
