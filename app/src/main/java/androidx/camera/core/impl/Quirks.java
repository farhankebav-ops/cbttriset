package androidx.camera.core.impl;

import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }

    public static String toString(Quirks quirks) {
        ArrayList arrayList = new ArrayList();
        Iterator<Quirk> it = quirks.mQuirks.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getClass().getSimpleName());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            while (true) {
                sb.append((CharSequence) it2.next());
                if (!it2.hasNext()) {
                    break;
                }
                sb.append((CharSequence) " | ");
            }
        }
        return sb.toString();
    }

    @VisibleForTesting
    public void addQuirkForTesting(Quirk quirk) {
        this.mQuirks.add(quirk);
    }

    public boolean contains(Class<? extends Quirk> cls) {
        Iterator<Quirk> it = this.mQuirks.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next().getClass())) {
                return true;
            }
        }
        return false;
    }

    public <T extends Quirk> T get(Class<T> cls) {
        Iterator<Quirk> it = this.mQuirks.iterator();
        while (it.hasNext()) {
            T t3 = (T) it.next();
            if (t3.getClass() == cls) {
                return t3;
            }
        }
        return null;
    }

    public <T extends Quirk> List<T> getAll(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Quirk quirk : this.mQuirks) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                arrayList.add(quirk);
            }
        }
        return arrayList;
    }
}
