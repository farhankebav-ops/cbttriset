package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import j2.q;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface EncodedData extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    MediaCodec.BufferInfo getBufferInfo();

    ByteBuffer getByteBuffer();

    q getClosedFuture();

    long getPresentationTimeUs();

    boolean isKeyFrame();

    long size();
}
