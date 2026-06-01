package j4;

import androidx.core.app.NotificationManagerCompat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f12340d;

    public n4(float f4, float f8) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f12340d = atomicInteger;
        this.f12339c = (int) (f8 * 1000.0f);
        int i2 = (int) (f4 * 1000.0f);
        this.f12337a = i2;
        this.f12338b = i2 / 2;
        atomicInteger.set(i2);
    }

    public final boolean a() {
        AtomicInteger atomicInteger;
        int i2;
        int i8;
        do {
            atomicInteger = this.f12340d;
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return false;
            }
            i8 = i2 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        } while (!atomicInteger.compareAndSet(i2, Math.max(i8, 0)));
        return i8 > this.f12338b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n4)) {
            return false;
        }
        n4 n4Var = (n4) obj;
        return this.f12337a == n4Var.f12337a && this.f12339c == n4Var.f12339c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f12337a), Integer.valueOf(this.f12339c));
    }
}
