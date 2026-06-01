package androidx.camera.core.processing;

import androidx.core.util.Preconditions;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class TargetUtils {
    private TargetUtils() {
    }

    public static void checkSupportedTargets(Collection<Integer> collection, int i2) {
        boolean zContains = collection.contains(Integer.valueOf(i2));
        Locale locale = Locale.US;
        Preconditions.checkArgument(zContains, a1.a.o("Effects target ", getHumanReadableName(i2), " is not in the supported list ", getHumanReadableNames(collection), "."));
    }

    public static String getHumanReadableName(int i2) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i2 & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i2 & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) "|");
            }
        }
        return sb.toString();
    }

    private static String getHumanReadableNames(Collection<Integer> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getHumanReadableName(it.next().intValue()));
        }
        StringBuilder sb = new StringBuilder(C2300e4.i.f8403d);
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it2.next());
                if (!it2.hasNext()) {
                    break;
                }
                sb2.append((CharSequence) ", ");
            }
        }
        sb.append(sb2.toString());
        sb.append(C2300e4.i.e);
        return sb.toString();
    }

    public static int getNumberOfTargets(int i2) {
        int i8 = 0;
        while (i2 != 0) {
            i8 += i2 & 1;
            i2 >>= 1;
        }
        return i8;
    }

    public static boolean isSuperset(int i2, int i8) {
        return (i2 & i8) == i8;
    }
}
