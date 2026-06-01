package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f3351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f3353d;

    public /* synthetic */ b(EngagementSignalsCallback engagementSignalsCallback, boolean z2, Bundle bundle, int i2) {
        this.f3350a = i2;
        this.f3351b = engagementSignalsCallback;
        this.f3352c = z2;
        this.f3353d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3350a) {
            case 0:
                this.f3351b.onSessionEnded(this.f3352c, this.f3353d);
                break;
            case 1:
                this.f3351b.onVerticalScrollEvent(this.f3352c, this.f3353d);
                break;
            case 2:
                this.f3351b.onVerticalScrollEvent(this.f3352c, this.f3353d);
                break;
            default:
                this.f3351b.onSessionEnded(this.f3352c, this.f3353d);
                break;
        }
    }
}
