package i4;

import j4.p3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q0 f11934d;
    public static final List e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f11935a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f11936b = new LinkedHashMap();

    static {
        Logger logger = Logger.getLogger(q0.class.getName());
        f11933c = logger;
        ArrayList arrayList = new ArrayList();
        try {
            boolean z2 = p3.f12369a;
            arrayList.add(p3.class);
        } catch (ClassNotFoundException e4) {
            logger.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e4);
        }
        try {
            arrayList.add(q4.y.class);
        } catch (ClassNotFoundException e8) {
            logger.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e8);
        }
        e = Collections.unmodifiableList(arrayList);
    }

    public static synchronized q0 b() {
        try {
            if (f11934d == null) {
                List<p0> listH = f.h(p0.class, e, p0.class.getClassLoader(), new j(6));
                f11934d = new q0();
                for (p0 p0Var : listH) {
                    f11933c.fine("Service loader found " + p0Var);
                    f11934d.a(p0Var);
                }
                f11934d.d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f11934d;
    }

    public final synchronized void a(p0 p0Var) {
        p0Var.getClass();
        this.f11935a.add(p0Var);
    }

    public final synchronized p0 c(String str) {
        LinkedHashMap linkedHashMap;
        linkedHashMap = this.f11936b;
        r2.q.D(str, "policy");
        return (p0) linkedHashMap.get(str);
    }

    public final synchronized void d() {
        this.f11936b.clear();
        for (p0 p0Var : this.f11935a) {
            String strA = p0Var.a();
            if (((p0) this.f11936b.get(strA)) == null) {
                this.f11936b.put(strA, p0Var);
            }
        }
    }
}
