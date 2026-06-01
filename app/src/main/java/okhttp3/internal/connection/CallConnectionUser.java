package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.List;
import kotlin.jvm.internal.k;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CallConnectionUser implements ConnectionUser {
    private final RealCall call;
    private final RealInterceptorChain chain;
    private final ConnectionListener poolConnectionListener;

    public CallConnectionUser(RealCall call, ConnectionListener poolConnectionListener, RealInterceptorChain chain) {
        k.e(call, "call");
        k.e(poolConnectionListener, "poolConnectionListener");
        k.e(chain, "chain");
        this.call = call;
        this.poolConnectionListener = poolConnectionListener;
        this.chain = chain;
    }

    private final EventListener getEventListener() {
        return this.call.getEventListener$okhttp();
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void acquireConnectionNoEvents(RealConnection connection) {
        k.e(connection, "connection");
        this.call.acquireConnectionNoEvents(connection);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void addPlanToCancel(ConnectPlan connectPlan) {
        k.e(connectPlan, "connectPlan");
        this.call.getPlansToCancel$okhttp().add(connectPlan);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void callConnectEnd(Route route, Protocol protocol) {
        k.e(route, "route");
        getEventListener().connectEnd(this.call, route.socketAddress(), route.proxy(), protocol);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public RealConnection candidateConnection() {
        return this.call.getConnection();
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectFailed(Route route, Protocol protocol, IOException e) {
        k.e(route, "route");
        k.e(e, "e");
        getEventListener().connectFailed(this.call, route.socketAddress(), route.proxy(), null, e);
        this.poolConnectionListener.connectFailed(route, this.call, e);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectStart(Route route) {
        k.e(route, "route");
        getEventListener().connectStart(this.call, route.socketAddress(), route.proxy());
        this.poolConnectionListener.connectStart(route, this.call);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectionAcquired(Connection connection) {
        k.e(connection, "connection");
        getEventListener().connectionAcquired(this.call, connection);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectionConnectEnd(Connection connection, Route route) {
        k.e(connection, "connection");
        k.e(route, "route");
        this.poolConnectionListener.connectEnd(connection, route, this.call);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectionConnectionAcquired(RealConnection connection) {
        k.e(connection, "connection");
        connection.getConnectionListener$okhttp().connectionAcquired(connection, this.call);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectionConnectionClosed(RealConnection connection) {
        k.e(connection, "connection");
        connection.getConnectionListener$okhttp().connectionClosed(connection);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectionConnectionReleased(RealConnection connection) {
        k.e(connection, "connection");
        connection.getConnectionListener$okhttp().connectionReleased(connection, this.call);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void connectionReleased(Connection connection) {
        k.e(connection, "connection");
        getEventListener().connectionReleased(this.call, connection);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void dnsEnd(String socketHost, List<? extends InetAddress> result) {
        k.e(socketHost, "socketHost");
        k.e(result, "result");
        getEventListener().dnsEnd(this.call, socketHost, result);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void dnsStart(String socketHost) {
        k.e(socketHost, "socketHost");
        getEventListener().dnsStart(this.call, socketHost);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public boolean doExtensiveHealthChecks() {
        return !k.a(this.chain.getRequest$okhttp().method(), "GET");
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public boolean isCanceled() {
        return this.call.isCanceled();
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void noNewExchanges(RealConnection connection) {
        k.e(connection, "connection");
        connection.getConnectionListener$okhttp().noNewExchanges(connection);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void proxySelectEnd(HttpUrl url, List<? extends Proxy> proxies) {
        k.e(url, "url");
        k.e(proxies, "proxies");
        getEventListener().proxySelectEnd(this.call, url, proxies);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void proxySelectStart(HttpUrl url) {
        k.e(url, "url");
        getEventListener().proxySelectStart(this.call, url);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public Socket releaseConnectionNoEvents() {
        return this.call.releaseConnectionNoEvents$okhttp();
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void removePlanToCancel(ConnectPlan connectPlan) {
        k.e(connectPlan, "connectPlan");
        this.call.getPlansToCancel$okhttp().remove(connectPlan);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void secureConnectEnd(Handshake handshake) {
        getEventListener().secureConnectEnd(this.call, handshake);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void secureConnectStart() {
        getEventListener().secureConnectStart(this.call);
    }

    @Override // okhttp3.internal.connection.ConnectionUser
    public void updateRouteDatabaseAfterSuccess(Route route) {
        k.e(route, "route");
        this.call.getClient().getRouteDatabase$okhttp().connected(route);
    }
}
