package r5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class p extends o {
    public static void M0(List list) {
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void N0(List list, Comparator comparator) {
        kotlin.jvm.internal.k.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
