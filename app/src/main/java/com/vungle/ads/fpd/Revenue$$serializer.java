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
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Revenue$$serializer implements e0 {
    public static final Revenue$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        Revenue$$serializer revenue$$serializer = new Revenue$$serializer();
        INSTANCE = revenue$$serializer;
        e1 e1Var = new e1("com.vungle.ads.fpd.Revenue", revenue$$serializer, 17);
        e1Var.j("total_earnings_usd", true);
        e1Var.j("earnings_by_placement_usd", true);
        e1Var.j("top_n_adomain", true);
        e1Var.j("is_user_a_purchaser", true);
        e1Var.j("is_user_a_subscriber", true);
        e1Var.j("last_7_days_total_spend_usd", true);
        e1Var.j("last_7_days_median_spend_usd", true);
        e1Var.j("last_7_days_mean_spend_usd", true);
        e1Var.j("last_30_days_total_spend_usd", true);
        e1Var.j("last_30_days_median_spend_usd", true);
        e1Var.j("last_30_days_mean_spend_usd", true);
        e1Var.j("last_7_days_user_pltv_usd", true);
        e1Var.j("last_7_days_user_ltv_usd", true);
        e1Var.j("last_30_days_user_pltv_usd", true);
        e1Var.j("last_30_days_user_ltv_usd", true);
        e1Var.j("last_7_days_placement_fill_rate", true);
        e1Var.j("last_30_days_placement_fill_rate", true);
        descriptor = e1Var;
    }

    private Revenue$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        d0 d0Var = d0.f11433a;
        c cVarY = q.Y(d0Var);
        c cVarY2 = q.Y(d0Var);
        c cVarY3 = q.Y(new d(q1.f11501a, 0));
        f7.g gVar = f7.g.f11455a;
        return new c[]{cVarY, cVarY2, cVarY3, q.Y(gVar), q.Y(gVar), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var), q.Y(d0Var)};
    }

    @Override // b7.b
    public Revenue deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        Object obj;
        Object objDecodeNullableSerializableElement4;
        Object obj2;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        Object objDecodeNullableSerializableElement7;
        Object objDecodeNullableSerializableElement8;
        Object objDecodeNullableSerializableElement9;
        Object objDecodeNullableSerializableElement10;
        Object objDecodeNullableSerializableElement11;
        Object obj3;
        int i2;
        Object obj4;
        Object objDecodeNullableSerializableElement12;
        Object objDecodeNullableSerializableElement13;
        Object obj5;
        Object obj6;
        Object objDecodeNullableSerializableElement14;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            d0 d0Var = d0.f11433a;
            Object objDecodeNullableSerializableElement15 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, d0Var, null);
            Object objDecodeNullableSerializableElement16 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, d0Var, null);
            Object objDecodeNullableSerializableElement17 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, new d(q1.f11501a, 0), null);
            f7.g gVar = f7.g.f11455a;
            Object objDecodeNullableSerializableElement18 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, gVar, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, gVar, null);
            objDecodeNullableSerializableElement13 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, d0Var, null);
            objDecodeNullableSerializableElement11 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, d0Var, null);
            objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, d0Var, null);
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, d0Var, null);
            objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, d0Var, null);
            objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, d0Var, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 11, d0Var, null);
            objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 12, d0Var, null);
            objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 13, d0Var, null);
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 14, d0Var, null);
            Object objDecodeNullableSerializableElement19 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 15, d0Var, null);
            objDecodeNullableSerializableElement12 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 16, d0Var, null);
            i2 = 131071;
            obj = objDecodeNullableSerializableElement18;
            obj3 = objDecodeNullableSerializableElement15;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement16;
            obj2 = objDecodeNullableSerializableElement19;
            obj4 = objDecodeNullableSerializableElement17;
        } else {
            boolean z2 = true;
            Object objDecodeNullableSerializableElement20 = null;
            Object objDecodeNullableSerializableElement21 = null;
            Object objDecodeNullableSerializableElement22 = null;
            objDecodeNullableSerializableElement = null;
            Object objDecodeNullableSerializableElement23 = null;
            Object objDecodeNullableSerializableElement24 = null;
            Object objDecodeNullableSerializableElement25 = null;
            objDecodeNullableSerializableElement2 = null;
            Object objDecodeNullableSerializableElement26 = null;
            Object objDecodeNullableSerializableElement27 = null;
            objDecodeNullableSerializableElement3 = null;
            Object objDecodeNullableSerializableElement28 = null;
            Object objDecodeNullableSerializableElement29 = null;
            Object objDecodeNullableSerializableElement30 = null;
            Object objDecodeNullableSerializableElement31 = null;
            Object obj11 = null;
            int i8 = 0;
            Object objDecodeNullableSerializableElement32 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        obj5 = objDecodeNullableSerializableElement32;
                        obj6 = objDecodeNullableSerializableElement22;
                        objDecodeNullableSerializableElement14 = obj11;
                        obj7 = objDecodeNullableSerializableElement20;
                        z2 = false;
                        objDecodeNullableSerializableElement22 = obj6;
                        objDecodeNullableSerializableElement20 = obj7;
                        obj11 = objDecodeNullableSerializableElement14;
                        objDecodeNullableSerializableElement32 = obj5;
                        break;
                    case 0:
                        obj5 = objDecodeNullableSerializableElement32;
                        obj6 = objDecodeNullableSerializableElement22;
                        Object obj12 = obj11;
                        obj7 = objDecodeNullableSerializableElement20;
                        objDecodeNullableSerializableElement14 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, d0.f11433a, obj12);
                        i8 |= 1;
                        objDecodeNullableSerializableElement22 = obj6;
                        objDecodeNullableSerializableElement20 = obj7;
                        obj11 = objDecodeNullableSerializableElement14;
                        objDecodeNullableSerializableElement32 = obj5;
                        break;
                    case 1:
                        obj8 = objDecodeNullableSerializableElement32;
                        objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, d0.f11433a, objDecodeNullableSerializableElement);
                        i8 |= 2;
                        objDecodeNullableSerializableElement22 = objDecodeNullableSerializableElement22;
                        objDecodeNullableSerializableElement32 = obj8;
                        break;
                    case 2:
                        obj8 = objDecodeNullableSerializableElement32;
                        objDecodeNullableSerializableElement23 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, new d(q1.f11501a, 0), objDecodeNullableSerializableElement23);
                        i8 |= 4;
                        objDecodeNullableSerializableElement22 = objDecodeNullableSerializableElement22;
                        objDecodeNullableSerializableElement = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement32 = obj8;
                        break;
                    case 3:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement32 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, f7.g.f11455a, objDecodeNullableSerializableElement32);
                        i8 |= 8;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 4:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement21 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, f7.g.f11455a, objDecodeNullableSerializableElement21);
                        i8 |= 16;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 5:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement20 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, d0.f11433a, objDecodeNullableSerializableElement20);
                        i8 |= 32;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 6:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement26 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, d0.f11433a, objDecodeNullableSerializableElement26);
                        i8 |= 64;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 7:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement27 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, d0.f11433a, objDecodeNullableSerializableElement27);
                        i8 |= 128;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 8:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, d0.f11433a, objDecodeNullableSerializableElement2);
                        i8 |= 256;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 9:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement25 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, d0.f11433a, objDecodeNullableSerializableElement25);
                        i8 |= 512;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 10:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement24 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, d0.f11433a, objDecodeNullableSerializableElement24);
                        i8 |= 1024;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 11:
                        obj9 = objDecodeNullableSerializableElement22;
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 11, d0.f11433a, objDecodeNullableSerializableElement3);
                        i8 |= 2048;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 12:
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement28 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 12, d0.f11433a, objDecodeNullableSerializableElement28);
                        i8 |= 4096;
                        objDecodeNullableSerializableElement22 = objDecodeNullableSerializableElement22;
                        objDecodeNullableSerializableElement29 = objDecodeNullableSerializableElement29;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 13:
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement29 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 13, d0.f11433a, objDecodeNullableSerializableElement29);
                        i8 |= 8192;
                        objDecodeNullableSerializableElement22 = objDecodeNullableSerializableElement22;
                        objDecodeNullableSerializableElement30 = objDecodeNullableSerializableElement30;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 14:
                        obj10 = objDecodeNullableSerializableElement;
                        objDecodeNullableSerializableElement30 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 14, d0.f11433a, objDecodeNullableSerializableElement30);
                        i8 |= 16384;
                        objDecodeNullableSerializableElement22 = objDecodeNullableSerializableElement22;
                        objDecodeNullableSerializableElement31 = objDecodeNullableSerializableElement31;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 15:
                        obj10 = objDecodeNullableSerializableElement;
                        obj9 = objDecodeNullableSerializableElement22;
                        objDecodeNullableSerializableElement31 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 15, d0.f11433a, objDecodeNullableSerializableElement31);
                        i8 |= 32768;
                        objDecodeNullableSerializableElement22 = obj9;
                        objDecodeNullableSerializableElement = obj10;
                        break;
                    case 16:
                        objDecodeNullableSerializableElement22 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 16, d0.f11433a, objDecodeNullableSerializableElement22);
                        i8 |= 65536;
                        objDecodeNullableSerializableElement = objDecodeNullableSerializableElement;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            obj = objDecodeNullableSerializableElement32;
            Object obj13 = objDecodeNullableSerializableElement22;
            Object obj14 = obj11;
            Object obj15 = objDecodeNullableSerializableElement20;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement21;
            obj2 = objDecodeNullableSerializableElement31;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement30;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement29;
            objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement28;
            Object obj16 = objDecodeNullableSerializableElement27;
            objDecodeNullableSerializableElement8 = objDecodeNullableSerializableElement24;
            objDecodeNullableSerializableElement9 = obj16;
            Object obj17 = objDecodeNullableSerializableElement26;
            objDecodeNullableSerializableElement10 = objDecodeNullableSerializableElement25;
            objDecodeNullableSerializableElement11 = obj17;
            obj3 = obj14;
            i2 = i8;
            obj4 = objDecodeNullableSerializableElement23;
            objDecodeNullableSerializableElement12 = obj13;
            objDecodeNullableSerializableElement13 = obj15;
        }
        cVarBeginStructure.endStructure(descriptor2);
        return new Revenue(i2, (Float) obj3, (Float) objDecodeNullableSerializableElement, (List) obj4, (Boolean) obj, (Boolean) objDecodeNullableSerializableElement4, (Float) objDecodeNullableSerializableElement13, (Float) objDecodeNullableSerializableElement11, (Float) objDecodeNullableSerializableElement9, (Float) objDecodeNullableSerializableElement2, (Float) objDecodeNullableSerializableElement10, (Float) objDecodeNullableSerializableElement8, (Float) objDecodeNullableSerializableElement3, (Float) objDecodeNullableSerializableElement7, (Float) objDecodeNullableSerializableElement6, (Float) objDecodeNullableSerializableElement5, (Float) obj2, (Float) objDecodeNullableSerializableElement12, null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, Revenue value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        e7.d dVarBeginStructure = encoder.beginStructure(descriptor2);
        Revenue.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
