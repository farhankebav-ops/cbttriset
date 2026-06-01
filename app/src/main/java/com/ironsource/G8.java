package com.ironsource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import com.ironsource.C2300e4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class G8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6829d;
    private final Drawable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WebView f6830f;
    private final View g;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f6833a;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f6834a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f6835b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f6836c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final String f6837d;
            private final q5.k e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final q5.k f6838f;
            private final View g;

            public a(String str, String str2, String str3, String str4, q5.k kVar, q5.k kVar2, View privacyIcon) {
                kotlin.jvm.internal.k.e(privacyIcon, "privacyIcon");
                this.f6834a = str;
                this.f6835b = str2;
                this.f6836c = str3;
                this.f6837d = str4;
                this.e = kVar;
                this.f6838f = kVar2;
                this.g = privacyIcon;
            }

            public final String a() {
                return this.f6834a;
            }

            public final String b() {
                return this.f6835b;
            }

            public final String c() {
                return this.f6836c;
            }

            public final String d() {
                return this.f6837d;
            }

            public final q5.k e() {
                return this.e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return kotlin.jvm.internal.k.a(this.f6834a, aVar.f6834a) && kotlin.jvm.internal.k.a(this.f6835b, aVar.f6835b) && kotlin.jvm.internal.k.a(this.f6836c, aVar.f6836c) && kotlin.jvm.internal.k.a(this.f6837d, aVar.f6837d) && kotlin.jvm.internal.k.a(this.e, aVar.e) && kotlin.jvm.internal.k.a(this.f6838f, aVar.f6838f) && kotlin.jvm.internal.k.a(this.g, aVar.g);
            }

            public final q5.k f() {
                return this.f6838f;
            }

            public final View g() {
                return this.g;
            }

            public final G8 h() {
                Drawable drawable;
                String str = this.f6834a;
                String str2 = this.f6835b;
                String str3 = this.f6836c;
                String str4 = this.f6837d;
                q5.k kVar = this.e;
                WebView webView = null;
                if (kVar != null) {
                    Object obj = kVar.f13501a;
                    if (obj instanceof q5.j) {
                        obj = null;
                    }
                    drawable = (Drawable) obj;
                } else {
                    drawable = null;
                }
                q5.k kVar2 = this.f6838f;
                if (kVar2 != null) {
                    Object obj2 = kVar2.f13501a;
                    webView = (WebView) (obj2 instanceof q5.j ? null : obj2);
                }
                return new G8(str, str2, str3, str4, drawable, webView, this.g);
            }

            public int hashCode() {
                Object obj;
                Object obj2;
                String str = this.f6834a;
                int iHashCode = 0;
                int iHashCode2 = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f6835b;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f6836c;
                int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f6837d;
                int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                q5.k kVar = this.e;
                int iHashCode6 = (iHashCode5 + ((kVar == null || (obj = kVar.f13501a) == null) ? 0 : obj.hashCode())) * 31;
                q5.k kVar2 = this.f6838f;
                if (kVar2 != null && (obj2 = kVar2.f13501a) != null) {
                    iHashCode = obj2.hashCode();
                }
                return this.g.hashCode() + ((iHashCode6 + iHashCode) * 31);
            }

            public final String i() {
                return this.f6835b;
            }

            public final String j() {
                return this.f6836c;
            }

            public final String k() {
                return this.f6837d;
            }

            public final q5.k l() {
                return this.e;
            }

            public final q5.k m() {
                return this.f6838f;
            }

            public final View n() {
                return this.g;
            }

            public final String o() {
                return this.f6834a;
            }

            public String toString() {
                String str = this.f6834a;
                String str2 = this.f6835b;
                String str3 = this.f6836c;
                String str4 = this.f6837d;
                q5.k kVar = this.e;
                q5.k kVar2 = this.f6838f;
                View view = this.g;
                StringBuilder sbZ = a1.a.z("Data(title=", str, ", advertiser=", str2, ", body=");
                androidx.camera.core.processing.util.a.A(sbZ, str3, ", cta=", str4, ", icon=");
                sbZ.append(kVar);
                sbZ.append(", media=");
                sbZ.append(kVar2);
                sbZ.append(", privacyIcon=");
                sbZ.append(view);
                sbZ.append(")");
                return sbZ.toString();
            }

            public final a a(String str, String str2, String str3, String str4, q5.k kVar, q5.k kVar2, View privacyIcon) {
                kotlin.jvm.internal.k.e(privacyIcon, "privacyIcon");
                return new a(str, str2, str3, str4, kVar, kVar2, privacyIcon);
            }

            public static /* synthetic */ a a(a aVar, String str, String str2, String str3, String str4, q5.k kVar, q5.k kVar2, View view, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = aVar.f6834a;
                }
                if ((i2 & 2) != 0) {
                    str2 = aVar.f6835b;
                }
                if ((i2 & 4) != 0) {
                    str3 = aVar.f6836c;
                }
                if ((i2 & 8) != 0) {
                    str4 = aVar.f6837d;
                }
                if ((i2 & 16) != 0) {
                    kVar = aVar.e;
                }
                if ((i2 & 32) != 0) {
                    kVar2 = aVar.f6838f;
                }
                if ((i2 & 64) != 0) {
                    view = aVar.g;
                }
                q5.k kVar3 = kVar2;
                View view2 = view;
                q5.k kVar4 = kVar;
                String str5 = str3;
                return aVar.a(str, str2, str5, str4, kVar4, kVar3, view2);
            }
        }

        public b(a data) {
            kotlin.jvm.internal.k.e(data, "data");
            this.f6833a = data;
        }

        public final a a() {
            return this.f6833a;
        }

        public final JSONObject b() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (this.f6833a.o() != null) {
                a(jSONObject, "title");
            }
            if (this.f6833a.i() != null) {
                a(jSONObject, C2300e4.h.F0);
            }
            if (this.f6833a.j() != null) {
                a(jSONObject, C2300e4.h.E0);
            }
            if (this.f6833a.k() != null) {
                a(jSONObject, C2300e4.h.G0);
            }
            q5.k kVarL = this.f6833a.l();
            if (kVarL != null) {
                a(jSONObject, C2300e4.h.H0, kVarL.f13501a);
            }
            q5.k kVarM = this.f6833a.m();
            if (kVarM != null) {
                a(jSONObject, C2300e4.h.I0, kVarM.f13501a);
            }
            return jSONObject;
        }

        private static final void a(JSONObject jSONObject, String str) throws JSONException {
            jSONObject.put(str, new JSONObject().put("success", true));
        }

        private static final <T> void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", !(obj instanceof q5.j));
            Throwable thA = q5.k.a(obj);
            if (thA != null) {
                String message = thA.getMessage();
                if (message == null) {
                    message = "unknown reason";
                }
                jSONObject2.put("reason", message);
            }
            jSONObject.put(str, jSONObject2);
        }
    }

    public G8(String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View privacyIcon) {
        kotlin.jvm.internal.k.e(privacyIcon, "privacyIcon");
        this.f6826a = str;
        this.f6827b = str2;
        this.f6828c = str3;
        this.f6829d = str4;
        this.e = drawable;
        this.f6830f = webView;
        this.g = privacyIcon;
    }

    public final String a() {
        return this.f6826a;
    }

    public final String b() {
        return this.f6827b;
    }

    public final String c() {
        return this.f6828c;
    }

    public final String d() {
        return this.f6829d;
    }

    public final Drawable e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G8)) {
            return false;
        }
        G8 g8 = (G8) obj;
        return kotlin.jvm.internal.k.a(this.f6826a, g8.f6826a) && kotlin.jvm.internal.k.a(this.f6827b, g8.f6827b) && kotlin.jvm.internal.k.a(this.f6828c, g8.f6828c) && kotlin.jvm.internal.k.a(this.f6829d, g8.f6829d) && kotlin.jvm.internal.k.a(this.e, g8.e) && kotlin.jvm.internal.k.a(this.f6830f, g8.f6830f) && kotlin.jvm.internal.k.a(this.g, g8.g);
    }

    public final WebView f() {
        return this.f6830f;
    }

    public final View g() {
        return this.g;
    }

    public final String h() {
        return this.f6827b;
    }

    public int hashCode() {
        String str = this.f6826a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f6827b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f6828c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f6829d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Drawable drawable = this.e;
        int iHashCode5 = (iHashCode4 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        WebView webView = this.f6830f;
        return this.g.hashCode() + ((iHashCode5 + (webView != null ? webView.hashCode() : 0)) * 31);
    }

    public final String i() {
        return this.f6828c;
    }

    public final String j() {
        return this.f6829d;
    }

    public final Drawable k() {
        return this.e;
    }

    public final WebView l() {
        return this.f6830f;
    }

    public final View m() {
        return this.g;
    }

    public final String n() {
        return this.f6826a;
    }

    public String toString() {
        String str = this.f6826a;
        String str2 = this.f6827b;
        String str3 = this.f6828c;
        String str4 = this.f6829d;
        Drawable drawable = this.e;
        WebView webView = this.f6830f;
        View view = this.g;
        StringBuilder sbZ = a1.a.z("ISNNativeAdData(title=", str, ", advertiser=", str2, ", body=");
        androidx.camera.core.processing.util.a.A(sbZ, str3, ", cta=", str4, ", icon=");
        sbZ.append(drawable);
        sbZ.append(", mediaView=");
        sbZ.append(webView);
        sbZ.append(", privacyIcon=");
        sbZ.append(view);
        sbZ.append(")");
        return sbZ.toString();
    }

    public final G8 a(String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View privacyIcon) {
        kotlin.jvm.internal.k.e(privacyIcon, "privacyIcon");
        return new G8(str, str2, str3, str4, drawable, webView, privacyIcon);
    }

    public static /* synthetic */ G8 a(G8 g8, String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View view, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = g8.f6826a;
        }
        if ((i2 & 2) != 0) {
            str2 = g8.f6827b;
        }
        if ((i2 & 4) != 0) {
            str3 = g8.f6828c;
        }
        if ((i2 & 8) != 0) {
            str4 = g8.f6829d;
        }
        if ((i2 & 16) != 0) {
            drawable = g8.e;
        }
        if ((i2 & 32) != 0) {
            webView = g8.f6830f;
        }
        if ((i2 & 64) != 0) {
            view = g8.g;
        }
        WebView webView2 = webView;
        View view2 = view;
        Drawable drawable2 = drawable;
        String str5 = str3;
        return g8.a(str, str2, str5, str4, drawable2, webView2, view2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X8 f6831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC2225a1 f6832b;

        public a(X8 imageLoader, InterfaceC2225a1 adViewManagement) {
            kotlin.jvm.internal.k.e(imageLoader, "imageLoader");
            kotlin.jvm.internal.k.e(adViewManagement, "adViewManagement");
            this.f6831a = imageLoader;
            this.f6832b = adViewManagement;
        }

        private final q5.k b(String str) {
            if (str == null) {
                return null;
            }
            return new q5.k(this.f6831a.a(str));
        }

        public final b a(Context activityContext, JSONObject json) {
            kotlin.jvm.internal.k.e(activityContext, "activityContext");
            kotlin.jvm.internal.k.e(json, "json");
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("title");
            String strB = jSONObjectOptJSONObject != null ? H8.b(jSONObjectOptJSONObject, C2300e4.h.K0) : null;
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject(C2300e4.h.F0);
            String strB2 = jSONObjectOptJSONObject2 != null ? H8.b(jSONObjectOptJSONObject2, C2300e4.h.K0) : null;
            JSONObject jSONObjectOptJSONObject3 = json.optJSONObject(C2300e4.h.E0);
            String strB3 = jSONObjectOptJSONObject3 != null ? H8.b(jSONObjectOptJSONObject3, C2300e4.h.K0) : null;
            JSONObject jSONObjectOptJSONObject4 = json.optJSONObject(C2300e4.h.G0);
            String strB4 = jSONObjectOptJSONObject4 != null ? H8.b(jSONObjectOptJSONObject4, C2300e4.h.K0) : null;
            JSONObject jSONObjectOptJSONObject5 = json.optJSONObject(C2300e4.h.H0);
            String strB5 = jSONObjectOptJSONObject5 != null ? H8.b(jSONObjectOptJSONObject5, "url") : null;
            JSONObject jSONObjectOptJSONObject6 = json.optJSONObject(C2300e4.h.I0);
            String strB6 = jSONObjectOptJSONObject6 != null ? H8.b(jSONObjectOptJSONObject6, "adViewId") : null;
            JSONObject jSONObjectOptJSONObject7 = json.optJSONObject(C2300e4.h.J0);
            return new b(new b.a(strB, strB2, strB3, strB4, b(strB5), a(strB6), C2608vd.f10453a.a(activityContext, jSONObjectOptJSONObject7 != null ? H8.b(jSONObjectOptJSONObject7, "url") : null, this.f6831a)));
        }

        private final q5.k a(String str) {
            if (str == null) {
                return null;
            }
            K8 k8A = this.f6832b.a(str);
            WebView presentingView = k8A != null ? k8A.getPresentingView() : null;
            if (presentingView == null) {
                return new q5.k(r2.q.M(new Exception(a1.a.m("missing adview for id: '", str, "'"))));
            }
            return new q5.k(presentingView);
        }
    }
}
