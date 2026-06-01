package z1;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class y extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f17978a;

    public y(TextInputLayout textInputLayout) {
        this.f17978a = textInputLayout;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        TextInputLayout textInputLayout = this.f17978a;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z2 = textInputLayout.f5477v0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z7 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        w wVar = textInputLayout.f5451b;
        View view2 = wVar.f17970b;
        if (view2.getVisibility() == 0) {
            accessibilityNodeInfoCompat.setLabelFor(view2);
            accessibilityNodeInfoCompat.setTraversalAfter(view2);
        } else {
            accessibilityNodeInfoCompat.setTraversalAfter(wVar.f17972d);
        }
        if (!zIsEmpty) {
            accessibilityNodeInfoCompat.setText(text);
        } else if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfoCompat.setText(string);
            if (!z2 && placeholderText != null) {
                accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfoCompat.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            if (Build.VERSION.SDK_INT >= 26) {
                accessibilityNodeInfoCompat.setHintText(string);
            } else {
                if (!zIsEmpty) {
                    string = ((Object) text) + ", " + string;
                }
                accessibilityNodeInfoCompat.setText(string);
            }
            accessibilityNodeInfoCompat.setShowingHintText(zIsEmpty);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
        if (z7) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfoCompat.setError(error);
        }
        View view3 = textInputLayout.k.y;
        if (view3 != null) {
            accessibilityNodeInfoCompat.setLabelFor(view3);
        }
        textInputLayout.f5453c.b().m(accessibilityNodeInfoCompat);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        this.f17978a.f5453c.b().n(accessibilityEvent);
    }
}
