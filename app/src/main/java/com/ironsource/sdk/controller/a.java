package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C2346ge;
import com.ironsource.C2519q8;
import com.ironsource.C2531r4;
import com.ironsource.InterfaceC2429l8;
import com.ironsource.InterfaceC2487oa;
import com.ironsource.Mg;
import com.ironsource.wg;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class a implements InterfaceC2429l8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9873d = "loadWithUrl";
    private static final String e = "sendMessage";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9874f = "removeAdView";
    public static final String g = "webviewAction";
    public static final String h = "handleGetViewVisibility";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9875i = "functionName";
    private static final String j = "functionParams";
    private static final String k = "success";
    private static final String l = "fail";
    public static final String m = "errMsg";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f9876n = "%s | unsupported AdViews API";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Mg f9877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C2519q8 f9878b = C2519q8.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f9879c;

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0194a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f9880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f9881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f9882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f9883d;

        public /* synthetic */ C0194a(int i2) {
            this();
        }

        private C0194a() {
        }
    }

    public a(Context context) {
        this.f9879c = context;
    }

    public void a(Mg mg) {
        this.f9877a = mg;
    }

    @Override // com.ironsource.InterfaceC2429l8
    public void a(String str, JSONObject jSONObject) {
        if (this.f9877a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f9877a.a(str, jSONObject);
    }

    @Override // com.ironsource.InterfaceC2429l8
    public void a(String str, String str2, String str3) {
        a(str, wg.a(str2, str3));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(String str, InterfaceC2487oa interfaceC2487oa) throws Exception {
        C0194a c0194aA = a(str);
        C2346ge c2346ge = new C2346ge();
        try {
            String str2 = c0194aA.f9880a;
            try {
                switch (str2.hashCode()) {
                    case -1384357108:
                        if (str2.equals(f9874f)) {
                            this.f9878b.c(c0194aA.f9881b, c0194aA.f9882c, c0194aA.f9883d);
                            return;
                        }
                        throw new IllegalArgumentException(c0194aA.f9880a + " | unsupported AdViews API");
                    case 691453791:
                        if (str2.equals("sendMessage")) {
                            this.f9878b.d(c0194aA.f9881b, c0194aA.f9882c, c0194aA.f9883d);
                            return;
                        }
                        throw new IllegalArgumentException(c0194aA.f9880a + " | unsupported AdViews API");
                    case 842351363:
                        if (str2.equals("loadWithUrl")) {
                            this.f9878b.a(this, c0194aA.f9881b, this.f9879c, c0194aA.f9882c, c0194aA.f9883d);
                            return;
                        }
                        throw new IllegalArgumentException(c0194aA.f9880a + " | unsupported AdViews API");
                    case 1182065477:
                        if (str2.equals("handleGetViewVisibility")) {
                            this.f9878b.a(c0194aA.f9881b, c0194aA.f9882c, c0194aA.f9883d);
                            return;
                        }
                        throw new IllegalArgumentException(c0194aA.f9880a + " | unsupported AdViews API");
                    case 1491535759:
                        if (str2.equals(g)) {
                            this.f9878b.b(c0194aA.f9881b, c0194aA.f9882c, c0194aA.f9883d);
                            return;
                        }
                        throw new IllegalArgumentException(c0194aA.f9880a + " | unsupported AdViews API");
                    default:
                        throw new IllegalArgumentException(c0194aA.f9880a + " | unsupported AdViews API");
                }
            } catch (Exception e4) {
                e = e4;
                C2531r4.d().a(e);
                c2346ge.b("errMsg", e.getMessage());
                String strC = this.f9878b.c(c0194aA.f9881b);
                if (!TextUtils.isEmpty(strC)) {
                    c2346ge.b("adViewId", strC);
                }
                interfaceC2487oa.a(false, c0194aA.f9883d, c2346ge);
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    private C0194a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        C0194a c0194a = new C0194a(0);
        c0194a.f9880a = jSONObject.optString("functionName");
        c0194a.f9881b = jSONObject.optJSONObject("functionParams");
        c0194a.f9882c = jSONObject.optString("success");
        c0194a.f9883d = jSONObject.optString("fail");
        return c0194a;
    }
}
