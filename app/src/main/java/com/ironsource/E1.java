package com.ironsource;

import android.text.TextUtils;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class E1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6653d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6654f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet<String> f6651b = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6650a = false;
    private boolean e = false;
    private boolean g = true;

    public void a(boolean z2) {
        this.f6650a = z2;
    }

    public HashSet<String> b() {
        return this.f6651b;
    }

    public void c(String str) {
        this.f6652c = str;
    }

    public String d() {
        return this.f6652c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f6650a;
    }

    public boolean g() {
        return this.g;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6651b.add(str);
    }

    public void b(String str) {
        this.f6653d = str;
    }

    public String c() {
        return this.f6653d;
    }

    public void b(boolean z2) {
        this.g = z2;
    }

    public void c(boolean z2) {
        this.e = z2;
    }

    public int a() {
        return this.f6654f;
    }

    public void a(int i2) {
        this.f6654f = i2;
    }
}
