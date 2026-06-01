package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.qa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2521qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2487oa f9706a;

    public C2521qa(InterfaceC2487oa interfaceC2487oa) {
        this.f9706a = interfaceC2487oa;
    }

    public void a(C2504pa c2504pa, JSONObject jSONObject) {
        this.f9706a.a(false, c2504pa.a(), jSONObject);
    }

    public void b(C2504pa c2504pa, JSONObject jSONObject) {
        this.f9706a.a(true, c2504pa.d(), jSONObject);
    }
}
