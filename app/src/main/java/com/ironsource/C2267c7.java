package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.c7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2267c7 implements Y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f8117a;

    /* JADX INFO: renamed from: com.ironsource.c7$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f8119b = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f8121d = 24;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8118a = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f8120c = EnumC2285d7.SendEvent.b();

        private a() {
        }

        public final int a() {
            return f8120c;
        }
    }

    public C2267c7(JSONObject jSONObject) {
        this.f8117a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.Y6
    public long a() {
        return ((long) this.f8117a.optInt("timeout", 24)) * 1000;
    }

    @Override // com.ironsource.X5
    public boolean b() {
        return this.f8117a.optBoolean(com.ironsource.mediationsdk.metadata.a.j, false);
    }

    @Override // com.ironsource.Y6
    public EnumC2285d7 c() {
        return EnumC2285d7.f8205b.a(this.f8117a.optInt("strategy", a.f8118a.a()));
    }
}
