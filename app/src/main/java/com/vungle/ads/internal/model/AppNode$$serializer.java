package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.q1;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AppNode$$serializer implements e0 {
    public static final AppNode$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        AppNode$$serializer appNode$$serializer = new AppNode$$serializer();
        INSTANCE = appNode$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.AppNode", appNode$$serializer, 3);
        e1Var.j("bundle", false);
        e1Var.j("ver", false);
        e1Var.j("id", false);
        descriptor = e1Var;
    }

    private AppNode$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new c[]{q1Var, q1Var, q1Var};
    }

    @Override // b7.b
    public AppNode deserialize(e decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        String str;
        int i2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
            strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 2);
            str = strDecodeStringElement3;
            i2 = 7;
        } else {
            strDecodeStringElement = null;
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
            boolean z2 = true;
            int i8 = 0;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                    i8 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                    i8 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new m(iDecodeElementIndex);
                    }
                    strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(descriptor2, 2);
                    i8 |= 4;
                }
            }
            strDecodeStringElement2 = strDecodeStringElement4;
            str = strDecodeStringElement5;
            i2 = i8;
        }
        String str2 = strDecodeStringElement;
        cVarBeginStructure.endStructure(descriptor2);
        return new AppNode(i2, str2, str, strDecodeStringElement2, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, AppNode value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AppNode.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
