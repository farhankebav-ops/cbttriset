package com.ironsource.sdk.controller;

import com.ironsource.C2230a6;
import com.ironsource.C2504pa;
import com.ironsource.C2521qa;
import com.ironsource.C2531r4;
import com.ironsource.C2586u8;
import com.ironsource.C8;
import com.ironsource.InterfaceC2487oa;
import com.ironsource.Pc;
import com.ironsource.Y5;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2230a6 f9993b;

    public j(String str, C2230a6 c2230a6) {
        this.f9992a = str;
        this.f9993b = c2230a6;
    }

    private C8 b(JSONObject jSONObject, String str) throws Exception {
        if (!jSONObject.has(Y5.c.f7842c) || !jSONObject.has(Y5.c.f7841b)) {
            throw new Exception(Y5.a.f7830a);
        }
        String string = jSONObject.getString(Y5.c.f7842c);
        return new C8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, string), jSONObject.getString(Y5.c.f7841b));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(JSONObject jSONObject, InterfaceC2487oa interfaceC2487oa) {
        C2504pa c2504pa = new C2504pa(jSONObject);
        C2521qa c2521qa = new C2521qa(interfaceC2487oa);
        try {
            String strB = c2504pa.b();
            JSONObject jSONObjectC = c2504pa.c();
            C8 c8B = b(jSONObjectC, this.f9992a);
            IronSourceStorageUtils.ensurePathSafety(c8B, this.f9992a);
            switch (strB.hashCode()) {
                case -2073025383:
                    if (strB.equals(Y5.b.f7835a)) {
                        this.f9993b.a(c8B, jSONObjectC.optString(Y5.c.f7840a), jSONObjectC.optInt("connectionTimeout"), jSONObjectC.optInt("readTimeout"), a(c2504pa, c2521qa));
                    }
                    break;
                case -1137024519:
                    if (strB.equals(Y5.b.f7837c)) {
                        this.f9993b.b(c8B);
                        c2521qa.b(c2504pa, a(c2504pa, c8B.a()));
                    }
                    break;
                case -318115535:
                    if (strB.equals(Y5.b.e)) {
                        c2521qa.b(c2504pa, a(c2504pa, this.f9993b.d(c8B)));
                    }
                    break;
                case 537556755:
                    if (strB.equals(Y5.b.f7839f)) {
                        this.f9993b.a(c8B, jSONObjectC.optJSONObject(Y5.c.g));
                        c2521qa.b(c2504pa, a(c2504pa, c8B.a()));
                    }
                    break;
                case 1764172231:
                    if (strB.equals(Y5.b.f7836b)) {
                        this.f9993b.a(c8B);
                        c2521qa.b(c2504pa, a(c2504pa, c8B.a()));
                    }
                    break;
                case 1953259713:
                    if (strB.equals(Y5.b.f7838d)) {
                        c2521qa.b(c2504pa, a(c2504pa, this.f9993b.c(c8B)));
                    }
                    break;
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            c2521qa.a(c2504pa, a(c2504pa, e.getMessage()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Pc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2521qa f9994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C2504pa f9995b;

        public a(C2521qa c2521qa, C2504pa c2504pa) {
            this.f9994a = c2521qa;
            this.f9995b = c2504pa;
        }

        @Override // com.ironsource.Pc
        public void a(C8 c8) {
            try {
                C2521qa c2521qa = this.f9994a;
                C2504pa c2504pa = this.f9995b;
                c2521qa.b(c2504pa, j.this.a(c2504pa, c8.a()));
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.ironsource.Pc
        public void a(C8 c8, C2586u8 c2586u8) {
            try {
                C2521qa c2521qa = this.f9994a;
                C2504pa c2504pa = this.f9995b;
                c2521qa.a(c2504pa, j.this.a(c2504pa, c2586u8.b()));
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    private Pc a(C2504pa c2504pa, C2521qa c2521qa) {
        return new a(c2521qa, c2504pa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(C2504pa c2504pa, JSONObject jSONObject) {
        try {
            return c2504pa.e().put("result", jSONObject);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    private JSONObject a(C2504pa c2504pa, long j) {
        try {
            return c2504pa.e().put("result", j);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(C2504pa c2504pa, String str) {
        try {
            return c2504pa.e().put("errMsg", str);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    private C8 a(JSONObject jSONObject, String str) throws Exception {
        if (jSONObject.has(Y5.c.f7843d)) {
            return new C8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, jSONObject.getString(Y5.c.f7843d)));
        }
        throw new Exception(Y5.a.f7831b);
    }
}
