package androidx.core.util;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f4, S s7) {
        this.first = f4;
        this.second = s7;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a8, B b8) {
        return new Pair<>(a8, b8);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f4 = this.first;
        int iHashCode = f4 == null ? 0 : f4.hashCode();
        S s7 = this.second;
        return iHashCode ^ (s7 != null ? s7.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
