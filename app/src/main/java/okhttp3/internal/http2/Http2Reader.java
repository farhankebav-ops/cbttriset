package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;
import l7.j;
import l7.l;
import l7.m;
import l7.o0;
import l7.r0;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Hpack;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final l source;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i2, int i8, int i9) throws IOException {
            if ((i8 & 8) != 0) {
                i2--;
            }
            if (i9 <= i2) {
                return i2 - i9;
            }
            throw new IOException(androidx.camera.core.processing.util.a.i("PROTOCOL_ERROR padding ", i9, " > remaining length ", i2));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Handler {
        void ackSettings();

        void alternateService(int i2, String str, m mVar, String str2, int i8, long j);

        void data(boolean z2, int i2, l lVar, int i8) throws IOException;

        void goAway(int i2, ErrorCode errorCode, m mVar);

        void headers(boolean z2, int i2, int i8, List<Header> list);

        void ping(boolean z2, int i2, int i8);

        void priority(int i2, int i8, int i9, boolean z2);

        void pushPromise(int i2, int i8, List<Header> list) throws IOException;

        void rstStream(int i2, ErrorCode errorCode);

        void settings(boolean z2, Settings settings);

        void windowUpdate(int i2, long j);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        k.d(logger2, "getLogger(...)");
        logger = logger2;
    }

    public Http2Reader(l source, boolean z2) {
        k.e(source, "source");
        this.source = source;
        this.client = z2;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i2, int i8, int i9) throws IOException {
        if (i9 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z2 = (i8 & 1) != 0;
        if ((i8 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iAnd = (i8 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        handler.data(z2, i9, this.source, Companion.lengthWithoutPadding(i2, i8, iAnd));
        this.source.skip(iAnd);
    }

    private final void readGoAway(Handler handler, int i2, int i8, int i9) throws IOException {
        if (i2 < 8) {
            throw new IOException(a1.a.g(i2, "TYPE_GOAWAY length < 8: "));
        }
        if (i9 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i10 = this.source.readInt();
        int i11 = this.source.readInt();
        int i12 = i2 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i11);
        if (errorCodeFromHttp2 == null) {
            throw new IOException(a1.a.g(i11, "TYPE_GOAWAY unexpected error code: "));
        }
        m mVarJ = m.f12880d;
        if (i12 > 0) {
            mVarJ = this.source.J(i12);
        }
        handler.goAway(i10, errorCodeFromHttp2, mVarJ);
    }

    private final List<Header> readHeaderBlock(int i2, int i8, int i9, int i10) throws IOException {
        this.continuation.setLeft(i2);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i8);
        this.continuation.setFlags(i9);
        this.continuation.setStreamId(i10);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i2, int i8, int i9) throws IOException {
        if (i9 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z2 = (i8 & 1) != 0;
        int iAnd = (i8 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        if ((i8 & 32) != 0) {
            readPriority(handler, i9);
            i2 -= 5;
        }
        handler.headers(z2, i9, -1, readHeaderBlock(Companion.lengthWithoutPadding(i2, i8, iAnd), iAnd, i8, i9));
    }

    private final void readPing(Handler handler, int i2, int i8, int i9) throws IOException {
        if (i2 != 8) {
            throw new IOException(a1.a.g(i2, "TYPE_PING length != 8: "));
        }
        if (i9 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i8 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler handler, int i2, int i8, int i9) throws IOException {
        if (i2 != 5) {
            throw new IOException(a1.a.h(i2, "TYPE_PRIORITY length: ", " != 5"));
        }
        if (i9 == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        readPriority(handler, i9);
    }

    private final void readPushPromise(Handler handler, int i2, int i8, int i9) throws IOException {
        if (i9 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iAnd = (i8 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(i9, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i2 - 4, i8, iAnd), iAnd, i8, i9));
    }

    private final void readRstStream(Handler handler, int i2, int i8, int i9) throws IOException {
        if (i2 != 4) {
            throw new IOException(a1.a.h(i2, "TYPE_RST_STREAM length: ", " != 4"));
        }
        if (i9 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i10 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i10);
        if (errorCodeFromHttp2 == null) {
            throw new IOException(a1.a.g(i10, "TYPE_RST_STREAM unexpected error code: "));
        }
        handler.rstStream(i9, errorCodeFromHttp2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        throw new java.io.IOException(a1.a.g(r4, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void readSettings(okhttp3.internal.http2.Http2Reader.Handler r7, int r8, int r9, int r10) throws java.io.IOException {
        /*
            r6 = this;
            if (r10 != 0) goto L97
            r10 = 1
            r9 = r9 & r10
            if (r9 == 0) goto L14
            if (r8 != 0) goto Lc
            r7.ackSettings()
            return
        Lc:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "FRAME_SIZE_ERROR ack frame should be empty!"
            r7.<init>(r8)
            throw r7
        L14:
            int r9 = r8 % 6
            if (r9 != 0) goto L8b
            okhttp3.internal.http2.Settings r9 = new okhttp3.internal.http2.Settings
            r9.<init>()
            r0 = 0
            k6.d r8 = r2.q.D0(r0, r8)
            r1 = 6
            k6.b r8 = r2.q.w0(r8, r1)
            int r1 = r8.f12709a
            int r2 = r8.f12710b
            int r8 = r8.f12711c
            if (r8 <= 0) goto L31
            if (r1 <= r2) goto L35
        L31:
            if (r8 >= 0) goto L87
            if (r2 > r1) goto L87
        L35:
            l7.l r3 = r6.source
            short r3 = r3.readShort()
            r4 = 65535(0xffff, float:9.1834E-41)
            int r3 = okhttp3.internal._UtilCommonKt.and(r3, r4)
            l7.l r4 = r6.source
            int r4 = r4.readInt()
            r5 = 2
            if (r3 == r5) goto L73
            r5 = 4
            if (r3 == r5) goto L68
            r5 = 5
            if (r3 == r5) goto L52
            goto L80
        L52:
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r4 < r5) goto L5c
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            if (r4 > r5) goto L5c
            goto L80
        L5c:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "
            java.lang.String r8 = a1.a.g(r4, r8)
            r7.<init>(r8)
            throw r7
        L68:
            if (r4 < 0) goto L6b
            goto L80
        L6b:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            r7.<init>(r8)
            throw r7
        L73:
            if (r4 == 0) goto L80
            if (r4 != r10) goto L78
            goto L80
        L78:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            r7.<init>(r8)
            throw r7
        L80:
            r9.set(r3, r4)
            if (r1 == r2) goto L87
            int r1 = r1 + r8
            goto L35
        L87:
            r7.settings(r0, r9)
            return
        L8b:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r9 = "TYPE_SETTINGS length % 6 != 0: "
            java.lang.String r8 = a1.a.g(r8, r9)
            r7.<init>(r8)
            throw r7
        L97:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "TYPE_SETTINGS streamId != 0"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.readSettings(okhttp3.internal.http2.Http2Reader$Handler, int, int, int):void");
    }

    private final void readWindowUpdate(Handler handler, int i2, int i8, int i9) throws Exception {
        int i10;
        try {
            if (i2 != 4) {
                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i2);
            }
            try {
                long jAnd = _UtilCommonKt.and(this.source.readInt(), 2147483647L);
                if (jAnd == 0) {
                    throw new IOException("windowSizeIncrement was 0");
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i10 = i9;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(true, i9, i2, jAnd));
                } else {
                    i10 = i9;
                }
                handler.windowUpdate(i10, jAnd);
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                logger.fine(Http2.INSTANCE.frameLog(true, i9, i2, 8, i8));
                throw exc;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z2, Handler handler) throws Exception {
        k.e(handler, "handler");
        try {
            this.source.F(9L);
            int medium = _UtilCommonKt.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException(a1.a.g(medium, "FRAME_SIZE_ERROR: "));
            }
            int iAnd = _UtilCommonKt.and(this.source.readByte(), 255);
            int iAnd2 = _UtilCommonKt.and(this.source.readByte(), 255);
            int i2 = this.source.readInt() & Integer.MAX_VALUE;
            if (iAnd != 8) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, i2, medium, iAnd, iAnd2));
                }
            }
            if (z2 && iAnd != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(iAnd));
            }
            switch (iAnd) {
                case 0:
                    readData(handler, medium, iAnd2, i2);
                    return true;
                case 1:
                    readHeaders(handler, medium, iAnd2, i2);
                    return true;
                case 2:
                    readPriority(handler, medium, iAnd2, i2);
                    return true;
                case 3:
                    readRstStream(handler, medium, iAnd2, i2);
                    return true;
                case 4:
                    readSettings(handler, medium, iAnd2, i2);
                    return true;
                case 5:
                    readPushPromise(handler, medium, iAnd2, i2);
                    return true;
                case 6:
                    readPing(handler, medium, iAnd2, i2);
                    return true;
                case 7:
                    readGoAway(handler, medium, iAnd2, i2);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, iAnd2, i2);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        k.e(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        l lVar = this.source;
        m mVar = Http2.CONNECTION_PREFACE;
        m mVarJ = lVar.J(mVar.d());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(_UtilJvmKt.format("<< CONNECTION " + mVarJ.e(), new Object[0]));
        }
        if (!mVar.equals(mVarJ)) {
            throw new IOException("Expected a connection header but was ".concat(mVarJ.t()));
        }
    }

    private final void readPriority(Handler handler, int i2) throws IOException {
        int i8 = this.source.readInt();
        handler.priority(i2, i8 & Integer.MAX_VALUE, _UtilCommonKt.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & i8) != 0);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ContinuationSource implements o0 {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final l source;
        private int streamId;

        public ContinuationSource(l source) {
            k.e(source, "source");
            this.source = source;
        }

        private final void readContinuationHeader() throws IOException {
            int i2 = this.streamId;
            int medium = _UtilCommonKt.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            int iAnd = _UtilCommonKt.and(this.source.readByte(), 255);
            this.flags = _UtilCommonKt.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, iAnd, this.flags));
            }
            int i8 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i8;
            if (iAnd == 9) {
                if (i8 != i2) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iAnd + " != TYPE_CONTINUATION");
            }
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // l7.o0
        public long read(j sink, long j) throws IOException {
            k.e(sink, "sink");
            while (true) {
                int i2 = this.left;
                if (i2 != 0) {
                    long j3 = this.source.read(sink, Math.min(j, i2));
                    if (j3 == -1) {
                        return -1L;
                    }
                    this.left -= (int) j3;
                    return j3;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i2) {
            this.flags = i2;
        }

        public final void setLeft(int i2) {
            this.left = i2;
        }

        public final void setLength(int i2) {
            this.length = i2;
        }

        public final void setPadding(int i2) {
            this.padding = i2;
        }

        public final void setStreamId(int i2) {
            this.streamId = i2;
        }

        @Override // l7.o0
        public r0 timeout() {
            return this.source.timeout();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
