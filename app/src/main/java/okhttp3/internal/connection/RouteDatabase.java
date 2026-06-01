package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;
import okhttp3.Route;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RouteDatabase {
    private final Set<Route> _failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        k.e(route, "route");
        this._failedRoutes.remove(route);
    }

    public final synchronized void failed(Route failedRoute) {
        k.e(failedRoute, "failedRoute");
        this._failedRoutes.add(failedRoute);
    }

    public final synchronized Set<Route> getFailedRoutes() {
        return l.r1(this._failedRoutes);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        k.e(route, "route");
        return this._failedRoutes.contains(route);
    }
}
