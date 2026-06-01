package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import j2.q;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class EncodedDataImpl implements EncodedData {
    private final int mBufferIndex;
    private final MediaCodec.BufferInfo mBufferInfo;
    private final ByteBuffer mByteBuffer;
    private final AtomicBoolean mClosed = new AtomicBoolean(false);
    private final CallbackToFutureAdapter.Completer<Void> mClosedCompleter;
    private final q mClosedFuture;
    private final MediaCodec mMediaCodec;

    public EncodedDataImpl(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) throws MediaCodec.CodecException {
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(mediaCodec);
        this.mBufferIndex = i2;
        this.mByteBuffer = mediaCodec.getOutputBuffer(i2);
        this.mBufferInfo = (MediaCodec.BufferInfo) Preconditions.checkNotNull(bufferInfo);
        AtomicReference atomicReference = new AtomicReference();
        this.mClosedFuture = CallbackToFutureAdapter.getFuture(new n(atomicReference, 2));
        this.mClosedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "Data closed";
    }

    private void throwIfClosed() {
        if (this.mClosed.get()) {
            throw new IllegalStateException("encoded data is closed.");
        }
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData, java.lang.AutoCloseable
    public void close() {
        if (this.mClosed.getAndSet(true)) {
            return;
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(this.mBufferIndex, false);
            this.mClosedCompleter.set(null);
        } catch (IllegalStateException e) {
            this.mClosedCompleter.setException(e);
        }
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public MediaCodec.BufferInfo getBufferInfo() {
        return this.mBufferInfo;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public ByteBuffer getByteBuffer() {
        throwIfClosed();
        this.mByteBuffer.position(this.mBufferInfo.offset);
        ByteBuffer byteBuffer = this.mByteBuffer;
        MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        return this.mByteBuffer;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public q getClosedFuture() {
        return Futures.nonCancellationPropagating(this.mClosedFuture);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long getPresentationTimeUs() {
        return this.mBufferInfo.presentationTimeUs;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public boolean isKeyFrame() {
        return (this.mBufferInfo.flags & 1) != 0;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long size() {
        return this.mBufferInfo.size;
    }
}
