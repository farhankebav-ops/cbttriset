package com.iab.omid.library.bigosg.b;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f5778a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5779b;

    private d() {
    }

    public static d a() {
        return f5778a;
    }

    public Context b() {
        return this.f5779b;
    }

    public void a(Context context) {
        this.f5779b = context != null ? context.getApplicationContext() : null;
    }
}
