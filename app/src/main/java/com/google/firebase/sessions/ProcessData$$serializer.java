package com.google.firebase.sessions;

import b7.m;
import d7.g;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.q1;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public /* synthetic */ class ProcessData$$serializer implements e0 {
    public static final ProcessData$$serializer INSTANCE;
    private static final g descriptor;

    static {
        ProcessData$$serializer processData$$serializer = new ProcessData$$serializer();
        INSTANCE = processData$$serializer;
        e1 e1Var = new e1("com.google.firebase.sessions.ProcessData", processData$$serializer, 2);
        e1Var.j("pid", false);
        e1Var.j("uuid", false);
        descriptor = e1Var;
    }

    private ProcessData$$serializer() {
    }

    @Override // f7.e0
    public final b7.c[] childSerializers() {
        return new b7.c[]{l0.f11478a, q1.f11501a};
    }

    @Override // b7.b
    public final ProcessData deserialize(e7.e decoder) {
        int iDecodeIntElement;
        String strDecodeStringElement;
        int i2;
        k.e(decoder, "decoder");
        g gVar = descriptor;
        e7.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 0);
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 1);
            i2 = 3;
        } else {
            boolean z2 = true;
            iDecodeIntElement = 0;
            int i8 = 0;
            String strDecodeStringElement2 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 0);
                    i8 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new m(iDecodeElementIndex);
                    }
                    strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 1);
                    i8 |= 2;
                }
            }
            strDecodeStringElement = strDecodeStringElement2;
            i2 = i8;
        }
        cVarBeginStructure.endStructure(gVar);
        return new ProcessData(i2, iDecodeIntElement, strDecodeStringElement, null);
    }

    @Override // b7.j, b7.b
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public final void serialize(f encoder, ProcessData value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g gVar = descriptor;
        e7.d dVarBeginStructure = encoder.beginStructure(gVar);
        ProcessData.write$Self$com_google_firebase_firebase_sessions(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // f7.e0
    public b7.c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
