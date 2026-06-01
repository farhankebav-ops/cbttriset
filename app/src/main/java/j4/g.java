package j4;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f12198a;

    public g(int i2) {
        switch (i2) {
            case 1:
                this.f12198a = new AtomicLong();
                break;
            default:
                this.f12198a = new AtomicLong();
                break;
        }
    }

    @Override // j4.c2
    public void a() {
        this.f12198a.getAndAdd(1L);
    }
}
