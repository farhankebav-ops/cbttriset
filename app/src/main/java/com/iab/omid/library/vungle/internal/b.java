package com.iab.omid.library.vungle.internal;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class b extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f6187d = new b();

    private b() {
    }

    public static b g() {
        return f6187d;
    }

    @Override // com.iab.omid.library.vungle.internal.d
    public void b(boolean z2) {
        Iterator<com.iab.omid.library.vungle.adsession.a> it = c.c().b().iterator();
        while (it.hasNext()) {
            it.next().d().a(z2);
        }
    }

    @Override // com.iab.omid.library.vungle.internal.d
    public boolean d() {
        Iterator<com.iab.omid.library.vungle.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            View viewE = it.next().e();
            if (viewE != null && viewE.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
