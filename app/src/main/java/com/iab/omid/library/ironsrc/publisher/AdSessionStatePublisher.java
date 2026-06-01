package com.iab.omid.library.ironsrc.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iab.omid.library.ironsrc.adsession.AdEvents;
import com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.ErrorType;
import com.iab.omid.library.ironsrc.adsession.VerificationScriptResource;
import com.iab.omid.library.ironsrc.adsession.media.MediaEvents;
import com.iab.omid.library.ironsrc.internal.g;
import com.iab.omid.library.ironsrc.internal.h;
import com.iab.omid.library.ironsrc.utils.c;
import com.iab.omid.library.ironsrc.utils.f;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.weakreference.b f6010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdEvents f6011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaEvents f6012d;
    private a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6013f;

    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f6009a = str;
        this.f6010b = new com.iab.omid.library.ironsrc.weakreference.b(null);
    }

    public void a() {
        this.f6013f = f.b();
        this.e = a.AD_STATE_IDLE;
    }

    public void b() {
        this.f6010b.clear();
    }

    public AdEvents c() {
        return this.f6011c;
    }

    public MediaEvents d() {
        return this.f6012d;
    }

    public boolean e() {
        return this.f6010b.get() != null;
    }

    public void f() {
        h.a().a(getWebView(), this.f6009a);
    }

    public void g() {
        h.a().b(getWebView(), this.f6009a);
    }

    public WebView getWebView() {
        return this.f6010b.get();
    }

    public void h() {
        a((JSONObject) null);
    }

    public void a(float f4) {
        h.a().a(getWebView(), this.f6009a, f4);
    }

    public void b(String str, long j) {
        if (j >= this.f6013f) {
            this.e = a.AD_STATE_VISIBLE;
            h.a().b(getWebView(), this.f6009a, str);
        }
    }

    public void a(WebView webView) {
        this.f6010b = new com.iab.omid.library.ironsrc.weakreference.b(webView);
    }

    public void b(boolean z2) {
        if (e()) {
            h.a().a(getWebView(), this.f6009a, z2 ? "locked" : "unlocked");
        }
    }

    public void a(AdEvents adEvents) {
        this.f6011c = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        h.a().a(getWebView(), this.f6009a, adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        h.a().a(getWebView(), this.f6009a, errorType, str);
    }

    public void a(com.iab.omid.library.ironsrc.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, null);
    }

    public void a(com.iab.omid.library.ironsrc.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        c.a(jSONObject2, "environment", "app");
        c.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        c.a(jSONObject2, "deviceInfo", com.iab.omid.library.ironsrc.utils.b.d());
        c.a(jSONObject2, "deviceCategory", com.iab.omid.library.ironsrc.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, adSessionContext.getPartner().getName());
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, adSessionContext.getPartner().getVersion());
        c.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.a(jSONObject4, "libraryVersion", "1.5.2-Ironsrc");
        c.a(jSONObject4, RemoteConfigConstants.RequestFieldKey.APP_ID, g.b().a().getApplicationContext().getPackageName());
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
        h.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.f6012d = mediaEvents;
    }

    public void a(String str) {
        a(str, (JSONObject) null);
    }

    public void a(String str, long j) {
        if (j >= this.f6013f) {
            a aVar = this.e;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.e = aVar2;
                h.a().b(getWebView(), this.f6009a, str);
            }
        }
    }

    public void a(String str, @Nullable JSONObject jSONObject) {
        h.a().a(getWebView(), this.f6009a, str, jSONObject);
    }

    public void a(@NonNull Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        h.a().a(getWebView(), jSONObject);
    }

    public void a(@Nullable JSONObject jSONObject) {
        h.a().b(getWebView(), this.f6009a, jSONObject);
    }

    public void a(boolean z2) {
        if (e()) {
            h.a().c(getWebView(), this.f6009a, z2 ? "foregrounded" : "backgrounded");
        }
    }

    public void i() {
    }
}
