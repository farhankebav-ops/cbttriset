package h5;

import a5.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends AtomicReferenceArray implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f11721f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f11723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f11725d;
    public final int e;

    public a(int i2) {
        super(1 << (32 - Integer.numberOfLeadingZeros(i2 - 1)));
        this.f11722a = length() - 1;
        this.f11723b = new AtomicLong();
        this.f11725d = new AtomicLong();
        this.e = Math.min(i2 / 4, f11721f.intValue());
    }

    @Override // a5.h
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.f11723b.get() == this.f11725d.get();
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicLong atomicLong = this.f11723b;
        long j = atomicLong.get();
        int i2 = this.f11722a;
        int i8 = ((int) j) & i2;
        if (j >= this.f11724c) {
            long j3 = ((long) this.e) + j;
            if (get(i2 & ((int) j3)) == null) {
                this.f11724c = j3;
            } else if (get(i8) != null) {
                return false;
            }
        }
        lazySet(i8, obj);
        atomicLong.lazySet(j + 1);
        return true;
    }

    @Override // a5.h
    public final Object poll() {
        AtomicLong atomicLong = this.f11725d;
        long j = atomicLong.get();
        int i2 = ((int) j) & this.f11722a;
        Object obj = get(i2);
        if (obj == null) {
            return null;
        }
        atomicLong.lazySet(j + 1);
        lazySet(i2, null);
        return obj;
    }
}
