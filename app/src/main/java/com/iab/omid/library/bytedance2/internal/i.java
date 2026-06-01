package com.iab.omid.library.bytedance2.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.bytedance2.internal.d;
import com.iab.omid.library.bytedance2.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class i implements com.iab.omid.library.bytedance2.devicevolume.c, d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f5891f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5892a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.devicevolume.e f5893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.devicevolume.b f5894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.devicevolume.d f5895d;
    private c e;

    public i(com.iab.omid.library.bytedance2.devicevolume.e eVar, com.iab.omid.library.bytedance2.devicevolume.b bVar) {
        this.f5893b = eVar;
        this.f5894c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static i c() {
        if (f5891f == null) {
            f5891f = new i(new com.iab.omid.library.bytedance2.devicevolume.e(), new com.iab.omid.library.bytedance2.devicevolume.b());
        }
        return f5891f;
    }

    public float b() {
        return this.f5892a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f5895d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f5895d.d();
    }

    @Override // com.iab.omid.library.bytedance2.devicevolume.c
    public void a(float f4) {
        this.f5892a = f4;
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f4);
        }
    }

    public void a(Context context) {
        this.f5895d = this.f5893b.a(new Handler(), context, this.f5894c.a(), this);
    }

    @Override // com.iab.omid.library.bytedance2.internal.d.a
    public void a(boolean z2) {
        if (z2) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
