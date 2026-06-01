package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Recorder_RecordingRecord extends Recorder.RecordingRecord {
    private final Executor getCallbackExecutor;
    private final Consumer<VideoRecordEvent> getEventListener;
    private final OutputOptions getOutputOptions;
    private final long getRecordingId;
    private final boolean hasAudioEnabled;
    private final boolean isPersistent;

    public AutoValue_Recorder_RecordingRecord(OutputOptions outputOptions, Executor executor, Consumer<VideoRecordEvent> consumer, boolean z2, boolean z7, long j) {
        if (outputOptions == null) {
            throw new NullPointerException("Null getOutputOptions");
        }
        this.getOutputOptions = outputOptions;
        this.getCallbackExecutor = executor;
        this.getEventListener = consumer;
        this.hasAudioEnabled = z2;
        this.isPersistent = z7;
        this.getRecordingId = j;
    }

    public boolean equals(Object obj) {
        Executor executor;
        Consumer<VideoRecordEvent> consumer;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Recorder.RecordingRecord) {
            Recorder.RecordingRecord recordingRecord = (Recorder.RecordingRecord) obj;
            if (this.getOutputOptions.equals(recordingRecord.getOutputOptions()) && ((executor = this.getCallbackExecutor) != null ? executor.equals(recordingRecord.getCallbackExecutor()) : recordingRecord.getCallbackExecutor() == null) && ((consumer = this.getEventListener) != null ? consumer.equals(recordingRecord.getEventListener()) : recordingRecord.getEventListener() == null) && this.hasAudioEnabled == recordingRecord.hasAudioEnabled() && this.isPersistent == recordingRecord.isPersistent() && this.getRecordingId == recordingRecord.getRecordingId()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public Executor getCallbackExecutor() {
        return this.getCallbackExecutor;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public Consumer<VideoRecordEvent> getEventListener() {
        return this.getEventListener;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public OutputOptions getOutputOptions() {
        return this.getOutputOptions;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public long getRecordingId() {
        return this.getRecordingId;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public boolean hasAudioEnabled() {
        return this.hasAudioEnabled;
    }

    public int hashCode() {
        int iHashCode = (this.getOutputOptions.hashCode() ^ 1000003) * 1000003;
        Executor executor = this.getCallbackExecutor;
        int iHashCode2 = (iHashCode ^ (executor == null ? 0 : executor.hashCode())) * 1000003;
        Consumer<VideoRecordEvent> consumer = this.getEventListener;
        int iHashCode3 = (((iHashCode2 ^ (consumer != null ? consumer.hashCode() : 0)) * 1000003) ^ (this.hasAudioEnabled ? 1231 : 1237)) * 1000003;
        int i2 = this.isPersistent ? 1231 : 1237;
        long j = this.getRecordingId;
        return ((iHashCode3 ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public boolean isPersistent() {
        return this.isPersistent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RecordingRecord{getOutputOptions=");
        sb.append(this.getOutputOptions);
        sb.append(", getCallbackExecutor=");
        sb.append(this.getCallbackExecutor);
        sb.append(", getEventListener=");
        sb.append(this.getEventListener);
        sb.append(", hasAudioEnabled=");
        sb.append(this.hasAudioEnabled);
        sb.append(", isPersistent=");
        sb.append(this.isPersistent);
        sb.append(", getRecordingId=");
        return a1.a.p(sb, this.getRecordingId, "}");
    }
}
