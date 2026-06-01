package com.iab.omid.library.unity3d.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.unity3d.internal.d;
import com.iab.omid.library.unity3d.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class h implements d.a, com.iab.omid.library.unity3d.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static h f6102f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f6103a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.devicevolume.e f6104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.devicevolume.b f6105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.unity3d.devicevolume.d f6106d;
    private c e;

    public h(com.iab.omid.library.unity3d.devicevolume.e eVar, com.iab.omid.library.unity3d.devicevolume.b bVar) {
        this.f6104b = eVar;
        this.f6105c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static h c() {
        if (f6102f == null) {
            f6102f = new h(new com.iab.omid.library.unity3d.devicevolume.e(), new com.iab.omid.library.unity3d.devicevolume.b());
        }
        return f6102f;
    }

    public float b() {
        return this.f6103a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f6106d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f6106d.d();
    }

    @Override // com.iab.omid.library.unity3d.devicevolume.c
    public void a(float f4) {
        this.f6103a = f4;
        Iterator<com.iab.omid.library.unity3d.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f4);
        }
    }

    public void a(Context context) {
        this.f6106d = this.f6104b.a(new Handler(), context, this.f6105c.a(), this);
    }

    @Override // com.iab.omid.library.unity3d.internal.d.a
    public void a(boolean z2) {
        if (z2) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
