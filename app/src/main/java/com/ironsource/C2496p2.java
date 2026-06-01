package com.ironsource;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.ironsource.p2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2496p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9580d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9581f;
    private int g;
    private long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9582i;
    private long j;
    private long k;
    private long l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<String> f9583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f9584o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9585q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f9586r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f9587s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f9588t;

    public C2496p2() {
        this.f9578b = "";
        this.f9579c = "";
        this.f9580d = "";
        this.f9582i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = true;
        this.f9583n = new ArrayList<>();
        this.g = 0;
        this.f9584o = false;
        this.p = false;
        this.f9585q = 1;
    }

    public String a() {
        return this.f9578b;
    }

    public long b() {
        return this.j;
    }

    public int c() {
        return this.f9581f;
    }

    public int d() {
        return this.f9585q;
    }

    public boolean e() {
        return this.m;
    }

    public ArrayList<String> f() {
        return this.f9583n;
    }

    public int g() {
        return this.e;
    }

    public boolean h() {
        return this.f9577a;
    }

    public int i() {
        return this.g;
    }

    public long j() {
        return this.k;
    }

    public long k() {
        return this.f9582i;
    }

    public long l() {
        return this.l;
    }

    public long m() {
        return this.h;
    }

    public boolean n() {
        return this.f9588t;
    }

    public boolean o() {
        return this.f9584o;
    }

    public boolean p() {
        return this.p;
    }

    public boolean q() {
        return this.f9587s;
    }

    public boolean r() {
        return this.f9586r;
    }

    public String a(boolean z2) {
        return z2 ? this.f9580d : this.f9579c;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f9583n.add(str);
    }

    public C2496p2(String str, String str2, String str3, int i2, int i8, long j, long j3, long j8, long j9, long j10, boolean z2, int i9, boolean z7, boolean z8, boolean z9, int i10, boolean z10, boolean z11, boolean z12) {
        this.f9578b = str;
        this.f9579c = str2;
        this.f9580d = str3;
        this.e = i2;
        this.f9581f = i8;
        this.h = j;
        this.f9577a = z9;
        this.f9582i = j3;
        this.j = j8;
        this.k = j9;
        this.l = j10;
        this.m = z2;
        this.g = i9;
        this.f9583n = new ArrayList<>();
        this.f9584o = z7;
        this.p = z8;
        this.f9585q = i10;
        this.f9586r = z10;
        this.f9587s = z11;
        this.f9588t = z12;
    }
}
