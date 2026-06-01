package z1;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.cbt.exam.browser.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends o {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17907f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.cbt.exam.browser.activity.o f17908i;
    public final a j;
    public final i k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f17909n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f17910o;
    public AccessibilityManager p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f17911q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f17912r;

    /* JADX WARN: Type inference failed for: r0v2, types: [z1.i] */
    public j(n nVar) {
        super(nVar);
        this.f17908i = new com.cbt.exam.browser.activity.o(this, 4);
        this.j = new a(this, 1);
        this.k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: z1.i
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z2) {
                j jVar = this.f17906a;
                AutoCompleteTextView autoCompleteTextView = jVar.h;
                if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
                    return;
                }
                jVar.f17936d.setImportantForAccessibility(z2 ? 2 : 1);
            }
        };
        this.f17910o = LocationRequestCompat.PASSIVE_INTERVAL;
        this.f17907f = a.a.S(nVar.getContext(), R.attr.motionDurationShort3, 67);
        this.e = a.a.S(nVar.getContext(), R.attr.motionDurationShort3, 50);
        this.g = a.a.T(nVar.getContext(), R.attr.motionEasingLinearInterpolator, c1.a.f4168a);
    }

    @Override // z1.o
    public final void a() {
        if (this.p.isTouchExplorationEnabled() && this.h.getInputType() != 0 && !this.f17936d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new com.vungle.ads.internal.omsdk.a(this, 16));
    }

    @Override // z1.o
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // z1.o
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // z1.o
    public final View.OnFocusChangeListener e() {
        return this.j;
    }

    @Override // z1.o
    public final View.OnClickListener f() {
        return this.f17908i;
    }

    @Override // z1.o
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.k;
    }

    @Override // z1.o
    public final boolean i(int i2) {
        return i2 != 0;
    }

    @Override // z1.o
    public final boolean k() {
        return this.f17909n;
    }

    @Override // z1.o
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new com.cbt.exam.browser.activity.t(this, 2));
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: z1.h
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                j jVar = this.f17905a;
                jVar.m = true;
                jVar.f17910o = SystemClock.uptimeMillis();
                jVar.s(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.f17933a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.p.isTouchExplorationEnabled()) {
            this.f17936d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // z1.o
    public final void m(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.h.getInputType() == 0) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // z1.o
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.p.isEnabled() && this.h.getInputType() == 0) {
            boolean z2 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f17909n && !this.h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z2) {
                t();
                this.m = true;
                this.f17910o = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // z1.o
    public final void q() {
        int i2 = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f17907f);
        valueAnimatorOfFloat.addUpdateListener(new com.onesignal.inAppMessages.internal.display.impl.a(this, i2));
        this.f17912r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.e);
        valueAnimatorOfFloat2.addUpdateListener(new com.onesignal.inAppMessages.internal.display.impl.a(this, i2));
        this.f17911q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new e1.c(this, i2));
        this.p = (AccessibilityManager) this.f17935c.getSystemService("accessibility");
    }

    @Override // z1.o
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z2) {
        if (this.f17909n != z2) {
            this.f17909n = z2;
            this.f17912r.cancel();
            this.f17911q.start();
        }
    }

    public final void t() {
        if (this.h == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f17910o;
        if (jUptimeMillis < 0 || jUptimeMillis > 300) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        s(!this.f17909n);
        if (!this.f17909n) {
            this.h.dismissDropDown();
        } else {
            this.h.requestFocus();
            this.h.showDropDown();
        }
    }
}
