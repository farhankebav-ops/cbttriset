package okhttp3.internal.http2;

import f7.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.a0;
import l7.j;
import l7.k;
import l7.l;
import l7.m;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.FlowControlListener;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import okhttp3.internal.platform.Platform;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Connection implements Closeable, Lockable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private final FlowControlListener flowControlListener;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private final WindowCounter readBytes;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private FlowControlListener flowControlListener;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public k sink;
        public Socket socket;
        public l source;
        private final TaskRunner taskRunner;

        public Builder(boolean z2, TaskRunner taskRunner) {
            kotlin.jvm.internal.k.e(taskRunner, "taskRunner");
            this.client = z2;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
            this.flowControlListener = FlowControlListener.None.INSTANCE;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, l lVar, k kVar, int i2, Object obj) throws IOException {
            if ((i2 & 2) != 0) {
                str = _UtilJvmKt.peerName(socket);
            }
            if ((i2 & 4) != 0) {
                lVar = l7.b.c(l7.b.k(socket));
            }
            if ((i2 & 8) != 0) {
                kVar = l7.b.b(l7.b.i(socket));
            }
            return builder.socket(socket, str, lVar, kVar);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final Builder flowControlListener(FlowControlListener flowControlListener) {
            kotlin.jvm.internal.k.e(flowControlListener, "flowControlListener");
            this.flowControlListener = flowControlListener;
            return this;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.k.l("connectionName");
            throw null;
        }

        public final FlowControlListener getFlowControlListener$okhttp() {
            return this.flowControlListener;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final k getSink$okhttp() {
            k kVar = this.sink;
            if (kVar != null) {
                return kVar;
            }
            kotlin.jvm.internal.k.l("sink");
            throw null;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            kotlin.jvm.internal.k.l("socket");
            throw null;
        }

        public final l getSource$okhttp() {
            l lVar = this.source;
            if (lVar != null) {
                return lVar;
            }
            kotlin.jvm.internal.k.l("source");
            throw null;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder pingIntervalMillis(int i2) {
            this.pingIntervalMillis = i2;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            kotlin.jvm.internal.k.e(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z2) {
            this.client = z2;
        }

        public final void setConnectionName$okhttp(String str) {
            kotlin.jvm.internal.k.e(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setFlowControlListener$okhttp(FlowControlListener flowControlListener) {
            kotlin.jvm.internal.k.e(flowControlListener, "<set-?>");
            this.flowControlListener = flowControlListener;
        }

        public final void setListener$okhttp(Listener listener) {
            kotlin.jvm.internal.k.e(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i2) {
            this.pingIntervalMillis = i2;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            kotlin.jvm.internal.k.e(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(k kVar) {
            kotlin.jvm.internal.k.e(kVar, "<set-?>");
            this.sink = kVar;
        }

        public final void setSocket$okhttp(Socket socket) {
            kotlin.jvm.internal.k.e(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(l lVar) {
            kotlin.jvm.internal.k.e(lVar, "<set-?>");
            this.source = lVar;
        }

        public final Builder socket(Socket socket) throws IOException {
            kotlin.jvm.internal.k.e(socket, "socket");
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public final Builder socket(Socket socket, String peerName) throws IOException {
            kotlin.jvm.internal.k.e(socket, "socket");
            kotlin.jvm.internal.k.e(peerName, "peerName");
            return socket$default(this, socket, peerName, null, null, 12, null);
        }

        public final Builder socket(Socket socket, String peerName, l source) throws IOException {
            kotlin.jvm.internal.k.e(socket, "socket");
            kotlin.jvm.internal.k.e(peerName, "peerName");
            kotlin.jvm.internal.k.e(source, "source");
            return socket$default(this, socket, peerName, source, null, 8, null);
        }

        public final Builder socket(Socket socket, String peerName, l source, k sink) throws IOException {
            String strConcat;
            kotlin.jvm.internal.k.e(socket, "socket");
            kotlin.jvm.internal.k.e(peerName, "peerName");
            kotlin.jvm.internal.k.e(source, "source");
            kotlin.jvm.internal.k.e(sink, "sink");
            setSocket$okhttp(socket);
            if (this.client) {
                strConcat = _UtilJvmKt.okHttpName + ' ' + peerName;
            } else {
                strConcat = "MockWebServer ".concat(peerName);
            }
            setConnectionName$okhttp(strConcat);
            setSource$okhttp(source);
            setSink$okhttp(sink);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream stream) throws IOException {
                kotlin.jvm.internal.k.e(stream, "stream");
                stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            private Companion() {
            }
        }

        public void onSettings(Http2Connection connection, Settings settings) {
            kotlin.jvm.internal.k.e(connection, "connection");
            kotlin.jvm.internal.k.e(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ReaderRunnable implements Http2Reader.Handler, e6.a {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader reader) {
            kotlin.jvm.internal.k.e(reader, "reader");
            this.this$0 = http2Connection;
            this.reader = reader;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x applyAndAckSettings$lambda$7$lambda$6$lambda$5(Http2Connection http2Connection, a0 a0Var) {
            http2Connection.getListener$okhttp().onSettings(http2Connection, (Settings) a0Var.f12717a);
            return x.f13520a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x headers$lambda$2$lambda$1(Http2Connection http2Connection, Http2Stream http2Stream) {
            try {
                http2Connection.getListener$okhttp().onStream(http2Stream);
            } catch (IOException e) {
                Platform.Companion.get().log("Http2Connection.Listener failure for " + http2Connection.getConnectionName$okhttp(), 4, e);
                try {
                    http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                } catch (IOException unused) {
                }
            }
            return x.f13520a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x ping$lambda$10(Http2Connection http2Connection, int i2, int i8) {
            http2Connection.writePing(true, i2, i8);
            return x.f13520a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x settings$lambda$3(ReaderRunnable readerRunnable, boolean z2, Settings settings) {
            readerRunnable.applyAndAckSettings(z2, settings);
            return x.f13520a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i2, String origin, m protocol, String host, int i8, long j) {
            kotlin.jvm.internal.k.e(origin, "origin");
            kotlin.jvm.internal.k.e(protocol, "protocol");
            kotlin.jvm.internal.k.e(host, "host");
        }

        public final void applyAndAckSettings(boolean z2, Settings settings) {
            long initialWindowSize;
            int i2;
            Http2Stream[] http2StreamArr;
            Settings settings2 = settings;
            kotlin.jvm.internal.k.e(settings2, "settings");
            a0 a0Var = new a0();
            Http2Writer writer = this.this$0.getWriter();
            Http2Connection http2Connection = this.this$0;
            synchronized (writer) {
                synchronized (http2Connection) {
                    try {
                        Settings peerSettings = http2Connection.getPeerSettings();
                        if (!z2) {
                            Settings settings3 = new Settings();
                            settings3.merge(peerSettings);
                            settings3.merge(settings2);
                            settings2 = settings3;
                        }
                        a0Var.f12717a = settings2;
                        initialWindowSize = ((long) settings2.getInitialWindowSize()) - ((long) peerSettings.getInitialWindowSize());
                        http2StreamArr = (initialWindowSize == 0 || http2Connection.getStreams$okhttp().isEmpty()) ? null : (Http2Stream[]) http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                        http2Connection.setPeerSettings((Settings) a0Var.f12717a);
                        TaskQueue.execute$default(http2Connection.settingsListenerQueue, http2Connection.getConnectionName$okhttp() + " onSettings", 0L, false, new z(3, http2Connection, a0Var), 6, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) a0Var.f12717a);
                } catch (IOException e) {
                    http2Connection.failConnection(e);
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z2, int i2, l source, int i8) throws IOException {
            kotlin.jvm.internal.k.e(source, "source");
            if (this.this$0.pushedStream$okhttp(i2)) {
                this.this$0.pushDataLater$okhttp(i2, source, i8, z2);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i2);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i2, ErrorCode.PROTOCOL_ERROR);
                long j = i8;
                this.this$0.updateConnectionFlowControl$okhttp(j);
                source.skip(j);
                return;
            }
            stream.receiveData(source, i8);
            if (z2) {
                stream.receiveHeaders(Headers.EMPTY, true);
            }
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i2, ErrorCode errorCode, m debugData) {
            int i8;
            Object[] array;
            kotlin.jvm.internal.k.e(errorCode, "errorCode");
            kotlin.jvm.internal.k.e(debugData, "debugData");
            debugData.d();
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                http2Connection.isShutdown = true;
            }
            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                if (http2Stream.getId() > i2 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z2, int i2, int i8, List<Header> headerBlock) {
            kotlin.jvm.internal.k.e(headerBlock, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i2)) {
                this.this$0.pushHeadersLater$okhttp(i2, headerBlock, z2);
                return;
            }
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(i2);
                if (stream != null) {
                    stream.receiveHeaders(_UtilJvmKt.toHeaders(headerBlock), z2);
                    return;
                }
                if (http2Connection.isShutdown) {
                    return;
                }
                if (i2 <= http2Connection.getLastGoodStreamId$okhttp()) {
                    return;
                }
                if (i2 % 2 == http2Connection.getNextStreamId$okhttp() % 2) {
                    return;
                }
                Http2Stream http2Stream = new Http2Stream(i2, http2Connection, false, z2, _UtilJvmKt.toHeaders(headerBlock));
                http2Connection.setLastGoodStreamId$okhttp(i2);
                http2Connection.getStreams$okhttp().put(Integer.valueOf(i2), http2Stream);
                TaskQueue.execute$default(http2Connection.taskRunner.newQueue(), http2Connection.getConnectionName$okhttp() + '[' + i2 + "] onStream", 0L, false, new z(2, http2Connection, http2Stream), 6, null);
            }
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            m3607invoke();
            return x.f13520a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z2, final int i2, final int i8) {
            if (!z2) {
                TaskQueue taskQueue = this.this$0.writerQueue;
                String str = this.this$0.getConnectionName$okhttp() + " ping";
                final Http2Connection http2Connection = this.this$0;
                TaskQueue.execute$default(taskQueue, str, 0L, false, new e6.a() { // from class: okhttp3.internal.http2.f
                    @Override // e6.a
                    public final Object invoke() {
                        return Http2Connection.ReaderRunnable.ping$lambda$10(http2Connection, i2, i8);
                    }
                }, 6, null);
                return;
            }
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection2) {
                try {
                    if (i2 == 1) {
                        http2Connection2.intervalPongsReceived++;
                    } else if (i2 == 2) {
                        http2Connection2.degradedPongsReceived++;
                    } else if (i2 == 3) {
                        http2Connection2.awaitPongsReceived++;
                        http2Connection2.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i2, int i8, List<Header> requestHeaders) {
            kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i8, requestHeaders);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i2, ErrorCode errorCode) {
            kotlin.jvm.internal.k.e(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i2)) {
                this.this$0.pushResetLater$okhttp(i2, errorCode);
                return;
            }
            Http2Stream http2StreamRemoveStream$okhttp = this.this$0.removeStream$okhttp(i2);
            if (http2StreamRemoveStream$okhttp != null) {
                http2StreamRemoveStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z2, final Settings settings) {
            kotlin.jvm.internal.k.e(settings, "settings");
            TaskQueue.execute$default(this.this$0.writerQueue, this.this$0.getConnectionName$okhttp() + " applyAndAckSettings", 0L, false, new e6.a() { // from class: okhttp3.internal.http2.g
                @Override // e6.a
                public final Object invoke() {
                    return Http2Connection.ReaderRunnable.settings$lambda$3(this.f13253a, z2, settings);
                }
            }, 6, null);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i2, long j) {
            if (i2 == 0) {
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(i2);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public void m3607invoke() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode3;
                    this.this$0.close$okhttp(errorCode, errorCode3, e);
                    _UtilCommonKt.closeQuietly(this.reader);
                    throw th;
                }
                try {
                    this.this$0.close$okhttp(errorCode2, ErrorCode.CANCEL, null);
                    errorCode = errorCode2;
                } catch (IOException e8) {
                    e = e8;
                    ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection http2Connection = this.this$0;
                    http2Connection.close$okhttp(errorCode4, errorCode4, e);
                    errorCode = http2Connection;
                }
                errorCode3 = this.reader;
                _UtilCommonKt.closeQuietly(errorCode3);
            } catch (Throwable th2) {
                th = th2;
                this.this$0.close$okhttp(errorCode, errorCode3, e);
                _UtilCommonKt.closeQuietly(this.reader);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i2, int i8, int i9, boolean z2) {
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(4, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        kotlin.jvm.internal.k.e(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue taskQueueNewQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = taskQueueNewQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        this.flowControlListener = builder.getFlowControlListener$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(4, 16777216);
        }
        this.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.readBytes = new WindowCounter(0);
        this.writeBytesMaximum = this.peerSettings.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            taskQueueNewQueue.schedule(a1.a.C(connectionName$okhttp, " ping"), nanos, new b(this, nanos, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _init_$lambda$2(Http2Connection http2Connection, long j) {
        boolean z2;
        synchronized (http2Connection) {
            long j3 = http2Connection.intervalPongsReceived;
            long j8 = http2Connection.intervalPingsSent;
            if (j3 < j8) {
                z2 = true;
            } else {
                http2Connection.intervalPingsSent = j8 + 1;
                z2 = false;
            }
        }
        if (z2) {
            http2Connection.failConnection(null);
            return -1L;
        }
        http2Connection.writePing(false, 1, 0);
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x pushDataLater$lambda$38(Http2Connection http2Connection, int i2, j jVar, int i8, boolean z2) {
        try {
            boolean zOnData = http2Connection.pushObserver.onData(i2, jVar, i8, z2);
            if (zOnData) {
                http2Connection.writer.rstStream(i2, ErrorCode.CANCEL);
            }
            if (zOnData || z2) {
                synchronized (http2Connection) {
                    http2Connection.currentPushRequests.remove(Integer.valueOf(i2));
                }
            }
        } catch (IOException unused) {
        }
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x pushHeadersLater$lambda$35(Http2Connection http2Connection, int i2, List list, boolean z2) {
        boolean zOnHeaders = http2Connection.pushObserver.onHeaders(i2, list, z2);
        if (zOnHeaders) {
            try {
                http2Connection.writer.rstStream(i2, ErrorCode.CANCEL);
            } catch (IOException unused) {
            }
        }
        if (zOnHeaders || z2) {
            synchronized (http2Connection) {
                http2Connection.currentPushRequests.remove(Integer.valueOf(i2));
            }
        }
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x pushRequestLater$lambda$32(Http2Connection http2Connection, int i2, List list) {
        if (http2Connection.pushObserver.onRequest(i2, list)) {
            try {
                http2Connection.writer.rstStream(i2, ErrorCode.CANCEL);
                synchronized (http2Connection) {
                    http2Connection.currentPushRequests.remove(Integer.valueOf(i2));
                }
            } catch (IOException unused) {
            }
        }
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x pushResetLater$lambda$40(Http2Connection http2Connection, int i2, ErrorCode errorCode) {
        http2Connection.pushObserver.onReset(i2, errorCode);
        synchronized (http2Connection) {
            http2Connection.currentPushRequests.remove(Integer.valueOf(i2));
        }
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x sendDegradedPingLater$lambda$28(Http2Connection http2Connection) {
        http2Connection.writePing(false, 2, 0);
        return x.f13520a;
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z2, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            z2 = true;
        }
        http2Connection.start(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x writeSynResetLater$lambda$12(Http2Connection http2Connection, int i2, ErrorCode errorCode) {
        try {
            http2Connection.writeSynReset$okhttp(i2, errorCode);
        } catch (IOException e) {
            http2Connection.failConnection(e);
        }
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x writeWindowUpdateLater$lambda$13(Http2Connection http2Connection, int i2, long j) {
        try {
            http2Connection.writer.windowUpdate(i2, j);
        } catch (IOException e) {
            http2Connection.failConnection(e);
        }
        return x.f13520a;
    }

    public final void awaitPong() throws InterruptedException {
        synchronized (this) {
            while (this.awaitPongsReceived < this.awaitPingsSent) {
                wait();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) {
        int i2;
        Object[] array;
        kotlin.jvm.internal.k.e(connectionCode, "connectionCode");
        kotlin.jvm.internal.k.e(streamCode, "streamCode");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            shutdown(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                array = null;
            } else {
                array = this.streams.values().toArray(new Http2Stream[0]);
                this.streams.clear();
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final FlowControlListener getFlowControlListener$okhttp() {
        return this.flowControlListener;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final Http2Stream getStream(int i2) {
        Http2Stream http2Stream;
        synchronized (this) {
            http2Stream = this.streams.get(Integer.valueOf(i2));
        }
        return http2Stream;
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final boolean isHealthy(long j) {
        synchronized (this) {
            if (this.isShutdown) {
                return false;
            }
            if (this.degradedPongsReceived < this.degradedPingsSent) {
                if (j >= this.degradedPongDeadlineNs) {
                    return false;
                }
            }
            return true;
        }
    }

    public final Http2Stream newStream(List<Header> requestHeaders, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        return newStream(0, requestHeaders, z2);
    }

    public final int openStreamCount() {
        int size;
        synchronized (this) {
            size = this.streams.size();
        }
        return size;
    }

    public final void pushDataLater$okhttp(final int i2, l source, final int i8, final boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        final j jVar = new j();
        long j = i8;
        source.F(j);
        source.read(jVar, j);
        TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i2 + "] onData", 0L, false, new e6.a() { // from class: okhttp3.internal.http2.a
            @Override // e6.a
            public final Object invoke() {
                return Http2Connection.pushDataLater$lambda$38(this.f13232a, i2, jVar, i8, z2);
            }
        }, 6, null);
    }

    public final void pushHeadersLater$okhttp(final int i2, final List<Header> requestHeaders, final boolean z2) {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i2 + "] onHeaders", 0L, false, new e6.a() { // from class: okhttp3.internal.http2.e
            @Override // e6.a
            public final Object invoke() {
                return Http2Connection.pushHeadersLater$lambda$35(this.f13246a, i2, requestHeaders, z2);
            }
        }, 6, null);
    }

    public final void pushRequestLater$okhttp(int i2, List<Header> requestHeaders) {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i2))) {
                writeSynResetLater$okhttp(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i2));
            TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i2 + "] onRequest", 0L, false, new f7.x(this, i2, requestHeaders), 6, null);
        }
    }

    public final void pushResetLater$okhttp(int i2, ErrorCode errorCode) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i2 + "] onReset", 0L, false, new d(this, i2, errorCode, 1), 6, null);
    }

    public final Http2Stream pushStream(int i2, List<Header> requestHeaders, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return newStream(i2, requestHeaders, z2);
    }

    public final boolean pushedStream$okhttp(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public final Http2Stream removeStream$okhttp(int i2) {
        Http2Stream http2StreamRemove;
        synchronized (this) {
            http2StreamRemove = this.streams.remove(Integer.valueOf(i2));
            notifyAll();
        }
        return http2StreamRemove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j = this.degradedPongsReceived;
            long j3 = this.degradedPingsSent;
            if (j < j3) {
                return;
            }
            this.degradedPingsSent = j3 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
            TaskQueue.execute$default(this.writerQueue, a1.a.r(new StringBuilder(), this.connectionName, " ping"), 0L, false, new androidx.activity.result.b(this, 12), 6, null);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i2) {
        this.lastGoodStreamId = i2;
    }

    public final void setNextStreamId$okhttp(int i2) {
        this.nextStreamId = i2;
    }

    public final void setPeerSettings(Settings settings) {
        kotlin.jvm.internal.k.e(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(Settings settings) throws IOException {
        kotlin.jvm.internal.k.e(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(ErrorCode statusCode) throws IOException {
        kotlin.jvm.internal.k.e(statusCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                this.writer.goAway(this.lastGoodStreamId, statusCode, _UtilCommonKt.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void start() throws IOException {
        start$default(this, false, 1, null);
    }

    public final void updateConnectionFlowControl$okhttp(long j) {
        synchronized (this) {
            try {
                WindowCounter.update$default(this.readBytes, j, 0L, 2, null);
                long unacknowledged = this.readBytes.getUnacknowledged();
                if (unacknowledged >= this.okHttpSettings.getInitialWindowSize() / 2) {
                    writeWindowUpdateLater$okhttp(0, unacknowledged);
                    WindowCounter.update$default(this.readBytes, 0L, unacknowledged, 1, null);
                }
                this.flowControlListener.receivingConnectionWindowChanged(this.readBytes);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.writer.maxDataLength());
        r6 = r2;
        r8.writeBytesTotal += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeData(int r9, boolean r10, l7.j r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L6a
            monitor-enter(r8)
        L12:
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            long r6 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r2 = r8.streams     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            goto L12
        L2a:
            r9 = move-exception
            goto L68
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            okhttp3.internal.http2.Http2Writer r4 = r8.writer     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.maxDataLength()     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L56
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = r3
        L57:
            r4.data(r5, r9, r11, r2)
            goto Ld
        L5b:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L68:
            monitor-exit(r8)
            throw r9
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, l7.j, long):void");
    }

    public final void writeHeaders$okhttp(int i2, boolean z2, List<Header> alternating) throws IOException {
        kotlin.jvm.internal.k.e(alternating, "alternating");
        this.writer.headers(z2, i2, alternating);
    }

    public final void writePing(boolean z2, int i2, int i8) {
        try {
            this.writer.ping(z2, i2, i8);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i2, ErrorCode statusCode) throws IOException {
        kotlin.jvm.internal.k.e(statusCode, "statusCode");
        this.writer.rstStream(i2, statusCode);
    }

    public final void writeSynResetLater$okhttp(int i2, ErrorCode errorCode) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + i2 + "] writeSynReset", 0L, false, new d(this, i2, errorCode, 0), 6, null);
    }

    public final void writeWindowUpdateLater$okhttp(final int i2, final long j) {
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + i2 + "] windowUpdate", 0L, false, new e6.a() { // from class: okhttp3.internal.http2.c
            @Override // e6.a
            public final Object invoke() {
                return Http2Connection.writeWindowUpdateLater$lambda$13(this.f13239a, i2, j);
            }
        }, 6, null);
    }

    private final Http2Stream newStream(int i2, List<Header> list, boolean z2) throws Throwable {
        Throwable th;
        boolean z7 = !z2;
        synchronized (this.writer) {
            try {
                try {
                    synchronized (this) {
                        try {
                            if (this.nextStreamId > 1073741823) {
                                try {
                                    shutdown(ErrorCode.REFUSED_STREAM);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            try {
                                if (this.isShutdown) {
                                    throw new ConnectionShutdownException();
                                }
                                int i8 = this.nextStreamId;
                                this.nextStreamId = i8 + 2;
                                Http2Stream http2Stream = new Http2Stream(i8, this, z7, false, null);
                                boolean z8 = !z2 || this.writeBytesTotal >= this.writeBytesMaximum || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                                if (http2Stream.isOpen()) {
                                    this.streams.put(Integer.valueOf(i8), http2Stream);
                                }
                                if (i2 == 0) {
                                    this.writer.headers(z7, i8, list);
                                } else {
                                    if (this.client) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                    }
                                    this.writer.pushPromise(i2, i8, list);
                                }
                                if (z8) {
                                    this.writer.flush();
                                }
                                return http2Stream;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        th = th;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    public final void start(boolean z2) throws IOException {
        if (z2) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            if (this.okHttpSettings.getInitialWindowSize() != 65535) {
                this.writer.windowUpdate(0, r9 - 65535);
            }
        }
        TaskQueue.execute$default(this.taskRunner.newQueue(), this.connectionName, 0L, false, this.readerRunnable, 6, null);
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
