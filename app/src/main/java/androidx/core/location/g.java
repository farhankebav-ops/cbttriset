package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f3937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Location f3938c;

    public /* synthetic */ g(Consumer consumer, Location location, int i2) {
        this.f3936a = i2;
        this.f3937b = consumer;
        this.f3938c = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3936a) {
            case 0:
                this.f3937b.accept(this.f3938c);
                break;
            default:
                this.f3937b.accept(this.f3938c);
                break;
        }
    }
}
