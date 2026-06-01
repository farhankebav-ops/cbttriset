package com.vungle.ads.internal.model;

import b7.c;
import b7.m;
import com.ironsource.C2574td;
import com.vungle.ads.internal.model.ConfigPayload;
import d7.g;
import e7.e;
import e7.f;
import f7.c1;
import f7.d;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.m1;
import f7.q0;
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigPayload$$serializer implements e0 {
    public static final ConfigPayload$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        ConfigPayload$$serializer configPayload$$serializer = new ConfigPayload$$serializer();
        INSTANCE = configPayload$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.ConfigPayload", configPayload$$serializer, 19);
        e1Var.j("reuse_assets", true);
        e1Var.j("config", true);
        e1Var.j("endpoints", true);
        e1Var.j("log_metrics", true);
        e1Var.j(C2574td.f10303c, true);
        e1Var.j("user", true);
        e1Var.j(Cookie.CONFIG_EXTENSION, true);
        e1Var.j(Cookie.COPPA_DISABLE_AD_ID, true);
        e1Var.j("ri_enabled", true);
        e1Var.j("session_timeout", true);
        e1Var.j("wait_for_connectivity_for_tpat", true);
        e1Var.j("sdk_session_timeout", true);
        e1Var.j("signals_disabled", true);
        e1Var.j("fpd_enabled", true);
        e1Var.j("rta_debugging", true);
        e1Var.j("config_last_validated_ts", true);
        e1Var.j("auto_redirect", true);
        e1Var.j("retry_prioritized_tpat", true);
        e1Var.j("enable_ot", true);
        descriptor = e1Var;
    }

    private ConfigPayload$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        c cVarY = q.Y(ConfigPayload$CleverCache$$serializer.INSTANCE);
        c cVarY2 = q.Y(ConfigPayload$ConfigSettings$$serializer.INSTANCE);
        c cVarY3 = q.Y(ConfigPayload$Endpoints$$serializer.INSTANCE);
        c cVarY4 = q.Y(ConfigPayload$LogMetricsSettings$$serializer.INSTANCE);
        c cVarY5 = q.Y(new d(Placement$$serializer.INSTANCE, 0));
        c cVarY6 = q.Y(ConfigPayload$UserPrivacy$$serializer.INSTANCE);
        c cVarY7 = q.Y(q1.f11501a);
        f7.g gVar = f7.g.f11455a;
        c cVarY8 = q.Y(gVar);
        c cVarY9 = q.Y(gVar);
        l0 l0Var = l0.f11478a;
        return new c[]{cVarY, cVarY2, cVarY3, cVarY4, cVarY5, cVarY6, cVarY7, cVarY8, cVarY9, q.Y(l0Var), q.Y(gVar), q.Y(l0Var), q.Y(gVar), q.Y(gVar), q.Y(gVar), q.Y(q0.f11499a), q.Y(ConfigPayload$AutoRedirect$$serializer.INSTANCE), q.Y(gVar), q.Y(gVar)};
    }

    @Override // b7.b
    public ConfigPayload deserialize(e decoder) {
        Object objDecodeNullableSerializableElement;
        int i2;
        Object objDecodeNullableSerializableElement2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object objDecodeNullableSerializableElement3;
        Object objDecodeNullableSerializableElement4;
        Object obj5;
        Object objDecodeNullableSerializableElement5;
        Object objDecodeNullableSerializableElement6;
        Object objDecodeNullableSerializableElement7;
        Object obj6;
        Object objDecodeNullableSerializableElement8;
        Object objDecodeNullableSerializableElement9;
        Object objDecodeNullableSerializableElement10;
        Object objDecodeNullableSerializableElement11;
        Object objDecodeNullableSerializableElement12;
        Object objDecodeNullableSerializableElement13;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        k.e(decoder, "decoder");
        g descriptor2 = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor2);
        if (cVarBeginStructure.decodeSequentially()) {
            Object objDecodeNullableSerializableElement14 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, ConfigPayload$CleverCache$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement4 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$ConfigSettings$$serializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement15 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ConfigPayload$Endpoints$$serializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement16 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement17 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, new d(Placement$$serializer.INSTANCE, 0), null);
            objDecodeNullableSerializableElement11 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ConfigPayload$UserPrivacy$$serializer.INSTANCE, null);
            objDecodeNullableSerializableElement3 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, q1.f11501a, null);
            f7.g gVar = f7.g.f11455a;
            objDecodeNullableSerializableElement9 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, gVar, null);
            objDecodeNullableSerializableElement13 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, gVar, null);
            l0 l0Var = l0.f11478a;
            objDecodeNullableSerializableElement8 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, l0Var, null);
            objDecodeNullableSerializableElement12 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, gVar, null);
            Object objDecodeNullableSerializableElement18 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 11, l0Var, null);
            objDecodeNullableSerializableElement10 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 12, gVar, null);
            obj6 = objDecodeNullableSerializableElement18;
            objDecodeNullableSerializableElement7 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 13, gVar, null);
            objDecodeNullableSerializableElement6 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 14, gVar, null);
            objDecodeNullableSerializableElement5 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 15, q0.f11499a, null);
            Object objDecodeNullableSerializableElement19 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 16, ConfigPayload$AutoRedirect$$serializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement20 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 17, gVar, null);
            i2 = 524287;
            objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 18, gVar, null);
            obj3 = objDecodeNullableSerializableElement16;
            obj = objDecodeNullableSerializableElement20;
            obj2 = objDecodeNullableSerializableElement15;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement17;
            obj5 = objDecodeNullableSerializableElement19;
            obj4 = objDecodeNullableSerializableElement14;
        } else {
            boolean z2 = true;
            Object objDecodeNullableSerializableElement21 = null;
            Object objDecodeNullableSerializableElement22 = null;
            objDecodeNullableSerializableElement = null;
            Object objDecodeNullableSerializableElement23 = null;
            Object objDecodeNullableSerializableElement24 = null;
            Object objDecodeNullableSerializableElement25 = null;
            Object objDecodeNullableSerializableElement26 = null;
            Object objDecodeNullableSerializableElement27 = null;
            Object objDecodeNullableSerializableElement28 = null;
            Object objDecodeNullableSerializableElement29 = null;
            Object objDecodeNullableSerializableElement30 = null;
            Object objDecodeNullableSerializableElement31 = null;
            Object objDecodeNullableSerializableElement32 = null;
            Object objDecodeNullableSerializableElement33 = null;
            Object objDecodeNullableSerializableElement34 = null;
            Object objDecodeNullableSerializableElement35 = null;
            Object objDecodeNullableSerializableElement36 = null;
            Object objDecodeNullableSerializableElement37 = null;
            i2 = 0;
            Object objDecodeNullableSerializableElement38 = null;
            while (z2) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        Object obj12 = objDecodeNullableSerializableElement21;
                        z2 = false;
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        objDecodeNullableSerializableElement37 = objDecodeNullableSerializableElement37;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement21 = obj12;
                        break;
                    case 0:
                        Object obj13 = objDecodeNullableSerializableElement21;
                        i2 |= 1;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement38 = objDecodeNullableSerializableElement38;
                        objDecodeNullableSerializableElement21 = obj13;
                        objDecodeNullableSerializableElement37 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 0, ConfigPayload$CleverCache$$serializer.INSTANCE, objDecodeNullableSerializableElement37);
                        break;
                    case 1:
                        obj7 = objDecodeNullableSerializableElement21;
                        i2 |= 2;
                        objDecodeNullableSerializableElement25 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$ConfigSettings$$serializer.INSTANCE, objDecodeNullableSerializableElement25);
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement21 = obj7;
                        break;
                    case 2:
                        obj7 = objDecodeNullableSerializableElement21;
                        obj8 = objDecodeNullableSerializableElement24;
                        obj9 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement38 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ConfigPayload$Endpoints$$serializer.INSTANCE, objDecodeNullableSerializableElement38);
                        i2 |= 4;
                        objDecodeNullableSerializableElement24 = obj8;
                        objDecodeNullableSerializableElement25 = obj9;
                        objDecodeNullableSerializableElement21 = obj7;
                        break;
                    case 3:
                        obj7 = objDecodeNullableSerializableElement21;
                        obj8 = objDecodeNullableSerializableElement24;
                        obj9 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement23 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE, objDecodeNullableSerializableElement23);
                        i2 |= 8;
                        objDecodeNullableSerializableElement24 = obj8;
                        objDecodeNullableSerializableElement25 = obj9;
                        objDecodeNullableSerializableElement21 = obj7;
                        break;
                    case 4:
                        obj8 = objDecodeNullableSerializableElement24;
                        obj9 = objDecodeNullableSerializableElement25;
                        obj7 = objDecodeNullableSerializableElement21;
                        objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 4, new d(Placement$$serializer.INSTANCE, 0), objDecodeNullableSerializableElement);
                        i2 |= 16;
                        objDecodeNullableSerializableElement24 = obj8;
                        objDecodeNullableSerializableElement25 = obj9;
                        objDecodeNullableSerializableElement21 = obj7;
                        break;
                    case 5:
                        obj10 = objDecodeNullableSerializableElement24;
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement30 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ConfigPayload$UserPrivacy$$serializer.INSTANCE, objDecodeNullableSerializableElement30);
                        i2 |= 32;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 6:
                        obj10 = objDecodeNullableSerializableElement24;
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement21 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 6, q1.f11501a, objDecodeNullableSerializableElement21);
                        i2 |= 64;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 7:
                        obj10 = objDecodeNullableSerializableElement24;
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement29 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 7, f7.g.f11455a, objDecodeNullableSerializableElement29);
                        i2 |= 128;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 8:
                        obj10 = objDecodeNullableSerializableElement24;
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement28 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 8, f7.g.f11455a, objDecodeNullableSerializableElement28);
                        i2 |= 256;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 9:
                        obj10 = objDecodeNullableSerializableElement24;
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement27 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 9, l0.f11478a, objDecodeNullableSerializableElement27);
                        i2 |= 512;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 10:
                        obj10 = objDecodeNullableSerializableElement24;
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement22 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 10, f7.g.f11455a, objDecodeNullableSerializableElement22);
                        i2 |= 1024;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 11:
                        obj10 = objDecodeNullableSerializableElement24;
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement26 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 11, l0.f11478a, objDecodeNullableSerializableElement26);
                        i2 |= 2048;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 12:
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement31 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 12, f7.g.f11455a, objDecodeNullableSerializableElement31);
                        i2 |= 4096;
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement32 = objDecodeNullableSerializableElement32;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 13:
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement32 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 13, f7.g.f11455a, objDecodeNullableSerializableElement32);
                        i2 |= 8192;
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement33 = objDecodeNullableSerializableElement33;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 14:
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement33 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 14, f7.g.f11455a, objDecodeNullableSerializableElement33);
                        i2 |= 16384;
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement34 = objDecodeNullableSerializableElement34;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 15:
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement34 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 15, q0.f11499a, objDecodeNullableSerializableElement34);
                        i2 |= 32768;
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement35 = objDecodeNullableSerializableElement35;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 16:
                        obj11 = objDecodeNullableSerializableElement25;
                        objDecodeNullableSerializableElement35 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 16, ConfigPayload$AutoRedirect$$serializer.INSTANCE, objDecodeNullableSerializableElement35);
                        i2 |= 65536;
                        objDecodeNullableSerializableElement24 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement36 = objDecodeNullableSerializableElement36;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 17:
                        obj11 = objDecodeNullableSerializableElement25;
                        obj10 = objDecodeNullableSerializableElement24;
                        objDecodeNullableSerializableElement36 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 17, f7.g.f11455a, objDecodeNullableSerializableElement36);
                        i2 |= 131072;
                        objDecodeNullableSerializableElement24 = obj10;
                        objDecodeNullableSerializableElement25 = obj11;
                        break;
                    case 18:
                        objDecodeNullableSerializableElement24 = cVarBeginStructure.decodeNullableSerializableElement(descriptor2, 18, f7.g.f11455a, objDecodeNullableSerializableElement24);
                        i2 |= 262144;
                        objDecodeNullableSerializableElement25 = objDecodeNullableSerializableElement25;
                        break;
                    default:
                        throw new m(iDecodeElementIndex);
                }
            }
            Object obj14 = objDecodeNullableSerializableElement21;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement24;
            Object obj15 = objDecodeNullableSerializableElement25;
            obj = objDecodeNullableSerializableElement36;
            Object obj16 = objDecodeNullableSerializableElement37;
            obj2 = objDecodeNullableSerializableElement38;
            obj3 = objDecodeNullableSerializableElement23;
            obj4 = obj16;
            objDecodeNullableSerializableElement3 = obj14;
            objDecodeNullableSerializableElement4 = obj15;
            obj5 = objDecodeNullableSerializableElement35;
            objDecodeNullableSerializableElement5 = objDecodeNullableSerializableElement34;
            objDecodeNullableSerializableElement6 = objDecodeNullableSerializableElement33;
            objDecodeNullableSerializableElement7 = objDecodeNullableSerializableElement32;
            obj6 = objDecodeNullableSerializableElement26;
            objDecodeNullableSerializableElement8 = objDecodeNullableSerializableElement27;
            objDecodeNullableSerializableElement9 = objDecodeNullableSerializableElement29;
            objDecodeNullableSerializableElement10 = objDecodeNullableSerializableElement31;
            objDecodeNullableSerializableElement11 = objDecodeNullableSerializableElement30;
            objDecodeNullableSerializableElement12 = objDecodeNullableSerializableElement22;
            objDecodeNullableSerializableElement13 = objDecodeNullableSerializableElement28;
        }
        int i8 = i2;
        cVarBeginStructure.endStructure(descriptor2);
        return new ConfigPayload(i8, (ConfigPayload.CleverCache) obj4, (ConfigPayload.ConfigSettings) objDecodeNullableSerializableElement4, (ConfigPayload.Endpoints) obj2, (ConfigPayload.LogMetricsSettings) obj3, (List) objDecodeNullableSerializableElement, (ConfigPayload.UserPrivacy) objDecodeNullableSerializableElement11, (String) objDecodeNullableSerializableElement3, (Boolean) objDecodeNullableSerializableElement9, (Boolean) objDecodeNullableSerializableElement13, (Integer) objDecodeNullableSerializableElement8, (Boolean) objDecodeNullableSerializableElement12, (Integer) obj6, (Boolean) objDecodeNullableSerializableElement10, (Boolean) objDecodeNullableSerializableElement7, (Boolean) objDecodeNullableSerializableElement6, (Long) objDecodeNullableSerializableElement5, (ConfigPayload.AutoRedirect) obj5, (Boolean) obj, (Boolean) objDecodeNullableSerializableElement2, (m1) null);
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, ConfigPayload value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        e7.d dVarBeginStructure = encoder.beginStructure(descriptor2);
        ConfigPayload.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
