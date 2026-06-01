package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.List;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Route;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionUser {
    void acquireConnectionNoEvents(RealConnection realConnection);

    void addPlanToCancel(ConnectPlan connectPlan);

    void callConnectEnd(Route route, Protocol protocol);

    RealConnection candidateConnection();

    void connectFailed(Route route, Protocol protocol, IOException iOException);

    void connectStart(Route route);

    void connectionAcquired(Connection connection);

    void connectionConnectEnd(Connection connection, Route route);

    void connectionConnectionAcquired(RealConnection realConnection);

    void connectionConnectionClosed(RealConnection realConnection);

    void connectionConnectionReleased(RealConnection realConnection);

    void connectionReleased(Connection connection);

    void dnsEnd(String str, List<? extends InetAddress> list);

    void dnsStart(String str);

    boolean doExtensiveHealthChecks();

    boolean isCanceled();

    void noNewExchanges(RealConnection realConnection);

    void proxySelectEnd(HttpUrl httpUrl, List<? extends Proxy> list);

    void proxySelectStart(HttpUrl httpUrl);

    Socket releaseConnectionNoEvents();

    void removePlanToCancel(ConnectPlan connectPlan);

    void secureConnectEnd(Handshake handshake);

    void secureConnectStart();

    void updateRouteDatabaseAfterSuccess(Route route);
}
