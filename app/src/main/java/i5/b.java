package i5;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c[] f11988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11989c;

    public b(int i2, ThreadFactory threadFactory) {
        this.f11987a = i2;
        this.f11988b = new c[i2];
        for (int i8 = 0; i8 < i2; i8++) {
            this.f11988b[i8] = new c(threadFactory);
        }
    }
}
