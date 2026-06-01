package z1;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f17895b;

    public /* synthetic */ a(o oVar, int i2) {
        this.f17894a = i2;
        this.f17895b = oVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        switch (this.f17894a) {
            case 0:
                d dVar = (d) this.f17895b;
                dVar.s(dVar.t());
                break;
            default:
                j jVar = (j) this.f17895b;
                jVar.l = z2;
                jVar.p();
                if (!z2) {
                    jVar.s(false);
                    jVar.m = false;
                }
                break;
        }
    }
}
