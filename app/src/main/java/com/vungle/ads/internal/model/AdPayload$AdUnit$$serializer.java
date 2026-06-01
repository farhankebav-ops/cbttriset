package com.vungle.ads.internal.model;

import b7.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import d7.g;
import e7.f;
import f7.c1;
import f7.d;
import f7.e0;
import f7.e1;
import f7.l0;
import f7.q1;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdPayload$AdUnit$$serializer implements e0 {
    public static final AdPayload$AdUnit$$serializer INSTANCE;
    public static final /* synthetic */ g descriptor;

    static {
        AdPayload$AdUnit$$serializer adPayload$AdUnit$$serializer = new AdPayload$AdUnit$$serializer();
        INSTANCE = adPayload$AdUnit$$serializer;
        e1 e1Var = new e1("com.vungle.ads.internal.model.AdPayload.AdUnit", adPayload$AdUnit$$serializer, 29);
        e1Var.j("id", true);
        e1Var.j("ad_type", true);
        e1Var.j(FirebaseAnalytics.Param.AD_SOURCE, true);
        e1Var.j("expiry", true);
        e1Var.j("deeplink_url", true);
        e1Var.j("click_coordinates_enabled", true);
        e1Var.j("ad_load_optimization", true);
        e1Var.j("template_heartbeat_check", true);
        e1Var.j("mediation_name", true);
        e1Var.j("info", true);
        e1Var.j("sleep", true);
        e1Var.j("error_code", true);
        e1Var.j("tpat", true);
        e1Var.j("vm_url", true);
        e1Var.j("vm_version", true);
        e1Var.j("ad_market_id", true);
        e1Var.j(OneSignalDbContract.NotificationTable.TABLE_NAME, true);
        e1Var.j(Constants.LOAD_AD, true);
        e1Var.j("viewability", true);
        e1Var.j("template_type", true);
        e1Var.j("template_settings", true);
        e1Var.j("creative_id", true);
        e1Var.j("app_id", true);
        e1Var.j("show_close", true);
        e1Var.j("show_close_incentivized", true);
        e1Var.j("ad_size", true);
        e1Var.j("webview_settings", true);
        e1Var.j("use_preloading", true);
        e1Var.j("ad_partial_download_enabled", true);
        descriptor = e1Var;
    }

    private AdPayload$AdUnit$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        q1 q1Var = q1.f11501a;
        c cVarY = q.Y(q1Var);
        c cVarY2 = q.Y(q1Var);
        c cVarY3 = q.Y(q1Var);
        l0 l0Var = l0.f11478a;
        c cVarY4 = q.Y(l0Var);
        c cVarY5 = q.Y(q1Var);
        f7.g gVar = f7.g.f11455a;
        return new c[]{cVarY, cVarY2, cVarY3, cVarY4, cVarY5, q.Y(gVar), q.Y(gVar), q.Y(gVar), q.Y(q1Var), q.Y(q1Var), q.Y(l0Var), q.Y(l0Var), q.Y(AdPayload.TpatSerializer.INSTANCE), q.Y(q1Var), q.Y(q1Var), q.Y(q1Var), q.Y(new d(q1Var, 0)), q.Y(new d(q1Var, 0)), q.Y(AdPayload$ViewAbility$$serializer.INSTANCE), q.Y(q1Var), q.Y(AdPayload$TemplateSettings$$serializer.INSTANCE), q.Y(q1Var), q.Y(q1Var), q.Y(l0Var), q.Y(l0Var), q.Y(AdPayload$AdSizeInfo$$serializer.INSTANCE), q.Y(AdPayload$WebViewSettings$$serializer.INSTANCE), q.Y(gVar), q.Y(gVar)};
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // b7.b
    public com.vungle.ads.internal.model.AdPayload.AdUnit deserialize(e7.e r89) {
        /*
            Method dump skipped, instruction units count: 2238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload$AdUnit$$serializer.deserialize(e7.e):com.vungle.ads.internal.model.AdPayload$AdUnit");
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, AdPayload.AdUnit value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        g descriptor2 = getDescriptor();
        e7.d dVarBeginStructure = encoder.beginStructure(descriptor2);
        AdPayload.AdUnit.write$Self(value, dVarBeginStructure, descriptor2);
        dVarBeginStructure.endStructure(descriptor2);
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
