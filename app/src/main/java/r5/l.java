package r5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l extends p {
    public static final int O0(z zVar, int i2) {
        if (i2 >= 0 && i2 <= m.G0(zVar)) {
            return m.G0(zVar) - i2;
        }
        StringBuilder sbV = a1.a.v(i2, "Element index ", " must be in range [");
        sbV.append(new k6.d(0, m.G0(zVar), 1));
        sbV.append("].");
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final int P0(z zVar, int i2) {
        if (i2 >= 0 && i2 <= zVar.size()) {
            return zVar.size() - i2;
        }
        StringBuilder sbV = a1.a.v(i2, "Position index ", " must be in range [");
        sbV.append(new k6.d(0, zVar.size(), 1));
        sbV.append("].");
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static void Q0(Iterable elements, Collection collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void R0(Collection collection, Object[] elements) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        collection.addAll(j.X(elements));
    }

    public static c6.m S0(Iterable iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return new c6.m(iterable, 4);
    }

    public static boolean T0(Iterable iterable, Object obj) {
        int iIndexOf;
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    m.K0();
                    throw null;
                }
                if (kotlin.jvm.internal.k.a(obj, next)) {
                    iIndexOf = i2;
                    break;
                }
                i2++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static List U0(Iterable iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return n1(q1(iterable));
    }

    public static List V0(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        int size = list.size() - 1;
        if (size <= 0) {
            return r.f13638a;
        }
        if (size == 1) {
            return r2.q.j0(d1(list));
        }
        ArrayList arrayList = new ArrayList(size);
        if (list instanceof RandomAccess) {
            int size2 = list.size();
            for (int i2 = 1; i2 < size2; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator listIterator = list.listIterator(1);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static ArrayList W0(Collection collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object X0(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object Y0(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object Z0(int i2, List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    public static final void a1(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, e6.l lVar) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        sb.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                sb.append(charSequence);
            }
            a.a.i(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String c1(Iterable iterable, String str, String str2, String str3, e6.l lVar, int i2) {
        if ((i2 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String prefix = (i2 & 2) != 0 ? "" : str2;
        String str5 = (i2 & 4) != 0 ? "" : str3;
        if ((i2 & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        StringBuilder sb = new StringBuilder();
        a1(iterable, sb, str4, prefix, str5, "...", lVar);
        return sb.toString();
    }

    public static Object d1(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(m.G0(list));
    }

    public static Object e1(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static ArrayList f1(Iterable elements, Collection collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            Q0(elements, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList g1(Collection collection, Object obj) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static void h1(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        list.remove(m.G0(list));
    }

    public static List i1(Collection collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        if (collection.size() <= 1) {
            return n1(collection);
        }
        List listP1 = p1(collection);
        Collections.reverse(listP1);
        return listP1;
    }

    public static List j1(List list, Comparator comparator) {
        kotlin.jvm.internal.k.e(list, "<this>");
        kotlin.jvm.internal.k.e(comparator, "comparator");
        if (list.size() <= 1) {
            return n1(list);
        }
        Object[] array = list.toArray(new Object[0]);
        kotlin.jvm.internal.k.e(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return j.X(array);
    }

    public static List k1(int i2, List list) {
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "Requested element count ", " is less than zero.").toString());
        }
        if (i2 == 0) {
            return r.f13638a;
        }
        if (i2 >= list.size()) {
            return n1(list);
        }
        if (i2 == 1) {
            return r2.q.j0(X0(list));
        }
        ArrayList arrayList = new ArrayList(i2);
        Iterator it = list.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i8++;
            if (i8 == i2) {
                break;
            }
        }
        return m.J0(arrayList);
    }

    public static final void l1(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] m1(List list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Number) it.next()).intValue();
            i2++;
        }
        return iArr;
    }

    public static List n1(Iterable iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m.J0(p1(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return r.f13638a;
        }
        if (size != 1) {
            return o1(collection);
        }
        return r2.q.j0(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList o1(Collection collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List p1(Iterable iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return o1((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        l1(iterable, arrayList);
        return arrayList;
    }

    public static Set q1(Iterable iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        l1(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set r1(Iterable iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return n7.b.N(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(x.d0(collection.size()));
                l1(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            l1(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : n7.b.N(linkedHashSet2.iterator().next());
            }
        }
        return t.f13640a;
    }
}
