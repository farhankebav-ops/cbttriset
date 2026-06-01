package com.unity3d.ads.core.domain.work;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BackgroundWorker {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "UnityAdsBackgroundWorker";
    private final WorkManager workManager;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public BackgroundWorker(Context applicationContext) {
        k.e(applicationContext, "applicationContext");
        WorkManager workManager = WorkManager.getInstance(applicationContext);
        k.d(workManager, "getInstance(applicationContext)");
        this.workManager = workManager;
    }

    public final WorkManager getWorkManager() {
        return this.workManager;
    }

    public final <T extends UniversalRequestJob> void invoke(UniversalRequestWorkerData universalRequestWorkerData) {
        k.e(universalRequestWorkerData, "universalRequestWorkerData");
        k.d(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build(), "Builder()\n            .s…TED)\n            .build()");
        k.k();
        throw null;
    }
}
