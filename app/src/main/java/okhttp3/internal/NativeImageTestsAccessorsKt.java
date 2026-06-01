package okhttp3.internal;

import kotlin.jvm.internal.k;
import l7.g0;
import l7.t;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeImageTestsAccessorsKt {
    public static final Cache buildCache(g0 file, long j, t fileSystem) {
        k.e(file, "file");
        k.e(fileSystem, "fileSystem");
        return new Cache(fileSystem, file, j);
    }

    public static final void finishedAccessor(Dispatcher dispatcher, RealCall.AsyncCall call) {
        k.e(dispatcher, "<this>");
        k.e(call, "call");
        dispatcher.finished$okhttp(call);
    }

    public static final RealConnection getConnectionAccessor(Exchange exchange) {
        k.e(exchange, "<this>");
        return exchange.getConnection$okhttp();
    }

    public static final Exchange getExchangeAccessor(Response response) {
        k.e(response, "<this>");
        return response.exchange();
    }

    public static final long getIdleAtNsAccessor(RealConnection realConnection) {
        k.e(realConnection, "<this>");
        return realConnection.getIdleAtNs();
    }

    public static final void setIdleAtNsAccessor(RealConnection realConnection, long j) {
        k.e(realConnection, "<this>");
        realConnection.setIdleAtNs(j);
    }
}
