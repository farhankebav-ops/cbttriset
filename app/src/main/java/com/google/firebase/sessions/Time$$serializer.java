package com.google.firebase.sessions;

import b7.m;
import d7.g;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.q0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public /* synthetic */ class Time$$serializer implements e0 {
    public static final Time$$serializer INSTANCE;
    private static final g descriptor;

    static {
        Time$$serializer time$$serializer = new Time$$serializer();
        INSTANCE = time$$serializer;
        e1 e1Var = new e1("com.google.firebase.sessions.Time", time$$serializer, 3);
        e1Var.j("ms", false);
        e1Var.j("us", true);
        e1Var.j("seconds", true);
        descriptor = e1Var;
    }

    private Time$$serializer() {
    }

    @Override // f7.e0
    public final b7.c[] childSerializers() {
        q0 q0Var = q0.f11499a;
        return new b7.c[]{q0Var, q0Var, q0Var};
    }

    @Override // b7.b
    public final Time deserialize(e7.e decoder) {
        int i2;
        long jDecodeLongElement;
        long j;
        long j3;
        k.e(decoder, "decoder");
        g gVar = descriptor;
        e7.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 0);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 1);
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 2);
            i2 = 7;
            j = jDecodeLongElement2;
            j3 = jDecodeLongElement3;
        } else {
            long jDecodeLongElement4 = 0;
            boolean z2 = true;
            int i8 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, 0);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 1);
                    i8 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new m(iDecodeElementIndex);
                    }
                    jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 2);
                    i8 |= 4;
                }
            }
            i2 = i8;
            jDecodeLongElement = jDecodeLongElement4;
            j = jDecodeLongElement5;
            j3 = jDecodeLongElement6;
        }
        cVarBeginStructure.endStructure(gVar);
        return new Time(i2, j, j3, jDecodeLongElement, null);
    }

    @Override // b7.j, b7.b
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public final void serialize(f encoder, Time value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g gVar = descriptor;
        e7.d dVarBeginStructure = encoder.beginStructure(gVar);
        Time.write$Self$com_google_firebase_firebase_sessions(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // f7.e0
    public b7.c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
