package androidx.camera.video.internal.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager$AudioRecordingCallback;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.compat.Api23Impl;
import androidx.camera.video.internal.compat.Api24Impl;
import androidx.camera.video.internal.compat.Api29Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.camera.video.internal.compat.quirk.AudioTimestampFramePositionIncorrectQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AudioStreamImpl implements AudioStream {
    private static final long DIFF_LIMIT_FROM_SYSTEM_TIME_NS = TimeUnit.MILLISECONDS.toNanos(500);
    private static final String TAG = "AudioStreamImpl";
    private AudioRecord mAudioRecord;
    private AudioManager$AudioRecordingCallback mAudioRecordingCallback;
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBufferSize;
    private final int mBytesPerFrame;
    private Executor mCallbackExecutor;
    private final AudioSettings mSettings;
    private long mTotalFramesRead;
    private final AtomicBoolean mIsReleased = new AtomicBoolean(false);
    private final AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private final AtomicReference<Boolean> mNotifiedSilenceState = new AtomicReference<>(null);
    private boolean mShouldFallbackToSystemTime = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(29)
    public class AudioRecordingApi29Callback extends AudioManager$AudioRecordingCallback {
        public AudioRecordingApi29Callback() {
        }

        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            Iterator<AudioRecordingConfiguration> it = list.iterator();
            while (it.hasNext()) {
                AudioRecordingConfiguration audioRecordingConfigurationL = androidx.appcompat.app.c.l(it.next());
                if (Api24Impl.getClientAudioSessionId(audioRecordingConfigurationL) == AudioStreamImpl.this.mAudioRecord.getAudioSessionId()) {
                    AudioStreamImpl.this.notifySilenced(Api29Impl.isClientSilenced(audioRecordingConfigurationL));
                    return;
                }
            }
        }
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public AudioStreamImpl(AudioSettings audioSettings, Context context) throws AudioStream.AudioStreamException, IllegalArgumentException {
        if (!isSettingsSupported(audioSettings.getCaptureSampleRate(), audioSettings.getChannelCount(), audioSettings.getAudioFormat())) {
            throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", Integer.valueOf(audioSettings.getCaptureSampleRate()), Integer.valueOf(audioSettings.getChannelCount()), Integer.valueOf(audioSettings.getAudioFormat())));
        }
        this.mSettings = audioSettings;
        this.mBytesPerFrame = audioSettings.getBytesPerFrame();
        int minBufferSize = getMinBufferSize(audioSettings.getCaptureSampleRate(), audioSettings.getChannelCount(), audioSettings.getAudioFormat());
        Preconditions.checkState(minBufferSize > 0);
        int i2 = minBufferSize * 2;
        this.mBufferSize = i2;
        AudioRecord audioRecordCreateAudioRecord = createAudioRecord(i2, audioSettings, context);
        this.mAudioRecord = audioRecordCreateAudioRecord;
        checkAudioRecordInitialStateOrReleaseAndThrow(audioRecordCreateAudioRecord);
    }

    private static void checkAudioRecordInitialStateOrReleaseAndThrow(AudioRecord audioRecord) throws AudioStream.AudioStreamException {
        if (audioRecord.getState() == 1) {
            return;
        }
        audioRecord.release();
        throw new AudioStream.AudioStreamException("Unable to initialize AudioRecord");
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private static AudioFormat createAudioFormat(AudioSettings audioSettings) throws IllegalArgumentException {
        return createAudioFormat(audioSettings.getCaptureSampleRate(), audioSettings.getChannelCount(), audioSettings.getAudioFormat());
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    private static AudioRecord createAudioRecord(int i2, AudioSettings audioSettings, Context context) throws IllegalArgumentException {
        int i8 = Build.VERSION.SDK_INT;
        AudioFormat audioFormatCreateAudioFormat = createAudioFormat(audioSettings);
        AudioRecord.Builder builderCreateAudioRecordBuilder = Api23Impl.createAudioRecordBuilder();
        if (i8 >= 31 && context != null) {
            Api31Impl.setContext(builderCreateAudioRecordBuilder, context);
        }
        Api23Impl.setAudioSource(builderCreateAudioRecordBuilder, audioSettings.getAudioSource());
        Api23Impl.setAudioFormat(builderCreateAudioRecordBuilder, audioFormatCreateAudioFormat);
        Api23Impl.setBufferSizeInBytes(builderCreateAudioRecordBuilder, i2);
        try {
            return Api23Impl.build(builderCreateAudioRecordBuilder);
        } catch (UnsupportedOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private long generatePresentationTimeNs() {
        long jComputeInterpolatedTimeNs;
        if (Build.VERSION.SDK_INT < 24 || this.mShouldFallbackToSystemTime) {
            jComputeInterpolatedTimeNs = -1;
        } else {
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            if (Api24Impl.getTimestamp(this.mAudioRecord, audioTimestamp, 0) == 0) {
                jComputeInterpolatedTimeNs = AudioUtils.computeInterpolatedTimeNs(this.mSettings.getCaptureSampleRate(), this.mTotalFramesRead, audioTimestamp);
                if (Math.abs(jComputeInterpolatedTimeNs - System.nanoTime()) > DIFF_LIMIT_FROM_SYSTEM_TIME_NS) {
                    this.mShouldFallbackToSystemTime = true;
                }
            } else {
                Logger.w(TAG, "Unable to get audio timestamp");
            }
            jComputeInterpolatedTimeNs = -1;
        }
        return jComputeInterpolatedTimeNs == -1 ? System.nanoTime() : jComputeInterpolatedTimeNs;
    }

    private static int getMinBufferSize(int i2, int i8, int i9) {
        return AudioRecord.getMinBufferSize(i2, AudioUtils.channelCountToChannelConfig(i8), i9);
    }

    private static boolean hasAudioTimestampQuirk() {
        return DeviceQuirks.get(AudioTimestampFramePositionIncorrectQuirk.class) != null;
    }

    public static boolean isSettingsSupported(int i2, int i8, int i9) {
        if (i2 <= 0 || i8 <= 0 || getMinBufferSize(i2, i8, i9) <= 0) {
            return false;
        }
        try {
            createAudioFormat(i2, i8, i9);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void notifySilenced(boolean z2) {
        Executor executor = this.mCallbackExecutor;
        AudioStream.AudioStreamCallback audioStreamCallback = this.mAudioStreamCallback;
        if (executor == null || audioStreamCallback == null || Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(z2)), Boolean.valueOf(z2))) {
            return;
        }
        executor.execute(new androidx.camera.camera2.interop.c(audioStreamCallback, z2, 1));
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer byteBuffer) {
        long jGeneratePresentationTimeNs;
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        int i2 = this.mAudioRecord.read(byteBuffer, this.mBufferSize);
        if (i2 > 0) {
            byteBuffer.limit(i2);
            jGeneratePresentationTimeNs = generatePresentationTimeNs();
            this.mTotalFramesRead = AudioUtils.sizeToFrameCount(i2, this.mBytesPerFrame) + this.mTotalFramesRead;
        } else {
            jGeneratePresentationTimeNs = 0;
        }
        return AudioStream.PacketInfo.of(i2, jGeneratePresentationTimeNs);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        AudioManager$AudioRecordingCallback audioManager$AudioRecordingCallback;
        if (this.mIsReleased.getAndSet(true)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29 && (audioManager$AudioRecordingCallback = this.mAudioRecordingCallback) != null) {
            Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, audioManager$AudioRecordingCallback);
        }
        this.mAudioRecord.release();
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
        if (Build.VERSION.SDK_INT >= 29) {
            AudioManager$AudioRecordingCallback audioManager$AudioRecordingCallback = this.mAudioRecordingCallback;
            if (audioManager$AudioRecordingCallback != null) {
                Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, audioManager$AudioRecordingCallback);
            }
            if (audioStreamCallback == null) {
                return;
            }
            if (this.mAudioRecordingCallback == null) {
                this.mAudioRecordingCallback = new AudioRecordingApi29Callback();
            }
            Api29Impl.registerAudioRecordingCallback(this.mAudioRecord, executor, this.mAudioRecordingCallback);
        }
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true)) {
            return;
        }
        if (hasAudioTimestampQuirk()) {
            checkAudioRecordInitialStateOrReleaseAndThrow(this.mAudioRecord);
        }
        this.mAudioRecord.startRecording();
        boolean z2 = false;
        if (this.mAudioRecord.getRecordingState() != 3) {
            this.mIsStarted.set(false);
            throw new AudioStream.AudioStreamException("Unable to start AudioRecord with state: " + this.mAudioRecord.getRecordingState());
        }
        this.mTotalFramesRead = 0L;
        this.mShouldFallbackToSystemTime = false;
        this.mNotifiedSilenceState.set(null);
        if (Build.VERSION.SDK_INT >= 29) {
            AudioRecordingConfiguration activeRecordingConfiguration = Api29Impl.getActiveRecordingConfiguration(this.mAudioRecord);
            z2 = activeRecordingConfiguration != null && Api29Impl.isClientSilenced(activeRecordingConfiguration);
        }
        notifySilenced(z2);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false)) {
            this.mAudioRecord.stop();
            if (this.mAudioRecord.getRecordingState() != 1) {
                Logger.w(TAG, "Failed to stop AudioRecord with state: " + this.mAudioRecord.getRecordingState());
            }
            if (hasAudioTimestampQuirk()) {
                this.mAudioRecord.release();
                this.mAudioRecord = createAudioRecord(this.mBufferSize, this.mSettings, null);
            }
        }
    }

    private static AudioFormat createAudioFormat(int i2, int i8, int i9) throws IllegalArgumentException {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(AudioUtils.channelCountToChannelMask(i8)).setEncoding(i9).build();
    }
}
