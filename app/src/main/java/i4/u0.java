package i4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11964c = Logger.getLogger(u0.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static u0 f11965d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f11966a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f11967b = Collections.EMPTY_LIST;

    public static List b() {
        Logger logger = f11964c;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(k4.i.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e4) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e4);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e8) {
            logger.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e8);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(s0 s0Var) {
        s0Var.getClass();
        this.f11966a.add(s0Var);
    }

    public final s0 c() {
        List list;
        synchronized (this) {
            list = this.f11967b;
        }
        if (list.isEmpty()) {
            return null;
        }
        return (s0) list.get(0);
    }

    public final synchronized void d() {
        ArrayList arrayList = new ArrayList(this.f11966a);
        Collections.sort(arrayList, Collections.reverseOrder(new t0()));
        this.f11967b = Collections.unmodifiableList(arrayList);
    }
}
