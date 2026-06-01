package l7;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f12877a = new k0(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f12879c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f12878b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i2 = 0; i2 < iHighestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference();
        }
        f12879c = atomicReferenceArr;
    }

    public static final void a(k0 segment) {
        kotlin.jvm.internal.k.e(segment, "segment");
        if (segment.f12876f != null || segment.g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f12875d) {
            return;
        }
        AtomicReference atomicReference = f12879c[(int) (Thread.currentThread().getId() & (((long) f12878b) - 1))];
        k0 k0Var = f12877a;
        k0 k0Var2 = (k0) atomicReference.getAndSet(k0Var);
        if (k0Var2 == k0Var) {
            return;
        }
        int i2 = k0Var2 != null ? k0Var2.f12874c : 0;
        if (i2 >= 65536) {
            atomicReference.set(k0Var2);
            return;
        }
        segment.f12876f = k0Var2;
        segment.f12873b = 0;
        segment.f12874c = i2 + 8192;
        atomicReference.set(segment);
    }

    public static final k0 b() {
        AtomicReference atomicReference = f12879c[(int) (Thread.currentThread().getId() & (((long) f12878b) - 1))];
        k0 k0Var = f12877a;
        k0 k0Var2 = (k0) atomicReference.getAndSet(k0Var);
        if (k0Var2 == k0Var) {
            return new k0();
        }
        if (k0Var2 == null) {
            atomicReference.set(null);
            return new k0();
        }
        atomicReference.set(k0Var2.f12876f);
        k0Var2.f12876f = null;
        k0Var2.f12874c = 0;
        return k0Var2;
    }
}
