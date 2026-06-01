package r5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x extends a.a {
    public static Object b0(Map map, Object obj) {
        kotlin.jvm.internal.k.e(map, "<this>");
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static HashMap c0(q5.i... iVarArr) {
        HashMap map = new HashMap(d0(iVarArr.length));
        k0(map, iVarArr);
        return map;
    }

    public static int d0(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map e0(q5.i pair) {
        kotlin.jvm.internal.k.e(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.f13498a, pair.f13499b);
        kotlin.jvm.internal.k.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static Map f0(q5.i... iVarArr) {
        if (iVarArr.length <= 0) {
            return s.f13639a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0(iVarArr.length));
        k0(linkedHashMap, iVarArr);
        return linkedHashMap;
    }

    public static LinkedHashMap g0(q5.i... iVarArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0(iVarArr.length));
        k0(linkedHashMap, iVarArr);
        return linkedHashMap;
    }

    public static final Map h0(LinkedHashMap linkedHashMap) {
        int size = linkedHashMap.size();
        return size != 0 ? size != 1 ? linkedHashMap : p0(linkedHashMap) : s.f13639a;
    }

    public static LinkedHashMap i0(Map map, Map map2) {
        kotlin.jvm.internal.k.e(map, "<this>");
        kotlin.jvm.internal.k.e(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static Map j0(Map map, q5.i iVar) {
        kotlin.jvm.internal.k.e(map, "<this>");
        if (map.isEmpty()) {
            return e0(iVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(iVar.f13498a, iVar.f13499b);
        return linkedHashMap;
    }

    public static final void k0(HashMap map, q5.i[] iVarArr) {
        for (q5.i iVar : iVarArr) {
            map.put(iVar.f13498a, iVar.f13499b);
        }
    }

    public static List l0(Map map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        r rVar = r.f13638a;
        if (size == 0) {
            return rVar;
        }
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return rVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (!it.hasNext()) {
            return r2.q.j0(new q5.i(entry.getKey(), entry.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new q5.i(entry.getKey(), entry.getValue()));
        do {
            Map.Entry entry2 = (Map.Entry) it.next();
            arrayList.add(new q5.i(entry2.getKey(), entry2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static Map m0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return s.f13639a;
        }
        if (size == 1) {
            return e0((q5.i) arrayList.get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0(arrayList.size()));
        int size2 = arrayList.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj = arrayList.get(i2);
            i2++;
            q5.i iVar = (q5.i) obj;
            linkedHashMap.put(iVar.f13498a, iVar.f13499b);
        }
        return linkedHashMap;
    }

    public static Map n0(Map map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? o0(map) : p0(map) : s.f13639a;
    }

    public static LinkedHashMap o0(Map map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static final Map p0(Map map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.k.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
