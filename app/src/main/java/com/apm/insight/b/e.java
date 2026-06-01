package com.apm.insight.b;

import androidx.annotation.CallSuper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f4290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f4291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f4292c = false;

    public boolean a() {
        return false;
    }

    @CallSuper
    public void b(String str) {
        this.f4292c = false;
    }

    @CallSuper
    public void a(String str) {
        this.f4292c = true;
    }
}
