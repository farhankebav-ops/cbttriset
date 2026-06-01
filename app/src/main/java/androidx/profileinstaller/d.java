package androidx.profileinstaller;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f4060b;

    public /* synthetic */ d(Context context, int i2) {
        this.f4059a = i2;
        this.f4060b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4059a) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(this.f4060b);
                break;
            default:
                ProfileInstaller.writeProfile(this.f4060b);
                break;
        }
    }
}
