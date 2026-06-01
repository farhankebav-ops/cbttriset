package com.iab.omid.library.ironsrc.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f5977c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.ironsrc.adsession.a> f5978a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.ironsrc.adsession.a> f5979b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f5977c;
    }

    public Collection<com.iab.omid.library.ironsrc.adsession.a> a() {
        return Collections.unmodifiableCollection(this.f5979b);
    }

    public Collection<com.iab.omid.library.ironsrc.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f5978a);
    }

    public boolean d() {
        return this.f5979b.size() > 0;
    }

    public void a(com.iab.omid.library.ironsrc.adsession.a aVar) {
        this.f5978a.add(aVar);
    }

    public void b(com.iab.omid.library.ironsrc.adsession.a aVar) {
        boolean zD = d();
        this.f5978a.remove(aVar);
        this.f5979b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        i.c().e();
    }

    public void c(com.iab.omid.library.ironsrc.adsession.a aVar) {
        boolean zD = d();
        this.f5979b.add(aVar);
        if (zD) {
            return;
        }
        i.c().d();
    }
}
