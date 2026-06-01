package androidx.camera.video;

import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VideoRecordEvent {
    private final OutputOptions mOutputOptions;
    private final RecordingStats mRecordingStats;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Finalize extends VideoRecordEvent {
        public static final int ERROR_DURATION_LIMIT_REACHED = 9;
        public static final int ERROR_ENCODING_FAILED = 6;
        public static final int ERROR_FILE_SIZE_LIMIT_REACHED = 2;
        public static final int ERROR_INSUFFICIENT_STORAGE = 3;
        public static final int ERROR_INVALID_OUTPUT_OPTIONS = 5;
        public static final int ERROR_NONE = 0;
        public static final int ERROR_NO_VALID_DATA = 8;
        public static final int ERROR_RECORDER_ERROR = 7;
        public static final int ERROR_RECORDING_GARBAGE_COLLECTED = 10;
        public static final int ERROR_SOURCE_INACTIVE = 4;
        public static final int ERROR_UNKNOWN = 1;
        private final Throwable mCause;
        private final int mError;
        private final OutputResults mOutputResults;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface VideoRecordError {
        }

        public Finalize(OutputOptions outputOptions, RecordingStats recordingStats, OutputResults outputResults, int i2, Throwable th) {
            super(outputOptions, recordingStats);
            this.mOutputResults = outputResults;
            this.mError = i2;
            this.mCause = th;
        }

        public static String errorToString(int i2) {
            switch (i2) {
                case 0:
                    return "ERROR_NONE";
                case 1:
                    return "ERROR_UNKNOWN";
                case 2:
                    return "ERROR_FILE_SIZE_LIMIT_REACHED";
                case 3:
                    return "ERROR_INSUFFICIENT_STORAGE";
                case 4:
                    return "ERROR_SOURCE_INACTIVE";
                case 5:
                    return "ERROR_INVALID_OUTPUT_OPTIONS";
                case 6:
                    return "ERROR_ENCODING_FAILED";
                case 7:
                    return "ERROR_RECORDER_ERROR";
                case 8:
                    return "ERROR_NO_VALID_DATA";
                case 9:
                    return "ERROR_DURATION_LIMIT_REACHED";
                case 10:
                    return "ERROR_RECORDING_GARBAGE_COLLECTED";
                default:
                    return a1.a.h(i2, "Unknown(", ")");
            }
        }

        public Throwable getCause() {
            return this.mCause;
        }

        public int getError() {
            return this.mError;
        }

        public OutputResults getOutputResults() {
            return this.mOutputResults;
        }

        public boolean hasError() {
            return this.mError != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Pause extends VideoRecordEvent {
        public Pause(OutputOptions outputOptions, RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Resume extends VideoRecordEvent {
        public Resume(OutputOptions outputOptions, RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Start extends VideoRecordEvent {
        public Start(OutputOptions outputOptions, RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Status extends VideoRecordEvent {
        public Status(OutputOptions outputOptions, RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    public VideoRecordEvent(OutputOptions outputOptions, RecordingStats recordingStats) {
        this.mOutputOptions = (OutputOptions) Preconditions.checkNotNull(outputOptions);
        this.mRecordingStats = (RecordingStats) Preconditions.checkNotNull(recordingStats);
    }

    public static Finalize finalize(OutputOptions outputOptions, RecordingStats recordingStats, OutputResults outputResults) {
        return new Finalize(outputOptions, recordingStats, outputResults, 0, null);
    }

    public static Finalize finalizeWithError(OutputOptions outputOptions, RecordingStats recordingStats, OutputResults outputResults, int i2, Throwable th) {
        Preconditions.checkArgument(i2 != 0, "An error type is required.");
        return new Finalize(outputOptions, recordingStats, outputResults, i2, th);
    }

    public static Pause pause(OutputOptions outputOptions, RecordingStats recordingStats) {
        return new Pause(outputOptions, recordingStats);
    }

    public static Resume resume(OutputOptions outputOptions, RecordingStats recordingStats) {
        return new Resume(outputOptions, recordingStats);
    }

    public static Start start(OutputOptions outputOptions, RecordingStats recordingStats) {
        return new Start(outputOptions, recordingStats);
    }

    public static Status status(OutputOptions outputOptions, RecordingStats recordingStats) {
        return new Status(outputOptions, recordingStats);
    }

    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    public RecordingStats getRecordingStats() {
        return this.mRecordingStats;
    }
}
