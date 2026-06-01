package p0;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements m0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f13305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f13306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f13307c;

    public t(Set set, k kVar, v vVar) {
        this.f13305a = set;
        this.f13306b = kVar;
        this.f13307c = vVar;
    }

    public final u a(String str, m0.c cVar, m0.f fVar) {
        Set set = this.f13305a;
        if (set.contains(cVar)) {
            return new u(this.f13306b, str, cVar, fVar, this.f13307c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, set));
    }
}
