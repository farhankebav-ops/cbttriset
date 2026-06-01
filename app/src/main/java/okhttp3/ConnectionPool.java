package okhttp3;

import e6.q;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.ConnectionUser;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.FastFallbackExchangeFinder;
import okhttp3.internal.connection.ForceConnectRoutePlanner;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RealRoutePlanner;
import okhttp3.internal.connection.RouteDatabase;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConnectionPool {
    private final RealConnectionPool delegate;

    public ConnectionPool(RealConnectionPool delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExchangeFinder _init_$lambda$0(TaskRunner taskRunner, int i2, int i8, int i9, int i10, int i11, boolean z2, boolean z7, RouteDatabase routeDatabase, RealConnectionPool pool, Address address, ConnectionUser user) {
        k.e(pool, "pool");
        k.e(address, "address");
        k.e(user, "user");
        return new FastFallbackExchangeFinder(new ForceConnectRoutePlanner(new RealRoutePlanner(taskRunner, pool, i2, i8, i9, i10, i11, z2, z7, address, routeDatabase, user)), taskRunner);
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.delegate.getConnectionListener$okhttp();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public /* synthetic */ ConnectionPool(int i2, long j, TimeUnit timeUnit, TaskRunner taskRunner, ConnectionListener connectionListener, int i8, int i9, int i10, int i11, int i12, boolean z2, boolean z7, RouteDatabase routeDatabase, int i13, f fVar) {
        this((i13 & 1) != 0 ? 5 : i2, (i13 & 2) != 0 ? 5L : j, (i13 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i13 & 8) != 0 ? TaskRunner.INSTANCE : taskRunner, (i13 & 16) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener, (i13 & 32) != 0 ? 10000 : i8, (i13 & 64) != 0 ? 10000 : i9, (i13 & 128) != 0 ? 10000 : i10, (i13 & 256) != 0 ? 10000 : i11, (i13 & 512) == 0 ? i12 : 10000, (i13 & 1024) != 0 ? true : z2, (i13 & 2048) == 0 ? z7 : true, (i13 & 4096) != 0 ? new RouteDatabase() : routeDatabase);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i2, long j, TimeUnit timeUnit, final TaskRunner taskRunner, ConnectionListener connectionListener, final int i8, final int i9, final int i10, final int i11, final int i12, final boolean z2, final boolean z7, final RouteDatabase routeDatabase) {
        this(new RealConnectionPool(taskRunner, i2, j, timeUnit, connectionListener, new q() { // from class: okhttp3.b
            @Override // e6.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ConnectionPool._init_$lambda$0(taskRunner, i8, i9, i10, i11, i12, z2, z7, routeDatabase, (RealConnectionPool) obj, (Address) obj2, (ConnectionUser) obj3);
            }
        }));
        k.e(timeUnit, "timeUnit");
        k.e(taskRunner, "taskRunner");
        k.e(connectionListener, "connectionListener");
        k.e(routeDatabase, "routeDatabase");
    }

    public /* synthetic */ ConnectionPool(int i2, long j, TimeUnit timeUnit, ConnectionListener connectionListener, int i8, f fVar) {
        this((i8 & 1) != 0 ? 5 : i2, (i8 & 2) != 0 ? 5L : j, (i8 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i8 & 8) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i2, long j, TimeUnit timeUnit, ConnectionListener connectionListener) {
        this(i2, j, timeUnit, TaskRunner.INSTANCE, connectionListener, 0, 0, 0, 0, 0, false, false, null, 8160, null);
        k.e(timeUnit, "timeUnit");
        k.e(connectionListener, "connectionListener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i2, long j, TimeUnit timeUnit) {
        this(i2, j, timeUnit, TaskRunner.INSTANCE, ConnectionListener.Companion.getNONE(), 0, 0, 0, 0, 0, false, false, null, 8160, null);
        k.e(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
