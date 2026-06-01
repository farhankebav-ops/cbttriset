package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.jvm.internal.k;
import l7.j;
import l7.l;
import l7.n0;
import l7.o0;
import l7.r0;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.flowcontrol.WindowCounter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Stream implements Lockable {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private final WindowCounter readBytes;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class FramingSource implements o0 {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private Headers trailers;
        private final j receiveBuffer = new j();
        private final j readBuffer = new j();

        public FramingSource(long j, boolean z2) {
            this.maxByteCount = j;
            this.finished = z2;
        }

        private final void updateConnectionFlowControl(long j) {
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                j jVar = this.readBuffer;
                j = jVar.f12868b;
                jVar.a();
                k.c(http2Stream, "null cannot be cast to non-null type java.lang.Object");
                http2Stream.notifyAll();
            }
            if (j > 0) {
                updateConnectionFlowControl(j);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final j getReadBuffer() {
            return this.readBuffer;
        }

        public final j getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // l7.o0
        public long read(j sink, long j) throws IOException {
            IOException errorException$okhttp;
            boolean z2;
            long j3;
            k.e(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
            }
            do {
                Http2Stream http2Stream = Http2Stream.this;
                synchronized (http2Stream) {
                    boolean zDoReadTimeout = http2Stream.doReadTimeout();
                    if (zDoReadTimeout) {
                        http2Stream.getReadTimeout$okhttp().enter();
                    }
                    try {
                        if (http2Stream.getErrorCode$okhttp() == null || this.finished) {
                            errorException$okhttp = null;
                        } else {
                            errorException$okhttp = http2Stream.getErrorException$okhttp();
                            if (errorException$okhttp == null) {
                                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                k.b(errorCode$okhttp);
                                errorException$okhttp = new StreamResetException(errorCode$okhttp);
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        j jVar = this.readBuffer;
                        long j8 = jVar.f12868b;
                        z2 = false;
                        if (j8 > 0) {
                            j3 = jVar.read(sink, Math.min(j, j8));
                            WindowCounter.update$default(http2Stream.getReadBytes(), j3, 0L, 2, null);
                            long unacknowledged = http2Stream.getReadBytes().getUnacknowledged();
                            if (errorException$okhttp == null && unacknowledged >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), unacknowledged);
                                WindowCounter.update$default(http2Stream.getReadBytes(), 0L, unacknowledged, 1, null);
                            }
                        } else {
                            if (!this.finished && errorException$okhttp == null) {
                                http2Stream.waitForIo$okhttp();
                                z2 = true;
                            }
                            j3 = -1;
                        }
                        if (zDoReadTimeout) {
                            http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                        }
                    } finally {
                    }
                }
                Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.f12868b);
            } while (z2);
            if (j3 != -1) {
                return j3;
            }
            if (errorException$okhttp == null) {
                return -1L;
            }
            throw errorException$okhttp;
        }

        public final void receive$okhttp(l source, long j) throws IOException {
            boolean z2;
            boolean z7;
            k.e(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            long j3 = j;
            while (j3 > 0) {
                synchronized (Http2Stream.this) {
                    z2 = this.finished;
                    z7 = this.readBuffer.f12868b + j3 > this.maxByteCount;
                }
                if (z7) {
                    source.skip(j3);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z2) {
                    source.skip(j3);
                    return;
                }
                long j8 = source.read(this.receiveBuffer, j3);
                if (j8 == -1) {
                    throw new EOFException();
                }
                j3 -= j8;
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream2) {
                    try {
                        if (this.closed) {
                            this.receiveBuffer.a();
                        } else {
                            j jVar = this.readBuffer;
                            boolean z8 = jVar.f12868b == 0;
                            jVar.H(this.receiveBuffer);
                            if (z8) {
                                k.c(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
                                http2Stream2.notifyAll();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            updateConnectionFlowControl(j);
            Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.f12868b);
        }

        public final void setClosed$okhttp(boolean z2) {
            this.closed = z2;
        }

        public final void setFinished$okhttp(boolean z2) {
            this.finished = z2;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // l7.o0
        public r0 timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class StreamTimeout extends l7.f {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // l7.f
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // l7.f
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i2, Http2Connection connection, boolean z2, boolean z7, Headers headers) {
        k.e(connection, "connection");
        this.id = i2;
        this.connection = connection;
        this.readBytes = new WindowCounter(i2);
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(connection.getOkHttpSettings().getInitialWindowSize(), z7);
        this.sink = new FramingSink(z2);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            if (getSource().getFinished$okhttp()) {
                if (getSink().getFinished()) {
                    return false;
                }
            }
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doReadTimeout() {
        return !this.connection.getClient$okhttp() || getSink().getClosed() || getSink().getFinished();
    }

    public static /* synthetic */ Headers takeHeaders$default(Http2Stream http2Stream, boolean z2, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return http2Stream.takeHeaders(z2);
    }

    public final void addBytesToWriteWindow(long j) {
        this.writeBytesMaximum += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void cancel() {
        closeLater(ErrorCode.CANCEL);
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z2;
        boolean zIsOpen;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                z2 = !getSource().getFinished$okhttp() && getSource().getClosed$okhttp() && (getSink().getFinished() || getSink().getClosed());
                zIsOpen = isOpen();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (getSink().getClosed()) {
            throw new IOException("stream closed");
        }
        if (getSink().getFinished()) {
            throw new IOException("stream finished");
        }
        if (getErrorCode$okhttp() != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode$okhttp = getErrorCode$okhttp();
            k.b(errorCode$okhttp);
            throw new StreamResetException(errorCode$okhttp);
        }
    }

    public final void close(ErrorCode rstStatusCode, IOException iOException) throws IOException {
        k.e(rstStatusCode, "rstStatusCode");
        if (closeInternal(rstStatusCode, iOException)) {
            this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
        }
    }

    public final void closeLater(ErrorCode errorCode) {
        k.e(errorCode, "errorCode");
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, errorCode);
        }
    }

    public final void enqueueTrailers(Headers trailers) {
        k.e(trailers, "trailers");
        synchronized (this) {
            if (getSink().getFinished()) {
                throw new IllegalStateException("already finished");
            }
            if (trailers.size() == 0) {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
            getSink().setTrailers(trailers);
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final ErrorCode getErrorCode$okhttp() {
        ErrorCode errorCode;
        synchronized (this) {
            errorCode = this.errorCode;
        }
        return errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.id & 1) == 1);
    }

    public final boolean isOpen() {
        synchronized (this) {
            try {
                if (getErrorCode$okhttp() != null) {
                    return false;
                }
                if (getSource().getFinished$okhttp() || getSource().getClosed$okhttp()) {
                    if (getSink().getFinished() || getSink().getClosed()) {
                        if (this.hasResponseHeaders) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isSourceComplete() {
        /*
            r1 = this;
            monitor-enter(r1)
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r1.getSource()     // Catch: java.lang.Throwable -> L1b
            boolean r0 = r0.getFinished$okhttp()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r1.getSource()     // Catch: java.lang.Throwable -> L1b
            l7.j r0 = r0.getReadBuffer()     // Catch: java.lang.Throwable -> L1b
            boolean r0 = r0.M()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            r0 = 1
            goto L1e
        L1b:
            r0 = move-exception
            goto L20
        L1d:
            r0 = 0
        L1e:
            monitor-exit(r1)
            return r0
        L20:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.isSourceComplete():boolean");
    }

    public final Headers peekTrailers() throws IOException {
        synchronized (this) {
            if (getSource().getFinished$okhttp() && getSource().getReceiveBuffer().M() && getSource().getReadBuffer().M()) {
                Headers trailers = getSource().getTrailers();
                if (trailers == null) {
                    trailers = Headers.EMPTY;
                }
                return trailers;
            }
            if (getErrorCode$okhttp() == null) {
                return null;
            }
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode$okhttp = getErrorCode$okhttp();
            k.b(errorCode$okhttp);
            throw new StreamResetException(errorCode$okhttp);
        }
    }

    public final r0 readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(l source, int i2) throws IOException {
        k.e(source, "source");
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(this)) {
            getSource().receive$okhttp(source, i2);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void receiveHeaders(Headers headers, boolean z2) {
        boolean zIsOpen;
        k.e(headers, "headers");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && headers.get(Header.RESPONSE_STATUS_UTF8) == null && headers.get(Header.TARGET_METHOD_UTF8) == null) {
                    getSource().setTrailers(headers);
                } else {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                }
                if (z2) {
                    getSource().setFinished$okhttp(true);
                }
                zIsOpen = isOpen();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream$okhttp(this.id);
    }

    public final void receiveRstStream(ErrorCode errorCode) {
        k.e(errorCode, "errorCode");
        synchronized (this) {
            if (getErrorCode$okhttp() == null) {
                this.errorCode = errorCode;
                notifyAll();
            }
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setWriteBytesMaximum$okhttp(long j) {
        this.writeBytesMaximum = j;
    }

    public final void setWriteBytesTotal$okhttp(long j) {
        this.writeBytesTotal = j;
    }

    public final Headers takeHeaders(boolean z2) throws IOException {
        Headers headers;
        synchronized (this) {
            while (this.headersQueue.isEmpty() && getErrorCode$okhttp() == null) {
                try {
                    boolean z7 = z2 || doReadTimeout();
                    if (z7) {
                        this.readTimeout.enter();
                    }
                    try {
                        waitForIo$okhttp();
                        if (z7) {
                            this.readTimeout.exitAndThrowIfTimedOut();
                        }
                    } catch (Throwable th) {
                        if (z7) {
                            this.readTimeout.exitAndThrowIfTimedOut();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.headersQueue.isEmpty()) {
                IOException iOException = this.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCode$okhttp = getErrorCode$okhttp();
                k.b(errorCode$okhttp);
                throw new StreamResetException(errorCode$okhttp);
            }
            Headers headersRemoveFirst = this.headersQueue.removeFirst();
            k.d(headersRemoveFirst, "removeFirst(...)");
            headers = headersRemoveFirst;
        }
        return headers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> responseHeaders, boolean z2, boolean z7) throws IOException {
        k.e(responseHeaders, "responseHeaders");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z2) {
                getSink().setFinished(true);
                notifyAll();
            }
        }
        if (!z7) {
            synchronized (this) {
                z7 = this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum();
            }
        }
        this.connection.writeHeaders$okhttp(this.id, z2, responseHeaders);
        if (z7) {
            this.connection.flush();
        }
    }

    public final r0 writeTimeout() {
        return this.writeTimeout;
    }

    public FramingSink getSink() {
        return this.sink;
    }

    public FramingSource getSource() {
        return this.source;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class FramingSink implements n0 {
        private boolean closed;
        private boolean finished;
        private final j sendBuffer;
        private Headers trailers;

        public FramingSink(boolean z2) {
            this.finished = z2;
            this.sendBuffer = new j();
        }

        /* JADX WARN: Finally extract failed */
        private final void emitFrame(boolean z2) throws IOException {
            long jMin;
            boolean z7;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout$okhttp().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                    try {
                        http2Stream.waitForIo$okhttp();
                    } catch (Throwable th) {
                        http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                jMin = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.f12868b);
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + jMin);
                z7 = z2 && jMin == this.sendBuffer.f12868b;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z7, this.sendBuffer, jMin);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                if (this.closed) {
                    return;
                }
                boolean z2 = http2Stream2.getErrorCode$okhttp() == null;
                if (!Http2Stream.this.getSink().finished) {
                    boolean z7 = this.sendBuffer.f12868b > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.f12868b > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        k.b(headers);
                        connection.writeHeaders$okhttp(id, z2, _UtilJvmKt.toHeaderList(headers));
                    } else if (z7) {
                        while (this.sendBuffer.f12868b > 0) {
                            emitFrame(true);
                        }
                    } else if (z2) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                Http2Stream http2Stream3 = Http2Stream.this;
                synchronized (http2Stream3) {
                    this.closed = true;
                    k.c(http2Stream3, "null cannot be cast to non-null type java.lang.Object");
                    http2Stream3.notifyAll();
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // l7.n0, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
            }
            while (this.sendBuffer.f12868b > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z2) {
            this.closed = z2;
        }

        public final void setFinished(boolean z2) {
            this.finished = z2;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // l7.n0
        public r0 timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // l7.n0
        public void write(j source, long j) throws IOException {
            k.e(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(source, j);
                while (this.sendBuffer.f12868b >= Http2Stream.EMIT_BUFFER_SIZE) {
                    emitFrame(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
            this((i2 & 1) != 0 ? false : z2);
        }
    }
}
