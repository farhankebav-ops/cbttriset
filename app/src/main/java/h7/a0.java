package h7;

import f7.a2;
import f7.d2;
import f7.u1;
import f7.x1;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f11736a = n7.b.O(x1.f11545b, a2.f11419b, u1.f11527b, d2.f11438b);

    public static final boolean a(d7.g gVar) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        return gVar.isInline() && f11736a.contains(gVar);
    }
}
