package z1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewCompat;
import com.cbt.exam.browser.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class w extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f17969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f17970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f17971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f17972d;
    public ColorStateList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f17973f;
    public int g;
    public ImageView.ScaleType h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View.OnLongClickListener f17974i;
    public boolean j;

    public w(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f17969a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f17972d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f17970b = appCompatTextView;
        if (t1.c.d(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f17974i;
        checkableImageButton.setOnClickListener(null);
        r2.q.t0(checkableImageButton, onLongClickListener);
        this.f17974i = null;
        checkableImageButton.setOnLongClickListener(null);
        r2.q.t0(checkableImageButton, null);
        if (tintTypedArray.hasValue(70)) {
            this.e = t1.c.b(getContext(), tintTypedArray, 70);
        }
        if (tintTypedArray.hasValue(71)) {
            this.f17973f = q1.p.a(tintTypedArray.getInt(71, -1), null);
        }
        if (tintTypedArray.hasValue(67)) {
            b(tintTypedArray.getDrawable(67));
            if (tintTypedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = tintTypedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(tintTypedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = tintTypedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.g) {
            this.g = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (tintTypedArray.hasValue(69)) {
            ImageView.ScaleType scaleTypeK = r2.q.K(tintTypedArray.getInt(69, -1));
            this.h = scaleTypeK;
            checkableImageButton.setScaleType(scaleTypeK);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        appCompatTextView.setAccessibilityLiveRegion(1);
        TextViewCompat.setTextAppearance(appCompatTextView, tintTypedArray.getResourceId(61, 0));
        if (tintTypedArray.hasValue(62)) {
            appCompatTextView.setTextColor(tintTypedArray.getColorStateList(62));
        }
        CharSequence text2 = tintTypedArray.getText(60);
        this.f17971c = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        e();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.f17972d;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        return this.f17970b.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f17972d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.e;
            PorterDuff.Mode mode = this.f17973f;
            TextInputLayout textInputLayout = this.f17969a;
            r2.q.j(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            r2.q.n0(textInputLayout, checkableImageButton, this.e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f17974i;
        checkableImageButton.setOnClickListener(null);
        r2.q.t0(checkableImageButton, onLongClickListener);
        this.f17974i = null;
        checkableImageButton.setOnLongClickListener(null);
        r2.q.t0(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z2) {
        CheckableImageButton checkableImageButton = this.f17972d;
        if ((checkableImageButton.getVisibility() == 0) != z2) {
            checkableImageButton.setVisibility(z2 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f17969a.e;
        if (editText == null) {
            return;
        }
        this.f17970b.setPaddingRelative(this.f17972d.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i2 = (this.f17971c == null || this.j) ? 8 : 0;
        setVisibility((this.f17972d.getVisibility() == 0 || i2 == 0) ? 0 : 8);
        this.f17970b.setVisibility(i2);
        this.f17969a.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        d();
    }
}
