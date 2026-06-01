package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2421l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IronSource.a f8874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NetworkSettings f8876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8877d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f8878f;
    private String g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8879i;

    public C2421l0(IronSource.a aVar, String str, int i2, JSONObject jSONObject, String str2, int i8, String str3, NetworkSettings networkSettings, int i9) {
        this.f8874a = aVar;
        this.f8875b = str;
        this.e = i2;
        this.f8878f = jSONObject;
        this.g = str2;
        this.h = i8;
        this.f8879i = str3;
        this.f8876c = networkSettings;
        this.f8877d = i9;
    }

    public IronSource.a a() {
        return this.f8874a;
    }

    public String b() {
        return this.f8879i;
    }

    public String c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public JSONObject e() {
        return this.f8878f;
    }

    public int f() {
        return this.f8877d;
    }

    public NetworkSettings g() {
        return this.f8876c;
    }

    public int h() {
        return this.e;
    }

    public String i() {
        return this.f8875b;
    }
}
