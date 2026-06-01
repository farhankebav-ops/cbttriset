package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f4054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4056d;

    public /* synthetic */ b(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i2, Object obj, int i8) {
        this.f4053a = i8;
        this.f4054b = diagnosticsCallback;
        this.f4055c = i2;
        this.f4056d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4053a) {
            case 0:
                this.f4054b.onResultReceived(this.f4055c, this.f4056d);
                break;
            default:
                this.f4054b.onDiagnosticReceived(this.f4055c, this.f4056d);
                break;
        }
    }
}
