package androidx.core.util;

import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PairKt {
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(i iVar) {
        return new android.util.Pair<>(iVar.f13498a, iVar.f13499b);
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(i iVar) {
        return new Pair<>(iVar.f13498a, iVar.f13499b);
    }

    public static final <F, S> i toKotlinPair(Pair<F, S> pair) {
        return new i(pair.first, pair.second);
    }

    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    public static final <F, S> i toKotlinPair(android.util.Pair<F, S> pair) {
        return new i(pair.first, pair.second);
    }
}
