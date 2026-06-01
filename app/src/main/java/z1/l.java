package z1;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f17914a;

    public l(n nVar) {
        this.f17914a = nVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        n nVar = this.f17914a;
        k kVar = nVar.f17932v;
        if (nVar.f17929s == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = nVar.f17929s;
        if (editText != null) {
            editText.removeTextChangedListener(kVar);
            if (nVar.f17929s.getOnFocusChangeListener() == nVar.b().e()) {
                nVar.f17929s.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        nVar.f17929s = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(kVar);
        }
        nVar.b().l(nVar.f17929s);
        nVar.j(nVar.b());
    }
}
