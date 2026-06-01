package com.ironsource;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class N9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7277a;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f7281f;
    private final Ic g;
    private boolean h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7278b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7279c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C2376i8 f7280d = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f7282i = false;
    protected String j = null;

    public N9(String str, Ic ic) throws NullPointerException {
        this.f7277a = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.g = (Ic) SDKUtils.requireNonNull(ic, "AdListener name can't be null");
    }

    public N9 a(boolean z2) {
        this.f7279c = z2;
        return this;
    }

    public N9 b(boolean z2) {
        this.f7282i = z2;
        return this;
    }

    public N9 c() {
        this.f7278b = true;
        return this;
    }

    public N9 a(C2376i8 c2376i8) {
        this.f7280d = c2376i8;
        return this;
    }

    public N9 b(@Nullable String str) {
        this.j = str;
        return this;
    }

    public N9 c(boolean z2) {
        this.h = z2;
        return this;
    }

    public N9 a(String str) {
        this.e = str;
        return this;
    }

    public String b() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f7277a);
            jSONObject.put("rewarded", this.f7278b);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return (this.f7279c || this.h) ? X9.a() : X9.a(jSONObject);
    }

    public N9 a(Map<String, String> map) {
        this.f7281f = map;
        return this;
    }

    public M9 a() {
        return new M9(b(), this.f7277a, this.f7278b, this.f7279c, this.h, this.f7282i, this.j, this.f7281f, this.g, this.f7280d);
    }
}
