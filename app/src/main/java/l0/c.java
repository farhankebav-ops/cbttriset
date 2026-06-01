package l0;

import android.content.Context;
import p0.l;
import p0.o;
import p0.w;
import q0.g;
import v0.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12732a;

    public l a() {
        Context context = this.f12732a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        l lVar = new l();
        lVar.f13295a = r0.a.a(o.f13302a);
        q0.e eVar = new q0.e(context, 1);
        lVar.f13296b = eVar;
        lVar.f13297c = r0.a.a(new g(eVar, new q0.e(eVar, 0), 0));
        q0.e eVar2 = lVar.f13296b;
        lVar.f13298d = new w0.e(eVar2, 1);
        p5.a aVarA = r0.a.a(new w0.e(eVar2, 0));
        lVar.e = aVarA;
        p5.a aVarA2 = r0.a.a(new g(lVar.f13298d, aVarA, 1));
        lVar.f13299f = aVarA2;
        u0.d dVar = new u0.d();
        q0.e eVar3 = lVar.f13296b;
        w wVar = new w(eVar3, aVarA2, dVar, 1);
        p5.a aVar = lVar.f13295a;
        p5.a aVar2 = lVar.f13297c;
        lVar.g = r0.a.a(new w(new u0.b(aVar, aVar2, wVar, aVarA2, aVarA2), new v0.g(eVar3, aVar2, aVarA2, wVar, aVar, aVarA2, aVarA2), new h(aVar, aVarA2, wVar, aVarA2), 0));
        return lVar;
    }
}
