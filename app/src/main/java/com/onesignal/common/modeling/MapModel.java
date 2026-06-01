package com.onesignal.common.modeling;

import f6.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.l;
import r5.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class MapModel<V> extends Model implements Map<String, V>, e {
    public MapModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // java.util.Map
    public void clear() {
        Iterator<String> it = getData().keySet().iterator();
        while (it.hasNext()) {
            Model.setOptAnyProperty$default(this, it.next(), null, null, false, 12, null);
        }
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(V v2) {
        return getData().containsValue(v2);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ V get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public Set<Map.Entry<String, V>> getEntries() {
        Set<Map.Entry<String, Object>> setEntrySet = getData().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (d0.f(obj)) {
                arrayList.add(obj);
            }
        }
        return l.q1(arrayList);
    }

    public Set<String> getKeys() {
        return getData().keySet();
    }

    public int getSize() {
        return getData().size();
    }

    public Collection<V> getValues() {
        Collection<Object> collectionValues = getData().values();
        ArrayList arrayList = new ArrayList(n.L0(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return l.o1(arrayList);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getData().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> from) {
        k.e(from, "from");
        for (Map.Entry<? extends String, ? extends V> entry : from.entrySet()) {
            Model.setOptAnyProperty$default(this, entry.getKey(), entry.getValue(), null, false, 12, null);
        }
    }

    @Override // java.util.Map
    public final /* bridge */ V remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public /* synthetic */ MapModel(Model model, String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : model, (i2 & 2) != 0 ? null : str);
    }

    public boolean containsKey(String key) {
        k.e(key, "key");
        return getData().containsKey(key);
    }

    public V get(String key) {
        k.e(key, "key");
        return (V) Model.getOptAnyProperty$default(this, key, null, 2, null);
    }

    @Override // java.util.Map
    public V put(String key, V v2) {
        k.e(key, "key");
        Model.setOptAnyProperty$default(this, key, v2, null, false, 12, null);
        return v2;
    }

    public V remove(String key) {
        k.e(key, "key");
        V v2 = (V) Model.getOptAnyProperty$default(this, key, null, 2, null);
        Model.setOptAnyProperty$default(this, key, null, null, false, 12, null);
        return v2;
    }

    public MapModel(Model model, String str) {
        super(model, str);
    }
}
