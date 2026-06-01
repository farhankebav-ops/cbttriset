package m6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r2.q;
import r5.r;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k extends q {
    public static h G0(Iterator it) {
        kotlin.jvm.internal.k.e(it, "<this>");
        return new a(new c6.m(it, 2));
    }

    public static f H0(h hVar, e6.l predicate) {
        kotlin.jvm.internal.k.e(predicate, "predicate");
        return new f(hVar, predicate, 0);
    }

    public static String I0(h hVar, String str) {
        kotlin.jvm.internal.k.e(hVar, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i2 = 0;
        for (Object obj : hVar) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) str);
            }
            a.a.i(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static f J0(h hVar, e6.l lVar) {
        kotlin.jvm.internal.k.e(hVar, "<this>");
        return new f(hVar, lVar, 2);
    }

    public static List K0(h hVar) {
        Iterator it = hVar.iterator();
        if (!it.hasNext()) {
            return r.f13638a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return q.j0(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
