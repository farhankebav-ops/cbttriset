package com.ironsource;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.n8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2467n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2429l8 f9490a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f9492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9493d;
    private String e = "n8";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f9494f = {"handleGetViewVisibility"};
    private final String[] g = {C2393j8.h, C2393j8.f8780i, C2393j8.g, "handleGetViewVisibility", C2393j8.j};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qg f9491b = new qg();

    /* JADX INFO: renamed from: com.ironsource.n8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f9498d;

        public a(String str, String str2, String str3, JSONObject jSONObject) {
            this.f9495a = str;
            this.f9496b = str2;
            this.f9497c = str3;
            this.f9498d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!C2467n8.this.b(this.f9495a)) {
                    String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + this.f9495a;
                    Log.e(C2467n8.this.e, str);
                    C2467n8.this.a(this.f9496b, str);
                    return;
                }
                if (this.f9495a.equalsIgnoreCase("handleGetViewVisibility")) {
                    C2467n8.this.e(this.f9497c);
                    return;
                }
                if (!this.f9495a.equalsIgnoreCase(C2393j8.j) && !this.f9495a.equalsIgnoreCase(C2393j8.f8780i)) {
                    return;
                }
                C2467n8.this.a(this.f9498d.getString("params"), this.f9497c, this.f9496b);
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
                String str2 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + this.f9495a;
                Log.e(C2467n8.this.e, str2);
                C2467n8.this.a(this.f9496b, str2);
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.n8$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9500b;

        public b(String str, String str2) {
            this.f9499a = str;
            this.f9500b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C2467n8.this.f9492c.evaluateJavascript(this.f9499a, null);
            } catch (Throwable th) {
                C2531r4.d().a(th);
                Log.e(C2467n8.this.e, "injectJavaScriptIntoWebView | Error while trying inject JS into external adUnit: " + this.f9500b + "Android API level: " + Build.VERSION.SDK_INT);
            }
        }
    }

    private void d() {
        if (this.f9490a == null || this.f9491b == null) {
            return;
        }
        a(C2393j8.f8775a, a());
    }

    private boolean h(String str) {
        for (String str2 : this.f9494f) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(String str) {
        return str.equalsIgnoreCase(C2393j8.k);
    }

    public void e() {
        if (this.f9490a == null || this.f9491b == null) {
            return;
        }
        a(C2393j8.f8776b, a());
    }

    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adViewId", this.f9493d);
            a(str, jSONObject);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void g(String str) {
        this.f9493d = str;
    }

    public void a(WebView webView) {
        this.f9492c = webView;
    }

    public void b() {
        this.f9490a = null;
        this.f9491b = null;
    }

    public String c() {
        return this.f9493d;
    }

    public void a(InterfaceC2429l8 interfaceC2429l8) {
        this.f9490a = interfaceC2429l8;
    }

    public void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("method");
            if (!TextUtils.isEmpty(strOptString) && h(strOptString)) {
                if (strOptString.equalsIgnoreCase("handleGetViewVisibility")) {
                    a(jSONObject, (String) null, (String) null);
                    return;
                }
                return;
            }
            a(jSONObject.optString(C2393j8.f8788v, C2393j8.f8777c), jSONObject);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            Log.e(this.e, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        for (String str2 : this.g) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private void d(String str) {
        V7.f7731a.d(new b(a1.a.m("javascript:try{", str, "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}"), str));
    }

    public void a(String str, JSONObject jSONObject) {
        InterfaceC2429l8 interfaceC2429l8 = this.f9490a;
        if (interfaceC2429l8 != null) {
            interfaceC2429l8.a(str, jSONObject);
        }
    }

    public void e(String str) throws JSONException {
        JSONObject jSONObjectA = this.f9491b.a();
        jSONObjectA.put("adViewId", this.f9493d);
        a(str, jSONObjectA);
    }

    public void a(String str, String str2) {
        InterfaceC2429l8 interfaceC2429l8 = this.f9490a;
        if (interfaceC2429l8 != null) {
            interfaceC2429l8.a(str, str2, this.f9493d);
        }
    }

    public void a(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.f9490a == null) {
            A8.a(C2328fe.f8544t, new C2603v8().a(G5.y, "mDelegate is null").a());
        } else {
            V7.f7731a.d(new a(str, str3, str2, jSONObject));
        }
    }

    public void a(String str, int i2, boolean z2) {
        this.f9491b.a(str, i2, z2);
        if (i(str)) {
            d();
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C2393j8.f8785s, this.f9491b.a());
            jSONObject.put(C2393j8.p, jSONObject2);
            jSONObject.put("adViewId", c());
            return jSONObject;
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        a(a(jSONObject).toString(), str, str2);
    }

    public void a(String str, String str2, String str3) throws JSONException {
        if (this.f9492c == null) {
            String strL = a1.a.l("No external adUnit attached to ISNAdView while trying to send message: ", str);
            Log.e(this.e, strL);
            this.f9490a.a(str3, strL, this.f9493d);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            str = "\"" + str + "\"";
        }
        d(a(str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.f9493d);
        a(str2, jSONObject);
    }

    private String a(String str) {
        return String.format(C2393j8.f8787u, str);
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", jSONObject.getString("id"));
            jSONObject2.put("data", this.f9491b.a());
            return jSONObject2;
        } catch (Exception e) {
            C2531r4.d().a(e);
            Log.e(this.e, "Error while trying execute method buildVisibilityMessageForAdUnit | params: " + jSONObject);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject2;
        }
    }
}
