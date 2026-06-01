package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f3983b;

    public /* synthetic */ l(ViewConfiguration viewConfiguration, int i2) {
        this.f3982a = i2;
        this.f3983b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int scaledMaximumFlingVelocity;
        switch (this.f3982a) {
            case 0:
                scaledMaximumFlingVelocity = this.f3983b.getScaledMaximumFlingVelocity();
                break;
            default:
                scaledMaximumFlingVelocity = this.f3983b.getScaledMinimumFlingVelocity();
                break;
        }
        return Integer.valueOf(scaledMaximumFlingVelocity);
    }
}
