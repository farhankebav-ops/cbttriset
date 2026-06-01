package com.iab.omid.library.ironsrc.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f5989b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5990a;

    private g() {
    }

    public static g b() {
        return f5989b;
    }

    public Context a() {
        return this.f5990a;
    }

    public void a(Context context) {
        this.f5990a = context != null ? context.getApplicationContext() : null;
    }
}
