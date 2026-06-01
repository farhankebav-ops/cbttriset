package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.camera.video.internal.BufferProvider;
import j2.q;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface Encoder {
    public static final long NO_TIMESTAMP = -1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ByteBufferInput extends EncoderInput, BufferProvider<InputBuffer> {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface EncoderInput {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface SurfaceInput extends EncoderInput {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public interface OnSurfaceUpdateListener {
            void onSurfaceUpdate(Surface surface);
        }

        void setOnSurfaceUpdateListener(Executor executor, OnSurfaceUpdateListener onSurfaceUpdateListener);
    }

    int getConfiguredBitrate();

    EncoderInfo getEncoderInfo();

    EncoderInput getInput();

    q getReleasedFuture();

    void pause();

    void release();

    void requestKeyFrame();

    void setEncoderCallback(EncoderCallback encoderCallback, Executor executor);

    void start();

    void stop();

    void stop(long j);
}
