package okhttp3.internal.connection;

import kotlin.jvm.internal.k;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.internal.connection.RoutePlanner;
import r5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ForceConnectRoutePlanner implements RoutePlanner {
    private final RealRoutePlanner delegate;

    public ForceConnectRoutePlanner(RealRoutePlanner delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public Address getAddress() {
        return this.delegate.getAddress();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public i getDeferredPlans() {
        return this.delegate.getDeferredPlans();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean hasNext(RealConnection realConnection) {
        return this.delegate.hasNext(realConnection);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public RoutePlanner.Plan plan() {
        return this.delegate.planConnect$okhttp();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean sameHostAndPort(HttpUrl url) {
        k.e(url, "url");
        return this.delegate.sameHostAndPort(url);
    }
}
