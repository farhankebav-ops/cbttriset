package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import d7.g;
import e7.d;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.e1;
import f7.m1;
import f7.q1;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnclosedAd$$serializer implements e0 {
    public static final UnclosedAd$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        UnclosedAd$$serializer unclosedAd$$serializer = new UnclosedAd$$serializer();
        INSTANCE = unclosedAd$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.UnclosedAd", unclosedAd$$serializer, 2);
        e1Var.j("107", false);
        e1Var.j(StatisticData.ERROR_CODE_IO_ERROR, true);
        descriptor = e1Var;
    }

    private UnclosedAd$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        return new c[]{q1Var, q1Var};
    }

    @Override // b7.b
    public UnclosedAd deserialize(e decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        int i2;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
            strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
            i2 = 3;
        } else {
            boolean z2 = true;
            int i8 = 0;
            strDecodeStringElement = null;
            String strDecodeStringElement3 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(descriptor2, 0);
                    i8 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new m(iDecodeElementIndex);
                    }
                    strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(descriptor2, 1);
                    i8 |= 2;
                }
            }
            strDecodeStringElement2 = strDecodeStringElement3;
            i2 = i8;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new UnclosedAd(i2, strDecodeStringElement, strDecodeStringElement2, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, UnclosedAd value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        d dVarBeginStructure = encoder.beginStructure(descriptor2);
        UnclosedAd.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
