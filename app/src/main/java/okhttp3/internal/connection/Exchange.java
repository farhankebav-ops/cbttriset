package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.jvm.internal.k;
import l7.b;
import l7.j;
import l7.n0;
import l7.o0;
import l7.v;
import l7.w;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class RequestBodySink extends v {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, n0 delegate, long j) {
            super(delegate);
            k.e(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
        }

        private final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return (E) Exchange.bodyComplete$default(this.this$0, this.bytesReceived, false, true, e, 2, null);
        }

        @Override // l7.v, l7.n0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // l7.v, l7.n0, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // l7.v, l7.n0
        public void write(j source, long j) throws IOException {
            k.e(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j3 = this.contentLength;
            if (j3 == -1 || this.bytesReceived + j <= j3) {
                try {
                    super.write(source, j);
                    this.bytesReceived += j;
                    return;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ResponseBodySource extends w {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, o0 delegate, long j) {
            super(delegate);
            k.e(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
            this.invokeStartEvent = true;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // l7.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            if (e == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return (E) Exchange.bodyComplete$default(this.this$0, this.bytesReceived, true, false, e, 4, null);
        }

        @Override // l7.w, l7.o0
        public long read(j sink, long j) throws IOException {
            k.e(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long j3 = delegate().read(sink, j);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (j3 == -1) {
                    complete(null);
                    return -1L;
                }
                long j8 = this.bytesReceived + j3;
                long j9 = this.contentLength;
                if (j9 != -1 && j8 > j9) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j8);
                }
                this.bytesReceived = j8;
                if (this.this$0.codec.isResponseComplete()) {
                    complete(null);
                }
                return j3;
            } catch (IOException e) {
                throw complete(e);
            }
        }
    }

    public Exchange(RealCall call, EventListener eventListener, ExchangeFinder finder, ExchangeCodec codec) {
        k.e(call, "call");
        k.e(eventListener, "eventListener");
        k.e(finder, "finder");
        k.e(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
    }

    public static /* synthetic */ IOException bodyComplete$default(Exchange exchange, long j, boolean z2, boolean z7, IOException iOException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = -1;
        }
        return exchange.bodyComplete(j, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z7, iOException);
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.codec.getCarrier().trackFailure(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long j, boolean z2, boolean z7, E e) {
        if (e != null) {
            trackFailure(e);
        }
        if (z7) {
            if (e != null) {
                this.eventListener.requestFailed(this.call, e);
            } else {
                this.eventListener.requestBodyEnd(this.call, j);
            }
        }
        if (z2) {
            if (e != null) {
                this.eventListener.responseFailed(this.call, e);
            } else {
                this.eventListener.responseBodyEnd(this.call, j);
            }
        }
        return (E) this.call.messageDone$okhttp(this, z7, z2, e);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final n0 createRequestBody(Request request, boolean z2) throws IOException {
        k.e(request, "request");
        this.isDuplex = z2;
        RequestBody requestBodyBody = request.body();
        k.b(requestBodyBody);
        long jContentLength = requestBodyBody.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, jContentLength), jContentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        RealConnection realConnection = carrier instanceof RealConnection ? (RealConnection) carrier : null;
        if (realConnection != null) {
            return realConnection;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !k.a(this.finder.getRoutePlanner().getAddress().url().host(), this.codec.getCarrier().getRoute().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        k.c(carrier, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        return ((RealConnection) carrier).newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getCarrier().noNewExchanges();
    }

    public final void noRequestBody() {
        RealCall.messageDone$okhttp$default(this.call, this, true, false, null, 4, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        k.e(response, "response");
        try {
            String strHeader$default = Response.header$default(response, "Content-Type", null, 2, null);
            long jReportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(strHeader$default, jReportedContentLength, b.c(new ResponseBodySource(this, this.codec.openResponseBodySource(response), jReportedContentLength)));
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final Headers peekTrailers() throws IOException {
        return this.codec.peekTrailers();
    }

    public final Response.Builder readResponseHeaders(boolean z2) throws IOException {
        try {
            Response.Builder responseHeaders = this.codec.readResponseHeaders(z2);
            if (responseHeaders == null) {
                return responseHeaders;
            }
            responseHeaders.initExchange$okhttp(this);
            return responseHeaders;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersEnd(Response response) {
        k.e(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete$default(this, 0L, true, true, null, 1, null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        k.e(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }
}
