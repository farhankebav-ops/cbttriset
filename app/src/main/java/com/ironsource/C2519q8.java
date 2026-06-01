package com.ironsource;

import android.content.Context;
import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.q8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2519q8 implements InterfaceC2225a1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9697b = "q8";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static C2519q8 f9698c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, K8> f9699a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.ironsource.q8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2502p8 f9700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f9701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9702c;

        public a(C2502p8 c2502p8, Context context, String str) {
            this.f9700a = c2502p8;
            this.f9701b = context;
            this.f9702c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2519q8.this.f9699a.put(this.f9702c, new C2411k8(this.f9700a, this.f9701b));
        }
    }

    private C2376i8 b(JSONObject jSONObject) {
        C2376i8 c2376i8 = new C2376i8();
        try {
            return a(jSONObject);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return c2376i8;
        }
    }

    private boolean d(JSONObject jSONObject) {
        return jSONObject.optBoolean(C2300e4.h.f8384s0);
    }

    public String c(JSONObject jSONObject) throws JSONException {
        return (jSONObject == null || !jSONObject.has("adViewId")) ? (jSONObject == null || !jSONObject.has("params")) ? "" : new JSONObject(jSONObject.getString("params")).getString("adViewId") : jSONObject.getString("adViewId");
    }

    public static synchronized C2519q8 a() {
        try {
            if (f9698c == null) {
                f9698c = new C2519q8();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9698c;
    }

    public void d(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = new JSONObject(jSONObject.getString("params")).getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(f9697b, "sendMessageToAd fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f9699a.containsKey(string)) {
            Logger.i(f9697b, "sendMessageToAd fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        K8 k8 = this.f9699a.get(string);
        if (k8 != null) {
            k8.c(jSONObject, str, str2);
        }
    }

    private C2376i8 a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(C2300e4.h.O));
            String string = jSONObject2.get("height").toString();
            String string2 = jSONObject2.get("width").toString();
            return new C2376i8(Integer.parseInt(string2), Integer.parseInt(string), jSONObject2.get("label").toString());
        } catch (Exception e) {
            C2531r4.d().a(e);
            return new C2376i8();
        }
    }

    public void b(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f9699a.containsKey(string)) {
                K8 k8 = this.f9699a.get(string);
                String string2 = jSONObject.getString(C2300e4.h.f8389v0);
                if (k8 != null) {
                    k8.a(string2, str, str2);
                    return;
                }
                return;
            }
            Logger.i(f9697b, "performWebViewAction fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        Logger.i(f9697b, "performWebViewAction fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void c(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f9699a.containsKey(string)) {
                K8 k8 = this.f9699a.get(string);
                this.f9699a.remove(string);
                if (k8 != null) {
                    k8.a(str, str2);
                    return;
                }
                return;
            }
            Logger.i(f9697b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        Logger.i(f9697b, "removeAdView fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void a(InterfaceC2429l8 interfaceC2429l8, JSONObject jSONObject, Context context, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            C2376i8 c2376i8B = b(jSONObject);
            if (!this.f9699a.containsKey(string)) {
                C2502p8 c2502p8 = new C2502p8(interfaceC2429l8, context, string, c2376i8B);
                c2502p8.e(IronSourceStorageUtils.getNetworkStorageDir(context));
                c2502p8.b(jSONObject, str, str2);
                if (d(jSONObject)) {
                    V7.f7731a.d(new a(c2502p8, context, string));
                    return;
                } else {
                    this.f9699a.put(string, c2502p8);
                    return;
                }
            }
            Logger.i(f9697b, "sendMessageToAd fail - collection already contain adViewId");
            throw new Exception("collection already contain adViewId");
        }
        Logger.i(f9697b, "loadWithUrl fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    @Override // com.ironsource.InterfaceC2225a1
    public K8 a(String str) {
        if (str.isEmpty() || !this.f9699a.containsKey(str)) {
            return null;
        }
        return this.f9699a.get(str);
    }

    public void a(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f9699a.containsKey(string)) {
                K8 k8 = this.f9699a.get(string);
                if (k8 != null) {
                    k8.a(jSONObject, str, str2);
                    return;
                }
                return;
            }
            Logger.i(f9697b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        Logger.i(f9697b, "removeAdView fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }
}
