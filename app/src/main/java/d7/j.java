package d7;

import f7.y;
import java.util.Iterator;
import kotlin.jvm.internal.d0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements Iterable, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11198b;

    public /* synthetic */ j(Object obj, int i2) {
        this.f11197a = i2;
        this.f11198b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f11197a) {
            case 0:
                return new i((y) this.f11198b);
            case 1:
                return new n6.b((n6.c) this.f11198b);
            default:
                return new m6.b(d0.g((Object[]) ((androidx.activity.result.b) this.f11198b).f3323b));
        }
    }
}
