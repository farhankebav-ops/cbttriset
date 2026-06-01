package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.iab.omid.library.ironsrc.Omid;
import com.iab.omid.library.ironsrc.adsession.AdEvents;
import com.iab.omid.library.ironsrc.adsession.AdSession;
import com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.CreativeType;
import com.iab.omid.library.ironsrc.adsession.ImpressionType;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.Partner;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Hc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6925d = "Ironsrc";
    public static final String e = "7";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6926f = Omid.getVersion();
    public static final String g = "omidVersion";
    public static final String h = "omidPartnerName";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f6927i = "omidPartnerVersion";
    public static final String j = "omidActiveAdSessions";
    private static final String k = "Invalid OMID impressionOwner";
    private static final String l = "Invalid OMID videoEventsOwner";
    private static final String m = "Missing OMID impressionOwner";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f6928n = "Missing OMID videoEventsOwner";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f6929o = "OMID has not been activated";
    private static final String p = "Missing OMID creativeType";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f6930q = "Missing adview id in OMID params";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f6931r = "No adview found with the provided adViewId";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f6932s = "OMID Session has already started";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f6933t = "OMID Session has not started";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Partner f6934a = Partner.createPartner(f6925d, e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6936c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, AdSession> f6935b = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f6937i = "isolateVerificationScripts";
        private static final String j = "impressionOwner";
        private static final String k = "videoEventsOwner";
        private static final String l = "customReferenceData";
        private static final String m = "creativeType";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f6938n = "impressionType";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f6939o = "adViewId";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Owner f6941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Owner f6942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6943d;
        public ImpressionType e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CreativeType f6944f;
        public String g;
        public Owner h;

        public static a a(JSONObject jSONObject) throws IllegalArgumentException {
            a aVar = new a();
            aVar.f6940a = jSONObject.optBoolean("isolateVerificationScripts", false);
            String strOptString = jSONObject.optString("impressionOwner", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(Hc.m);
            }
            try {
                aVar.f6941b = Owner.valueOf(strOptString.toUpperCase(Locale.getDefault()));
                String strOptString2 = jSONObject.optString("videoEventsOwner", "");
                if (TextUtils.isEmpty(strOptString)) {
                    throw new IllegalArgumentException(Hc.f6928n);
                }
                try {
                    aVar.f6942c = Owner.valueOf(strOptString2.toUpperCase(Locale.getDefault()));
                    aVar.f6943d = jSONObject.optString("customReferenceData", "");
                    aVar.f6944f = b(jSONObject);
                    aVar.e = c(jSONObject);
                    aVar.g = e(jSONObject);
                    aVar.h = d(jSONObject);
                    return aVar;
                } catch (IllegalArgumentException e) {
                    C2531r4.d().a(e);
                    throw new IllegalArgumentException(a1.a.l("Invalid OMID videoEventsOwner ", strOptString2));
                }
            } catch (IllegalArgumentException e4) {
                C2531r4.d().a(e4);
                throw new IllegalArgumentException(a1.a.l("Invalid OMID impressionOwner ", strOptString));
            }
        }

        private static CreativeType b(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("creativeType", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(a1.a.l(Hc.p, strOptString));
            }
            for (CreativeType creativeType : CreativeType.values()) {
                if (strOptString.equalsIgnoreCase(creativeType.toString())) {
                    return creativeType;
                }
            }
            throw new IllegalArgumentException(a1.a.l(Hc.p, strOptString));
        }

        private static ImpressionType c(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("impressionType", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(a1.a.l(Hc.p, strOptString));
            }
            for (ImpressionType impressionType : ImpressionType.values()) {
                if (strOptString.equalsIgnoreCase(impressionType.toString())) {
                    return impressionType;
                }
            }
            throw new IllegalArgumentException(a1.a.l(Hc.p, strOptString));
        }

        private static Owner d(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("videoEventsOwner", "");
            Owner owner = Owner.NONE;
            try {
                return Owner.valueOf(strOptString.toUpperCase(Locale.getDefault()));
            } catch (IllegalArgumentException e) {
                C2531r4.d().a(e);
                return owner;
            }
        }

        private static String e(JSONObject jSONObject) throws IllegalArgumentException {
            String strOptString = jSONObject.optString("adViewId", "");
            if (TextUtils.isEmpty(strOptString)) {
                throw new IllegalArgumentException(a1.a.l(Hc.f6930q, strOptString));
            }
            return strOptString;
        }
    }

    public void a(Context context) throws IllegalArgumentException {
        if (this.f6936c) {
            return;
        }
        Omid.activate(context);
        this.f6936c = true;
    }

    public void b(JSONObject jSONObject) throws IllegalStateException {
        a(jSONObject);
        String strOptString = jSONObject.optString("adViewId");
        AdSession adSession = this.f6935b.get(strOptString);
        if (adSession == null) {
            throw new IllegalStateException(f6933t);
        }
        adSession.finish();
        this.f6935b.remove(strOptString);
    }

    public void c(JSONObject jSONObject) throws IllegalStateException, IllegalArgumentException {
        a(jSONObject);
        AdSession adSession = this.f6935b.get(jSONObject.optString("adViewId"));
        if (adSession == null) {
            throw new IllegalStateException(f6933t);
        }
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        if (jSONObject.optBoolean("signalLoaded")) {
            adEventsCreateAdEvents.loaded();
        }
        adEventsCreateAdEvents.impressionOccurred();
    }

    public void d(JSONObject jSONObject) throws IllegalStateException, IllegalArgumentException {
        a(a.a(jSONObject));
    }

    public C2346ge a() {
        C2346ge c2346ge = new C2346ge();
        c2346ge.b(g, SDKUtils.encodeString(f6926f));
        c2346ge.b(h, SDKUtils.encodeString(f6925d));
        c2346ge.b(f6927i, SDKUtils.encodeString(e));
        c2346ge.b(j, SDKUtils.encodeString(Arrays.toString(this.f6935b.keySet().toArray())));
        return c2346ge;
    }

    public void a(a aVar) throws IllegalStateException, IllegalArgumentException {
        if (this.f6936c) {
            if (!TextUtils.isEmpty(aVar.g)) {
                String str = aVar.g;
                if (!this.f6935b.containsKey(str)) {
                    K8 k8A = C2519q8.a().a(str);
                    if (k8A != null) {
                        AdSession adSessionA = a(aVar, k8A);
                        adSessionA.start();
                        this.f6935b.put(str, adSessionA);
                        return;
                    }
                    throw new IllegalStateException(f6931r);
                }
                throw new IllegalStateException(f6932s);
            }
            throw new IllegalStateException(f6930q);
        }
        throw new IllegalStateException(f6929o);
    }

    private AdSession a(a aVar, K8 k8) throws IllegalArgumentException {
        AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(aVar.f6944f, aVar.e, aVar.f6941b, aVar.f6942c, aVar.f6940a), AdSessionContext.createHtmlAdSessionContext(this.f6934a, k8.getPresentingView(), null, aVar.f6943d));
        adSessionCreateAdSession.registerAdView(k8.getPresentingView());
        return adSessionCreateAdSession;
    }

    private void a(JSONObject jSONObject) throws IllegalStateException {
        if (!this.f6936c) {
            throw new IllegalStateException(f6929o);
        }
        if (jSONObject == null) {
            throw new IllegalStateException(f6933t);
        }
    }
}
