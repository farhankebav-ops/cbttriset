package e3;

import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TestSuiteActivity f11254b;

    public /* synthetic */ a(TestSuiteActivity testSuiteActivity, int i2) {
        this.f11253a = i2;
        this.f11254b = testSuiteActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11253a) {
            case 0:
                TestSuiteActivity.a(this.f11254b);
                break;
            default:
                TestSuiteActivity.b(this.f11254b);
                break;
        }
    }
}
