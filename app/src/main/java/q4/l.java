package q4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements Map {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f13458a = new HashMap();

    public final double a() {
        HashMap map = this.f13458a;
        if (map.isEmpty()) {
            return 0.0d;
        }
        Iterator it = map.values().iterator();
        int i2 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            i8++;
            if (((k) it.next()).d()) {
                i2++;
            }
        }
        return (((double) i2) / ((double) i8)) * 100.0d;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f13458a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f13458a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f13458a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return this.f13458a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj == this || this.f13458a.equals(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f13458a.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f13458a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f13458a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return this.f13458a.keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f13458a.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f13458a.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f13458a.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f13458a.size();
    }

    public final String toString() {
        return this.f13458a.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f13458a.values();
    }
}
