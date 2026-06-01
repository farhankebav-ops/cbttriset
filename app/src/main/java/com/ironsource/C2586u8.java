package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.u8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2586u8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10386c = 1001;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10388b;

    public C2586u8(int i2, String str) {
        this.f10388b = i2;
        this.f10387a = str == null ? "" : str;
    }

    public int a() {
        return this.f10388b;
    }

    public String b() {
        return this.f10387a;
    }

    public String toString() {
        return "error - code:" + this.f10388b + ", message:" + this.f10387a;
    }
}
