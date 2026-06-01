package sg.bigo.ads.common.p;

import android.content.Context;
import java.io.File;
import sg.bigo.ads.common.o;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends sg.bigo.ads.common.p.a {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f15912a = new d(0);
    }

    private d() {
        this.f15852b = new sg.bigo.ads.common.h.a.a();
    }

    @Override // sg.bigo.ads.common.p.a
    public final String a() {
        return "IconLoader";
    }

    @Override // sg.bigo.ads.common.p.a
    public final int b() {
        sg.bigo.ads.common.h.a.a aVar = this.f15852b;
        if (aVar.f15741b == 0) {
            return Integer.MAX_VALUE;
        }
        return aVar.f15742c;
    }

    @Override // sg.bigo.ads.common.p.a
    public final String c(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.f(context));
        return a1.a.r(sb, File.separator, str);
    }

    public /* synthetic */ d(byte b8) {
        this();
    }

    @Override // sg.bigo.ads.common.p.a
    public final sg.bigo.ads.common.c a(Context context, String str) {
        return c.a(context).f15908c.get(str);
    }

    @Override // sg.bigo.ads.common.p.a
    public final String b(Context context) {
        return o.f(context);
    }

    @Override // sg.bigo.ads.common.p.a
    public final void a(Context context) {
        c.a(context).f15908c.evictAll();
    }

    @Override // sg.bigo.ads.common.p.a
    public final void b(Context context, String str) {
        c.a(context).f15908c.remove(str);
    }

    @Override // sg.bigo.ads.common.p.a
    public final void a(Context context, String str, sg.bigo.ads.common.c cVar) {
        c cVarA = c.a(context);
        if (cVar.f15587a.isRecycled()) {
            return;
        }
        cVarA.f15908c.put(str, cVar);
        sg.bigo.ads.common.t.a.a(0, 3, "BitmapCacheManager", "The left cache size: " + (c.f15906a.get() - cVarA.f15907b.size()));
    }
}
