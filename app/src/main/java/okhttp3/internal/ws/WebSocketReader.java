package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import l7.h;
import l7.j;
import l7.l;
import l7.m;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final j controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final h maskCursor;
    private final byte[] maskKey;
    private final j messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final l source;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface FrameCallback {
        void onReadClose(int i2, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(m mVar) throws IOException;

        void onReadPing(m mVar);

        void onReadPong(m mVar);
    }

    public WebSocketReader(boolean z2, l source, FrameCallback frameCallback, boolean z7, boolean z8) {
        k.e(source, "source");
        k.e(frameCallback, "frameCallback");
        this.isClient = z2;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z7;
        this.noContextTakeover = z8;
        this.controlFrameBuffer = new j();
        this.messageFrameBuffer = new j();
        this.maskKey = z2 ? null : new byte[4];
        this.maskCursor = z2 ? null : new h();
    }

    private final void readControlFrame() throws IOException {
        short s7;
        String strR;
        long j = this.frameLength;
        if (j > 0) {
            this.source.d(this.controlFrameBuffer, j);
            if (!this.isClient) {
                j jVar = this.controlFrameBuffer;
                h hVar = this.maskCursor;
                k.b(hVar);
                jVar.n(hVar);
                this.maskCursor.b(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                h hVar2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                k.b(bArr);
                webSocketProtocol.toggleMask(hVar2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                j jVar2 = this.controlFrameBuffer;
                long j3 = jVar2.f12868b;
                if (j3 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j3 != 0) {
                    s7 = jVar2.readShort();
                    strR = this.controlFrameBuffer.r();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s7);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    s7 = 1005;
                    strR = "";
                }
                this.frameCallback.onReadClose(s7, strR);
                this.closed = true;
                return;
            case 9:
                FrameCallback frameCallback = this.frameCallback;
                j jVar3 = this.controlFrameBuffer;
                frameCallback.onReadPing(jVar3.J(jVar3.f12868b));
                return;
            case 10:
                FrameCallback frameCallback2 = this.frameCallback;
                j jVar4 = this.controlFrameBuffer;
                frameCallback2.onReadPong(jVar4.J(jVar4.f12868b));
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + _UtilJvmKt.toHexString(this.opcode));
        }
    }

    private final void readHeader() throws IOException {
        boolean z2;
        if (this.closed) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int iAnd = _UtilCommonKt.and(this.source.readByte(), 255);
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            int i2 = iAnd & 15;
            this.opcode = i2;
            boolean z7 = (iAnd & 128) != 0;
            this.isFinalFrame = z7;
            boolean z8 = (iAnd & 8) != 0;
            this.isControlFrame = z8;
            if (z8 && !z7) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z9 = (iAnd & 64) != 0;
            if (i2 == 1 || i2 == 2) {
                if (!z9) {
                    z2 = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z2 = true;
                }
                this.readingCompressedMessage = z2;
            } else if (z9) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iAnd & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iAnd & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iAnd2 = _UtilCommonKt.and(this.source.readByte(), 255);
            boolean z10 = (iAnd2 & 128) != 0;
            if (z10 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = iAnd2 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = _UtilCommonKt.and(this.source.readShort(), 65535);
            } else if (j == 127) {
                long j3 = this.source.readLong();
                this.frameLength = j3;
                if (j3 < 0) {
                    throw new ProtocolException("Frame length 0x" + _UtilJvmKt.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z10) {
                l lVar = this.source;
                byte[] bArr = this.maskKey;
                k.b(bArr);
                lVar.readFully(bArr);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.d(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    j jVar = this.messageFrameBuffer;
                    h hVar = this.maskCursor;
                    k.b(hVar);
                    jVar.n(hVar);
                    this.maskCursor.b(this.messageFrameBuffer.f12868b - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    h hVar2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    k.b(bArr);
                    webSocketProtocol.toggleMask(hVar2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + _UtilJvmKt.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i2 = this.opcode;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Unknown opcode: " + _UtilJvmKt.toHexString(i2));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i2 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.r());
            return;
        }
        FrameCallback frameCallback = this.frameCallback;
        j jVar = this.messageFrameBuffer;
        frameCallback.onReadMessage(jVar.J(jVar.f12868b));
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    public final l getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
