package com.iab.omid.library.bigosg.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.bigosg.b.b;
import com.iab.omid.library.bigosg.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class f implements com.iab.omid.library.bigosg.a.c, b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f5784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f5785b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.bigosg.a.e f5786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.iab.omid.library.bigosg.a.b f5787d;
    private com.iab.omid.library.bigosg.a.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f5788f;

    public f(com.iab.omid.library.bigosg.a.e eVar, com.iab.omid.library.bigosg.a.b bVar) {
        this.f5786c = eVar;
        this.f5787d = bVar;
    }

    public static f a() {
        if (f5784a == null) {
            f5784a = new f(new com.iab.omid.library.bigosg.a.e(), new com.iab.omid.library.bigosg.a.b());
        }
        return f5784a;
    }

    private a e() {
        if (this.f5788f == null) {
            this.f5788f = a.a();
        }
        return this.f5788f;
    }

    public void b() {
        b.a().a(this);
        b.a().b();
        if (b.a().d()) {
            TreeWalker.getInstance().a();
        }
        this.e.a();
    }

    public void c() {
        TreeWalker.getInstance().b();
        b.a().c();
        this.e.b();
    }

    public float d() {
        return this.f5785b;
    }

    @Override // com.iab.omid.library.bigosg.a.c
    public void a(float f4) {
        this.f5785b = f4;
        Iterator<com.iab.omid.library.bigosg.adsession.a> it = e().c().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f4);
        }
    }

    public void a(Context context) {
        this.e = this.f5786c.a(new Handler(), context, this.f5787d.a(), this);
    }

    @Override // com.iab.omid.library.bigosg.b.b.a
    public void a(boolean z2) {
        if (z2) {
            TreeWalker.getInstance().a();
        } else {
            TreeWalker.getInstance().c();
        }
    }
}
