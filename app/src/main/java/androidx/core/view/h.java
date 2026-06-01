package androidx.core.view;

import android.view.View;
import androidx.core.view.SoftwareKeyboardControllerCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3979b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f3978a = i2;
        this.f3979b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3978a) {
            case 0:
                SoftwareKeyboardControllerCompat.Impl20.lambda$show$0((View) this.f3979b);
                break;
            default:
                ((e6.a) this.f3979b).invoke();
                break;
        }
    }
}
