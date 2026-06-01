package j2;

import com.ironsource.C2300e4;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m extends k2.a implements q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f12081d = new Object();
    public static final p e = new p();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f12082f;
    public static final a.a g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f12083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f12084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile l f12085c;

    static {
        boolean z2;
        a.a fVar;
        Throwable th;
        a.a kVar;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z2 = false;
        }
        f12082f = z2;
        String property = System.getProperty("java.runtime.name", "");
        Throwable e4 = null;
        if (property == null || property.contains(C2300e4.f8279d)) {
            try {
                kVar = new k(13);
            } catch (Error | Exception e8) {
                try {
                    fVar = new e(13);
                } catch (Error | Exception e9) {
                    e4 = e9;
                    fVar = new f(13);
                }
                a.a aVar = fVar;
                th = e8;
                kVar = aVar;
            }
        } else {
            try {
                kVar = new e(13);
            } catch (NoClassDefFoundError unused2) {
                kVar = new f(13);
            }
        }
        th = null;
        g = kVar;
        if (e4 != null) {
            p pVar = e;
            Logger loggerA = pVar.a();
            Level level = Level.SEVERE;
            loggerA.log(level, "UnsafeAtomicHelper is broken!", th);
            pVar.a().log(level, "AtomicReferenceFieldUpdaterAtomicHelper is broken!", e4);
        }
    }

    public final void a(l lVar) {
        lVar.f12079a = null;
        while (true) {
            l lVar2 = this.f12085c;
            if (lVar2 == l.f12078c) {
                return;
            }
            l lVar3 = null;
            while (lVar2 != null) {
                l lVar4 = lVar2.f12080b;
                if (lVar2.f12079a != null) {
                    lVar3 = lVar2;
                } else if (lVar3 != null) {
                    lVar3.f12080b = lVar4;
                    if (lVar3.f12079a == null) {
                        break;
                    }
                } else if (!g.m(this, lVar2, lVar4)) {
                    break;
                }
                lVar2 = lVar4;
            }
            return;
        }
    }
}
