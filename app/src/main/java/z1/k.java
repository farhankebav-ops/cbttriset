package z1;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends q1.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f17913a;

    public k(n nVar) {
        this.f17913a = nVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f17913a.b().a();
    }

    @Override // q1.k, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
        this.f17913a.b().b();
    }
}
