package androidx.camera.extensions.internal.compat.workaround;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.extensions.internal.compat.quirk.CrashWhenOnDisableTooSoon;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class OnEnableDisableSessionDurationCheck {

    @VisibleForTesting
    static final long MIN_DURATION_FOR_ENABLE_DISABLE_SESSION = 100;
    private static final String TAG = "OnEnableDisableSessionDurationCheck";
    private final boolean mEnabledMinimumDuration;
    private long mOnEnableSessionTimeStamp;

    public OnEnableDisableSessionDurationCheck() {
        this(DeviceQuirks.get(CrashWhenOnDisableTooSoon.class) != null);
    }

    private void ensureMinDurationAfterOnEnableSession() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mOnEnableSessionTimeStamp;
        while (true) {
            long j3 = jElapsedRealtime - j;
            if (j3 >= MIN_DURATION_FOR_ENABLE_DISABLE_SESSION) {
                return;
            }
            long j8 = MIN_DURATION_FOR_ENABLE_DISABLE_SESSION - j3;
            try {
                Logger.d(TAG, "onDisableSession too soon, wait " + j8 + " ms");
                Thread.sleep(j8);
                jElapsedRealtime = SystemClock.elapsedRealtime();
                j = this.mOnEnableSessionTimeStamp;
            } catch (InterruptedException unused) {
                Logger.e(TAG, "sleep interrupted");
                return;
            }
        }
    }

    public void onDisableSessionInvoked() {
        if (this.mEnabledMinimumDuration) {
            ensureMinDurationAfterOnEnableSession();
        }
    }

    public void onEnableSessionInvoked() {
        if (this.mEnabledMinimumDuration) {
            this.mOnEnableSessionTimeStamp = SystemClock.elapsedRealtime();
        }
    }

    @VisibleForTesting
    public OnEnableDisableSessionDurationCheck(boolean z2) {
        this.mOnEnableSessionTimeStamp = 0L;
        this.mEnabledMinimumDuration = z2;
    }
}
