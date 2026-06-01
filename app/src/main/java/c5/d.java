package c5;

import android.support.v4.media.g;
import com.google.firebase.inappmessaging.internal.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends s4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4210a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f4211b;

    public d(f fVar) {
        this.f4211b = fVar;
    }

    @Override // s4.a
    public final void e(s4.b bVar) {
        switch (this.f4210a) {
            case 0:
                this.f4211b.d(new a4.a(6, this, bVar));
                break;
            default:
                b5.b bVar2 = new b5.b(2);
                bVar.a(bVar2);
                this.f4211b.d(new g(this, bVar, bVar2));
                break;
        }
    }

    public d(f fVar, j jVar) {
        this.f4211b = fVar;
    }
}
