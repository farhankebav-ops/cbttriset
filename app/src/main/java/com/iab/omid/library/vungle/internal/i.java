package com.iab.omid.library.vungle.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.vungle.internal.d;
import com.iab.omid.library.vungle.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class i implements d.a, com.iab.omid.library.vungle.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f6206f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f6207a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.vungle.devicevolume.e f6208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.vungle.devicevolume.b f6209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.vungle.devicevolume.d f6210d;
    private c e;

    public i(com.iab.omid.library.vungle.devicevolume.e eVar, com.iab.omid.library.vungle.devicevolume.b bVar) {
        this.f6208b = eVar;
        this.f6209c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static i c() {
        if (f6206f == null) {
            f6206f = new i(new com.iab.omid.library.vungle.devicevolume.e(), new com.iab.omid.library.vungle.devicevolume.b());
        }
        return f6206f;
    }

    public float b() {
        return this.f6207a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f6210d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f6210d.d();
    }

    @Override // com.iab.omid.library.vungle.devicevolume.c
    public void a(float f4) {
        this.f6207a = f4;
        Iterator<com.iab.omid.library.vungle.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().d().a(f4);
        }
    }

    public void a(Context context) {
        this.f6210d = this.f6208b.a(new Handler(), context, this.f6209c.a(), this);
    }

    @Override // com.iab.omid.library.vungle.internal.d.a
    public void a(boolean z2) {
        if (z2) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
