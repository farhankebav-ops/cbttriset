package androidx.camera.video;

import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RecordingStats {
    public static RecordingStats of(long j, long j3, AudioStats audioStats) {
        Preconditions.checkArgument(j >= 0, "duration must be positive value.");
        Preconditions.checkArgument(j3 >= 0, "bytes must be positive value.");
        return new AutoValue_RecordingStats(j, j3, audioStats);
    }

    public abstract AudioStats getAudioStats();

    public abstract long getNumBytesRecorded();

    public abstract long getRecordedDurationNanos();
}
