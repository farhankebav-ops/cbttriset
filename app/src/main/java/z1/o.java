package z1;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f17933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f17934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f17935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f17936d;

    public o(n nVar) {
        this.f17933a = nVar.f17919a;
        this.f17934b = nVar;
        this.f17935c = nVar.getContext();
        this.f17936d = nVar.g;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return null;
    }

    public boolean i(int i2) {
        return true;
    }

    public boolean j() {
        return this instanceof j;
    }

    public boolean k() {
        return false;
    }

    public final void p() {
        this.f17934b.f(false);
    }

    public void a() {
    }

    public void b() {
    }

    public void q() {
    }

    public void r() {
    }

    public void l(EditText editText) {
    }

    public void m(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void n(AccessibilityEvent accessibilityEvent) {
    }

    public void o(boolean z2) {
    }
}
