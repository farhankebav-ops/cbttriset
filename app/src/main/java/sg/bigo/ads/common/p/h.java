package sg.bigo.ads.common.p;

import android.content.Context;
import java.io.File;
import sg.bigo.ads.common.o;

/* JADX INFO: loaded from: classes6.dex */
public final class h extends sg.bigo.ads.common.p.a {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f15921a = new h(0);
    }

    private h() {
        this.f15852b = new sg.bigo.ads.common.h.a.a();
    }

    @Override // sg.bigo.ads.common.p.a
    public final String a() {
        return "ImageLoader";
    }

    @Override // sg.bigo.ads.common.p.a
    public final int b() {
        return this.f15852b.a();
    }

    @Override // sg.bigo.ads.common.p.a
    public final String c(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.e(context));
        return a1.a.r(sb, File.separator, str);
    }

    public /* synthetic */ h(byte b8) {
        this();
    }

    @Override // sg.bigo.ads.common.p.a
    public final sg.bigo.ads.common.c a(Context context, String str) {
        return c.a(context).f15907b.get(str);
    }

    @Override // sg.bigo.ads.common.p.a
    public final String b(Context context) {
        return o.e(context);
    }

    @Override // sg.bigo.ads.common.p.a
    public final void a(Context context) {
        c.a(context).f15907b.evictAll();
    }

    @Override // sg.bigo.ads.common.p.a
    public final void b(Context context, String str) {
        c.a(context).f15907b.remove(str);
    }

    @Override // sg.bigo.ads.common.p.a
    public final void a(Context context, String str, sg.bigo.ads.common.c cVar) {
        c cVarA = c.a(context);
        if (cVar.f15587a.isRecycled()) {
            return;
        }
        cVarA.f15907b.put(str, cVar);
        sg.bigo.ads.common.t.a.a(0, 3, "BitmapCacheManager", "The left cache size: " + (c.f15906a.get() - cVarA.f15907b.size()));
    }
}
