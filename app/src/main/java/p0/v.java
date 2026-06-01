package p0;

import android.content.Context;
import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static volatile l e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0.a f13312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y0.a f13313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u0.c f13314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v0.f f13315d;

    public v(y0.a aVar, y0.a aVar2, u0.c cVar, v0.f fVar, j4.h hVar) {
        this.f13312a = aVar;
        this.f13313b = aVar2;
        this.f13314c = cVar;
        this.f13315d = fVar;
        ((Executor) hVar.f12231a).execute(new com.vungle.ads.internal.omsdk.a(hVar, 12));
    }

    public static v a() {
        l lVar = e;
        if (lVar != null) {
            return (v) lVar.g.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (v.class) {
                try {
                    if (e == null) {
                        l0.c cVar = new l0.c();
                        context.getClass();
                        cVar.f12732a = context;
                        e = cVar.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final t c(m mVar) {
        byte[] bytes;
        Set setUnmodifiableSet = mVar != null ? Collections.unmodifiableSet(n0.a.f13042d) : Collections.singleton(new m0.c("proto"));
        mVar.getClass();
        n0.a aVar = (n0.a) mVar;
        String str = aVar.f13044a;
        String str2 = aVar.f13045b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = a1.a.n("1$", str, "\\", str2).getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
        }
        return new t(setUnmodifiableSet, new k("cct", bytes, m0.e.f12921a), this);
    }
}
