package androidx.camera.video.internal.audio;

import android.media.AudioTimestamp;
import androidx.core.util.Preconditions;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioUtils {
    private AudioUtils() {
    }

    public static int channelCountToChannelConfig(int i2) {
        return i2 == 1 ? 16 : 12;
    }

    public static int channelCountToChannelMask(int i2) {
        return i2 == 1 ? 16 : 12;
    }

    public static long computeInterpolatedTimeNs(int i2, long j, AudioTimestamp audioTimestamp) {
        Preconditions.checkArgument(((long) i2) > 0, "sampleRate must be greater than 0.");
        Preconditions.checkArgument(j >= 0, "framePosition must be no less than 0.");
        long jFrameCountToDurationNs = audioTimestamp.nanoTime + frameCountToDurationNs(j - audioTimestamp.framePosition, i2);
        if (jFrameCountToDurationNs < 0) {
            return 0L;
        }
        return jFrameCountToDurationNs;
    }

    public static long frameCountToDurationNs(long j, int i2) {
        long j3 = i2;
        Preconditions.checkArgument(j3 > 0, "sampleRate must be greater than 0.");
        return (TimeUnit.SECONDS.toNanos(1L) * j) / j3;
    }

    public static long frameCountToSize(long j, int i2) {
        long j3 = i2;
        Preconditions.checkArgument(j3 > 0, "bytesPerFrame must be greater than 0.");
        return j * j3;
    }

    public static int getBytesPerFrame(int i2, int i8) {
        Preconditions.checkArgument(i8 > 0, "Invalid channel count: " + i8);
        if (i2 == 2) {
            return i8 * 2;
        }
        if (i2 == 3) {
            return i8;
        }
        if (i2 != 4) {
            if (i2 == 21) {
                return i8 * 3;
            }
            if (i2 != 22) {
                throw new IllegalArgumentException(a1.a.g(i2, "Invalid audio encoding: "));
            }
        }
        return i8 * 4;
    }

    public static long sizeToFrameCount(long j, int i2) {
        long j3 = i2;
        Preconditions.checkArgument(j3 > 0, "bytesPerFrame must be greater than 0.");
        return j / j3;
    }
}
