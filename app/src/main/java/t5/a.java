package t5;

import java.util.Comparator;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Comparator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f17409b = new a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17410c = new a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17411a;

    public /* synthetic */ a(int i2) {
        this.f17411a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f17411a) {
            case 0:
                Comparable a8 = (Comparable) obj;
                Comparable b8 = (Comparable) obj2;
                k.e(a8, "a");
                k.e(b8, "b");
                return a8.compareTo(b8);
            default:
                Comparable a9 = (Comparable) obj;
                Comparable b9 = (Comparable) obj2;
                k.e(a9, "a");
                k.e(b9, "b");
                return b9.compareTo(a9);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f17411a) {
            case 0:
                return f17410c;
            default:
                return f17409b;
        }
    }
}
