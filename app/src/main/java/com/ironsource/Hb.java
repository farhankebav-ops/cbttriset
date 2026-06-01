package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Hb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f6924d;

    public Hb(JSONObject applicationLogger) {
        kotlin.jvm.internal.k.e(applicationLogger, "applicationLogger");
        this.f6921a = applicationLogger.optInt(Ib.f6986a, 3);
        this.f6922b = applicationLogger.optInt(Ib.f6987b, 3);
        this.f6923c = applicationLogger.optInt("console", 3);
        this.f6924d = applicationLogger.optBoolean(Ib.f6989d, false);
    }

    public final int a() {
        return this.f6923c;
    }

    public final int b() {
        return this.f6922b;
    }

    public final int c() {
        return this.f6921a;
    }

    public final boolean d() {
        return this.f6924d;
    }
}
