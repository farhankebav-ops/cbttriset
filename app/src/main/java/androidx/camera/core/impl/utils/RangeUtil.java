package androidx.camera.core.impl.utils;

import android.util.Range;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RangeUtil {
    public static final RangeUtil INSTANCE = new RangeUtil();

    private RangeUtil() {
    }

    public static final Set<Range<Integer>> filterFixedRanges(Set<Range<Integer>> set) {
        k.e(set, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            Range range = (Range) obj;
            if (k.a(range.getUpper(), range.getLower())) {
                arrayList.add(obj);
            }
        }
        return new LinkedHashSet(arrayList);
    }
}
