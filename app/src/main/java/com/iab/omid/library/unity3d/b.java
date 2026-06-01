package com.iab.omid.library.unity3d;

import android.content.Context;
import com.iab.omid.library.unity3d.internal.f;
import com.iab.omid.library.unity3d.internal.h;
import com.iab.omid.library.unity3d.utils.e;
import com.iab.omid.library.unity3d.utils.g;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6070a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    public String a() {
        return "1.4.9-Unity3d";
    }

    public void c() {
        g.a();
        com.iab.omid.library.unity3d.internal.a.a().d();
    }

    public void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        h.c().a(context);
        com.iab.omid.library.unity3d.internal.b.g().a(context);
        com.iab.omid.library.unity3d.utils.a.a(context);
        com.iab.omid.library.unity3d.utils.c.a(context);
        e.a(context);
        f.b().a(context);
        com.iab.omid.library.unity3d.internal.a.a().a(context);
    }

    public boolean b() {
        return this.f6070a;
    }

    public void a(boolean z2) {
        this.f6070a = z2;
    }
}
