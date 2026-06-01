package androidx.camera.video.internal.workaround;

import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.encoder.TimeProvider;
import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class VideoTimebaseConverter {
    private static final String TAG = "VideoTimebaseConverter";
    private static final long UPTIME_REALTIME_DIFF_THRESHOLD_US = 3000000;
    private final CameraUseInconsistentTimebaseQuirk mCameraUseInconsistentTimebaseQuirk;
    private final Timebase mInputTimebase;
    private Timebase mResolvedInputTimebase;
    private final TimeProvider mTimeProvider;
    private long mUptimeToRealtimeOffsetUs = -1;

    /* JADX INFO: renamed from: androidx.camera.video.internal.workaround.VideoTimebaseConverter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$Timebase;

        static {
            int[] iArr = new int[Timebase.values().length];
            $SwitchMap$androidx$camera$core$impl$Timebase = iArr;
            try {
                iArr[Timebase.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$Timebase[Timebase.UPTIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public VideoTimebaseConverter(TimeProvider timeProvider, Timebase timebase, CameraUseInconsistentTimebaseQuirk cameraUseInconsistentTimebaseQuirk) {
        this.mTimeProvider = timeProvider;
        this.mInputTimebase = timebase;
        this.mCameraUseInconsistentTimebaseQuirk = cameraUseInconsistentTimebaseQuirk;
    }

    private long calculateUptimeToRealtimeOffsetUs() {
        long j = LocationRequestCompat.PASSIVE_INTERVAL;
        long j3 = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            long jUptimeUs = this.mTimeProvider.uptimeUs();
            long jRealtimeUs = this.mTimeProvider.realtimeUs();
            long jUptimeUs2 = this.mTimeProvider.uptimeUs();
            long j8 = jUptimeUs2 - jUptimeUs;
            if (i2 == 0 || j8 < j) {
                j3 = jRealtimeUs - ((jUptimeUs + jUptimeUs2) >> 1);
                j = j8;
            }
        }
        return Math.max(0L, j3);
    }

    private boolean exceedUptimeRealtimeDiffThreshold() {
        return this.mTimeProvider.realtimeUs() - this.mTimeProvider.uptimeUs() > UPTIME_REALTIME_DIFF_THRESHOLD_US;
    }

    private boolean isCloseToRealtime(long j) {
        return Math.abs(j - this.mTimeProvider.realtimeUs()) < Math.abs(j - this.mTimeProvider.uptimeUs());
    }

    private Timebase resolveInputTimebase(long j) {
        boolean z2;
        String str;
        if (this.mCameraUseInconsistentTimebaseQuirk != null) {
            Logger.w(TAG, "CameraUseInconsistentTimebaseQuirk is enabled");
            z2 = false;
        } else {
            if (!exceedUptimeRealtimeDiffThreshold()) {
                return this.mInputTimebase;
            }
            z2 = true;
        }
        Timebase timebase = isCloseToRealtime(j) ? Timebase.REALTIME : Timebase.UPTIME;
        if (!z2 || timebase == this.mInputTimebase) {
            Logger.d(TAG, "Detect input timebase = " + timebase);
            return timebase;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            str = ", SOC: " + Build.SOC_MODEL;
        } else {
            str = "";
        }
        Logger.e(TAG, String.format("Detected camera timebase inconsistent. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, Hardware: %s, API Level: %d%s].\nCamera timebase is inconsistent. The timebase reported by the camera is %s, but the actual timebase contained in the frame is detected as %s.", Build.MANUFACTURER, Build.MODEL, Build.HARDWARE, Integer.valueOf(i2), str, this.mInputTimebase, timebase));
        return timebase;
    }

    public long convertToUptimeUs(long j) {
        if (this.mResolvedInputTimebase == null) {
            this.mResolvedInputTimebase = resolveInputTimebase(j);
        }
        int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$Timebase[this.mResolvedInputTimebase.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return j;
            }
            throw new AssertionError("Unknown timebase: " + this.mResolvedInputTimebase);
        }
        if (this.mUptimeToRealtimeOffsetUs == -1) {
            this.mUptimeToRealtimeOffsetUs = calculateUptimeToRealtimeOffsetUs();
            Logger.d(TAG, "mUptimeToRealtimeOffsetUs = " + this.mUptimeToRealtimeOffsetUs);
        }
        return j - this.mUptimeToRealtimeOffsetUs;
    }
}
