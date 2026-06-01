package com.iab.omid.library.unity3d.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f6086c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.unity3d.adsession.a> f6087a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.unity3d.adsession.a> f6088b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f6086c;
    }

    public Collection<com.iab.omid.library.unity3d.adsession.a> a() {
        return Collections.unmodifiableCollection(this.f6088b);
    }

    public Collection<com.iab.omid.library.unity3d.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f6087a);
    }

    public boolean d() {
        return this.f6088b.size() > 0;
    }

    public void a(com.iab.omid.library.unity3d.adsession.a aVar) {
        this.f6087a.add(aVar);
    }

    public void b(com.iab.omid.library.unity3d.adsession.a aVar) {
        boolean zD = d();
        this.f6087a.remove(aVar);
        this.f6088b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        h.c().e();
    }

    public void c(com.iab.omid.library.unity3d.adsession.a aVar) {
        boolean zD = d();
        this.f6088b.add(aVar);
        if (zD) {
            return;
        }
        h.c().d();
    }
}
