package com.iab.omid.library.unity3d.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f f6096b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6097a;

    private f() {
    }

    public static f b() {
        return f6096b;
    }

    public Context a() {
        return this.f6097a;
    }

    public void a(Context context) {
        this.f6097a = context != null ? context.getApplicationContext() : null;
    }
}
