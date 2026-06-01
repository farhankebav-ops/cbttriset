package okhttp3.internal.ws;

import androidx.activity.result.b;
import androidx.camera.core.processing.util.a;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import f7.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import k6.d;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.l;
import l7.m;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import q5.x;
import r2.q;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback, Lockable {
    public static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<m> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private final long webSocketCloseTimeout;
    private WebSocketWriter writer;
    private Task writerTask;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> ONLY_HTTP1 = q.j0(Protocol.HTTP_1_1);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final m reason;

        public Close(int i2, m mVar, long j) {
            this.code = i2;
            this.reason = mVar;
            this.cancelAfterCloseMillis = j;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final m getReason() {
            return this.reason;
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
    public static final class Message {
        private final m data;
        private final int formatOpcode;

        public Message(int i2, m data) {
            k.e(data, "data");
            this.formatOpcode = i2;
            this.data = data;
        }

        public final m getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final l7.k sink;
        private final l source;

        public Streams(boolean z2, l source, l7.k sink) {
            k.e(source, "source");
            k.e(sink, "sink");
            this.client = z2;
            this.source = source;
            this.sink = sink;
        }

        public abstract void cancel();

        public final boolean getClient() {
            return this.client;
        }

        public final l7.k getSink() {
            return this.sink;
        }

        public final l getSource() {
            return this.source;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e) {
                RealWebSocket.failWebSocket$default(RealWebSocket.this, e, null, true, 2, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request originalRequest, WebSocketListener listener, Random random, long j, WebSocketExtensions webSocketExtensions, long j3, long j8) {
        k.e(taskRunner, "taskRunner");
        k.e(originalRequest, "originalRequest");
        k.e(listener, "listener");
        k.e(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j3;
        this.webSocketCloseTimeout = j8;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!"GET".equals(originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
        }
        m mVar = m.f12880d;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = c.g(bArr).a();
    }

    public static /* synthetic */ void failWebSocket$default(RealWebSocket realWebSocket, Exception exc, Response response, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            response = null;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        realWebSocket.failWebSocket(exc, response, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x failWebSocket$lambda$14$lambda$13(a0 a0Var, a0 a0Var2) {
        _UtilCommonKt.closeQuietly((Closeable) a0Var.f12717a);
        Streams streams = (Streams) a0Var2.f12717a;
        if (streams != null) {
            _UtilCommonKt.closeQuietly(streams);
        }
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x finishReader$lambda$5$lambda$4(WebSocketWriter webSocketWriter) {
        _UtilCommonKt.closeQuietly(webSocketWriter);
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long initReaderAndWriter$lambda$3$lambda$2(RealWebSocket realWebSocket, long j) {
        realWebSocket.writePingFrame$okhttp();
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits == null) {
            return true;
        }
        d dVar = new d(8, 15, 1);
        int iIntValue = webSocketExtensions.serverMaxWindowBits.intValue();
        return 8 <= iIntValue && iIntValue <= dVar.f12710b;
    }

    private final void runWriter() {
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x writeOneFrame$lambda$10$lambda$9(RealWebSocket realWebSocket) {
        realWebSocket.cancel();
        return x.f13520a;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        k.b(call);
        call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        k.e(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String strHeader$default = Response.header$default(response, "Connection", null, 2, null);
        if (!"Upgrade".equalsIgnoreCase(strHeader$default)) {
            throw new ProtocolException(a.f('\'', "Expected 'Connection' header value 'Upgrade' but was '", strHeader$default));
        }
        String strHeader$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!"websocket".equalsIgnoreCase(strHeader$default2)) {
            throw new ProtocolException(a.f('\'', "Expected 'Upgrade' header value 'websocket' but was '", strHeader$default2));
        }
        String strHeader$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        m mVar = m.f12880d;
        String strA = c.e(this.key + WebSocketProtocol.ACCEPT_MAGIC).c(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1).a();
        if (k.a(strA, strHeader$default3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + strHeader$default3 + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i2, String str) {
        return close(i2, str, this.webSocketCloseTimeout);
    }

    public final void connect(OkHttpClient client) {
        k.e(client, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket$default(this, new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null, false, 6, null);
            return;
        }
        OkHttpClient okHttpClientBuild = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(okHttpClientBuild, requestBuild, true);
        this.call = realCall;
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket.connect.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                k.e(call, "call");
                k.e(e, "e");
                RealWebSocket.failWebSocket$default(RealWebSocket.this, e, null, false, 6, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws Throwable {
                k.e(call, "call");
                k.e(response, "response");
                Exchange exchange = response.exchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    k.b(exchange);
                    Streams streamsNewWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions webSocketExtensions = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = webSocketExtensions;
                    if (!RealWebSocket.this.isValid(webSocketExtensions)) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            realWebSocket.messageAndCloseQueue.clear();
                            realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    RealWebSocket.this.initReaderAndWriter(_UtilJvmKt.okHttpName + " WebSocket " + requestBuild.url().redact(), streamsNewWebSocketStreams);
                    RealWebSocket.this.loopReader(response);
                } catch (IOException e) {
                    RealWebSocket.failWebSocket$default(RealWebSocket.this, e, response, false, 4, null);
                    _UtilCommonKt.closeQuietly(response);
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                }
            }
        });
    }

    public final void failWebSocket(Exception e, Response response, boolean z2) {
        k.e(e, "e");
        a0 a0Var = new a0();
        a0 a0Var2 = new a0();
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                this.failed = true;
                Streams streams = this.streams;
                WebSocketWriter webSocketWriter = this.writer;
                a0Var2.f12717a = webSocketWriter;
                Streams streams2 = null;
                this.writer = null;
                if (webSocketWriter != null && this.reader == null) {
                    streams2 = streams;
                }
                a0Var.f12717a = streams2;
                if (!z2 && a0Var2.f12717a != null) {
                    TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new z(4, a0Var2, a0Var), 2, null);
                }
                this.taskQueue.shutdown();
                try {
                    this.listener.onFailure(this, e, response);
                    if (streams != null) {
                        streams.cancel();
                    }
                    if (z2) {
                        WebSocketWriter webSocketWriter2 = (WebSocketWriter) a0Var2.f12717a;
                        if (webSocketWriter2 != null) {
                            _UtilCommonKt.closeQuietly(webSocketWriter2);
                        }
                        Streams streams3 = (Streams) a0Var.f12717a;
                        if (streams3 != null) {
                            _UtilCommonKt.closeQuietly(streams3);
                        }
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finishReader() {
        boolean z2;
        int i2;
        String str;
        WebSocketReader webSocketReader;
        Streams streams;
        synchronized (this) {
            try {
                z2 = this.failed;
                i2 = this.receivedCloseCode;
                str = this.receivedCloseReason;
                webSocketReader = this.reader;
                this.reader = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    WebSocketWriter webSocketWriter = this.writer;
                    if (webSocketWriter != null) {
                        this.writer = null;
                        TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new b(webSocketWriter, 14), 2, null);
                    }
                    this.taskQueue.shutdown();
                }
                streams = this.writer == null ? this.streams : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2 && streams != null && this.receivedCloseCode != -1) {
            WebSocketListener webSocketListener = this.listener;
            k.b(str);
            webSocketListener.onClosed(this, i2, str);
        }
        if (webSocketReader != null) {
            _UtilCommonKt.closeQuietly(webSocketReader);
        }
        if (streams != null) {
            _UtilCommonKt.closeQuietly(streams);
        }
    }

    public final Call getCall$okhttp() {
        return this.call;
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String name, Streams streams) throws Throwable {
        Throwable th;
        k.e(name, "name");
        k.e(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        k.b(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = name;
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j = this.pingIntervalMillis;
                if (j != 0) {
                    try {
                        long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                        this.taskQueue.schedule(name.concat(" ping"), nanos, new okhttp3.internal.http2.b(this, nanos, 1));
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
                this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public final void loopReader(Response response) throws IOException {
        k.e(response, "response");
        try {
            try {
                this.listener.onOpen(this, response);
                while (this.receivedCloseCode == -1) {
                    WebSocketReader webSocketReader = this.reader;
                    k.b(webSocketReader);
                    webSocketReader.processNextFrame();
                }
            } catch (Exception e) {
                failWebSocket$default(this, e, null, false, 6, null);
                finishReader();
            }
        } finally {
            finishReader();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i2, String reason) {
        k.e(reason, "reason");
        if (i2 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i2;
            this.receivedCloseReason = reason;
        }
        this.listener.onClosing(this, i2, reason);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String text) throws IOException {
        k.e(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(m payload) {
        try {
            k.e(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(m payload) {
        k.e(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(m payload) {
        try {
            k.e(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            k.b(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket$default(this, e, null, false, 6, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String text) {
        k.e(text, "text");
        m mVar = m.f12880d;
        return send(c.e(text), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void setCall$okhttp(Call call) {
        this.call = call;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088 A[Catch: all -> 0x0091, TRY_ENTER, TryCatch #0 {all -> 0x0091, blocks: (B:33:0x0088, B:36:0x0093, B:38:0x0097, B:39:0x00a7, B:41:0x00b6, B:44:0x00b9, B:45:0x00ba, B:46:0x00bb, B:48:0x00bf, B:50:0x00d1, B:57:0x00e5, B:58:0x00ea, B:40:0x00a8), top: B:66:0x0086, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[Catch: all -> 0x0091, TryCatch #0 {all -> 0x0091, blocks: (B:33:0x0088, B:36:0x0093, B:38:0x0097, B:39:0x00a7, B:41:0x00b6, B:44:0x00b9, B:45:0x00ba, B:46:0x00bb, B:48:0x00bf, B:50:0x00d1, B:57:0x00e5, B:58:0x00ea, B:40:0x00a8), top: B:66:0x0086, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e1  */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter == null) {
                    return;
                }
                int i2 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                if (i2 != -1) {
                    StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                    sb.append(this.pingIntervalMillis);
                    sb.append("ms (after ");
                    failWebSocket$default(this, new SocketTimeoutException(a1.a.q(sb, " successful ping/pongs)", i2 - 1)), null, true, 2, null);
                    return;
                }
                try {
                    webSocketWriter.writePing(m.f12880d);
                } catch (IOException e) {
                    failWebSocket$default(this, e, null, true, 2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean close(int i2, String str, long j) {
        m mVarE;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i2);
            if (str != null) {
                m mVar = m.f12880d;
                mVarE = c.e(str);
                if (mVarE.f12881a.length > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                }
            } else {
                mVarE = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i2, mVarE, j));
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(m bytes) throws IOException {
        k.e(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.WebSocket
    public boolean send(m bytes) {
        k.e(bytes, "bytes");
        return send(bytes, 2);
    }

    private final synchronized boolean send(m mVar, int i2) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) mVar.d()) > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += (long) mVar.d();
            this.messageAndCloseQueue.add(new Message(i2, mVar));
            runWriter();
            return true;
        }
        return false;
    }
}
