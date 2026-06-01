package androidx.collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class IntIntPair {
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m18boximpl(long j) {
        return new IntIntPair(j);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m19component1impl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m20component2impl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m22constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m23equalsimpl(long j, Object obj) {
        return (obj instanceof IntIntPair) && j == ((IntIntPair) obj).m29unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m24equalsimpl0(long j, long j3) {
        return j == j3;
    }

    /* JADX INFO: renamed from: getFirst-impl, reason: not valid java name */
    public static final int m25getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: getSecond-impl, reason: not valid java name */
    public static final int m26getSecondimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m27hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m28toStringimpl(long j) {
        return "(" + m25getFirstimpl(j) + ", " + m26getSecondimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m23equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m27hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m28toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m29unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m21constructorimpl(int i2, int i8) {
        return m22constructorimpl((((long) i8) & 4294967295L) | (((long) i2) << 32));
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }
}
