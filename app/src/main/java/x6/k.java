package x6;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import v6.u;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f17819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f17821d;
    public static final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f17822f;

    static {
        String property;
        int i2 = u.f17650a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f17818a = property;
        f17819b = v6.a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, LocationRequestCompat.PASSIVE_INTERVAL);
        int i8 = u.f17650a;
        if (i8 < 2) {
            i8 = 2;
        }
        f17820c = v6.a.j(i8, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f17821d = v6.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        e = TimeUnit.SECONDS.toNanos(v6.a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, LocationRequestCompat.PASSIVE_INTERVAL));
        f17822f = g.f17813a;
    }
}
