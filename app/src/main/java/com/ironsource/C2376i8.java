package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.i8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2376i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8725c;

    public C2376i8() {
        this.f8723a = 0;
        this.f8724b = 0;
        this.f8725c = "";
    }

    public int a() {
        return this.f8724b;
    }

    public String b() {
        return this.f8725c;
    }

    public int c() {
        return this.f8723a;
    }

    public boolean d() {
        return this.f8724b > 0 && this.f8723a > 0;
    }

    public boolean e() {
        return this.f8724b == 0 && this.f8723a == 0;
    }

    public String toString() {
        return this.f8725c;
    }

    public C2376i8(int i2, int i8, String str) {
        this.f8723a = i2;
        this.f8724b = i8;
        this.f8725c = str;
    }
}
