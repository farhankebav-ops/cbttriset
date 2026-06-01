package e2;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11225b;

    public b() {
        this.f11224a = 1;
        this.f11225b = Collections.newSetFromMap(new IdentityHashMap());
    }

    public abstract void a();

    public abstract void b();

    public void c(Object obj, boolean z2) {
        Set set = (Set) this.f11225b;
        int size = set.size();
        if (z2) {
            set.add(obj);
            if (size == 0) {
                a();
                return;
            }
            return;
        }
        if (set.remove(obj) && size == 1) {
            b();
        }
    }

    public String toString() {
        switch (this.f11224a) {
            case 0:
                return (String) this.f11225b;
            default:
                return super.toString();
        }
    }

    public b(String str) {
        this.f11224a = 0;
        this.f11225b = str;
    }
}
