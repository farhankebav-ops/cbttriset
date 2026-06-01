package androidx.collection;

import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        k.c(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int get(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    public static final long group(long[] metadata, int i2) {
        k.e(metadata, "metadata");
        int i8 = i2 >> 3;
        int i9 = (i2 & 7) << 3;
        return (((-i9) >> 63) & (metadata[i8 + 1] << (64 - i9))) | (metadata[i8] >>> i9);
    }

    public static final int h1(int i2) {
        return i2 >>> 7;
    }

    public static final int h2(int i2) {
        return i2 & 127;
    }

    public static final boolean hasNext(long j) {
        return j != 0;
    }

    public static final int hash(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final boolean isDeleted(long[] metadata, int i2) {
        k.e(metadata, "metadata");
        return ((metadata[i2 >> 3] >> ((i2 & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(long[] metadata, int i2) {
        k.e(metadata, "metadata");
        return ((metadata[i2 >> 3] >> ((i2 & 7) << 3)) & 255) == 128;
    }

    public static final boolean isFull(long j) {
        return j < 128;
    }

    public static final int loadedCapacity(int i2) {
        if (i2 == 7) {
            return 6;
        }
        return i2 - (i2 / 8);
    }

    public static final int lowestBitSet(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    public static final long maskEmpty(long j) {
        return j & ((~j) << 6) & (-9187201950435737472L);
    }

    public static final long maskEmptyOrDeleted(long j) {
        return j & ((~j) << 7) & (-9187201950435737472L);
    }

    public static final long match(long j, int i2) {
        long j3 = j ^ (((long) i2) * BitmaskLsb);
        return (~j3) & (j3 - BitmaskLsb) & (-9187201950435737472L);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static final long next(long j) {
        return j & (j - 1);
    }

    public static final int nextCapacity(int i2) {
        if (i2 == 0) {
            return 6;
        }
        return (i2 * 2) + 1;
    }

    public static final int normalizeCapacity(int i2) {
        if (i2 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i2);
        }
        return 0;
    }

    public static final long readRawMetadata(long[] data, int i2) {
        k.e(data, "data");
        return (data[i2 >> 3] >> ((i2 & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i2) {
        if (i2 == 7) {
            return 8;
        }
        return ((i2 - 1) / 7) + i2;
    }

    public static final void writeRawMetadata(long[] data, int i2, long j) {
        k.e(data, "data");
        int i8 = i2 >> 3;
        int i9 = (i2 & 7) << 3;
        data[i8] = (j << i9) | (data[i8] & (~(255 << i9)));
    }

    public static final boolean isFull(long[] metadata, int i2) {
        k.e(metadata, "metadata");
        return ((metadata[i2 >> 3] >> ((i2 & 7) << 3)) & 255) < 128;
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(i... pairs) {
        k.e(pairs, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(pairs.length);
        mutableScatterMap.putAll(pairs);
        return mutableScatterMap;
    }

    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    public static /* synthetic */ void getSentinel$annotations() {
    }
}
