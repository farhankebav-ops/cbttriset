package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.b1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2243b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NetworkSettings f8026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f8027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IronSource.a f8028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8029d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8030f;
    private int g;

    public C2243b1(NetworkSettings networkSettings, JSONObject jSONObject, IronSource.a aVar) {
        this.f8026a = networkSettings;
        this.f8027b = jSONObject;
        int iOptInt = jSONObject.optInt("instanceType");
        this.f8030f = iOptInt;
        this.f8029d = iOptInt == 2;
        this.e = jSONObject.optBoolean(IronSourceConstants.EARLY_INIT_FIELD);
        this.g = jSONObject.optInt("maxAdsPerSession", 99);
        this.f8028c = aVar;
    }

    public String a() {
        return this.f8026a.getAdSourceNameForEvents();
    }

    public IronSource.a b() {
        return this.f8028c;
    }

    public JSONObject c() {
        return this.f8027b;
    }

    public int d() {
        return this.f8030f;
    }

    public int e() {
        return this.g;
    }

    public String f() {
        return this.f8026a.getProviderName();
    }

    public String g() {
        return this.f8026a.getProviderTypeForReflection();
    }

    public NetworkSettings h() {
        return this.f8026a;
    }

    public String i() {
        return this.f8026a.getSubProviderId();
    }

    public boolean j() {
        return this.f8029d;
    }

    public boolean k() {
        return this.e;
    }
}
