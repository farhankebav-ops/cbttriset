package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ra, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2537ra implements Le<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Le<String> f9767a;

    public C2537ra(Le<String> serverResponse) {
        kotlin.jvm.internal.k.e(serverResponse, "serverResponse");
        this.f9767a = serverResponse;
    }

    @Override // com.ironsource.Le
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        return new JSONObject(this.f9767a.a());
    }
}
