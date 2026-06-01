package com.iab.omid.library.ironsrc.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.ironsrc.internal.d;
import com.iab.omid.library.ironsrc.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class i implements d.a, com.iab.omid.library.ironsrc.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f5995f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5996a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.devicevolume.e f5997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.devicevolume.b f5998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.devicevolume.d f5999d;
    private c e;

    public i(com.iab.omid.library.ironsrc.devicevolume.e eVar, com.iab.omid.library.ironsrc.devicevolume.b bVar) {
        this.f5997b = eVar;
        this.f5998c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static i c() {
        if (f5995f == null) {
            f5995f = new i(new com.iab.omid.library.ironsrc.devicevolume.e(), new com.iab.omid.library.ironsrc.devicevolume.b());
        }
        return f5995f;
    }

    public float b() {
        return this.f5996a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f5999d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f5999d.d();
    }

    @Override // com.iab.omid.library.ironsrc.devicevolume.c
    public void a(float f4) {
        this.f5996a = f4;
        Iterator<com.iab.omid.library.ironsrc.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f4);
        }
    }

    public void a(Context context) {
        this.f5999d = this.f5997b.a(new Handler(), context, this.f5998c.a(), this);
    }

    @Override // com.iab.omid.library.ironsrc.internal.d.a
    public void a(boolean z2) {
        if (z2) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
