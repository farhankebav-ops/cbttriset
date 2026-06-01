package f5;

import com.google.firebase.inappmessaging.internal.s;
import com.google.firebase.inappmessaging.internal.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11370c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(s4.l lVar, Object obj, int i2) {
        super(lVar);
        this.f11369b = i2;
        this.f11370c = obj;
    }

    @Override // s4.l
    public final void d(s4.m mVar) {
        switch (this.f11369b) {
            case 0:
                this.f11364a.c(new b(mVar, (e2.f) this.f11370c, 0));
                break;
            case 1:
                this.f11364a.c(new f(mVar, (t) this.f11370c, 0));
                break;
            case 2:
                this.f11364a.c(new j(mVar, (s) this.f11370c));
                break;
            case 3:
                this.f11364a.c(new f(mVar, (x4.c) this.f11370c, 1));
                break;
            default:
                e2.i iVar = new e2.i(mVar, (n) this.f11370c);
                mVar.a((b5.b) iVar.e);
                this.f11364a.c(iVar);
                break;
        }
    }
}
