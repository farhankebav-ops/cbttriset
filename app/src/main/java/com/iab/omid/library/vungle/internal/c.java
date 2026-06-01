package com.iab.omid.library.vungle.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f6188c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.vungle.adsession.a> f6189a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.vungle.adsession.a> f6190b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f6188c;
    }

    public Collection<com.iab.omid.library.vungle.adsession.a> a() {
        return Collections.unmodifiableCollection(this.f6190b);
    }

    public Collection<com.iab.omid.library.vungle.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f6189a);
    }

    public boolean d() {
        return this.f6190b.size() > 0;
    }

    public void a(com.iab.omid.library.vungle.adsession.a aVar) {
        this.f6189a.add(aVar);
    }

    public void b(com.iab.omid.library.vungle.adsession.a aVar) {
        boolean zD = d();
        this.f6189a.remove(aVar);
        this.f6190b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        i.c().e();
    }

    public void c(com.iab.omid.library.vungle.adsession.a aVar) {
        boolean zD = d();
        this.f6190b.add(aVar);
        if (zD) {
            return;
        }
        i.c().d();
    }
}
