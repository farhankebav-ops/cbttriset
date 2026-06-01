package z1;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends o {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(n nVar, int i2) {
        super(nVar);
        this.e = i2;
    }

    @Override // z1.o
    public void q() {
        switch (this.e) {
            case 0:
                n nVar = this.f17934b;
                nVar.f17926o = null;
                CheckableImageButton checkableImageButton = nVar.g;
                checkableImageButton.setOnLongClickListener(null);
                r2.q.t0(checkableImageButton, null);
                break;
        }
    }
}
