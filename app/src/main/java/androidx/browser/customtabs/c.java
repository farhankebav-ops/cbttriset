package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f3355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f3357d;

    public /* synthetic */ c(EngagementSignalsCallback engagementSignalsCallback, int i2, Bundle bundle, int i8) {
        this.f3354a = i8;
        this.f3355b = engagementSignalsCallback;
        this.f3356c = i2;
        this.f3357d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3354a) {
            case 0:
                this.f3355b.onGreatestScrollPercentageIncreased(this.f3356c, this.f3357d);
                break;
            default:
                this.f3355b.onGreatestScrollPercentageIncreased(this.f3356c, this.f3357d);
                break;
        }
    }
}
