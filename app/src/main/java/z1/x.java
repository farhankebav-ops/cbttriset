package z1;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class x implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f17976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f17977c;

    public x(TextInputLayout textInputLayout, EditText editText) {
        this.f17977c = textInputLayout;
        this.f17976b = editText;
        this.f17975a = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f17977c;
        textInputLayout.w(!textInputLayout.B0, false);
        if (textInputLayout.l) {
            textInputLayout.p(editable);
        }
        if (textInputLayout.f5473t) {
            textInputLayout.x(editable);
        }
        EditText editText = this.f17976b;
        int lineCount = editText.getLineCount();
        int i2 = this.f17975a;
        if (lineCount != i2) {
            if (lineCount < i2) {
                int minimumHeight = editText.getMinimumHeight();
                int i8 = textInputLayout.f5475u0;
                if (minimumHeight != i8) {
                    editText.setMinimumHeight(i8);
                }
            }
            this.f17975a = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
    }
}
