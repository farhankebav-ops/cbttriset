package androidx.collection;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LongListKt {
    private static final LongList EmptyLongList = new MutableLongList(0);

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    public static final LongList longListOf(long j) {
        return mutableLongListOf(j);
    }

    public static final MutableLongList mutableLongListOf(long j) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j);
        return mutableLongList;
    }

    public static final LongList longListOf(long j, long j3) {
        return mutableLongListOf(j, j3);
    }

    public static final LongList longListOf(long j, long j3, long j8) {
        return mutableLongListOf(j, j3, j8);
    }

    public static final MutableLongList mutableLongListOf(long j, long j3) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j);
        mutableLongList.add(j3);
        return mutableLongList;
    }

    public static final LongList longListOf(long... elements) {
        k.e(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j, long j3, long j8) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j);
        mutableLongList.add(j3);
        mutableLongList.add(j8);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long... elements) {
        k.e(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }
}
