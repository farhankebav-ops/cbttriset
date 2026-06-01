package i4;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f11823d = Logger.getLogger(b0.class.getName());
    public static final b0 e = new b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentSkipListMap f11824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f11825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f11826c;

    public b0() {
        new ConcurrentSkipListMap();
        this.f11824a = new ConcurrentSkipListMap();
        this.f11825b = new ConcurrentHashMap();
        this.f11826c = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }
}
