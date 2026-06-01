package sg.bigo.ads.core.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.bigosg.Omid;
import com.iab.omid.library.bigosg.ScriptInjector;
import com.iab.omid.library.bigosg.adsession.AdSession;
import com.iab.omid.library.bigosg.adsession.AdSessionConfiguration;
import com.iab.omid.library.bigosg.adsession.AdSessionContext;
import com.iab.omid.library.bigosg.adsession.CreativeType;
import com.iab.omid.library.bigosg.adsession.ImpressionType;
import com.iab.omid.library.bigosg.adsession.Owner;
import com.iab.omid.library.bigosg.adsession.Partner;
import com.iab.omid.library.bigosg.adsession.VerificationScriptResource;
import com.iab.omid.library.bigosg.adsession.media.MediaEvents;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.h.d;
import sg.bigo.ads.common.o;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends d {
    protected String e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f16863a = new c(0);
    }

    private c() {
        this.e = "";
    }

    @Override // sg.bigo.ads.common.h.d
    public final String a() {
        return "OMSDK";
    }

    @Override // sg.bigo.ads.common.h.d
    public final String b() {
        return "omsdk-v1.js";
    }

    @Override // sg.bigo.ads.common.h.d
    public final String c() {
        return "https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js";
    }

    @Override // sg.bigo.ads.common.h.d
    public final String d() {
        return this.e;
    }

    @Override // sg.bigo.ads.common.h.d
    public final String e() {
        return sg.bigo.ads.common.x.a.g();
    }

    public /* synthetic */ c(byte b8) {
        this();
    }

    @Override // sg.bigo.ads.common.h.d
    public final String a(Context context) {
        return o.g(context);
    }

    @Override // sg.bigo.ads.common.h.d
    public final boolean b(String str) {
        return str.contains("omidGlobal");
    }

    public final String c(String str) {
        try {
            return ScriptInjector.injectScriptContentIntoHtml(this.f15784a, str);
        } catch (Exception unused) {
            return str;
        }
    }

    @Nullable
    @MainThread
    public final b a(@NonNull WebView webView, @Nullable View... viewArr) {
        AdSession adSessionCreateAdSession;
        if (!this.f15785b) {
            return null;
        }
        try {
            adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(Partner.createPartner("Bigosg", "5.5.1"), webView, null));
            try {
                adSessionCreateAdSession.registerAdView(webView);
                for (View view : viewArr) {
                    if (view != null) {
                        adSessionCreateAdSession.addFriendlyObstruction(view);
                    }
                }
                adSessionCreateAdSession.start();
                sg.bigo.ads.common.t.a.a(0, 3, "OMSDK", "createHtmlOmsdkEvent success, AdSession Id: " + adSessionCreateAdSession.getAdSessionId());
                return new b(adSessionCreateAdSession, null);
            } catch (Exception e) {
                e = e;
                sg.bigo.ads.common.t.a.b("OMSDK", "createHtmlOmsdkEvent error: " + e.getMessage());
                if (adSessionCreateAdSession != null) {
                    adSessionCreateAdSession.finish();
                }
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            adSessionCreateAdSession = null;
        }
    }

    @Nullable
    @MainThread
    public final b a(List<sg.bigo.ads.core.c.a> list, boolean z2, @NonNull View view, @Nullable View... viewArr) {
        Exception exc;
        AdSession adSession;
        String str;
        if (!this.f15785b) {
            str = "Fail to create native OM AdSession: OMSDK is not ready";
        } else if (list == null) {
            str = "Fail to create native OM AdSession: OM configs is null";
        } else {
            try {
                Partner partnerCreatePartner = Partner.createPartner("Bigosg", "5.5.1");
                ArrayList arrayList = new ArrayList();
                for (sg.bigo.ads.core.c.a aVar : list) {
                    if (!TextUtils.isEmpty(aVar.f16842a)) {
                        arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(aVar.f16843b, new URL(aVar.f16842a), aVar.f16844c));
                        sg.bigo.ads.common.t.a.a(0, 3, "OMSDK", "Create verificationScriptResource: " + aVar.f16843b + " " + aVar.f16842a + " " + aVar.f16844c);
                    }
                }
                if (arrayList.size() == 0) {
                    sg.bigo.ads.common.t.a.b("OMSDK", "Fail to create native OM AdSession: no verification script resources");
                    return null;
                }
                AdSessionContext adSessionContextCreateNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(partnerCreatePartner, this.f15784a, arrayList, "");
                CreativeType creativeType = z2 ? CreativeType.VIDEO : CreativeType.NATIVE_DISPLAY;
                ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
                Owner owner = Owner.NATIVE;
                AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, z2 ? owner : Owner.NONE, false), adSessionContextCreateNativeAdSessionContext);
                try {
                    adSessionCreateAdSession.registerAdView(view);
                    if (viewArr != null) {
                        for (View view2 : viewArr) {
                            if (view2 != null) {
                                adSessionCreateAdSession.addFriendlyObstruction(view2);
                            }
                        }
                    }
                    MediaEvents mediaEventsCreateMediaEvents = z2 ? MediaEvents.createMediaEvents(adSessionCreateAdSession) : null;
                    adSessionCreateAdSession.start();
                    sg.bigo.ads.common.t.a.a(0, 3, "OMSDK", "Create native OM AdSession success, AdSession Id: " + adSessionCreateAdSession.getAdSessionId());
                    return new b(adSessionCreateAdSession, mediaEventsCreateMediaEvents);
                } catch (Exception e) {
                    adSession = adSessionCreateAdSession;
                    exc = e;
                    sg.bigo.ads.common.t.a.b("OMSDK", "Fail to create native OM Session: : " + exc.getMessage());
                    if (adSession != null) {
                        adSession.finish();
                    }
                    return null;
                }
            } catch (Exception e4) {
                exc = e4;
                adSession = null;
            }
        }
        sg.bigo.ads.common.t.a.b("OMSDK", str);
        return null;
    }

    @MainThread
    public final void a(@NonNull final Context context, String str) {
        try {
            Omid.activate(context);
            sg.bigo.ads.common.t.a.a("OMSDK", "OM SDK initialized successfully.");
            this.e = str;
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.c.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = c.this;
                    Context context2 = context;
                    if (!cVar.e(context2)) {
                        cVar.a("https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js", context2);
                        return;
                    }
                    String strD = cVar.d(context2);
                    cVar.f15784a = strD;
                    if (TextUtils.isEmpty(strD)) {
                        cVar.a("https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js", context2);
                        return;
                    }
                    sg.bigo.ads.common.t.a.a("OMSDK", "Fetch omsdk-v1.js from file successfully.");
                    cVar.f15785b = true;
                    cVar.b(context2);
                }
            });
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(1, 5, "OMSDK", "Failed to initialize OM SDK initialize: " + th.getMessage());
        }
    }

    @Override // sg.bigo.ads.common.h.d
    public final void a(String str) {
        sg.bigo.ads.common.x.a.b(str);
    }

    @Override // sg.bigo.ads.common.h.d
    public final boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true;
    }
}
