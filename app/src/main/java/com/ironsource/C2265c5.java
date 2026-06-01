package com.ironsource;

import android.content.Context;

/* JADX INFO: renamed from: com.ironsource.c5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2265c5 {
    private static C2265c5 h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8110d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8111f;
    private final B7 g;

    private C2265c5(Context context) {
        B7 b7I = Mb.U().i();
        this.g = b7I;
        this.f8107a = b7I.q();
        this.f8108b = b7I.l();
        this.f8109c = b7I.f();
        this.f8110d = b7I.i();
        this.e = b7I.e();
        this.f8111f = b7I.u(context);
    }

    public static C2265c5 b(Context context) {
        if (h == null) {
            h = new C2265c5(context);
        }
        return h;
    }

    public static void g() {
        h = null;
    }

    public int a() {
        return this.e;
    }

    public String c() {
        return this.f8108b;
    }

    public String d() {
        return this.f8107a;
    }

    public String e() {
        return this.f8109c;
    }

    public String f() {
        return this.f8110d;
    }

    public float a(Context context) {
        return this.g.E(context);
    }

    public String b() {
        return this.f8111f;
    }
}
