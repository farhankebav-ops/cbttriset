package com.iab.omid.library.unity3d.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.ErrorType;
import com.iab.omid.library.unity3d.adsession.VerificationScriptResource;
import com.iab.omid.library.unity3d.adsession.media.MediaEvents;
import com.iab.omid.library.unity3d.internal.g;
import com.iab.omid.library.unity3d.utils.c;
import com.iab.omid.library.unity3d.utils.f;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.iab.omid.library.unity3d.weakreference.b f6112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdEvents f6113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaEvents f6114d;
    private a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6115f;

    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f6111a = str;
        this.f6112b = new com.iab.omid.library.unity3d.weakreference.b(null);
    }

    public void a() {
        this.f6115f = f.b();
        this.e = a.AD_STATE_IDLE;
    }

    public void b() {
        this.f6112b.clear();
    }

    public AdEvents c() {
        return this.f6113c;
    }

    public MediaEvents d() {
        return this.f6114d;
    }

    public boolean e() {
        return this.f6112b.get() != null;
    }

    public void f() {
        g.a().a(getWebView(), this.f6111a);
    }

    public void g() {
        g.a().b(getWebView(), this.f6111a);
    }

    public WebView getWebView() {
        return this.f6112b.get();
    }

    public void h() {
        a((JSONObject) null);
    }

    public void a(float f4) {
        g.a().a(getWebView(), this.f6111a, f4);
    }

    public void b(String str, long j) {
        if (j >= this.f6115f) {
            this.e = a.AD_STATE_VISIBLE;
            g.a().a(getWebView(), this.f6111a, str);
        }
    }

    public void a(WebView webView) {
        this.f6112b = new com.iab.omid.library.unity3d.weakreference.b(webView);
    }

    public void a(AdEvents adEvents) {
        this.f6113c = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        g.a().a(getWebView(), this.f6111a, adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        g.a().a(getWebView(), this.f6111a, errorType, str);
    }

    public void a(com.iab.omid.library.unity3d.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, null);
    }

    public void a(com.iab.omid.library.unity3d.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        c.a(jSONObject2, "environment", "app");
        c.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        c.a(jSONObject2, "deviceInfo", com.iab.omid.library.unity3d.utils.b.d());
        c.a(jSONObject2, "deviceCategory", com.iab.omid.library.unity3d.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, adSessionContext.getPartner().getName());
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, adSessionContext.getPartner().getVersion());
        c.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.a(jSONObject4, "libraryVersion", "1.4.9-Unity3d");
        c.a(jSONObject4, RemoteConfigConstants.RequestFieldKey.APP_ID, com.iab.omid.library.unity3d.internal.f.b().a().getApplicationContext().getPackageName());
        c.a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            c.a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            c.a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            c.a(jSONObject5, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        g.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.f6114d = mediaEvents;
    }

    public void a(String str) {
        a(str, (JSONObject) null);
    }

    public void a(String str, long j) {
        if (j >= this.f6115f) {
            a aVar = this.e;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.e = aVar2;
                g.a().a(getWebView(), this.f6111a, str);
            }
        }
    }

    public void a(String str, @Nullable JSONObject jSONObject) {
        g.a().a(getWebView(), this.f6111a, str, jSONObject);
    }

    public void a(@NonNull Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        g.a().a(getWebView(), jSONObject);
    }

    public void a(@Nullable JSONObject jSONObject) {
        g.a().b(getWebView(), this.f6111a, jSONObject);
    }

    public void a(boolean z2) {
        if (e()) {
            g.a().b(getWebView(), this.f6111a, z2 ? "foregrounded" : "backgrounded");
        }
    }

    public void i() {
    }
}
