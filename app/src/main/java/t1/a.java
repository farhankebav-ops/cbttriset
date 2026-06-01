package t1;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f17383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a4.a f17384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17385c;

    public a(a4.a aVar, Typeface typeface) {
        this.f17383a = typeface;
        this.f17384b = aVar;
    }

    @Override // t1.g
    public final void a(int i2) {
        if (this.f17385c) {
            return;
        }
        q1.c cVar = (q1.c) this.f17384b.f3216b;
        if (cVar.l(this.f17383a)) {
            cVar.j(false);
        }
    }

    @Override // t1.g
    public final void b(Typeface typeface, boolean z2) {
        if (this.f17385c) {
            return;
        }
        q1.c cVar = (q1.c) this.f17384b.f3216b;
        if (cVar.l(typeface)) {
            cVar.j(false);
        }
    }
}
