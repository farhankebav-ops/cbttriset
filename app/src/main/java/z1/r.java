package z1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.cbt.exam.browser.R;
import com.google.android.material.textfield.TextInputLayout;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class r {
    public ColorStateList A;
    public Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f17945d;
    public final TimeInterpolator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f17946f;
    public final Context g;
    public final TextInputLayout h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f17947i;
    public int j;
    public FrameLayout k;
    public AnimatorSet l;
    public final float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f17948n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17949o;
    public CharSequence p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f17950q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AppCompatTextView f17951r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f17952s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f17953t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f17954u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f17955v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f17956w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f17957x;
    public AppCompatTextView y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f17958z;

    public r(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.h = textInputLayout;
        this.m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f17942a = a.a.S(context, R.attr.motionDurationShort4, Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE);
        this.f17943b = a.a.S(context, R.attr.motionDurationMedium4, 167);
        this.f17944c = a.a.S(context, R.attr.motionDurationShort4, 167);
        this.f17945d = a.a.T(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, c1.a.f4171d);
        LinearInterpolator linearInterpolator = c1.a.f4168a;
        this.e = a.a.T(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f17946f = a.a.T(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(AppCompatTextView appCompatTextView, int i2) {
        if (this.f17947i == null && this.k == null) {
            Context context = this.g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f17947i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f17947i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.k = new FrameLayout(context);
            this.f17947i.addView(this.k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.k.setVisibility(0);
            this.k.addView(appCompatTextView);
        } else {
            this.f17947i.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f17947i.setVisibility(0);
        this.j++;
    }

    public final void b() {
        if (this.f17947i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.g;
                boolean zD = t1.c.d(context);
                LinearLayout linearLayout = this.f17947i;
                int paddingStart = editText.getPaddingStart();
                if (zD) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zD) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zD) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z2, AppCompatTextView appCompatTextView, int i2, int i8, int i9) {
        if (appCompatTextView == null || !z2) {
            return;
        }
        if (i2 == i9 || i2 == i8) {
            boolean z7 = i9 == i2;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, z7 ? 1.0f : 0.0f);
            int i10 = this.f17944c;
            objectAnimatorOfFloat.setDuration(z7 ? this.f17943b : i10);
            objectAnimatorOfFloat.setInterpolator(z7 ? this.e : this.f17946f);
            if (i2 == i9 && i8 != 0) {
                objectAnimatorOfFloat.setStartDelay(i10);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i9 != i2 || i8 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f17942a);
            objectAnimatorOfFloat2.setInterpolator(this.f17945d);
            objectAnimatorOfFloat2.setStartDelay(i10);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i2) {
        if (i2 == 1) {
            return this.f17951r;
        }
        if (i2 != 2) {
            return null;
        }
        return this.y;
    }

    public final void f() {
        this.p = null;
        c();
        if (this.f17948n == 1) {
            if (!this.f17957x || TextUtils.isEmpty(this.f17956w)) {
                this.f17949o = 0;
            } else {
                this.f17949o = 2;
            }
        }
        i(this.f17948n, this.f17949o, h(this.f17951r, ""));
    }

    public final void g(AppCompatTextView appCompatTextView, int i2) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f17947i;
        if (linearLayout == null) {
            return;
        }
        if ((i2 == 0 || i2 == 1) && (frameLayout = this.k) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i8 = this.j - 1;
        this.j = i8;
        LinearLayout linearLayout2 = this.f17947i;
        if (i8 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.f17949o == this.f17948n && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i2, int i8, boolean z2) {
        TextView textViewE;
        TextView textViewE2;
        r rVar = this;
        if (i2 == i8) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            rVar.l = animatorSet;
            ArrayList arrayList = new ArrayList();
            rVar.d(arrayList, rVar.f17957x, rVar.y, 2, i2, i8);
            rVar.d(arrayList, rVar.f17950q, rVar.f17951r, 1, i2, i8);
            int size = arrayList.size();
            long jMax = 0;
            for (int i9 = 0; i9 < size; i9++) {
                Animator animator = (Animator) arrayList.get(i9);
                jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            valueAnimatorOfInt.setDuration(jMax);
            arrayList.add(0, valueAnimatorOfInt);
            animatorSet.playTogether(arrayList);
            p pVar = new p(this, i8, e(i2), i2, rVar.e(i8));
            rVar = this;
            animatorSet.addListener(pVar);
            animatorSet.start();
        } else if (i2 != i8) {
            if (i8 != 0 && (textViewE2 = rVar.e(i8)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i2 != 0 && (textViewE = e(i2)) != null) {
                textViewE.setVisibility(4);
                if (i2 == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            rVar.f17948n = i8;
        }
        TextInputLayout textInputLayout = rVar.h;
        textInputLayout.t();
        textInputLayout.w(z2, false);
        textInputLayout.z();
    }
}
