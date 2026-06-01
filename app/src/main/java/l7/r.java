package l7;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f12900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f12901d;
    public final Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f12902f;
    public final Long g;
    public final Map h;

    public r(boolean z2, boolean z7, g0 g0Var, Long l, Long l8, Long l9, Long l10, Map extras) {
        kotlin.jvm.internal.k.e(extras, "extras");
        this.f12898a = z2;
        this.f12899b = z7;
        this.f12900c = g0Var;
        this.f12901d = l;
        this.e = l8;
        this.f12902f = l9;
        this.g = l10;
        this.h = r5.x.n0(extras);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f12898a) {
            arrayList.add("isRegularFile");
        }
        if (this.f12899b) {
            arrayList.add("isDirectory");
        }
        Long l = this.f12901d;
        if (l != null) {
            arrayList.add("byteCount=" + l);
        }
        Long l8 = this.e;
        if (l8 != null) {
            arrayList.add("createdAt=" + l8);
        }
        Long l9 = this.f12902f;
        if (l9 != null) {
            arrayList.add("lastModifiedAt=" + l9);
        }
        Long l10 = this.g;
        if (l10 != null) {
            arrayList.add("lastAccessedAt=" + l10);
        }
        Map map = this.h;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return r5.l.c1(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }

    public /* synthetic */ r(boolean z2, boolean z7, g0 g0Var, Long l, Long l8, Long l9, Long l10) {
        this(z2, z7, g0Var, l, l8, l9, l10, r5.s.f13639a);
    }
}
