package r5;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class m extends r2.q {
    public static int G0(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static List H0(Object... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return elements.length > 0 ? j.X(elements) : r.f13638a;
    }

    public static ArrayList I0(Object... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new h(elements, true));
    }

    public static final List J0(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : r2.q.j0(list.get(0)) : r.f13638a;
    }

    public static void K0() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
