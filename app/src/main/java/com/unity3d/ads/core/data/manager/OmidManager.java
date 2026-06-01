package com.unity3d.ads.core.data.manager;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;
import com.iab.omid.library.unity3d.adsession.Partner;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface OmidManager {
    void activate(Context context);

    AdEvents createAdEvents(AdSession adSession);

    AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext);

    AdSessionConfiguration createAdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z2);

    AdSessionContext createHtmlAdSessionContext(Partner partner, WebView webView, String str, String str2);

    AdSessionContext createJavaScriptAdSessionContext(Partner partner, WebView webView, String str, String str2);

    String getVersion();

    boolean isActive();
}
