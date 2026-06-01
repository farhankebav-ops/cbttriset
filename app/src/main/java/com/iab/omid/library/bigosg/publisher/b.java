package com.iab.omid.library.bigosg.publisher;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.bigosg.adsession.AdSessionContext;
import com.iab.omid.library.bigosg.adsession.VerificationScriptResource;
import com.iab.omid.library.bigosg.b.e;
import com.iab.omid.library.bigosg.d.d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f5811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f5812b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, VerificationScriptResource> f5813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5814d;

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.f5813c = map;
        this.f5814d = str;
    }

    @Override // com.iab.omid.library.bigosg.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new Runnable() { // from class: com.iab.omid.library.bigosg.publisher.b.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private WebView f5816b;

            {
                this.f5816b = b.this.f5811a;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5816b.destroy();
            }
        }, Math.max(4000 - (this.f5812b == null ? 4000L : TimeUnit.MILLISECONDS.convert(d.a() - this.f5812b.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f5811a = null;
    }

    public void j() {
        WebView webView = new WebView(com.iab.omid.library.bigosg.b.d.a().b());
        this.f5811a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f5811a);
        e.a().a(this.f5811a, this.f5814d);
        for (String str : this.f5813c.keySet()) {
            e.a().a(this.f5811a, this.f5813c.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f5812b = Long.valueOf(d.a());
    }

    @Override // com.iab.omid.library.bigosg.publisher.AdSessionStatePublisher
    public void a() {
        super.a();
        j();
    }

    @Override // com.iab.omid.library.bigosg.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.bigosg.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            com.iab.omid.library.bigosg.d.b.a(jSONObject, str, injectedResourcesMap.get(str));
        }
        a(aVar, adSessionContext, jSONObject);
    }
}
