package androidx.camera.core.processing;

import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.ironsource.C2677ze;
import com.vungle.ads.AnalyticsClient;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3715a;

    public /* synthetic */ i(int i2) {
        this.f3715a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3715a) {
            case 0:
                DefaultSurfaceProcessor.lambda$executeSafely$11();
                break;
            case 1:
                DualSurfaceProcessor.lambda$executeSafely$7();
                break;
            case 2:
                CrashlyticsWorker.lambda$await$6();
                break;
            case 3:
                C2677ze.f();
                break;
            case 4:
                AnalyticsClient.m3242initOrUpdate$lambda1$lambda0();
                break;
            default:
                int i2 = AlarmManagerSchedulerBroadcastReceiver.f5211a;
                break;
        }
    }
}
