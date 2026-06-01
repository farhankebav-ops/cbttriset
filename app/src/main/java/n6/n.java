package n6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n extends a.a {
    public static String b0(String str) {
        List listJ0;
        Comparable comparable;
        kotlin.jvm.internal.k.e(str, "<this>");
        h hVar = new h(str);
        if (hVar.hasNext()) {
            Object next = hVar.next();
            if (hVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (hVar.hasNext()) {
                    arrayList.add(hVar.next());
                }
                listJ0 = arrayList;
            } else {
                listJ0 = r2.q.j0(next);
            }
        } else {
            listJ0 = r5.r.f13638a;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listJ0) {
            if (!m.A0((String) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(r5.n.L0(arrayList2, 10));
        int size = arrayList2.size();
        int i2 = 0;
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList2.get(i8);
            i8++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!n7.b.A(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList3.add(Integer.valueOf(length2));
        }
        Iterator it = arrayList3.iterator();
        if (it.hasNext()) {
            comparable = (Comparable) it.next();
            while (it.hasNext()) {
                Comparable comparable2 = (Comparable) it.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listJ0.size();
        int iG0 = r5.m.G0(listJ0);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : listJ0) {
            int i9 = i2 + 1;
            if (i2 < 0) {
                r5.m.K0();
                throw null;
            }
            String str3 = (String) obj3;
            String strS0 = ((i2 == 0 || i2 == iG0) && m.A0(str3)) ? null : m.s0(iIntValue, str3);
            if (strS0 != null) {
                arrayList4.add(strS0);
            }
            i2 = i9;
        }
        StringBuilder sb = new StringBuilder(length3);
        r5.l.a1(arrayList4, sb, "\n", "", "", "...", null);
        return sb.toString();
    }

    public static String c0(String str) {
        List listJ0;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (m.A0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        h hVar = new h(str);
        if (hVar.hasNext()) {
            Object next = hVar.next();
            if (hVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (hVar.hasNext()) {
                    arrayList.add(hVar.next());
                }
                listJ0 = arrayList;
            } else {
                listJ0 = r2.q.j0(next);
            }
        } else {
            listJ0 = r5.r.f13638a;
        }
        int length = str.length();
        listJ0.size();
        int iG0 = r5.m.G0(listJ0);
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (Object obj : listJ0) {
            int i8 = i2 + 1;
            String strSubstring = null;
            if (i2 < 0) {
                r5.m.K0();
                throw null;
            }
            String str2 = (String) obj;
            if ((i2 != 0 && i2 != iG0) || !m.A0(str2)) {
                int length2 = str2.length();
                int i9 = 0;
                while (true) {
                    if (i9 >= length2) {
                        i9 = -1;
                        break;
                    }
                    if (!n7.b.A(str2.charAt(i9))) {
                        break;
                    }
                    i9++;
                }
                if (i9 != -1 && t.m0(str2, "|", i9, false)) {
                    strSubstring = str2.substring("|".length() + i9);
                    kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList2.add(strSubstring);
            }
            i2 = i8;
        }
        StringBuilder sb = new StringBuilder(length);
        r5.l.a1(arrayList2, sb, "\n", "", "", "...", null);
        return sb.toString();
    }
}
