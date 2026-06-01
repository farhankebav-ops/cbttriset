package z1;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.cbt.exam.browser.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class v extends o {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f17968f;
    public final com.cbt.exam.browser.activity.o g;

    public v(n nVar, int i2) {
        super(nVar);
        this.e = R.drawable.design_password_eye;
        this.g = new com.cbt.exam.browser.activity.o(this, 5);
        if (i2 != 0) {
            this.e = i2;
        }
    }

    @Override // z1.o
    public final void b() {
        p();
    }

    @Override // z1.o
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // z1.o
    public final int d() {
        return this.e;
    }

    @Override // z1.o
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // z1.o
    public final boolean j() {
        return true;
    }

    @Override // z1.o
    public final boolean k() {
        EditText editText = this.f17968f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // z1.o
    public final void l(EditText editText) {
        this.f17968f = editText;
        p();
    }

    @Override // z1.o
    public final void q() {
        EditText editText = this.f17968f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f17968f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // z1.o
    public final void r() {
        EditText editText = this.f17968f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
