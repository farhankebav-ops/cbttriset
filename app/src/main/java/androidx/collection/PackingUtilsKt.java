package androidx.collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PackingUtilsKt {
    public static final long packFloats(float f4, float f8) {
        return (((long) Float.floatToRawIntBits(f8)) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32);
    }

    public static final long packInts(int i2, int i8) {
        return (((long) i8) & 4294967295L) | (((long) i2) << 32);
    }
}
