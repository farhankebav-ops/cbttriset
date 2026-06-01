package com.vungle.ads.internal.omsdk;

import android.util.Base64;
import android.view.View;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdEvents;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.internal.model.OmSdkData;
import com.vungle.ads.internal.util.Logger;
import g7.c;
import g7.q;
import java.net.URL;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeOMTracker {
    private AdEvents adEvents;
    private AdSession adSession;
    private final c json;

    public NativeOMTracker(String omSdkData, String omSdkJS) {
        k.e(omSdkData, "omSdkData");
        k.e(omSdkJS, "omSdkJS");
        q qVarB = a.a.b(NativeOMTracker$json$1.INSTANCE);
        this.json = qVarB;
        try {
            AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
            Partner partnerCreatePartner = Partner.createPartner(BuildConfig.OMSDK_PARTNER_NAME, BuildConfig.VERSION_NAME);
            byte[] bArrDecode = Base64.decode(omSdkData, 0);
            OmSdkData omSdkData2 = bArrDecode != null ? (OmSdkData) qVarB.a(r2.q.q0(qVarB.f11599b, b0.b(OmSdkData.class)), new String(bArrDecode, n6.a.f13073a)) : null;
            VerificationScriptResource verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(omSdkData2 != null ? omSdkData2.getVendorKey() : null, new URL(omSdkData2 != null ? omSdkData2.getVendorURL() : null), omSdkData2 != null ? omSdkData2.getParams() : null);
            k.d(verificationScriptResource, "verificationScriptResource");
            this.adSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, AdSessionContext.createNativeAdSessionContext(partnerCreatePartner, omSdkJS, r2.q.j0(verificationScriptResource), null, null));
        } catch (Exception e) {
            Logger.Companion.e("NativeOMTracker", "error occured when create omsdk adSession:", e);
        }
    }

    public final void impressionOccurred() {
        AdEvents adEvents = this.adEvents;
        if (adEvents != null) {
            adEvents.impressionOccurred();
        }
    }

    public final void start(View view) {
        AdSession adSession;
        k.e(view, "view");
        if (!Omid.isActive() || (adSession = this.adSession) == null) {
            return;
        }
        adSession.registerAdView(view);
        adSession.start();
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        this.adEvents = adEventsCreateAdEvents;
        if (adEventsCreateAdEvents != null) {
            adEventsCreateAdEvents.loaded();
        }
    }

    public final void stop() {
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.finish();
        }
        this.adSession = null;
    }
}
