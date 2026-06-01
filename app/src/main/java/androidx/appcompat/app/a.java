package androidx.appcompat.app;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f3337b;

    public /* synthetic */ a(Context context, int i2) {
        this.f3336a = i2;
        this.f3337b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3336a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.f3337b);
                break;
            default:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.f3337b);
                break;
        }
    }
}
