package com.ironsource;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f6387a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f6388b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f6389c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<String> f6390d = new ArrayList<>();

    public ArrayList<String> a() {
        return this.f6389c;
    }

    public ArrayList<String> b() {
        return this.f6388b;
    }

    public ArrayList<String> c() {
        return this.f6390d;
    }

    public ArrayList<String> d() {
        return this.f6387a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6389c.add(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6388b.add(str);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6390d.add(str);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6387a.add(str);
    }
}
