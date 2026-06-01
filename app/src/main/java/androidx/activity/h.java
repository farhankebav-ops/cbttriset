package androidx.activity;

import androidx.activity.ComponentActivity;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3308b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f3307a = i2;
        this.f3308b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3307a) {
            case 0:
                ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0((ComponentActivity.ReportFullyDrawnExecutorImpl) this.f3308b);
                break;
            case 1:
                super/*android.app.Dialog*/.onBackPressed();
                break;
            default:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) this.f3308b);
                break;
        }
    }
}
