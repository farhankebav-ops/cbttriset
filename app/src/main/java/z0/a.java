package z0;

import android.util.SparseArray;
import java.util.HashMap;
import m0.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f17892a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f17893b;

    static {
        HashMap map = new HashMap();
        f17893b = map;
        map.put(e.f12921a, 0);
        map.put(e.f12922b, 1);
        map.put(e.f12923c, 2);
        for (e eVar : map.keySet()) {
            f17892a.append(((Integer) f17893b.get(eVar)).intValue(), eVar);
        }
    }

    public static int a(e eVar) {
        Integer num = (Integer) f17893b.get(eVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + eVar);
    }

    public static e b(int i2) {
        e eVar = (e) f17892a.get(i2);
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalArgumentException(a1.a.g(i2, "Unknown Priority for value "));
    }
}
