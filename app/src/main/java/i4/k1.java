package i4;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k1 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f11888a;

    public k1(l1 l1Var) {
        this.f11888a = l1Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        l1 l1Var = this.f11888a;
        int iD = l1Var.d(obj) - l1Var.d(obj2);
        return iD != 0 ? iD : obj.getClass().getName().compareTo(obj2.getClass().getName());
    }
}
