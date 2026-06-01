package g7;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@b7.h(with = z.class)
public final class x extends m implements Map<String, m>, f6.a {
    public static final w Companion = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11628a;

    public x(Map content) {
        kotlin.jvm.internal.k.e(content, "content");
        this.f11628a = content;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ m compute(String str, BiFunction<? super String, ? super m, ? extends m> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ m computeIfAbsent(String str, Function<? super String, ? extends m> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ m computeIfPresent(String str, BiFunction<? super String, ? super m, ? extends m> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return this.f11628a.containsKey((String) obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        return this.f11628a.containsValue((m) obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, m>> entrySet() {
        return this.f11628a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return kotlin.jvm.internal.k.a(this.f11628a, obj);
    }

    @Override // java.util.Map
    public final m get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return (m) this.f11628a.get((String) obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f11628a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f11628a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f11628a.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ m merge(String str, m mVar, BiFunction<? super m, ? super m, ? extends m> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ m put(String str, m mVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends m> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ m putIfAbsent(String str, m mVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final m remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ m replace(String str, m mVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super m, ? extends m> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f11628a.size();
    }

    public final String toString() {
        return r5.l.c1(this.f11628a.entrySet(), ",", "{", "}", new androidx.activity.u(10), 24);
    }

    @Override // java.util.Map
    public final Collection<m> values() {
        return this.f11628a.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, m mVar, m mVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
