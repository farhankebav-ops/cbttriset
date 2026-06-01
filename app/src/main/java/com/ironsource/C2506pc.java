package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.ironsource.C2569t8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.pc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2506pc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B7 f9660b = Mb.U().i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    U6 f9659a = new U6();

    public void a(Context context) {
        if (context instanceof Activity) {
            this.f9659a.a(Q6.f7452n, Boolean.valueOf(this.f9660b.a((Activity) context)));
        }
    }

    public void b() {
        String controllerConfig = SDKUtils.getControllerConfig();
        if (TextUtils.isEmpty(controllerConfig)) {
            return;
        }
        try {
            this.f9659a.a(Q6.f7443i, new JSONObject(controllerConfig).opt(C2300e4.a.f8299q));
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void c() {
        this.f9659a.a("uxt", Boolean.valueOf(IronSourceStorageUtils.isUxt()));
    }

    public void d() {
        this.f9659a.a(Q6.V, "9.0.0");
    }

    public void e() {
        HashMap map = new HashMap();
        map.put(Q6.E, Hc.f6926f);
        map.put(Q6.D, Hc.e);
        this.f9659a.a(map);
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(IronSourceQaProperties.getInstance().getParameters());
        if (jSONObject.length() > 0) {
            this.f9659a.a("debug", jSONObject);
        }
    }

    public void b(Context context) {
        this.f9659a.a("gpi", Boolean.valueOf(C2291dd.d(context)));
    }

    public void a(JSONObject jSONObject) {
        this.f9659a.a(Q6.l, jSONObject);
    }

    public void a(C2569t8.c cVar) {
        this.f9659a.a(Q6.f7481x1, Integer.valueOf(cVar.ordinal()));
    }

    public void a(Map<String, JSONObject> map) {
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            this.f9659a.a(entry.getKey(), (Object) entry.getValue());
        }
    }

    public void a(List<String> list) {
        this.f9659a.a(Q6.A1, list);
    }

    public void a(boolean z2) {
        this.f9659a.a(Q6.R0, Boolean.valueOf(z2));
    }
}
