package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f6946b;

    public Hd(JSONObject features, String nameKey, String amountKey) {
        kotlin.jvm.internal.k.e(features, "features");
        kotlin.jvm.internal.k.e(nameKey, "nameKey");
        kotlin.jvm.internal.k.e(amountKey, "amountKey");
        this.f6945a = features.has(nameKey) ? features.getString(nameKey) : null;
        this.f6946b = features.has(amountKey) ? Integer.valueOf(features.getInt(amountKey)) : null;
    }

    public final Integer a() {
        return this.f6946b;
    }

    public final String b() {
        return this.f6945a;
    }
}
