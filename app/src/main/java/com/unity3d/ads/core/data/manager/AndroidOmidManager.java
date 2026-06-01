package com.unity3d.ads.core.data.manager;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.unity3d.Omid;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;
import com.iab.omid.library.unity3d.adsession.Partner;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidOmidManager implements OmidManager {
    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public void activate(Context context) {
        k.e(context, "context");
        Omid.activate(context);
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public AdEvents createAdEvents(AdSession adSession) {
        k.e(adSession, "adSession");
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        k.d(adEventsCreateAdEvents, "createAdEvents(adSession)");
        return adEventsCreateAdEvents;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext context) {
        k.e(adSessionConfiguration, "adSessionConfiguration");
        k.e(context, "context");
        AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfiguration, context);
        k.d(adSessionCreateAdSession, "createAdSession(adSessionConfiguration, context)");
        return adSessionCreateAdSession;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public AdSessionConfiguration createAdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner mediaEventsOwner, boolean z2) {
        k.e(creativeType, "creativeType");
        k.e(impressionType, "impressionType");
        k.e(owner, "owner");
        k.e(mediaEventsOwner, "mediaEventsOwner");
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, mediaEventsOwner, z2);
        k.d(adSessionConfigurationCreateAdSessionConfiguration, "createAdSessionConfigura…VerificationScripts\n    )");
        return adSessionConfigurationCreateAdSessionConfiguration;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public AdSessionContext createHtmlAdSessionContext(Partner partner, WebView webView, String str, String str2) {
        AdSessionContext adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(partner, webView, str, str2);
        k.d(adSessionContextCreateHtmlAdSessionContext, "createHtmlAdSessionConte…customReferenceData\n    )");
        return adSessionContextCreateHtmlAdSessionContext;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public AdSessionContext createJavaScriptAdSessionContext(Partner partner, WebView webView, String str, String str2) {
        AdSessionContext adSessionContextCreateJavascriptAdSessionContext = AdSessionContext.createJavascriptAdSessionContext(partner, webView, str, str2);
        k.d(adSessionContextCreateJavascriptAdSessionContext, "createJavascriptAdSessio…customReferenceData\n    )");
        return adSessionContextCreateJavascriptAdSessionContext;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public String getVersion() {
        String version = Omid.getVersion();
        k.d(version, "getVersion()");
        return version;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public boolean isActive() {
        return Omid.isActive();
    }
}
