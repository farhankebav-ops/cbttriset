package okhttp3;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.f0;
import l7.j;
import l7.l;
import l7.m;
import l7.o0;
import l7.q0;
import l7.r0;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final f0 afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final m crlfDashDashBoundary;
    private PartSource currentPart;
    private final m dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final l source;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final f0 getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Part implements Closeable {
        private final l body;
        private final Headers headers;

        public Part(Headers headers, l body) {
            k.e(headers, "headers");
            k.e(body, "body");
            this.headers = headers;
            this.body = body;
        }

        public final l body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class PartSource implements o0 {
        private final r0 timeout = new r0();

        public PartSource() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (k.a(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // l7.o0
        public long read(j sink, long j) {
            long j3;
            k.e(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
            }
            if (!k.a(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed");
            }
            r0 r0VarTimeout = MultipartReader.this.source.timeout();
            r0 r0Var = this.timeout;
            MultipartReader multipartReader = MultipartReader.this;
            long jTimeoutNanos = r0VarTimeout.timeoutNanos();
            q0 q0Var = r0.Companion;
            long jTimeoutNanos2 = r0Var.timeoutNanos();
            long jTimeoutNanos3 = r0VarTimeout.timeoutNanos();
            q0Var.getClass();
            if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
                jTimeoutNanos2 = jTimeoutNanos3;
            }
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            r0VarTimeout.timeout(jTimeoutNanos2, timeUnit);
            if (!r0VarTimeout.hasDeadline()) {
                if (r0Var.hasDeadline()) {
                    r0VarTimeout.deadlineNanoTime(r0Var.deadlineNanoTime());
                }
                try {
                    long jCurrentPartBytesRemaining = multipartReader.currentPartBytesRemaining(j);
                    long j8 = jCurrentPartBytesRemaining == 0 ? -1L : multipartReader.source.read(sink, jCurrentPartBytesRemaining);
                    r0VarTimeout.timeout(jTimeoutNanos, timeUnit);
                    if (r0Var.hasDeadline()) {
                        r0VarTimeout.clearDeadline();
                    }
                    return j8;
                } catch (Throwable th) {
                    r0VarTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (r0Var.hasDeadline()) {
                        r0VarTimeout.clearDeadline();
                    }
                    throw th;
                }
            }
            long jDeadlineNanoTime = r0VarTimeout.deadlineNanoTime();
            if (r0Var.hasDeadline()) {
                j3 = jDeadlineNanoTime;
                r0VarTimeout.deadlineNanoTime(Math.min(r0VarTimeout.deadlineNanoTime(), r0Var.deadlineNanoTime()));
            } else {
                j3 = jDeadlineNanoTime;
            }
            try {
                long jCurrentPartBytesRemaining2 = multipartReader.currentPartBytesRemaining(j);
                long j9 = jCurrentPartBytesRemaining2 == 0 ? -1L : multipartReader.source.read(sink, jCurrentPartBytesRemaining2);
                r0VarTimeout.timeout(jTimeoutNanos, timeUnit);
                if (r0Var.hasDeadline()) {
                    r0VarTimeout.deadlineNanoTime(j3);
                }
                return j9;
            } catch (Throwable th2) {
                long j10 = j3;
                r0VarTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (r0Var.hasDeadline()) {
                    r0VarTimeout.deadlineNanoTime(j10);
                }
                throw th2;
            }
        }

        @Override // l7.o0
        public r0 timeout() {
            return this.timeout;
        }
    }

    static {
        m mVar = m.f12880d;
        afterBoundaryOptions = l7.b.f(r4.c.e("\r\n"), r4.c.e("--"), r4.c.e(" "), r4.c.e("\t"));
    }

    public MultipartReader(l source, String boundary) throws IOException {
        k.e(source, "source");
        k.e(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        j jVar = new j();
        jVar.d0("--");
        jVar.d0(boundary);
        this.dashDashBoundary = jVar.J(jVar.f12868b);
        j jVar2 = new j();
        jVar2.d0("\r\n--");
        jVar2.d0(boundary);
        this.crlfDashDashBoundary = jVar2.J(jVar2.f12868b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j) throws EOFException {
        long jMin = Math.min(this.source.getBuffer().f12868b, j) + 1;
        long jN = this.source.N(jMin, this.crlfDashDashBoundary);
        if (jN != -1) {
            return jN;
        }
        if (this.source.getBuffer().f12868b >= jMin) {
            return Math.min(jMin, j);
        }
        throw new EOFException();
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.I(0L, this.dashDashBoundary)) {
            this.source.skip(this.dashDashBoundary.d());
        } else {
            while (true) {
                long jCurrentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (jCurrentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(jCurrentPartBytesRemaining);
            }
            this.source.skip(this.crlfDashDashBoundary.d());
        }
        boolean z2 = false;
        while (true) {
            int iF = this.source.f(afterBoundaryOptions);
            if (iF == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (iF == 0) {
                this.partCount++;
                Headers headers = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(headers, l7.b.c(partSource));
            }
            if (iF == 1) {
                if (z2) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (iF == 2 || iF == 3) {
                z2 = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultipartReader(ResponseBody response) throws IOException {
        String strParameter;
        k.e(response, "response");
        l lVarSource = response.source();
        MediaType mediaTypeContentType = response.contentType();
        if (mediaTypeContentType != null && (strParameter = mediaTypeContentType.parameter("boundary")) != null) {
            this(lVarSource, strParameter);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
