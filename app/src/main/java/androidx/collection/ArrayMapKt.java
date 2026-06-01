package androidx.collection;

import com.bumptech.glide.util.CachedHashCodeArrayMap;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(i... pairs) {
        k.e(pairs, "pairs");
        CachedHashCodeArrayMap cachedHashCodeArrayMap = (ArrayMap<K, V>) new ArrayMap(pairs.length);
        for (i iVar : pairs) {
            cachedHashCodeArrayMap.put(iVar.f13498a, iVar.f13499b);
        }
        return cachedHashCodeArrayMap;
    }
}
