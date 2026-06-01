package androidx.camera.video.internal.audio;

import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SilentAudioStream implements AudioStream {
    private static final String TAG = "SilentAudioStream";
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBytesPerFrame;
    private Executor mCallbackExecutor;
    private long mCurrentReadTimeNs;
    private final int mSampleRate;
    private byte[] mZeroBytes;
    private final AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private final AtomicBoolean mIsReleased = new AtomicBoolean(false);

    public SilentAudioStream(AudioSettings audioSettings) {
        this.mBytesPerFrame = audioSettings.getBytesPerFrame();
        this.mSampleRate = audioSettings.getCaptureSampleRate();
    }

    private static void blockUntilSystemTimeReached(long j) {
        long jCurrentSystemTimeNs = j - currentSystemTimeNs();
        if (jCurrentSystemTimeNs > 0) {
            try {
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(jCurrentSystemTimeNs));
            } catch (InterruptedException e) {
                Logger.w(TAG, "Ignore interruption", e);
            }
        }
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private static long currentSystemTimeNs() {
        return System.nanoTime();
    }

    private void notifySilenced() {
        AudioStream.AudioStreamCallback audioStreamCallback = this.mAudioStreamCallback;
        Executor executor = this.mCallbackExecutor;
        if (audioStreamCallback == null || executor == null) {
            return;
        }
        executor.execute(new a3.b(audioStreamCallback, 9));
    }

    private void writeSilenceToBuffer(ByteBuffer byteBuffer, int i2) {
        Preconditions.checkState(i2 <= byteBuffer.remaining());
        byte[] bArr = this.mZeroBytes;
        if (bArr == null || bArr.length < i2) {
            this.mZeroBytes = new byte[i2];
        }
        int iPosition = byteBuffer.position();
        byteBuffer.put(this.mZeroBytes, 0, i2).limit(i2 + iPosition).position(iPosition);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer byteBuffer) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        long jSizeToFrameCount = AudioUtils.sizeToFrameCount(byteBuffer.remaining(), this.mBytesPerFrame);
        int iFrameCountToSize = (int) AudioUtils.frameCountToSize(jSizeToFrameCount, this.mBytesPerFrame);
        if (iFrameCountToSize <= 0) {
            return AudioStream.PacketInfo.of(0, this.mCurrentReadTimeNs);
        }
        long jFrameCountToDurationNs = this.mCurrentReadTimeNs + AudioUtils.frameCountToDurationNs(jSizeToFrameCount, this.mSampleRate);
        blockUntilSystemTimeReached(jFrameCountToDurationNs);
        writeSilenceToBuffer(byteBuffer, iFrameCountToSize);
        AudioStream.PacketInfo packetInfoOf = AudioStream.PacketInfo.of(iFrameCountToSize, this.mCurrentReadTimeNs);
        this.mCurrentReadTimeNs = jFrameCountToDurationNs;
        return packetInfoOf;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        this.mIsReleased.getAndSet(true);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(AudioStream.AudioStreamCallback audioStreamCallback, Executor executor) {
        boolean z2 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (audioStreamCallback != null && executor == null) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "executor can't be null with non-null callback.");
        this.mAudioStreamCallback = audioStreamCallback;
        this.mCallbackExecutor = executor;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true)) {
            return;
        }
        this.mCurrentReadTimeNs = currentSystemTimeNs();
        notifySilenced();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        this.mIsStarted.set(false);
    }
}
