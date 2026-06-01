package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l7.j;
import l7.k;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.Hpack;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Writer implements Closeable, Lockable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final j hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final k sink;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public Http2Writer(k sink, boolean z2) {
        kotlin.jvm.internal.k.e(sink, "sink");
        this.sink = sink;
        this.client = z2;
        j jVar = new j();
        this.hpackBuffer = jVar;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, jVar, 3, null);
    }

    private final void writeContinuationFrames(int i2, long j) throws IOException {
        while (j > 0) {
            long jMin = Math.min(this.maxFrameSize, j);
            j -= jMin;
            frameHeader(i2, (int) jMin, 9, j == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, jMin);
        }
    }

    public final void applyAndAckSettings(Settings peerSettings) throws IOException {
        kotlin.jvm.internal.k.e(peerSettings, "peerSettings");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
                if (peerSettings.getHeaderTableSize() != -1) {
                    this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
                }
                frameHeader(0, 0, 4, 1);
                this.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.closed = true;
            this.sink.close();
        }
    }

    public final void connectionPreface() throws IOException {
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (this.client) {
                    Logger logger2 = logger;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.e(), new Object[0]));
                    }
                    this.sink.E(Http2.CONNECTION_PREFACE);
                    this.sink.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void data(boolean z2, int i2, j jVar, int i8) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            dataFrame(i2, z2 ? 1 : 0, jVar, i8);
        }
    }

    public final void dataFrame(int i2, int i8, j jVar, int i9) throws IOException {
        frameHeader(i2, i9, 0, i8);
        if (i9 > 0) {
            k kVar = this.sink;
            kotlin.jvm.internal.k.b(jVar);
            kVar.write(jVar, i9);
        }
    }

    public final void flush() throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void frameHeader(int r9, int r10, int r11, int r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 8
            if (r11 == r0) goto L1d
            java.util.logging.Logger r0 = okhttp3.internal.http2.Http2Writer.logger
            java.util.logging.Level r1 = java.util.logging.Level.FINE
            boolean r1 = r0.isLoggable(r1)
            if (r1 == 0) goto L1d
            okhttp3.internal.http2.Http2 r2 = okhttp3.internal.http2.Http2.INSTANCE
            r3 = 0
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            java.lang.String r9 = r2.frameLog(r3, r4, r5, r6, r7)
            r0.fine(r9)
            goto L21
        L1d:
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
        L21:
            int r9 = r8.maxFrameSize
            if (r5 > r9) goto L57
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r9 & r4
            if (r9 != 0) goto L47
            l7.k r9 = r8.sink
            okhttp3.internal._UtilCommonKt.writeMedium(r9, r5)
            l7.k r9 = r8.sink
            r10 = r6 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            l7.k r9 = r8.sink
            r10 = r7 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            l7.k r9 = r8.sink
            r10 = 2147483647(0x7fffffff, float:NaN)
            r10 = r10 & r4
            r9.writeInt(r10)
            return
        L47:
            java.lang.String r9 = "reserved bit set: "
            java.lang.String r9 = a1.a.g(r4, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L57:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "FRAME_SIZE_ERROR length > "
            r9.<init>(r10)
            int r10 = r8.maxFrameSize
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Writer.frameHeader(int, int, int, int):void");
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final void goAway(int i2, ErrorCode errorCode, byte[] debugData) throws IOException {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        kotlin.jvm.internal.k.e(debugData, "debugData");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            frameHeader(0, debugData.length + 8, 7, 0);
            this.sink.writeInt(i2);
            this.sink.writeInt(errorCode.getHttpCode());
            if (debugData.length != 0) {
                this.sink.write(debugData);
            }
            this.sink.flush();
        }
    }

    public final void headers(boolean z2, int i2, List<Header> headerBlock) throws IOException {
        kotlin.jvm.internal.k.e(headerBlock, "headerBlock");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(headerBlock);
            long j = this.hpackBuffer.f12868b;
            long jMin = Math.min(this.maxFrameSize, j);
            int i8 = j == jMin ? 4 : 0;
            if (z2) {
                i8 |= 1;
            }
            frameHeader(i2, (int) jMin, 1, i8);
            this.sink.write(this.hpackBuffer, jMin);
            if (j > jMin) {
                writeContinuationFrames(i2, j - jMin);
            }
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void ping(boolean z2, int i2, int i8) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, 8, 6, z2 ? 1 : 0);
            this.sink.writeInt(i2);
            this.sink.writeInt(i8);
            this.sink.flush();
        }
    }

    public final void pushPromise(int i2, int i8, List<Header> requestHeaders) throws IOException {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(requestHeaders);
            long j = this.hpackBuffer.f12868b;
            int iMin = (int) Math.min(((long) this.maxFrameSize) - 4, j);
            long j3 = iMin;
            frameHeader(i2, iMin + 4, 5, j == j3 ? 4 : 0);
            this.sink.writeInt(i8 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j3);
            if (j > j3) {
                writeContinuationFrames(i2, j - j3);
            }
        }
    }

    public final void rstStream(int i2, ErrorCode errorCode) throws IOException {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            frameHeader(i2, 4, 3, 0);
            this.sink.writeInt(errorCode.getHttpCode());
            this.sink.flush();
        }
    }

    public final void settings(Settings settings) throws IOException {
        kotlin.jvm.internal.k.e(settings, "settings");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                frameHeader(0, settings.size() * 6, 4, 0);
                for (int i2 = 0; i2 < 10; i2++) {
                    if (settings.isSet(i2)) {
                        this.sink.writeShort(i2);
                        this.sink.writeInt(settings.get(i2));
                    }
                }
                this.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void windowUpdate(int i2, long j) throws IOException {
        int i8;
        long j3;
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (j == 0 || j > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i8 = i2;
                    j3 = j;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(false, i8, 4, j3));
                } else {
                    i8 = i2;
                    j3 = j;
                }
                frameHeader(i8, 4, 8, 0);
                this.sink.writeInt((int) j3);
                this.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
