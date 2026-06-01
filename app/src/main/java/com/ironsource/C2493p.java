package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2493p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f9570a;

    public C2493p(JSONObject adFormatAuctionSettings) {
        kotlin.jvm.internal.k.e(adFormatAuctionSettings, "adFormatAuctionSettings");
        this.f9570a = adFormatAuctionSettings.has(C2510q.f9685a) ? Boolean.valueOf(adFormatAuctionSettings.optBoolean(C2510q.f9685a)) : null;
    }

    public final Boolean a() {
        return this.f9570a;
    }
}
