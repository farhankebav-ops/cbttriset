package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import l7.h;
import l7.j;
import l7.k;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final h maskCursor;
    private final byte[] maskKey;
    private final j messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final k sink;
    private final j sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z2, k sink, Random random, boolean z7, boolean z8, long j) {
        kotlin.jvm.internal.k.e(sink, "sink");
        kotlin.jvm.internal.k.e(random, "random");
        this.isClient = z2;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z7;
        this.noContextTakeover = z8;
        this.minimumDeflateSize = j;
        this.messageBuffer = new j();
        this.sinkBuffer = sink.getBuffer();
        this.maskKey = z2 ? new byte[4] : null;
        this.maskCursor = z2 ? new h() : null;
    }

    private final void writeControlFrame(int i2, m mVar) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int iD = mVar.d();
        if (iD > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.x(i2 | 128);
        if (this.isClient) {
            this.sinkBuffer.x(iD | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            kotlin.jvm.internal.k.b(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m3450write(this.maskKey);
            if (iD > 0) {
                j jVar = this.sinkBuffer;
                long j = jVar.f12868b;
                jVar.w(mVar);
                j jVar2 = this.sinkBuffer;
                h hVar = this.maskCursor;
                kotlin.jvm.internal.k.b(hVar);
                jVar2.n(hVar);
                this.maskCursor.b(j);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.x(iD);
            this.sinkBuffer.w(mVar);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final k getSink() {
        return this.sink;
    }

    public final void writeClose(int i2, m mVar) throws IOException {
        m mVarJ = m.f12880d;
        if (i2 != 0 || mVar != null) {
            if (i2 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i2);
            }
            j jVar = new j();
            jVar.Z(i2);
            if (mVar != null) {
                jVar.w(mVar);
            }
            mVarJ = jVar.J(jVar.f12868b);
        }
        try {
            writeControlFrame(8, mVarJ);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i2, m data) throws IOException {
        kotlin.jvm.internal.k.e(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.w(data);
        int i8 = i2 | 128;
        if (this.perMessageDeflate && data.d() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i8 = i2 | 192;
        }
        long j = this.messageBuffer.f12868b;
        this.sinkBuffer.x(i8);
        int i9 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.x(i9 | ((int) j));
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.x(i9 | 126);
            this.sinkBuffer.Z((int) j);
        } else {
            this.sinkBuffer.x(i9 | 127);
            this.sinkBuffer.Y(j);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            kotlin.jvm.internal.k.b(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m3450write(this.maskKey);
            if (j > 0) {
                j jVar = this.messageBuffer;
                h hVar = this.maskCursor;
                kotlin.jvm.internal.k.b(hVar);
                jVar.n(hVar);
                this.maskCursor.b(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, j);
        this.sink.z();
    }

    public final void writePing(m payload) throws IOException {
        kotlin.jvm.internal.k.e(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(m payload) throws IOException {
        kotlin.jvm.internal.k.e(payload, "payload");
        writeControlFrame(10, payload);
    }
}
