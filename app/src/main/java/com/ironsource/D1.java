package com.ironsource;

import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class D1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet<String> f6429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6431d;
    private final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6432f;
    private final boolean g;

    public D1(JSONObject applicationCrashReporterSettings) throws JSONException {
        HashSet<String> hashSet;
        kotlin.jvm.internal.k.e(applicationCrashReporterSettings, "applicationCrashReporterSettings");
        this.f6428a = applicationCrashReporterSettings.optBoolean("enabled", false);
        List<String> listB = C2395ja.b(applicationCrashReporterSettings.optJSONArray(F1.f6741b));
        if (listB != null) {
            hashSet = new HashSet<>(r5.x.d0(r5.n.L0(listB, 12)));
            r5.l.l1(listB, hashSet);
        } else {
            hashSet = null;
        }
        this.f6429b = hashSet;
        String strOptString = applicationCrashReporterSettings.optString(F1.f6742c);
        kotlin.jvm.internal.k.d(strOptString, "applicationCrashReporter…(CRASHREPORTER_URL_FIELD)");
        this.f6430c = strOptString;
        String strOptString2 = applicationCrashReporterSettings.optString(F1.f6743d);
        kotlin.jvm.internal.k.d(strOptString2, "applicationCrashReporter…SHREPORTER_KEYWORD_FIELD)");
        this.f6431d = strOptString2;
        this.e = applicationCrashReporterSettings.optBoolean(F1.e, false);
        this.f6432f = applicationCrashReporterSettings.optInt("timeout", 5000);
        this.g = applicationCrashReporterSettings.optBoolean(F1.g, false);
    }

    public final int a() {
        return this.f6432f;
    }

    public final HashSet<String> b() {
        return this.f6429b;
    }

    public final String c() {
        return this.f6431d;
    }

    public final String d() {
        return this.f6430c;
    }

    public final boolean e() {
        return this.e;
    }

    public final boolean f() {
        return this.f6428a;
    }

    public final boolean g() {
        return this.g;
    }
}
