package g5;

import android.support.v4.media.g;
import e5.i;
import s4.q;
import s4.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f11592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11593c;

    public /* synthetic */ b(q qVar, Object obj, int i2) {
        this.f11591a = i2;
        this.f11592b = qVar;
        this.f11593c = obj;
    }

    @Override // s4.q
    public final void c(r rVar) {
        switch (this.f11591a) {
            case 0:
                this.f11592b.b(new g(this, rVar));
                break;
            default:
                this.f11592b.b(new i(3, rVar, (z4.a) this.f11593c));
                break;
        }
    }
}
