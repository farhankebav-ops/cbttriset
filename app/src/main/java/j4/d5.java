package j4;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.i[] f12162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f12163b = new AtomicBoolean(false);

    static {
        new d5(new i4.i[0]);
    }

    public d5(i4.i[] iVarArr) {
        this.f12162a = iVarArr;
    }

    public final void a(long j) {
        for (i4.i iVar : this.f12162a) {
            iVar.g(j);
        }
    }
}
