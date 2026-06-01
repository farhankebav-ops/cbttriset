package com.vungle.ads.internal.downloader;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface AssetDownloadListener {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DownloadError {
        public static final Companion Companion = new Companion(null);
        public static final int DEFAULT_SERVER_CODE = -1;
        private final Throwable cause;

        @ErrorReason
        private final int reason;
        private final int serverCode;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ErrorReason {
            public static final Companion Companion = Companion.$$INSTANCE;

            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class Companion {
                private static int CONNECTION_ERROR;
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                private static int REQUEST_ERROR = 1;
                private static int DISK_ERROR = 2;
                private static int FILE_NOT_FOUND_ERROR = 3;
                private static int INTERNAL_ERROR = 4;

                private Companion() {
                }

                public final int getCONNECTION_ERROR() {
                    return CONNECTION_ERROR;
                }

                public final int getDISK_ERROR() {
                    return DISK_ERROR;
                }

                public final int getFILE_NOT_FOUND_ERROR() {
                    return FILE_NOT_FOUND_ERROR;
                }

                public final int getINTERNAL_ERROR() {
                    return INTERNAL_ERROR;
                }

                public final int getREQUEST_ERROR() {
                    return REQUEST_ERROR;
                }

                public final void setCONNECTION_ERROR(int i2) {
                    CONNECTION_ERROR = i2;
                }

                public final void setDISK_ERROR(int i2) {
                    DISK_ERROR = i2;
                }

                public final void setFILE_NOT_FOUND_ERROR(int i2) {
                    FILE_NOT_FOUND_ERROR = i2;
                }

                public final void setINTERNAL_ERROR(int i2) {
                    INTERNAL_ERROR = i2;
                }

                public final void setREQUEST_ERROR(int i2) {
                    REQUEST_ERROR = i2;
                }
            }
        }

        public DownloadError(int i2, Throwable cause, int i8) {
            k.e(cause, "cause");
            this.serverCode = i2;
            this.cause = cause;
            this.reason = i8;
        }

        public final Throwable getCause() {
            return this.cause;
        }

        public final int getReason() {
            return this.reason;
        }

        public final int getServerCode() {
            return this.serverCode;
        }

        public String toString() {
            return "DownloadError(serverCode=" + this.serverCode + ", reason=" + this.reason + ", cause=" + this.cause + ')';
        }
    }

    void onError(DownloadError downloadError, DownloadRequest downloadRequest);

    void onProgress(Progress progress, DownloadRequest downloadRequest);

    void onStart(DownloadRequest downloadRequest);

    void onSuccess(File file, DownloadRequest downloadRequest);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Progress {
        private int progressPercent;
        private long readBytes;
        private long sizeBytes;
        private int status;
        private long timestampDownloadStart;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ProgressStatus {
            public static final Companion Companion = Companion.$$INSTANCE;

            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class Companion {
                private static int STARTED;
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                private static int IN_PROGRESS = 1;
                private static int PAUSED = 2;
                private static int CANCELLED = 3;
                private static int DONE = 4;
                private static int LOST_CONNECTION = 5;
                private static int STATE_CHANGED = 6;
                private static int ERROR = 7;

                private Companion() {
                }

                public final int getCANCELLED() {
                    return CANCELLED;
                }

                public final int getDONE() {
                    return DONE;
                }

                public final int getERROR() {
                    return ERROR;
                }

                public final int getIN_PROGRESS() {
                    return IN_PROGRESS;
                }

                public final int getLOST_CONNECTION() {
                    return LOST_CONNECTION;
                }

                public final int getPAUSED() {
                    return PAUSED;
                }

                public final int getSTARTED() {
                    return STARTED;
                }

                public final int getSTATE_CHANGED() {
                    return STATE_CHANGED;
                }

                public final void setCANCELLED(int i2) {
                    CANCELLED = i2;
                }

                public final void setDONE(int i2) {
                    DONE = i2;
                }

                public final void setERROR(int i2) {
                    ERROR = i2;
                }

                public final void setIN_PROGRESS(int i2) {
                    IN_PROGRESS = i2;
                }

                public final void setLOST_CONNECTION(int i2) {
                    LOST_CONNECTION = i2;
                }

                public final void setPAUSED(int i2) {
                    PAUSED = i2;
                }

                public final void setSTARTED(int i2) {
                    STARTED = i2;
                }

                public final void setSTATE_CHANGED(int i2) {
                    STATE_CHANGED = i2;
                }
            }
        }

        public final int getProgressPercent() {
            return this.progressPercent;
        }

        public final long getReadBytes() {
            return this.readBytes;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final int getStatus() {
            return this.status;
        }

        public final long getTimestampDownloadStart() {
            return this.timestampDownloadStart;
        }

        public final void setProgressPercent(int i2) {
            this.progressPercent = i2;
        }

        public final void setReadBytes(long j) {
            this.readBytes = j;
        }

        public final void setSizeBytes(long j) {
            this.sizeBytes = j;
        }

        public final void setStatus(int i2) {
            this.status = i2;
        }

        public final void setTimestampDownloadStart(long j) {
            this.timestampDownloadStart = j;
        }

        public String toString() {
            return "Progress(status=" + this.status + ", percent=" + this.progressPercent + ", startAt=" + this.timestampDownloadStart + ", readed=" + this.readBytes + ", total=" + this.sizeBytes + ')';
        }

        @ProgressStatus
        public static /* synthetic */ void getStatus$annotations() {
        }
    }
}
