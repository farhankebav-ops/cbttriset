package androidx.camera.featurecombinationquery;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraDeviceSetupCompat {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SupportQueryResult {
        public static final int RESULT_SUPPORTED = 1;
        public static final int RESULT_UNDEFINED = 0;
        public static final int RESULT_UNSUPPORTED = 2;
        public static final int SOURCE_ANDROID_FRAMEWORK = 2;
        public static final int SOURCE_PLAY_SERVICES = 1;
        public static final int SOURCE_UNDEFINED = 0;
        private final int mSource;
        private final int mSupported;
        private final long mTimestampMillis;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface Supported {
        }

        public SupportQueryResult(int i2, int i8, long j) {
            this.mSupported = i2;
            this.mSource = i8;
            this.mTimestampMillis = j;
        }

        public int getSource() {
            return this.mSource;
        }

        public int getSupported() {
            return this.mSupported;
        }

        public long getTimestampMillis() {
            return this.mTimestampMillis;
        }
    }

    SupportQueryResult isSessionConfigurationSupported(SessionConfiguration sessionConfiguration) throws CameraAccessException;

    SupportQueryResult isSessionConfigurationSupportedLegacy(SessionConfigurationLegacy sessionConfigurationLegacy);
}
