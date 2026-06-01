package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.jvm.internal.k;
import okhttp3.Address;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.platform.Platform;
import r5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RealRoutePlanner implements RoutePlanner {
    private final Address address;
    private final RealConnectionPool connectionPool;
    private final ConnectionUser connectionUser;
    private final i deferredPlans;
    private final boolean fastFallback;
    private Route nextRouteToTry;
    private final int pingIntervalMillis;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;
    private final int socketConnectTimeoutMillis;
    private final int socketReadTimeoutMillis;
    private final TaskRunner taskRunner;
    private final int writeTimeoutMillis;

    public RealRoutePlanner(TaskRunner taskRunner, RealConnectionPool connectionPool, int i2, int i8, int i9, int i10, int i11, boolean z2, boolean z7, Address address, RouteDatabase routeDatabase, ConnectionUser connectionUser) {
        k.e(taskRunner, "taskRunner");
        k.e(connectionPool, "connectionPool");
        k.e(address, "address");
        k.e(routeDatabase, "routeDatabase");
        k.e(connectionUser, "connectionUser");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = i2;
        this.writeTimeoutMillis = i8;
        this.socketConnectTimeoutMillis = i9;
        this.socketReadTimeoutMillis = i10;
        this.pingIntervalMillis = i11;
        this.retryOnConnectionFailure = z2;
        this.fastFallback = z7;
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.connectionUser = connectionUser;
        this.deferredPlans = new i();
    }

    private final Request createTunnelRequest(Route route) throws IOException {
        Request requestBuild = new Request.Builder().url(route.address().url()).method("CONNECT", null).header("Host", _UtilJvmKt.toHostHeader(route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", _UtilCommonKt.USER_AGENT).build();
        Request requestAuthenticate = route.address().proxyAuthenticator().authenticate(route, new Response.Builder().request(requestBuild).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return requestAuthenticate == null ? requestBuild : requestAuthenticate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConnectPlan planConnectToRoute$okhttp$default(RealRoutePlanner realRoutePlanner, Route route, List list, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planConnectToRoute$okhttp(route, list);
    }

    private final ReusePlan planReuseCallConnection() {
        Socket socketReleaseConnectionNoEvents;
        boolean z2;
        RealConnection realConnectionCandidateConnection = this.connectionUser.candidateConnection();
        if (realConnectionCandidateConnection == null) {
            return null;
        }
        boolean zIsHealthy = realConnectionCandidateConnection.isHealthy(this.connectionUser.doExtensiveHealthChecks());
        synchronized (realConnectionCandidateConnection) {
            try {
                if (!zIsHealthy) {
                    z2 = !realConnectionCandidateConnection.getNoNewExchanges();
                    realConnectionCandidateConnection.setNoNewExchanges(true);
                    socketReleaseConnectionNoEvents = this.connectionUser.releaseConnectionNoEvents();
                } else if (realConnectionCandidateConnection.getNoNewExchanges() || !sameHostAndPort(realConnectionCandidateConnection.route().address().url())) {
                    socketReleaseConnectionNoEvents = this.connectionUser.releaseConnectionNoEvents();
                    z2 = false;
                } else {
                    z2 = false;
                    socketReleaseConnectionNoEvents = null;
                }
            } finally {
            }
        }
        if (this.connectionUser.candidateConnection() != null) {
            if (socketReleaseConnectionNoEvents == null) {
                return new ReusePlan(realConnectionCandidateConnection);
            }
            throw new IllegalStateException("Check failed.");
        }
        if (socketReleaseConnectionNoEvents != null) {
            _UtilJvmKt.closeQuietly(socketReleaseConnectionNoEvents);
        }
        this.connectionUser.connectionReleased(realConnectionCandidateConnection);
        this.connectionUser.connectionConnectionReleased(realConnectionCandidateConnection);
        if (socketReleaseConnectionNoEvents != null) {
            this.connectionUser.connectionConnectionClosed(realConnectionCandidateConnection);
        } else if (z2) {
            this.connectionUser.noNewExchanges(realConnectionCandidateConnection);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReusePlan planReusePooledConnection$okhttp$default(RealRoutePlanner realRoutePlanner, ConnectPlan connectPlan, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            connectPlan = null;
        }
        if ((i2 & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planReusePooledConnection$okhttp(connectPlan, list);
    }

    private final Route retryRoute(RealConnection realConnection) {
        Route route;
        synchronized (realConnection) {
            route = null;
            if (realConnection.getRouteFailureCount$okhttp() == 0 && realConnection.getNoNewExchanges() && _UtilJvmKt.canReuseConnectionFor(realConnection.route().address().url(), getAddress().url())) {
                route = realConnection.route();
            }
        }
        return route;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public Address getAddress() {
        return this.address;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public i getDeferredPlans() {
        return this.deferredPlans;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean hasNext(RealConnection realConnection) {
        RouteSelector routeSelector;
        Route routeRetryRoute;
        if (!getDeferredPlans().isEmpty() || this.nextRouteToTry != null) {
            return true;
        }
        if (realConnection != null && (routeRetryRoute = retryRoute(realConnection)) != null) {
            this.nextRouteToTry = routeRetryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection == null || !selection.hasNext()) && (routeSelector = this.routeSelector) != null) {
            return routeSelector.hasNext();
        }
        return true;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean isCanceled() {
        return this.connectionUser.isCanceled();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public RoutePlanner.Plan plan() throws IOException {
        ReusePlan reusePlanPlanReuseCallConnection = planReuseCallConnection();
        if (reusePlanPlanReuseCallConnection != null) {
            return reusePlanPlanReuseCallConnection;
        }
        ReusePlan reusePlanPlanReusePooledConnection$okhttp$default = planReusePooledConnection$okhttp$default(this, null, null, 3, null);
        if (reusePlanPlanReusePooledConnection$okhttp$default != null) {
            return reusePlanPlanReusePooledConnection$okhttp$default;
        }
        if (!getDeferredPlans().isEmpty()) {
            return (RoutePlanner.Plan) getDeferredPlans().removeFirst();
        }
        ConnectPlan connectPlanPlanConnect$okhttp = planConnect$okhttp();
        ReusePlan reusePlanPlanReusePooledConnection$okhttp = planReusePooledConnection$okhttp(connectPlanPlanConnect$okhttp, connectPlanPlanConnect$okhttp.getRoutes$okhttp());
        return reusePlanPlanReusePooledConnection$okhttp != null ? reusePlanPlanReusePooledConnection$okhttp : connectPlanPlanConnect$okhttp;
    }

    public final ConnectPlan planConnect$okhttp() throws IOException {
        Route route = this.nextRouteToTry;
        if (route != null) {
            this.nextRouteToTry = null;
            return planConnectToRoute$okhttp$default(this, route, null, 2, null);
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (selection != null && selection.hasNext()) {
            return planConnectToRoute$okhttp$default(this, selection.next(), null, 2, null);
        }
        RouteSelector routeSelector = this.routeSelector;
        if (routeSelector == null) {
            routeSelector = new RouteSelector(getAddress(), this.routeDatabase, this.connectionUser, this.fastFallback);
            this.routeSelector = routeSelector;
        }
        if (!routeSelector.hasNext()) {
            throw new IOException("exhausted all routes");
        }
        RouteSelector.Selection next = routeSelector.next();
        this.routeSelection = next;
        if (isCanceled()) {
            throw new IOException("Canceled");
        }
        return planConnectToRoute$okhttp(next.next(), next.getRoutes());
    }

    public final ConnectPlan planConnectToRoute$okhttp(Route route, List<Route> list) throws IOException {
        k.e(route, "route");
        if (route.address().sslSocketFactory() == null) {
            if (!route.address().connectionSpecs().contains(ConnectionSpec.CLEARTEXT)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String strHost = route.address().url().host();
            if (!Platform.Companion.get().isCleartextTrafficPermitted(strHost)) {
                throw new UnknownServiceException(a1.a.m("CLEARTEXT communication to ", strHost, " not permitted by network security policy"));
            }
        } else if (route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.connectionUser, this, route, list, 0, route.requiresTunnel() ? createTunnelRequest(route) : null, -1, false);
    }

    public final ReusePlan planReusePooledConnection$okhttp(ConnectPlan connectPlan, List<Route> list) {
        RealConnection realConnectionCallAcquirePooledConnection = this.connectionPool.callAcquirePooledConnection(this.connectionUser.doExtensiveHealthChecks(), getAddress(), this.connectionUser, list, connectPlan != null && connectPlan.isReady());
        if (realConnectionCallAcquirePooledConnection == null) {
            return null;
        }
        if (connectPlan != null) {
            this.nextRouteToTry = connectPlan.getRoute();
            connectPlan.closeQuietly();
        }
        this.connectionUser.connectionAcquired(realConnectionCallAcquirePooledConnection);
        this.connectionUser.connectionConnectionAcquired(realConnectionCallAcquirePooledConnection);
        return new ReusePlan(realConnectionCallAcquirePooledConnection);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean sameHostAndPort(HttpUrl url) {
        k.e(url, "url");
        HttpUrl httpUrlUrl = getAddress().url();
        return url.port() == httpUrlUrl.port() && k.a(url.host(), httpUrlUrl.host());
    }
}
