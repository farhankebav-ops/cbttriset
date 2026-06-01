package com.iab.omid.library.vungle.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f6200b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6201a;

    private g() {
    }

    public static g b() {
        return f6200b;
    }

    public Context a() {
        return this.f6201a;
    }

    public void a(Context context) {
        this.f6201a = context != null ? context.getApplicationContext() : null;
    }
}
