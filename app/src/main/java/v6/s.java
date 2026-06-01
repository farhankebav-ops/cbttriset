package v6;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import q6.s1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class s extends b implements s1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17647d = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17648c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public s(long j, s sVar, int i2) {
        super(sVar);
        this.f17648c = j;
        this.cleanedAndPointers$volatile = i2 << 16;
    }

    @Override // v6.b
    public final boolean d() {
        return f17647d.get(this) == g() && c() != null;
    }

    public final boolean f() {
        return f17647d.addAndGet(this, SupportMenu.CATEGORY_MASK) == g() && c() != null;
    }

    public abstract int g();

    public abstract void h(int i2, v5.h hVar);

    public final void i() {
        if (f17647d.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f17647d;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 == g() && c() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
