package androidx.datastore.preferences.core;

import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import q6.m0;
import q6.w;
import r5.l;
import x6.d;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Actual_jvmAndroidKt {
    public static final <T> Set<T> immutableCopyOfSet(Set<? extends T> set) {
        k.e(set, "set");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(l.r1(set));
        k.d(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final <K, V> Map<K, V> immutableMap(Map<K, ? extends V> map) {
        k.e(map, "map");
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        k.d(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }

    public static final w ioDispatcher() {
        e eVar = m0.f13566a;
        return d.f17810a;
    }
}
