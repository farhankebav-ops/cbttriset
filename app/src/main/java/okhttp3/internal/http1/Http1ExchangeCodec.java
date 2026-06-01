package okhttp3.internal.http1;

import androidx.camera.core.processing.util.a;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import l7.j;
import l7.k;
import l7.l;
import l7.n0;
import l7.o0;
import l7.r0;
import l7.x;
import n6.m;
import n6.t;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final ExchangeCodec.Carrier carrier;
    private final OkHttpClient client;
    private final HeadersReader headersReader;
    private final k sink;
    private final l source;
    private int state;
    private Headers trailers;
    public static final Companion Companion = new Companion(null);
    private static final Headers TRAILERS_RESPONSE_BODY_TRUNCATED = Headers.Companion.of("OkHttp-Response-Body", "Truncated");

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public abstract class AbstractSource implements o0 {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final x timeout;
        private final HttpUrl url;

        public AbstractSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            kotlin.jvm.internal.k.e(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.url = url;
            this.timeout = new x(http1ExchangeCodec.source.timeout());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close() throws IOException;

        public final boolean getClosed() {
            return this.closed;
        }

        public final x getTimeout() {
            return this.timeout;
        }

        public final HttpUrl getUrl() {
            return this.url;
        }

        @Override // l7.o0
        public long read(j sink, long j) throws IOException {
            kotlin.jvm.internal.k.e(sink, "sink");
            try {
                return this.this$0.source.read(sink, j);
            } catch (IOException e) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw e;
            }
        }

        public final void responseBodyComplete(Headers trailers) {
            OkHttpClient okHttpClient;
            CookieJar cookieJar;
            kotlin.jvm.internal.k.e(trailers, "trailers");
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state != 5) {
                throw new IllegalStateException("state: " + this.this$0.state);
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.trailers = trailers;
            this.this$0.state = 6;
            if (trailers.size() <= 0 || (okHttpClient = this.this$0.client) == null || (cookieJar = okHttpClient.cookieJar()) == null) {
                return;
            }
            HttpHeaders.receiveHeaders(cookieJar, this.url, trailers);
        }

        public final void setClosed(boolean z2) {
            this.closed = z2;
        }

        @Override // l7.o0
        public r0 timeout() {
            return this.timeout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ChunkedSink implements n0 {
        private boolean closed;
        private final x timeout;

        public ChunkedSink() {
            this.timeout = new x(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.sink.C("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // l7.n0, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // l7.n0
        public r0 timeout() {
            return this.timeout;
        }

        @Override // l7.n0
        public void write(j source, long j) {
            kotlin.jvm.internal.k.e(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1ExchangeCodec.this.sink.Q(j);
            Http1ExchangeCodec.this.sink.C("\r\n");
            Http1ExchangeCodec.this.sink.write(source, j);
            Http1ExchangeCodec.this.sink.C("\r\n");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            super(http1ExchangeCodec, url);
            kotlin.jvm.internal.k.e(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() throws ProtocolException {
            if (this.bytesRemainingInChunk != -1) {
                this.this$0.source.D();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.source.U();
                String string = m.T0(this.this$0.source.D()).toString();
                if (this.bytesRemainingInChunk < 0 || (string.length() > 0 && !t.n0(string, ";", false))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string + '\"');
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    responseBodyComplete(this.this$0.headersReader.readHeaders());
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, l7.o0
        public long read(j sink, long j) throws IOException {
            kotlin.jvm.internal.k.e(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(a.j("byteCount < 0: ", j).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j3 = this.bytesRemainingInChunk;
            if (j3 == 0 || j3 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long j8 = super.read(sink, Math.min(j, this.bytesRemainingInChunk));
            if (j8 != -1) {
                this.bytesRemainingInChunk -= j8;
                return j8;
            }
            this.this$0.getCarrier().noNewExchanges();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            throw protocolException;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl url, long j) {
            super(http1ExchangeCodec, url);
            kotlin.jvm.internal.k.e(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.bytesRemaining = j;
            if (j == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, l7.o0
        public long read(j sink, long j) throws IOException {
            kotlin.jvm.internal.k.e(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(a.j("byteCount < 0: ", j).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            long j3 = this.bytesRemaining;
            if (j3 == 0) {
                return -1L;
            }
            long j8 = super.read(sink, Math.min(j3, j));
            if (j8 == -1) {
                this.this$0.getCarrier().noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw protocolException;
            }
            long j9 = this.bytesRemaining - j8;
            this.bytesRemaining = j9;
            if (j9 == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
            return j8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class KnownLengthSink implements n0 {
        private boolean closed;
        private final x timeout;

        public KnownLengthSink() {
            this.timeout = new x(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // l7.n0, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // l7.n0
        public r0 timeout() {
            return this.timeout;
        }

        @Override // l7.n0
        public void write(j source, long j) {
            kotlin.jvm.internal.k.e(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            _UtilCommonKt.checkOffsetAndCount(source.f12868b, 0L, j);
            Http1ExchangeCodec.this.sink.write(source, j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            super(http1ExchangeCodec, url);
            kotlin.jvm.internal.k.e(url, "url");
            this.this$0 = http1ExchangeCodec;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, l7.o0
        public long read(j sink, long j) throws IOException {
            kotlin.jvm.internal.k.e(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(a.j("byteCount < 0: ", j).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j3 = super.read(sink, j);
            if (j3 != -1) {
                return j3;
            }
            this.inputExhausted = true;
            responseBodyComplete(Headers.EMPTY);
            return -1L;
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, ExchangeCodec.Carrier carrier, l source, k sink) {
        kotlin.jvm.internal.k.e(carrier, "carrier");
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(sink, "sink");
        this.client = okHttpClient;
        this.carrier = carrier;
        this.source = source;
        this.sink = sink;
        this.headersReader = new HeadersReader(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachTimeout(x xVar) {
        r0 r0Var = xVar.f12907a;
        r0 delegate = r0.NONE;
        kotlin.jvm.internal.k.e(delegate, "delegate");
        xVar.f12907a = delegate;
        r0Var.clearDeadline();
        r0Var.clearTimeout();
    }

    private final boolean isChunked(Response response) {
        return "chunked".equalsIgnoreCase(Response.header$default(response, "Transfer-Encoding", null, 2, null));
    }

    private final n0 newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final o0 newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final o0 newFixedLengthSource(HttpUrl httpUrl, long j) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(this, httpUrl, j);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final n0 newKnownLengthSink() {
        if (this.state == 1) {
            this.state = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final o0 newUnknownLengthSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            getCarrier().noNewExchanges();
            return new UnknownLengthSource(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getCarrier().mo3601cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public n0 createRequestBody(Request request, long j) throws ProtocolException {
        kotlin.jvm.internal.k.e(request, "request");
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null && requestBodyBody.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (isChunked(request)) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public boolean isResponseComplete() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public o0 openResponseBodySource(Response response) {
        kotlin.jvm.internal.k.e(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(response.request().url(), 0L);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        }
        long jHeadersContentLength = _UtilJvmKt.headersContentLength(response);
        return jHeadersContentLength != -1 ? newFixedLengthSource(response.request().url(), jHeadersContentLength) : newUnknownLengthSource(response.request().url());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers peekTrailers() throws IOException {
        Headers headers = this.trailers;
        if (headers == TRAILERS_RESPONSE_BODY_TRUNCATED) {
            throw new IOException("Trailers cannot be read because the response body was truncated");
        }
        int i2 = this.state;
        if (i2 == 5 || i2 == 6) {
            return headers;
        }
        throw new IllegalStateException(("Trailers cannot be read because the state is " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z2) {
        int i2 = this.state;
        if (i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            StatusLine statusLine = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder builderHeaders = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(this.headersReader.readHeaders());
            if (z2 && statusLine.code == 100) {
                return null;
            }
            int i8 = statusLine.code;
            if (i8 == 100) {
                this.state = 3;
                return builderHeaders;
            }
            if (102 > i8 || i8 >= 200) {
                this.state = 4;
                return builderHeaders;
            }
            this.state = 3;
            return builderHeaders;
        } catch (EOFException e) {
            throw new IOException(a1.a.l("unexpected end of stream on ", getCarrier().getRoute().address().url().redact()), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        kotlin.jvm.internal.k.e(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (isChunked(response)) {
            return -1L;
        }
        return _UtilJvmKt.headersContentLength(response);
    }

    public final void skipConnectBody(Response response) {
        kotlin.jvm.internal.k.e(response, "response");
        long jHeadersContentLength = _UtilJvmKt.headersContentLength(response);
        if (jHeadersContentLength == -1) {
            return;
        }
        o0 o0VarNewFixedLengthSource = newFixedLengthSource(response.request().url(), jHeadersContentLength);
        _UtilJvmKt.skipAll(o0VarNewFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        o0VarNewFixedLengthSource.close();
    }

    public final void writeRequest(Headers headers, String requestLine) {
        kotlin.jvm.internal.k.e(headers, "headers");
        kotlin.jvm.internal.k.e(requestLine, "requestLine");
        if (this.state != 0) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.sink.C(requestLine).C("\r\n");
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.sink.C(headers.name(i2)).C(": ").C(headers.value(i2)).C("\r\n");
        }
        this.sink.C("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        kotlin.jvm.internal.k.e(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getCarrier().getRoute().proxy().type();
        kotlin.jvm.internal.k.d(type, "type(...)");
        writeRequest(request.headers(), requestLine.get(request, type));
    }

    private final boolean isChunked(Request request) {
        return "chunked".equalsIgnoreCase(request.header("Transfer-Encoding"));
    }
}
