package androidx.collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LongLongPair {
    private final long first;
    private final long second;

    public LongLongPair(long j, long j3) {
        this.first = j;
        this.second = j3;
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        return longLongPair.first == this.first && longLongPair.second == this.second;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public int hashCode() {
        long j = this.first;
        int i2 = (int) (j ^ (j >>> 32));
        long j3 = this.second;
        return i2 ^ ((int) ((j3 >>> 32) ^ j3));
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
