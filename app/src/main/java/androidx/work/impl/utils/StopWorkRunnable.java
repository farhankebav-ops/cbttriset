package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StopWorkRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("StopWorkRunnable");
    private final boolean mStopInForeground;
    private final StartStopToken mToken;
    private final WorkManagerImpl mWorkManagerImpl;

    public StopWorkRunnable(@NonNull WorkManagerImpl workManagerImpl, @NonNull StartStopToken startStopToken, boolean z2) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mToken = startStopToken;
        this.mStopInForeground = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zStopForegroundWork = this.mStopInForeground ? this.mWorkManagerImpl.getProcessor().stopForegroundWork(this.mToken) : this.mWorkManagerImpl.getProcessor().stopWork(this.mToken);
        Logger.get().debug(TAG, "StopWorkRunnable for " + this.mToken.getId().getWorkSpecId() + "; Processor.stopWork = " + zStopForegroundWork);
    }
}
