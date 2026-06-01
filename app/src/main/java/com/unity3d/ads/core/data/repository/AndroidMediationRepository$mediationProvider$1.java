package com.unity3d.ads.core.data.repository;

import e6.a;
import gatewayprotocol.v1.ClientInfoOuterClass;
import kotlin.jvm.internal.l;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidMediationRepository$mediationProvider$1 extends l implements a {
    final /* synthetic */ AndroidMediationRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidMediationRepository$mediationProvider$1(AndroidMediationRepository androidMediationRepository) {
        super(0);
        this.this$0 = androidMediationRepository;
    }

    @Override // e6.a
    public final ClientInfoOuterClass.MediationProvider invoke() {
        String name = this.this$0.getName();
        if (name != null) {
            ClientInfoOuterClass.MediationProvider mediationProvider = t.n0(name, "AppLovinSdk_", false) ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_MAX : name.equalsIgnoreCase("AdMob") ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_ADMOB : name.equalsIgnoreCase("MAX") ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_MAX : name.equalsIgnoreCase("ironSource") ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_LEVELPLAY : ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_CUSTOM;
            if (mediationProvider != null) {
                return mediationProvider;
            }
        }
        return ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_UNSPECIFIED;
    }
}
