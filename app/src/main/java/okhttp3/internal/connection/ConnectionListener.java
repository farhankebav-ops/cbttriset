package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Route;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ConnectionListener {
    public static final Companion Companion = new Companion(null);
    private static final ConnectionListener NONE = new ConnectionListener() { // from class: okhttp3.internal.connection.ConnectionListener$Companion$NONE$1
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final ConnectionListener getNONE() {
            return ConnectionListener.NONE;
        }

        private Companion() {
        }
    }

    public void connectEnd(Connection connection, Route route, Call call) {
        k.e(connection, "connection");
        k.e(route, "route");
        k.e(call, "call");
    }

    public void connectFailed(Route route, Call call, IOException failure) {
        k.e(route, "route");
        k.e(call, "call");
        k.e(failure, "failure");
    }

    public void connectStart(Route route, Call call) {
        k.e(route, "route");
        k.e(call, "call");
    }

    public void connectionAcquired(Connection connection, Call call) {
        k.e(connection, "connection");
        k.e(call, "call");
    }

    public void connectionClosed(Connection connection) {
        k.e(connection, "connection");
    }

    public void connectionReleased(Connection connection, Call call) {
        k.e(connection, "connection");
        k.e(call, "call");
    }

    public void noNewExchanges(Connection connection) {
        k.e(connection, "connection");
    }
}
