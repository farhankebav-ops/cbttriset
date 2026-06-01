package com.bytedance.sdk.openadsdk.core.EV;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.AdSessionConfiguration;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.CreativeType;
import com.iab.omid.library.bytedance2.adsession.ImpressionType;
import com.iab.omid.library.bytedance2.adsession.Owner;
import com.iab.omid.library.bytedance2.adsession.Partner;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    @NonNull
    public static Bc IlO(@NonNull View view, @NonNull Set<NV> set) {
        AdSession adSessionIlO = IlO(CreativeType.VIDEO, set, Owner.NATIVE);
        return new DmF(adSessionIlO, AdEvents.createAdEvents(adSessionIlO), view, MediaEvents.createMediaEvents(adSessionIlO));
    }

    public static Bc IlO(WebView webView) {
        Partner partnerIlO = Cc.IlO();
        if (partnerIlO != null) {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(partnerIlO, webView, "", ""));
            return new Bc(adSessionCreateAdSession, AdEvents.createAdEvents(adSessionCreateAdSession), webView);
        }
        throw new IllegalArgumentException("Parameter 'partner' may not be null.");
    }

    private static AdSession IlO(CreativeType creativeType, Set<NV> set, Owner owner) {
        List<VerificationScriptResource> listIlO = IlO(set);
        listIlO.isEmpty();
        Partner partnerIlO = Cc.IlO();
        if (partnerIlO == null) {
            return null;
        }
        return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(partnerIlO, Cc.MY(), listIlO, "", ""));
    }

    private static List<VerificationScriptResource> IlO(Set<NV> set) {
        ArrayList arrayList = new ArrayList();
        for (NV nv : set) {
            try {
                if (!TextUtils.isEmpty(nv.IlO()) && !TextUtils.isEmpty(nv.MY())) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(nv.IlO(), nv.EO(), nv.MY()));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(nv.EO()));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
