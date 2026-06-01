package com.iab.omid.library.bytedance2.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f5885b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5886a;

    private g() {
    }

    public static g b() {
        return f5885b;
    }

    public Context a() {
        return this.f5886a;
    }

    public void a(Context context) {
        this.f5886a = context != null ? context.getApplicationContext() : null;
    }
}
