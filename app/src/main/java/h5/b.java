package h5;

import a5.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11726i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f11727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11730d;
    public AtomicReferenceArray e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f11731f;
    public AtomicReferenceArray g;
    public final AtomicLong h;

    public b(int i2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f11727a = atomicLong;
        this.h = new AtomicLong();
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i2) - 1));
        int i8 = iNumberOfLeadingZeros - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iNumberOfLeadingZeros + 1);
        this.e = atomicReferenceArray;
        this.f11730d = i8;
        this.f11728b = Math.min(iNumberOfLeadingZeros / 4, f11726i);
        this.g = atomicReferenceArray;
        this.f11731f = i8;
        this.f11729c = iNumberOfLeadingZeros - 2;
        atomicLong.lazySet(0L);
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
        return this.f11727a.get() == this.h.get();
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.e;
        AtomicLong atomicLong = this.f11727a;
        long j3 = atomicLong.get();
        int i2 = this.f11730d;
        int i8 = ((int) j3) & i2;
        if (j3 < this.f11729c) {
            atomicReferenceArray.lazySet(i8, obj);
            atomicLong.lazySet(j3 + 1);
            return true;
        }
        long j8 = ((long) this.f11728b) + j3;
        if (atomicReferenceArray.get(((int) j8) & i2) == null) {
            this.f11729c = j8 - 1;
            atomicReferenceArray.lazySet(i8, obj);
            atomicLong.lazySet(j3 + 1);
            return true;
        }
        long j9 = j3 + 1;
        if (atomicReferenceArray.get(((int) j9) & i2) == null) {
            atomicReferenceArray.lazySet(i8, obj);
            atomicLong.lazySet(j9);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.f11729c = (j3 + ((long) i2)) - 1;
        atomicReferenceArray2.lazySet(i8, obj);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i8, j);
        atomicLong.lazySet(j9);
        return true;
    }

    @Override // a5.h
    public final Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.g;
        AtomicLong atomicLong = this.h;
        long j3 = atomicLong.get();
        int i2 = this.f11731f;
        int i8 = ((int) j3) & i2;
        Object obj = atomicReferenceArray.get(i8);
        boolean z2 = obj == j;
        if (obj != null && !z2) {
            atomicReferenceArray.lazySet(i8, null);
            atomicLong.lazySet(j3 + 1);
            return obj;
        }
        if (!z2) {
            return null;
        }
        int i9 = i2 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i9);
        atomicReferenceArray.lazySet(i9, null);
        this.g = atomicReferenceArray2;
        Object obj2 = atomicReferenceArray2.get(i8);
        if (obj2 != null) {
            atomicReferenceArray2.lazySet(i8, null);
            atomicLong.lazySet(j3 + 1);
        }
        return obj2;
    }
}
